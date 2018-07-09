package UI_DES;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class LoadingUI extends JFrame{
    int a = 0;
    JProgressBar progressBar = new JProgressBar(0, 100);
    ImageIcon image1 =new ImageIcon("img/tu_image.jpg");
    JLabel label = new JLabel("",image1,JLabel.CENTER);
    Border border = BorderFactory.createTitledBorder("·ÎµùÁß...");

	public LoadingUI() {
		// TODO Auto-generated constructor stub
		progressBar.setStringPainted(true);
		progressBar.setBorder(border);
		label.setFont(new Font("Tahoma", 1, 24));
		JPanel content = (JPanel) getContentPane();
		Color warnaBorder = Color.BLACK;
		content.setBorder(BorderFactory.createLineBorder(warnaBorder));
		setLayout(null);
		add(label);
		label.setBounds(150, 40, 700, 700);
		Component add = add(progressBar);
		content.setBackground(Color.white);
		progressBar.setBounds(10, 750, 1015, 50);
		setSize(1070, 950);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		while (a <= 100) {
			progressBar.setValue(a);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			a += 1;
		}
		this.dispose();
	}
}
