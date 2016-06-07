package gui;

import dao.TransaccionDao;
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
    private int idTransaccion;

    public ListaTransacciones() {
        initComponents();
        this.setLocationRelativeTo(this);
        tableModel();
        idTransaccion = 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        pnCuentas = new javax.swing.JPanel();
        pnTransacciones = new javax.swing.JPanel();
        lbCuenta = new javax.swing.JLabel();
        cbCuenta = new javax.swing.JComboBox<String>();
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

        pnCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder("CUENTAS"));

        javax.swing.GroupLayout pnCuentasLayout = new javax.swing.GroupLayout(pnCuentas);
        pnCuentas.setLayout(pnCuentasLayout);
        pnCuentasLayout.setHorizontalGroup(
            pnCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnCuentasLayout.setVerticalGroup(
            pnCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnTransacciones.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA DE TRANSACCIONES"));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
<<<<<<< HEAD
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new EditaTransferencia().setVisible(true);
                }
            });
=======
            EditarTransaccion edit = new EditarTransaccion(0);
            edit.setVisible(true);
>>>>>>> Implementacion de metodos en la interfaz Transaccion
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblTransacciones.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que decea eliminar", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        } else {
            eleiminar(1);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarActionPerformed
        cargarTransaccionesById(idTransaccion);
    }//GEN-LAST:event_btnMostarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        cargarTodasTransacciones();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaTransacciones().setVisible(true);
            }
        });
    }

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
    private javax.swing.JPanel pnCuentas;
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
        ArrayList<Transaccion> listCagtegorias = objDao.getList();
        for (Transaccion listCagtegoria : listCagtegorias) {
            Object datos[] = {listCagtegoria.getIdTransaccion(), listCagtegoria.getTipo(), listCagtegoria.getIdCategoria(), listCagtegoria.getDescripcion(), listCagtegoria.getIdCuenta(), listCagtegoria.getMonto(), listCagtegoria.getFecha(), listCagtegoria.getHora()};
            dtmTransacciones.addRow(datos);
        }
    }

    private void cargarTransaccionesById(int id) {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        Transaccion transaccion = objDao.get(id);
        if (transaccion != null) {
            Object datos[] = {transaccion.getIdTransaccion(), transaccion.getTipo(), transaccion.getIdCategoria(), transaccion.getDescripcion(), transaccion.getIdCuenta(), transaccion.getMonto(), transaccion.getFecha(), transaccion.getHora()};
            dtmTransacciones.addRow(datos);
        }
    }

    private void eleiminar(int id) {
        TransaccionDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionDao();
        objDao.delete(id);
    }
}
