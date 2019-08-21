package admin;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.app;
import login.login;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings({ "serial", "unused" })
public class enseig extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JTextField txtAge;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private JTable table;
	private JTextField txtnom;
	private JTextField txtDist;
	private JTextField txtAncien;
	private JTextField txtmalad;
	private JTextField txtID;
	private JTextField txtutil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enseig frame = new enseig();
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
	public enseig() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-1053)/2, (h-502)/2, 1032, 502);
		setTitle("Gestion des enseignants");
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
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_3.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_3.setBackground(new Color(36, 48, 66));
			}
			
            public void mouseClicked(MouseEvent arg0) {
				
				compt m =new compt();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(36, 48, 66));
		panel_3.setBounds(0, 122, 197, 47);
		panel.add(panel_3);
		
		JLabel lblGestionDesComptes = new JLabel("Gestion Des Comptes");
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
				
				modul m =new modul();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 47);
		panel_4.setBackground(new Color(36,47,65));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblListeDesEnseignant = new JLabel("liste des modules");
		lblListeDesEnseignant.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblListeDesEnseignant.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesEnseignant.setForeground(Color.WHITE);
		lblListeDesEnseignant.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesEnseignant.setBounds(10, 11, 153, 25);
		panel_4.add(lblListeDesEnseignant);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_5.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_5.setBackground(new Color(27, 36, 49));
			}
		});
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.setBounds(0, 216, 197, 47);
		panel_5.setBackground(new Color(27, 36, 49));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label = new JLabel("liste des enseignats");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		label.setBounds(10, 11, 156, 25);
		panel_5.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_6.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_6.setBackground(new Color(36, 48, 66));
			}			
			public void mouseClicked(MouseEvent arg0) {
				salle m = new salle();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.setBounds(0, 263, 197, 47);
		panel_6.setBackground(new Color(36, 48, 66));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblListeDesSalles = new JLabel("Gestion  des salles");
		lblListeDesSalles.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesSalles.setForeground(Color.WHITE);
		lblListeDesSalles.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesSalles.setBounds(10, 11, 153, 25);
		panel_6.add(lblListeDesSalles);
		
		JLabel lblKeeptoo = new JLabel("GETE");
		lblKeeptoo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeeptoo.setBounds(0, 25, 197, 37);
		lblKeeptoo.setForeground(new Color(255, 255, 255));
		lblKeeptoo.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		panel.add(lblKeeptoo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 73, 100, 11);
		panel.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_2.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_2.setBackground(new Color(36, 48, 66));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				niveau m = new niveau();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(36, 48, 66));
		panel_2.setBounds(0, 310, 197, 47);
		panel.add(panel_2);
		
		JLabel lblListeDesNiveaux = new JLabel("Gestion des Sp\u00E9cialit\u00E9s");
		lblListeDesNiveaux.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesNiveaux.setForeground(Color.WHITE);
		lblListeDesNiveaux.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesNiveaux.setBounds(10, 11, 177, 25);
		panel_2.add(lblListeDesNiveaux);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {			
				panel_7.setBackground(new Color(45, 60, 82));			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_7.setBackground(new Color(36, 48, 66));
			}
			 public void mouseClicked(MouseEvent arg0) {
					planning m = new planning();
					m.setVisible(true);
					setVisible(false);
				}
		});
		panel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(36, 48, 66));
		panel_7.setBounds(0, 357, 197, 47);
		panel.add(panel_7);
		
		JLabel lblPlaningExamens = new JLabel("planing examens");
		lblPlaningExamens.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlaningExamens.setForeground(Color.WHITE);
		lblPlaningExamens.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPlaningExamens.setBounds(10, 11, 153, 25);
		panel_7.add(lblPlaningExamens);
		
		JLabel lblMotDePasse = new JLabel("Nom et Pr\u00E9nom :");
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(218, 154, 129, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblEmail = new JLabel("Distance            :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(218, 201, 141, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSpialit = new JLabel("Age                  :");
		lblSpialit.setForeground(Color.BLACK);
		lblSpialit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSpialit.setBounds(222, 236, 125, 30);
		contentPane.add(lblSpialit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(353, 188, 215, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(353, 231, 215, 14);
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
		txtAge.setBounds(357, 244, 211, 20);
		contentPane.add(txtAge);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_1.setBackground(new Color(54, 71, 99));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(36,47,65));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne=table.getSelectedRow();
				
				if (txtID.getText().equals("L'ID d'Enseignant")
						||txtnom.getText().equals("Nom et Prénom d'Enseignant")  
						|| txtDist.getText().equals("Entre maison et la fac en KM")  
						|| txtAge.getText().equals("Entrer l'Age d'enseignant") 
						|| txtAncien.getText().equals("Entrer l'Age d'enseignant")
						|| txtmalad.getText().equals("Entrer l'Age d'enseignant")
						|| txtID.getText().equals("")
						|| txtnom.getText().equals("")  
						|| txtDist.getText().equals("")  
						|| txtAge.getText().equals("")  
						|| txtAncien.getText().equals("")
						|| txtmalad.getText().equals("") 
) {
					JOptionPane.showMessageDialog(null, "insérer le donnée");
				}
			else {
				
				String i= txtID.getText();
				int id= (int) Double.parseDouble(i);
				String nomp= txtnom.getText();
				String nmu= txtutil.getText();
				String dis=txtDist.getText().toString();
				int d= Integer.parseInt(dis);
				String a=txtAge.getText().toString();
				int age= Integer.parseInt(a);
				String aa=txtAncien.getText().toString();
				int ancie= Integer.parseInt(aa);
				String mal=txtmalad.getText().toString();
			
					try {
						String sql = "INSERT INTO `ensei`(`ID`, `NomUtil`, `NomPren`, `DISTANCE`, `Age`, `Ancien`, `Maladie`) "
								+ "VALUES ('"+id+"','"+nmu+"','"+nomp+"','"+d+"','"+age+"','"+ancie+"','"+mal+"')";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
					pst = con.prepareStatement(sql);		
					pst.execute();					
					JOptionPane.showMessageDialog(null, "enseignant insérer ");
					txtID.setText("");
				    txtnom.setText("");
					txtDist.setText("");
					txtAge.setText("");
					txtAncien.setText("");
					txtmalad.setText("");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
					
				}
			}
		});
		panel_1.setBackground(new Color(36,47,65));
		panel_1.setBounds(238, 401, 84, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblC = new JLabel("");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
		lblC.setIcon(img);
		lblC.setBounds(0, 0, 84, 50);
		panel_1.add(lblC);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblAjouter.setForeground(Color.WHITE);
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBounds(10, 47, 64, 25);
		panel_1.add(lblAjouter);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(353, 275, 215, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(353, 321, 215, 2);
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

				int ligne=table.getSelectedRow();
			
				if (ligne == -1) {
					JOptionPane.showMessageDialog(null, "Sélectionner un etudiant");
				}
			else {
				Modifier();
				}
			}
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(36, 47, 65));
		panel_8.setBounds(347, 401, 84, 72);
		contentPane.add(panel_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
		label_1.setIcon(img1);
		label_1.setBounds(0, 0, 84, 50);
		panel_8.add(label_1);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setForeground(Color.WHITE);
		lblModifier.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblModifier.setBounds(10, 47, 64, 25);
		panel_8.add(lblModifier);
		
		JPanel panel_9 = new JPanel();
		panel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_9.setBackground(new Color(54, 71, 99));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_9.setBackground(new Color(36,47,65));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int ligne=table.getSelectedRow();
				
				if (ligne == -1) {
					JOptionPane.showMessageDialog(null, "Sélectionner un etudiant");
				}
			else {
				int idc = (Integer)table.getModel().getValueAt(ligne, 0);
				String nompren = txtnom.getText().toString();
				String a=txtDist.getText();
				String b=txtAge.getText();
				String c=txtAncien.getText();
				int dis=Integer.parseInt(a);
				int age=Integer.parseInt(b);
				int ancien=Integer.parseInt(c);
				String maladi = txtmalad.getText().toString();
				String sql = "delete FROM ensei where id = '"+idc+"'";			
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
					pst = con.prepareStatement(sql);		
					pst.execute(sql);
					JOptionPane.showMessageDialog(null, "enseignant supprimé ");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
				}
				
			/*	int ligne=table.getSelectedRow();
				int idc = (Integer)table.getModel().getValueAt(ligne, 0);
				if (ligne ==-1) {
					
					JOptionPane.showMessageDialog(null, "Sélectionner un etudiant");
					
				}
			else {
				String sql = "delete FROM client where idclient = '"+idc+"'";			
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque?useSSL=false","root","");
					pst = con.prepareStatement(sql);		
					pst.execute(sql);
					JOptionPane.showMessageDialog(null, "client suppimé");
					UpdateTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
				}*/
				
			}
		});
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(36, 47, 65));
		panel_9.setBounds(457, 401, 84, 72);
		contentPane.add(panel_9);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/supp.png"));
		label_2.setIcon(img2);
		label_2.setBounds(0, 0, 84, 50);
		panel_9.add(label_2);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupprimer.setForeground(Color.WHITE);
		lblSupprimer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblSupprimer.setBounds(10, 47, 74, 25);
		panel_9.add(lblSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(582, 96, 423, 377);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				Select();
			}
		});
		UpdateTable();
		scrollPane.setViewportView(table);
		
		txtnom = new JTextField();
		txtnom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtDist.requestFocus();
					
				}

				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtutil.requestFocus();
					
				}
				
			}
		});
		txtnom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtnom.getText().equals("") ||
						txtnom.getText().equals("Nom et Prénom d'Enseignant"))
					{
					txtnom.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtnom.getText().trim().equals("") ||
						txtnom.getText().trim().toLowerCase().equals("Nom et Prénom d'Enseignant") )
				{
					
					txtnom.setText("Nom et Prénom d'Enseignant");
					
				}
				
			}
		});
		txtnom.setToolTipText("");
		txtnom.setText("Nom et Prénom d'Enseignant");
		txtnom.setForeground(Color.DARK_GRAY);
		txtnom.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtnom.setColumns(10);
		txtnom.setCaretColor(Color.WHITE);
		txtnom.setBorder(null);
		txtnom.setBackground(new Color(97, 212, 195));
		txtnom.setBounds(357, 154, 213, 20);
		contentPane.add(txtnom);
		
		txtDist = new JTextField();
		txtDist.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtAge.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtnom.requestFocus();
					
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
		txtDist.setBounds(357, 201, 211, 20);
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
		txtAncien.setBounds(357, 290, 215, 20);
		contentPane.add(txtAncien);
		
		JPanel panel_81 = new JPanel();
		panel_81.setBounds(0, 0, 1032, 39);
		contentPane.add(panel_81);
		panel_81.setLayout(null);
		//panel_8.setBackground(new Color(97, 212, 195));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, -1, 48, 37);
		panel_81.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img22 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img22);
		
		JLabel lblcpt = new JLabel("Gestion des enseignats");
		lblcpt.setBounds(129, 0, 834, 37);
		panel_81.add(lblcpt);
		lblcpt.setHorizontalAlignment(SwingConstants.CENTER);
		lblcpt.setForeground(Color.BLACK);
		lblcpt.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel label_11 = new JLabel("\u0640\u0640\u0640");
		label_11.setBounds(963, 0, 29, 37);
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
		lblX.setBounds(993, 0, 29, 37);
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
		
		JLabel lblAnciennet = new JLabel("Anciennet\u00E9        :");
		lblAnciennet.setForeground(Color.BLACK);
		lblAnciennet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAnciennet.setBounds(218, 294, 141, 14);
		contentPane.add(lblAnciennet);
		
		JLabel lblMaladieChronique = new JLabel("Maladie             :");
		lblMaladieChronique.setForeground(Color.BLACK);
		lblMaladieChronique.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMaladieChronique.setBounds(218, 343, 129, 14);
		contentPane.add(lblMaladieChronique);
		
		txtmalad = new JTextField();
		txtmalad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtAge.requestFocus();
					
				}

				if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtID.requestFocus();
					
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
		txtmalad.setBounds(357, 341, 215, 20);
		contentPane.add(txtmalad);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(353, 372, 215, 2);
		contentPane.add(separator_5);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtutil.requestFocus();
					
				}
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtmalad.requestFocus();
					
				}
			}
		});
		txtID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtID.getText().equals("") ||
						txtID.getText().equals("L'ID d'Enseignant"))
					{
					txtID.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtID.getText().trim().equals("") ||
						txtID.getText().trim().toLowerCase().equals("L'ID d'Enseignant") )
				{
					
					txtID.setText("L'ID d'Enseignant");
					
				}
				
			}
		});
		txtID.setToolTipText("");
		txtID.setText("L'ID d'Enseignant");
		txtID.setForeground(Color.DARK_GRAY);
		txtID.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtID.setColumns(10);
		txtID.setCaretColor(Color.WHITE);
		txtID.setBorder(null);
		txtID.setBackground(new Color(97, 212, 195));
		txtID.setBounds(357, 66, 213, 20);
		contentPane.add(txtID);
		
		JLabel lblLidentifiant = new JLabel("L'identifiant      :");
		lblLidentifiant.setForeground(Color.BLACK);
		lblLidentifiant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLidentifiant.setBounds(218, 66, 129, 14);
		contentPane.add(lblLidentifiant);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(353, 97, 215, 2);
		contentPane.add(separator_6);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				app b = new app();
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
		
		txtutil = new JTextField();
		txtutil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtnom.requestFocus();
					
				}

				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtID.requestFocus();
					
				}
				
			}
		});
		txtutil.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtutil.getText().equals("") ||
						txtutil.getText().equals("Le nom d'utilisateur"))
					{
					txtutil.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtutil.getText().trim().equals("") ||
						txtutil.getText().trim().toLowerCase().equals("Le nom d'utilisateur") )
				{
					
					txtutil.setText("Le nom d'utilisateur");
					
				}
				
			}
		});
		txtutil.setToolTipText("");
		txtutil.setText("Le nom d'utilisateur");
		txtutil.setForeground(Color.DARK_GRAY);
		txtutil.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtutil.setColumns(10);
		txtutil.setCaretColor(Color.WHITE);
		txtutil.setBorder(null);
		txtutil.setBackground(new Color(97, 212, 195));
		txtutil.setBounds(357, 110, 213, 20);
		contentPane.add(txtutil);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur:");
		lblNomDutilisateur.setForeground(Color.BLACK);
		lblNomDutilisateur.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNomDutilisateur.setBounds(218, 110, 152, 14);
		contentPane.add(lblNomDutilisateur);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(353, 141, 215, 2);
		contentPane.add(separator_7);
	}
	public void UpdateTable(){
		
		String sql = "SELECT * FROM ensei"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	
	public void Modifier(){
		int ligne=table.getSelectedRow();
		int idc = (Integer)table.getModel().getValueAt(ligne, 0);
		String nompren = txtnom.getText().toString();
		String nmu= txtutil.getText();
		String a=txtDist.getText();
		String b=txtAge.getText();
		String c=txtAncien.getText();
		int dis=Integer.parseInt(a);
		int age=Integer.parseInt(b);
		int ancien=Integer.parseInt(c);
		String maladi = txtmalad.getText().toString();
		
	
		int d = (Integer)table.getModel().getValueAt(ligne, 3);
		int ag = (Integer)table.getModel().getValueAt(ligne, 4);
		int an = (Integer)table.getModel().getValueAt(ligne, 5);
		String malad = (String)table.getModel().getValueAt(ligne, 1);
		int prio = (Integer)table.getModel().getValueAt(ligne, 7);
	    int p = 1;
	/*    if((dis > 50) && (d < 50)) {
			p = p + 10;
		}
		if((dis < 50) && (d > 50)) {
			p = p - 10;
		}
		if((age> 45)&& (ag < 45)) {
			p = p + 16;
		}
		if((age < 45)&& (ag > 45)) {
			p = p - 16;
		}
		if((ancien > 10)&& (an < 10)) {
			p = p + 15;
		}
		if((ancien < 10)&& (an > 10)) {
			p = p - 15;
		}
		if((!(maladi.equals("aucune")))&& !(maladi.equals(malad))) {
			p = p + 30;
		}
		if(((maladi.equals("aucune")))&& !(malad.equals("aucune"))) {
			p = p - 30;
		}*/
	    if((dis > 50)) {
			p = p + 10;
		}
		if((age> 45)) {
			p = p + 16;
		}
		if((ancien > 10)) {
			p = p + 15;
		}
		if((!(maladi.equals("aucune")))) {
			p = p + 30;
		}
		
		String sql = "UPDATE `ensei` SET  `NomPren`='"+nompren+"',`NomUtil`='"+nmu+"',`DISTANCE`= '"+dis +"' ,`Age`= '"+age+"' ,`Ancien`= '"+ancien+"',`Maladie`= '"+maladi+"' , `priorit`='"+p+"' where `ID` = '"+idc+"'";			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			pst.execute(sql);
			JOptionPane.showMessageDialog(null, "enseignant modifié ");
			UpdateTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 	
		
	}	
	public void Select() {
		int ligne=table.getSelectedRow();
		//JOptionPane.showMessageDialog(null, ligne);
		int i = (Integer)table.getModel().getValueAt(ligne, 0);
		String id= String.valueOf(i);
	    String id1 = (String)table.getModel().getValueAt(ligne, 1);
	    String id2 = (String)table.getModel().getValueAt(ligne, 2);
	    int i3 = (Integer)table.getModel().getValueAt(ligne, 3);
	    String id3 = String.valueOf(i3);
	    int i4 = (Integer)table.getModel().getValueAt(ligne, 4);
		String id4= String.valueOf(i4);
	    int i5 = (Integer)table.getModel().getValueAt(ligne, 5);
	    String id5 = String.valueOf(i5);
	    String id6 = (String)table.getModel().getValueAt(ligne, 6);

		txtID.setText(id);
		txtutil.setText(id1);
		txtnom.setText(id2);
		txtDist.setText(id3);
		txtAge.setText(id4);
		txtAncien.setText(id5);
		txtmalad.setText(id6);
		
		
		
	}
}
