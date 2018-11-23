package org.konate.tp_concurrence_maven.serie2.exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomServer {

	private static ServerSocket server;

	public static void main(String[] args) throws IOException {

		server = new ServerSocket(8080);

		int processors = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(processors);
		ConcurrentHashMap<String, Integer> orders = new ConcurrentHashMap<>();

		while (true) {
			System.out.println("Listening to request");
			Socket socket = server.accept();
			System.out.println("Accepting request");

			Callable<?> response = () -> {
				InputStream inputStream = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String[] items = null;
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
				String order = null;
				try {
					order = reader.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				while (order != null) {
					if (order.startsWith("GET")) {
						writer.printf("Received GET order : %s\n", order);
						writer.flush();
						System.out.printf("Received GET order : %s\n", order);
					} else if (order.equals("bye")) {
						System.out.printf("Closing connection\n");
						socket.close();
					} else if (order.startsWith("PUT")) {
						writer.printf("Received PUT order : %s\n", order);
						writer.flush();
						System.out.printf("Received PUT order : %s\n", order);
						orders.put(order.split(" ")[1], Integer.parseInt(order.split(" ")[2]));
					} else if (order.startsWith("LIST")) {
						writer.printf("Received PUT order : %s\n", order);
						writer.flush();
						orders.forEach((k, v) -> writer.printf("Item Name : %s, Price : %d", k, v));
						//writer.flush();
					}
					order = reader.readLine();
				}
				return items;
			};

			service.submit(response);
			service.shutdown();
		}
	}
}