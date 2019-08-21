package Enseig;

import java.awt.BorderLayout;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Deleg.clasm;
import login.appE;
import login.appd;
import login.login;
import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;

public class Mcompt extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JTextField txtAge;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private Connection con2 = null; 		
	private java.sql.PreparedStatement pst2 = null;		
	private ResultSet rs2 = null;
	private JTextField txtNomPrn;
	private JTextField txtDist;
	private JTextField txtAncien;
	private JTextField txtmalad;
	private JTextField txtUtil;
	private JComboBox nbrT;
	private JLabel lblpri;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mcompt frame = new Mcompt();
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
	public Mcompt() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-630)/2, (h-502)/2, 630, 502);
		setTitle("Mon Compte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97,212,195));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36,47,65));
		panel.setBounds(0, 39, 197, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appE b = new appE();
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
		lblGestionDesComptes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestionDesComptes.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestionDesComptes.setForeground(Color.WHITE);
		lblGestionDesComptes.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblGestionDesComptes.setBounds(10, 11, 177, 25);
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
            	jrs m = new jrs();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 47);
		panel_4.setBackground(new Color(36,47,65));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLclsm = new JLabel("Planning de surveillance");
		lblLclsm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jrs m = new jrs();
				m.setVisible(true);
				setVisible(false);
			}
		});
		lblLclsm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLclsm.setHorizontalAlignment(SwingConstants.LEFT);
		lblLclsm.setForeground(Color.WHITE);
		lblLclsm.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblLclsm.setBounds(10, 11, 177, 25);
		panel_4.add(lblLclsm);
		
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
		lblNomPren.setBounds(207, 118, 141, 14);
		contentPane.add(lblNomPren);
		
		JLabel lblDis = new JLabel("Distance              :");
		lblDis.setForeground(Color.BLACK);
		lblDis.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDis.setBounds(207, 165, 141, 14);
		contentPane.add(lblDis);
		
		JLabel lblAge = new JLabel("Age                    :");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAge.setBounds(211, 200, 137, 30);
		contentPane.add(lblAge);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(368, 149, 215, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(368, 192, 215, 14);
		contentPane.add(separator_2);
		
		txtAge = new JTextField();
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtAncien.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtDist.requestFocus();
					
				}
				
			}
		});
		txtAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtAge.getText().equals("") ||
						txtAge.getText().equals("Entrer l'Age d'enseignant"))
					{
					txtAge.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtAge.getText().trim().equals("") ||
						txtAge.getText().trim().toLowerCase().equals("Entrer l'Age d'enseignant") )
				{
					
					txtAge.setText("Entrer l'Age d'enseignant");
					
				}
				
			}
		});
		txtAge.setToolTipText("");
		txtAge.setText("Entrer l'Age d'enseignant");
		txtAge.setForeground(Color.DARK_GRAY);
		txtAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setCaretColor(Color.WHITE);
		txtAge.setBorder(null);
		txtAge.setBackground(new Color(97, 212, 195));
		txtAge.setBounds(378, 208, 205, 20);
		contentPane.add(txtAge);
		ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(368, 236, 215, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(368, 282, 215, 2);
		contentPane.add(separator_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_8.setBackground(new Color(54, 71, 99));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(new Color(36,47,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				String nompren = txtNomPrn.getText().toString();
				String a=txtDist.getText();
				int dis = Integer.valueOf(a);
				String b=txtAge.getText();
				String c=txtAncien.getText();
				String p=lblpri.getText();
			//	int dis=Integer.parseInt(a);
			//	int age=Integer.parseInt(b);
			//	int ancien=Integer.parseInt(c);
			//	int prio = Integer.parseInt(p);
			//	String maladi = txtmalad.getText().toString();
				
				String sql = "UPDATE `ensei` SET  `priorit`='\"+prio+\"' Where `NomPren`='"+nompren+"'";			

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
					pst = con.prepareStatement(sql);		
					pst.execute(sql);
					JOptionPane.showMessageDialog(null, "enseignant modifié ");

					
					/*if((dist > 50)&&(a<50)) {
						pi = pi + 10;
					}
					if((dis < 50)&&(a>50)) {
						pi = pi - 10;
					}
					if((age > 45)&&(b<45)) {
						pi = pi + 16;
					}
					if((age < 45)&&(b>45)) {
						pi = pi - 16;
					}
					if((ancien > 10)&&(c<10)) {
						pi = pi + 15;
					}
					if((ancien < 10)&&(c>10)) {
						pi = pi - 15;
					}
					/*if((!(maladi.equals("aucune")) {
						pi = pi + 30;
					}*/
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}remp(); 	
				
			}
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(36, 47, 65));
		panel_8.setBounds(401, 419, 182, 72);
		contentPane.add(panel_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
		label_1.setIcon(img1);
		label_1.setBounds(0, 0, 55, 72);
		panel_8.add(label_1);
		
		JLabel lblModifier = new JLabel("Enregestrer");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setForeground(Color.WHITE);
		lblModifier.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblModifier.setBounds(55, 0, 112, 47);
		panel_8.add(lblModifier);
		
		JLabel lblLesModifications = new JLabel("les modifications");
		lblLesModifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesModifications.setForeground(Color.WHITE);
		lblLesModifications.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblLesModifications.setBounds(55, 25, 112, 47);
		panel_8.add(lblLesModifications);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/supp.png"));
		UpdateTable();
		
		txtNomPrn = new JTextField();
		txtNomPrn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtDist.requestFocus();
					
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
						txtNomPrn.getText().equals("Nom et Prénom d'Enseignant"))
					{
					txtNomPrn.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtNomPrn.getText().trim().equals("") ||
						txtNomPrn.getText().trim().toLowerCase().equals("Nom et Prénom d'Enseignant") )
				{
					
					txtNomPrn.setText("Nom et Prénom d'Enseignant");
					
				}
				
			}
		});
		txtNomPrn.setToolTipText("");
		txtNomPrn.setText("Nom et Prénom d'Enseignant");
		txtNomPrn.setForeground(Color.DARK_GRAY);
		txtNomPrn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtNomPrn.setColumns(10);
		txtNomPrn.setCaretColor(Color.WHITE);
		txtNomPrn.setBorder(null);
		txtNomPrn.setBackground(new Color(97, 212, 195));
		txtNomPrn.setBounds(378, 118, 207, 20);
		contentPane.add(txtNomPrn);
		
		txtDist = new JTextField();
		txtDist.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtAge.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtNomPrn.requestFocus();
					
				}
				
			}
		});
		txtDist.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtDist.getText().equals("") ||
						txtDist.getText().equals("Entre maison et la fac en KM"))
					{
					txtDist.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtDist.getText().trim().equals("") ||
						txtDist.getText().trim().toLowerCase().equals("Entre maison et la fac en KM") )
				{
					
					txtDist.setText("Entre maison et la fac en KM");
					
				}
				
			}
		});
		txtDist.setToolTipText("");
		txtDist.setText("Entre maison et la fac en KM");
		txtDist.setForeground(Color.DARK_GRAY);
		txtDist.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtDist.setColumns(10);
		txtDist.setCaretColor(Color.WHITE);
		txtDist.setBorder(null);
		txtDist.setBackground(new Color(97, 212, 195));
		txtDist.setBounds(378, 165, 205, 20);
		contentPane.add(txtDist);
		
		txtAncien = new JTextField();
		txtAncien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtAge.requestFocus();
					
				}
                if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtmalad.requestFocus();
					
				}
				
			}
		});
		txtAncien.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtAncien.getText().equals("") ||
						txtAncien.getText().equals("Nombre d'année d'ancienneté"))
					{
					txtAncien.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtAncien.getText().trim().equals("") ||
						txtAncien.getText().trim().toLowerCase().equals("Nombre d'année d'ancienneté") )
				{
					
					txtAncien.setText("Nombre d'année d'ancienneté");
					
				}
				
			}
		});
		txtAncien.setToolTipText("");
		txtAncien.setText("Nombre d'année d'ancienneté");
		txtAncien.setForeground(Color.DARK_GRAY);
		txtAncien.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtAncien.setColumns(10);
		txtAncien.setCaretColor(Color.WHITE);
		txtAncien.setBorder(null);
		txtAncien.setBackground(new Color(97, 212, 195));
		txtAncien.setBounds(378, 254, 209, 20);
		contentPane.add(txtAncien);
		
	//	Remplir();
		
		JPanel panel_81 = new JPanel();
		panel_81.setBounds(0, 0, 644, 39);
		contentPane.add(panel_81);
		panel_81.setLayout(null);
		//panel_8.setBackground(new Color(97, 212, 195));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 48, 37);
		panel_81.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img22 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img22);
		
		JLabel lblcpt = new JLabel("Mon Compte");
		lblcpt.setBounds(58, 0, 514, 37);
		panel_81.add(lblcpt);
		lblcpt.setHorizontalAlignment(SwingConstants.CENTER);
		lblcpt.setForeground(Color.BLACK);
		lblcpt.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel label_11 = new JLabel("\u0640\u0640\u0640");
		label_11.setBounds(561, 0, 29, 37);
		panel_81.add(label_11);
		label_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(591, 0, 29, 37);
		panel_81.add(lblX);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblAnciennet = new JLabel("Anciennet\u00E9          :");
		lblAnciennet.setForeground(Color.BLACK);
		lblAnciennet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAnciennet.setBounds(207, 258, 141, 14);
		contentPane.add(lblAnciennet);
		
		JLabel lblMalad = new JLabel("Maladie               :");
		lblMalad.setForeground(Color.BLACK);
		lblMalad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMalad.setBounds(207, 307, 141, 14);
		contentPane.add(lblMalad);
		
		txtmalad = new JTextField();
		txtmalad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtAge.requestFocus();
					
				}

				if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtUtil.requestFocus();
					
				}
				
			}
		});
		txtmalad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtmalad.getText().equals("") ||
						txtmalad.getText().equals("Nom de la maladie s'il existe"))
					{
					txtmalad.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtmalad.getText().trim().equals("") ||
						txtmalad.getText().trim().toLowerCase().equals("Nom de la maladie s'il existe") )
				{
					
					txtmalad.setText("Nom de la maladie s'il existe");
					
				}
				
			}
		});
		txtmalad.setToolTipText("");
		txtmalad.setText("Nom de la maladie s'il existe");
		txtmalad.setForeground(Color.DARK_GRAY);
		txtmalad.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtmalad.setColumns(10);
		txtmalad.setCaretColor(Color.WHITE);
		txtmalad.setBorder(null);
		txtmalad.setBackground(new Color(97, 212, 195));
		txtmalad.setBounds(378, 305, 209, 20);
		contentPane.add(txtmalad);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(368, 333, 215, 2);
		contentPane.add(separator_5);
		
		txtUtil = new JTextField();
		txtUtil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtNomPrn.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtmalad.requestFocus();
					
				}
			}
		});
		txtUtil.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtUtil.getText().equals("") ||
						txtUtil.getText().equals("L'ID d'Enseignant"))
					{
					txtUtil.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtUtil.getText().trim().equals("") ||
						txtUtil.getText().trim().toLowerCase().equals("L'ID d'Enseignant") )
				{
					
					txtUtil.setText("L'ID d'Enseignant");
					
				}
				
			}
		});
		txtUtil.setToolTipText("");
		txtUtil.setText("L'ID d'Enseignant");
		txtUtil.setForeground(Color.DARK_GRAY);
		txtUtil.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtUtil.setColumns(10);
		txtUtil.setCaretColor(Color.WHITE);
		txtUtil.setBorder(null);
		txtUtil.setBackground(new Color(97, 212, 195));
		txtUtil.setBounds(382, 71, 203, 20);
		contentPane.add(txtUtil);
		
		JLabel lblUtil = new JLabel("Nom d'utulisateur:");
		lblUtil.setForeground(Color.BLACK);
		lblUtil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblUtil.setBounds(207, 71, 151, 14);
		contentPane.add(lblUtil);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(368, 102, 215, 2);
		contentPane.add(separator_6);
		
		JLabel lblJourDeTravaille = new JLabel("Jour de Travaille  :");
		lblJourDeTravaille.setForeground(Color.BLACK);
		lblJourDeTravaille.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblJourDeTravaille.setBounds(207, 359, 162, 14);
		contentPane.add(lblJourDeTravaille);
		
		nbrT = new JComboBox();
		nbrT.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		nbrT.setToolTipText("");
		nbrT.setForeground(Color.DARK_GRAY);
		nbrT.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		nbrT.setBorder(null);
		//nbrT.setBackground(new Color(97, 212, 195));
		nbrT.setBounds(368, 346, 219, 41);
		contentPane.add(nbrT);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(368, 385, 215, 2);
		contentPane.add(separator_7);
		
		JLabel lblPriorit = new JLabel("Priorit\u00E9 :");
		lblPriorit.setForeground(Color.BLACK);
		lblPriorit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblPriorit.setBounds(240, 435, 69, 30);
		contentPane.add(lblPriorit);
		
		lblpri = new JLabel("1");
		lblpri.setBackground(Color.WHITE);
		lblpri.setHorizontalAlignment(SwingConstants.CENTER);
		lblpri.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblpri.setBounds(319, 435, 39, 30);
		contentPane.add(lblpri);
		Remplir();
		remp();
		
	}
public void UpdateTable(){
		
		String sql = "SELECT * FROM ensei"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		
	}
public void Remplir(){
		
		login a =new login();
		String s1= a.s;
		String s2 = "Enseignat5";
		String sql = "SELECT * FROM ensei WHERE `NomUtil` = '"+s1+"';"; 	
		//String sql = "SELECT * FROM ensei WHERE ID = 5 ;";
		try {
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false", "root", "");
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			
			while (rs.next()) {
				//JOptionPane.showMessageDialog(null,rs.getInt("Age") );
				int i = rs.getInt("Age");
				String 	age= String.valueOf(i);				
				txtUtil.setText(rs.getString("NomUtil"));
				txtNomPrn.setText(rs.getString("NomPren"));
				txtDist.setText(rs.getString("DISTANCE"));
				txtAge.setText(age);
				txtAncien.setText(rs.getString("Ancien"));
				txtmalad.setText(rs.getString("Maladie"));
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	

		
	}

public void remp() {
	String sql = "SELECT * FROM `ensei` WHERE `ensei`.`ID` = 1"; 			
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
		pst = con.prepareStatement(sql);		
		rs = pst.executeQuery(sql);
		while (rs.next()) {
			String Util= rs.getString("NomUtil").toString();
			String NomPrn= rs.getString("NomPren").toString();
			int dis= rs.getInt("DISTANCE");
			String d = String.valueOf(dis);
			int age= rs.getInt("Age");
			String a = String.valueOf(age);
			int Niv= rs.getInt("Ancien");
			String n = String.valueOf(Niv);
			String Fil= rs.getString("Maladie").toString();
			int p= rs.getInt("priorit");
			String pi = String.valueOf(p);
			txtUtil.setText(Util);
			txtNomPrn.setText(NomPrn);		
			txtDist.setText(d);
			txtAge.setText(a);
			txtAncien.setText(n);
			txtmalad.setText(Fil);
			lblpri.setText(pi);

			
			//String type= rs.getString("Type").toString();
			//comboBox.addItem(type);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
