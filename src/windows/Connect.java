package windows;
import java.sql.*;

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

	     st.executeUpdate("INSERT INTO stok Values (" + stok.getStokKodu() + ", "+ stok.getStokAdi() + "," + stok.getStokTipi() + "," + stok.getBirim() + "," + stok.getBarKodu() + "," + stok.getKdvTipi() + "," + stok.getAciklama() + ")");

	     conn.close();
		 System.out.println("Stock Added");
	}

	catch (SQLException ex) {
		System.out.println(ex.getMessage());
}
}

public void deleteStock(Stok stok)
{
	try {
	     Connection conn = getConnection(); 
	     Statement st = (Statement) conn.createStatement(); 

	     st.executeUpdate("DELETE from stok where Id = " + stok.getId() + " ");

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

	     st.executeUpdate("DELETE from stok where Id = " + stok.getId() + " ");

	     conn.close();
		 System.out.println("Stock Deleted");
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
}
