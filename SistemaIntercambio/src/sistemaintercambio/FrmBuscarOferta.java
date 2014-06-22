
package sistemaintercambio;

import Clases.Oferta;
import DAO.OfertaDAO;
import Factory.DAOFactory;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmBuscarOferta extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmBuscarOferta(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;      
    }
    
    private void cargarTBOfertas(ArrayList<Oferta> pOfertas){
        
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{
        "Oferta ID","Monto","Tipo Cambio"}, 0)
        {  
            Class[] types = new Class [] {   
                java.lang.String.class, java.lang.String.class, java.lang.String.class};  

            @Override  
            public Class getColumnClass(int columnIndex) {  
                return types [columnIndex];  
            }  
        }; 

        for(Oferta oferta : pOfertas){
            modeloTabla.addRow(new Object[]{String.valueOf(oferta.getIdOferta()),String.valueOf(oferta.getMonto()),
                                String.valueOf(oferta.getTipoCambio())});
        }
        
        tbOfertas.setModel(modeloTabla);
        
        //center row content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tbOfertas.setDefaultRenderer(String.class, centerRenderer);
    }
    
    private void buscarOferta(){
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        OfertaDAO ofertaDAO = sqlserverFactory.getOfertaDAO();
        
        double montoMin,montoMax,tipoCambioMin,tipoCambioMax;
        String tipo;
        
        ArrayList<Oferta> ofertas = null;
        
        if(txtMontoMin.getText().trim().length() != 0 && txtTipoCambioMin.getText().trim().length() != 0
                && txtMontoMax.getText().trim().length() != 0 && txtTipoCambioMax.getText().trim().length() != 0){
            
            if(rbtnCompra.isSelected())
                tipo = "1";
            else
                tipo = "0";
            
            try{
                montoMin = Double.parseDouble(txtMontoMin.getText());
                tipoCambioMin = Double.parseDouble(txtTipoCambioMin.getText());
                montoMax = Double.parseDouble(txtMontoMax.getText());
                tipoCambioMax = Double.parseDouble(txtTipoCambioMax.getText());
                
                ofertas = ofertaDAO.buscarOferta(tipo, String.valueOf(montoMin),
                        String.valueOf(montoMax), String.valueOf(tipoCambioMin), String.valueOf(tipoCambioMax));
                if(ofertas == null)
                    JOptionPane.showMessageDialog(this, "ERROR");
                else
                    cargarTBOfertas(ofertas);
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
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        rbtnCompra = new javax.swing.JRadioButton();
        lblInicio3 = new javax.swing.JLabel();
        rbtnVenta = new javax.swing.JRadioButton();
        txtMontoMin = new javax.swing.JTextField();
        lblInicio5 = new javax.swing.JLabel();
        txtTipoCambioMin = new javax.swing.JTextField();
        lblInicio6 = new javax.swing.JLabel();
        txtTipoCambioMax = new javax.swing.JTextField();
        lblInicio7 = new javax.swing.JLabel();
        lblInicio8 = new javax.swing.JLabel();
        txtMontoMax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOfertas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Buscar Oferta");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
        lblInicio5.setText("Monto Min:");

        lblInicio6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio6.setText("Tipo Cambio Min:");

        lblInicio7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio7.setText("Tipo Cambio Max:");

        lblInicio8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio8.setText("Monto Max:");

        tbOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oferta ID", "Monto", "Tipo Cambio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbOfertas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInicio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblInicio3)
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbtnCompra)
                                        .addComponent(rbtnVenta))
                                    .addGap(62, 62, 62))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblInicio8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMontoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblInicio5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMontoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblInicio6)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTipoCambioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblInicio7)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTipoCambioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCompra)
                    .addComponent(lblInicio3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnVenta)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio5)
                    .addComponent(txtMontoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio8)
                    .addComponent(txtMontoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio6)
                    .addComponent(txtTipoCambioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoCambioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarOferta();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmParticiOptions frm = new FrmParticiOptions(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBuscarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBuscarOferta("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicio3;
    private javax.swing.JLabel lblInicio5;
    private javax.swing.JLabel lblInicio6;
    private javax.swing.JLabel lblInicio7;
    private javax.swing.JLabel lblInicio8;
    private javax.swing.ButtonGroup radioGroupMoneda;
    private javax.swing.ButtonGroup radioGroupTipo;
    private javax.swing.JRadioButton rbtnCompra;
    private javax.swing.JRadioButton rbtnVenta;
    private javax.swing.JTable tbOfertas;
    private javax.swing.JTextField txtMontoMax;
    private javax.swing.JTextField txtMontoMin;
    private javax.swing.JTextField txtTipoCambioMax;
    private javax.swing.JTextField txtTipoCambioMin;
    // End of variables declaration//GEN-END:variables
}
