package UI_DES;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		try {
			// here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException ex) {
		}
		
		new LoadingUI(); //로딩화면생성
		
		try {
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException ex) {
		}
		new UI(); //메인UI
		
	}
}
