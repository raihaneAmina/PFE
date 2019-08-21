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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import login.login;
import net.proteanit.sql.DbUtils;
import admin.compt;
import admin.enseig;
import admin.modul;
import admin.niveau;


public class jrs extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JPanel panel_7;
	private JPanel panel;
	private JScrollPane e1;
	private JLabel lbl7;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl4;
	private JLabel lbl3;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lbl20;
	private JLabel lbl21;
	private JLabel lbl22;
	private JLabel lbl23;
	private JLabel lbl24;
	private JLabel lbl25;
	private JLabel lbl26;
	private JLabel lbl27;
	private JLabel lbl28;
	private JLabel lbl29;
	private JLabel lbl30;
	private JLabel lbl31;
	private JLabel lbl32;
	private JLabel lbl33;
	private JLabel lbl34;
	private JLabel lbl35;
	private JLabel lbl36;
	private JLabel lbl37;
	private JLabel lbl38;
	private JLabel lbl39;
	private JLabel lbl40;
	private JLabel lbl41;
	private JLabel lbl42;
	private JLabel lbl43;
	private JLabel lbl44;
	private JLabel lbl45;
	private JLabel lbl46;
	private JLabel lbl47;
	private JLabel lbl48;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jrs frame = new jrs();
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
	public jrs() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(w/8, h/8, 1032, 502);
		setTitle("Planning de surveillence");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cellul();
			}
		});
		contentPane.setBackground(new Color(97,212,195));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & ALLALI Yasmine & RAIEB Rekia");
		lblSehalAminaRihane.setBackground(Color.BLACK);
		lblSehalAminaRihane.setBounds(197, 475, 835, 27);
		contentPane.add(lblSehalAminaRihane);
		lblSehalAminaRihane.setForeground(Color.BLACK);
		lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/print2.png"));
		
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
            	Mcompt m = new Mcompt();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(36, 48, 66));
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
				panel_4.setBackground(new Color(27, 36, 49));
			}
			
            public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 47);
		panel_4.setBackground(new Color(27, 36, 49));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblListeDesEnseignant = new JLabel("Planning de surveillance");
		lblListeDesEnseignant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblListeDesEnseignant.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesEnseignant.setForeground(Color.WHITE);
		lblListeDesEnseignant.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesEnseignant.setBounds(10, 11, 177, 25);
		panel_4.add(lblListeDesEnseignant);
		
		JLabel lblKeeptoo = new JLabel("GETE");
		lblKeeptoo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeeptoo.setBounds(0, 25, 197, 37);
		lblKeeptoo.setForeground(new Color(255, 255, 255));
		lblKeeptoo.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		panel.add(lblKeeptoo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 73, 100, 11);
		panel.add(separator);
	//	ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
	//	ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
	//	ImageIcon img2 = new ImageIcon(login.class.getResource("/img/supp.png"));
	//	UpdateTable();
		
		JPanel panel_81 = new JPanel();
		panel_81.setBounds(0, 0, 1032, 39);
		contentPane.add(panel_81);
		panel_81.setLayout(null);
		//panel_8.setBackground(new Color(97, 212, 195));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 48, 37);
		panel_81.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img3 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img3);
		
		JLabel lblGesionDesEnseignats = new JLabel("Planning de surveillance");
		lblGesionDesEnseignats.setBounds(58, 0, 905, 37);
		panel_81.add(lblGesionDesEnseignats);
		lblGesionDesEnseignats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGesionDesEnseignats.setForeground(Color.BLACK);
		lblGesionDesEnseignats.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
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


		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(97,212,195));
		panel_7.setBounds(197, 92, 828, 319);
		contentPane.add(panel_7);
		//panel_7.setVisible(false);
		
		JLabel label_4 = new JLabel("Samedi");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_4.setBounds(49, 68, 80, 20);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("Dimanche");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_5.setBounds(49, 110, 80, 20);
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("Lundi");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_6.setBounds(49, 152, 80, 20);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("Mardi");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_7.setBounds(49, 194, 80, 20);
		panel_7.add(label_7);
		
		JLabel label_8 = new JLabel("Mercredi");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_8.setBounds(49, 236, 80, 20);
		panel_7.add(label_8);
		
		JLabel label_9 = new JLabel("Jeudi");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_9.setBounds(49, 278, 80, 20);
		panel_7.add(label_9);
		
		JLabel lblHh_3 = new JLabel("08.30 h -10.00h");
		lblHh_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh_3.setForeground(Color.BLACK);
		lblHh_3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblHh_3.setBounds(142, 25, 145, 20);
		panel_7.add(lblHh_3);
		
		JLabel lblHh_1 = new JLabel("10.30 h -12.00h");
		lblHh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh_1.setForeground(Color.BLACK);
		lblHh_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblHh_1.setBounds(307, 25, 145, 20);
		panel_7.add(lblHh_1);
		
		JLabel lblHh_2 = new JLabel("13.00 h -14.30h");
		lblHh_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh_2.setForeground(Color.BLACK);
		lblHh_2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblHh_2.setBounds(475, 25, 145, 20);
		panel_7.add(lblHh_2);
		
		JLabel lblHh_4 = new JLabel("15.00 h -16.30h");
		lblHh_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh_4.setForeground(Color.BLACK);
		lblHh_4.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblHh_4.setBounds(640, 25, 145, 20);
		panel_7.add(lblHh_4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(307, 56, 142, 42);
		panel_11.setLayout(null);
		
		lbl7 = new JLabel("");
		lbl7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl7.setBackground(Color.WHITE);
		lbl7.setBounds(0, 0, 148, 42);
		panel_11.add(lbl7);
		
		JLabel lblNewLabel = new JLabel("Semaine 2");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_7.setVisible(false);
				panel.setVisible(true);
			}
		});
		lblNewLabel.setBounds(10, 11, 119, 32);
		panel_7.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(152, 64, 135, 240);
		panel_7.add(panel_1);
		panel_1.setLayout(null);
		
		lbl1 = new JLabel("");
		lbl1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl1.setBounds(0, 0, 135, 40);
		panel_1.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl2.setBounds(0, 40, 135, 40);
		panel_1.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl3.setBounds(0, 80, 135, 40);
		panel_1.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl4.setBounds(0, 120, 135, 40);
		panel_1.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl5.setBounds(0, 160, 135, 40);
		panel_1.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl6.setBounds(0, 200, 135, 40);
		panel_1.add(lbl6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(317, 64, 135, 240);
		panel_7.add(panel_2);
		
		lbl7 = new JLabel("");
		lbl7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl7.setBounds(0, 0, 135, 40);
		panel_2.add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl8.setBounds(0, 40, 135, 40);
		panel_2.add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl9.setBounds(0, 80, 135, 40);
		panel_2.add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl10.setBounds(0, 120, 135, 40);
		panel_2.add(lbl10);
		
		lbl11 = new JLabel("");
		lbl11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl11.setBounds(0, 160, 135, 40);
		panel_2.add(lbl11);
		
		lbl12 = new JLabel("");
		lbl12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl12.setBounds(0, 200, 135, 40);
		panel_2.add(lbl12);
		
		JPanel panel_31 = new JPanel();
		panel_31.setLayout(null);
		panel_31.setBounds(485, 64, 135, 240);
		panel_7.add(panel_31);
		
		lbl13 = new JLabel("");
		lbl13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl13.setBounds(0, 0, 135, 40);
		panel_31.add(lbl13);
		
		lbl14 = new JLabel("");
		lbl14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl14.setBounds(0, 40, 135, 40);
		panel_31.add(lbl14);
		
		lbl15 = new JLabel("");
		lbl15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl15.setBounds(0, 80, 135, 40);
		panel_31.add(lbl15);
		
		lbl16 = new JLabel("");
		lbl16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl16.setBounds(0, 120, 135, 40);
		panel_31.add(lbl16);
		
		lbl17 = new JLabel("");
		lbl17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl17.setBounds(0, 160, 135, 40);
		panel_31.add(lbl17);
		
		lbl18 = new JLabel("");
		lbl18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl18.setBounds(0, 200, 135, 40);
		panel_31.add(lbl18);
		
		JPanel panel_41 = new JPanel();
		panel_41.setLayout(null);
		panel_41.setBounds(650, 64, 135, 240);
		panel_7.add(panel_41);
		
		lbl19 = new JLabel("");
		lbl19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl19.setBounds(0, 0, 135, 40);
		panel_41.add(lbl19);
		
		lbl20 = new JLabel("");
		lbl20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl20.setBounds(0, 40, 135, 40);
		panel_41.add(lbl20);
		
		lbl21 = new JLabel("");
		lbl21.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl21.setBounds(0, 80, 135, 40);
		panel_41.add(lbl21);
		
		lbl22 = new JLabel("");
		lbl22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl22.setBounds(0, 120, 135, 40);
		panel_41.add(lbl22);
		
		lbl23 = new JLabel("");
		lbl23.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl23.setBounds(0, 160, 135, 40);
		panel_41.add(lbl23);
		
		lbl24 = new JLabel("");		
		lbl24.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl24.setBounds(0, 200, 135, 40);
		panel_41.add(lbl24);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(789, 422, 182, 72);
		contentPane.add(panel_8);
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
			
			}
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(36, 47, 65));
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(img1);
		label_1.setBounds(0, 0, 66, 72);
		panel_8.add(label_1);
		
		JLabel lblImprimer = new JLabel("Imprimer");
		lblImprimer.setBounds(65, 11, 107, 50);
		panel_8.add(lblImprimer);
		lblImprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblImprimer.setForeground(Color.WHITE);
		lblImprimer.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		lblImprimer.setBackground(Color.BLACK);
		
	}
	public void UpdateEmp(JLabel l,int i,String j ,String h) {
		
		String sql = "SELECT NomSalle FROM emploiens P,salle M WHERE semaine='"+i+"' AND Jour = '"+j+"' AND temps = '"+h+"' AND M.ID = P.Numsal; "; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String ty= rs.getString("NomSalle").toString();
				l.setText(ty);
				//p.addItem(ty);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	
	public void cellul() {
		
		//1er Semestre
		UpdateEmp(lbl1,1,"Samedi" ,"08.30 h -10.00h");
		UpdateEmp(lbl2,1,"Dimanche" ,"08.30 h -10.00h");
		UpdateEmp(lbl3,1,"Lundi" ,"08.30 h -10.00h");
		UpdateEmp(lbl4,1,"Mardi" ,"08.30 h -10.00h");
		UpdateEmp(lbl5,1,"Mercredi" ,"08.30 h -10.00h");
		UpdateEmp(lbl6,1,"Jeudi" ,"08.30 h -10.00h");
		UpdateEmp(lbl7,1,"Samedi" ,"10.30 h -12.00h");
		UpdateEmp(lbl8,1,"Dimanche" ,"10.30 h -12.00h");
		UpdateEmp(lbl9,1,"Lundi" ,"10.30 h -12.00h");
		UpdateEmp(lbl10,1,"Mardi" ,"10.30 h -12.00h");
		UpdateEmp(lbl11,1,"Mercredi" ,"10.30 h -12.00h");
		UpdateEmp(lbl12,1,"Jeudi" ,"10.30 h -12.00h");
		UpdateEmp(lbl13,1,"Samedi" ,"13.00 h -14.30h");
		UpdateEmp(lbl14,1,"Dimanche" ,"13.00 h -14.30h");
		UpdateEmp(lbl15,1,"Lundi" ,"13.00 h -14.30h");
		UpdateEmp(lbl16,1,"Mardi" ,"13.00 h -14.30h");
		UpdateEmp(lbl17,1,"Mercredi" ,"13.00 h -14.30h");
		UpdateEmp(lbl18,1,"Jeudi" ,"13.00 h -14.30h");
		UpdateEmp(lbl19,1,"Samedi" ,"15.00 h -16.30h");
		UpdateEmp(lbl20,1,"Dimanche" ,"15.00 h -16.30h");
		UpdateEmp(lbl21,1,"Lundi" ,"15.00 h -16.30h");
		UpdateEmp(lbl22,1,"Mardi" ,"15.00 h -16.30h");
		UpdateEmp(lbl23,1,"Mercredi" ,"15.00 h -16.30h");
		UpdateEmp(lbl24,1,"Jeudi" ,"15.00 h -16.30h");
		
		//2eme Semestre
		/*
		UpdateEmp(lbl25,2,"Samedi" ,"08.30 h -10.00h");
		UpdateEmp(lbl26,2,"Dimanche" ,"08.30 h -10.00h");
		UpdateEmp(lbl27,2,"Lundi" ,"08.30 h -10.00h");
		UpdateEmp(lbl28,2,"Mardi" ,"08.30 h -10.00h");
		UpdateEmp(lbl29,2,"Mercredi" ,"08.30 h -10.00h");
		UpdateEmp(lbl30,2,"Jeudi" ,"08.30 h -10.00h");
		UpdateEmp(lbl31,2,"Samedi" ,"10.30 h -12.00h");
		UpdateEmp(lbl32,2,"Dimanche" ,"10.30 h -12.00h");
		UpdateEmp(lbl33,2,"Lundi" ,"10.30 h -12.00h");
		UpdateEmp(lbl34,2,"Mardi" ,"10.30 h -12.00h");
		UpdateEmp(lbl35,2,"Mercredi" ,"10.30 h -12.00h");
		UpdateEmp(lbl36,2,"Jeudi" ,"10.30 h -12.00h");
		UpdateEmp(lbl37,2,"Samedi" ,"13.00 h -14.30h");
		UpdateEmp(lbl38,2,"Dimanche" ,"13.00 h -14.30h");
		UpdateEmp(lbl39,2,"Lundi" ,"13.00 h -14.30h");
		UpdateEmp(lbl40,2,"Mardi" ,"13.00 h -14.30h");
		UpdateEmp(lbl41,2,"Mercredi" ,"13.00 h -14.30h");
		UpdateEmp(lbl42,2,"Jeudi" ,"13.00 h -14.30h");
		UpdateEmp(lbl43,2,"Samedi" ,"15.00 h -16.30h");
		UpdateEmp(lbl44,2,"Dimanche" ,"15.00 h -16.30h");
		UpdateEmp(lbl45,2,"Lundi" ,"15.00 h -16.30h");
		UpdateEmp(lbl46,2,"Mardi" ,"15.00 h -16.30h");
		UpdateEmp(lbl47,2,"Mercredi" ,"15.00 h -16.30h");
		UpdateEmp(lbl48,2,"Jeudi" ,"15.00 h -16.30h");*/
		
		/*		 */
	}
}
