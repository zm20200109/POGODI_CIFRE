/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.SkriveniBroj;
import model.User;
import server.PokreniServer;

/**
 *
 * @author Acer
 */
public class ServerskaForma extends javax.swing.JFrame {
    User ulogovani = Controller.getInstance().getUlogovani();
    /**
     * Creates new form ServerskaForma
     */
    public ServerskaForma() {
        initComponents();
        btnPokreniIgru.setEnabled(false);
        lblUlogovani.setText("Zdravo, "+ulogovani.getIme() + " "+ ulogovani.getPrezime());
        // dugmici su velicine 75 = ROW HEIGHT 
        jTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                
                if(Controller.getInstance().getBrojevi().size()>=3){
                    JOptionPane.showMessageDialog(null,"Vec ste uneli tri broja!","Upozorenje!",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    int red = e.getFirstRow();
                    int kolona = e.getColumn(); 
                    //vraca prvi red koji se izmenio kao i kolonu od tog
                    //polja koje se izmenilo. 
                    TableModel model = (TableModel)e.getSource();
                    //vraca model izmenjene tabele preko e.getSource()
                    if(model.getValueAt(red,kolona)!=null){ //zato sto pri upisu null u liniji 49 metoda sama poziva sebe!!! ova linija koda za null znaci da metoda prekida izvrsenje
                        int vrednost = (int) model.getValueAt(red, kolona);
                        //System.out.println("Vrednost: "+vrednost);
                        SkriveniBroj sb = new SkriveniBroj(kolona,red,vrednost);
                
                        
                        boolean postoji = Controller.getInstance().postoji(sb);
                        if(postoji){
                            model.setValueAt(null, red, kolona);
                            JOptionPane.showMessageDialog(null, "Objekat vec postoji!", "Postoji!", JOptionPane.INFORMATION_MESSAGE);
                            //OVDE NE MOZE THIS JER JE EVENT E U OVOJ METODI THIS!!!
                        }else{
                        Controller.getInstance().dodajBroj(sb);
                          if(Controller.getInstance().getBrojevi().size()==3){
                            btnPokreniIgru.setEnabled(true);
                        }
                        
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnPokreniIgru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblUlogovani.setToolTipText("");

        jTable.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setFocusable(false);
        jTable.setPreferredSize(new java.awt.Dimension(235, 248));
        jTable.setRowHeight(75);
        jScrollPane1.setViewportView(jTable);

        btnPokreniIgru.setText("POKRENI IGRU");
        btnPokreniIgru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniIgruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(btnPokreniIgru, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnPokreniIgru, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniIgruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniIgruActionPerformed
        // TODO add your handling code here:
        PokreniServer ps = new PokreniServer();
        ps.start();
    }//GEN-LAST:event_btnPokreniIgruActionPerformed

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
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreniIgru;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblUlogovani;
    // End of variables declaration//GEN-END:variables
}
