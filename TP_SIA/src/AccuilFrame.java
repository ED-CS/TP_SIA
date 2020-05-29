import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccuilFrame extends JFrame {
	private Connection conn = null;
	private static final long serialVersionUID = 5544866006395128454L;
	private Font font_bold = new Font("Times New Roman", Font.BOLD, 14);
	private Font font_plain = new Font("Times New Roman", Font.PLAIN, 14);
	private Font font_title = new Font("SansSerif", Font.BOLD, 18);
	private JTable table;
	private JTextField searchName_textField;
	private Statement statement;  
    private ResultSet resultSet;
    boolean exist = false,founded = false;
    public static DefaultTableModel model;
    private TableRowSorter<TableModel> rowSorter;
	private int id_max = 0;
	
	public AccuilFrame(Connection conn) {
		this.conn = conn;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	private void initialize() {
		
		ImageIcon icon_delete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(AccuilFrame.class.getResource("/Icons/delete.png")));
		Quit exit = new Quit();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccuilFrame.class.getResource("/Icons/database.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel leftPanel = new JPanel();
		getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBounds(0, 0, 512, 334);

		
        JPanel add_panel = new JPanel();
        tabbedPane.addTab("Add", add_panel);
        add_panel.setLayout(null);
        
        JLabel add_panel_label = new JLabel("Ajouter");
        add_panel_label.setFont(new Font("SansSerif", Font.BOLD, 22));
        add_panel_label.setBounds(199, 27, 89, 34);
        add_panel.add(add_panel_label);
        
        JButton btnNouveauPresonne = new JButton("Nouveau Presonne");
        btnNouveauPresonne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AjouterPersonneFrame personne = new AjouterPersonneFrame(conn);
        	}
        });
        btnNouveauPresonne.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNouveauPresonne.setBounds(146, 79, 200, 50);
        add_panel.add(btnNouveauPresonne);
        
        JButton btnNouveauMaterielle = new JButton("Nouveau Mat\u00E9rielle");
        btnNouveauMaterielle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AjouterMaterielleFrame materielle = new AjouterMaterielleFrame(conn);
        	}
        });
        btnNouveauMaterielle.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNouveauMaterielle.setBounds(146, 142, 200, 50);
        add_panel.add(btnNouveauMaterielle);
        
        JButton btnNouveauSalle = new JButton("Nouveau Salle");
        btnNouveauSalle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AjouterSalleFrame salle = new AjouterSalleFrame(conn);
        	}
        });
        btnNouveauSalle.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNouveauSalle.setBounds(146, 205, 200, 50);
        add_panel.add(btnNouveauSalle);
        JPanel edit_panel = new JPanel();
        tabbedPane.addTab("Edit", edit_panel);
        edit_panel.setLayout(null);
        
        JButton edit_button = new JButton("Edit");
        edit_button.setFont(font_bold);
        edit_button.setBounds(118, 193, 90, 28);
        edit_panel.add(edit_button);
        
        JTextField id_textField = new JTextField("");
        id_textField.setFont(font_plain);
        id_textField.setBounds(134, 92, 131, 28);
        edit_panel.add(id_textField);
        
        JLabel id_label = new JLabel("ID");
        id_label.setFont(font_bold);
        id_label.setBounds(98, 98, 37, 16);
        edit_panel.add(id_label);
        
        JLabel edit_panel_label = new JLabel("Choose a Product ID to Edit");
        edit_panel_label.setFont(font_title);
        edit_panel_label.setBounds(37, 6, 272, 35);
        edit_panel.add(edit_panel_label);
		leftPanel.add(tabbedPane);
		
		JPanel search_panel = new JPanel();
		tabbedPane.addTab("Search", null, search_panel, null);
		search_panel.setLayout(null);
		
		JComboBox search_comboBox = new JComboBox();
		search_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Product Name", "Product Price"}));
		search_comboBox.setBounds(59, 41, 219, 26);
		search_panel.add(search_comboBox);
		
		JLabel search_panel_label = new JLabel("Choose to Search by");
		search_panel_label.setFont(font_title);
		search_panel_label.setBounds(71, 6, 203, 35);
		search_panel.add(search_panel_label);
		
		JPanel cardLayout_panel = new JPanel();
		cardLayout_panel.setBounds(22, 76, 292, 137);
		search_panel.add(cardLayout_panel);
		cardLayout_panel.setLayout(new CardLayout(0, 0));
		
		JPanel searchName_panel = new JPanel();
		cardLayout_panel.add(searchName_panel, "Product Name");
		searchName_panel.setLayout(null);
		
		searchName_textField = new JTextField();
		searchName_textField.setFont(font_plain);
		searchName_textField.setColumns(10);
		searchName_textField.setBounds(99, 49, 131, 28);
		searchName_panel.add(searchName_textField);
		
		JLabel searchName_label = new JLabel("Name");
		searchName_label.setFont(font_bold);
		searchName_label.setBounds(48, 53, 55, 16);
		searchName_panel.add(searchName_label);
		
		JPanel searchPrice_panel = new JPanel();
		cardLayout_panel.add(searchPrice_panel, "Product Price");
		searchPrice_panel.setLayout(null);
		
		JTextField searchPrice_textField = new JTextField();
		searchPrice_textField.setFont(font_plain);
		searchPrice_textField.setBounds(99, 49, 131, 28);
		searchPrice_panel.add(searchPrice_textField);
		
		
		JLabel searchPrice_label = new JLabel("Price");
		searchPrice_label.setFont(font_bold);
		searchPrice_label.setBounds(48, 53, 37, 16);
		searchPrice_panel.add(searchPrice_label);
		
		JPanel delete_panel = new JPanel();
		tabbedPane.addTab("Delete", null, delete_panel, null);
		delete_panel.setLayout(null);
		
		JButton delete_button = new JButton("Delete");
		delete_button.setFont(font_bold);
		delete_button.setBounds(118, 193, 90, 28);
		delete_panel.add(delete_button);
		
		JLabel delete_panel_label1 = new JLabel("Select Row/Rows ");
		delete_panel_label1.setFont(font_title);
		delete_panel_label1.setBounds(78, 43, 166, 36);
		delete_panel.add(delete_panel_label1);
		
		JLabel delete_panel_label2 = new JLabel("from the table to delete");
		delete_panel_label2.setFont(font_title);
		delete_panel_label2.setBounds(51, 79, 216, 36);
		delete_panel.add(delete_panel_label2);
		
		JLabel noneName_label = new JLabel("Nothing was found");
		noneName_label.setFont(font_bold);
		noneName_label.setForeground(Color.RED);
		noneName_label.setBounds(86, 102, 144, 29);
		noneName_label.setVisible(false);
		searchName_panel.add(noneName_label);
		
		JLabel nonePrice_label = new JLabel("Nothing was found");
		nonePrice_label.setFont(font_bold);
		nonePrice_label.setForeground(Color.RED);
		nonePrice_label.setBounds(86, 102, 144, 29);
		nonePrice_label.setVisible(false);
		searchName_panel.add(nonePrice_label);
		
		setTitle("Accuil");
		setResizable(false);
		setBounds(500, 200, 520, 370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

	}
}
