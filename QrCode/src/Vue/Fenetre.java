package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class Fenetre extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton;
	private Object selectedOption;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JLabel lblContenueDuQrcode;
	private JComboBox Police;

    /**
     * Méthode principale pour lancer l'application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Crée une instance de la classe Fenetre et l'affiche.
                    Fenetre frame = new Fenetre();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructeur de la classe Fenetre.
     */
    public Fenetre() {
        // Configuration de la fenêtre.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // Configuration du contenu de la fenêtre.
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Création d'un bouton.
        btnNewButton = new JButton("New button");
        btnNewButton.setBounds(10, 194, 416, 59);
        contentPane.add(btnNewButton);

        // Création d'un champ de texte.
        textField = new JTextField();
        textField.setBounds(10, 32, 416, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Couleur du texte :");
        lblNewLabel.setBounds(20, 62, 88, 20);
        contentPane.add(lblNewLabel);
        
        comboBox = new JComboBox();
        comboBox.setBounds(163, 62, 79, 21);
        contentPane.add(comboBox);
        comboBox.addItem("black");
        comboBox.addItem("blue");
        comboBox.addItem("red");
        comboBox.addItem("green");
        comboBox.addItem("orange");
        comboBox.addItem("pink");
        comboBox.addItem("yellow");
        comboBox.addItem("purple");
        comboBox.addItem("brown");
        
        JLabel lblTailleDuTexte = new JLabel("Taille du texte :");
        lblTailleDuTexte.setBounds(20, 88, 88, 20);
        contentPane.add(lblTailleDuTexte);
        
        spinner = new JSpinner();
        spinner.setBounds(163, 89, 79, 20);
        contentPane.add(spinner);
        
        lblContenueDuQrcode = new JLabel("Contenue du QrCode :");
        lblContenueDuQrcode.setBounds(10, 10, 416, 20);
        contentPane.add(lblContenueDuQrcode);
        
        JLabel lblPoliceDcriture = new JLabel("Police d'écriture :");
        lblPoliceDcriture.setBounds(20, 115, 88, 20);
        contentPane.add(lblPoliceDcriture);
        
        Police = new JComboBox();
        Police.setBounds(163, 115, 79, 21);
        contentPane.add(Police);
        Police.addItem("Arial");
        Police.addItem("Calibri");
        
        

        // Rend la fenêtre visible.
        this.setVisible(true);
    }

    /**
     * Méthode permettant d'ajouter un écouteur d'événements au bouton.
     */
    public void clicBouton(ActionListener actionListener) {
        this.btnNewButton.addActionListener(actionListener);
    }

    public String getText() {
        return this.textField.getText();
        
    }
    
    public String getColor() {
    	return (String) this.comboBox.getSelectedItem();
    }
    
    public int getspinner() {
    	return (Integer) this.spinner.getValue();
    }
    
    public String getPolice() {
    	return (String) this.Police.getSelectedItem();
    }
}
