/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class waaw extends javax.swing.JFrame {

    /**
     * Creates new form waaw
     */
    private DefaultTableModel modelo = new DefaultTableModel();
    private int diametro;
    private String cons = "";

    public waaw(DefaultTableModel mod) {

        initComponents();
        //tabla
        setLocationRelativeTo(null);
        Object[] etiquetas;
        if (ventanap.idioma() == 1) {
            Object[] etiquetas2 = {"API Degree", "Nominal Weight", "Selected"};
            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pipes"));
            cancelar.setText("Cancel");
            aceptar.setText("Accept");
            this.setTitle("Pipe Selection");
            jCheckBox1.setText("Select All");
            etiquetas = etiquetas2;
        } else {
            Object[] etiquetas2 = {"Grado", "Peso", "Selecionado"};
            this.setTitle("Selección de Tubos");
            aceptar.setText("Aceptar");
            cancelar.setText("Cancelar");
            jCheckBox1.setText("Seleccionar Todos");
            etiquetas = etiquetas2;
        }

        mod.setColumnIdentifiers(etiquetas);
        tabla.setModel(mod);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de Tubos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tuberias"));

        tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Grado api", "Peso Nominal", "Selección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Seleccionar todos");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addGap(29, 29, 29)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aceptar)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar)
                    .addComponent(jCheckBox1))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        String consulta = "(Select * from caracteristicas Where grado_api = '";
        Object[] etiquetas;

        if (ventanap.idioma() == 1) {
            Object[] etiquetas2 = {"API Degree", "Nominal Weight"};
            etiquetas = etiquetas2;
        } else {
            Object[] etiquetas2 = {"Grado", "Peso"};
            etiquetas = etiquetas2;
        }


        modelo.setColumnIdentifiers(etiquetas);
        System.out.println("asdhsksagdfslakh"+diametro);
        for (int i = 0; i < tabla.getRowCount(); i++) {

            if ((Boolean) tabla.getValueAt(i, 2)) {


                String[] fila = new String[2];
                fila[0] = tabla.getModel().getValueAt(i, 0).toString();
                fila[1] = tabla.getModel().getValueAt(i, 1).toString();
                System.out.println(fila[0] + fila[1]);
                modelo.addRow(fila);
                consulta = consulta + tabla.getModel().getValueAt(i, 0).toString() + "' And peso_nominal = " + tabla.getModel().getValueAt(i, 1).toString() + " and id_diametro =" + diametro + " ) Union (Select * from caracteristicas Where grado_api = '";

            }
        }

        if (verifcar()) {
            tabla.setModel(modelo);
            consulta = consulta.substring(0, consulta.length() - 56);
            System.out.println(consulta);
            cons = consulta;
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione por lo menos una tuberia", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aceptarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here: 
    }//GEN-LAST:event_tablaMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:

        dispose();

    }//GEN-LAST:event_cancelarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < tabla.getRowCount(); i++) {

            if (!(Boolean) tabla.getValueAt(i, 2)) {

                tabla.getModel().setValueAt(true, i, 2);

            } else {

                tabla.getModel().setValueAt(false, i, 2);
            }

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void setModelo(DefaultTableModel mod) {

        tabla.setModel(modelo);

    }

    public DefaultTableModel getTable() {

        return modelo;
    }

    public String getCons() {
        return cons;
    }

    private boolean verifcar() {

        for (int i = 0; i < tabla.getRowCount(); i++) {

            if ((Boolean) tabla.getValueAt(i, 2)) {

                //aceptar.setEnabled(true);
                return true;

            }

        }

        return false;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}