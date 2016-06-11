package gui;

import dao.CategoriaDao;
import dao.CuentaDao;
import dao.TransaccionDao;
import dto.Categoria;
import dto.Cuenta;
import dto.Transaccion;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.log4j.LogManager;

public class EditarCuenta extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    private ArrayList<Cuenta> listCuenta;
    private double saldoCuenta;
    private int idCategoria;

    public EditarCuenta(int id) {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarCuentasById(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRealizarTransaccion = new javax.swing.JPanel();
        lbMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbMonto1 = new javax.swing.JLabel();
        txtNombreCuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setTitle("TRANSACCION");

        pnRealizarTransaccion.setBackground(new java.awt.Color(187, 222, 254));
        pnRealizarTransaccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbMonto.setText("Monto inicial:");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel1.setText("Bs.");

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

        lbMonto1.setText("Nombre Cuenta:");

        txtNombreCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCuentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Actualizar Cuenta");

        jLabel3.setText("Numero de cuenta:");

        txtid.setEditable(false);

        javax.swing.GroupLayout pnRealizarTransaccionLayout = new javax.swing.GroupLayout(pnRealizarTransaccion);
        pnRealizarTransaccion.setLayout(pnRealizarTransaccionLayout);
        pnRealizarTransaccionLayout.setHorizontalGroup(
            pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRealizarTransaccionLayout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
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
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(txtNombreCuenta, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)))
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//        obtenerIdCategoria(cbCategoria.getSelectedItem().toString());
//        if (!txtMonto.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && idCategoria > 0 && Integer.parseInt(txtNroCuenta.getText()) > 0) {
//            if (saldoCuenta > Double.parseDouble(txtMonto.getText()) && !cbTipoTransaccion.getSelectedItem().toString().equals("Gasto")) {
               actualizar();
//            } else if (cbTipoTransaccion.getSelectedItem().toString().equals("Ingreso")) {
//                actualizar();
//            } else {
//                JOptionPane.showMessageDialog(this, "El saldo es insuciente", "MENSAJE", JOptionPane.WARNING_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Coloque todos los datos correctamente", "MENSAJE", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCuentaActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbMonto1;
    private javax.swing.JPanel pnRealizarTransaccion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void cargarCuentasById(int id) {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        Cuenta objCuenta = objDao.get(id);
        if (objCuenta != null) {
            txtMonto.setText("" + objCuenta.getSaldo());
            txtNombreCuenta.setText(objCuenta.getNombreCuenta());
        txtid.setText(""+ objCuenta.getIdCuenta());
        }
    }

//    private void obtenerCategoriasByTipo(String tipo) {
//        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
//        listCagtegorias = objDao.getListByTipo(tipo);
//        this.cbCategoria.removeAllItems();
//        listCagtegorias.stream().forEach((list) -> {
//            this.cbCategoria.addItem(list.getNombre());
//        });
//    }

//    private void obtenerIdCategoria(String nombre) {
//        listCagtegorias.stream().filter((objCategoria) -> (objCategoria.getNombre().equals(nombre))).forEach((objCategoria) -> {
//            this.idCategoria = objCategoria.getIdCategoria();
//        });
//    }

//    private String obtenerCategoriaNombre(int idCat) {
//        for (Categoria objCategoria : listCagtegorias) {
//            if (objCategoria.getIdCategoria() == idCat) {
//                return objCategoria.getNombre();
//            }
//        }
//        return "";
//    }

//    private Date obtenerFecha(String fecha, String hour) {
//        int dia = 0;
//        int mes = 0;
//        int year = 0;
//        int hora = 0;
//        int min = 0;
//        int seg = 0;
//        ArrayList<String> numeros = new ArrayList<>();
//        String num[] = fecha.split("/");
//        numeros.addAll(Arrays.asList(num));
//        year = Integer.parseInt(numeros.get(0));
//        mes = Integer.parseInt(numeros.get(1));
//        dia = Integer.parseInt(numeros.get(2));
//        ArrayList<String> numeros2 = new ArrayList<>();
//        String num2[] = hour.split(":");
//        numeros2.addAll(Arrays.asList(num2));
//        hora = Integer.parseInt(numeros2.get(0));
//        min = Integer.parseInt(numeros2.get(1));
//        seg = Integer.parseInt(numeros2.get(2));
//        return new Date(year, mes, dia, hora, min, seg);
//    }

    public void obtenerCuenta(int id) {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        Cuenta cuenta = objDao.get(id);
        this.saldoCuenta = cuenta.getSaldo();
    }

//    private String obtenerFechaSeleccionada() {
//        String mes0 = "";
//        String dia0 = "";
//        int year = dcFecha.getCalendar().get(Calendar.YEAR);
//        int mes = dcFecha.getCalendar().get(Calendar.MONTH) + 1;
//        int dia = dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH);
//        if (mes < 10) {
//            mes0 = "/0" + mes;
//        } else {
//            mes0 = "/" + mes;
//        }
//        if (dia < 10) {
//            dia0 = "/0" + dia;
//        } else {
//            dia0 = "/" + dia;
//        }
//        return year + mes0 + dia0;
//    }

//    private String obtenerHoraSeleccionada() {
//        String hora0 = "";
//        String minutos0 = "";
//        String segundos0 = "";
//        int hora = tcHora.getHours();
//        int minutos = tcHora.getMinutes();
//        int segundos = tcHora.getMinutes();
//        if (hora < 10) {
//            hora0 = "0" + hora + ":";
//        } else {
//            hora0 = hora + ":";
//        }
//        if (minutos < 10) {
//            minutos0 = "0" + minutos + ":";
//        } else {
//            minutos0 = minutos + ":";
//        }
//        if (segundos < 10) {
//            segundos0 = "0" + segundos + ":";
//        } else {
//            segundos0 = segundos + "";
//        }
//        return hora0 + minutos0 + segundos0;
//
//    }

    private void actualizar() {
        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();

            Cuenta obj = new Cuenta();
            obj.setIdCuenta(Integer.parseInt(txtid.getText()));
            obj.setNombreCuenta(txtNombreCuenta.getText());
            obj.setSaldo(Double.parseDouble(txtMonto.getText()));

            objDao.update(obj);
            

            JOptionPane.showMessageDialog(this, "Cuenta realizada con exito", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            ListaCuentas listaCuentas = new ListaCuentas();
            listaCuentas.setVisible(true);
            this.hide();
        } catch (Exception ex) {
            logger.error("Error al realizar Cuenta: " + ex.toString());
            JOptionPane.showMessageDialog(this, "No se pudo realizar la Cuenta ", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
    }

}
