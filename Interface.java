import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.UIManager;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField txtLargeC;
	String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&/();:";
    String cadenaFinal = "";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(94, 92, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Contraseña aleatoria");
		lblTitle.setFont(new Font("Roboto Medium", Font.BOLD, 27));
		lblTitle.setBounds(165, 12, 287, 68);
		contentPane.add(lblTitle);
		
		JLabel lbQuestion = new JLabel("¿Ingresa la cantidad de caracteres que desee para la contraseña?");
		lbQuestion.setFont(new Font("Dialog", Font.BOLD, 14));
		lbQuestion.setBounds(34, 92, 532, 40);
		contentPane.add(lbQuestion);
		
		txtLargeC = new JTextField();
		txtLargeC.setBounds(44, 128, 114, 29);
		contentPane.add(txtLargeC);
		txtLargeC.setColumns(10);
		txtLargeC.setBorder(null);
		
		JButton btnGenerate = new JButton("Generar Contraseña");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random azar = new Random();
				Integer largoCadena = Integer.parseInt(txtLargeC.getText());
				
				
				
				char[] text = new char[largoCadena];
				
				for(int i=0; i < largoCadena; i++) {
					text[i] = caracteres.charAt(azar.nextInt(caracteres.length()));
				}
				
				for(int i=0; i < text.length; i++) {
					cadenaFinal += text[i];
				}
				
				
				//Resultado
				if (cadenaFinal.length() < 15) {
					JOptionPane.showMessageDialog(null, "Tu contraseña es: "+cadenaFinal +"\n   \n Se recomienda que la contraseña tenga 15 o mas dígitos. \n  \n ¡Contraseña copiada!.", 
							"Contraseña Aleatoria", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/llave.png"));
					copiarContra();
				} else {
					JOptionPane.showMessageDialog(null, "Tu contraseña es: "+cadenaFinal+ "\n   \n ¡Contraseña copiada!.", "Contraseña Aleatoria", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/llave.png"));
					copiarContra();
				}
				
			}
			
			//Copia la contraseña
			 void copiarContra() {
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		        StringSelection strSel = new StringSelection(cadenaFinal);
		        cb.setContents(strSel, null);
		        cadenaFinal = "";
			}
		});
		btnGenerate.setBounds(188, 185, 199, 25);
		contentPane.add(btnGenerate);
		
	}
}
