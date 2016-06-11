package gui;

import dao.CategoriaDao;
import dao.CuentaDao;
import dao.TransaccionDao;
import dto.Categoria;
import factory.FactoryDao;

import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

public class EditarCategoria extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();


    public EditarCategoria(int id) {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarCuentasById(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRealizarTransaccion = new javax.swing.JPanel();
        lbMonto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbMonto1 = new javax.swing.JLabel();
        txtNombreCuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        cbtipo = new javax.swing.JComboBox();

        setTitle("TRANSACCION");

        pnRealizarTransaccion.setBackground(new java.awt.Color(187, 222, 254));
        pnRealizarTransaccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbMonto.setText("tipo:");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbMonto1.setText("Nombre:");

        txtNombreCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCuentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Editar Categoria");

        jLabel3.setText("Id Categoria:");

        txtid.setEditable(false);

        cbtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingreso", "Gasto" }));

        javax.swing.GroupLayout pnRealizarTransaccionLayout = new javax.swing.GroupLayout(pnRealizarTransaccion);
        pnRealizarTransaccion.setLayout(pnRealizarTransaccionLayout);
        pnRealizarTransaccionLayout.setHorizontalGroup(
            pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRealizarTransaccionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCuenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbtipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 103, Short.MAX_VALUE))
        );
        pnRealizarTransaccionLayout.setVerticalGroup(
            pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRealizarTransaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRealizarTransaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ListaCuentas list = new ListaCuentas();
        list.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        actualizar();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbtipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbMonto1;
    private javax.swing.JPanel pnRealizarTransaccion;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void cargarCuentasById(int id) {
        CategoriaDao objCategoriaDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
        Categoria objCuenta = objCategoriaDao.get(id);
        if (objCuenta != null) {
            cbtipo.setSelectedItem(objCuenta.getTipo());
            txtNombreCuenta.setText(objCuenta.getNombre());
            txtid.setText("" + objCuenta.getIdCategoria());
        }
    }

    private void actualizar() {
        try {
            CategoriaDao objCategoriaDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();

            Categoria obj = new Categoria();
            obj.setIdCategoria(Integer.parseInt(txtid.getText()));
            obj.setNombre(txtNombreCuenta.getText());
            obj.setTipo(cbtipo.getSelectedItem().toString());

            objCategoriaDao.update(obj);

            JOptionPane.showMessageDialog(this, "Cuenta realizada con exito", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            ListaCategoria listaCuentas = new ListaCategoria();
            listaCuentas.setVisible(true);
            this.hide();
        } catch (Exception ex) {
            logger.error("Error al realizar Cuenta: " + ex.toString());
            JOptionPane.showMessageDialog(this, "No se pudo realizar la Cuenta ", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
    }

}
