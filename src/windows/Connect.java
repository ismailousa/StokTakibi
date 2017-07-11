package windows;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import com.mysql.jdbc.Connection;

public class Connect{
	
	
public Connection getConnection()
{
	try {
		
		String url = "jdbc:mysql://localhost:3306/stoktakibi";
		String username = "root";
		String password = "";
		java.sql.Connection connection = DriverManager.getConnection(url, username, password);
	    System.out.println("Database connected!");
	    return connection;
		
	} catch (SQLException e) {
	    throw new IllegalStateException("Cannot connect the database!", e);
	}
}

public void addStock(Stok stok)
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     st.executeUpdate("INSERT INTO stok(StokKodu, StokAdi,StokTipi, Birim, BarKodu, KDV, Aciklama, Tarih)  Values ('" + stok.getStokKodu() + "', '"+ stok.getStokAdi() + "'," + stok.getStokTipi() + "," + stok.getBirim() + ",'" + stok.getBarKodu() + "'," + stok.getKdvTipi() + ",'" + stok.getAciklama() + "', '" + stok.getOlusturmaTarihi() + "')");

	     conn.close();
		 System.out.println("Stock Added");
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
}

public void deleteStock(String Id)
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     st.executeUpdate("DELETE from stok where Id = " + Id + " ");

	     conn.close();
		 System.out.println("Stock Deleted");
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
}

public void updateStock(Stok stok)
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     st.executeUpdate("UPDATE stok set StokKodu = '" + stok.getStokKodu() + "', StokAdi = '" + stok.getStokAdi() + "', StokTipi = " + stok.getStokTipi() + ", Birim = " + stok.getBirim() + ", BarKodu = '" + stok.getBarKodu() + "', KDV = " + stok.getKdvTipi() + ", Aciklama = '" + stok.getAciklama() + "' where Id = " + stok.getId() + " ");

	     conn.close();
		 System.out.println("Stock Updated");
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
}


public void insertBirim()
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     st.executeUpdate("INSERT INTO birim (Adi) Values ('Kilogram')");

	     conn.close();
		    System.out.println("Added");
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
}

public List<String> getCbx(String tableName)
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     ResultSet rs = st.executeQuery("select * from " + tableName + "");
	     List<String> strings = new ArrayList<String>();
	 	while(rs.next()){

	 	     strings.add(rs.getString("Adi"));  // Confirm if "Name" is valid
	 	    }
	 	return strings;
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
	return null;
}

public String getAdi(String Id, String table)
{
	try {
	Connection conn = getConnection(); 
    Statement st = (Statement) conn.createStatement(); 
	ResultSet rs = st.executeQuery("select Adi from " + table + " where Id = " + Id + "");
	rs.next();
	return rs.getString(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    java.sql.ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
}
