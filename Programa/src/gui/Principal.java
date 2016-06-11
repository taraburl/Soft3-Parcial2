package gui;

import dao.CuentaDao;
import dto.Cuenta;
import factory.FactoryDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.log4j.PropertyConfigurator;

public class Principal extends javax.swing.JFrame {

    private static double saldoTotal;
    private static ArrayList<Cuenta> listCuentas;

    public Principal() {

        initComponents();
        Panel p = new Panel("../images/ban.jpg");
        this.add(p, BorderLayout.CENTER);
        p.repaint();
        obtenerCuentas();
        pnCuentas.setLayout(new GridLayout(35, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jScrollBar1 = new javax.swing.JScrollBar();
        pnSaldos = new javax.swing.JPanel();
        pnCuentas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingenieria de Software III - Parcial 2");
        setAutoRequestFocus(false);
        setExtendedState(6);
        setIconImage(new ImageIcon("transaccion.png").getImage());

        pnSaldos.setOpaque(false);

        pnCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTA DE CUENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnCuentas.setOpaque(false);

        javax.swing.GroupLayout pnCuentasLayout = new javax.swing.GroupLayout(pnCuentas);
        pnCuentas.setLayout(pnCuentasLayout);
        pnCuentasLayout.setHorizontalGroup(
            pnCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnCuentasLayout.setVerticalGroup(
            pnCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SALDO TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        lbTotal.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(204, 204, 204));
        lbTotal.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbTotal)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnSaldosLayout = new javax.swing.GroupLayout(pnSaldos);
        pnSaldos.setLayout(pnSaldosLayout);
        pnSaldosLayout.setHorizontalGroup(
            pnSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSaldosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSaldosLayout.setVerticalGroup(
            pnSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSaldosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuenta.png"))); // NOI18N
        jMenu1.setText("Cuenta");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCuenta.png"))); // NOI18N
        jMenuItem5.setText("Cuenta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transaccionlogo.png"))); // NOI18N
        jMenu2.setText("Transacciones");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listatranicon.png"))); // NOI18N
        jMenuItem2.setText("Transacciones");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trans.png"))); // NOI18N
        jMenu3.setText("Transferencias");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista_transf.png"))); // NOI18N
        jMenuItem3.setText("Transferencias");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoriaicon.png"))); // NOI18N
        jMenu6.setText("Categoria");
        jMenu6.setToolTipText("");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoria.png"))); // NOI18N
        jMenuItem7.setText("LISTA");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(481, Short.MAX_VALUE)
                .addComponent(pnSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSaldos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaTransacciones().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaTransferencia().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaCuentas().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaCategoria().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem7ActionPerformed
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
        String resource
                = "/auditoria.properties";
        URL configFileResource;
        configFileResource = Principal.class.getResource(resource);
        PropertyConfigurator.configure(configFileResource);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private static javax.swing.JLabel lbTotal;
    public static javax.swing.JPanel pnCuentas;
    private javax.swing.JPanel pnSaldos;
    // End of variables declaration//GEN-END:variables

    public static void obtenerCuentas() {
        lbTotal.setText("");
        pnCuentas.removeAll();
        saldoTotal = 0;
        listCuentas = new ArrayList<>();
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        listCuentas = objDao.getList();
        for (Cuenta listCuenta : listCuentas) {
            saldoTotal = saldoTotal + listCuenta.getSaldo();
            lbTotal.setText(saldoTotal + " Bs.");
            JLabel lbCaja = new JLabel("NOMBRE: " + listCuenta.getNombreCuenta()+"  CUENTA: " + listCuenta.getSaldo() + " Bs.");
            lbCaja.setFont(new Font("Consolas", Font.BOLD, 18));
            lbCaja.setForeground(/*new Color(204, 204, 204)*/Color.WHITE);
            pnCuentas.add(lbCaja);
        }
    }
}
