# Réponse aux questions des TPs de concurrence

## Exercice 0 :
### Question 1 : Le nom est **Thread-0**
### Question 2 : Cet unique Thread est **main**

## Exercice 1 :
### Question 3 : la valeur finale doit être **1000**, On observe des valeurs aléatoires à chaque éxecution du programme ce qui est dû au faite que les 10 threads ne sont pas synchronnent entre eux. 
### Question 4 : On peut les synchroniser, en mettent un verrou(bloc synchronised) sur le compteur

## Exercice 2 :
### Question 5 : On va se mettre en attente **wait** tantque qu'il n'y a pas de place libre dans l'etrepôt avant de d'ajouter une marchandise, on ne va également enlever qu'une fois qu'il y a eu stockage d'une marchandise dans l'entrepôt
### Question 7 : Le résultat n'est pas 5 car on n'a pas laissé le temps à toutes les tâches de se terminer, un ajoutant un **Sleep** de 10 secondes, on  obtient bien 5 comme résultat.
