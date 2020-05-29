import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class successPan {

	successPan(String message,Icon icon){  
	    JOptionPane.showMessageDialog(new JFrame(),message,"Success",JOptionPane.INFORMATION_MESSAGE,icon);
	}
}
 