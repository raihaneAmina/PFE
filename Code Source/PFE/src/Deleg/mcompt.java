package Deleg;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.appd;
import login.login;


@SuppressWarnings("serial")
public class mcompt extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JTextField txtNiv;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private Connection con2 = null; 		
	private java.sql.PreparedStatement pst2 = null;		
	private ResultSet rs2 = null;
	private JTextField txtNomPrn;
	private JTextField txtSp;
	private JTextField txtFil;
	private JTextField txtUtil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mcompt frame = new mcompt();
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
	public mcompt() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-650)/2, (h-500)/2, 650, 500);
		setTitle("Mon Compte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97,212,195));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36,47,65));
		panel.setBounds(0, 38, 197, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appd b = new appd();
				b.setVisible(true);
				setVisible(false);
			}
		});
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(0, 0, 71, 63);
		panel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img3 = new ImageIcon(login.class.getResource("/img/back.png"));
		label_3.setIcon(img3);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_3.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_3.setBackground(new Color(27, 36, 49));
			}
			
            public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(27, 36, 49));
		panel_3.setBounds(0, 122, 197, 47);
		panel.add(panel_3);
		
		JLabel lblGestionDesComptes = new JLabel("Mon Compte");
		lblGestionDesComptes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_3.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_3.setBackground(new Color(36, 48, 66));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mcompt m = new mcompt();
				m.setVisible(true);
				setVisible(false);
			}
		});
		lblGestionDesComptes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestionDesComptes.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestionDesComptes.setForeground(Color.WHITE);
		lblGestionDesComptes.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblGestionDesComptes.setBounds(10, 11, 153, 25);
		panel_3.add(lblGestionDesComptes);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_4.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_4.setBackground(new Color(36, 48, 66));
			}
			
            public void mouseClicked(MouseEvent arg0) {
            	clasm m = new clasm();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 70);
		panel_4.setBackground(new Color(36,47,65));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblListeDesEnseignant = new JLabel("Ordre de passage");
		lblListeDesEnseignant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_4.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_4.setBackground(new Color(36, 48, 66));
			}
			
            public void mouseClicked(MouseEvent arg0) {
            	clasm m = new clasm();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		lblListeDesEnseignant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListeDesEnseignant.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesEnseignant.setForeground(Color.WHITE);
		lblListeDesEnseignant.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesEnseignant.setBounds(10, 11, 177, 25);
		panel_4.add(lblListeDesEnseignant);
		
		JLabel lblDesExamens = new JLabel("des examens ");
		lblDesExamens.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesExamens.setForeground(Color.WHITE);
		lblDesExamens.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblDesExamens.setBounds(10, 34, 177, 25);
		panel_4.add(lblDesExamens);
		
		JLabel lblKeeptoo = new JLabel("GETE");
		lblKeeptoo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeeptoo.setBounds(0, 25, 197, 37);
		lblKeeptoo.setForeground(new Color(255, 255, 255));
		lblKeeptoo.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		panel.add(lblKeeptoo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 73, 100, 11);
		panel.add(separator);
		
		JLabel lblNomPren = new JLabel("Nom et Pr\u00E9nom   :");
		lblNomPren.setForeground(Color.BLACK);
		lblNomPren.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNomPren.setBounds(230, 148, 141, 14);
		contentPane.add(lblNomPren);
		
		JLabel lblsps = new JLabel("Sp\u00E9cialit\u00E9            :");
		lblsps.setForeground(Color.BLACK);
		lblsps.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblsps.setBounds(230, 208, 141, 14);
		contentPane.add(lblsps);
		
		JLabel lblAge = new JLabel("Niveau               :");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAge.setBounds(230, 268, 137, 30);
		contentPane.add(lblAge);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(387, 170, 215, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(387, 230, 215, 14);
		contentPane.add(separator_2);
		
		txtNiv = new JTextField();
		txtNiv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtFil.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtSp.requestFocus();
					
				}
				
			}
		});
		txtNiv.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtNiv.getText().equals("") ||
						txtNiv.getText().equals("Niveau"))
					{
					txtNiv.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtNiv.getText().trim().equals("") ||
						txtNiv.getText().trim().toLowerCase().equals("Niveau ") )
				{
					
					txtNiv.setText("Niveau");
					
				}
				
			}
		});
		txtNiv.setToolTipText("");
		txtNiv.setText("Niveau ");
		txtNiv.setForeground(Color.DARK_GRAY);
		txtNiv.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtNiv.setColumns(10);
		txtNiv.setCaretColor(Color.WHITE);
		txtNiv.setBorder(null);
		txtNiv.setBackground(new Color(97, 212, 195));
		txtNiv.setBounds(387, 268, 205, 20);
		contentPane.add(txtNiv);
		ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(387, 290, 215, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(387, 350, 215, 2);
		contentPane.add(separator_4);
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/supp.png"));
	//	UpdateTable();
		
		txtNomPrn = new JTextField();
		txtNomPrn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtSp.requestFocus();
					
				}

				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtUtil.requestFocus();
					
				}
				
			}
		});
		txtNomPrn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtNomPrn.getText().equals("") ||
						txtNomPrn.getText().equals("Nom et Prénom"))
					{
					txtNomPrn.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtNomPrn.getText().trim().equals("") ||
						txtNomPrn.getText().trim().toLowerCase().equals("Nom et Prénom") )
				{
					
					txtNomPrn.setText("Nom et Prénom");
					
				}
				
			}
		});
		txtNomPrn.setToolTipText("");
		txtNomPrn.setText("Nom et Prénom");
		txtNomPrn.setForeground(Color.DARK_GRAY);
		txtNomPrn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtNomPrn.setColumns(10);
		txtNomPrn.setCaretColor(Color.WHITE);
		txtNomPrn.setBorder(null);
		txtNomPrn.setBackground(new Color(97, 212, 195));
		txtNomPrn.setBounds(387, 148, 207, 20);
		contentPane.add(txtNomPrn);
		
		txtSp = new JTextField();
		txtSp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtNiv.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtNomPrn.requestFocus();
					
				}
				
			}
		});
		txtSp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtSp.getText().equals("") ||
						txtSp.getText().equals("Spécialité"))
					{
					txtSp.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtSp.getText().trim().equals("") ||
						txtSp.getText().trim().toLowerCase().equals("Spécialité") )
				{
					
					txtSp.setText("Spécialité");
					
				}
				
			}
		});
		txtSp.setToolTipText("");
		txtSp.setText("Spécialité");
		txtSp.setForeground(Color.DARK_GRAY);
		txtSp.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtSp.setColumns(10);
		txtSp.setCaretColor(Color.WHITE);
		txtSp.setBorder(null);
		txtSp.setBackground(new Color(97, 212, 195));
		txtSp.setBounds(387, 208, 205, 20);
		contentPane.add(txtSp);
		
		txtFil = new JTextField();
		txtFil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtNiv.requestFocus();
					
				}
                if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					
					
				}
				
			}
		});
		txtFil.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtFil.getText().equals("") ||
						txtFil.getText().equals("Filière"))
					{
					txtFil.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtFil.getText().trim().equals("") ||
						txtFil.getText().trim().toLowerCase().equals("Filière") )
				{
					
					txtFil.setText("Filière");
					
				}
				
			}
		});
		txtFil.setToolTipText("");
		txtFil.setText("Filière ");
		txtFil.setForeground(Color.DARK_GRAY);
		txtFil.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtFil.setColumns(10);
		txtFil.setCaretColor(Color.WHITE);
		txtFil.setBorder(null);
		txtFil.setBackground(new Color(97, 212, 195));
		txtFil.setBounds(387, 328, 209, 20);
		contentPane.add(txtFil);
		
//		Remplir();
		
		JLabel label_11 = new JLabel("\u0640\u0640\u0640");
		label_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(new Color(36,47,65));
		label_11.setFont(new Font("Arial", Font.BOLD, 18));
		label_11.setBounds(591, 0, 29, 38);
		contentPane.add(label_11);
		
		JLabel lblX = new JLabel("x");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(36,47,65));
		lblX.setFont(new Font("Arial", Font.BOLD, 18));
		lblX.setBounds(621, 0, 29, 38);
		contentPane.add(lblX);
		
		JLabel lblAnciennet = new JLabel("Fili\u00E8re                :");
		lblAnciennet.setForeground(Color.BLACK);
		lblAnciennet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAnciennet.setBounds(230, 328, 141, 14);
		contentPane.add(lblAnciennet);
		
		txtUtil = new JTextField();
		txtUtil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtNomPrn.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					
				}
			}
		});
		txtUtil.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtUtil.getText().equals("") ||
						txtUtil.getText().equals("Nom d'utulisateur"))
					{
					txtUtil.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtUtil.getText().trim().equals("") ||
						txtUtil.getText().trim().toLowerCase().equals("Nom d'utulisateur") )
				{
					
					txtUtil.setText("Nom d'utulisateur");
					
				}
				
			}
		});
		txtUtil.setToolTipText("");
		txtUtil.setText("Nom d'utulisateur");
		txtUtil.setForeground(Color.DARK_GRAY);
		txtUtil.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtUtil.setColumns(10);
		txtUtil.setCaretColor(Color.WHITE);
		txtUtil.setBorder(null);
		txtUtil.setBackground(new Color(97, 212, 195));
		txtUtil.setBounds(387, 88, 203, 20);
		contentPane.add(txtUtil);
		
		JLabel lblUtil = new JLabel("Nom d'utulisateur:");
		lblUtil.setForeground(Color.BLACK);
		lblUtil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblUtil.setBounds(230, 88, 151, 14);
		contentPane.add(lblUtil);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(387, 110, 215, 2);
		contentPane.add(separator_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 650, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(5, -1, 33, 37);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img33 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img33);
		
		JLabel lblGesionDesEnseignats = new JLabel("Mon Compte");
		lblGesionDesEnseignats.setBounds(61, 0, 589, 38);
		panel_2.add(lblGesionDesEnseignats);
		lblGesionDesEnseignats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGesionDesEnseignats.setForeground(Color.BLACK);
		lblGesionDesEnseignats.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		remp();
	}
	public void remp() {
		String sql = "SELECT * FROM `filiè`,`compt`,`délégué` WHERE `délégué`.`ID` = 37 and Nomfil = 'Informatique '"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String Util= rs.getString("NomUti").toString();
				String NomPrn= rs.getString("NomPren").toString();
				String Sp= rs.getString("spécialité").toString();
				String Niv= rs.getString("niveau").toString();
				String Fil= rs.getString("Nomfil").toString();
				txtUtil.setText(Util);
				txtNomPrn.setText(NomPrn);
				txtSp.setText(Sp);
				txtNiv.setText(Niv);
				txtFil.setText(Fil);
				
				//String type= rs.getString("Type").toString();
				//comboBox.addItem(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
