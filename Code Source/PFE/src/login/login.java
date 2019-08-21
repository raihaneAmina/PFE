package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;




import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.DropMode;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.util.jar.Attributes.Name;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;

import javax.swing.UIManager;

@SuppressWarnings({ "serial", "unused" })
public class login extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField;
	private JSeparator separator_5;
	public String s;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
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
					login frame = new login();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public login() {
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int ret = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter l’application");
				if (ret == 0) {         
					//System.exit(0);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
					}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(w/4, h/7, 750, 528);
		setTitle("Systeme Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
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
		separator_2.setBounds(47, 444, 280, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(80, 469, 206, 2);
		panel.add(separator_3);
		
		JLabel label = new JLabel("");
		label.setBounds(47, 156, 280, 277);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		//ImageIcon imgl = new ImageIcon(login.class.getResource("/img/logob.png"));
		ImageIcon img = new ImageIcon(login.class.getResource("/img/timetable.png"));
		label.setIcon(img);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, -10, 90, 104);
		panel.add(lblNewLabel_2);
		ImageIcon imgl = new ImageIcon(login.class.getResource("/img/logob.png"));
		lblNewLabel_2.setIcon(imgl);
		JLabel lblNewLabel_1 = new JLabel("Nom de l'utilisateur");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(419, 99, 163, 14);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(419, 195, 163, 14);
		contentPane.add(lblMotDePasse);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					passwordField.requestFocus();
					
				}
				
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
				
				if (  txtUser.getText().trim().equals("") ||
						txtUser.getText().trim().toLowerCase().equals("Entrer votre nom d'utilisateur") )
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
		txtUser.setBounds(419, 123, 285, 39);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtUser.requestFocus();
					
				}
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					
					connexion();
					
				}					
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				
				if (passwordField.getText().trim().equals("") ||
						passwordField.getText().trim().toLowerCase().equals("**********"))
					{		
					
					passwordField.setText(null);
					}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				
				if (passwordField.getText().trim().equals("") ||
						passwordField.getText().trim().toLowerCase().equals("**********"))
					{
						
					passwordField.setText("**********");
						
					}
				
			}
		});
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setEchoChar('*');
		passwordField.setText("**********");
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField.setToolTipText("");
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBackground(new Color(36,47,65));
		passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBounds(419, 219, 285, 39);
		contentPane.add(passwordField);
		
		JCheckBox chckbxAfficherLeMot = new JCheckBox("Afficher le mot de passe");
		chckbxAfficherLeMot.setForeground(Color.WHITE);
		chckbxAfficherLeMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAfficherLeMot.isSelected()) {
					
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
				
			}
		});
		chckbxAfficherLeMot.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		chckbxAfficherLeMot.setBackground(new Color(36,47,65));
		chckbxAfficherLeMot.setBounds(417, 338, 300, 50);
		contentPane.add(chckbxAfficherLeMot);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(419, 172, 285, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(419, 266, 285, 2);
		contentPane.add(separator_1);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
					
				btnConnexion.setBackground(new Color(140, 160, 192)/**new Color(246, 164, 34)*/);
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnConnexion.setBackground(new Color(97,212,195));
				}
			});
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				connexion();
				
				}
					
		});
		btnConnexion.setBackground(new Color(97,212,195));
		btnConnexion.setBounds(410, 410, 122, 48);
		btnConnexion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		contentPane.add(btnConnexion);
		
		JLabel lblConnectezvous = new JLabel("Connectez-vous");
		lblConnectezvous.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectezvous.setForeground(Color.WHITE);
		lblConnectezvous.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConnectezvous.setBounds(380, 28, 370, 39);
		contentPane.add(lblConnectezvous);
		
		JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & ALLALI Yasmine & RAIEB Rekia");
		lblSehalAminaRihane.setBounds(373, 489, 367, 28);
		contentPane.add(lblSehalAminaRihane);
		lblSehalAminaRihane.setForeground(Color.WHITE);
		lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
		
		JLabel lblModifierLeMot = new JLabel("Modifier le mot de passe");
		lblModifierLeMot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				modf m = new modf();
				m.setVisible(true);
				setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblModifierLeMot.setForeground(new Color(140, 160, 192));
				separator_5.setBackground(new Color(140, 160, 192));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblModifierLeMot.setForeground(Color.WHITE);
				separator_5.setBackground(Color.WHITE);
			}
		});
		lblModifierLeMot.setHorizontalAlignment(SwingConstants.LEFT);
		lblModifierLeMot.setForeground(Color.WHITE);
		lblModifierLeMot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModifierLeMot.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblModifierLeMot.setBounds(542, 399, 186, 50);
		contentPane.add(lblModifierLeMot);
		
				
			
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(558, 437, 145, -3);
		contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(542, 437, 153, 2);
		contentPane.add(separator_5);
		
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
		label_1.setBounds(674, 11, 29, 20);
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
		lblX.setBounds(705, 11, 29, 20);
		contentPane.add(lblX);
		
		comboBox = new JComboBox();
		comboBox.setFocusTraversalPolicyProvider(true);
		comboBox.setFocusCycleRoot(true);
		comboBox.setBorder(null);
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(36,47,65));
		comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Enseignant", "D\u00E9ligu\u00E9"}));
		comboBox.setBounds(559, 296, 145, 35);
		contentPane.add(comboBox);
		
		JLabel lblType = new JLabel("Type d'utilisateur");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblType.setBounds(419, 296, 145, 35);
		contentPane.add(lblType);
	}

   public String NomUtil(){
    	return txtUser.getText();
    }
    
    
    @SuppressWarnings("deprecation")
	public void connexion() {
    	
    	if (txtUser.getText().equals("Entrer votre nom d'utilisateur")  || passwordField.getText().equals("**********")||txtUser.getText().equals("")  || passwordField.getText().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Information Oublier", "Erreur Connexion",JOptionPane.ERROR_MESSAGE);	
			
		
			
		
	}else{ 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String user=txtUser.getText().toString() ;
			String pass= passwordField.getText().toString();
			String type= String.valueOf(comboBox.getSelectedItem());
			String sql = "SELECT * FROM compt WHERE NomUtil='" + user+"' and MotDePasse='" +pass+"' and Type='" + type+"'"; 
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false", "root", "");
			pst=con.prepareStatement(sql);
			rs= pst.executeQuery();
			//JOptionPane.showMessageDialog(null, Nom());
			
			if(rs.next()){
				
				//JOptionPane.showMessageDialog(null, "Username and Password Matched and you are "+comboBox.getSelectedItem()); 
				
				if(comboBox.getSelectedIndex()==0) {
					app a = new app();
					a.setVisible(true);
					this.setVisible(false);
				}
				if(comboBox.getSelectedIndex()==1) {
					appE a = new appE();
					a.setVisible(true);
					s = NomUtil();
					a.bjr.setText(s);
				    //JOptionPane.showMessageDialog(null,s);
					this.setVisible(false);
				}
				if(comboBox.getSelectedIndex()==2) {
					appd a = new appd();
					a.setVisible(true);
					this.setVisible(false);
				}
			}
			else {
			      JOptionPane.showMessageDialog(null, "Informations de connexion invalide", "Erreur Connexion",JOptionPane.ERROR_MESSAGE); 
		          textField.setText(null); 
		          passwordField.setText(null); 
		}
		       //con.close(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(this,e.getMessage());
		}
		 
		
		

	

} }	
}