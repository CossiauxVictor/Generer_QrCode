package Modele;

import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.aspose.words.*;

import Controleur.Controleur;

public class Modele {
    // Déclaration des variables de classe
    private QRCodeWriter generateurQr;
    private byte[] qrCodeByteArray;
    

    // Constructeur de la classe Modele
    public Modele(String data, String couleur, Integer taille, String police) throws WriterException, IOException {
        // Génère une matrice QR Code à partir des données fournies
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);

        // Convertit la matrice en tableau d'octets (byte array)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", baos);
        qrCodeByteArray = baos.toByteArray();

        // Initialise un document Aspose Words
        Document doc = (Document) null;
        try {
            doc = new Document();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialise un constructeur de document Aspose Words
        DocumentBuilder builder = new DocumentBuilder(doc);
        
        Font font=builder.getFont();

        
        
        try {
        	// Insère l'image QR Code dans le document
            builder.insertImage(qrCodeByteArray);
            builder.write(" ");

        	font.setSize(taille);
        	
        	
        	
        	builder.getFont().setName(police);
        	
			if (couleur.equals("black")) {
				font.setColor(Color.BLACK);
            } else if (couleur.equals("blue")) {
                font.setColor(Color.BLUE);
            } else if (couleur.equals("red")) {
                font.setColor(Color.RED);
            } else if (couleur.equals("green")) {
                font.setColor(Color.GREEN);
            } else if (couleur.equals("orange")) {
                font.setColor(Color.ORANGE);
            } else if (couleur.equals("pink")) {
                font.setColor(Color.PINK);
            } else if (couleur.equals("yellow")) {
                font.setColor(Color.YELLOW);
            } else if (couleur.equals("purple")) {
                font.setColor(new Color(128, 0, 128)); 
            } else if (couleur.equals("brown")) {
                font.setColor(new Color(139, 69, 19)); 
            }
        	
        	
            // Écrit les données dans le document
            builder.write(data);

            

            // Sauvegarde le document au format PDF
            doc.save("./qrcodev4.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode permettant d'obtenir le tableau d'octets du QR Code généré
    public byte[] getQrCodeByteArray() {
        return qrCodeByteArray;
    }

    // Méthode non implémentée, à compléter selon les besoins
    public void modele(String data, String couleur, int taille, String police) {
        // TODO Auto-generated method stub
    }
}
