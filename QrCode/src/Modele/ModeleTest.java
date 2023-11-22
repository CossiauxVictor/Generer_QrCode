// Déclaration du package dans lequel se trouve la classe
package Modele;

// Importation des classes nécessaires pour les tests unitaires
import org.junit.Test;
import static org.junit.Assert.*;

// Définition de la classe de test pour la classe Modele
public class ModeleTest {

    // Méthode de test pour la fonction getQrCodeByteArray de la classe Modele
    @Test
    public void testGetQrCodeByteArray() {
        
        // Données de test
        String testData = "Données de test";
        String testcouleur = "green";
        Integer testtaille = 60;
        String testpolice = "Arial";
        
        // Initialisation d'une instance de la classe Modele à tester
        Modele modele = null;
        try {
            modele = new Modele(testData , testcouleur, testtaille, testpolice);
        } catch (Exception e) {
            // Échec du test si une exception est levée lors de l'initialisation
            fail("Exception levée lors de l'initialisation : " + e.getMessage());
        }

        // Appel de la méthode à tester pour obtenir le tableau d'octets du code QR
        byte[] qrCodeByteArray = modele.getQrCodeByteArray();
        
        // Vérification que le tableau d'octets n'est pas nul
        assertNotNull(qrCodeByteArray);
        
        // Vérification que le tableau d'octets a une longueur supérieure à zéro
        assertTrue(qrCodeByteArray.length > 0);
    }    
}
