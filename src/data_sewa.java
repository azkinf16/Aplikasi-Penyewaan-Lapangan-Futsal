

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Dias_Raihan
 */
public class data_sewa extends javax.swing.JFrame {

    static Connection conn;
    static ResultSet res;
    static Statement state;
    
    public data_sewa() {
        initComponents();
        //koneksi ke database
        koneksi DB = new koneksi();
        DB.config();
        conn = DB.connection;
        state = DB.statement;
        tampil();
    }
    
    public void tampil(){
    try{
            Object [] rows={"ID","Kode Lapangan","Tanggal","Jam","Durasi","Nama","No. HP","Uang Muka","Sisa Bayar","Status"};
            DefaultTableModel dtm = new DefaultTableModel(null,rows);
            tbl_data.setModel(dtm);
            tbl_data.setBorder(null);
            
            String tbl_id="",tbl_kode_lapangan="",tbl_tanggal="",tbl_jam="",tbl_durasi="",tbl_nama=""
                    + "",tbl_telepon="",tbl_uang_muka="",tbl_sisa_pembayaran="",tbl_status_pembayaran="";
            try{
                String sql="SELECT * FROM data_sewa";
                state=conn.createStatement();
                res=state.executeQuery(sql);
                while(res.next()){
                    tbl_id=res.getString("tbl_id");
                    tbl_kode_lapangan=res.getString("tbl_kode_lapangan");
                    tbl_tanggal=res.getString("tbl_tanggal");
                    tbl_jam=res.getString("tbl_jam");
                    tbl_durasi=res.getString("tbl_durasi");
                    tbl_nama=res.getString("tbl_nama");
                    tbl_telepon=res.getString("tbl_telepon");
                    tbl_uang_muka=res.getString("tbl_uang_muka");
                    tbl_sisa_pembayaran=res.getString("tbl_sisa_pembayaran");
                    tbl_status_pembayaran=res.getString("tbl_status_pembayaran");
                    String [] tampil={""+tbl_id,tbl_kode_lapangan,tbl_tanggal,tbl_jam,tbl_durasi,tbl_nama
                            ,tbl_telepon,tbl_uang_muka,tbl_sisa_pembayaran,tbl_status_pembayaran};
                    dtm.addRow(tampil);
                }
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Query Salah "+e);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void hapus(){
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete Record Ini???",
            "Confirmation",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            try{
                String sql="delete from data_sewa where tbl_id='"+tbl_data.getValueAt(tbl_data.getSelectedRow(), 0)+"'";
                PreparedStatement state=conn.prepareStatement(sql);
                state.executeUpdate();
                tampil();
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Delete Data Gagal");
            }
        }
    }
    
    public void cari(){
        Object [] rows={"ID","Kode Lapangan","Tanggal","Jam","Durasi","Nama","No. HP","Uang Muka","Sisa Bayar","Status"};
            DefaultTableModel dtm = new DefaultTableModel(null,rows);
            tbl_data.setModel(dtm);
            tbl_data.setBorder(null);
        
        
        String tbl_id="",tbl_kode_lapangan="",tbl_tanggal="",tbl_jam="",tbl_durasi="",tbl_nama=""
                    + "",tbl_telepon="",tbl_uang_muka="",tbl_sisa_pembayaran="",tbl_status_pembayaran="";
        
        String cari = txt_cari.getText();
        
        try{
                String sql="SELECT * FROM data_sewa WHERE tbl_id LIKE '%"+cari+"%'"
                        + "OR tbl_kode_lapangan LIKE '%"+cari+"%' OR tbl_tanggal LIKE '%"+cari+"%'"
                        + "OR tbl_jam LIKE '%"+cari+"%' OR tbl_durasi LIKE '%"+cari+"%'"
                        + "OR tbl_nama LIKE '%"+cari+"%' OR tbl_telepon LIKE '%"+cari+"%'"
                        + "OR tbl_uang_muka LIKE '%"+cari+"%' OR tbl_sisa_pembayaran LIKE '%"+cari+"%'"
                        + "OR tbl_status_pembayaran LIKE '%"+cari+"%' ORDER BY tbl_id";
                state=conn.createStatement();
                res=state.executeQuery(sql);
                while(res.next()){
                    tbl_id=res.getString("tbl_id");
                    tbl_kode_lapangan=res.getString("tbl_kode_lapangan");
                    tbl_tanggal=res.getString("tbl_tanggal");
                    tbl_jam=res.getString("tbl_jam");
                    tbl_durasi=res.getString("tbl_durasi");
                    tbl_nama=res.getString("tbl_nama");
                    tbl_telepon=res.getString("tbl_telepon");
                    tbl_uang_muka=res.getString("tbl_uang_muka");
                    tbl_sisa_pembayaran=res.getString("tbl_sisa_pembayaran");
                    tbl_status_pembayaran=res.getString("tbl_status_pembayaran");
                    String [] tampil={""+tbl_id,tbl_kode_lapangan,tbl_tanggal,tbl_jam,tbl_durasi,tbl_nama
                            ,tbl_telepon,tbl_uang_muka,tbl_sisa_pembayaran,tbl_status_pembayaran};
                    dtm.addRow(tampil);
                }
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Query Salah "+e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        lbl_databooking = new javax.swing.JLabel();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_baru = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        btn_bayar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KIPINDEAS FUTSAL");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbl_data.setAutoCreateRowSorter(true);
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Sewa", "Kode Lapangan", "Tanggal", "Jam", "Durasi", "Nama", "No. HP", "Uang Muka", "Sisa Bayar", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data.setFocusable(false);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data);

        lbl_databooking.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        lbl_databooking.setText("DATA BOOKING");

        btn_perbarui.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btn_perbarui.setText("Perbarui");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_keluar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        btn_baru.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btn_baru.setText("Baru");
        btn_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_baruActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N
        jLabel1.setText("Copyright by. KIPINDEAS");

        btn_cari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_bayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(57, 57, 57)
                                .addComponent(btn_cari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_perbarui)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_databooking, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_databooking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_perbarui)
                    .addComponent(btn_keluar)
                    .addComponent(btn_baru)
                    .addComponent(jLabel1)
                    .addComponent(btn_cari)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_baruActionPerformed
        baru baru = new baru();
        baru.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_baruActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        int i = tbl_data.getSelectedRow();
        if (i==-1){
            return;
        }
        String code = (String)tbl_data.getValueAt(i,0);
        String code1 = (String)tbl_data.getValueAt(i,1);
        String code2 = (String)tbl_data.getValueAt(i,2);
        String code3 = (String)tbl_data.getValueAt(i,3);
        String code4 = (String)tbl_data.getValueAt(i,4);
        String code5 = (String)tbl_data.getValueAt(i,5);
        String code6 = (String)tbl_data.getValueAt(i,6);
        String code7 = (String)tbl_data.getValueAt(i,7);
        String code8 = (String)tbl_data.getValueAt(i,8);
        String code9 = (String)tbl_data.getValueAt(i,9);
        
        perbarui pbd = new perbarui();
        
        pbd.txt_idsewadb.setText(code);
        pbd.cmb_kodelapangandb.setSelectedItem(code1);
        pbd.txt_tanggaldb.setText(code2);
        pbd.txt_jamdb.setText(code3);
        pbd.cmb_durasidb.setSelectedItem(code4);
        pbd.txt_namadb.setText(code5);
        pbd.txt_nohpdb.setText(code6);
        pbd.txt_uangmukadb.setText(code7);
        pbd.txt_sisabayardb.setText(code8);
        pbd.cmb_statusdb.setSelectedItem(code9);
        
        pbd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        hapus();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        cari();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        int i = tbl_data.getSelectedRow();
        if (i==-1){
            return;
        }
        
        String code = (String)tbl_data.getValueAt(i,0);
        String code1 = (String)tbl_data.getValueAt(i,8);
        
        var pls = new pembayaran();
        
        pls.txt_idlunas.setText(code);
        pls.txt_sisabayarbayar.setText(code1);
        
        pls.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_bayarActionPerformed

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
            java.util.logging.Logger.getLogger(data_sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_sewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_baru;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_databooking;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
