import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DesponibiliteFrame extends JFrame {
	private Connection conn;
	private Statement statement;
	private ResultSet resultSet;
	private String id;
	public DesponibiliteFrame(Connection conn,String id) {
		this.conn= conn;
		this.id = id;
		initialize();
		
	}	
	private void initialize() {
		getContentPane().setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(118, 88, 190, 40);
		getContentPane().add(dateChooser);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sd = new SimpleDateFormat("yyMMdd");
				String date = sd.format(dateChooser.getDate());
				
				SimpleDateFormat sd1 = new SimpleDateFormat("yy-MM-dd");
				String date1 = sd1.format(dateChooser.getDate());
				try {
					statement = conn.createStatement();
				    resultSet = statement.executeQuery("SELECT * from demande_materielle where id_mat ="+Integer.parseInt(id)+"and date_debut = '"+date+"';");  
				    if(resultSet.next()) {				 
				    		successPan b = new successPan("Matérielle est réserver a la date "+date1, null);
				    		dispose();
				    }else {
				    		successPan s = new successPan("Matérielle est disponible a la date "+date1, null);
				    		dispose();
				    }
				    
				} 
				catch(SQLException e1) {
				      System.out.println(e1.getMessage());
				      e1.printStackTrace();
				}
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(159, 179, 97, 25);
		getContentPane().add(btnOk);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(34, 88, 56, 40);
		getContentPane().add(lblDate);
		
		setTitle("Matérielle");
		setResizable(false);
		setBounds(500, 200, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
