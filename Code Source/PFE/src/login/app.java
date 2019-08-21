package login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import admin.compt;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })
public class app extends JFrame {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
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
	public app() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((w-851)/2, (h-541)/2, 851, 541);
		setTitle("Systeme Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logoa.png").getFile()));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,47,65));
		panel_1.setBounds(0, 225, 851, 316);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel.setBackground(new Color(140, 160, 192));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel.setBackground(new Color(97,212,195));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				compt m = new compt();
				m.setVisible(true);
				setVisible(false);
			}
		});
		panel.setBackground(new Color(97,212,195));
		panel.setBounds(58, 68, 209, 209);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		ImageIcon img = new ImageIcon(login.class.getResource("/img/calendar (1).png"));
		label_3.setIcon(img);
		//label_3.setIcon(new ImageIcon("C:\\Users\\Rihane\\Downloads\\calendar (1).png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 11, 189, 132);
		panel.add(label_3);
		
		JLabel lblCre = new JLabel("G\u00E9rer l'emplois\r\n");
		lblCre.setHorizontalAlignment(SwingConstants.CENTER);
		lblCre.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblCre.setBounds(0, 124, 209, 37);
		panel.add(lblCre);
		
		JLabel lblDuTemps = new JLabel(" du Temps");
		lblDuTemps.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuTemps.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDuTemps.setBounds(0, 154, 209, 28);
		panel.add(lblDuTemps);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_3.setBackground(new Color(140, 160, 192));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_3.setBackground(new Color(97,212,195));
			}
		});
		panel_3.setBackground(new Color(97,212,195));
		panel_3.setBounds(319, 68, 209, 209);
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 11, 189, 132);
		panel_3.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img3 = new ImageIcon(login.class.getResource("/img/print (1).png"));
		label_2.setIcon(img3);
		
		JLabel lblImprimer = new JLabel("Imprimer");
		lblImprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblImprimer.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblImprimer.setBounds(0, 130, 209, 53);
		panel_3.add(lblImprimer);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				login l = new login();
				l.setVisible(true);
				
			}
		});
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_4.setBackground(new Color(140, 160, 192));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_4.setBackground(new Color(97,212,195));
			}
		});
		panel_4.setBackground(new Color(97, 212, 195));
		panel_4.setBounds(584, 68, 209, 209);
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		ImageIcon img4 = new ImageIcon(login.class.getResource("/img/cancel.png"));
		label_4.setIcon(img4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 11, 197, 132);
		panel_4.add(label_4);
		
		JLabel lblFermer = new JLabel("Fermer");
		lblFermer.setHorizontalAlignment(SwingConstants.CENTER);
		lblFermer.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblFermer.setBounds(0, 131, 209, 53);
		panel_4.add(lblFermer);
		
		JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & ALLALI Yasmine & RAIEB Rekia");
		lblSehalAminaRihane.setBounds(0, 295, 851, 17);
		panel_1.add(lblSehalAminaRihane);
		lblSehalAminaRihane.setForeground(Color.WHITE);
		lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 851, 227);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon img2 = new ImageIcon(login.class.getResource("/img/utilisateur.png"));
		label.setIcon(img2);	
		label.setBounds(535, 37, 262, 177);
		panel_2.add(label);
		
		JLabel lblNl = new JLabel("Gestion des emplois du temps");
		lblNl.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblNl.setBounds(160, 52, 393, 66);
		panel_2.add(lblNl);
		
		JLabel lblUniversitDjilaliBounaama = new JLabel("Universit\u00E9 Djilali Bounaama Khmis Miliana");
		lblUniversitDjilaliBounaama.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblUniversitDjilaliBounaama.setBounds(160, 111, 393, 28);
		panel_2.add(lblUniversitDjilaliBounaama);
		
		JLabel label_0 = new JLabel("Faculté Science et Technologie");
		label_0.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		label_0.setBounds(160, 145, 393, 28);
		panel_2.add(label_0);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img1 = new ImageIcon(login.class.getResource("/img/logoa.png"));
		lblNewLabel.setIcon(img1);
		lblNewLabel.setBounds(40,49,120, 123);
		panel_2.add(lblNewLabel);
		
	JLabel label_1 = new JLabel("\u0640\u0640\u0640");
	label_1.setBounds(784, 11, 29, 20);
	panel_2.add(label_1);
	label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	label_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseExited(MouseEvent arg0) {
			
			//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
			//label_1.setBorder(label_border);
			label_1.setForeground(new Color(36,47,65));
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			//Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
			//label_1.setBorder(label_border);
			label_1.setForeground(new Color(97,212,195));
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			setState(JFrame.ICONIFIED);
		}
	});
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setForeground(new Color(36,47,65));
	label_1.setFont(new Font("Arial", Font.BOLD, 18));
	
	JLabel lblX = new JLabel("x");
	lblX.setBounds(812, 11, 29, 20);
	panel_2.add(lblX);
	lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblX.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseExited(MouseEvent arg0) {
			
			lblX.setForeground(new Color(36,47,65));
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			lblX.setForeground(new Color(97,212,195));
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
			
		}
	});
	lblX.setHorizontalAlignment(SwingConstants.CENTER);
	lblX.setForeground(new Color(36,47,65));
	lblX.setFont(new Font("Arial", Font.BOLD, 18));

	}
}
