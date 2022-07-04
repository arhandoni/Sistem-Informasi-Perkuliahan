
package LatihanFormMahasiswa;
import controller.CRUD;
import controller.KoneksiDB;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
*
* @author Doni
*/


public class LatihanFormMahasiswa extends JFrame implements ActionListener {
 
 private Container konten = new Container();
 private JPanel panel1 = new JPanel();
 private JPanel panel2 = new JPanel();
 private JLabel labelForm,
 labelSistem,
 labelNIM,
 labelNama,
 labelAlamat,
 labelTanggalLahir,
 labelJenisKelamin,
 labelStatus;
 private JTextField txtNIM, txtNama, txtTanggalLahir;
 private JTextArea txtAlamat = new JTextArea();
 
 private ButtonGroup grpJenisKelamin = new ButtonGroup();
 private JRadioButton rdPerempuan = new JRadioButton("Perempuan");
 private JRadioButton rdLaki = new JRadioButton("Laki-laki");
 private JRadioButton rdBimbang = new JRadioButton("Bimbang");
 
 String arrStatus[] = {"Aktif", "Tidak-aktif"};
 private JComboBox cmbStatus = new JComboBox(arrStatus);
 
 private JButton btnShow, 
 btnUpdate, 
 btnDelete, 
 btnClear,
 btnInsert,
 btnClose;
 
 KoneksiDB koneksiDB;
 Connection connection;
 
 LatihanFormMahasiswa() {
 super("Form Master Mahasiswa");
 setLocation(300, 200);
 setSize(630,450);
 
 //memanggil class KoneksiDB
 koneksiDB = new KoneksiDB();
 //menjalankan open koneksi
 connection = koneksiDB.openConnection();
 
 
 konten = getContentPane();
 panel1.setLayout(null);
 
 labelForm = new JLabel("FORM MASTER MAHASISWA");
 labelForm.setFont(new Font("Serif", 1, 16));
 labelForm.setForeground(Color.BLACK);
 labelForm.setHorizontalAlignment(SwingConstants.CENTER);
 labelForm.setHorizontalTextPosition(SwingConstants.CENTER);
 labelForm.setBounds(0, 5, 580, 30);
 
 labelSistem = new JLabel("Aplikasi Sistem Informasi Perkuliahan");
 labelSistem.setFont(new Font("Serif", 1, 16));
 labelSistem.setForeground(Color.BLACK);
 labelSistem.setHorizontalAlignment(SwingConstants.CENTER);
 labelSistem.setHorizontalTextPosition(SwingConstants.CENTER);
 labelSistem.setBounds(0, 35, 580, 30);
 
 labelNIM = new JLabel("NIM:\t");
 labelNIM.setForeground(Color.BLACK);
 labelNIM.setBounds(50, 90, 150, 25);
 
 labelNama = new JLabel("Nama:\t");
 labelNama.setForeground(Color.BLACK);
 labelNama.setBounds(50, 125, 150, 25);
 
 labelAlamat = new JLabel("Alamat:\t");
 labelAlamat.setForeground(Color.BLACK);
 labelAlamat.setBounds(50, 155, 150, 25);
 
 labelTanggalLahir = new JLabel("Tanggal Lahir:\t");
 labelTanggalLahir.setForeground(Color.BLACK);
 labelTanggalLahir.setBounds(50, 190, 150, 25);
 
 labelJenisKelamin = new JLabel("Jenis Kelamin:\t");
 labelJenisKelamin.setForeground(Color.BLACK);
 labelJenisKelamin.setBounds(50, 225, 150, 25);
 
 labelStatus = new JLabel("Status:\t");
 labelStatus.setForeground(Color.BLACK);
 labelStatus.setBounds(50, 255, 150, 25);
 
 txtNIM = new JTextField();
 txtNIM.setHorizontalAlignment(JTextField.LEFT);
 txtNIM.setBounds(210, 90, 80, 25);
 
 txtNama = new JTextField();
 txtNama.setHorizontalAlignment(JTextField.LEFT);
 txtNama.setBounds(210, 125, 240, 25);
 
 txtAlamat = new JTextArea();
 txtAlamat.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
 txtAlamat.setBounds(210, 155, 200, 25);
 
 txtTanggalLahir = new JTextField();
 txtTanggalLahir.setHorizontalAlignment(JTextField.LEFT);
 txtTanggalLahir.setBounds(210, 190, 240, 25);
 
 grpJenisKelamin.add(rdLaki);
 grpJenisKelamin.add(rdPerempuan);
 grpJenisKelamin.add(rdBimbang);
 
 panel2.setLayout(new GridLayout(1, 3));
 panel2.add(rdLaki);
 panel2.add(rdPerempuan);
 panel2.add(rdBimbang);
 panel2.setBounds(210, 225, 310, 25);
 
 cmbStatus.setSelectedIndex(0);
 cmbStatus.setMaximumRowCount(2);
 cmbStatus.setBounds(210, 255, 80, 25);
 
 btnShow = new JButton("Show");
 btnShow.setBounds(50, 290, 100, 30);
 btnShow.addActionListener(this);
 
 btnUpdate = new JButton("Update");
 btnUpdate.setBounds(160, 290, 100, 30);
 btnUpdate.addActionListener(this);
 
 btnDelete = new JButton("Delete");
 btnDelete.setBounds(270, 290, 100, 30);
 btnDelete.addActionListener(this);
 
 btnClear = new JButton("Clear");
 btnClear.setBounds(380, 290, 100, 30);
 btnClear.addActionListener(this);
 
 btnInsert = new JButton("Insert");
 btnInsert.setBounds(490, 290, 100, 30);
 btnInsert.addActionListener(this);
 
 btnClose = new JButton("Close");
 btnClose.setBounds(270, 330, 100, 30);
 btnClose.addActionListener(this);
 
 //add elemen to panel
 panel1.add(labelForm);
 panel1.add(labelSistem);
 panel1.add(labelNIM);
 panel1.add(labelNama);
 panel1.add(labelAlamat);
 panel1.add(labelTanggalLahir);
 panel1.add(labelJenisKelamin);
 panel1.add(labelStatus);
 panel1.add(txtNIM);
 panel1.add(txtNama);
 panel1.add(txtAlamat);
 panel1.add(txtTanggalLahir);
 panel1.add(panel2);
 panel1.add(cmbStatus);
 panel1.add(btnShow);
 panel1.add(btnUpdate);
 panel1.add(btnDelete);
 panel1.add(btnClear);
 panel1.add(btnInsert);
 panel1.add(btnClose);
 setVisible(true);
 
 getContentPane().add(panel1);
 show();
 }
 
 public void actionPerformed(ActionEvent e) {
 Object button = e.getSource();
 if (button == btnInsert) {
 insertData();
 } else if (button == btnShow) {
 showData();
 } else if (button == btnUpdate){
 try {
 updateData();
 } catch (SQLException ex) {
 Logger.getLogger(LatihanFormMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
 }
 } else if (button == btnDelete){
 notReady();
 } else if (button == btnClear){
 clear();
 } else {
 System.exit(0);
 }
 }
 
 void notReady(){
 JOptionPane.showMessageDialog(null, "Maaf.. saat ini fitur belum bersedia!", "INFORMASI",
 JOptionPane.INFORMATION_MESSAGE);
 }
 
 void clear(){
 txtNIM.setText("");
 txtNama.setText("");
 txtAlamat.setText("");
 txtTanggalLahir.setText("");
 }
 
 void showData() {
 String sData;
 sData = "NIM:\t" + txtNIM.getText();
 sData += "\nNama:\t" + txtNama.getText();
 sData += "\nAlamat:\t" + txtAlamat.getText();
 sData += "\nTanggalLahir:\t" + txtTanggalLahir.getText();
 sData += "\nJenisKelamin\t";
 if(rdLaki.isSelected()) {
 sData += "Laki-laki";
 } else if (rdPerempuan.isSelected()) {
 sData += "Perempuan";
 } else if (rdBimbang.isSelected()) {
 sData += "Masih Bimbang";
 } else {
 sData += "Nggak Jelas";
 }
 
 sData += "\nStatus:\t";
 sData += cmbStatus.getItemAt(
 cmbStatus.getSelectedIndex());
 
 JOptionPane.showMessageDialog(null, sData, "Data Tercetak",
 JOptionPane.INFORMATION_MESSAGE);
 }
 
 void insertData() {
 int nim = Integer.parseInt(txtNIM.getText());
 String nama = txtNama.getText();
 String alamat = txtAlamat.getText();
 String tanggalLahir = txtTanggalLahir.getText();
 
 String jenisKelamin = "" ;
 if(rdLaki.isSelected()) {
 jenisKelamin += "Laki-laki";
 } else if (rdPerempuan.isSelected()) {
 jenisKelamin += "Perempuan";
 } else if (rdBimbang.isSelected()) {
 jenisKelamin += "Masih Bimbang";
 } else {
 jenisKelamin += "Nggak Jelas";
 } 
 
 String status =cmbStatus.getItemAt(
 cmbStatus.getSelectedIndex()).toString();
 
 //memanggil class CDRUD
 CRUD crud = new CRUD();
 //insert data mahasiswa 
 boolean isSuccess = crud.insertDataMahasiswa(connection, nim, nama, 
 alamat, jenisKelamin, tanggalLahir, status);
 
 if (isSuccess) {
 JOptionPane.showMessageDialog(null, "Data berhasil disimpan!",
 "Informasi", JOptionPane.INFORMATION_MESSAGE);
 } else {
 JOptionPane.showMessageDialog(null, "Data gagal disimpan!",
 "Informasi", JOptionPane.INFORMATION_MESSAGE);
 }
 }
 
 void updateData() throws SQLException {
 int nim = Integer.parseInt(txtNIM.getText());
 String nama = txtNama.getText();
 String alamat = txtAlamat.getText();
 String tanggalLahir = txtTanggalLahir.getText();
 
 String jenisKelamin = "" ;
 if(rdLaki.isSelected()) {
 jenisKelamin += "Laki-laki";
 } else if (rdPerempuan.isSelected()) {
 jenisKelamin += "Perempuan";
 } else if (rdBimbang.isSelected()) {
 jenisKelamin += "Masih Bimbang";
 } else {
 jenisKelamin += "Nggak Jelas";
 } 
 
 String status =cmbStatus.getItemAt(
 cmbStatus.getSelectedIndex()).toString();
 
 //memanggil class CDRUD
 CRUD crud = new CRUD();
 //update data mahasiswa 
 boolean isSuccess = crud.updateDataMahasiswa(connection, nim, nama, 
 alamat, jenisKelamin, tanggalLahir, status);
 
 if (isSuccess) {
 JOptionPane.showMessageDialog(null, "Data berhasil diupdate!",
 "Informasi", JOptionPane.INFORMATION_MESSAGE);
 } else {
 JOptionPane.showMessageDialog(null, "Data gagal diupdate!",
 "Informasi", JOptionPane.INFORMATION_MESSAGE);
 }
 }
 
 
 public static void main(String[] args){
 new LatihanFormMahasiswa();
 }
}