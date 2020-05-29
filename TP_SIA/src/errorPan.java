import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class errorPan {

	errorPan(String message){  
	    JOptionPane.showMessageDialog(new JFrame(),message,"Alert",JOptionPane.WARNING_MESSAGE);
	}
	errorPan(String message,Icon icon){  
	    JOptionPane.showMessageDialog(new JFrame(),message,"Alert",JOptionPane.WARNING_MESSAGE,icon);
	}
}
 