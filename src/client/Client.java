package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            String operation = "";
            String x;
            String y;

                // création d'une connexion au serveur en spécifiant son adresse IP et son port
                Socket comm = new Socket("100.104.161.70", 7010);
                // création d'un DataOutputStream pour envoyer des données au serveur
                DataOutputStream sortieVersServeur = new DataOutputStream(comm.getOutputStream());
                // création d'un BufferedReader pour lire les données reçues du serveur
                BufferedReader entreeDepuisServeur = new BufferedReader(new InputStreamReader(comm.getInputStream()));
                // utilisation de Scanner pour lire les données à envoyer au serveur
                Scanner scanner = new Scanner(System.in);
                while (!operation.matches("[+\\-*/]")) {
                    System.out.print("Entrez une opération mathématique (+, -, *, /) : ");
                    operation = scanner.nextLine();
                }
                System.out.println("Veuillez saisir x");
                x = scanner.nextLine();
                System.out.println("Veuillez saisir y");
                y = scanner.nextLine();
                //System.out.println("Entrez une phrase à envoyer au serveur : ");
                //String phrase = scanner.nextLine();
                //if (phrase.equalsIgnoreCase("exit")) {
                  //  System.exit(0);
                //} else {
                    // envoi des données au serveur
                    sortieVersServeur.writeBytes(operation + '\n');
                    sortieVersServeur.writeBytes(x + '\n');
                    sortieVersServeur.writeBytes(y + '\n');
                    //sortieVersServeur.writeBytes(phrase + '\n');
                    String resultat = entreeDepuisServeur.readLine();
                    // lecture de la réponse du serveur
                    //String reponse = entreeDepuisServeur.readLine();
                    // affichage de la réponse
                    //System.out.println("Réponse du serveur : " + reponse);
                    System.out.println("Le resultat de l'operation est  : " + resultat);

                    // fermeture des flux de données et de la connexion
                    sortieVersServeur.close();
                    entreeDepuisServeur.close();
                    comm.close();
                    //System.out.println("pour sortir taper exit");
                //}


        } catch (IOException e) {
            System.out.println("Erreur de connexion : " + e);
        }
    }

}