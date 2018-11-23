package org.konate.tp_concurrence_maven.serie2.exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!"bye".equals(command)) {

            System.out.println("Sending command = " + command);
            writer.println(command);
            writer.flush();

            String answer = reader.readLine();
            System.out.println("Got answer = " + answer);

            System.out.print("> ");
            command = scanner.nextLine();
        }
        writer.println(command);
        writer.flush();
        scanner.close();
        socket.close();
    }
}
