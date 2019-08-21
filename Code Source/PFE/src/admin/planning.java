package admin;

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

import javax.sound.midi.MidiDevice.Info;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

import FntrInfo.Infor;
import FntrInfo.Item;
import login.app;
import login.login;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class planning extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSp;
	private JPanel panel_7;
	private JTable table;
	private JRadioButton rdbtnSt;
	private JRadioButton rdbtnSm;
	private JRadioButton rdbtnMi;
	private DefaultComboBoxModel model = new DefaultComboBoxModel();
	private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model2 = new DefaultComboBoxModel();
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
	private JPanel panel;
	private JRadioButton rdbS1;
	private JRadioButton rdvS2;
	private JComboBox cbxNiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planning frame = new planning();
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
	public planning() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-1032)/2, (h-502)/2, 1032, 502);
		setTitle("Planninge d'examen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sp = String.valueOf(cbxSp.getSelectedItem());
				String niv = String.valueOf(cbxNiv.getSelectedItem());
				String sql = "SELECT DISTINCT NomModul,ordre "
						+ "FROM module M,ensei E, filiè F "
						+ "WHERE M.NumEns = E.ID "
						+ "AND F.ID = M.NumF "
						+ "AND Nomfil = '"+sp+"' "
						+ "AND niveau = '"+niv+"' AND "
						+ "semestre = 1 "; ; 	
				
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
		});
		contentPane.setBackground(new Color(36, 47, 65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel lblNewLabel_1 = new JLabel("Fili\u00E8re  :");
		lblNewLabel_1.setBounds(713, 129, 72, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Niveau :");
		lblMotDePasse.setBounds(713, 84, 62, 14);
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblMotDePasse);
		ImageIcon img = new ImageIcon(login.class.getResource("/img/plus.png"));
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/tools.png"));
		ImageIcon img3 = new ImageIcon(login.class.getResource("/img/supp.png"));
		
		
		cbxNiv = new JComboBox();
		cbxNiv.setBounds(785, 75, 170, 32);
		cbxNiv.setModel(new DefaultComboBoxModel(new String[] {"Licence 1", "Licence 2", "Licence 3", "Master 1"}));
		cbxNiv.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		contentPane.add(cbxNiv);
		
		rdbtnSt = new JRadioButton("ST");
		rdbtnSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radiobtn();
			}
		});
		rdbtnSt.setForeground(Color.WHITE);
		rdbtnSt.setBounds(783, 125, 56, 23);
		rdbtnSt.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSt.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnSt.setBackground(new Color(36, 47, 65));
		contentPane.add(rdbtnSt);
		
		rdbtnSm = new JRadioButton("SM");
		rdbtnSm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radiobtn();
			}
		});
		rdbtnSm.setForeground(Color.WHITE);
		rdbtnSm.setBounds(841, 125, 56, 23);
		rdbtnSm.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSm.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnSm.setBackground(new Color(36, 47, 65));
		contentPane.add(rdbtnSm);
		
		rdbtnMi = new JRadioButton("MI");
		rdbtnMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radiobtn();
			}
		});
		rdbtnMi.setForeground(Color.WHITE);
		rdbtnMi.setBounds(899, 125, 56, 23);
		rdbtnMi.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMi.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnMi.setBackground(new Color(36, 47, 65));
		contentPane.add(rdbtnMi);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSt);
		buttonGroup.add(rdbtnSm);
		buttonGroup.add(rdbtnMi);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9 :");
		lblSpcialit.setBounds(400, 82, 90, 14);
		lblSpcialit.setForeground(Color.WHITE);
		lblSpcialit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblSpcialit);
		
		cbxSp = new JComboBox();
		cbxSp.setBounds(493, 75, 170, 32);
		contentPane.add(cbxSp);
		RemplirJComb();
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 0, 1032, 39);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		//panel_8.setBackground(new Color(97, 212, 195));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 48, 37);
		panel_9.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/logod.png"));
		lblNewLabel_2.setIcon(img2);
		
		JLabel lblGesionDesEnseignats = new JLabel("Planning d'examens");
		lblGesionDesEnseignats.setBounds(58, 0, 905, 37);
		panel_9.add(lblGesionDesEnseignats);
		lblGesionDesEnseignats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGesionDesEnseignats.setForeground(Color.BLACK);
		lblGesionDesEnseignats.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel label_11 = new JLabel("\u0640\u0640\u0640");
		label_11.setBounds(963, 0, 29, 37);
		panel_9.add(label_11);
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
		panel_9.add(lblX);
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
		panel_7.setBounds(200, 164, 828, 333);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(485, 64, 135, 240);
		panel_7.add(panel_3);
		
		lbl13 = new JLabel("");
		lbl13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl13.setBounds(0, 0, 135, 40);
		panel_3.add(lbl13);
		
		lbl14 = new JLabel("");
		lbl14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl14.setBounds(0, 40, 135, 40);
		panel_3.add(lbl14);
		
		lbl15 = new JLabel("");
		lbl15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl15.setBounds(0, 80, 135, 40);
		panel_3.add(lbl15);
		
		lbl16 = new JLabel("");
		lbl16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl16.setBounds(0, 120, 135, 40);
		panel_3.add(lbl16);
		
		lbl17 = new JLabel("");
		lbl17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl17.setBounds(0, 160, 135, 40);
		panel_3.add(lbl17);
		
		lbl18 = new JLabel("");
		lbl18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl18.setBounds(0, 200, 135, 40);
		panel_3.add(lbl18);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(650, 64, 135, 240);
		panel_7.add(panel_4);
		
		lbl19 = new JLabel("");
		lbl19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl19.setBounds(0, 0, 135, 40);
		panel_4.add(lbl19);
		
		lbl20 = new JLabel("");
		lbl20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl20.setBounds(0, 40, 135, 40);
		panel_4.add(lbl20);
		
		lbl21 = new JLabel("");
		lbl21.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl21.setBounds(0, 80, 135, 40);
		panel_4.add(lbl21);
		
		lbl22 = new JLabel("");
		lbl22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl22.setBounds(0, 120, 135, 40);
		panel_4.add(lbl22);
		
		lbl23 = new JLabel("");
		lbl23.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl23.setBounds(0, 160, 135, 40);
		panel_4.add(lbl23);
		
		lbl24 = new JLabel("");		
		lbl24.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl24.setBounds(0, 200, 135, 40);
		panel_4.add(lbl24);
		
				
		JLabel lblSemestre = new JLabel("Semestre :");
		lblSemestre.setBounds(399, 124, 83, 14);
		lblSemestre.setForeground(Color.WHITE);
		lblSemestre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblSemestre);
		
		ButtonGroup b =new ButtonGroup();
		
		rdbS1 = new JRadioButton("01");

		rdbS1.setForeground(Color.WHITE);
		rdbS1.setBounds(492, 119, 70, 23);
		rdbS1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbS1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbS1.setBackground(new Color(36, 47, 65));
		contentPane.add(rdbS1);
		b.add(rdbS1);
		
		rdvS2 = new JRadioButton("02");
		rdvS2.setForeground(Color.WHITE);
		rdvS2.setBounds(564, 119, 70, 23);
		rdvS2.setHorizontalAlignment(SwingConstants.CENTER);
		rdvS2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdvS2.setBackground(new Color(36, 47, 65));
		contentPane.add(rdvS2);
		b.add(rdvS2);
		
		JLabel label_31 = new JLabel("");
		label_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modul m = new modul();
				m.setVisible(true);
				setVisible(false);
			}
		});
		label_31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_31.setBounds(221, 44, 62, 55);
		getContentPane().add(label_31);
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img4 = new ImageIcon(login.class.getResource("/img/back.png"));
		label_31.setIcon(img4);
		
		JLabel label_71 = new JLabel("");
		label_71.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cellul();
			}
		});
		label_71.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_71.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img7 = new ImageIcon(login.class.getResource("/img/refresh.png"));
		label_71.setIcon(img7);
		label_71.setBounds(965, 75, 67, 68);
		contentPane.add(label_71);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Infor i = new Infor();
				i.setVisible(true);
			}
		});
		btnModifier.setBounds(221, 102, 119, 39);
		contentPane.add(btnModifier);
		
		JScrollPane scrollPane_18 = new JScrollPane();
		scrollPane_18.setBounds(5, 44, 190, 455);
		contentPane.add(scrollPane_18);
		
		table = new JTable();
		scrollPane_18.setViewportView(table);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(97, 212, 195));
		panel.setBounds(200, 164, 828, 333);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Samedi");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label.setBounds(49, 68, 80, 20);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Dimanche");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_1.setBounds(49, 110, 80, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Lundi");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_2.setBounds(49, 152, 80, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Mardi");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_3.setBounds(49, 194, 80, 20);
		panel.add(label_3);
		
		JLabel label_10 = new JLabel("Mercredi");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_10.setBounds(49, 236, 80, 20);
		panel.add(label_10);
		
		JLabel label_12 = new JLabel("Jeudi");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_12.setBounds(49, 278, 80, 20);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("08.30 h -10.00h");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_13.setBounds(142, 25, 145, 20);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("10.30 h -12.00h");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_14.setBounds(307, 25, 145, 20);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("13.00 h -14.30h");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_15.setBounds(475, 25, 145, 20);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("15.00 h -16.30h");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_16.setBounds(640, 25, 145, 20);
		panel.add(label_16);
		
		JLabel lblSemaine = new JLabel("Semaine 1");
		lblSemaine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(false);
				panel_7.setVisible(true);
			}
		});
		lblSemaine.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSemaine.setBounds(10, 11, 119, 32);
		panel.add(lblSemaine);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(152, 64, 135, 240);
		panel.add(panel_5);
		
		lbl25 = new JLabel("");
		lbl25.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl25.setBounds(0, 0, 135, 40);
		panel_5.add(lbl25);
		
		lbl26 = new JLabel("");
		lbl26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl26.setBounds(0, 40, 135, 40);
		panel_5.add(lbl26);
		
		lbl27 = new JLabel("");
		lbl27.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl27.setBounds(0, 80, 135, 40);
		panel_5.add(lbl27);
		
		lbl28 = new JLabel("");
		lbl28.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl28.setBounds(0, 120, 135, 40);
		panel_5.add(lbl28);
		
		lbl29 = new JLabel("");
		lbl29.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl29.setBounds(0, 160, 135, 40);
		panel_5.add(lbl29);
		
		lbl30 = new JLabel("");
		lbl30.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl30.setBounds(0, 200, 135, 40);
		panel_5.add(lbl30);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(317, 64, 135, 240);
		panel.add(panel_6);
		
		lbl31 = new JLabel("");
		lbl31.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl31.setBounds(0, 0, 135, 40);
		panel_6.add(lbl31);
		
		lbl32 = new JLabel("");
		lbl32.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl32.setBounds(0, 40, 135, 40);
		panel_6.add(lbl32);
		
		lbl33 = new JLabel("");
		lbl33.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl33.setBounds(0, 80, 135, 40);
		panel_6.add(lbl33);
		
		lbl34 = new JLabel("");
		lbl34.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl34.setBounds(0, 120, 135, 40);
		panel_6.add(lbl34);
		
		lbl35 = new JLabel("");
		lbl35.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl35.setBounds(0, 160, 135, 40);
		panel_6.add(lbl35);
		
		lbl36 = new JLabel("");
		lbl36.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl36.setBounds(0, 200, 135, 40);
		panel_6.add(lbl36);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(485, 64, 135, 240);
		panel.add(panel_8);
		
		lbl37 = new JLabel("");
		lbl37.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl37.setBounds(0, 0, 135, 40);
		panel_8.add(lbl37);
		
		lbl38 = new JLabel("");
		lbl38.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl38.setBounds(0, 40, 135, 40);
		panel_8.add(lbl38);
		
		lbl39 = new JLabel("");
		lbl39.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl39.setBounds(0, 80, 135, 40);
		panel_8.add(lbl39);
		
		lbl40 = new JLabel("");
		lbl40.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl40.setBounds(0, 120, 135, 40);
		panel_8.add(lbl40);
		
		lbl41 = new JLabel("");
		lbl41.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl41.setBounds(0, 160, 135, 40);
		panel_8.add(lbl41);
		
		lbl42 = new JLabel("");
		lbl42.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl42.setBounds(0, 200, 135, 40);
		panel_8.add(lbl42);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(650, 64, 135, 240);
		panel.add(panel_10);
		
		lbl43 = new JLabel("");
		lbl43.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl43.setBounds(0, 0, 135, 40);
		panel_10.add(lbl43);
		
		lbl44 = new JLabel("");
		lbl44.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl44.setBounds(0, 40, 135, 40);
		panel_10.add(lbl44);
		
		lbl45 = new JLabel("");
		lbl45.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl45.setBounds(0, 80, 135, 40);
		panel_10.add(lbl45);
		
		lbl46 = new JLabel("");
		lbl46.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl46.setBounds(0, 120, 135, 40);
		panel_10.add(lbl46);
		
		lbl47 = new JLabel("");
		lbl47.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl47.setBounds(0, 160, 135, 40);
		panel_10.add(lbl47);
		
		lbl48 = new JLabel("");
		lbl48.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl48.setBounds(0, 200, 135, 40);
		panel_10.add(lbl48);
		
		panel.setVisible(false);
		
		UpdateTable();
		
		//panel_7.setVisible(false);
	}

	public void radiobtn() {
		if(rdbtnSt.isSelected()){
			cbxSp.removeAllItems();
			String sql = "SELECT DISTINCT  Nomfil,ID FROM filiè WHERE spécialité = 'ST';"; 			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
				pst = con.prepareStatement(sql);		
				rs = pst.executeQuery(sql);
				while (rs.next()) {
					String type= rs.getString("Nomfil").toString();
					cbxSp.addItem(type);
					int id= rs.getInt("ID");
					model.addElement(new Item(id, type));
					cbxSp.setModel(model);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(rdbtnSm.isSelected()){
			cbxSp.removeAllItems();
			String sql = "SELECT DISTINCT Nomfil,ID FROM filiè WHERE spécialité = 'SM';"; 			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
				pst = con.prepareStatement(sql);		
				rs = pst.executeQuery(sql);
				while (rs.next()) {
					String type= rs.getString("Nomfil").toString();
					cbxSp.addItem(type);
					int id= rs.getInt("ID");
					model1.addElement(new Item(id, type));
					cbxSp.setModel(model1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else {
		//	cbxSp.setSelectedItem(null);
		}
		if(rdbtnMi.isSelected()){
			cbxSp.removeAllItems();
			String sql = "SELECT DISTINCT * FROM filiè WHERE spécialité = 'MI';"; 			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
				pst = con.prepareStatement(sql);		
				rs = pst.executeQuery(sql);
				while (rs.next()) {
					String type= rs.getString("Nomfil").toString();
					cbxSp.addItem(type);
					int id= rs.getInt("ID");
					model2.addElement(new Item(id, type));
					cbxSp.setModel(model2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}		
	@SuppressWarnings("unchecked")
	public void RemplirJComb(){
			
			String sql = "SELECT DISTINCT Nomfil FROM filiè"; 			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
				pst = con.prepareStatement(sql);		
				rs = pst.executeQuery(sql);
				while (rs.next()) {
					String type= rs.getString("Nomfil").toString();
					cbxSp.addItem(type);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
					
		}
		public void UpdateTable(){
		
		String sql = "SELECT * FROM `ordre`"; 			
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
		public void UpdateEmp(JLabel l,int i,String j ,String h) {
			
			String sql = "SELECT NomModul FROM emploi P,module M WHERE semaine='"+i+"' AND Jour = '"+j+"' AND temps = '"+h+"' AND M.ID = P.NumM; "; 			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
				pst = con.prepareStatement(sql);		
				rs = pst.executeQuery(sql);
				while (rs.next()) {
					String ty= rs.getString("NomModul").toString();
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
			UpdateEmp(lbl48,2,"Jeudi" ,"15.00 h -16.30h");
			
			/*		 */
		}
	}
