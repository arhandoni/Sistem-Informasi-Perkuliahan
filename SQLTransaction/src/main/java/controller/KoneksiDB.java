package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
*
* @author Doni
*/
public class KoneksiDB {
public KoneksiDB () {}
 
public Connection openConnection() {
 Connection connection = null;
 
 
 // Define Connection
 String jdbcURL = "jdbc:mysql://localhost/latihan";
 String username = "root";
 String password = "";
 
 try {
 //open connection
 connection = DriverManager.getConnection(jdbcURL, username, password);
 
 //check apakah koneksi berhasil
 if (connection != null) {
 System.out.println("Berhasil koneksi ke database!");
 return connection;
 } else {
 System.out.println("Gagal koneksi ke database!");
 return null;
 }
 } catch (SQLException ex) {
 ex.printStackTrace();
 }
 return null;
 }
 public Connection closeConnection(Connection connection) {
 try {
 //close connection
 connection.close();
 System.out.println("Berhasil tutup koneksi database!");
 return null;
 } catch (Exception e) {
 throw new Error("gagal tutup koneksi database!" + e);
 }
 
 
 }
} 