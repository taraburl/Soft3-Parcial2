/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.*;
import dto.Cuenta;
import factory.FactoryDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Laus
 */
public class Transferencia extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    private ArrayList<Cuenta> lisCuentas = new ArrayList<>();
    ;
    int idCuenta_ori = 0;
    int idCuenta_des = 0;
    Date fechaHora_actual = new Date();

    public Transferencia() {

        initComponents();
        this.setLocationRelativeTo(this);
        obtenerfechaHoraActual();
        dtHora.setEnabled(false);
        txtSaldo_des.setEditable(false);
        txtSaldo_ori.setEditable(false);
        llenarJcCuenta();

    }

    private void obtenerfechaHoraActual() {
        java.util.Date fecha = new Date();
        dtFecha.setDate(fecha);
        dtHora.setTime(fecha);
        fechaHora_actual = fecha;

    }

    private void llenarJcCuenta() {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        lisCuentas = objDao.getList();
        if (lisCuentas != null) {
            jcCuenta_des.removeAllItems();
            jcCuenta_ori.removeAllItems();
            for (int i = 0; i < lisCuentas.size(); i++) {
                jcCuenta_des.addItem(lisCuentas.get(i).getNombreCuenta().trim());
                jcCuenta_ori.addItem(lisCuentas.get(i).getNombreCuenta().trim());
            }
        }
    }

    public java.sql.Timestamp convertJavaDateToSqlTimestamp(Date fecha) throws java.text.ParseException {

        java.sql.Timestamp sqlTime = new java.sql.Timestamp(fecha.getTime());
        return sqlTime;

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();
        lbHora = new javax.swing.JLabel();
        dtHora = new lu.tudor.santec.jtimechooser.JTimeChooser();
        lbDescripcion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbCuenta = new javax.swing.JLabel();
        jcCuenta_des = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        txtSaldo_des = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lbCuenta1 = new javax.swing.JLabel();
        jcCuenta_ori = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo_ori = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setTitle("TRANSFERENCIA");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(187, 222, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon("src/images/icono_trans.png").getImage());

        jPanel3.setBackground(new java.awt.Color(187, 222, 254));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Bs.");

        lbFecha.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbFecha.setText("FECHA:");

        dtFecha.setDateFormatString("dd/MM/yyyy");

        lbHora.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbHora.setText("HORA:");

        dtHora.setToolTipText("");

        lbDescripcion.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbDescripcion.setText("DESCRIPCION:");

        jPanel1.setBackground(new java.awt.Color(187, 222, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Destino"));

        lbCuenta.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbCuenta.setText("SELECCIONAR CUENTA:");

        jcCuenta_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCuenta_desActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("SALDO:");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Bs.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbCuenta)
                    .addComponent(jcCuenta_des, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSaldo_des, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcCuenta_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lbMonto.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbMonto.setText("MONTO A TRANFERIR:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trans.png"))); // NOI18N
        jButton1.setText("TRANSFERIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar_transfe.png"))); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel2.setBackground(new java.awt.Color(187, 222, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Origen"));
        jPanel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        lbCuenta1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbCuenta1.setText("SELECCIONAR CUENTA:");

        jcCuenta_ori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCuenta_oriActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("SALDO:");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel5.setText("Bs.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCuenta1)
                    .addComponent(jLabel4)
                    .addComponent(jcCuenta_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSaldo_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcCuenta_ori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo_ori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFecha)
                .addGap(4, 4, 4)
                .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHora)
                .addGap(4, 4, 4)
                .addComponent(dtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') & (car != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!txtMonto.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && idCuenta_des > 0 && idCuenta_ori > 0) {
            if (jcCuenta_ori.getSelectedIndex() != jcCuenta_des.getSelectedIndex()) {
                if (Double.parseDouble(txtSaldo_ori.getText()) >= Double.parseDouble(txtMonto.getText())) {
                    try {
                        TransferenciaDao objDao = FactoryDao.getFactoryInstance().getNewTransferenciaDao();

                        dto.Transferencia obj = new dto.Transferencia();
                        obj.setMonto(Double.parseDouble(txtMonto.getText()));
                        obj.setFechaHora(convertJavaDateToSqlTimestamp(fechaHora_actual));
                        obj.setDescripcion(txtDescripcion.getText());
                        obj.setIdCuentaOrigen(idCuenta_ori);
                        obj.setIdCuentaDestino(idCuenta_des);

                        int id = objDao.insert(obj);
                        obj = objDao.get(id);

                        JOptionPane.showMessageDialog(this, "Transferencia realizada con exito", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                        ListaTransferencia listaTransferencias = new ListaTransferencia();
                        listaTransferencias.setVisible(true);
                        Principal.obtenerCuentas();
                        this.hide();
                    } catch (Exception ex) {
                        logger.debug("Error al realizar Transferencia: " + ex.toString());
                        JOptionPane.showMessageDialog(this, "No se pudo realizar la transferencia ", "MENSAJE", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente para realizar la transferencia, su saldo actual es "
                            + txtSaldo_ori.getText() + " Bs.", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese cuentas distintas para transferir", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos correctamente", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcCuenta_oriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCuenta_oriActionPerformed
        lisCuentas.stream().filter((objCuenta) -> (jcCuenta_ori.getSelectedItem().toString().equals(objCuenta.getNombreCuenta()))).forEach((objCuenta) -> {
            txtSaldo_ori.setText(objCuenta.getSaldo() + "");
            idCuenta_ori = objCuenta.getIdCuenta();
        });


    }//GEN-LAST:event_jcCuenta_oriActionPerformed

    private void jcCuenta_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCuenta_desActionPerformed
        lisCuentas.stream().filter((objCuenta) -> (jcCuenta_des.getSelectedItem().toString().equals(objCuenta.getNombreCuenta()))).forEach((objCuenta) -> {
            txtSaldo_des.setText(objCuenta.getSaldo() + "");
            idCuenta_des = objCuenta.getIdCuenta();
        });
    }//GEN-LAST:event_jcCuenta_desActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.hide();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaTransferencia().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dtFecha;
    private lu.tudor.santec.jtimechooser.JTimeChooser dtHora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCuenta_des;
    private javax.swing.JComboBox<String> jcCuenta_ori;
    private javax.swing.JLabel lbCuenta;
    private javax.swing.JLabel lbCuenta1;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtSaldo_des;
    private javax.swing.JTextField txtSaldo_ori;
    // End of variables declaration//GEN-END:variables
}
