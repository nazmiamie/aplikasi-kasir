/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ferry
 */
public class popup_barang2 extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
DefaultTableModel table = new DefaultTableModel();
public  barang_masuk kd = null;
    /**
     * Creates new form daftarmenu
     */
    public popup_barang2() {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

// membuat titik x dan y
int x = layar.width / 2  - this.getSize().width / 2;
int y = layar.height / 2 - this.getSize().height / 2;

this.setLocation(x, y);
       
        table_barang.setModel(table);
        table.addColumn("KODE BARANG");
        table.addColumn("NAMA");
        table.addColumn("KATEGORI");
        table.addColumn("JENIS");
        table.addColumn("HARGA");
        table.addColumn("STOK");
         clear();
     tampilData();
    }
    
       private void tampilData(){
    int row = table_barang.getRowCount();
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
                table_barang.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
   
   private void clear(){
        txtcari.setText("");
        
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
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        refersh1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DAFTAR BARANG");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 310, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 830, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0), new java.awt.Color(153, 102, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_more_25px.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });
        jPanel3.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 270, 30));

        back.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chevron.png"))); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 30));

        refersh1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        refersh1.setText("Refresh");
        refersh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refersh1ActionPerformed(evt);
            }
        });
        jPanel3.add(refersh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 110, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 830, 50));

        table_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        table_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_barang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 790, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
       dispose();
    }//GEN-LAST:event_backActionPerformed

    private void refersh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refersh1ActionPerformed
        // TODO add your handling code here:
         clear();
    }//GEN-LAST:event_refersh1ActionPerformed

    private void table_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangMouseClicked
        // TODO add your handling code here:
         int tab = table_barang.getSelectedRow();
        kd.kd = table_barang.getValueAt(tab, 0).toString();
        kd.ns = table_barang.getValueAt(tab, 1).toString();
        kd.kt = table_barang.getValueAt(tab, 2).toString();
        kd.jen = table_barang.getValueAt(tab, 3).toString();
        kd.st = table_barang.getValueAt(tab, 5).toString();
        kd.itemTerpilih();
        this.dispose();
    }//GEN-LAST:event_table_barangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(popup_barang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popup_barang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popup_barang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popup_barang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popup_barang2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refersh1;
    private javax.swing.JTable table_barang;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}