package FntrInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import admin.planning;
import login.login;
import net.proteanit.sql.DbUtils;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class Infor extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;
	private JComboBox cbxmat;
	private JComboBox textField_1;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSurv;
	Connection con=null;
	java.sql.PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel panel;
	private JComboBox cbxSal;
	private JComboBox cbxjr;
	private JComboBox cbxh;
	private DefaultComboBoxModel model = new DefaultComboBoxModel();
	private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model2 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model3 = new DefaultComboBoxModel();
	private DefaultComboBoxModel model4 = new DefaultComboBoxModel();
	private JRadioButton radioButton;
	private JRadioButton radioButton2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Infor frame = new Infor();
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
	public Infor() {
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
		setBounds(((w-471)/2), (h-528)/2, 471, 528);
		setTitle("Systeme Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36,47,65));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//ImageIcon imgl = new ImageIcon(login.class.getResource("/img/logob.png"));
		ImageIcon img = new ImageIcon(login.class.getResource("/img/timetable.png"));
		ImageIcon imgl = new ImageIcon(login.class.getResource("/img/logob.png"));
		JLabel lblmod = new JLabel("la mati\u00E8re");
		lblmod.setForeground(Color.WHITE);
		lblmod.setBounds(92, 269, 77, 14);
		lblmod.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(lblmod);
		
		ButtonGroup b = new ButtonGroup();
		
		radioButton = new JRadioButton("01");
		radioButton.setForeground(Color.WHITE);
		radioButton.setBounds(111, 201, 50, 23);
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		radioButton.setBackground(new Color(36, 47, 65));
		contentPane.add(radioButton);
		b.add(radioButton);
		
		radioButton2 = new JRadioButton("02");
		radioButton2.setForeground(Color.WHITE);
		radioButton2.setBounds(163, 201, 41, 23);
		radioButton2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		radioButton2.setBackground(new Color(36, 47, 65));
		contentPane.add(radioButton2);
		b.add(radioButton2);
		
		cbxmat = new JComboBox();
		cbxmat.setForeground(Color.BLACK);
		cbxmat.setToolTipText("");
		cbxmat.setBorder(null);
		contentPane.add(cbxmat);

		
		
		cbxmat.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxmat.setBounds(193, 257, 192, 39);
		contentPane.add(cbxmat);
		RemplirSalle();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(90, 306, 293, 3);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(92, 366, 291, 3);
		contentPane.add(separator_1);
		
		JButton btnConnexion = new JButton("Enregestrie");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
					
				btnConnexion.setBackground(new Color(140, 160, 192));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnConnexion.setBackground(new Color(97,212,195));
				}
			});
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				empl();
		}
					});
		btnConnexion.setBackground(new Color(97,212,195));
		btnConnexion.setBounds(76, 439, 150, 50);
		btnConnexion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		contentPane.add(btnConnexion);
		
		JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & ALLALI Yasmine & RAIEB Rekia");
		lblSehalAminaRihane.setBounds(0, 500, 655, 28);
		contentPane.add(lblSehalAminaRihane);
		lblSehalAminaRihane.setForeground(Color.WHITE);
		lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
		
		cbxSurv = new JComboBox();
		cbxSurv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((Item)cbxSurv.getSelectedItem()).getId();
				JOptionPane.showMessageDialog(null, i);
			}
		});
		cbxSurv.setFocusTraversalPolicyProvider(true);
		cbxSurv.setFocusCycleRoot(true);
		cbxSurv.setBorder(null);
		cbxSurv.setForeground(Color.BLACK);
		//comboBox.setBackground(new Color(97,212,195));
		cbxSurv.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxSurv.setBounds(193, 320, 192, 35);
		contentPane.add(cbxSurv);
		RemplirSurv();
		
		JLabel lblsrérv = new JLabel("s\u00E9rveillant 1");
		lblsrérv.setHorizontalAlignment(SwingConstants.LEFT);
		lblsrérv.setForeground(Color.WHITE);
		lblsrérv.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblsrérv.setBounds(92, 320, 103, 35);
		contentPane.add(lblsrérv);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(92, 426, 291, 2);
		contentPane.add(separator_2);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.GRAY, null, null));
		panel.setBounds(0, 0, 655, 97);
		panel.setBackground(new Color(97,212,195));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(428, 11, 29, 20);
		panel.add(lblX);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				lblX.setForeground(Color.black);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblX.setForeground(new Color(140, 160, 192));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("\u0640\u0640\u0640");
		label_1.setBounds(400, 11, 29, 20);
		panel.add(label_1);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				//label_1.setBorder(label_border);
				label_1.setForeground(Color.black);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				//label_1.setBorder(label_border);
				label_1.setForeground(new Color(140, 160, 192));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(15, -9, 90, 104);
		panel.add(lblNewLabel_2);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/logob.png"));
		lblNewLabel_2.setIcon(img2);
		
		JLabel lblNewLabel = new JLabel("Choisie les informations");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 11, 366, 73);
		panel.add(lblNewLabel);
		
		JLabel lblLeJour = new JLabel("le jour");
		lblLeJour.setForeground(Color.WHITE);
		lblLeJour.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLeJour.setBounds(25, 134, 77, 39);
		contentPane.add(lblLeJour);
		
		cbxjr = new JComboBox();
		cbxjr.setModel(new DefaultComboBoxModel(new String[] {"Samedi", "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi"}));
		cbxjr.setToolTipText("");
		cbxjr.setForeground(Color.BLACK);
		cbxjr.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxjr.setBorder(null);
		cbxjr.setBounds(90, 134, 134, 39);
		contentPane.add(cbxjr);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(25, 183, 429, 3);
		contentPane.add(separator_3);
		
		JLabel lblLheur = new JLabel("\u00E0 l'heur");
		lblLheur.setForeground(Color.WHITE);
		lblLheur.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLheur.setBounds(234, 136, 77, 35);
		contentPane.add(lblLheur);
		
		cbxh = new JComboBox();
		cbxh.setModel(new DefaultComboBoxModel(new String[] {"08.30 h -10.00h", "10.30 h -11.00h", "10.30 h -12.00h", "13.00 h -14.30h", "15.00 h -16.30h"}));
		cbxh.setToolTipText("");
		cbxh.setForeground(Color.BLACK);
		cbxh.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxh.setBorder(null);
		cbxh.setBounds(303, 134, 150, 39);
		contentPane.add(cbxh);
		
		JLabel lblSrveillant = new JLabel("Salle");
		lblSrveillant.setHorizontalAlignment(SwingConstants.LEFT);
		lblSrveillant.setForeground(Color.WHITE);
		lblSrveillant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSrveillant.setBounds(92, 380, 103, 35);
		contentPane.add(lblSrveillant);
		
		cbxSal = new JComboBox();
		cbxSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i1 = ((Item)cbxSal.getSelectedItem()).getId();
				JOptionPane.showMessageDialog(null, i1);
			}
		});
		cbxSal.setForeground(Color.BLACK);
		cbxSal.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cbxSal.setFocusTraversalPolicyProvider(true);
		cbxSal.setFocusCycleRoot(true);
		cbxSal.setBorder(null);
		cbxSal.setBounds(193, 380, 192, 35);
		contentPane.add(cbxSal);
		RemplirSurv1();
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnAnnuler.setBackground(new Color(97, 212, 195));
		btnAnnuler.setBounds(255, 439, 150, 50);
		contentPane.add(btnAnnuler);
		
		JLabel lblLaSemaine = new JLabel("la semaine");
		lblLaSemaine.setForeground(Color.WHITE);
		lblLaSemaine.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLaSemaine.setBounds(25, 196, 97, 28);
		contentPane.add(lblLaSemaine);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(25, 238, 429, 8);
		contentPane.add(separator_4);
		
		ButtonGroup b2 = new ButtonGroup();
		
		JRadioButton radioButton_1 = new JRadioButton("02");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql;
				if((radioButton_1).isSelected()) {
				sql = "SELECT DISTINCT * FROM module WHERE semestre = 2"; 
			}else {
				sql = "SELECT DISTINCT * FROM module WHERE semestre = 1";
			}
				RemplirJComb(sql);
			}
		});
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		radioButton_1.setBackground(new Color(36, 47, 65));
		radioButton_1.setBounds(412, 201, 41, 23);
		contentPane.add(radioButton_1);
		b2.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("01");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql;
				if((radioButton_2).isSelected()) {
				sql = "SELECT DISTINCT * FROM module WHERE semestre = 1"; 
			}else {
				sql = "SELECT DISTINCT * FROM module WHERE semestre = 2";
			}
				RemplirJComb(sql);
			}
		});
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		radioButton_2.setBackground(new Color(36, 47, 65));
		radioButton_2.setBounds(360, 201, 50, 23);
		contentPane.add(radioButton_2);
		b2.add(radioButton_2);
		
		JLabel lblSemestre = new JLabel("semestre");
		lblSemestre.setForeground(Color.WHITE);
		lblSemestre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSemestre.setBounds(274, 196, 97, 28);
		contentPane.add(lblSemestre);
		
		
	}   	
	

	@SuppressWarnings("unchecked")
	public void RemplirJComb(String s){
		
		cbxmat.removeAllItems();							
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(s);		
			rs = pst.executeQuery(s);
			while (rs.next()) {
				String type= rs.getString("NomModul").toString();
				int id= rs.getInt("ID");
				model4.addElement(new Item(id, type));
				cbxmat.setModel(model4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	
	public void RemplirSalle(){
		
		String sql = "SELECT DISTINCT NomSalle FROM salle"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String type= rs.getString("NomSalle").toString();
				
				//cbxSal.addItem(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
				
	}
	
	public void RemplirSurv(){
		
		String sql = "SELECT DISTINCT ID,NomPren FROM ensei"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String type= rs.getString("NomPren").toString();
				int id= rs.getInt("ID");
				model.addElement(new Item(id, type));
				cbxSurv.setModel(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
				
	}
public void RemplirSurv1(){
	/*String sql = "SELECT DISTINCT NomSalle FROM salle"; 			
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
		pst = con.prepareStatement(sql);		
		rs = pst.executeQuery(sql);
		while (rs.next()) {
			String type= rs.getString("NomSalle").toString();
			int id= rs.getInt("ID");
			model1.addElement(new Item(id, type));
			cbxSal.setModel(model1);
			//cbxSal.addItem(type);	*/
	
		String sql = "SELECT DISTINCT NomSalle,ID FROM salle"; 			
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
			pst = con.prepareStatement(sql);		
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				String type= rs.getString("NomSalle").toString();
				int id1= rs.getInt("ID");
				model1.addElement(new Item(id1, type));
				cbxSal.setModel(model1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
				
	}

public void empl() {

        String jr= cbxjr.getSelectedItem().toString();
        String hr=cbxh.getSelectedItem().toString();
        int mod = ((Item)cbxmat.getSelectedItem()).getId();  
        int sur = ((Item)cbxSurv.getSelectedItem()).getId();
        int sur1 = ((Item)cbxSal.getSelectedItem()).getId();
		try {
		int s = 2;
		if (radioButton.isSelected()) {
			s = 1;
		}
		if (radioButton2.isSelected()) {
			s = 2;
		}
		String sql = "INSERT INTO `emploi`(`Jour`, `temps`, `semaine`, `NumM`, `NumSurv`, `NumSurv1`) VALUES ('"+jr+"','"+hr+"',"+s+",'"+mod+"','"+sur+"','"+sur1+"')";
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","");
		pst = con.prepareStatement(sql);		
		pst.execute();					
		JOptionPane.showMessageDialog(null, "examen insérer ");

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 	
}
}