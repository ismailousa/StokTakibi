package windows;

import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class builder {

	private JFrame frame;
	private static JTextField StokKoduTxt;
	private JTextField StokAdiTxt;
	private JTextField BarKoduTxt;
	private JTextField textField_3;
	private JTable table;
	Connect conn = new Connect();

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
		frame.setBounds(100, 100, 555, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama");
		lblAklama.setBounds(283, 65, 99, 14);
		frame.getContentPane().add(lblAklama);
		
		JLabel lblOluturmaTarihi = new JLabel("Olu\u015Fturma Tarihi");
		lblOluturmaTarihi.setBounds(283, 178, 126, 14);
		frame.getContentPane().add(lblOluturmaTarihi);
		
		JButton btnAra = new JButton("Ara");
		btnAra.setBounds(10, 17, 58, 23);
		frame.getContentPane().add(btnAra);
		
		StokKoduTxt = new JTextField();
		StokKoduTxt.setBounds(81, 62, 105, 20);
		frame.getContentPane().add(StokKoduTxt);
		StokKoduTxt.setColumns(10);
		
		StokAdiTxt = new JTextField();
		StokAdiTxt.setBounds(81, 93, 105, 20);
		frame.getContentPane().add(StokAdiTxt);
		StokAdiTxt.setColumns(10);
		
		JComboBox StockTipiCbx = new JComboBox();
		StockTipiCbx.setBounds(81, 124, 105, 20);
		frame.getContentPane().add(StockTipiCbx);
		
		JComboBox BirimCbx = new JComboBox();
		BirimCbx.setBounds(81, 155, 105, 20);
		frame.getContentPane().add(BirimCbx);
		
		BarKoduTxt = new JTextField();
		BarKoduTxt.setBounds(81, 192, 105, 20);
		frame.getContentPane().add(BarKoduTxt);
		BarKoduTxt.setColumns(10);
		
		JComboBox kdvCbx = new JComboBox();
		kdvCbx.setBounds(81, 229, 105, 20);
		frame.getContentPane().add(kdvCbx);
		
		JTextArea AciklamaTxt = new JTextArea();
		AciklamaTxt.setBounds(283, 83, 234, 89);
		frame.getContentPane().add(AciklamaTxt);
		
		textField_3 = new JTextField();
		textField_3.setBounds(81, 17, 105, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JFormattedTextField TarihFtxt = new JFormattedTextField();
		TarihFtxt.setBounds(283, 192, 234, 20);
		frame.getContentPane().add(TarihFtxt);
		TarihFtxt.setValue(Calendar.getInstance().getTime());
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Stok stok = new Stok(StokKoduTxt.getText(),StokAdiTxt.getText(),StockTipiCbx.getSelectedIndex(), BirimCbx.getSelectedIndex(),BarKoduTxt.getText(), kdvCbx.getSelectedIndex(), AciklamaTxt.getText());
				Connect conn = new Connect();
				conn.addStock(stok);
			}
		});
		btnKaydet.setBounds(293, 228, 89, 23);
		frame.getContentPane().add(btnKaydet);
		
		JButton btnDzenle = new JButton("D\u00FCzenle");
		btnDzenle.setBounds(412, 228, 89, 23);
		frame.getContentPane().add(btnDzenle);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 519, 212);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setBounds(29, 115, 51, 14);
		panel.add(lblBirim);
		
		table = new JTable();
		table.setBounds(10, 398, 519, -122);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		frame.getContentPane().add(table);
		
		//conn.insertBirim();
	}
}
