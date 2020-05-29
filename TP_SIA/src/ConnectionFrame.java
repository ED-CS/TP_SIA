import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConnectionFrame  extends JFrame{
	private static final long serialVersionUID = -8896986317686307201L;
	private JTextField userName_textField;
	private JPasswordField password_passwordField;
	private Quit quit_actionListener = new Quit();
	private Font font = new Font("Times New Roman", Font.BOLD, 14);
	private Connection conn = null;
	
	public ConnectionFrame() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ConnectionFrame.class.getResource("/Icons/success.png")));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConnectionFrame.class.getResource("/Icons/connect.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		userName_textField = new JTextField();
		userName_textField.setColumns(10);
		userName_textField.setBounds(205, 31, 158, 23);
		getContentPane().add(userName_textField);
		
		JLabel userName_label = new JLabel("Administartor User Name:");
		userName_label.setFont(font);
		userName_label.setBounds(24, 31, 173, 21);
		getContentPane().add(userName_label);
		
		JLabel password_label = new JLabel("Administrator Password:");
		password_label.setFont(font);
		password_label.setBounds(24, 64, 152, 21);
		getContentPane().add(password_label);
		
		password_passwordField = new JPasswordField();
		password_passwordField.setBounds(205, 63, 158, 23);
		getContentPane().add(password_passwordField);
		
		JButton cancel_button = new JButton("Cancel");
		cancel_button.addActionListener(quit_actionListener);
		cancel_button.setFont(font);
		cancel_button.setBounds(93, 123, 89, 23);
		getContentPane().add(cancel_button);
		
		JButton connect_button = new JButton("Connect");
		connect_button.setFont(font);
		connect_button.setBounds(211, 123, 89, 23);
		connect_button.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					   String url = "jdbc:postgresql://127.0.0.1:5432/TpSIA?serverTimezone=GMT";
				       String user,password ;
				       user = "postgres";
				       password = "ed";
				       conn = DriverManager.getConnection(url, user, password);
				       @SuppressWarnings("unused")
				       successPan success = new successPan("Successfuly connected to database",icon);
				       @SuppressWarnings("unused")
				       AccuilFrame edit = new AccuilFrame(conn);
				       dispose();
				       
				   } 
				catch(SQLException e) {
					System.out.println(e.getMessage());
					@SuppressWarnings("unused")
					errorPan fail = new errorPan("User Name or password is incorrect\n"
												+"             or server is off");
				}
				
			}
		});
		getContentPane().add(connect_button);
		
		
		
		
		setTitle("Connector");
		setResizable(false);
		setBounds(500, 200, 392, 203);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}