package core;

import java.util.Scanner;

public class Master {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Zone de test
    // Utm utm1 = new Utm(); ?????

    // Initialisation des joueurs
    System.out.println("Joueur 1");
    Player player1 = new Player();
    System.out.println("Le joueur 1 représente la filière " + player1.getFiliere());

    // System.out.println("Passage au joueur 2");
    // Player player2 = new Player();
    // System.out.println("Le joueur 2 représente la filière " +
    // player2.getFiliere());

    // Répartition des points
    System.out.println("Réparition des points pour le joueur 1");
    player1.repartitionPoint();

    // System.out.println("Réparition des points pour le joueur 2");
    // player2.repartitionPoint();

    // Démarrage des zones

    player1.startMap();
    // player2.startMap();

    // Démarrage du combat
    // Trouver l'étudiant avec le plus d'initiative
    player1.beforeStartInfo();
    // player2.beforeStartInfo();
  }
}