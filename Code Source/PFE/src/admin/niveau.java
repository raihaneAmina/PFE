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

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class niveau extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private Connection con = null; 		
	private java.sql.PreparedStatement pst = null;		
	private ResultSet rs = null;
	private JTable table;
	private JTextField ID;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSp;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxniv;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxfil;
	private JTextField txtetd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					niveau frame = new niveau();
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
	public niveau() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((w-1053)/2, (h-502)/2, 1032, 502);
		setTitle("Gestion des Spécialités");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97,212,195));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Fili\u00E8re  :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(211, 171, 72, 14);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMotDePasse = new JLabel("Niveau :");
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblMotDePasse.setBounds(211, 277, 62, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblEmail = new JLabel("L'identifiant :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(291, 105, 102, 14);
		contentPane.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 83, 466, 378);
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
		
		
		ID = new JTextField();
		ID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (ID.getText().equals("") ||
						ID.getText().equals("Entrer le nom de module"))
					{
					ID.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  ID.getText().trim().equals("") ||
						ID.getText().trim().toLowerCase().equals("Entrer le nom de module") )
				{
					
					ID.setText("Entrer le nom de module");
					
				}
				
			}
		});
		ID.setToolTipText("");
		ID.setText("ID");
		ID.setForeground(Color.DARK_GRAY);
		ID.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		ID.setColumns(10);
		ID.setCaretColor(Color.WHITE);
		ID.setBorder(null);
		ID.setBackground(new Color(97, 212, 195));
		ID.setBounds(399, 103, 78, 20);
		contentPane.add(ID);
		
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
				panel_6.setBackground(new Color(36, 48, 66));
			}			
			public void mouseClicked(MouseEvent arg0) {
				salle m = new salle();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.setBounds(0, 262, 197, 47);
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
				panel_2.setBackground(new Color(27, 36, 49));
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
		UpdateTable();
		
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
		
		JLabel lblcpt = new JLabel("Gestion des Sp\u00E9cialit\u00E9s");
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
		
		cbxniv = new JComboBox();
		cbxniv.setModel(new DefaultComboBoxModel(new String[] {"Licence 1", "Licence 2", "Licence 3", "Master 1"}));
		cbxniv.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxniv.setBounds(331, 269, 193, 32);
		contentPane.add(cbxniv);
		
		@SuppressWarnings("unused")
		ButtonGroup buttonGroup = new ButtonGroup();
		
		@SuppressWarnings("unused")
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9 :");
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSpcialit.setBounds(211, 227, 84, 14);
		contentPane.add(lblSpcialit);
		
		cbxSp = new JComboBox();
		cbxSp.setBounds(331, 165, 193, 32);
		contentPane.add(cbxSp);
		RemplirJComb();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(222, 134, 293, 14);
		contentPane.add(separator_1);
		
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
		
		cbxfil = new JComboBox();
		cbxfil.setModel(new DefaultComboBoxModel(new String[] {"ST", "SM", "MI"}));
		cbxfil.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxfil.setBounds(331, 219, 193, 32);
		contentPane.add(cbxfil);
		
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
		
		JLabel lblNbrDeudiants = new JLabel("Nbr d'eudiants:");
		lblNbrDeudiants.setForeground(Color.BLACK);
		lblNbrDeudiants.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNbrDeudiants.setBounds(207, 327, 117, 14);
		contentPane.add(lblNbrDeudiants);
		
		txtetd = new JTextField();
		txtetd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (txtetd.getText().equals("") ||
						txtetd.getText().equals("Entrer le nbr d'etudiant"))
					{
					txtetd.setText(null);
					}
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (  txtetd.getText().trim().equals("") ||
						txtetd.getText().trim().toLowerCase().equals("Entrer le nbr d'etudiant") )
				{
					
					txtetd.setText("Entrer le nbr d'etudiant");
					
				}
				
			}
		});
		txtetd.setToolTipText("");
		txtetd.setText("Entrer le nbr d'etudiant");
		txtetd.setForeground(Color.DARK_GRAY);
		txtetd.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		txtetd.setColumns(10);
		txtetd.setCaretColor(Color.WHITE);
		txtetd.setBorder(null);
		txtetd.setBackground(new Color(97, 212, 195));
		txtetd.setBounds(334, 325, 189, 20);
		contentPane.add(txtetd);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(324, 358, 201, 3);
		contentPane.add(separator_3);
		
	}

	public void UpdateTable(){
		
		String sql = "SELECT * FROM filiè";
	/*	String sql = "SELECT NomPren, Nomfil,NomUti "
				+ "FROM filiè F,délégué D ,compt C "
				+ "WHERE D.NumF = F.ID"
				+ " AND C.NomUtil = D.NomUti ;";*/
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
	
	public void Select() {
		int ligne=table.getSelectedRow();
		//JOptionPane.showMessageDialog(null, ligne);
		int i = (Integer)table.getModel().getValueAt(ligne, 0);
		String id= String.valueOf(i);
	    String id1 = (String)table.getModel().getValueAt(ligne, 1);
		String id2 = (String)table.getModel().getValueAt(ligne, 2);
		String id3 = (String)table.getModel().getValueAt(ligne, 3);
		int nbr = (Integer)table.getModel().getValueAt(ligne, 4);
		String nbre= String.valueOf(nbr);
		
		ID.setText(id);
		cbxSp.setSelectedItem(id1);
		cbxniv.setSelectedItem(id3);
		cbxfil.setSelectedItem(id2);
		if (nbre != null) {
		txtetd.setText(nbre);
		}
	}
}
