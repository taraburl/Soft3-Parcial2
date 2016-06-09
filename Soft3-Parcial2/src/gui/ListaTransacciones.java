package gui;

import dao.CategoriaDao;
import dao.CuentaDao;
import dao.TransaccionDao;
import dto.Categoria;
import dto.Cuenta;
import dto.Transaccion;
import factory.FactoryDao;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.LogManager;

public class ListaTransacciones extends javax.swing.JFrame {

    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    private DefaultTableModel dtmTransacciones;
    private int idCuenta;
    private ArrayList<Cuenta> lisCuentas;

    public ListaTransacciones() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        this.setLocationRelativeTo(this);
        tableModel();
        cargarTodasTransacciones();
        obtenerCuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        pnTransacciones = new javax.swing.JPanel();
        lbCuenta = new javax.swing.JLabel();
        cbCuenta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransacciones = new javax.swing.JTable();
        btnMostar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setTitle("TRANSACCIONES");
        setIconImage(new ImageIcon("transaccion.png").getImage());
        setResizable(false);

        pnTransacciones.setBackground(new java.awt.Color(187, 222, 254));
        pnTransacciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbCuenta.setText("Seleccionar Cuenta:");

        tblTransacciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTransacciones);

        btnMostar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mostrar.png"))); // NOI18N
        btnMostar.setText("MOSTRAR");
        btnMostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarActionPerformed(evt);
            }
        });

        btnMostrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mostrarTodo.png"))); // NOI18N
        btnMostrarTodo.setText("MOSTRAR TODAS LAS TRANSACCIONES");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnTransaccionesLayout = new javax.swing.GroupLayout(pnTransacciones);
        pnTransacciones.setLayout(pnTransaccionesLayout);
        pnTransaccionesLayout.setHorizontalGroup(
            pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(pnTransaccionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTransaccionesLayout.createSequentialGroup()
                        .addComponent(lbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostar)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnTransaccionesLayout.setVerticalGroup(
            pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransaccionesLayout.createSequentialGroup()
                .addGroup(pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMostar)
                        .addComponent(cbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCuenta))
                    .addComponent(btnMostrarTodo)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = tblTransacciones.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que decea editar", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        } else {
            EditarTransaccion edit = new EditarTransaccion(Integer.parseInt(tblTransacciones.getValueAt(fila, 0).toString()));
            edit.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblTransacciones.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que decea eliminar", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        } else {
            eleiminar(Integer.parseInt(tblTransacciones.getValueAt(fila, 0).toString()));
            dtmTransacciones.removeRow(fila);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarActionPerformed
        tableModel();
        obtenerIdCuenta(cbCuenta.getSelectedItem().toString());
        cargarTransaccionesByIdCuenta(idCuenta);
    }//GEN-LAST:event_btnMostarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        tableModel();
        cargarTodasTransacciones();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostar;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JComboBox<String> cbCuenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbCuenta;
    private javax.swing.JPanel pnTransacciones;
    private javax.swing.JTable tblTransacciones;
    // End of variables declaration//GEN-END:variables

    private void tableModel() {
        dtmTransacciones = new DefaultTableModel();
        dtmTransacciones.addColumn("ID");
        dtmTransacciones.addColumn("Tipo");
        dtmTransacciones.addColumn("Categoria");
        dtmTransacciones.addColumn("Descripcion");
        dtmTransacciones.addColumn("ID Cuenta");
        dtmTransacciones.addColumn("Monto Bs.");
        dtmTransacciones.addColumn("Fecha");
        dtmTransacciones.addColumn("Hora");
        tblTransacciones.setModel(dtmTransacciones);
    }

    private void cargarTodasTransacciones() {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        ArrayList<Transaccion> listTransaccion = objDao.getList();
        for (Transaccion objTransaccion : listTransaccion) {
            Object datos[] = {objTransaccion.getIdTransaccion(), objTransaccion.getTipo(), obtenerCategoriaByID(objTransaccion.getIdCategoria()), objTransaccion.getDescripcion(), objTransaccion.getIdCuenta(), objTransaccion.getMonto(), objTransaccion.getFecha(), objTransaccion.getHora()};
            dtmTransacciones.addRow(datos);
        }
    }

    private void cargarTransaccionesByIdCuenta(int id) {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        ArrayList<Transaccion> listTransaccion = objDao.getListByCuenta(id);
        for (Transaccion objTransaccion : listTransaccion) {
            Object datos[] = {objTransaccion.getIdTransaccion(), objTransaccion.getTipo(), obtenerCategoriaByID(objTransaccion.getIdCategoria()), objTransaccion.getDescripcion(), objTransaccion.getIdCuenta(), objTransaccion.getMonto(), objTransaccion.getFecha(), objTransaccion.getHora()};
            dtmTransacciones.addRow(datos);
        }
    }

    private void eleiminar(int id) {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        objDao.delete(id);
    }

    private String obtenerCategoriaByID(int id) {
        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriaDao();
        Categoria objCategoria = objDao.get(id);
        return objCategoria.getNombre();
    }

    private void obtenerCuentas() {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        lisCuentas = objDao.getList();
        this.cbCuenta.removeAllItems();
        lisCuentas.stream().forEach((list) -> {
            this.cbCuenta.addItem(list.getNombreCuenta());
        });
    }

    private void obtenerIdCuenta(String nombre) {
        lisCuentas.stream().filter((objCuenta) -> (nombre.equals(objCuenta.getNombreCuenta()))).forEach((objCuenta) -> {
            this.idCuenta = objCuenta.getIdCuenta();
        });
    }
}
