package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
*
* @author anzalf
*/
public class CRUD {
 KoneksiDB koneksiDB;
 
 private Connection connection;
 private PreparedStatement preparedStatement;
 
 public CRUD() {
 koneksiDB = new KoneksiDB();
 }
 
 
 public HashMap getDataDosenByNidn(Connection connection, int nidn) {
 System.out.println("Searching for data dosen ...");
 HashMap data = new HashMap();
 String sql = "SELECT * FROM dosen where nidn = ?";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setInt(1, nidn);
 
 ResultSet result = preparedStatement.executeQuery();
 ResultSetMetaData resultSetMetaData = result.getMetaData();
 
 // untuk mengambil jumlah kolom
 int jumlahKolom = resultSetMetaData.getColumnCount();
 
 while (result.next()) {
 for(int i = 1; i <= jumlahKolom; i++) {
 data.put(resultSetMetaData.getColumnName(i), result.getString(i));
 }
 }
 
 // end of get data
 } catch (Exception e) {
 System.out.println("Error getDataDosenByNidn():" + e);
 e.printStackTrace();
 }
 
 return data;
 }
 
 
 public void deleteDataDosenById(Connection connection, int id) {
 String sql = "DELETE FROM dosen WHERE id = ?";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setInt(1, id);
 
 // execute query
 int rows = preparedStatement.executeUpdate();
 
 // check berhasil delete data atau tidak
 if (rows > 0) {
 System.out.println("Data berhasil dihapus!");
 } else {
 throw new Error("Data gagal dihapus!");
 
 }
 
 } catch (Exception e) {
 System.out.println("Error deleteDataDosenById(): " + e);
 e.printStackTrace();
 }
 
 }
 
 
 public boolean insertDataMahasiswa(Connection connection, Integer nidn,
 String nama, String alamat, String jenisKelamin, 
 String tanggalLahir, String status) {
 String sql = "INSERT INTO mahasiswa (nim, nama, alamat, jenis_kelamin,"
 + " tanggal_lahir, status)"
 + " VALUES (?, ?, ?, ?, ?, ?)";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setInt(1, nidn);
 preparedStatement.setString(2, nama);
 preparedStatement.setString(3, alamat);
 preparedStatement.setString(4, jenisKelamin);
 preparedStatement.setString(5, tanggalLahir);
 preparedStatement.setString(6, status);
 
 //execute query
 int rows = preparedStatement.executeUpdate();
 
 
 //check berhasil insert data atau tidak
 if (rows > 0) {
 System.out.println("Data berhasil disimpan!");
 return true;
 } else {
 System.out.println("Data gagal disimpan!");
 return false;
 }
 } catch (Exception e) {
 System.out.println("Error insertDataMahasiswa(): " + e);
 return false;
 }
 }
 
 public boolean updateDataMahasiswa(Connection connection, int NIM,
 String nama, String alamat, String jenisKelamin, String tanggalLahir, String status) throws 
SQLException {
 String sql = "UPDATE mahasiswa SET NIM = ?, nama = ?, alamat = ?, jenis_kelamin = ?, 
tanggal_lahir = ?, status = ? " 
 + "WHERE id = ?";
 
 int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Record 
ini???","Confirmation",JOptionPane.YES_NO_OPTION);
 
 PreparedStatement st=connection.prepareStatement(sql);
 if(ok==0)
 {
 try
 {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setInt(1, NIM);
 preparedStatement.setString(2, nama);
 preparedStatement.setString(3, alamat);
 preparedStatement.setString(4, jenisKelamin);
 preparedStatement.setString(5, tanggalLahir);
 preparedStatement.setString(6, status);
 //execute query
 int rows = preparedStatement.executeUpdate();
 
 
 //check berhasil update data atau tidak
 if (rows > 0) {
 System.out.println("Data berhasil diupdate!");
 } else {
 throw new Error("Data gagal diupdate!");
 }
 } catch (Exception e) {
 System.out.println("Error updateDataMahasiswa(): " + e);
 
 } 
 
 }
 return false;
 
 }
 
 
 public HashMap getDataMahasiswaByNIM(Connection connection, String nama) {
 System.out.println("Searching for data mahasiswa ...");
 HashMap data = new HashMap();
 String sql = "SELECT * FROM mahasiswa where nama like ?";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setString(1, "%" + nama + "%");
 
 ResultSet result = preparedStatement.executeQuery();
 ResultSetMetaData resultSetMetaData = result.getMetaData();
 
 // untuk mengambil jumlah kolom
 int jumlahKolom = resultSetMetaData.getColumnCount();
 
 while (result.next()) {
 for(int i = 1; i <= jumlahKolom; i++) {
 data.put(resultSetMetaData.getColumnName(i), result.getString(i));
 }
 }
 
 // end of get data
 } catch (Exception e) {
 System.out.println("Error getDataMahasiswaByNama():" + e);
 e.printStackTrace();
 }
 
 return data;
 }
 
 
 public HashMap getDataMatakuliahByNama(Connection connection, String nama) {
 System.out.println("Searching for data matakuliah ...");
 HashMap data = new HashMap();
 String sql = "SELECT * FROM matakuliah where nama like ?";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setString(1, "%" + nama + "%");
 
 ResultSet result = preparedStatement.executeQuery();
 ResultSetMetaData resultSetMetaData = result.getMetaData();
 
 // untuk mengambil jumlah kolom
 int jumlahKolom = resultSetMetaData.getColumnCount();
 
 while (result.next()) {
 for(int i = 1; i <= jumlahKolom; i++) {
 data.put(resultSetMetaData.getColumnName(i), result.getString(i));
 }
 }
 
 // end of get data
 } catch (Exception e) {
 System.out.println("Error getDataMatakuliahByNama():" + e);
 e.printStackTrace();
 }
 
 return data;
 }
 
 
 public HashMap getDataDosenByNama(Connection connection, String nama) {
 System.out.println("Searching for data dosen ...");
 HashMap data = new HashMap();
 String sql = "SELECT * FROM dosen where nama like ?";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setString(1, "%" + nama + "%");
 
 ResultSet result = preparedStatement.executeQuery();
 ResultSetMetaData resultSetMetaData = result.getMetaData();
 
 // untuk mengambil jumlah kolom
 int jumlahKolom = resultSetMetaData.getColumnCount();
 
 while (result.next()) {
 for(int i = 1; i <= jumlahKolom; i++) {
 data.put(resultSetMetaData.getColumnName(i), result.getString(i));
 }
 }
 
 // end of get data
 } catch (Exception e) {
 System.out.println("Error getDataDosenByNama():" + e);
 e.printStackTrace();
 }
 
 return data;
 }
 
 
 public void insertDataPerkuliahan(Connection connection, Integer idMahasiswa,
 Integer idMatakuliah, Integer idDosen, String kelompok, Integer nilai) {
 String sql = "INSERT INTO perkuliahan (id_mahasiswa, id_matakuliah,"
 + "id_dosen, kelompok, nilai)"
 + " VALUES (?, ?, ?, ?, ?)";
 
 try {
 preparedStatement = connection.prepareStatement(sql);
 preparedStatement.setInt(1, idMahasiswa);
 preparedStatement.setInt(2, idMatakuliah);
 preparedStatement.setInt(3, idDosen);
 preparedStatement.setString(4, kelompok);
 preparedStatement.setInt(5, nilai);
 //execute query
 int rows = preparedStatement.executeUpdate();
 
 
 //check berhasil insert data atau tidak
 if (rows > 0) {
 System.out.println("Data berhasil disimpan!");
 } else {
 throw new Error("Data gagal disimpan!");
 }
 } catch (Exception e) {
 System.out.println("Error insertDataPerkuliahan(): " + e);
 e.printStackTrace();
 }
 }

    public boolean insertDataMahasiswa(Connection connection, int nim, String nama, String alamat, String jenisKelamin, String tanggalLahir, String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
 
}
