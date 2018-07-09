package UI_DES;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import 정보보안.DECRYPTION;
import 정보보안.Encryption;
import 정보보안.Password_Create;

public class UI extends JFrame {
	private ArrayList<Integer> e_p = new ArrayList<Integer>(); // e_p
	private ArrayList<Integer> ip_list = new ArrayList<Integer>();
	private ArrayList<Integer> ip = new ArrayList<Integer>();
	private ArrayList<Integer> ip_converse_list = new ArrayList<Integer>();
	private ArrayList<Integer> bit_key_8 = new ArrayList<Integer>();
	private ArrayList<Integer> bit_key_8_1 = new ArrayList<Integer>();
	private ArrayList<Integer> bit_key_8_2 = new ArrayList<Integer>();
	private ArrayList<Integer> p4 = new ArrayList<Integer>();
	private ArrayList<Integer> result1 = new ArrayList<Integer>();
	private ArrayList<String> lp_result = new ArrayList<String>();
	private ArrayList<String> lp_result1 = new ArrayList<String>();
	private ArrayList<String> lp_result2 = new ArrayList<String>();
	private ArrayList<String> lp_ip_converse = new ArrayList<String>();
	private ArrayList<String> sw_result = new ArrayList<String>();
	private ArrayList<String> lp_result_1 = new ArrayList<String>();
	private ArrayList<String> lp_result1_1 = new ArrayList<String>();
	private ArrayList<String> lp_result2_1 = new ArrayList<String>();
	private ArrayList<String> lp_ip_converse_1 = new ArrayList<String>();
	private ArrayList<String> sw_result_1 = new ArrayList<String>();
	int s1 = 0;
	int time2;
	int ex[] = new int[5];
	int ex1[] = new int[5];
	private Password_Create password_create;
	private JPanel contentPane;
	private JTextField tf_pl;
	private JTextField tf_key;
	private JTextField textField_2;
	private boolean paint_boolean = false;
	private JPanel pl_key_choice;
	private JLabel lb_result_pl;
	private JLabel lb_p10;
	private JLabel lb_Fk1;
	private JLabel lb_Shift1;
	private JLabel lb_Shift2;
	private JLabel lb_p8_k1;
	private JLabel lb_p8_k2;
	private Graphics2D g2d[];
	private Graphics2D g3d[];
	private Thread thread;
	private JLabel lb_ip;
	private JLabel lb_sw;
	private JLabel lb_sw_2;
	private JLabel lb_fk2;
	private JLabel lb_IP_1;
	private JLabel lb_IP_2;
	private JLabel lb_result;
	private JLabel lb_result1;
	private JLabel lb_Fk1_2;
	private JLabel lb_fk_2;
	private JLabel iP_2;
	private JLabel lb_result_1;
	private boolean chack1 = false;
	private boolean chack2 = false;
	private boolean chack3 = false;
	private int S0[][] = { { 1, 0, 3, 2 }, { 3, 2, 1, 0 }, { 0, 2, 1, 3 }, { 3, 1, 3, 2 } };
	private int S1[][] = { { 0, 1, 2, 3 }, { 2, 0, 1, 3 }, { 3, 0, 1, 0 }, { 2, 1, 0, 3 } };
	private String bit_key_10_input_name = "";
	String name = "";
	int count_task;
	int s;
	Timer m_timer[] = new Timer[3];
	HelpSet helpSet;
	HelpBroker helpBroker;
	private ArrayList<Integer> bit_key_10 = new ArrayList<Integer>();

	class JTextFieldLimit extends PlainDocument {
		private int limit;
		private boolean toUppercase = false;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
			this.toUppercase = upper;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}
			if ((getLength() + str.length()) <= limit) {
				if (toUppercase) {
					str = str.toUpperCase();
				}
				super.insertString(offset, str, attr);
			}
		}
	}

	public UI() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width / 2) - (this.getWidth() / 2), (dim.height / 2) - (this.getHeight() / 2));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 993);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		JLabel lblNewLabel = new JLabel("S-DES 암호화 알고리즘");
		lblNewLabel.setFont(new Font("궁서", 10, 50));
		lblNewLabel.setBounds(212, 0, 576, 72);
		lblNewLabel.setForeground(Color.GRAY);
		contentPane.add(lblNewLabel);

		pl_key_choice = new JPanel();
		pl_key_choice.setBounds(70, 90, 156, 87);
		contentPane.add(pl_key_choice);
		pl_key_choice.setLayout(null);
		pl_key_choice.setBorder(BorderFactory.createTitledBorder("평문을 입력하세요"));
		pl_key_choice.setBackground(Color.white);
		tf_pl = new JTextField();
		tf_pl.setBounds(31, 36, 113, 26);
		pl_key_choice.add(tf_pl);
		tf_pl.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("IP"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(70, 220, 156, 66);
		contentPane.add(panel_1);
		lb_ip = new JLabel("");
		lb_ip.setBounds(31, 25, 156, 30);
		lb_ip.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_1.add(lb_ip);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder("FK1"));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(70, 340, 156, 66);
		contentPane.add(panel_2);
		lb_Fk1 = new JLabel("");
		lb_Fk1.setBounds(31, 25, 156, 30);
		lb_Fk1.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_2.add(lb_Fk1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder("SW"));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(70, 460, 156, 66);
		contentPane.add(panel_3);
		lb_sw = new JLabel("");
		lb_sw.setBounds(31, 25, 156, 30);
		lb_sw.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_3.add(lb_sw);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder("FK2"));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(70, 580, 156, 66);
		contentPane.add(panel_4);
		lb_fk2 = new JLabel("");
		lb_fk2.setBounds(31, 25, 156, 30);
		lb_fk2.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_4.add(lb_fk2);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(BorderFactory.createTitledBorder("IP-1"));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(70, 700, 156, 66);
		contentPane.add(panel_5);
		lb_IP_1 = new JLabel("");
		lb_IP_1.setBounds(31, 25, 156, 30);
		lb_IP_1.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_5.add(lb_IP_1);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(BorderFactory.createTitledBorder("암호문"));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(70, 820, 156, 66);
		contentPane.add(panel_6);
		lb_result = new JLabel("");
		lb_result.setBounds(31, 25, 156, 30);
		lb_result.setFont(new Font("BOLD", Font.BOLD, 20));
		panel_6.add(lb_result);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(BorderFactory.createTitledBorder("KEY(0~1023)입력	"));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(333, 90, 156, 87);
		contentPane.add(panel_7);
		tf_key = new JTextField();
		tf_key.setColumns(10);
		tf_key.setBounds(31, 36, 94, 26);
		tf_key.setDocument((new JTextFieldLimit(5))); // 5글자 제한
		tf_key.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar(); // 무조건 숫자만 입력가능

				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (tf_key.getText().length() >= 4 && Integer.parseInt(tf_key.getText()) > 1023) {
					tf_key.setText("1023"); // 1024이상이거나 4자리넘게 입력시 자동으로 1023 설정
				}
				if (tf_key.getText().length() >= 0 && tf_key.getText().charAt(0) == '0') {
					tf_key.setText("0"); // 0___ 입력시 자동으로 0설정
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		panel_7.add(tf_key);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(BorderFactory.createTitledBorder("P10"));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(333, 220, 156, 66);
		contentPane.add(panel_8);
		lb_p10 = new JLabel("");
		lb_p10.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_p10.setBounds(31, 25, 156, 30);
		panel_8.add(lb_p10);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(BorderFactory.createTitledBorder("Shift"));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(333, 340, 156, 66);
		contentPane.add(panel_9);
		lb_Shift1 = new JLabel("");
		lb_Shift1.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_Shift1.setBounds(31, 25, 156, 30);
		panel_9.add(lb_Shift1);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(BorderFactory.createTitledBorder("P8"));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(333, 460, 156, 66);
		contentPane.add(panel_10);
		lb_p8_k1 = new JLabel("");
		lb_p8_k1.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_p8_k1.setBounds(31, 25, 156, 30);
		panel_10.add(lb_p8_k1);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(BorderFactory.createTitledBorder("Shift"));
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(333, 580, 156, 66);
		contentPane.add(panel_11);
		lb_Shift2 = new JLabel("");
		lb_Shift2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_Shift2.setBounds(31, 25, 156, 30);
		panel_11.add(lb_Shift2);

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(BorderFactory.createTitledBorder("P8"));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(333, 700, 156, 66);
		contentPane.add(panel_12);
		lb_p8_k2 = new JLabel("");
		lb_p8_k2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_p8_k2.setBounds(31, 25, 156, 30);
		panel_12.add(lb_p8_k2);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(BorderFactory.createTitledBorder("평문"));
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(582, 97, 156, 87);
		contentPane.add(panel_13);
		lb_result_pl = new JLabel("");
		lb_result_pl.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_result_pl.setBounds(31, 25, 156, 30);
		panel_13.add(lb_result_pl);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(BorderFactory.createTitledBorder("IP-1"));
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(582, 220, 156, 66);
		contentPane.add(panel_14);

		lb_IP_2 = new JLabel("");
		lb_IP_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_IP_2.setBounds(31, 25, 156, 30);
		panel_14.add(lb_IP_2);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(BorderFactory.createTitledBorder("FK1"));
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(582, 340, 156, 66);
		contentPane.add(panel_15);
		lb_Fk1_2 = new JLabel("");
		lb_Fk1_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_Fk1_2.setBounds(31, 25, 156, 30);
		panel_15.add(lb_Fk1_2);

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(BorderFactory.createTitledBorder("SW"));
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(582, 460, 156, 66);
		contentPane.add(panel_16);
		lb_sw_2 = new JLabel("");
		lb_sw_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_sw_2.setBounds(31, 25, 156, 30);
		panel_16.add(lb_sw_2);

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(BorderFactory.createTitledBorder("FK2"));
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(582, 580, 156, 66);
		contentPane.add(panel_17);
		lb_fk_2 = new JLabel("");
		lb_fk_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_fk_2.setBounds(31, 25, 156, 30);
		panel_17.add(lb_fk_2);

		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(BorderFactory.createTitledBorder("IP"));
		panel_18.setBackground(Color.WHITE);
		panel_18.setBounds(582, 700, 156, 66);
		contentPane.add(panel_18);
		iP_2 = new JLabel("");
		iP_2.setFont(new Font("Dialog", Font.BOLD, 20));
		iP_2.setBounds(31, 25, 156, 30);
		panel_18.add(iP_2);

		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBorder(BorderFactory.createTitledBorder("암호문"));
		panel_19.setBackground(Color.WHITE);
		panel_19.setBounds(582, 820, 156, 66);
		contentPane.add(panel_19);
		lb_result_1 = new JLabel("");
		lb_result_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_result_1.setBounds(31, 25, 156, 30);
		panel_19.add(lb_result_1);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chack1 = true;
				chack2 = true;
				if (tf_key.getText().equals("")) {
					chack2 = false;
					JOptionPane.showMessageDialog(null, " 키 값을 입력하세요.", "오류", JOptionPane.WARNING_MESSAGE);
				}
				if (tf_pl.getText().equals("")) {
					chack1 = false;
					JOptionPane.showMessageDialog(null, "평문을 입력하세요.", "오류", JOptionPane.WARNING_MESSAGE);
				}
				if (chack1 == true && chack2 == true) {
					btnNewButton.setEnabled(false);
					paint_boolean = true;
					Ip_create(); // S-BOX, P8, E/P ,IP, IP-1, P4 생성
					for (int i = 0; i < m_timer.length; i++) {
						m_timer[i] = new Timer();
					}

					int temp = 0;
					bit_key_10.removeAll(bit_key_10);
					bit_key_10_input_name = Integer.toBinaryString(Integer.parseInt(tf_key.getText()));
					if (bit_key_10_input_name.length() != 10) {
						temp = 10 - bit_key_10_input_name.length();
					}
					for (int j = 0; j < temp; j++) {
						bit_key_10.add(0);
					}
					for (int i = 0; i < bit_key_10_input_name.length(); i++) {
						bit_key_10.add(Integer.parseInt(String.valueOf(bit_key_10_input_name.charAt(i))));
					}

					repaint();
				}

			}

			private void Ip_create() {
				// TODO Auto-generated method stub
				ip_list.removeAll(ip_list);
				bit_key_8_2.removeAll(bit_key_8_2);
				ip_converse_list.removeAll(ip_converse_list);
				e_p.removeAll(e_p);
				p4.removeAll(p4);
				for (int i = 0; i < 8; i++) {
					ip_list.add(i + 1);
					bit_key_8_2.add(0);
					ip_converse_list.add(i + 1);
					e_p.add(0);
				}
				Collections.shuffle(ip_list);

				for (int i = 0; i < ip_list.size(); i++) {
					ip_converse_list.set(ip_list.get(i) - 1, i);
				}

				for (int j = 0; j < ip_converse_list.size(); j++) {
					ip_converse_list.set(j, ip_converse_list.get(j) + 1);
				}
				boolean loop = true;
				boolean loop2 = true;
				while (loop || loop2) {
					for (int i = 0; i < e_p.size() / 2; i++) {
						e_p.set(i, (int) (Math.random() * 4) + 1);
					}
					for (int i = e_p.size() / 2; i < e_p.size(); i++) {
						e_p.set(i, (int) (Math.random() * 4) + 1);
					}
					for (int i = 0; i < e_p.size() / 2; i++) {
						for (int j = i + 1; j < e_p.size() / 2; j++) {
							if (e_p.get(i) == e_p.get(j)) {
								loop = true;
								break;
							} else {
								loop = false;
							}
						}
						if (loop == true) {
							break;
						}
					}
					for (int i = e_p.size() / 2; i < e_p.size(); i++) {
						for (int j = i + 1; j < e_p.size(); j++) {
							if (e_p.get(i) == e_p.get(j)) {
								loop2 = true;
								break;
							} else {
								loop2 = false;
							}
						}
						if (loop2 == true) {
							break;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					p4.add(0);
				}
				boolean loop3 = true;
				while (loop3) {
					for (int i = 0; i < 4; i++) {
						p4.set(i, (int) (Math.random() * 4) + 1);
					}
					for (int i = 0; i < p4.size(); i++) {
						for (int j = i + 1; j < p4.size(); j++) {
							if (p4.get(i) == p4.get(j)) {
								loop3 = true;
								break;
							} else {
								loop3 = false;
							}
						}
						if (loop3 == true) {
							break;
						}
					}
				}
			}
		});
		btnNewButton.setBounds(781, 589, 156, 57);
		contentPane.add(btnNewButton);

		JButton button = new JButton("RESET");
		button.setBounds(781, 709, 156, 57);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lb_result_pl.setText("");
				lb_p10.setText("");
				lb_Fk1.setText("");
				lb_Shift1.setText("");
				lb_Shift2.setText("");
				lb_p8_k1.setText("");
				lb_p8_k2.setText("");
				lb_ip.setText("");
				lb_sw.setText("");
				lb_sw_2.setText("");
				lb_fk2.setText("");
				lb_IP_1.setText("");
				lb_IP_2.setText("");
				lb_result.setText("");
				lb_Fk1_2.setText("");
				lb_fk_2.setText("");
				iP_2.setText("");
				lb_result_1.setText("");
				tf_key.setText("");
				tf_pl.setText("");
				m_timer[0].cancel();
				m_timer[1].cancel();
				btnNewButton.setEnabled(true);
			}
		});

		JButton button_1 = new JButton("EXIT");
		button_1.setBounds(781, 816, 156, 57);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료메세지", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(781, 469, 156, 57);
		contentPane.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initHelp();
				new CSH.DisplayHelpFromSource(helpBroker);
				helpBroker.setDisplayed(true);

			}

			private void initHelp() {
				final String helpsetName = "helpdemo1";
				try {
					ClassLoader cl = this.getClass().getClassLoader();
					URL hsURL = HelpSet.findHelpSet(cl, helpsetName);
					helpSet = new HelpSet(cl, hsURL);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				helpBroker = helpSet.createHelpBroker();
				helpBroker.setSize(new Dimension(700, 700));
				helpBroker.enableHelpKey(getRootPane(), "overview", helpSet);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// m_timer.cancel();
		float dash1[] = { 5, 1f };
		super.paint(g);
		chack3 = false;
		if (paint_boolean == true) {

			g2d = new Graphics2D[17];
			for (int i = 0; i < g2d.length; i++) {
				g2d[i] = (Graphics2D) g.create();
				g2d[i].setStroke(new BasicStroke(3));
			}
			g3d = new Graphics2D[4];
			for (int i = 0; i < g3d.length; i++) {
				g3d[i] = (Graphics2D) g.create();
			}
			g2d[0].drawLine(160, 200, 160, 265);
			g2d[1].drawLine(160, 305, 160, 385);
			g2d[2].drawLine(160, 425, 160, 505);
			g2d[3].drawLine(160, 550, 160, 625);
			g2d[4].drawLine(160, 670, 160, 740);
			g2d[5].drawLine(160, 785, 160, 865);

			g2d[6].drawLine(430, 200, 430, 265);
			g2d[7].drawLine(430, 305, 430, 385);
			g2d[8].drawLine(430, 425, 430, 505);
			int x[] = { 430, 550, 550, 430, 430 };
			int y[] = { 470, 470, 580, 580, 630 };
			g2d[9].drawPolyline(x, y, 5);
			g2d[10].drawLine(430, 670, 430, 755);

			int x1[] = { 220, 300, 300, 345 };
			int y1[] = { 400, 400, 530, 530 };
			g3d[0].setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
			g3d[0].drawPolyline(x1, y1, 4);

			int x2[] = { 220, 300, 300, 345 };
			int y2[] = { 630, 630, 780, 780 };
			g3d[1].setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
			g3d[1].drawPolyline(x2, y2, 4);

			g2d[11].drawLine(680, 200, 680, 265);
			g2d[12].drawLine(680, 305, 680, 385);
			g2d[13].drawLine(680, 425, 680, 505);
			g2d[14].drawLine(680, 550, 680, 625);
			g2d[15].drawLine(680, 670, 680, 740);
			g2d[16].drawLine(680, 785, 680, 865);

			int x3[] = { 600, 540, 540, 500 };
			int y3[] = { 400, 400, 530, 530 };
			g3d[2].setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
			g3d[2].drawPolyline(x3, y3, 4);

			int x4[] = { 600, 540, 540, 500 };
			int y4[] = { 630, 630, 780, 780 };
			g3d[3].setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
			g3d[3].drawPolyline(x4, y4, 4);

			lb_result_pl.setText("");
			lb_p10.setText("");
			lb_Fk1.setText("");
			lb_Shift1.setText("");
			lb_Shift2.setText("");
			lb_p8_k1.setText("");
			lb_p8_k2.setText("");
			lb_ip.setText("");
			lb_sw.setText("");
			lb_sw_2.setText("");
			lb_fk2.setText("");
			lb_IP_1.setText("");
			lb_IP_2.setText("");
			lb_result.setText("");
			lb_Fk1_2.setText("");
			lb_fk_2.setText("");
			iP_2.setText("");
			lb_result_1.setText("");
			password_create = new Password_Create(bit_key_10);

			TimerTask m_task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < password_create.getP10().size(); i++) {
						lb_p10.setText(lb_p10.getText() + password_create.getP10().get(i));
					}
					g2d[6].setColor(Color.red);
					g2d[6].drawLine(430, 200, 430, 265);
					lb_p10.setForeground(Color.RED);
				}
			};
			m_timer[0].schedule(m_task, 500);

			m_task = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					lb_p10.setForeground(Color.black);
					g2d[6].setColor(Color.black);
					g2d[6].drawLine(430, 200, 430, 265);
					for (int i = 0; i < password_create.getShift_key().size(); i++) {
						lb_Shift1.setText(lb_Shift1.getText() + password_create.getShift_key().get(i));
					}
					lb_Shift1.setForeground(Color.RED);
					g2d[7].setColor(Color.red);
					g2d[7].drawLine(430, 305, 430, 385);
				}
			};
			m_timer[0].schedule(m_task, 1000);

			m_task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					lb_Shift1.setForeground(Color.black);
					g2d[7].setColor(Color.black);
					g2d[7].drawLine(430, 305, 430, 385);
					for (int i = 0; i < password_create.getK1().size(); i++) {
						lb_p8_k1.setText(lb_p8_k1.getText() + password_create.getK1().get(i));
					}
					lb_p8_k1.setForeground(Color.red);
					g2d[8].setColor(Color.red);
					g2d[8].drawLine(430, 425, 430, 505);

				}
			};
			m_timer[0].schedule(m_task, 1500);

			m_task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					lb_p8_k1.setForeground(Color.black);
					g2d[8].setColor(Color.black);
					g2d[8].drawLine(430, 425, 430, 505);
					for (int i = 0; i < password_create.getShift_key_2().size(); i++) {
						lb_Shift2.setText(lb_Shift2.getText() + password_create.getShift_key_2().get(i));
					}
					lb_Shift2.setForeground(Color.red);
					g2d[9].setColor(Color.red);
					g2d[9].drawPolyline(x, y, 5);

				}
			};
			m_timer[0].schedule(m_task, 2000);

			m_task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					lb_Shift2.setForeground(Color.BLACK);
					g2d[9].setColor(Color.BLACK);
					g2d[9].drawPolyline(x, y, 5);
					for (int i = 0; i < password_create.getK2().size(); i++) {
						lb_p8_k2.setText(lb_p8_k2.getText() + password_create.getK2().get(i));
					}
					lb_p8_k2.setForeground(Color.red);
					g2d[10].setColor(Color.red);
					g2d[10].drawLine(430, 670, 430, 755);

				}
			};
			m_timer[0].schedule(m_task, 2500);

			int sum = 0;
			bit_key_8.removeAll(bit_key_8);
			String[] n = new String[tf_pl.getText().length()];
			for (int i = 0; i < n.length; i++) {
				n[i] = Integer.toBinaryString(tf_pl.getText().charAt(i));
				if (n[i].getBytes().length % 8 != 0) {
					int size = n[i].getBytes().length;
					int result = getByteSizeToComplex(String.valueOf(tf_pl.getText().charAt(i)));
					n[i] = "";
					for (int j = 0; j < (result * 8) - size; j++) {
						n[i] += Integer.toBinaryString(0);
					}
					n[i] += Integer.toBinaryString(tf_pl.getText().charAt(i));
				}
			}

			for (int i = 0; i < n.length; i++) {
				for (int j = 0; j < n[i].length(); j++) {
					bit_key_8.add(Integer.parseInt(String.valueOf(n[i].charAt(j))));
				}
			}
			Encryption e = new Encryption(result1);
			lb_result.setText("");
			result1.removeAll(result1);
			lp_result.removeAll(lp_result);
			lp_result1.removeAll(lp_result1);
			sw_result.removeAll(sw_result);
			lp_result2.removeAll(lp_result2);
			lp_ip_converse.removeAll(lp_ip_converse);

			for (int i = 0; i < tf_pl.getText().length(); i++) {
				sum = getByteSizeToComplex(String.valueOf(tf_pl.getText().charAt(i)));
				result1.add(sum);
			}
			while (true) {

				for (int i = 0; i < 8; i++) {
					bit_key_8_1.add(bit_key_8.get(i));
				}
				for (int i = 0; i < 8; i++) {
					bit_key_8.remove(0);
				}


				e.Encry(bit_key_8_1, password_create.getK1(), password_create.getK2(), ip_list, ip_converse_list, e_p,
						S0, S1, p4);
				lp_result.add(String.valueOf(e.getIp_result()));

				lp_result1.add(String.valueOf(e.getFk_1()));

				sw_result.add(String.valueOf(e.getSw()));

				lp_result2.add(String.valueOf(e.getFk_2()));

				lp_ip_converse.add(String.valueOf(e.getIp_converse_result()));

				bit_key_8_1.removeAll(bit_key_8_1);
				if (bit_key_8.size() == 0) {
					break;
				}

			}

			String l_result[] = new String[lp_result.size()];
			String l_result1[] = new String[lp_result1.size()];
			String l_result2[] = new String[sw_result.size()];
			String l_result3[] = new String[lp_result2.size()];
			String l_result4[] = new String[lp_ip_converse.size()];
			for (int i = 0; i < l_result.length; i++) {
				l_result[i] = "";
				l_result1[i] = "";
				l_result2[i] = "";
				l_result3[i] = "";
				l_result4[i] = "";
			}
			for (int i = 0; i < ex.length; i++) {
				ex[i] = 0;
			}
			while (ex[0] < lp_result.size()) {
				for (int j = 0; j < lp_result.get(ex[0]).length(); j++) {
					if (lp_result.get(ex[0]).charAt(j) != ']' && lp_result.get(ex[0]).charAt(j) != '['
							&& lp_result.get(ex[0]).charAt(j) != ',' && lp_result.get(ex[0]).charAt(j) != ' ') {
						// lb_ip.setText(lb_ip.getText() + lp_result.get(ex).charAt(j));
						l_result[ex[0]] += String.valueOf(lp_result.get(ex[0]).charAt(j));
						l_result1[ex[0]] += String.valueOf(lp_result1.get(ex[0]).charAt(j));
						l_result2[ex[0]] += String.valueOf(sw_result.get(ex[0]).charAt(j));
						l_result3[ex[0]] += String.valueOf(lp_result2.get(ex[0]).charAt(j));
						l_result4[ex[0]] += String.valueOf(lp_ip_converse.get(ex[0]).charAt(j));
					}
				}

				ex[0]++;
			}
			ex[0] = 0;
			s = 0;
			String lb_result_12 = e.result();
			time2 = 0;
			count_task = 0;

			lb_result_1.setText(lb_result_12);
			String[] c = new String[lb_result_12.length()];

			try {

				for (int i = 0; i < c.length; i++) {
					c[i] = Integer.toBinaryString(lb_result_12.charAt(i));
					if (c[i].getBytes().length % 8 != 0) {
						int size = c[i].getBytes().length;
						int result = getByteSizeToComplex(String.valueOf(lb_result_12.charAt(i)));
						c[i] = "";
						if (result1.get(i) == 1) {
							for (int j = 0; j < 8 - size; j++) {
								c[i] += Integer.toBinaryString(0);
							}
						} else if (result1.get(i) == 2) {
							for (int j = 0; j < (result * 8) - size; j++) {
								c[i] += Integer.toBinaryString(0);
							}
						}
						c[i] += Integer.toBinaryString(lb_result_12.charAt(i));
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			//
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[i].length(); j++) {
					bit_key_8.add(Integer.parseInt(String.valueOf(c[i].charAt(j))));
				}
			}

			DECRYPTION d = new DECRYPTION(result1);
			lp_result_1.removeAll(lp_result_1);
			lp_result1_1.removeAll(lp_result1_1);
			sw_result_1.removeAll(sw_result_1);
			lp_result2_1.removeAll(lp_result2_1);
			lp_ip_converse_1.removeAll(lp_ip_converse_1);

			while (true) {
				for (int i = 0; i < 8; i++) {
					bit_key_8_1.add(bit_key_8.get(i));
				}
				for (int i = 0; i < 8; i++) {
					bit_key_8.remove(0);
				}

				if (bit_key_8_2 == bit_key_8_1) {
					bit_key_8_1.removeAll(bit_key_8_1);
				} else {
					d.Decry(bit_key_8_1, password_create.getK1(), password_create.getK2(), ip_list, ip_converse_list,
							e_p, S0, S1, p4);
					lp_result_1.add(String.valueOf(d.getIp_result()));

					lp_result1_1.add(String.valueOf(d.getFk_1()));

					sw_result_1.add(String.valueOf(d.getSw()));

					lp_result2_1.add(String.valueOf(d.getFk_2()));

					lp_ip_converse_1.add(String.valueOf(d.getIp_converse_result()));
				}

				bit_key_8_1.removeAll(bit_key_8_1);
				if (bit_key_8.size() == 0) {
					break;
				}
			}
			String l_result5[] = new String[lp_result_1.size()];
			String l_result6[] = new String[lp_result1_1.size()];
			String l_result7[] = new String[sw_result_1.size()];
			String l_result8[] = new String[lp_result2_1.size()];
			String l_result9[] = new String[lp_ip_converse_1.size()];

			String lb_result_13 = d.result();
			for (int i = 0; i < l_result.length; i++) {
				l_result5[i] = "";
				l_result6[i] = "";
				l_result7[i] = "";
				l_result8[i] = "";
				l_result9[i] = "";
			}
			for (int i = 0; i < ex.length; i++) {
				ex1[i] = 0;
			}
			while (ex1[0] < lp_result_1.size()) {
				for (int j = 0; j < lp_result_1.get(ex1[0]).length(); j++) {
					if (lp_result_1.get(ex1[0]).charAt(j) != ']' && lp_result_1.get(ex1[0]).charAt(j) != '['
							&& lp_result_1.get(ex1[0]).charAt(j) != ',' && lp_result_1.get(ex1[0]).charAt(j) != ' ') {
						// lb_ip.setText(lb_ip.getText() + lp_result.get(ex).charAt(j));
						l_result5[ex1[0]] += String.valueOf(lp_result_1.get(ex1[0]).charAt(j));
						l_result6[ex1[0]] += String.valueOf(lp_result1_1.get(ex1[0]).charAt(j));
						l_result7[ex1[0]] += String.valueOf(sw_result_1.get(ex1[0]).charAt(j));
						l_result8[ex1[0]] += String.valueOf(lp_result2_1.get(ex1[0]).charAt(j));
						l_result9[ex1[0]] += String.valueOf(lp_ip_converse_1.get(ex1[0]).charAt(j));
					}
				}

				ex1[0]++;
			}
			ex1[0] = 0;

			try {

				m_task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (ex[0] < sw_result.size()) {
							TimerTask t = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub

									lb_IP_1.setForeground(Color.black);
									g2d[4].setColor(Color.black);
									g2d[4].drawLine(160, 670, 160, 740);
									lb_p8_k2.setForeground(Color.black);
									g2d[10].setColor(Color.black);
									g2d[10].drawLine(430, 670, 430, 755);

									lb_ip.setForeground(Color.red);
									lb_ip.setText(l_result[ex[0]]);
									ex[0]++;
									g2d[0].setColor(Color.red);
									g2d[0].drawLine(160, 200, 160, 265);

									time2 += 500;
								}
							};
							m_timer[2].schedule(t, 500);
						}
						if (ex[1] < sw_result.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_ip.setForeground(Color.black);
									g2d[0].setColor(Color.black);
									g2d[0].drawLine(160, 200, 160, 265);
									lb_Fk1.setText(l_result1[ex[1]]);
									ex[1]++;
									lb_p8_k1.setForeground(Color.RED);
									g3d[0].setColor(Color.RED);
									g3d[0].drawPolyline(x1, y1, 4);
									lb_Fk1.setForeground(Color.RED);
									g2d[1].setColor(Color.red);
									g2d[1].drawLine(160, 305, 160, 385);

									time2 += 500;
								}
							};
							m_timer[2].schedule(t2, 1000);
						}
						if (ex[2] < sw_result.size()) {
							TimerTask t2 = new TimerTask() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_Fk1.setForeground(Color.black);
									g2d[1].setColor(Color.black);
									g2d[1].drawLine(160, 305, 160, 385);
									lb_p8_k1.setForeground(Color.black);
									g3d[0].setColor(Color.black);
									g3d[0].drawPolyline(x1, y1, 4);
									lb_sw.setText(l_result2[ex[2]]);
									ex[2]++;
									lb_sw.setForeground(Color.red);
									g2d[2].setColor(Color.red);
									g2d[2].drawLine(160, 425, 160, 505);
									time2 += 1000;
								}
							};
							m_timer[2].schedule(t2, 1500);
						}
						if (ex[3] < lp_result2.size()) {
							TimerTask t2 = new TimerTask() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_sw.setForeground(Color.black);
									g2d[2].setColor(Color.black);
									g2d[2].drawLine(160, 425, 160, 505);
									lb_fk2.setText(l_result3[ex[3]]);
									ex[3]++;
									lb_fk2.setForeground(Color.red);
									lb_p8_k2.setForeground(Color.red);
									g2d[3].setColor(Color.red);
									g2d[3].drawLine(160, 550, 160, 625);
									g3d[1].setColor(Color.red);
									g3d[1].drawPolyline(x2, y2, 4);
									time2 += 1000;
								}
							};
							m_timer[2].schedule(t2, 2000);
						}
						if (ex[4] < lp_ip_converse.size()) {
							TimerTask t2 = new TimerTask() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_fk2.setForeground(Color.BLACK);
									g2d[3].setColor(Color.BLACK);
									lb_p8_k2.setForeground(Color.BLACK);
									g2d[3].drawLine(160, 550, 160, 625);
									g3d[1].setColor(Color.BLACK);
									g3d[1].drawPolyline(x2, y2, 4);
									lb_IP_1.setText(l_result4[ex[4]]);
									ex[4]++;
									lb_IP_1.setForeground(Color.red);
									g2d[4].setColor(Color.red);
									g2d[4].drawLine(160, 670, 160, 740);
									time2 += 1000;
								}
							};
							m_timer[2].schedule(t2, 2500);
						}
						if (s < result1.size()) {
							TimerTask t2 = new TimerTask() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_IP_1.setForeground(Color.black);
									g2d[4].setColor(Color.black);
									g2d[4].drawLine(160, 670, 160, 740);
									if (result1.get(s) == 1) {
										lb_result.setText(lb_result.getText() + lb_result_12.charAt(s));
										s++;
									} else if (result1.get(s) == 2) {
										count_task++;
										if (count_task == 2) {
											count_task = 0;
											lb_result.setText(lb_result.getText() + lb_result_12.charAt(s));
											s++;
										}
									}
									time2 += 1000;
								}
							};
							m_timer[2].schedule(t2, 3000);
						}
						if (s == result1.size()) {
							m_timer[2].cancel();
							chack3 = true;
						}
					}
				};
				m_timer[2].schedule(m_task, 6000, 4000);
			} catch (Exception e2) {
				// TODO: handle exception
				m_timer[2].cancel();
			}
			time2 = 1000;

			s1 = 0;

			count_task = 0;
			TimerTask m_task1 = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (chack3 == true) {
						if (ex1[0] < lp_result_1.size()) {
							TimerTask t = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									g2d[16].setColor(Color.red);
									g2d[16].drawLine(680, 785, 680, 865);
									iP_2.setText(l_result5[ex1[0]]);
									ex1[0]++;
									iP_2.setForeground(Color.red);
									time2 += 500;
								}
							};
							m_timer[1].schedule(t, 1000);
						}
						if (ex1[1] < lp_result1_1.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									iP_2.setForeground(Color.black);
									g2d[16].setColor(Color.black);
									g2d[16].drawLine(680, 785, 680, 865);
									lb_fk_2.setText(l_result6[ex1[1]]);
									ex1[1]++;
									lb_fk_2.setForeground(Color.RED);
									lb_p8_k2.setForeground(Color.RED);
									g2d[15].setColor(Color.red);
									g2d[15].drawLine(680, 670, 680, 740);
									g3d[3].setColor(Color.red);
									g3d[3].drawPolyline(x4, y4, 4);
									time2 += 500;
								}
							};
							m_timer[1].schedule(t2, 1500);
						}
						if (ex1[2] < sw_result_1.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_p8_k2.setForeground(Color.black);
									lb_fk_2.setForeground(Color.black);
									g2d[15].setColor(Color.black);
									g2d[15].drawLine(680, 670, 680, 740);
									g3d[3].setColor(Color.black);
									g3d[3].drawPolyline(x4, y4, 4);
									lb_sw_2.setText(l_result7[ex1[2]]);
									ex1[2]++;
									lb_sw_2.setForeground(Color.RED);
									g2d[14].setColor(Color.red);
									g2d[14].drawLine(680, 550, 680, 625);
									time2 += 1000;
								}
							};
							m_timer[1].schedule(t2, 2000);
						}
						if (ex1[3] < sw_result_1.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_sw_2.setForeground(Color.black);
									g2d[14].setColor(Color.black);
									g2d[14].drawLine(680, 550, 680, 625);
									lb_Fk1_2.setText(l_result8[ex1[3]]);
									ex1[3]++;
									lb_Fk1_2.setForeground(Color.RED);
									g2d[13].setColor(Color.red);
									g2d[13].drawLine(680, 425, 680, 505);
									lb_p8_k1.setForeground(Color.red);
									g3d[2].setColor(Color.red);
									g3d[2].drawPolyline(x3, y3, 4);
									time2 += 1000;
								}
							};
							m_timer[1].schedule(t2, 2500);
						}
						if (ex1[4] < lp_result2_1.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_Fk1_2.setForeground(Color.black);
									g2d[13].setColor(Color.black);
									g3d[2].setColor(Color.black);
									g3d[2].drawPolyline(x3, y3, 4);
									lb_IP_2.setForeground(Color.RED);
									g2d[13].drawLine(680, 425, 680, 505);
									lb_IP_2.setText(l_result9[ex1[4]]);
									ex1[4]++;
									g2d[12].setColor(Color.red);
									g2d[12].drawLine(680, 305, 680, 385);
									lb_p8_k1.setForeground(Color.black);
									time2 += 1000;
								}
							};
							m_timer[1].schedule(t2, 3000);
						}
						if (s1 < result1.size()) {
							TimerTask t2 = new TimerTask() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									lb_IP_2.setForeground(Color.black);
									g2d[12].setColor(Color.black);
									g2d[12].drawLine(680, 305, 680, 385);
									if (result1.get(s1) == 1) {
										lb_result_pl.setText(lb_result_pl.getText() + lb_result_13.charAt(s1));
										s1++;
									} else if (result1.get(s1) == 2) {
										count_task++;
										if (count_task == 2) {
											count_task = 0;
											lb_result_pl.setText(lb_result_pl.getText() + lb_result_13.charAt(s1));
											s1++;
										}
									}
									time2 += 1000;
								}
							};
							m_timer[1].schedule(t2, 3500);
						}

						if (s1 == result1.size()) {
							m_timer[1].cancel();
							m_timer[0].cancel();
							JOptionPane.showMessageDialog(null, "프로그램 완료", "수행 끝났습니다.",
									JOptionPane.INFORMATION_MESSAGE);

						}
					}
				}
			};
			m_timer[1].schedule(m_task1, 2000, 4000);
		}
	}

	private static int getByteSizeToComplex(String valueOf) {
		// TODO Auto-generated method stub
		int en = 0;
		int ko = 0;
		int etc = 0;
		int num = 0;
		char[] string = valueOf.toCharArray();

		for (int j = 0; j < string.length; j++) {
			if (string[j] >= 'A' && string[j] <= 'z') {
				en++;
			} else if (string[j] >= '\uAC00' && string[j] <= '\uD7A3') {
				ko++;
				ko++;
			} else if (string[j] >= '0' && string[j] <= '9') {
				num++;
			} else {
				etc++;
				etc++;
			}
		}
		return (en + ko + etc + num);
	}
}
