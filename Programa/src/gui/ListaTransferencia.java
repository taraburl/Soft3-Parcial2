package gui;

import Utils.Modelo;
import dao.TransferenciaDao;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ListaTransferencia extends javax.swing.JFrame {

    //datos de tabla dist
    private boolean canEdit[];
    private Class types[];
    private String header[];
    private int columnas_visibles;
    private Modelo modelo;

    public ListaTransferencia() {
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
        initTable();
        cargarDetalle();
    }

    private void initTable() {

        header = new String[]{"ID", "FECHA", "HORA", "MONTO", "DESCRIPCION", "CUENTA ORIGEN", "CUENTA DESTINO"};
        types = new Class[]{Integer.class, String.class, String.class, Double.class, String.class, String.class, String.class};

        canEdit = new boolean[]{false, false, false, false, false, false, false};

        columnas_visibles = 7;
        modelo = new Modelo(header, types, canEdit, columnas_visibles, -1);
        jtDetalle.setModel(modelo);

        //Ancho de las columnas String
        jtDetalle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtDetalle.getColumnModel().getColumn(1).setPreferredWidth(90);
        jtDetalle.getColumnModel().getColumn(2).setPreferredWidth(90);
        jtDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        jtDetalle.getColumnModel().getColumn(4).setPreferredWidth(180);
        jtDetalle.getColumnModel().getColumn(5).setPreferredWidth(130);
        jtDetalle.getColumnModel().getColumn(6).setPreferredWidth(130);

        alignText(jtDetalle, 0, JLabel.RIGHT);
        alignText(jtDetalle, 1, JLabel.RIGHT);
        alignText(jtDetalle, 2, JLabel.RIGHT);
        alignText(jtDetalle, 3, JLabel.RIGHT);
        alignText(jtDetalle, 4, JLabel.RIGHT);
        alignText(jtDetalle, 5, JLabel.RIGHT);
        alignText(jtDetalle, 6, JLabel.RIGHT);

        jtDetalle.putClientProperty("terminateEditOnFocusLost", true);
        this.modelo.removeModel();

    }

    private void cargarDetalle() {
        modelo.removeModel();
        int row = 0;
        TransferenciaDao objDao = FactoryDao.getFactoryInstance().getNewTransferenciaDao();
        ArrayList<dto.Transferencia> listTransferencia = objDao.getList();
        for (dto.Transferencia objTransferencia : listTransferencia) {

            modelo.addEmptyRowsWithNumbers(1, header.length);

            modelo.setValueAt(objTransferencia.getIdTransferencia(), row, 0);
            modelo.setValueAt(objTransferencia.getFechaHora(), row, 1);
            modelo.setValueAt(objTransferencia.getFechaHora().getHours()+":"+objTransferencia.getFechaHora().getMinutes()+":"+objTransferencia.getFechaHora().getSeconds(), row, 2);
            modelo.setValueAt(objTransferencia.getMonto()+ " Bs.", row, 3);
            modelo.setValueAt(objTransferencia.getDescripcion(), row, 4);
            modelo.setValueAt(objTransferencia.getIdCuentaOrigen(), row, 5);
            modelo.setValueAt(objTransferencia.getIdCuentaDestino(), row, 6);
            row++;
        }

    }

    private void alignText(JTable table, int column, int position) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(position);
        table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalle = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("LISTA TRANFERENCIAS");
        setBackground(new java.awt.Color(187, 222, 254));
        setFocusCycleRoot(false);
        setIconImage(new ImageIcon("src/images/icono_trans.png").getImage());
        setResizable(false);

        jtDetalle.setBackground(new java.awt.Color(187, 222, 254));
        jtDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtDetalle);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify_toolbar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/annul_toolbar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar_transfe.png"))); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new_transfe.png"))); // NOI18N
        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = jtDetalle.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que decea editar", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        } else {
            EditaTransferencia edit = new EditaTransferencia(Integer.parseInt(jtDetalle.getValueAt(fila, 0).toString()));
            edit.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtDetalle.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que decea eliminar", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        } else {
            int i = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                TransferenciaDao objDao = FactoryDao.getFactoryInstance().getNewTransferenciaDao();
                objDao.delete(Integer.parseInt(jtDetalle.getValueAt(fila, 0).toString()));
                modelo.removeRow(fila);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Transferencia().setVisible(true);
            }
        });
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtDetalle;
    // End of variables declaration//GEN-END:variables
}
