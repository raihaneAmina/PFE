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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

import FntrInfo.Item;
import login.app;
import login.login;
import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class modul extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private JTable table;
	private JTextField txtmodu;
	private JComboBox txtch;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSp;
	private JComboBox cbxNiv;
	private String sp;
	private String niv;
	private JTextField txtsem;
	private JRadioButton rdbtnSt;
	private JRadioButton rdbtnSm;
	private JRadioButton rdbtnMi;
	private DefaultComboBoxModel d;
	private DefaultComboBoxModel model = new DefaultComboBoxModel();
	private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model2 = new DefaultComboBoxModel();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modul frame = new modul();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public modul() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-1053)/2, (h-502)/2, 1032, 502);
		setTitle("Gestion des modules");
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
				panel_4.setBackground(new Color(27, 36, 49));
			}
		});
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBounds(0, 169, 197, 47);
		panel_4.setBackground(new Color(27, 36, 49));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblListeDesEnseignant = new JLabel("liste des modules");
		lblListeDesEnseignant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		panel_5.setBounds(0, 216, 197, 47);
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
		
		JLabel lblListeDesSalles = new JLabel("Gestion des salles");
		lblListeDesSalles.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesSalles.setForeground(Color.WHITE);
		lblListeDesSalles.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListeDesSalles.setBounds(10, 11, 153, 25);
		panel_6.add(lblListeDesSalles);
		
		JLabel lblKeeptoo = new JLabel("GETE");
		lblKeeptoo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeeptoo.setBounds(52, 25, 100, 37);
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
		JLabel lblNewLabel_1 = new JLabel("Fili\u00E8re  :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(242, 80, 72, 14);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Niveau :");
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(801, 80, 62, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblEmail = new JLabel("le module   :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(230, 174, 109, 14);
		contentPane.add(lblEmail);
		
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
			
		/*		if (txtmodu.getText().equals("Entrer le nom de module")  || 
						txtch.getText().equals("Entrer le nom de module")  || 
						txtsem.getText().equals("txtsem")||
						txtmodu.getText().equals("")  || 
						txtch.getText().equals("")  || 
						txtsem.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "insérer les donnée");
				}
			else {
				String modu= txtmodu.getText();
				String charg=txtch.getText().toString();
				String sem= txtsem.getText().toString();
				int se=Integer.parseInt(sem);
				String spe= cbxSp.getSelectedItem().toString();
				String ni= cbxNiv.getSelectedItem().toString();}	
		/*		String type2= comboBox.getSelectedItem().toString();
			
					try {
					
					String sql = "INSERT INTO `compt`(`ID`, `NomUtil`, `MotDePasse`, `Type`) VALUES('"+id+"','"+user+"','"+pass+"','"+type2+"')";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
					pst = con.prepareStatement(sql);		
					pst.execute();					
					JOptionPane.showMessageDialog(null, "Compte insérer ");
				    txtID.setText("l'identifiant d'utilisateur");
					txtUser.setText("Entrer le nom d'utilisateur");
					txtPass.setText("Entrer le mot de passe");
					UpdateTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
				}
			 * 	
			 */
				
				 		
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
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(324, 199, 201, 3);
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
		scrollPane.setBounds(544, 132, 478, 325);
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
		
		txtmodu = new JTextField();
		txtmodu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtch.requestFocus();
					
				}
				
			}
		});
		txtmodu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtmodu.getText().equals("") ||
						txtmodu.getText().equals("Entrer le nom de module"))
					{
					txtmodu.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtmodu.getText().trim().equals("") ||
						txtmodu.getText().trim().toLowerCase().equals("Entrer le nom de module") )
				{
					
					txtmodu.setText("Entrer le nom de module");
					
				}
				
			}
		});
		txtmodu.setToolTipText("");
		txtmodu.setText("Entrer le nom de module");
		txtmodu.setForeground(Color.DARK_GRAY);
		txtmodu.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtmodu.setColumns(10);
		txtmodu.setCaretColor(Color.WHITE);
		txtmodu.setBorder(null);
		txtmodu.setBackground(new Color(97, 212, 195));
		txtmodu.setBounds(334, 172, 189, 20);
		contentPane.add(txtmodu);
		
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
		
		JLabel lblcpt = new JLabel("Gestion des modules");
		lblcpt.setBounds(101, 0, 862, 37);
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
		
		cbxNiv = new JComboBox();
		cbxNiv.setModel(new DefaultComboBoxModel(new String[] {"Licence 1", "Licence 2", "Licence 3", "Master 1"}));
		cbxNiv.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxNiv.setBounds(873, 75, 97, 30);
		contentPane.add(cbxNiv);
		
		rdbtnSt = new JRadioButton("ST");
		rdbtnSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radiobtn();
			}
		});
		rdbtnSt.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSt.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnSt.setBackground(new Color(97,212,195));
		rdbtnSt.setBounds(306, 80, 56, 14);
		contentPane.add(rdbtnSt);
		
		rdbtnSm = new JRadioButton("SM");
		rdbtnSm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radiobtn();
			}
		});
		rdbtnSm.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSm.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnSm.setBackground(new Color(97, 212, 195));
		rdbtnSm.setBounds(359, 80, 56, 14);
		contentPane.add(rdbtnSm);
		
		rdbtnMi = new JRadioButton("MI");
		rdbtnMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radiobtn();
			}
		});
		rdbtnMi.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMi.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtnMi.setBackground(new Color(97, 212, 195));
		rdbtnMi.setBounds(417, 80, 56, 14);
		contentPane.add(rdbtnMi);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSt);
		buttonGroup.add(rdbtnSm);
		buttonGroup.add(rdbtnMi);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9 :");
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSpcialit.setBounds(483, 80, 90, 14);
		contentPane.add(lblSpcialit);
		
		cbxSp = new JComboBox();
		//RemplirJComb();
		cbxSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//radiobtn();
			}
		});
		cbxSp.setBounds(583, 75, 208, 30);
		contentPane.add(cbxSp);
		
		
		d = new DefaultComboBoxModel();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(232, 133, 293, 14);
		contentPane.add(separator_1);
		
		JLabel lblCredit = new JLabel("charger de");
		lblCredit.setForeground(Color.BLACK);
		lblCredit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblCredit.setBounds(230, 235, 94, 18);
		contentPane.add(lblCredit);
		
		txtch = new JComboBox();
		txtch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtsem.requestFocus();
					
				}
				if (arg0.getKeyCode()==KeyEvent.VK_UP) {
					
					txtmodu.requestFocus();
					
				}
				
			}
		});
		txtch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			/*	if (txtch.getText().equals("") ||
						txtch.getText().equals("Entrer charger de cours"))
					{
				//	txtch.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
			/*	if (  txtch.getText().trim().equals("") ||
						txtch.getText().trim().toLowerCase().equals("Entrer charger de cours") )
				{
					
					txtch.setText("Entrer charger de cours");
					
				}
				*/
			}
		});
		txtch.setToolTipText("");
	//	txtch.setText("Entrer charger de cours");
		txtch.setForeground(Color.DARK_GRAY);
		txtch.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	//	txtch.setColumns(10);
	//	txtch.setCaretColor(Color.WHITE);
		txtch.setBorder(null);
	//	txtch.setBackground(new Color(97, 212, 195));
		txtch.setBounds(324, 235, 201, 35);
		contentPane.add(txtch);
		 ens();
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblGestionDesComptes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestionDesComptes.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestionDesComptes.setForeground(Color.WHITE);
		lblGestionDesComptes.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblGestionDesComptes.setBounds(10, 11, 153, 25);
		panel_3.add(lblGestionDesComptes);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(324, 281, 201, 3);
		contentPane.add(separator_2);
		
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
		
		JLabel lblCours = new JLabel("cours:");
		lblCours.setHorizontalAlignment(SwingConstants.CENTER);
		lblCours.setForeground(Color.BLACK);
		lblCours.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblCours.setBounds(230, 255, 94, 18);
		contentPane.add(lblCours);
		
		JLabel lblSemestre = new JLabel("Semestre   :");
		lblSemestre.setForeground(Color.BLACK);
		lblSemestre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSemestre.setBounds(230, 327, 109, 14);
		contentPane.add(lblSemestre);
		
		txtsem = new JTextField();
		txtsem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if ((arg0.getKeyCode()==KeyEvent.VK_ENTER)|| arg0.getKeyCode()==KeyEvent.VK_DOWN) {
					
					txtch.requestFocus();
					
				}
				
			}
		});
		txtsem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtsem.getText().equals("") ||
						txtsem.getText().equals("Entrer le semestre"))
					{
					txtsem.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtsem.getText().trim().equals("") ||
						txtsem.getText().trim().toLowerCase().equals("Entrer le semestre") )
				{
					
					txtsem.setText("Entrer le semestre");
					
				}
				
			}
		});
		txtsem.setToolTipText("");
		txtsem.setText("Entrer le semestre");
		txtsem.setForeground(Color.DARK_GRAY);
		txtsem.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtsem.setColumns(10);
		txtsem.setCaretColor(Color.WHITE);
		txtsem.setBorder(null);
		txtsem.setBackground(new Color(97, 212, 195));
		txtsem.setBounds(334, 325, 189, 20);
		contentPane.add(txtsem);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(324, 358, 201, 3);
		contentPane.add(separator_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sp = String.valueOf(cbxSp.getSelectedItem());
				String niv = String.valueOf(cbxNiv.getSelectedItem());
				String sql = "SELECT DISTINCT NomModul,NomPren,semestre "
						+ "FROM module M,ensei E, filiè F "
						+ "WHERE M.NumEns = E.ID "
						+ "AND F.ID = M.NumF "
						+ "AND Nomfil = '"+sp+"' "
						+ "AND niveau = '"+niv+"' "; ; 	
				
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
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img4 = new ImageIcon(login.class.getResource("/img/refresh.png"));
		label_4.setIcon(img4);
		label_4.setBounds(980, 70, 42, 32);
		contentPane.add(label_4);
		
		
	}
	public void Select() {
		int ligne=table.getSelectedRow();
		//JOptionPane.showMessageDialog(null, ligne);
		String id= (String)table.getModel().getValueAt(ligne, 0);
	    String id1 = (String)table.getModel().getValueAt(ligne, 1);
	    int i2 = (Integer)table.getModel().getValueAt(ligne, 2);
		String id2= String.valueOf(i2);
		
		
		
		txtmodu.setText(id);
		txtch.setSelectedItem(id1);
		txtsem.setText(id2);
		
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
		
       
		
		
		String sql = "SELECT DISTINCT NomModul,NomPren,semestre "
				+ "FROM module M,ensei E, filiè F "
				+ "WHERE M.NumEns = E.ID "
				+ "AND F.ID = M.NumF "
				+ "AND Nomfil = '"+sp+"' "
				+ "AND niveau = '"+niv+"' "; ; 	
		
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
	public void ens() {
		String sql = "SELECT DISTINCT NomPren FROM ensei"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String ty= rs.getString("NomPren").toString();
				txtch.addItem(ty);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}}
