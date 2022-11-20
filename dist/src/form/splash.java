/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.sun.awt.AWTUtilities;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class splash extends javax.swing.JFrame {

    /**
     * Creates new form splash
     */
private Point point = new Point();
   private Dimension dimension = new Dimension();
   private AudioClip audio;
   private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();

    public splash() {
        initComponents();
         try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.fast.FastLookAndFeel());
        }
        catch(Exception e) {
            
        }
        Refresh();
        setIcon();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
    
    }
    private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("WhatsApp Image 2022-06-27 at 21.01.17.JPEG")));
    }
private void intfrom(){
         dimension =getSize();
        Shape shape =new RoundRectangle2D.Float(0,0,dimensi.width-50,dimensi.height-50,25,0);
        AWTUtilities.setWindowShape(this, shape);
    }

 ActionListener actionListener;
    private int i = 0;
    private javax.swing.Timer timer = new javax.swing.Timer(100, actionListener);
    private void Refresh(){
        try {
                ActionListener al = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    i = i+1;
                    jProgressBar1.setValue(i);
                    if(jProgressBar1.getPercentComplete()==1.0){
                        timer.stop();
                        // untuk menon aktifkan form splash
                        setVisible(false);
                        login_admin x = new login_admin();
                        x.setLocation(dimensi.width/2 - x.getWidth()/2,dimensi.height/2 - x.getHeight()/2);
                        x.setVisible(true);
                    }
                }
            };
            timer = new javax.swing.Timer(100, al);
            timer.start();
        } catch(Exception ex) {
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar1.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, java.awt.Color.darkGray));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 370, 25));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LOADING.....");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 140, 20));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/WhatsApp Image 2022-06-27 at 21.03.46.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
