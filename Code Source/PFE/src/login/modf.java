package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "serial", "unused" })
public class modf extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JTextField txtUser;
	@SuppressWarnings("unused")
	private JTextField textField_1;
	private JPasswordField txtpass;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	Connection con=null;
	java.sql.PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modf frame = new modf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 **/
	public modf() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(w/4, h/7, 750, 528);
		setTitle("Systeme Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logo.png").getFile())); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36,47,65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 528);
		panel.setBackground(new Color(97,212,195));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, -10, 90, 104);
		panel.add(lblNewLabel_2);
		ImageIcon imgl = new ImageIcon(login.class.getResource("/img/logob.png"));
		lblNewLabel_2.setIcon(imgl);
		
		JLabel lblNewLabel = new JLabel("Emplois du temps d'examens");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 82, 378, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		//lblNewLabel.setBounds(0, 41, 667, 40);
		panel.add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(46, 424, 280, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(79, 449, 206, 2);
		panel.add(separator_3);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 136, 280, 277);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon(login.class.getResource("/img//timetable.png"));
		label.setIcon(img);		
		JLabel lblNewLabel_1 = new JLabel("Nom de l'utilisateur");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(428, 92, 285, 14);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
                 if (e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN) {
					
                	 txtpass.requestFocus();
			}
			}
		});
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtUser.getText().equals("") ||
						txtUser.getText().equals("Entrer votre nom d'utilisateur"))
					{
					txtUser.setText(null);			
					
					}
				
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (txtUser.getText().trim().equals("") ||
					txtUser.getText().trim().toLowerCase().equals("Entrer votre nom d'utilisateur"))
				{
					
					txtUser.setText("Entrer votre nom d'utilisateur");
					
				}
				}
		});
		txtUser.setCaretColor(Color.WHITE);
		txtUser.setForeground(Color.LIGHT_GRAY);
		txtUser.setText("Entrer votre nom d'utilisateur");
		txtUser.setToolTipText("");
		txtUser.setBackground(new Color(36,47,65));
		txtUser.setBorder(null);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		
		txtUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtUser.setBounds(428, 118, 285, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {				
			
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					
					txtUser.requestFocus();
					
				}
				
                 if (e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN) {
					
                	 passwordField_1.requestFocus();
			}
			}
		});
		txtpass.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (txtpass.getText().trim().equals("") ||
						txtpass.getText().trim().toLowerCase().equals("**********"))
					{
					txtpass.setText(null);
					}
				
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtpass.getText().trim().equals("") ||
						txtpass.getText().trim().toLowerCase().equals("**********"))
					{
						
					txtpass.setText("**********");
						
					}
				
			}
		});
		txtpass.setCaretColor(Color.WHITE);
		txtpass.setEchoChar('*');
		txtpass.setText("**********");
		txtpass.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtpass.setToolTipText("");
		txtpass.setForeground(Color.LIGHT_GRAY);
		txtpass.setBackground(new Color(36,47,65));
		txtpass.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		txtpass.setColumns(10);
		txtpass.setBorder(null);
		txtpass.setBounds(428, 195, 285, 28);
		contentPane.add(txtpass);
		
		JCheckBox chckbxAfficherLeMot = new JCheckBox("Afficher le mot de passe");
		chckbxAfficherLeMot.setForeground(Color.WHITE);
		chckbxAfficherLeMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAfficherLeMot.isSelected()) {
					
					txtpass.setEchoChar((char)0);
					passwordField_1.setEchoChar((char)0);
					passwordField_2.setEchoChar((char)0);
					
				}else {
					txtpass.setEchoChar('*');
					passwordField_1.setEchoChar('*');
					passwordField_2.setEchoChar('*');
				}
				
			}
		});
		chckbxAfficherLeMot.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		chckbxAfficherLeMot.setBackground(new Color(36,47,65));
		chckbxAfficherLeMot.setBounds(428, 398, 185, 28);
		contentPane.add(chckbxAfficherLeMot);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(428, 157, 285, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(428, 234, 285, 2);
		contentPane.add(separator_1);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btnConnexion.setBackground(new Color(140, 160, 192));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConnexion.setBackground(new Color(97,212,195));
			}
		});
		btnConnexion.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
					
					if (txtUser.getText().equals("")  || 
							txtpass.getText().equals("")|| 
							passwordField_1.getText().equals("")|| 
							passwordField_2.getText().equals("") ||
							txtUser.getText().equals("Entrer votre nom d'utilisateur")  || 
							txtpass.getText().equals("**********")|| 
							passwordField_1.getText().equals("**********")|| 
							passwordField_2.getText().equals("**********")) 
				{				
						JOptionPane.showMessageDialog(null, "Information Oublier", "Erreur Connexion",JOptionPane.ERROR_MESSAGE);
				}else{ 
					//connexion();	 		
						
					} 
				}
				
			
		});
		btnConnexion.setBackground(new Color(97,212,195));
		btnConnexion.setBounds(428, 455, 122, 34);
		btnConnexion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		contentPane.add(btnConnexion);
		
		JLabel lblConnectezvous = new JLabel("Changer le mot de passe");
		lblConnectezvous.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectezvous.setForeground(Color.WHITE);
		lblConnectezvous.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConnectezvous.setBounds(377, 31, 373, 39);
		contentPane.add(lblConnectezvous);
		
		JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & ALLALI Yasmine & RAIEB Rekia");
		lblSehalAminaRihane.setBounds(377, 500, 373, 28);
		contentPane.add(lblSehalAminaRihane);
		lblSehalAminaRihane.setForeground(Color.WHITE);
		lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
		
		
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(/*new Color(234, 139, 81)*/ Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(699, 238, 25, 40);
		contentPane.add(label);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(558, 437, 145, -3);
		contentPane.add(separator_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
                 if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					
                	 txtUser.requestFocus();
			}
			}
		});
		textField.setForeground(new Color(36,47,65));
		textField.setDisabledTextColor(new Color(36,47,65));
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField.setBackground(new Color(36,47,65));
		textField.setBorder(null);
		textField.setBounds(388, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0640\u0640\u0640");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				//label_1.setBorder(label_border);
				label_1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				//label_1.setBorder(label_border);
				label_1.setForeground(new Color(97,212,195));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 18));
		label_1.setBounds(680, 11, 29, 20);
		contentPane.add(label_1);
		
		JLabel lblX = new JLabel("x");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				lblX.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblX.setForeground(new Color(97,212,195));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 18));
		lblX.setBounds(711, 11, 29, 20);
		contentPane.add(lblX);
	
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau Mot de passe");
		lblNouveauMotDe.setForeground(Color.WHITE);
		lblNouveauMotDe.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNouveauMotDe.setBounds(428, 247, 285, 14);
		contentPane.add(lblNouveauMotDe);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("");
		passwordField_1.setText("**********");
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					
					txtpass.requestFocus();
					
				}
				
                 if (e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN) {
					
                	 passwordField_2.requestFocus();
			}
			}
		});
		passwordField_1.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField_1.getText().trim().equals("") ||
						passwordField_1.getText().trim().toLowerCase().equals("**********"))
					{
					passwordField_1.setText(null);
					}
				passwordField_1.setText(null);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				
				if (passwordField_1.getText().trim().equals("") ||
						passwordField_1.getText().trim().toLowerCase().equals("**********"))
					{
						
					passwordField_1.setText("**********");
						
					}
				
			}
		});
		passwordField_1.setForeground(Color.LIGHT_GRAY);
		passwordField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		passwordField_1.setEchoChar('*');
		passwordField_1.setColumns(10);
		passwordField_1.setCaretColor(Color.WHITE);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(36, 47, 65));
		passwordField_1.setBounds(428, 272, 285, 28);
		contentPane.add(passwordField_1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(428, 311, 285, 2);
		contentPane.add(separator_6);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe actuel");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(428, 170, 285, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConfirmerVotreMot = new JLabel("Confirmer votre Mot de passe");
		lblConfirmerVotreMot.setForeground(Color.WHITE);
		lblConfirmerVotreMot.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblConfirmerVotreMot.setBounds(428, 324, 285, 14);
		contentPane.add(lblConfirmerVotreMot);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setToolTipText("");
		passwordField_2.setText("**********");
		passwordField_2.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					
					passwordField_1.requestFocus();
					
				}
				
                 if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					
                	 if (txtUser.getText().equals("")  || txtpass.getText().equals("")|| passwordField_1.getText().equals("")|| passwordField_2.getText().equals("")) {
 						
 						
 						JOptionPane.showMessageDialog(null, "Information Oublier", "Erreur Connexion",JOptionPane.ERROR_MESSAGE);}
 									
 						if (txtUser.getText().equals("Entrer votre nom d'utilisateur")  || txtpass.getText().equals("**********")|| passwordField_1.getText().equals("**********")|| passwordField_2.getText().equals("**********")) {
 							
 							JOptionPane.showMessageDialog(null, "Information Oublier", "Erreur Connexion",JOptionPane.ERROR_MESSAGE);	
 							
 						
 							
 						
 					}else{ 
 						 
					
 						
 					} 
			}
			}
		});
		passwordField_2.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField_2.getText().trim().equals("") ||
						passwordField_2.getText().trim().toLowerCase().equals("**********"))
					{
					passwordField_2.setText(null);
					}
				passwordField_2.setText(null);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				
				if (passwordField_2.getText().trim().equals("") ||
						passwordField_2.getText().trim().toLowerCase().equals("**********"))
					{
						
					passwordField_2.setText("**********");
						
					}
				
			}
		});
		passwordField_2.setForeground(Color.LIGHT_GRAY);
		passwordField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		passwordField_2.setEchoChar('*');
		passwordField_2.setColumns(10);
		passwordField_2.setCaretColor(Color.WHITE);
		passwordField_2.setBorder(null);
		passwordField_2.setBackground(new Color(36, 47, 65));
		passwordField_2.setBounds(428, 349, 285, 20);
		contentPane.add(passwordField_2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(428, 380, 285, 2);
		contentPane.add(separator_5);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btnAnnuler.setBackground(new Color(140, 160, 192));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAnnuler.setBackground(new Color(97,212,195));
			}
		});
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				login l = new login();
				l.setVisible(true);
				
			}
		});
		btnAnnuler.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnAnnuler.setBackground(new Color(97, 212, 195));
		btnAnnuler.setBounds(591, 455, 122, 34);
		contentPane.add(btnAnnuler);
	}
public void connexion() {
    	
    	if (txtUser.getText().equals("Entrer votre nom d'utilisateur")  || txtpass.getText().equals("**********")||txtUser.getText().equals("")  || txtpass.getText().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Information Oublier", "Erreur Connexion",JOptionPane.ERROR_MESSAGE);	
			
		
			
		
	}else{ 
		 

		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String user=txtUser.getText().toString() ;
			String pass= txtpass.getPassword().toString();
			//String type= String.valueOf(comboBox.getSelectedItem());
			
			String sql = "SELECT * FROM compt WHERE NomUtil='" + user+"' and MotDePasse='" +pass+"'"; 			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root",""); 
			
			pst = con.prepareStatement(sql);
			
				rs = pst.executeQuery(sql);
			
			
			if(rs.next()){
				
					String p1 = passwordField_1.getPassword().toString();
					String p2 = passwordField_2.getPassword().toString();
					if (p1 == p2) {
						
						//String sql2 = "UPDATE `compt` SET `NomUtil`='"+user+"',`MotDePasse`='"+p1+"'";	
						JOptionPane.showMessageDialog(null, "Mot de passe été modifier");
						
					}else {
						JOptionPane.showMessageDialog(null, "Erreur");
					}
			
							        
			}
			
			else {
			      JOptionPane.showMessageDialog(null, "Utilisateur n'existe pas", "Erreur Connexion",JOptionPane.ERROR_MESSAGE); 
		          textField.setText(null); 
		          txtpass.setText(null); 
		}
		       //con.close(); 
		}
		catch(Exception e) {
			       JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
}
}
