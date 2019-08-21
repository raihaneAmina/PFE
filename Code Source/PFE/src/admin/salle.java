package admin;

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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.app;
import login.login;
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class salle extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private JTable table;
	private JTextField txtcap;
	private JTextField txtnom;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salle frame = new salle();
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
	public salle() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-1053)/2, (h-502)/2, 1032, 502);
		setTitle("Gestion des salles");
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
		panel_4.setBounds(0, 168, 197, 47);
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
				panel_5.setBackground(new Color(36, 48, 66));
			}
			 public void mouseClicked(MouseEvent arg0) {
					enseig m = new enseig();
					m.setVisible(true);
					setVisible(false);
				}
		});
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.setBounds(0, 215, 197, 47);
		panel_5.setBackground(new Color(36, 48, 66));
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
				panel_6.setBackground(new Color(27, 36, 49));
			}
		});
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.setBounds(0, 262, 197, 47);
		panel_6.setBackground(new Color(27, 36, 49));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblListeDesSalles = new JLabel("Gestion des salles");
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
		panel_2.setBounds(0, 309, 197, 47);
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
		panel_7.setBounds(0, 356, 197, 47);
		panel.add(panel_7);
		
		JLabel lblPlaningExamens = new JLabel("planing examens");
		lblPlaningExamens.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlaningExamens.setForeground(Color.WHITE);
		lblPlaningExamens.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPlaningExamens.setBounds(10, 11, 153, 25);
		panel_7.add(lblPlaningExamens);
		JLabel lblNewLabel_1 = new JLabel("Nom Salle:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(217, 189, 84, 14);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Capacit\u00E9:");
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(217, 233, 84, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblEmail = new JLabel("ID            :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(217, 142, 84, 14);
		contentPane.add(lblEmail);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(311, 174, 214, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(311, 214, 214, 2);
		contentPane.add(separator_2);
		
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
		});
		panel_1.setBackground(new Color(36,47,65));
		panel_1.setBounds(222, 385, 84, 72);
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
		separator_3.setBounds(311, 258, 214, 2);
		contentPane.add(separator_3);
		
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
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(36, 47, 65));
		panel_8.setBounds(331, 385, 84, 72);
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
		});
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(36, 47, 65));
		panel_9.setBounds(441, 385, 84, 72);
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
		scrollPane.setBounds(545, 71, 465, 402);
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
		
		txtcap = new JTextField();
		txtcap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtnom.requestFocus();
					
				}
				
			}
		});
		txtcap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtcap.getText().equals("") ||
						txtcap.getText().equals("Entrer la capacité du salle"))
					{
					txtcap.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtcap.getText().trim().equals("") ||
						txtcap.getText().trim().toLowerCase().equals("Entrer la capacité du salle") )
				{
					
					txtcap.setText("Entrer la capacité du salle");
					
				}
				
			}
		});
		txtcap.setToolTipText("");
		txtcap.setText("Entrer la capacité du salle");
		txtcap.setForeground(Color.DARK_GRAY);
		txtcap.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtcap.setColumns(10);
		txtcap.setCaretColor(Color.WHITE);
		txtcap.setBorder(null);
		txtcap.setBackground(new Color(97, 212, 195));
		txtcap.setBounds(311, 231, 214, 20);
		contentPane.add(txtcap);
		
		txtnom = new JTextField();
		txtnom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtcap.requestFocus();
					
				}
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtID.requestFocus();
					
				}
				
			}
		});
		txtnom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtnom.getText().equals("") ||
						txtnom.getText().equals("Entrer le nom du salle"))
					{
					txtnom.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtnom.getText().trim().equals("") ||
						txtnom.getText().trim().toLowerCase().equals("Entrer le nom du salle") )
				{
					
					txtnom.setText("Entrer le nom du salle");
					
				}
				
			}
		});
		txtnom.setToolTipText("");
		txtnom.setText("Entrer le nom du salle");
		txtnom.setForeground(Color.DARK_GRAY);
		txtnom.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtnom.setColumns(10);
		txtnom.setCaretColor(Color.WHITE);
		txtnom.setBorder(null);
		txtnom.setBackground(new Color(97, 212, 195));
		txtnom.setBounds(311, 187, 214, 20);
		contentPane.add(txtnom);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtnom.requestFocus();
					
				}
				
			}
		});
		txtID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtID.getText().equals("") ||
						txtID.getText().equals("Entrer l' ID du salle"))
					{
					txtID.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtID.getText().trim().equals("") ||
						txtID.getText().trim().toLowerCase().equals("Entrer l' ID du salle") )
				{
					
					txtID.setText("Entrer l' ID du salle");
					
				}
				
			}
		});
		txtID.setToolTipText("");
		txtID.setText("Entrer l' ID du salle");
		txtID.setForeground(Color.DARK_GRAY);
		txtID.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtID.setColumns(10);
		txtID.setCaretColor(Color.WHITE);
		txtID.setBorder(null);
		txtID.setBackground(new Color(97, 212, 195));
		txtID.setBounds(311, 140, 214, 20);
		contentPane.add(txtID);
		
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
		
		JLabel lblcpt = new JLabel("Gestion des salles");
		lblcpt.setBounds(58, 0, 905, 37);
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
		
	}
	public void UpdateTable(){
		
		String sql = "SELECT * FROM `salle`"; 			
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
	
	public void Select() {
		int ligne=table.getSelectedRow();
		//JOptionPane.showMessageDialog(null, ligne);
		int i = (Integer)table.getModel().getValueAt(ligne, 0);
		String id= String.valueOf(i);
	    String id1 = (String)table.getModel().getValueAt(ligne, 1);
	    int i2 = (Integer)table.getModel().getValueAt(ligne, 2);
		String idd= String.valueOf(i2);
		
		
		
		txtID.setText(id);
		txtnom.setText(id1);
		txtcap.setText(idd);
		
	}
}
