package Deleg;

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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Enseig.jrs;
import login.app;
import login.appE;
import login.appd;
import login.login;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clasm extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private Connection con2 = null; 		
	private java.sql.PreparedStatement pst2 = null;		
	private ResultSet rs2 = null;
	private JTable table;
	private JTextField txtID;
	private JRadioButton rdbS1;
	private JRadioButton rdvS2;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clasm frame = new clasm();
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
	public clasm() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-650)/2, (h-500)/2, 650, 500);
		setTitle("Ordre de passage");
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
				panel_3.setBackground(new Color(36, 48, 66));
			}
			
            public void mouseClicked(MouseEvent arg0) {
            	mcompt m = new mcompt();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(36, 48, 66));
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
				panel_4.setBackground(new Color(27, 36, 49));
			}
			
            public void mouseClicked(MouseEvent arg0) {
            	
				
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 70);
		panel_4.setBackground(new Color(27, 36, 49));
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
				panel_4.setBackground(new Color(27, 36, 49));
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
		
		JLabel lblNomPren = new JLabel("Nom de module   :");
		lblNomPren.setForeground(Color.BLACK);
		lblNomPren.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNomPren.setBounds(238, 78, 171, 37);
		contentPane.add(lblNomPren);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(420, 112, 171, 14);
		contentPane.add(separator_1);
		ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
		
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
				modif();	
				}
			}
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(36, 47, 65));
		panel_8.setBounds(477, 175, 119, 39);
		contentPane.add(panel_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
		label_1.setIcon(img1);
		label_1.setBounds(10, 0, 41, 38);
		panel_8.add(label_1);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setForeground(Color.WHITE);
		lblModifier.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblModifier.setBounds(48, 0, 61, 39);
		panel_8.add(lblModifier);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/supp.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Select();
			}
		});
		scrollPane.setBounds(220, 225, 420, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				//Select();
			}
		});
		scrollPane.setViewportView(table);
		//UpdateTable();
		
		txtID = new JTextField();
		txtID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtID.getText().equals("") ||
						txtID.getText().equals("Nbr trait"))
					{
					txtID.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtID.getText().trim().equals("") ||
						txtID.getText().trim().toLowerCase().equals("Nbr trait") )
				{
					
					txtID.setText("Nbr trait");
					
				}
				
			}
		});
		txtID.setToolTipText("");
		txtID.setText("le nom du module");
		txtID.setForeground(Color.DARK_GRAY);
		txtID.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtID.setColumns(10);
		txtID.setCaretColor(Color.WHITE);
		txtID.setBorder(null);
		txtID.setBackground(new Color(97, 212, 195));
		txtID.setBounds(436, 87, 149, 20);
		contentPane.add(txtID);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 650, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(5, -1, 33, 37);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img33 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img33);
		
		JLabel lblGesionDesEnseignats = new JLabel("Ordre de passage des examens");
		lblGesionDesEnseignats.setBounds(94, 0, 496, 37);
		panel_1.add(lblGesionDesEnseignats);
		lblGesionDesEnseignats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGesionDesEnseignats.setForeground(Color.BLACK);
		lblGesionDesEnseignats.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel label_11 = new JLabel("\u0640\u0640\u0640");
		label_11.setBounds(581, -1, 29, 37);
		panel_1.add(label_11);
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
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(611, -1, 29, 37);
		panel_1.add(lblX);
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
		
		JLabel lblSemestre = new JLabel("Semestre :");
		lblSemestre.setBounds(248, 185, 83, 23);
		lblSemestre.setForeground(Color.BLACK);
		lblSemestre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblSemestre);
		
		ButtonGroup b =new ButtonGroup();
		
		rdbS1 = new JRadioButton("01");
		rdbS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT NomModul,ordre "
						+ "FROM module WHERE `module`.`NumF` = 37";
				if (rdbS1.isSelected()) {
				sql = "SELECT NomModul,ordre "
						+ "FROM module WHERE `module`.`NumF` = 37 and `semestre`= 1"; 
				}
				UpdateTable(sql);
			}
		});
		rdbS1.setForeground(Color.BLACK);
		rdbS1.setBounds(337, 185, 46, 23);
		rdbS1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbS1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbS1.setBackground(new Color(97,212,195));
		contentPane.add(rdbS1);
		b.add(rdbS1);
		
		rdvS2 = new JRadioButton("02");
		rdvS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT NomModul,ordre "
						+ "FROM module WHERE `module`.`NumF` = 37";
				if (rdvS2.isSelected()) {
				sql = "SELECT NomModul,ordre "
						+ "FROM module WHERE `module`.`NumF` = 37 and `semestre`= 2"; 
				}
				UpdateTable(sql);
			}
		});
		rdvS2.setForeground(Color.BLACK);
		rdvS2.setBounds(391, 185, 46, 23);
		rdvS2.setHorizontalAlignment(SwingConstants.CENTER);
		rdvS2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdvS2.setBackground(new Color(97,212,195));
		contentPane.add(rdvS2);
		b.add(rdvS2);
		
		JLabel label = new JLabel("Nbr de traitement    :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		label.setBounds(239, 126, 171, 37);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("Nbr trait");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(new Color(97, 212, 195));
		textField.setBounds(436, 135, 149, 20);
		contentPane.add(textField);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(420, 160, 171, 14);
		contentPane.add(separator_2);
		
		
		
		
	}
	
public void UpdateTable(String s){
		
	String ql = "INSERT INTO `ordre`(`ID`, `NumF`, `module`, `ordre`)"
			+ " VALUES ([value-1],[value-2],[value-3],[value-4])";
	
	String sql = "SELECT NomModul,ordre "
				+ "FROM module WHERE `module`.`NumF` = 37"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(s);		
			rs = pst.executeQuery(s);
		    table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
	}
public void modif() {
	
	String i= txtID.getText().toString();
	int id=Integer.parseInt(i);
	String ordr = txtID.getText().toString();
	String sql = "UPDATE `module` SET `ordre`='"+ordr+"' WHERE `ordre`='"+ordr+"'";	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
		pst = con.prepareStatement(sql);		
		pst.execute(sql);
		JOptionPane.showMessageDialog(null, "ordre modifier ");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 	
	
}

public void Select() {
	int ligne=table.getSelectedRow();
	int i = (Integer)table.getModel().getValueAt(ligne, 1);
	String id= String.valueOf(i);
	
	txtID.setText(id);

}
}
