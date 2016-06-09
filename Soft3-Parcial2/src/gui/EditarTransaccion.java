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

public class EditarTransaccion extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    private ArrayList<Categoria> listCagtegorias;
    private double saldoCuenta;
    private int idCategoria;

    public EditarTransaccion(int id) {
        initComponents();
        this.setLocationRelativeTo(this);
        cargarTransaccionesById(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRealizarTransaccion = new javax.swing.JPanel();
        lbTipoTransaccion = new javax.swing.JLabel();
        cbTipoTransaccion = new javax.swing.JComboBox<>();
        lbDescripcion = new javax.swing.JLabel();
        lbCuenta = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        btnAddCategoria = new javax.swing.JButton();
        lbMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        dcFecha = new com.toedter.calendar.JDateChooser();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        tcHora = new lu.tudor.santec.jtimechooser.JTimeChooser();
        btnCancelar = new javax.swing.JButton();
        txtNroCuenta = new javax.swing.JTextField();

        setTitle("TRANSACCION");

        pnRealizarTransaccion.setBackground(new java.awt.Color(187, 222, 254));
        pnRealizarTransaccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbTipoTransaccion.setText("TIPO DE TRANSACCION:");

        cbTipoTransaccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingreso", "Gasto" }));

        lbDescripcion.setText("DESCRIPCION:");

        lbCuenta.setText("NRO. DE CUENTA:");

        lbCategoria.setText("CATEGORIA:");

        btnAddCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.png"))); // NOI18N
        btnAddCategoria.setToolTipText("Agregar Nueva Categoria");

        lbMonto.setText("MONTO:");

        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel1.setText("Bs.");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        dcFecha.setDateFormatString("dd/MM/yyyy");

        lbFecha.setText("FECHA:");

        lbHora.setText("HORA:");

        tcHora.setToolTipText("");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNroCuenta.setEditable(false);

        javax.swing.GroupLayout pnRealizarTransaccionLayout = new javax.swing.GroupLayout(pnRealizarTransaccion);
        pnRealizarTransaccion.setLayout(pnRealizarTransaccionLayout);
        pnRealizarTransaccionLayout.setHorizontalGroup(
            pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipoTransaccion)
                                    .addComponent(lbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTipoTransaccion, 0, 143, Short.MAX_VALUE)
                                    .addComponent(txtNroCuenta)))
                            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tcHora, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(269, Short.MAX_VALUE))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );
        pnRealizarTransaccionLayout.setVerticalGroup(
            pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(18, 46, Short.MAX_VALUE)
                        .addComponent(lbHora)
                        .addGap(32, 32, 32))
                    .addGroup(pnRealizarTransaccionLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tcHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnRealizarTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnRealizarTransaccionLayout.createSequentialGroup()
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRealizarTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnRealizarTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ListaTransacciones list = new ListaTransacciones();
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
        obtenerIdCategoria(cbCategoria.getSelectedItem().toString());
        if (!txtMonto.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && idCategoria > 0 && Integer.parseInt(txtNroCuenta.getText()) > 0) {
            if (saldoCuenta > Double.parseDouble(txtMonto.getText()) && !cbTipoTransaccion.getSelectedItem().toString().equals("Gasto")) {
                actualizar();
            } else if (cbTipoTransaccion.getSelectedItem().toString().equals("Ingreso")) {
                actualizar();
            } else {
                JOptionPane.showMessageDialog(this, "El saldo es insuciente", "MENSAJE", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Coloque todos los datos correctamente", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbTipoTransaccion;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCuenta;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbTipoTransaccion;
    private javax.swing.JPanel pnRealizarTransaccion;
    private lu.tudor.santec.jtimechooser.JTimeChooser tcHora;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNroCuenta;
    // End of variables declaration//GEN-END:variables

    private void cargarTransaccionesById(int id) {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        Transaccion objTransaccion = objDao.get(id);
        if (objTransaccion != null) {
            txtMonto.setText("" + objTransaccion.getMonto());
            txtDescripcion.setText(objTransaccion.getDescripcion());
            cbTipoTransaccion.setSelectedItem(objTransaccion.getTipo());
            obtenerCategoriasByTipo(cbTipoTransaccion.getSelectedItem().toString());
            cbCategoria.setSelectedItem(obtenerCategoriaNombre(objTransaccion.getIdCategoria()));
            txtNroCuenta.setText(objTransaccion.getIdCuenta() + "");
            tcHora.setTime(obtenerFecha(objTransaccion.getFecha(), objTransaccion.getHora()));
            dcFecha.setDate(obtenerFecha(objTransaccion.getFecha(), objTransaccion.getHora()));
        }
    }

    private void obtenerCategoriasByTipo(String tipo) {
        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
        listCagtegorias = objDao.getListByTipo(tipo);
        this.cbCategoria.removeAllItems();
        listCagtegorias.stream().forEach((list) -> {
            this.cbCategoria.addItem(list.getNombre());
        });
    }

    private void obtenerIdCategoria(String nombre) {
        listCagtegorias.stream().filter((objCategoria) -> (objCategoria.getNombre().equals(nombre))).forEach((objCategoria) -> {
            this.idCategoria = objCategoria.getIdCategoria();
        });
    }

    private String obtenerCategoriaNombre(int idCat) {
        for (Categoria objCategoria : listCagtegorias) {
            if (objCategoria.getIdCategoria() == idCat) {
                return objCategoria.getNombre();
            }
        }
        return "";
    }

    private Date obtenerFecha(String fecha, String hour) {
        int dia = 0;
        int mes = 0;
        int year = 0;
        int hora = 0;
        int min = 0;
        int seg = 0;
        ArrayList<String> numeros = new ArrayList<>();
        String num[] = fecha.split("/");
        numeros.addAll(Arrays.asList(num));
        year = Integer.parseInt(numeros.get(0));
        mes = Integer.parseInt(numeros.get(1));
        dia = Integer.parseInt(numeros.get(2));
        ArrayList<String> numeros2 = new ArrayList<>();
        String num2[] = hour.split(":");
        numeros2.addAll(Arrays.asList(num2));
        hora = Integer.parseInt(numeros2.get(0));
        min = Integer.parseInt(numeros2.get(1));
        seg = Integer.parseInt(numeros2.get(2));
        return new Date(year, mes, dia, hora, min, seg);
    }

    public void obtenerCuenta(int id) {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        Cuenta cuenta = objDao.get(id);
        this.saldoCuenta = cuenta.getSaldo();
    }

    private String obtenerFechaSeleccionada() {
        String mes0 = "";
        String dia0 = "";
        int year = dcFecha.getCalendar().get(Calendar.YEAR);
        int mes = dcFecha.getCalendar().get(Calendar.MONTH) + 1;
        int dia = dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        if (mes < 10) {
            mes0 = "/0" + mes;
        } else {
            mes0 = "/" + mes;
        }
        if (dia < 10) {
            dia0 = "/0" + dia;
        } else {
            dia0 = "/" + dia;
        }
        return year + mes0 + dia0;
    }

    private String obtenerHoraSeleccionada() {
        String hora0 = "";
        String minutos0 = "";
        String segundos0 = "";
        int hora = tcHora.getHours();
        int minutos = tcHora.getMinutes();
        int segundos = tcHora.getMinutes();
        if (hora < 10) {
            hora0 = "0" + hora + ":";
        } else {
            hora0 = hora + ":";
        }
        if (minutos < 10) {
            minutos0 = "0" + minutos + ":";
        } else {
            minutos0 = minutos + ":";
        }
        if (segundos < 10) {
            segundos0 = "0" + segundos + ":";
        } else {
            segundos0 = segundos + "";
        }
        return hora0 + minutos0 + segundos0;

    }

    private void actualizar() {
        try {
            TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();

            Transaccion obj = new Transaccion();
            obj.setDescripcion(txtDescripcion.getText());
            obj.setFecha(obtenerFechaSeleccionada());
            obj.setHora(obtenerHoraSeleccionada());
            obj.setIdCategoria(idCategoria);
            obj.setIdCuenta(Integer.parseInt(txtNroCuenta.getText()));
            obj.setMonto(Double.parseDouble(txtMonto.getText()));
            obj.setTipo(cbTipoTransaccion.getSelectedItem().toString());

            int id = objDao.insert(obj);
            obj = objDao.get(id);

            JOptionPane.showMessageDialog(this, "Transaccion realizada con exito", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            ListaTransacciones listTranscciones = new ListaTransacciones();
            listTranscciones.setVisible(true);
            this.hide();
        } catch (Exception ex) {
            logger.error("Error al realizar Transaccion: " + ex.toString());
            JOptionPane.showMessageDialog(this, "No se pudo realizar la transaccion ", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
    }

}
