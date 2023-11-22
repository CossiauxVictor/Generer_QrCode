package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.google.zxing.WriterException;

import Modele.Modele;
import Vue.Fenetre;

public class Controleur {
	
	
    // Déclaration d'une instance de la classe Fenetre
    private Fenetre fenetre;
    
    
    // Constructeur de la classe Controleur
    public Controleur() {
        // Initialisation de l'instance de la classe Fenetre
        this.fenetre = new Fenetre();
        
        // Ajout d'un écouteur d'événements au bouton de la fenêtre
        this.fenetre.clicBouton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affichage du texte saisi dans la fenêtre dans la console
                System.out.println("Texte entrée : " + fenetre.getText());
                System.out.println("Couleur entrée : " + fenetre.getColor());
                System.out.println("Taille entrée : " + fenetre.getspinner());
                System.out.println("Police d'écriture : " + fenetre.getPolice());
                
                

                // Création d'une instance de la classe Modele avec les données
                try {
                    Modele modeleControleur = new Modele(fenetre.getText(), fenetre.getColor(), fenetre.getspinner(), fenetre.getPolice());
                    // Appel de la méthode "modele" de l'objet Modele
                    modeleControleur.modele(fenetre.getText(), fenetre.getColor(), fenetre.getspinner(), fenetre.getPolice());
                } catch (WriterException | IOException ex) {
                    // Gestion des exceptions WriterException et IOException
                    ex.printStackTrace();
                }
            }
        });
    }

    // Méthode principale (main) du programme
    public static void main(String[] args) {
        // Création d'une instance de la classe Controleur, ce qui déclenche l'exécution du programme
        new Controleur();
    }
}
