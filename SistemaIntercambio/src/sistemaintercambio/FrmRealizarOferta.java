
package sistemaintercambio;

import Clases.Participante;
import Clases.Sesion;
import DAO.OfertaDAO;
import DAO.ParticipanteDAO;
import DAO.SesionDAO;
import Factory.DAOFactory;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class FrmRealizarOferta extends javax.swing.JFrame {

    String encryptedPassword, userId;
    ArrayList<Sesion> sesiones;
    
    public FrmRealizarOferta(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;

        txtFecha.setEditable(false);
        
        ArrayList<Participante> sesiones = new ArrayList<>();
        cargarCMBIds();
    }

    private void cargarCMBIds(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        SesionDAO sesionDAO = sqlserverFactory.getSesionDAO();
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        
        sesiones = sesionDAO.listarSesiones();
        
        for (Sesion sesion : sesiones)
        {
            modeloCombo.addElement(sesion.getIdSesion());
        }
        cmbId.setModel(modeloCombo);
        cargarTBSesiones();
    }
    
    private void cargarTBSesiones(){
        try{
            int id = (int)cmbId.getSelectedItem();
            for(Sesion sesion : sesiones)
            {
                if(sesion.getIdSesion() == id)
                {
                    txtFecha.setText(sesion.getFecha().toString());
                    break;
                }
            }
        }
        catch(Exception e){
            txtFecha.setText("");
        }
        
    }
    
    private void finalizarSesion(){
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        OfertaDAO ofertaDAO = sqlserverFactory.getOfertaDAO();
        
        double monto, tipoCambio;
        String tipo;
        String sesionId = Integer.toString((int)cmbId.getSelectedItem());
        
        if(txtMonto.getText().trim().length() != 0 && txtTipoCambio.getText().trim().length() != 0
                && sesionId.trim().length()  != 0){
            
            if(rbtnCompra.isSelected())
                tipo = "1";
            else
                tipo = "0";
            
            try{
                monto = Double.parseDouble(txtMonto.getText());
                tipoCambio = Double.parseDouble(txtTipoCambio.getText());
                
                boolean succesful = ofertaDAO.crearOferta(userId, String.valueOf(monto),
                        tipo, String.valueOf(tipoCambio), sesionId);
                if(succesful)
                    JOptionPane.showMessageDialog(this, "Oferta ingresada correctamente");
                else
                    JOptionPane.showMessageDialog(this, "Hubo un error al ingresar la oferta");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Digite un monto o tipo de cambio valido por favor");
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Por favor llene todos los espacios solicitados");
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupMoneda = new javax.swing.ButtonGroup();
        radioGroupTipo = new javax.swing.ButtonGroup();
        lblInicio = new javax.swing.JLabel();
        lblInicio1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblInicio4 = new javax.swing.JLabel();
        cmbId = new javax.swing.JComboBox();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        rbtnCompra = new javax.swing.JRadioButton();
        lblInicio3 = new javax.swing.JLabel();
        rbtnVenta = new javax.swing.JRadioButton();
        txtMonto = new javax.swing.JTextField();
        lblInicio5 = new javax.swing.JLabel();
        txtTipoCambio = new javax.swing.JTextField();
        lblInicio6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Realizar Oferta");

        lblInicio1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio1.setText("Fecha:");

        lblInicio4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio4.setText("Sesion ID:");

        cmbId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdActionPerformed(evt);
            }
        });

        btnRealizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRealizar.setText("Realizar");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        radioGroupTipo.add(rbtnCompra);
        rbtnCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnCompra.setSelected(true);
        rbtnCompra.setText("Compra");

        lblInicio3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio3.setText("Tipo:");

        radioGroupTipo.add(rbtnVenta);
        rbtnVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnVenta.setText("Venta");

        lblInicio5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio5.setText("Monto:");

        lblInicio6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio6.setText("Tipo Cambio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInicio)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInicio1)
                            .addComponent(lblInicio4)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInicio6)
                            .addComponent(lblInicio5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha)
                                    .addComponent(cmbId, 0, 170, Short.MAX_VALUE))
                                .addComponent(btnRealizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTipoCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(txtMonto))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(lblInicio3)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnCompra)
                    .addComponent(rbtnVenta))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio4)
                    .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInicio3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnVenta)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio6)
                    .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRealizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        finalizarSesion();
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmParticiOptions frm = new FrmParticiOptions(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdActionPerformed
        // TODO add your handling code here:
        cargarTBSesiones();
    }//GEN-LAST:event_cmbIdActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRealizarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRealizarOferta("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JComboBox cmbId;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicio1;
    private javax.swing.JLabel lblInicio3;
    private javax.swing.JLabel lblInicio4;
    private javax.swing.JLabel lblInicio5;
    private javax.swing.JLabel lblInicio6;
    private javax.swing.ButtonGroup radioGroupMoneda;
    private javax.swing.ButtonGroup radioGroupTipo;
    private javax.swing.JRadioButton rbtnCompra;
    private javax.swing.JRadioButton rbtnVenta;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTipoCambio;
    // End of variables declaration//GEN-END:variables
}
