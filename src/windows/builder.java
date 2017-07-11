package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class builder {

	private JFrame frame;
	private static JTextField StokKoduTxt;
	private JTextField StokAdiTxt;
	private JTextField BarKoduTxt;
	private JTextField textField_3;
	static Connect conn = new Connect();
	private static JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					builder window = new builder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public builder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Stok Takibi");
		frame.getContentPane().setBackground(Color.black);
		//frame.getContentPane().setLayout(null);
		//frame.pack();
		frame.setVisible(true);
		
		JLabel lblStokKodu = new JLabel("Stok Kodu");
		lblStokKodu.setBounds(20, 65, 63, 14);
		frame.getContentPane().add(lblStokKodu);
		
		JLabel lblStokTipi = new JLabel("Stok Tipi");
		lblStokTipi.setBounds(22, 127, 61, 14);
		frame.getContentPane().add(lblStokTipi);
		
		JLabel lblStokAd = new JLabel("Stok Ad\u0131");
		lblStokAd.setBounds(20, 96, 63, 14);
		frame.getContentPane().add(lblStokAd);
		
		JLabel lblBarKodu = new JLabel("Bar Kodu");
		lblBarKodu.setBounds(20, 195, 63, 14);
		frame.getContentPane().add(lblBarKodu);
		
		JLabel lblKdvTipi = new JLabel("KDV Tipi");
		lblKdvTipi.setBounds(28, 232, 55, 14);
		frame.getContentPane().add(lblKdvTipi);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 519, 212);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		
		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setBounds(37, 156, 51, 14);
		panel.add(lblBirim);

		
		table_1 = new JTable();
		table_1.setBounds(10, 263, 637, 148);
		panel.add(table_1);
		
		JFormattedTextField TarihFtxt = new JFormattedTextField();
		panel.add(TarihFtxt);
		TarihFtxt.setBounds(318, 192, 329, 20);
		TarihFtxt.setValue(Calendar.getInstance().getTime());
		JTextArea AciklamaTxt = new JTextArea();
		panel.add(AciklamaTxt);
		AciklamaTxt.setBounds(318, 81, 329, 89);
		
		JButton btnDzenle = new JButton("D\u00FCzenle");
		
		panel.add(btnDzenle);
		btnDzenle.setBounds(434, 228, 93, 23);
		
		JButton btnKaydet = new JButton("Kaydet");
		panel.add(btnKaydet);
		btnKaydet.setBounds(328, 228, 93, 23);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getValueAt(table_1.getSelectedRow(), 1).toString() != null)
				{
					conn.deleteStock(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					listele("");
				}
			}
		});
		btnSil.setBounds(539, 228, 93, 23);
		panel.add(btnSil);
		
		StokKoduTxt = new JTextField();
		panel.add(StokKoduTxt);
		StokKoduTxt.setBounds(83, 64, 157, 20);
		StokKoduTxt.setColumns(10);
		
		StokAdiTxt = new JTextField();
		panel.add(StokAdiTxt);
		StokAdiTxt.setBounds(83, 93, 157, 20);
		StokAdiTxt.setColumns(10);
		
		JComboBox<String> StockTipiCbx = new JComboBox<String>();
		panel.add(StockTipiCbx);
		StockTipiCbx.setBounds(83, 123, 157, 20);
		loadItems(StockTipiCbx, "stoktipi");
		
		JComboBox<String> BirimCbx = new JComboBox<String>();
		panel.add(BirimCbx);
		BirimCbx.setBounds(83, 153, 157, 20);
		loadItems(BirimCbx, "birim");
		
		BarKoduTxt = new JTextField();
		panel.add(BarKoduTxt);
		BarKoduTxt.setBounds(83, 192, 157, 20);
		BarKoduTxt.setColumns(10);
		
		JComboBox kdvCbx = new JComboBox();
		panel.add(kdvCbx);
		kdvCbx.setBounds(83, 230, 157, 20);
		loadItems(kdvCbx, "kdvTipi");
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setBounds(83, 22, 157, 20);
		textField_3.setColumns(10);
		
		btnDzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stok stok = new Stok(StokKoduTxt.getText(),StokAdiTxt.getText(), StockTipiCbx.getSelectedIndex() + 1, BirimCbx.getSelectedIndex() + 1,BarKoduTxt.getText(), kdvCbx.getSelectedIndex() + 1, AciklamaTxt.getText());
				stok.setId(Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
				conn.updateStock(stok);
				listele("");
			}
		});
		
		JButton btnAra = new JButton("Ara");
		panel.add(btnAra);
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText() == "")
					listele("");
				else
					listele(textField_3.getText());
			}
		});
		btnAra.setBounds(13, 21, 58, 23);
		
		JLabel lblOluturmaTarihi = new JLabel("Olu\u015Fturma Tarihi");
		panel.add(lblOluturmaTarihi);
		lblOluturmaTarihi.setBounds(318, 176, 126, 14);
		
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama");
		panel.add(lblAklama);
		lblAklama.setBounds(318, 64, 99, 14);
		btnKaydet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Stok stok = new Stok(StokKoduTxt.getText(),StokAdiTxt.getText(),StockTipiCbx.getSelectedIndex() + 1, BirimCbx.getSelectedIndex() + 1,BarKoduTxt.getText(), kdvCbx.getSelectedIndex() + 1, AciklamaTxt.getText());
				conn.addStock(stok);
				listele("");
			}
		});
		btnDzenle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//TODO
			}
		});
		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            StokKoduTxt.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
	            StokAdiTxt.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
	            StockTipiCbx.setSelectedItem(conn.getAdi(table_1.getValueAt(table_1.getSelectedRow(), 3).toString(), "stoktipi"));
	            BirimCbx.setSelectedItem(conn.getAdi(table_1.getValueAt(table_1.getSelectedRow(), 4).toString(), "birim"));
	            kdvCbx.setSelectedItem(conn.getAdi(table_1.getValueAt(table_1.getSelectedRow(), 6).toString(), "kdvtipi"));
	            //TarihFtxt.setValue(table_1.getValueAt(table_1.getSelectedRow(), 8).toString());
	            BarKoduTxt.setText(table_1.getValueAt(table_1.getSelectedRow(), 5).toString());
	            AciklamaTxt.setText(table_1.getValueAt(table_1.getSelectedRow(), 7).toString());
	            System.out.println(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
	        }
	    });

				
		listele("");
	}
	
	public static void loadItems(JComboBox<String> cbx, String tableName) //Populates Comboboxes
	{
		List<String> strings = conn.getCbx(tableName);
		for (String item : strings)
			cbx.addItem(item);
	}
	
	public static void listele(String quer)
	{
		String sorgu;
		if (quer == "")
			sorgu = "Select * From stok";
		else
			sorgu = "Select * From stok where StokKodu = '" + quer + "'";
		try{
			Connection con = conn.getConnection();
			PreparedStatement posted = (PreparedStatement) con.prepareStatement(sorgu);
			ResultSet kayitlar = posted.executeQuery();
			ResultSetMetaData rowdata = (ResultSetMetaData) kayitlar.getMetaData();
			int j = 0;
			int k = rowdata.getColumnCount();
			String[] kolon = new String[k];
			for( j=0; j<k; j++) {
				kolon[j] = rowdata.getColumnName(j+1);
			}
			table_1.setModel(new DefaultTableModel(new Object [][]{},kolon));
			DefaultTableModel model = (DefaultTableModel)table_1.getModel();
			while(kayitlar.next()) {
				Object[] o = new Object[k];
				for(j=0; j<k; j++) {
					o[j] = kayitlar.getObject(j+1);
				}
				model.addRow(o);
			}	
			table_1.setModel(model);
			System.out.println("Veritabanindan veriler listelendi.");
			posted.close(); 
			con.close();
		}catch(Exception e1){ System.out.println(e1);
		
	}
	}
	
	public static void listele2(JTable table)
	{
		String header[] = {"Id","Stok Kodu","Stok Adı","Stok Tipi","Birim", "Bar Kodu", "KDV","Açıklama","Oluşturma Tarihi"};   
		String[][] tableItems = null;
		try {
		     Connection con = conn.getConnection(); 
		     Statement st = (Statement) con.createStatement(); 
		     Statement stmt = (Statement) con.createStatement();
		     
		     ResultSet rs1 = stmt.executeQuery("Select Count(*) from stok");
		     rs1.next();
		     ResultSet rs2 = st.executeQuery("select * from birim");
		     int stokCount = rs1.getInt(1);
		     
		     tableItems = new String[stokCount][9];
		     int index = 1;
		     while (rs2.next())
				{
					tableItems[index][0] = rs2.getString("Id");
					tableItems[index][1] = rs2.getString(2);
					tableItems[index][2] = rs2.getString(3);
					tableItems[index][3] = rs2.getString(4);
					tableItems[index][4] = rs2.getString(5);
					tableItems[index][5] = rs2.getString(6);						
					tableItems[index][6] = rs2.getString(7);
					tableItems[index][7] = rs2.getString(8);
					tableItems[index][8] = rs2.getTimestamp(9).toString();
					index++;
				}
		     
		     //JTable table = new JTable(buildTableModel(rs));
		     con.close();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
	}
		
        TableModel model = new DefaultTableModel(tableItems, header);
        table.setModel(model);
	}
}
