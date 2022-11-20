/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.toedter.calendar.JDateChooser;
import koneksi.koneksi;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ferry
 */
public class data_barang extends javax.swing.JInternalFrame {
private Connection conn = new koneksi().connect();
DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form stokmakanan
     */
    public data_barang() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);       
        table_admin.setModel(table);
        table.addColumn("KODE BARANG");
        table.addColumn("NAMA");
        table.addColumn("KATEGORI");
        table.addColumn("JENIS");
        table.addColumn("HARGA");
        table.addColumn("STOK");
     tampilData();
    }
    
    private void tampilData(){
    int row = table_admin.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        String cariitem = txtcari.getText();
       String query = "SELECT * FROM `tbl_barang` where kode_barang like '%"+cariitem+"%' or nama_barang like '%"+cariitem+"%' or kategori like '%"+cariitem+"%' or jenis like '%"+cariitem+"%' or stok like '%"+cariitem+"%' order by kode_barang asc";
        
        try{

            Statement sttmnt = conn.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String id= rslt.getString("kode_barang");
                    String me = rslt.getString("nama_barang");
                    String har = rslt.getString("kategori");
                    String s = rslt.getString("jenis");
                    String k = rslt.getString("harga");
                    String p = rslt.getString("stok");

                    
                //masukan semua data kedalam array
                String[] data = {id,me,har,s,k,p};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                table_admin.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }

    private void clear(){
//        txt_kodebarang.setText(null);
        harga.setText(null);
        menu.setText(null);
        stok.setText(null);
        jenis.setText(null);
        cb.setSelectedItem(null);
        txtcari.setText("");
        
    }
    
    private void tambahData(){
//        String kode = txt_kodebarang.getText();

        String cariitem = txtcari.getText();
        
        //query untuk memasukan data
        String na = menu.getText();
        String no = harga.getText();
        String pass = stok.getText();
        String ku = cb.getSelectedItem().toString();
        String jen = jenis.getText();
        
        
        //panggil koneksi
        //query untuk memasukan data
        String query = "INSERT INTO `tbl_barang` (`kode_barang`, `nama_barang`, `kategori`, `jenis`, `harga`, `stok`) "
                     + "VALUES (NULL, '"+na+"', '"+ku+"','"+jen+"','"+no+"','"+pass+"')";
                try{
                    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
        ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            tampilData();
            clear();
            
        }
    }
    private void hapusData(){
        //ambill data no pendaftaran
        int i = table_admin.getSelectedRow();
        
        String id = table.getValueAt(i, 0).toString();
        
        
        String query = "DELETE FROM `tbl_barang` WHERE `tbl_barang`.`kode_barang` = "+id+" ";
        try{
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ps.execute();
            JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }finally{
            tampilData();
            clear();
        }
        
    }
    private void editData(){
        int i = table_admin.getSelectedRow();
        
        String id = table.getValueAt(i, 0).toString();
        String na = menu.getText();
        String no = harga.getText();
        String pass = stok.getText();
        String ku = cb.getSelectedItem().toString();
        String jen = jenis.getText();
        
        
        String query = "UPDATE `tbl_barang` SET `nama_barang` = '"+na+"', `kategori` = '"+ku+"', `jenis` = '"+jen+"', `harga` = '"+no+"', `stok` = '"+pass+"' "
                + "WHERE `tbl_barang`.`kode_barang` = '"+id+"';";

        try{
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ps.executeUpdate(query);
            JOptionPane.showMessageDialog(null , "Data Update");
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Gagal Update");
        }finally{
            tampilData();
            clear();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menu = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        harga = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jenis = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtcari = new javax.swing.JTextField();
        refersh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_admin = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Harga");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stok");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 100, 30));
        jPanel2.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, 30));

        cancel.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chevron.png"))); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 140, 40));

        save.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        save.setText("ADD MENU");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 140, 40));

        delete.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-can.png"))); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 140, 40));

        edit.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 140, 40));

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        jPanel2.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 180, 30));

        stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokActionPerformed(evt);
            }
        });
        jPanel2.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 180, 30));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kategori");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));

        cb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Atasan", "Bawahan", "Aksesoris", "Peralatan" }));
        jPanel2.add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 30));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisActionPerformed(evt);
            }
        });
        jPanel2.add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 230));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        refersh.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        refersh.setText("Refresh");
        refersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refershActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_more_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refersh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refersh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcari))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 790, 50));

        table_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_adminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_admin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 770, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        clear();
        tampilData();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        tambahData();
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        editData();
    }//GEN-LAST:event_editActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tampilData();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_txtcariKeyReleased

    private void refershActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refershActionPerformed
        // TODO add your handling code here:
        clear();
        tampilData();
    }//GEN-LAST:event_refershActionPerformed

    private void table_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_adminMouseClicked
        // TODO add your handling code here:
        int baris = table_admin.getSelectedRow();

        String i = table.getValueAt(baris,1).toString();
        menu.setText(i);
        
        String pa = table.getValueAt(baris, 2).toString();
        cb.setSelectedItem(pa);
        
        String  m = table.getValueAt(baris, 3).toString();
        jenis.setText(m);

        String  ma = table.getValueAt(baris, 4).toString();
        harga.setText(ma);

        String pass = table.getValueAt(baris, 5).toString();
        stok.setText(pass);
        
    }//GEN-LAST:event_table_adminMouseClicked

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokActionPerformed

    private void jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenis;
    private javax.swing.JTextField menu;
    private javax.swing.JButton refersh;
    private javax.swing.JButton save;
    private javax.swing.JTextField stok;
    private javax.swing.JTable table_admin;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
