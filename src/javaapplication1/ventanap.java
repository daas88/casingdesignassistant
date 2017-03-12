/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author daniel
 */
public class ventanap extends javax.swing.JFrame {

    /**
     * Creates new form ventanap
     */
    private MaskFormatter formatter;
    static conexion conn = new conexion("jdbc:postgresql://localhost:5432/revestidores", "postgres", "123");
    static Asd asf = new Asd(conn);
    static Intermedio intermedio = new Intermedio(conn);
    static Superficial suprficial = new Superficial(conn);
    static Produccion produccion = new Produccion(conn);
    static ResultSet res = conn.ExecQuery("SELECT * FROM caracteristicas");
    static waaw ven;
    static ventanaInicial resultado;
    private ResultSet r1 = conn.ExecQuery("SELECT * FROM diametros ORDER BY id_diametro ASC");
    private String col_grado = "Nomenclatura API";
    private String col_peso = "Peso Nominal";
    private static int lang = 0;
    private Object[] datos = new Object[15];
    private int opcion;
    private int selec;
    private String err_msg1 = "Seleccione al menos uno";
    private String err_msg2 = "Hay Campos Vacios";
    private String err_msg3 = "Archivo Inválido";
    private String err_msg4 = "El rango debe ser de 3 a 40";
    private String err_msg5 = "El rango debe ser de 0 a 5000";
    private String err_msg6 = "El rango debe ser de 0 a 3";
    private String err_msg7 = "El rango debe ser de 0 a 3";
    private String err_msg8 = "El rango debe ser de 0 a 3";
    private String err_msg9 = "El rango debe ser de 0 a 10";
    private String err_msg10 = "El rango debe ser de 0 a 10";
    private String err_msg11 = "El rango debe ser de 0 a 10";
    private String err_msg12 = "El rango debe ser de 0 a 10";
    private String err_msg13 = "El rango debe ser de 0 a 5000";
    private String err_msg14 = "El rango debe ser de 3 a 40";
    private String err_msg15 = "El rango debe ser de 0 a 50";
    private String err_msg16 = "El rango debe ser de 0 a 50";
    private String err_msg17 = "El rango debe ser de 0 a 50";
    private String err_msg18 = "El rango debe ser de 3 a 40";
    private String err_msg19 = "El rango debe ser de 0 a 50";
    private String err_msg20 = "El rango debe ser de 0 a 10";
    private String err_msg21 = "El rango debe ser de 0 a 10";
    private String err_msg22 = "El rango debe ser de 0 a 500000";
    private String err_msg23 = "El rango debe ser de 0 a 500000";
    private String err_msg24 = "El rango debe ser de 0 a 500000";
    private String err_msg25 = "El rango debe ser de 1 a 5";
    private String err_msg26 = "El rango debe ser de 1 a 5";
    private String err_msg27 = "El rango debe ser de 1 a 5";
    private String err_msg28 = "El rango debe ser de 1 a 5";
    private String err_msg29 = "El rango debe ser de 1 a 5";
    private String err_msg30 = "El rango debe ser de 1 a 5";
    private String ttulo = "Acerca de...";
    private String acerca = "<html><p align='center'> "
            + "</b><br><br>"
            + "Casing Design Assistant 1.0<br>"
            + "Herramienta para el diseño de revestidores superficiales,<br>"
            + "intermedios y de producción.<br><br>"
            + "Daniel Añez Scott : <a href='mailto:daas171@gmail.com'>daas171@gmail.com</a>  <br>"
            + "José David Castellano: <a href='mailto:josedavid281@gmail.com'>josedavid281@gmail.com</a> <br>"
            + "Asesorados por Rolando Figueroa<br><br>"
            + "Software publicado bajo la licencia GPLv3, detallado aquí: <br/> http://www.viti.es/gnu/licenses/gpl.html"
            + "</p> </html>";

    public ventanap() throws ParseException {

        formatter = new MaskFormatter("***********");
        formatter.setValidCharacters(".0123456789");
        initComponents();
        setTitle("Casing Design Assistant 1.0");
        jTabbedPane1.removeAll();

        jTabbedPane1.add("Superficial", superficial);
        jTabbedPane1.addTab("Intermedio", jPanel1);
        jTabbedPane1.addTab("Producción", jPanel2);

        dens_lodo_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        dens_lodo_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        dens_lodo_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        dens_zap_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        dif_pres_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        dif_pres_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_col_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_col_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_col_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_est_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_est_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_estallido_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_grad_frac_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
//        fs_grad_frac_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_gradfrac_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens1_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens1_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens1_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens2_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens2_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        fs_tens2_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_form_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_form_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_form_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_frac_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        //grad_frac_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_frac_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_gas_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_gas_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        grad_gas_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        long_min_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        long_min_secc_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        long_min_secc_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        no_secc_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        nosecciones_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        num_sec_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        prof_t_int.setFocusLostBehavior(JFormattedTextField.COMMIT);
        prof_tot_prod.setFocusLostBehavior(JFormattedTextField.COMMIT);
        prof_total_sup.setFocusLostBehavior(JFormattedTextField.COMMIT);
        prof_zap_int.setFocusLostBehavior(JFormattedTextField.COMMIT);

        System.out.print("sdsadsadas" + no_secc_prod.getSize());


        setLocationRelativeTo(null);
        lista.removeAllItems();
        lista_pestania_produccion.removeAllItems();
        lista_superficial.removeAllItems();

        try {
            //r1.next();
            while (r1.next()) {
                System.out.println(r1.getString("diametro"));
                lista.addItem(r1.getString("diametro"));
                lista_pestania_produccion.addItem(r1.getString("diametro"));
                lista_superficial.addItem(r1.getString("diametro"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Asd.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        aceptar_int = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        selec_int = new javax.swing.JButton();
        lista = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        num_sec_int = new javax.swing.JFormattedTextField();
        long_min_int = new javax.swing.JFormattedTextField();
        grad_frac_int = new javax.swing.JFormattedTextField();
        fs_grad_frac_int = new javax.swing.JFormattedTextField();
        grad_gas_int = new javax.swing.JFormattedTextField();
        dens_lodo_int = new javax.swing.JFormattedTextField();
        fs_tens2_int = new javax.swing.JFormattedTextField();
        fs_est_int = new javax.swing.JFormattedTextField();
        fs_col_int = new javax.swing.JFormattedTextField();
        fs_tens1_int = new javax.swing.JFormattedTextField();
        grad_form_int = new javax.swing.JFormattedTextField();
        fs_est_int_lab = new javax.swing.JLabel();
        fs_col_int_lab = new javax.swing.JLabel();
        fs_tens1_int_lab = new javax.swing.JLabel();
        grad_form_int_lab = new javax.swing.JLabel();
        grad_gas_int_lab = new javax.swing.JLabel();
        dens_lodo_int_lab = new javax.swing.JLabel();
        fs_grad_frac_int_lab = new javax.swing.JLabel();
        fs_tens2_int_lab = new javax.swing.JLabel();
        grad_frac_int_lab = new javax.swing.JLabel();
        long_min_sec_lab_int = new javax.swing.JLabel();
        no_secc_lab_int = new javax.swing.JLabel();
        prof_t_int_lab = new javax.swing.JLabel();
        prof_zap_int = new javax.swing.JFormattedTextField();
        dens_zap_int = new javax.swing.JFormattedTextField();
        dif_pres_int = new javax.swing.JFormattedTextField();
        prof_zap_int_lab = new javax.swing.JLabel();
        dens_zap_lab_int = new javax.swing.JLabel();
        dif_pres_int_lab = new javax.swing.JLabel();
        prof_t_int = new javax.swing.JFormattedTextField(formatter);
        clr_int = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sup_tab_tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lista_pestania_produccion = new javax.swing.JComboBox();
        selec_pro = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        prof_tot_prod = new javax.swing.JFormattedTextField();
        fs_tens1_prod = new javax.swing.JFormattedTextField();
        dens_lodo_prod = new javax.swing.JFormattedTextField();
        long_min_secc_prod = new javax.swing.JFormattedTextField();
        fs_col_prod = new javax.swing.JFormattedTextField();
        grad_form_prod = new javax.swing.JFormattedTextField();
        fs_tens2_prod = new javax.swing.JFormattedTextField();
        fs_estallido_prod = new javax.swing.JFormattedTextField();
        grad_gas_prod = new javax.swing.JFormattedTextField();
        no_secc_prod = new javax.swing.JFormattedTextField();
        dif_pres_prod = new javax.swing.JFormattedTextField();
        prof_t_pro_lab = new javax.swing.JLabel();
        fs_est_pro_lab = new javax.swing.JLabel();
        no_secc_lab_pro = new javax.swing.JLabel();
        fs_col_pro_lab = new javax.swing.JLabel();
        long_min_sec_lab_pro = new javax.swing.JLabel();
        fs_tens1_pro_lab = new javax.swing.JLabel();
        dif_pres_pro_lab = new javax.swing.JLabel();
        fs_tens2_pro_lab = new javax.swing.JLabel();
        dens_lodo_pro_lab = new javax.swing.JLabel();
        grad_gas_pro_lab = new javax.swing.JLabel();
        grad_form_pro_lab = new javax.swing.JLabel();
        clr_prod = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_prod_tab = new javax.swing.JTable();
        aceptar_pro = new javax.swing.JButton();
        superficial = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_tabla_intermedio = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        lista_superficial = new javax.swing.JComboBox();
        selec_sup = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        prof_total_sup = new javax.swing.JFormattedTextField();
        nosecciones_sup = new javax.swing.JFormattedTextField();
        long_min_secc_sup = new javax.swing.JFormattedTextField();
        grad_gas_sup = new javax.swing.JFormattedTextField();
        dens_lodo_sup = new javax.swing.JFormattedTextField();
        fs_est_sup = new javax.swing.JFormattedTextField();
        fs_col_sup = new javax.swing.JFormattedTextField();
        fs_tens1_sup = new javax.swing.JFormattedTextField();
        grad_form_sup = new javax.swing.JFormattedTextField();
        fs_gradfrac_sup = new javax.swing.JFormattedTextField();
        fs_tens2_sup = new javax.swing.JFormattedTextField();
        grad_frac_sup = new javax.swing.JFormattedTextField();
        fs_est_sup_lab = new javax.swing.JLabel();
        fs_tens2_sup_lab = new javax.swing.JLabel();
        no_sec_lab_sup = new javax.swing.JLabel();
        fs_col_sup_lab = new javax.swing.JLabel();
        long_min_sec_lab_sup = new javax.swing.JLabel();
        fs_tens1_sup_lab = new javax.swing.JLabel();
        grad_frac_sup_lab = new javax.swing.JLabel();
        grad_gas_sup_lab = new javax.swing.JLabel();
        grad_form_sup_lab = new javax.swing.JLabel();
        dens_lodo_sup_lab = new javax.swing.JLabel();
        fs_grad_frac_sup_lab = new javax.swing.JLabel();
        prof_t_sup_lab = new javax.swing.JLabel();
        clr_sup = new javax.swing.JButton();
        aceptar_sup = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo_m = new javax.swing.JMenu();
        abrir_m = new javax.swing.JMenuItem();
        guardar_menu_arch = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        archivo_salir = new javax.swing.JMenuItem();
        ayuda_m = new javax.swing.JMenu();
        cont_ayuda = new javax.swing.JMenuItem();
        idioma_m = new javax.swing.JMenu();
        idioma_ing = new javax.swing.JMenuItem();
        idioma_esp = new javax.swing.JMenuItem();
        ayuda_m_acerca_de = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aceptar_int.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        aceptar_int.setText("Aceptar");
        aceptar_int.setEnabled(false);
        aceptar_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_intActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Diámetros Disponibles"));
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 107));

        selec_int.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        selec_int.setText("Seleccionar");
        selec_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_intActionPerformed(evt);
            }
        });

        lista.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selec_int))
                    .addComponent(lista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selec_int)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de Diseño"));
        jPanel4.setPreferredSize(new java.awt.Dimension(375, 505));

        num_sec_int.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");
        num_sec_int.setPreferredSize(new java.awt.Dimension(113, 19));
        num_sec_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                num_sec_intFocusLost(evt);
            }
        });

        long_min_int.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");
        long_min_int.setPreferredSize(new java.awt.Dimension(113, 19));
        long_min_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                long_min_intFocusLost(evt);
            }
        });

        grad_frac_int.setToolTipText("<html> <b>Gradiente de fractura</b> <br>[lbs/gal] </html>");
        grad_frac_int.setPreferredSize(new java.awt.Dimension(113, 19));
        grad_frac_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_frac_intFocusLost(evt);
            }
        });

        fs_grad_frac_int.setToolTipText("<html> <b>factor de seguridad de Gradiente de Fractura</b> <br>[lbs/gal] </html>");
        fs_grad_frac_int.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fs_grad_frac_int.setPreferredSize(new java.awt.Dimension(103, 19));
        fs_grad_frac_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_grad_frac_intFocusLost(evt);
            }
        });

        grad_gas_int.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");
        grad_gas_int.setPreferredSize(new java.awt.Dimension(103, 19));
        grad_gas_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_gas_intFocusLost(evt);
            }
        });

        dens_lodo_int.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");
        dens_lodo_int.setPreferredSize(new java.awt.Dimension(103, 19));
        dens_lodo_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dens_lodo_intFocusLost(evt);
            }
        });

        fs_tens2_int.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");
        fs_tens2_int.setPreferredSize(new java.awt.Dimension(103, 19));
        fs_tens2_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens2_intFocusLost(evt);
            }
        });

        fs_est_int.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");
        fs_est_int.setPreferredSize(new java.awt.Dimension(103, 19));
        fs_est_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_est_intFocusLost(evt);
            }
        });

        fs_col_int.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");
        fs_col_int.setPreferredSize(new java.awt.Dimension(103, 19));
        fs_col_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs_col_intActionPerformed(evt);
            }
        });
        fs_col_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_col_intFocusLost(evt);
            }
        });

        fs_tens1_int.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");
        fs_tens1_int.setPreferredSize(new java.awt.Dimension(103, 19));
        fs_tens1_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens1_intFocusLost(evt);
            }
        });

        grad_form_int.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");
        grad_form_int.setPreferredSize(new java.awt.Dimension(103, 19));
        grad_form_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_form_intFocusLost(evt);
            }
        });

        fs_est_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_est_int_lab.setText("F.S. Estallido");
        fs_est_int_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");

        fs_col_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_col_int_lab.setText("F.S. Colapso");
        fs_col_int_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");

        fs_tens1_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens1_int_lab.setText("F.S. Tensión 1");
        fs_tens1_int_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");

        grad_form_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_form_int_lab.setText("Grad. Formación");
        grad_form_int_lab.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");

        grad_gas_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_gas_int_lab.setText("Gradiente de gas");
        grad_gas_int_lab.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");

        dens_lodo_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dens_lodo_int_lab.setText("Densidad de Lodo");
        dens_lodo_int_lab.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");

        fs_grad_frac_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_grad_frac_int_lab.setText("F.S. Grad. Fract.");
        fs_grad_frac_int_lab.setToolTipText("<html> <b>factor de seguridad de Gradiente de Fractura</b> <br>[lbs/gal] </html>");

        fs_tens2_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens2_int_lab.setText("F.S. Tensión 2");
        fs_tens2_int_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");

        grad_frac_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_frac_int_lab.setText("Grad. Fractura");
        grad_frac_int_lab.setToolTipText("<html> <b>Gradiente de fractura</b> <br>[lbs/gal] </html>");

        long_min_sec_lab_int.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        long_min_sec_lab_int.setText("Long. Mín sección");
        long_min_sec_lab_int.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");

        no_secc_lab_int.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        no_secc_lab_int.setText("Núm. de Secciones");
        no_secc_lab_int.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");

        prof_t_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        prof_t_int_lab.setText("Profundidad Total");
        prof_t_int_lab.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");

        prof_zap_int.setToolTipText("<html> <b>Profundidad de la zapata del revestidor</b> <br>[pies]</html>");
        prof_zap_int.setPreferredSize(new java.awt.Dimension(103, 19));

        dens_zap_int.setToolTipText("<html> <b>Densidad del lodo a la profundidad de la zapata del revestidor</b> <br>[lbs/gal]</html>");
        dens_zap_int.setPreferredSize(new java.awt.Dimension(103, 19));
        dens_zap_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dens_zap_intFocusLost(evt);
            }
        });

        dif_pres_int.setToolTipText("<html> <b>Diferencial de presión</b> <br>[lpc] </html>");
        dif_pres_int.setPreferredSize(new java.awt.Dimension(103, 19));
        dif_pres_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dif_pres_intActionPerformed(evt);
            }
        });
        dif_pres_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dif_pres_intFocusLost(evt);
            }
        });

        prof_zap_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        prof_zap_int_lab.setText("Prof. Zapata");
        prof_zap_int_lab.setToolTipText("<html> <b>Profundidad de la zapata del revestidor</b> <br>[pies]</html>");

        dens_zap_lab_int.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dens_zap_lab_int.setText("Dens. En zapata");
        dens_zap_lab_int.setToolTipText("<html> <b>Densidad del lodo a la profundidad de la zapata del revestidor</b> <br>[lbs/gal]</html>");

        dif_pres_int_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dif_pres_int_lab.setText("Dif. de Presión");
        dif_pres_int_lab.setToolTipText("<html> <b>Diferencial de presión</b> <br>[lpc] </html>");

        prof_t_int.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");
        prof_t_int.setPreferredSize(new java.awt.Dimension(113, 19));
        prof_t_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_t_intActionPerformed(evt);
            }
        });
        prof_t_int.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prof_t_intFocusLost(evt);
            }
        });

        clr_int.setText("Borrar");
        clr_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clr_intActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grad_frac_int_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(no_secc_lab_int)
                                            .addComponent(prof_t_int_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(grad_gas_int_lab)
                                            .addComponent(dens_lodo_int_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prof_zap_int_lab)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(num_sec_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(prof_t_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(dens_lodo_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(grad_gas_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(grad_frac_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(prof_zap_int, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 19, Short.MAX_VALUE)))
                                .addGap(38, 38, 38))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(long_min_sec_lab_int, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(long_min_int, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_col_int, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_est_int_lab)
                            .addComponent(fs_col_int_lab)
                            .addComponent(fs_tens1_int_lab)
                            .addComponent(fs_tens1_int, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_tens2_int_lab)
                            .addComponent(dens_zap_lab_int)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(grad_form_int_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fs_grad_frac_int_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fs_est_int, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_tens2_int, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grad_form_int, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_grad_frac_int, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dens_zap_int, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dif_pres_int, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dif_pres_int_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clr_int, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fs_est_int_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_est_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(prof_t_int_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prof_t_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(no_secc_lab_int)
                    .addComponent(fs_col_int_lab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_sec_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fs_col_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fs_tens1_int_lab)
                        .addGap(5, 5, 5)
                        .addComponent(fs_tens1_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(fs_tens2_int_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_tens2_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grad_form_int_lab)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(grad_form_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fs_grad_frac_int_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_grad_frac_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(dens_zap_lab_int)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dens_zap_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(long_min_sec_lab_int)
                        .addGap(5, 5, 5)
                        .addComponent(long_min_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(grad_frac_int_lab)
                        .addGap(5, 5, 5)
                        .addComponent(grad_frac_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grad_gas_int_lab)
                        .addGap(3, 3, 3)
                        .addComponent(grad_gas_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dens_lodo_int_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(dens_lodo_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prof_zap_int_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prof_zap_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dif_pres_int_lab)
                .addGap(10, 10, 10)
                .addComponent(dif_pres_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(clr_int, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Tubos Seleccionados"));

        sup_tab_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nomenclatura API", "Peso Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sup_tab_tabla);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar_int, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar_int))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Intermedio", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Diámetros Disponibles"));

        lista_pestania_produccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lista_pestania_produccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        selec_pro.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        selec_pro.setText("Seleccionar");
        selec_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_proActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 252, Short.MAX_VALUE)
                        .addComponent(selec_pro))
                    .addComponent(lista_pestania_produccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lista_pestania_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selec_pro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de Diseño"));
        jPanel6.setPreferredSize(new java.awt.Dimension(399, 354));

        prof_tot_prod.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");
        prof_tot_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prof_tot_prodFocusLost(evt);
            }
        });

        fs_tens1_prod.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");
        fs_tens1_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens1_prodFocusLost(evt);
            }
        });

        dens_lodo_prod.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");
        dens_lodo_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dens_lodo_prodFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dens_lodo_prodFocusLost(evt);
            }
        });

        long_min_secc_prod.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");
        long_min_secc_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                long_min_secc_prodFocusLost(evt);
            }
        });

        fs_col_prod.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");
        fs_col_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs_col_prodActionPerformed(evt);
            }
        });
        fs_col_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_col_prodFocusLost(evt);
            }
        });

        grad_form_prod.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");
        grad_form_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_form_prodFocusLost(evt);
            }
        });

        fs_tens2_prod.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");
        fs_tens2_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens2_prodFocusLost(evt);
            }
        });

        fs_estallido_prod.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");
        fs_estallido_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_estallido_prodFocusLost(evt);
            }
        });

        grad_gas_prod.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");
        grad_gas_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_gas_prodFocusLost(evt);
            }
        });

        no_secc_prod.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");
        no_secc_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                no_secc_prodFocusLost(evt);
            }
        });

        dif_pres_prod.setToolTipText("<html> <b>Diferencial de presión</b> <br>[lpc]</html>");
        dif_pres_prod.setPreferredSize(new java.awt.Dimension(103, 19));
        dif_pres_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dif_pres_prodFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dif_pres_prodFocusLost(evt);
            }
        });

        prof_t_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        prof_t_pro_lab.setText("Profundidad Total");
        prof_t_pro_lab.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");

        fs_est_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_est_pro_lab.setText("F.S. Estallido");
        fs_est_pro_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");

        no_secc_lab_pro.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        no_secc_lab_pro.setText("Núm. de Secciones");
        no_secc_lab_pro.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");

        fs_col_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_col_pro_lab.setText("F.S. Colapso");
        fs_col_pro_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");

        long_min_sec_lab_pro.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        long_min_sec_lab_pro.setText("Long. Mín. Sección");
        long_min_sec_lab_pro.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");

        fs_tens1_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens1_pro_lab.setText("F.S. Tensión 1");
        fs_tens1_pro_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");

        dif_pres_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dif_pres_pro_lab.setText("Dif. de Presión");
        dif_pres_pro_lab.setToolTipText("<html> <b>Diferencial de presión</b> <br>[lpc]</html>");

        fs_tens2_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens2_pro_lab.setText("F.S. Tensión 2");
        fs_tens2_pro_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");

        dens_lodo_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dens_lodo_pro_lab.setText("Densidad de Lodo");
        dens_lodo_pro_lab.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");

        grad_gas_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_gas_pro_lab.setText("Gradiente de Gas");
        grad_gas_pro_lab.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");

        grad_form_pro_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_form_pro_lab.setText("Grad. Formación");
        grad_form_pro_lab.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");

        clr_prod.setText("Borrar");
        clr_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clr_prodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(long_min_sec_lab_pro, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dif_pres_pro_lab)
                                                .addComponent(dif_pres_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(prof_tot_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                                .addComponent(long_min_secc_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(grad_gas_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(grad_gas_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(no_secc_lab_pro, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dens_lodo_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(no_secc_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(0, 43, Short.MAX_VALUE)))
                                .addGap(42, 42, 42))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dens_lodo_pro_lab)
                                    .addComponent(prof_t_pro_lab))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(grad_form_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fs_tens2_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fs_tens2_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grad_form_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_est_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_col_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fs_tens1_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fs_col_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_tens1_pro_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_estallido_prod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clr_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(prof_t_pro_lab))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fs_est_pro_lab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(prof_tot_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(no_secc_lab_pro)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(no_secc_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_col_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(long_min_sec_lab_pro)
                            .addComponent(fs_tens1_pro_lab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(long_min_secc_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fs_tens1_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(fs_tens2_pro_lab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fs_tens2_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(dif_pres_pro_lab)
                                .addGap(7, 7, 7)
                                .addComponent(dif_pres_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grad_gas_pro_lab)
                            .addComponent(grad_form_pro_lab)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(fs_estallido_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_col_pro_lab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grad_gas_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(grad_form_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(3, 3, 3)
                .addComponent(dens_lodo_pro_lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dens_lodo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clr_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tubos Seleccionados"));
        jPanel7.setPreferredSize(new java.awt.Dimension(34, 508));

        tabla_prod_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nomenclatura API", "Peso Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_prod_tab);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        aceptar_pro.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        aceptar_pro.setText("Aceptar");
        aceptar_pro.setEnabled(false);
        aceptar_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_proActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Producción", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Tubos Seleccionados"));

        tab_tabla_intermedio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}

            },
            new String [] {
                col_grado, col_peso
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_tabla_intermedio.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tab_tabla_intermedio);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Diámetros Disponibles"));
        jPanel9.setToolTipText("");
        jPanel9.setPreferredSize(new java.awt.Dimension(150, 107));

        lista_superficial.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lista_superficial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        selec_sup.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        selec_sup.setText("Seleccionar");
        selec_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_supActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selec_sup))
                    .addComponent(lista_superficial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lista_superficial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selec_sup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de Diseño"));
        jPanel10.setToolTipText("");

        prof_total_sup.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");
        prof_total_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_total_supActionPerformed(evt);
            }
        });
        prof_total_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prof_total_supFocusLost(evt);
            }
        });

        nosecciones_sup.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");
        nosecciones_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nosecciones_supFocusLost(evt);
            }
        });

        long_min_secc_sup.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");
        long_min_secc_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                long_min_secc_supFocusLost(evt);
            }
        });

        grad_gas_sup.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");
        grad_gas_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_gas_supFocusLost(evt);
            }
        });

        dens_lodo_sup.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");
        dens_lodo_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dens_lodo_supFocusLost(evt);
            }
        });

        fs_est_sup.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");
        fs_est_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs_est_supActionPerformed(evt);
            }
        });
        fs_est_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_est_supFocusLost(evt);
            }
        });

        fs_col_sup.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");
        fs_col_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_col_supFocusLost(evt);
            }
        });

        fs_tens1_sup.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");
        fs_tens1_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens1_supFocusLost(evt);
            }
        });

        grad_form_sup.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");
        grad_form_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_form_supFocusLost(evt);
            }
        });

        fs_gradfrac_sup.setToolTipText("<html> <b>Factor de seguridad del gradiente de fractura</b> <br>[lbs/gal] </html>");
        fs_gradfrac_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs_gradfrac_supActionPerformed(evt);
            }
        });
        fs_gradfrac_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_gradfrac_supFocusLost(evt);
            }
        });

        fs_tens2_sup.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");
        fs_tens2_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fs_tens2_supActionPerformed(evt);
            }
        });
        fs_tens2_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fs_tens2_supFocusLost(evt);
            }
        });

        grad_frac_sup.setToolTipText("<html> <b>Gradiente de fractura</b> <br>[lbs/gal] </html>");
        grad_frac_sup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                grad_frac_supFocusLost(evt);
            }
        });

        fs_est_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_est_sup_lab.setText("F.S. Estallido");
        fs_est_sup_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por estallido</b> <br>[Adimensional] </html>");

        fs_tens2_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens2_sup_lab.setText("F.S. Tensión 2");
        fs_tens2_sup_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión 2</b> <br>[lbs] </html>");

        no_sec_lab_sup.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        no_sec_lab_sup.setText("Núm. de Secciones");
        no_sec_lab_sup.setToolTipText("<html> <b>Número de secciones</b> <br>[Adimensional] </html>");

        fs_col_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_col_sup_lab.setText("F.S. Colapso");
        fs_col_sup_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por colapso</b> <br>[Adimensional] </html>");

        long_min_sec_lab_sup.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        long_min_sec_lab_sup.setText("Long. Mín. Sección");
        long_min_sec_lab_sup.setToolTipText("<html> <b>Longitud mínima de sección</b> <br>[pies] </html>");

        fs_tens1_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_tens1_sup_lab.setText("F.S. Tensión 1");
        fs_tens1_sup_lab.setToolTipText("<html> <b>Factor de seguridad de diseño por tensión</b> <br>[Adimensional] </html>");

        grad_frac_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_frac_sup_lab.setText("Grad. Fractura");
        grad_frac_sup_lab.setToolTipText("<html> <b>Gradiente de fractura</b> <br>[lbs/gal] </html>");

        grad_gas_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_gas_sup_lab.setText("Gradiente de Gas");
        grad_gas_sup_lab.setToolTipText("<html> <b>Gradiente de gas</b> <br>[lpc/pie] </html>");

        grad_form_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        grad_form_sup_lab.setText("Grad. Formación");
        grad_form_sup_lab.setToolTipText("<html> <b>Gradiente de formación</b> <br>[lpc/pie] </html>");

        dens_lodo_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        dens_lodo_sup_lab.setText("Densidad de Lodo");
        dens_lodo_sup_lab.setToolTipText("<html> <b>Densidad del lodo</b> <br>[lbs/gal] </html>");

        fs_grad_frac_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fs_grad_frac_sup_lab.setText("F.S. Grad. Fract.");
        fs_grad_frac_sup_lab.setToolTipText("<html> <b>Factor de seguridad del gradiente de fractura</b> <br>[lbs/gal] </html>");

        prof_t_sup_lab.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        prof_t_sup_lab.setText("Profundidad Total");
        prof_t_sup_lab.setToolTipText("<html> <b>Profundidad total</b> <br>[pies] </html>");

        clr_sup.setText("Borrar");
        clr_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clr_supActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(long_min_secc_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(long_min_sec_lab_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(no_sec_lab_sup)
                            .addComponent(grad_gas_sup_lab)
                            .addComponent(nosecciones_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(grad_form_sup_lab)
                        .addComponent(grad_form_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dens_lodo_sup_lab)
                        .addComponent(prof_total_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grad_gas_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dens_lodo_sup, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof_t_sup_lab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fs_tens2_sup_lab)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fs_est_sup_lab, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fs_tens2_sup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_tens1_sup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_col_sup_lab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_tens1_sup_lab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fs_col_sup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fs_est_sup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(grad_frac_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fs_gradfrac_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fs_grad_frac_sup_lab)
                    .addComponent(grad_frac_sup_lab))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clr_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(fs_est_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_est_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_col_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_col_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fs_tens1_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_tens1_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fs_tens2_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_tens2_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grad_frac_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grad_frac_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fs_grad_frac_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fs_gradfrac_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(prof_t_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prof_total_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(no_sec_lab_sup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nosecciones_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(long_min_sec_lab_sup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(long_min_secc_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grad_gas_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grad_gas_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dens_lodo_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dens_lodo_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(grad_form_sup_lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grad_form_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clr_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aceptar_sup.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        aceptar_sup.setText("Aceptar");
        aceptar_sup.setEnabled(false);
        aceptar_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_supActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout superficialLayout = new javax.swing.GroupLayout(superficial);
        superficial.setLayout(superficialLayout);
        superficialLayout.setHorizontalGroup(
            superficialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(superficialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(superficialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(superficialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(superficialLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        superficialLayout.setVerticalGroup(
            superficialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(superficialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(superficialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(superficialLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar_sup))
                    .addGroup(superficialLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", superficial);

        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        archivo_m.setText("Archivo");
        archivo_m.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        abrir_m.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        abrir_m.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        abrir_m.setText("Abrir");
        abrir_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_mActionPerformed(evt);
            }
        });
        archivo_m.add(abrir_m);

        guardar_menu_arch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guardar_menu_arch.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        guardar_menu_arch.setText("Guardar");
        guardar_menu_arch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_menu_archActionPerformed(evt);
            }
        });
        archivo_m.add(guardar_menu_arch);
        archivo_m.add(jSeparator1);

        archivo_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        archivo_salir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        archivo_salir.setText("Salir");
        archivo_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivo_salirActionPerformed(evt);
            }
        });
        archivo_m.add(archivo_salir);

        jMenuBar1.add(archivo_m);

        ayuda_m.setText("Ayuda");
        ayuda_m.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        cont_ayuda.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cont_ayuda.setText("Contenidos de Ayuda");
        cont_ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cont_ayudaActionPerformed(evt);
            }
        });
        ayuda_m.add(cont_ayuda);

        idioma_m.setText("Idioma");
        idioma_m.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        idioma_ing.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        idioma_ing.setText("Inglés");
        idioma_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idioma_ingActionPerformed(evt);
            }
        });
        idioma_m.add(idioma_ing);

        idioma_esp.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        idioma_esp.setText("Español");
        idioma_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idioma_espActionPerformed(evt);
            }
        });
        idioma_m.add(idioma_esp);

        ayuda_m.add(idioma_m);

        ayuda_m_acerca_de.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ayuda_m_acerca_de.setText("Acerca de...");
        ayuda_m_acerca_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayuda_m_acerca_deActionPerformed(evt);
            }
        });
        ayuda_m.add(ayuda_m_acerca_de);

        jMenuBar1.add(ayuda_m);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selec_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_intActionPerformed
        // TODO add your handling code here:
        selec = sel();
        System.out.println("sel = " + selec);

        ResultSet tubes = conn.ExecQuery("Select grado_api, peso_nominal from caracteristicas where id_diametro = '" + selec + "'");
        try {

            while (tubes.next()) {

                System.out.println(tubes.getString(1) + " " + tubes.getFloat(2));

            }
            tubes.beforeFirst();

            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public Class getColumnClass(int columnIndex) {
                    if (columnIndex == 2) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            //modelo.addColumn(col_grado);
            //modelo.addColumn(col_grado);
            ResultSetMetaData metaDatos = tubes.getMetaData();
            // Se obtiene el número de columnas.


            // Se crea un array de etiquetas para rellenar
            Object[] etiquetas = {col_grado, col_peso, "Boolean"};

            modelo.setColumnIdentifiers(etiquetas);


            while (tubes.next()) {
                Object[] fila = new Object[3];
                for (int i = 0; i < etiquetas.length; i++) {

                    if (i == 2) {
                        fila[i] = Boolean.FALSE;
                    } else {
                        fila[i] = tubes.getObject(i + 1);
                    }

                }
                modelo.addRow(fila);
                //System.out.println("xcfgg");
            }

            //System.out.print(modelo.getValueAt(2,2));

//            jTable1.setEditingColumn(3);
//            jTable1.setModel(modelo);

            ven = new waaw(modelo);
            ven.setDiametro(selec);
            ven.setVisible(true);
            sup_tab_tabla.setModel(ven.getTable());
            aceptar_int.setEnabled(true);


        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_selec_intActionPerformed

    private void aceptar_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_intActionPerformed
        // TODO add your handling code here:

        if (!prof_t_int.getText().trim().isEmpty() && !"".equals(num_sec_int.getText().trim()) && !"".equals(long_min_int.getText().trim()) && !"".equals(grad_frac_int.getText().trim()) && !"".equals(grad_gas_int.getText().trim()) && !"".equals(dens_lodo_int.getText().trim()) && !"".equals(fs_est_int.getText().trim()) && !"".equals(fs_col_int.getText().trim()) && !"".equals(fs_tens1_int.getText().trim()) && !"".equals(num_sec_int.getText().trim())) {

            System.out.println("Profundidad T =" + prof_t_int.getText());
            System.out.println("Numero de Secciones =" + num_sec_int.getText());
            System.out.println("Longitud Minima de Seccion =" + long_min_int.getText());
            System.out.println("Gradiente de Fractura =" + grad_frac_int.getText());
            System.out.println("Gradiente de Gas =" + grad_gas_int.getText());
            System.out.println("Densidad del Lodo =" + dens_lodo_int.getText());
            System.out.println("Factor de seguridad Estallido =" + fs_est_int.getText());
            System.out.println("Factor de seguridad Colapso =" + fs_col_int.getText());
            System.out.println("Factor de seguridad T1 =" + fs_tens1_int.getText());
            System.out.println("Factor de seguridad T2 =" + fs_tens2_int.getText());
            System.out.println("Gradiemte de Formacion =" + grad_form_int.getText());
            System.out.println("Factor de seguridad Gfr =" + fs_grad_frac_int.getText());

            //Object[] datos = new Object[15];

            datos[0] = prof_t_int.getText().toString();
            datos[1] = num_sec_int.getText().toString();
            datos[2] = long_min_int.getText().toString();
            datos[3] = grad_frac_int.getText().toString();
            datos[4] = grad_gas_int.getText().toString();
            datos[5] = dens_lodo_int.getText().toString();
            datos[6] = prof_zap_int.getText().toString();
            datos[7] = dif_pres_int.getText().toString();
            datos[8] = fs_est_int.getText().toString();
            datos[9] = fs_col_int.getText().toString();
            datos[10] = fs_tens1_int.getText().toString();
            datos[11] = fs_tens2_int.getText().toString();
            datos[12] = grad_form_int.getText().toString();
            datos[13] = fs_grad_frac_int.getText().toString();
            datos[14] = dens_zap_int.getText().toString();

            intermedio.setH((int) Float.parseFloat(prof_t_int.getText()));
            intermedio.setDensidad_lodo(Float.parseFloat(dens_lodo_int.getText().trim()));
            intermedio.setFsc(Float.parseFloat(fs_col_int.getText().trim()));
            intermedio.setFse(Float.parseFloat(fs_est_int.getText().trim()));
            intermedio.setGform(Float.parseFloat(grad_form_int.getText().trim()));
            intermedio.setGfr(Float.parseFloat(grad_frac_int.getText().trim()));
            intermedio.setGg(Float.parseFloat(grad_gas_int.getText().trim()));
            intermedio.setSecciones(Integer.parseInt(num_sec_int.getText().trim()));
            intermedio.setLong_minima_sec(Integer.parseInt(long_min_int.getText().trim()));
            intermedio.setDensidad_zapata(Float.parseFloat(dens_zap_int.getText().trim()));
            intermedio.setProf_zapata(Float.parseFloat(prof_zap_int.getText().trim()));
            intermedio.setDif_pres(Float.parseFloat(dif_pres_int.getText().trim()));
            intermedio.setFs_tension1(Float.parseFloat(fs_tens1_int.getText().trim()));
            intermedio.setFs_tension1(Float.parseFloat(fs_tens2_int.getText().trim()));
            intermedio.setFs_grad_frac(Float.parseFloat(fs_tens1_int.getText().trim()));

            try {

                System.out.println("el diametor" + sel());
                ven.setDiametro(sel());
                intermedio.setDiam(sel());
                intermedio.setConsulta(ven.getCons());
                intermedio.Estallido_Int();

                resultado = new ventanaInicial(intermedio.Colapso2());
                resultado.setDatos(datos);
                opcion = intermedio.getIndex();
                resultado.setVisible(true);

                //asf.tension(TOP_ALIGNMENT, WIDTH);

            } catch (SQLException ex) {
                Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, err_msg2, "Error", JOptionPane.ERROR_MESSAGE);
        }

 }//GEN-LAST:event_aceptar_intActionPerformed

    private void dif_pres_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dif_pres_intActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dif_pres_intActionPerformed

    private void fs_col_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs_col_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fs_col_prodActionPerformed

    private void selec_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_proActionPerformed
        // TODO add your handling code here:

        ///
        selec = sel2();
        System.out.println("Select grado_api, peso_nominal from caracteristicas where id_diametro = '" + selec + "'");
        ResultSet tubes = conn.ExecQuery("Select grado_api, peso_nominal from caracteristicas where id_diametro = '" + selec + "'");
        try {

            while (tubes.next()) {

                System.out.println(tubes.getString(1) + " " + tubes.getFloat(2));

            }
            tubes.beforeFirst();

            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public Class getColumnClass(int columnIndex) {
                    if (columnIndex == 2) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            modelo.addColumn("Grado API");
            modelo.addColumn("Peso Nominal");
            //ResultSetMetaData metaDatos = tubes.getMetaData();
            // Se obtiene el número de columnas.


            // Se crea un array de etiquetas para rellenar
            Object[] etiquetas = {"Grado", "Peso", "Boolean"};

            modelo.setColumnIdentifiers(etiquetas);


            while (tubes.next()) {
                Object[] fila = new Object[3];
                for (int i = 0; i < etiquetas.length; i++) {

                    if (i == 2) {
                        fila[i] = Boolean.FALSE;
                    } else {
                        fila[i] = tubes.getObject(i + 1);
                    }

                }
                modelo.addRow(fila);
                //System.out.println("xcfgg");
            }



            //System.out.print(modelo.getValueAt(2,2));

//            jTable1.setEditingColumn(3);
//            jTable1.setModel(modelo);

            ven = new waaw(modelo);
            ven.setDiametro(selec);
            ven.setVisible(true);
            tabla_prod_tab.setModel(ven.getTable());
            aceptar_pro.setEnabled(true);


        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_selec_proActionPerformed

        private void aceptar_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_proActionPerformed
            // TODO add your handling code here:
            if (!prof_tot_prod.getText().trim().isEmpty() && !"".equals(no_secc_prod.getText().trim()) && !"".equals(long_min_secc_prod.getText().trim()) && !"".equals(grad_gas_prod.getText().trim()) && !"".equals(fs_estallido_prod.getText().trim()) && !"".equals(fs_col_prod.getText().trim()) && !"".equals(fs_tens1_prod.getText().trim()) && !"".equals(no_secc_prod.getText().trim())) {


                datos[0] = prof_tot_prod.getText().toString();
                datos[1] = no_secc_prod.getText().toString();
                datos[2] = long_min_secc_prod.getText().toString();
                //datos[3] = grad_frac_prod.getText().toString();
                datos[4] = grad_gas_prod.getText().toString();
                datos[5] = dens_lodo_prod.getText().toString();
                //datos[6] = prof_zap_prod.getText().toString();
                datos[6] = dif_pres_prod.getText().toString();
                datos[7] = fs_estallido_prod.getText().toString();
                datos[8] = fs_col_prod.getText().toString();
                datos[9] = fs_tens1_prod.getText().toString();
                datos[10] = fs_tens2_prod.getText().toString();
                datos[11] = grad_form_prod.getText().toString();
//                datos[12] = fs_grad_frac_prod.getText().toString();
                //datos[13] = dens_zap_prod.getText().toString();

                produccion.setH(Integer.parseInt(prof_tot_prod.getText().toString().trim()));
                produccion.setSecciones(Integer.parseInt(no_secc_prod.getText().toString().trim()));
//                produccion.setFsgfrac(Float.parseFloat(fs_grad_frac_prod.getText().toString().trim()));
                produccion.setFsc(Float.parseFloat(fs_col_prod.getText().toString().trim()));
                produccion.setFse(Float.parseFloat(fs_estallido_prod.getText().toString().trim()));
                produccion.setGform(Float.parseFloat(grad_form_prod.getText().toString().trim()));
                //produccion.setGfr(Float.parseFloat(grad_frac_prod.getText().toString().trim()));
                produccion.setGg(Float.parseFloat(grad_gas_prod.getText().toString().trim()));
                produccion.setLong_minima_sec(Integer.parseInt(long_min_secc_prod.getText().toString().trim()));
                produccion.setFs_tension1(Float.parseFloat(fs_tens1_prod.getText().toString().trim()));
                produccion.setFs_tension2(Float.parseFloat(fs_tens2_prod.getText().toString().trim()));
                //produccion.setDensidad_zapata(Integer.parseInt(dens_zap_prod.getText().toString()));
                if (dif_pres_prod.isEnabled() && !dif_pres_prod.getText().equals("")) {
                    produccion.setDif_pres(Integer.parseInt(dif_pres_prod.getText().toString().trim()));
                    produccion.setDensidad_lodo(0);
                } else {
                    produccion.setDensidad_lodo(Float.parseFloat(dens_lodo_prod.getText().toString().trim()));
                    produccion.setDif_pres(0);
                }

                System.out.println("Profundidad T =" + produccion.getH());
                System.out.println("Numero de Secciones =" + produccion.getSecciones());
                System.out.println("Longitud Minima de Seccion =" + produccion.getLong_minima_sec());
                System.out.println("Gradiente de Fractura =" + produccion.getGfr());
                System.out.println("Gradiente de Gas =" + produccion.getGg());
                System.out.println("Densidad del Lodo =" + produccion.getDensidad_lodo());
                System.out.println("Factor de seguridad Estallido =" + produccion.getFse());
                System.out.println("Factor de seguridad Colapso =" + produccion.getFsc());
                System.out.println("Factor de seguridad T1 =" + produccion.getFs_tension1());
                System.out.println("Factor de seguridad T2 =" + produccion.getFs_tension2());
                System.out.println("Gradiemte de Formacion =" + produccion.getGform());
                System.out.println("Factor de seguridad Gfr =" + produccion.getFsgfrac());
                System.out.println("dif pres=" + produccion.getDif_pres());

                try {

                    ven.setDiametro(sel2());
                    produccion.setConsulta(ven.getCons());
                    produccion.setDiametro(sel2());
                    produccion.Estallido_Pro();
                    resultado = new ventanaInicial(produccion.Colapso_pro());
                    resultado.setDatos(datos);
                    opcion = produccion.getIndex();
                    resultado.setVisible(true);


                } catch (SQLException ex) {
                    Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(this, err_msg2, "Error", JOptionPane.ERROR_MESSAGE);

            }
    }//GEN-LAST:event_aceptar_proActionPerformed

    private void prof_t_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prof_t_intActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prof_t_intActionPerformed

    private void fs_col_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs_col_intActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fs_col_intActionPerformed

    private void fs_tens2_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs_tens2_supActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fs_tens2_supActionPerformed

    private void selec_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_supActionPerformed
        // TODO add your handling code here:

        int seleccionado = sel3();
        //System.out.println("sel = " + asf);

        ResultSet tubes = conn.ExecQuery("Select grado_api, peso_nominal from caracteristicas where id_diametro = '" + seleccionado + "'");
        try {

            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public Class getColumnClass(int columnIndex) {
                    if (columnIndex == 2) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            modelo.addColumn("Nomenclatura API");
            modelo.addColumn("Peso Nominal");
            Object[] etiquetas = {"Grado", "Peso", "Boolean"};

            modelo.setColumnIdentifiers(etiquetas);

            while (tubes.next()) {
                Object[] fila = new Object[3];
                for (int i = 0; i < etiquetas.length; i++) {

                    if (i == 2) {
                        fila[i] = Boolean.FALSE;
                    } else {
                        fila[i] = tubes.getObject(i + 1);
                    }

                }
                modelo.addRow(fila);
                //System.out.println("xcfgg");
            }



            //System.out.print(modelo.getValueAt(2,2));

//            jTable1.setEditingColumn(3);
//            jTable1.setModel(modelo);

            ven = new waaw(modelo);
            ven.setDiametro(seleccionado);
            ven.setVisible(true);
            tab_tabla_intermedio.setModel(ven.getTable());
            aceptar_sup.setEnabled(true);


        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selec_supActionPerformed

    private void aceptar_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_supActionPerformed
        // TODO add your handling code here:

        if (!prof_total_sup.getText().trim().isEmpty() && !"".equals(nosecciones_sup.getText().trim()) && !"".equals(long_min_secc_sup.getText().trim()) && !"".equals(grad_gas_sup.getText().trim()) && !"".equals(fs_est_sup.getText().trim()) && !"".equals(fs_col_sup.getText().trim()) && !"".equals(fs_tens1_sup.getText().trim()) && !"".equals(nosecciones_sup.getText().trim())) {

            System.out.println("Profundidad T =" + prof_total_sup.getText());
            System.out.println("Numero de Secciones =" + nosecciones_sup.getText());
            System.out.println("Longitud Minima de Seccion =" + long_min_secc_sup.getText());
            System.out.println("Gradiente de Fractura =" + grad_frac_sup.getText());
            System.out.println("Gradiente de Gas =" + grad_gas_sup.getText());
            System.out.println("Densidad del Lodo =" + dens_lodo_sup.getText());
            System.out.println("Factor de seguridad Estallido =" + fs_est_sup.getText());
            System.out.println("Factor de seguridad Colapso =" + fs_col_sup.getText());
            System.out.println("Factor de seguridad T1 =" + fs_tens1_sup.getText());
            System.out.println("Factor de seguridad T2 =" + fs_tens2_sup.getText());
            System.out.println("Gradiemte de Formacion =" + grad_form_sup.getText());
            System.out.println("Factor de seguridad Gfr =" + fs_gradfrac_sup.getText());

            suprficial.setH(Integer.parseInt(prof_total_sup.getText().toString().trim()));
            suprficial.setDensidad_lodo(Float.parseFloat(dens_lodo_sup.getText().trim()));
            suprficial.setFsc(Float.parseFloat(fs_col_sup.getText().toString().trim()));
            suprficial.setFse(Float.parseFloat(fs_est_sup.getText().toString().trim()));
            suprficial.setGform(Float.parseFloat(grad_form_sup.getText().toString().trim()));
            suprficial.setGfr(Float.parseFloat(grad_frac_sup.getText().toString().trim()));
            suprficial.setGg(Float.parseFloat(grad_gas_sup.getText().toString().trim()));
            suprficial.setSecciones(Integer.parseInt(nosecciones_sup.getText().toString().trim()));
            suprficial.setLong_minima_sec(Integer.parseInt(long_min_secc_sup.getText().toString().trim()));
            suprficial.setFs_tension1(Float.parseFloat(fs_tens1_sup.getText().trim()));
            suprficial.setFs_tension2(Float.parseFloat(fs_tens2_sup.getText().trim()));
            suprficial.setFs_grad_frac(Float.parseFloat(fs_tens2_sup.getText().trim()));

            System.out.println(" Gfr =" + asf.getGfr());

            try {

                ven.setDiametro(sel3());
                suprficial.setDiam(sel3());
                suprficial.setConsulta(ven.getCons());
                suprficial.Estallido();
                resultado = new ventanaInicial(suprficial.Colapso());
                resultado.setDatos(datos);
                opcion = intermedio.getIndex();
                resultado.setVisible(true);
                //suprficial.Estallido();
                //suprficial.Colapso();

            } catch (SQLException ex) {
                Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            JOptionPane.showMessageDialog(this, err_msg2, "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_aceptar_supActionPerformed

    private void fs_gradfrac_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs_gradfrac_supActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fs_gradfrac_supActionPerformed

    private void ayuda_m_acerca_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayuda_m_acerca_deActionPerformed
        // TODO add your handling code here:

        new NewJFrame1(acerca,ttulo);

    }//GEN-LAST:event_ayuda_m_acerca_deActionPerformed

    private void idioma_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idioma_ingActionPerformed
        // TODO add your handling code here:

        lang = 1;
        ttulo = "About...";
        acerca = "<html><p align='center'>Casing Design Assistant 1.0<br><br>"
                + "Tool for the design of surface,<br> intermediate and production casings.<br><br>"
                + "Daniel Añez Scott : <a href='mailto:daas171@gmail.com'>daas171@gmail.com</a>  <br>"
                + "José David Castellano: <a href='mailto:josedavid281@gmail.com'>josedavid281@gmail.com</a> <br>"
                + "Advised by Rolando Figueroa<br><br>"
                + "Software under the General Public License v3,<br>detailed here: https://www.gnu.org/licenses/gpl-3.0.html</p></html>";

        Locale currentLocale = new Locale("en", "us");
        ResourceBundle mess = ResourceBundle.getBundle("idioma", currentLocale);
        clr_int.setText("Clear");
        clr_prod.setText("Clear");
        clr_sup.setText("Clear");
        JComponent.setDefaultLocale(Locale.ENGLISH);
        cont_ayuda.setText(mess.getString("cont_ayuda_m"));
        idioma_ing.setText(mess.getString("idioma_ing"));
        idioma_esp.setText(mess.getString("idioma_esp"));
        idioma_m.setText(mess.getString("idioma_m"));
        archivo_salir.setText(mess.getString("salir_m"));
        guardar_menu_arch.setText(mess.getString("guardar_m"));
        ayuda_m_acerca_de.setText(mess.getString("ayuda_m_acerca_de"));
        no_secc_lab_int.setText(mess.getString("no_secc_lab_int"));
        prof_t_int_lab.setText(mess.getString("prof_t_int_lab"));
        fs_grad_frac_int_lab.setText(mess.getString("fs_grad_frac_sup_lab"));
        grad_gas_int_lab.setText(mess.getString("grad_gas_int_lab"));
        dens_lodo_int_lab.setText(mess.getString("dens_lodo_int_lab"));
        fs_tens1_int_lab.setText(mess.getString("fs_tens1_int_lab"));
        fs_tens2_int_lab.setText(mess.getString("fs_tens2_int_lab"));
        fs_est_int_lab.setText(mess.getString("fs_est_int_lab"));
        fs_col_int_lab.setText(mess.getString("fs_col_int_lab"));
        grad_form_int_lab.setText(mess.getString("grad_form_int_lab"));
        dens_zap_lab_int.setText(mess.getString("dens_zap_lab_int"));
        dif_pres_int_lab.setText(mess.getString("dif_pres_int_lab"));
        prof_zap_int_lab.setText(mess.getString("prof_zap_int_lab"));
        long_min_sec_lab_int.setText(mess.getString("long_min_sec_lab_int"));
        fs_tens1_pro_lab.setText(mess.getString("fs_tens1_int_lab"));
        fs_tens1_sup_lab.setText(mess.getString("fs_tens1_int_lab"));
        aceptar_int.setText(mess.getString("aceptar_int"));
        ayuda_m.setText(mess.getString("ayuda_m"));
        selec_int.setText(mess.getString("selec_int"));
        archivo_m.setText(mess.getString("archivo_m"));
        abrir_m.setText(mess.getString("abrir_m"));
        grad_frac_int_lab.setText(mess.getString("grad_frac_int_lab"));


        no_sec_lab_sup.setText(mess.getString("no_secc_lab_sup"));
        prof_t_sup_lab.setText(mess.getString("prof_t_sup_lab"));
        fs_grad_frac_sup_lab.setText(mess.getString("fs_grad_frac_sup_lab"));
        grad_gas_sup_lab.setText(mess.getString("grad_gas_sup_lab"));
        dens_lodo_sup_lab.setText(mess.getString("dens_lodo_sup_lab"));
        fs_tens2_sup_lab.setText(mess.getString("fs_tens2_sup_lab"));
        fs_est_sup_lab.setText(mess.getString("fs_est_sup_lab"));
        fs_col_sup_lab.setText(mess.getString("fs_col_sup_lab"));
        grad_form_sup_lab.setText(mess.getString("grad_form_sup_lab"));
        long_min_sec_lab_sup.setText(mess.getString("long_min_sec_lab_sup"));
        grad_frac_sup_lab.setText(mess.getString("grad_frac_pro_lab"));
        aceptar_sup.setText(mess.getString("aceptar_sup"));
        selec_sup.setText(mess.getString("selec_sup"));

        ayuda_m_acerca_de.setText(mess.getString("ayuda_m_acerca_de"));
        no_secc_lab_pro.setText(mess.getString("no_secc_lab_pro"));
        prof_t_pro_lab.setText(mess.getString("prof_t_pro_lab"));
//        fs_grad_frac_pro_lab.setText(mess.getString("fs_grad_frac_sup_lab"));
        grad_gas_pro_lab.setText(mess.getString("grad_gas_pro_lab"));
        dens_lodo_pro_lab.setText(mess.getString("dens_lodo_pro_lab"));
        fs_tens2_pro_lab.setText(mess.getString("fs_tens2_pro_lab"));
        fs_est_pro_lab.setText(mess.getString("fs_est_pro_lab"));
        fs_col_pro_lab.setText(mess.getString("fs_col_pro_lab"));
        grad_form_pro_lab.setText(mess.getString("grad_form_pro_lab"));
        //dens_zap_lab_pro.setText(mess.getString("dens_zap_lab_pro"));
        dif_pres_pro_lab.setText(mess.getString("dif_pres_pro_lab"));
        //prof_zap_pro_lab.setText(mess.getString("fs_tens1_pro_lab"));
        long_min_sec_lab_pro.setText(mess.getString("long_min_sec_lab_pro"));
        //grad_frac_pro_lab.setText(mess.getString("grad_frac_pro_lab"));
        aceptar_pro.setText(mess.getString("aceptar_pro"));
        col_grado = mess.getString("col_grapi");
        col_peso = mess.getString("col_peso");
        selec_pro.setText(mess.getString("selec_pro"));

        err_msg1 = mess.getString("err_msg1");
        err_msg2 = mess.getString("err_msg2");
        err_msg3 = mess.getString("err_msg3");
        err_msg4 = mess.getString("err_msg4");
        err_msg5 = mess.getString("err_msg5");
        err_msg6 = mess.getString("err_msg6");
        err_msg7 = mess.getString("err_msg7");
        err_msg8 = mess.getString("err_msg8");
        err_msg9 = mess.getString("err_msg9");
        err_msg10 = mess.getString("err_msg10");
        err_msg11 = mess.getString("err_msg11");
        err_msg12 = mess.getString("err_msg12");
        err_msg13 = mess.getString("err_msg13");
        err_msg14 = mess.getString("err_msg14");
        err_msg15 = mess.getString("err_msg15");
        err_msg16 = mess.getString("err_msg16");
        err_msg17 = mess.getString("err_msg17");
        err_msg18 = mess.getString("err_msg18");
        err_msg19 = mess.getString("err_msg19");
        err_msg20 = mess.getString("err_msg20");
        err_msg21 = mess.getString("err_msg21");
        err_msg22 = mess.getString("err_msg22");
        err_msg23 = mess.getString("err_msg23");
        err_msg24 = mess.getString("err_msg24");
        err_msg25 = mess.getString("err_msg25");
        err_msg26 = mess.getString("err_msg26");
        err_msg27 = mess.getString("err_msg27");
        err_msg28 = mess.getString("err_msg28");
        err_msg29 = mess.getString("err_msg29");
        err_msg30 = mess.getString("err_msg30");


        jPanel3.setBorder(new TitledBorder(mess.getString("diam_disp")));
        jPanel5.setBorder(new TitledBorder(mess.getString("diam_disp")));
        jPanel9.setBorder(new TitledBorder(mess.getString("diam_disp")));


        jPanel7.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));
        jPanel8.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));
        jPanel11.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));

        jPanel6.setBorder(new TitledBorder(mess.getString("datos")));
        jPanel4.setBorder(new TitledBorder(mess.getString("datos")));
        jPanel10.setBorder(new TitledBorder(mess.getString("datos")));

        tab_tabla_intermedio.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        tab_tabla_intermedio.getColumnModel().getColumn(1).setHeaderValue(col_peso);
        sup_tab_tabla.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        sup_tab_tabla.getColumnModel().getColumn(1).setHeaderValue(col_peso);

        tabla_prod_tab.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        tabla_prod_tab.getColumnModel().getColumn(1).setHeaderValue(col_peso);

        jTabbedPane1.setTitleAt(0, mess.getString("sup"));
        jTabbedPane1.setTitleAt(1, mess.getString("int"));
        jTabbedPane1.setTitleAt(2, mess.getString("prod"));

        dens_lodo_int.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_prod.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_sup.setToolTipText(mess.getString("dens_lodo"));
        dens_zap_int.setToolTipText(mess.getString("dens_zap"));
        dif_pres_int.setToolTipText(mess.getString("dif_pres"));
        dif_pres_prod.setToolTipText(mess.getString("dif_pres"));
        fs_col_int.setToolTipText(mess.getString("fs_col"));
        fs_col_prod.setToolTipText(mess.getString("fs_col"));
        fs_col_sup.setToolTipText(mess.getString("fs_col"));
        fs_est_int.setToolTipText(mess.getString("fs_est"));
        fs_est_sup.setToolTipText(mess.getString("fs_est"));
        fs_estallido_prod.setToolTipText(mess.getString("fs_est"));
        fs_grad_frac_int.setToolTipText(mess.getString("fs_grad_frac"));
//        fs_grad_frac_prod.setToolTipText(mess.getString("fs_grad_frac"));
        fs_gradfrac_sup.setToolTipText(mess.getString("fs_grad_frac"));
        fs_tens1_int.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_prod.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_sup.setToolTipText(mess.getString("fs_tens1"));
        fs_tens2_int.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_prod.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_sup.setToolTipText(mess.getString("fs_tens2"));
        grad_form_int.setToolTipText(mess.getString("grad_form"));
        grad_form_prod.setToolTipText(mess.getString("grad_form"));
        grad_form_sup.setToolTipText(mess.getString("grad_form"));
        grad_frac_int.setToolTipText(mess.getString("grad_frac"));
        //grad_frac_prod.setToolTipText(mess.getString("grad_frac"));
        grad_frac_sup.setToolTipText(mess.getString("grad_frac"));
        grad_gas_int.setToolTipText(mess.getString("grad_gas"));
        grad_gas_prod.setToolTipText(mess.getString("grad_gas"));
        grad_gas_sup.setToolTipText(mess.getString("grad_gas"));
        long_min_int.setToolTipText(mess.getString("long_min"));
        long_min_secc_prod.setToolTipText(mess.getString("long_min"));
        long_min_secc_sup.setToolTipText(mess.getString("long_min"));
        no_secc_prod.setToolTipText(mess.getString("no_secc"));
        nosecciones_sup.setToolTipText(mess.getString("no_secc"));
        num_sec_int.setToolTipText(mess.getString("no_secc"));
        prof_tot_prod.setToolTipText(mess.getString("prof_tot"));
        prof_total_sup.setToolTipText(mess.getString("prof_tot"));
        prof_t_int.setToolTipText(mess.getString("prof_tot"));
        prof_zap_int.setToolTipText(mess.getString("prof_zap"));

        dens_lodo_int_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_pro_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_sup_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_zap_lab_int.setToolTipText(mess.getString("dens_zap"));
        dif_pres_int_lab.setToolTipText(mess.getString("dif_pres"));
        dif_pres_pro_lab.setToolTipText(mess.getString("dif_pres"));
        fs_col_int_lab.setToolTipText(mess.getString("fs_col"));
        fs_col_pro_lab.setToolTipText(mess.getString("fs_col"));
        fs_col_sup_lab.setToolTipText(mess.getString("fs_col"));
        fs_est_int_lab.setToolTipText(mess.getString("fs_est"));
        fs_est_pro_lab.setToolTipText(mess.getString("fs_est"));
        fs_est_sup_lab.setToolTipText(mess.getString("fs_est"));
        fs_grad_frac_int_lab.setToolTipText(mess.getString("fs_grad_frac"));
//        fs_grad_frac_pro_lab.setToolTipText(mess.getString("fs_grad_frac"));
        fs_grad_frac_sup_lab.setToolTipText(mess.getString("fs_grad_frac"));
        fs_tens1_int_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_pro_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_sup_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens2_int_lab.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_pro_lab.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_sup_lab.setToolTipText(mess.getString("fs_tens2"));
        grad_form_int_lab.setToolTipText(mess.getString("grad_form"));
        grad_form_pro_lab.setToolTipText(mess.getString("grad_form"));
        grad_form_sup_lab.setToolTipText(mess.getString("grad_form"));
        grad_frac_int_lab.setToolTipText(mess.getString("fs_grad_frac"));
        //grad_frac_pro_lab.setToolTipText(mess.getString("fs_grad_frac"));
        grad_frac_sup_lab.setToolTipText(mess.getString("fs_grad_frac"));
        grad_gas_int_lab.setToolTipText(mess.getString("grad_gas"));
        grad_gas_pro_lab.setToolTipText(mess.getString("grad_gas"));
        grad_gas_sup_lab.setToolTipText(mess.getString("grad_gas"));
        long_min_sec_lab_int.setToolTipText(mess.getString("long_min"));
        long_min_sec_lab_pro.setToolTipText(mess.getString("long_min"));
        long_min_sec_lab_sup.setToolTipText(mess.getString("long_min"));
        no_sec_lab_sup.setToolTipText(mess.getString("no_secc"));
        no_secc_lab_int.setToolTipText(mess.getString("no_secc"));
        no_secc_lab_pro.setToolTipText(mess.getString("no_secc"));
        prof_t_int_lab.setToolTipText(mess.getString("prof_tot"));
        prof_t_pro_lab.setToolTipText(mess.getString("prof_tot"));
        prof_t_sup_lab.setToolTipText(mess.getString("prof_tot"));
        prof_zap_int_lab.setToolTipText(mess.getString("prof_zap"));

        jTabbedPane1.setTitleAt(0, mess.getString("sup"));
        jTabbedPane1.setTitleAt(1, mess.getString("int"));
        jTabbedPane1.setTitleAt(2, mess.getString("prod"));


    }//GEN-LAST:event_idioma_ingActionPerformed

    static int idioma() {

        return lang;

    }

    private void idioma_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idioma_espActionPerformed
        // TODO add your handling code here:

        acerca = "<html><p align='center'> "
                + "</b><br><br>"
                + "Casing Design Assistant 1.0<br>"
                + "Herramienta para el diseño de revestidores superficiales,<br>"
                + "intermedios y de producción.<br><br>"
                + "Daniel Añez Scott : <a href='mailto:daas171@gmail.com'>daas171@gmail.com</a>  <br>"
                + "José David Castellano: <a href='mailto:josedavid281@gmail.com'>josedavid281@gmail.com</a> <br>"
                + "Asesorados por Rolando Figueroa<br><br>"
                + "Software publicado bajo la licencia GPLv3, detallado aquí: <br/> http://www.viti.es/gnu/licenses/gpl.html"
                + "</p> </html>";
        
        ttulo = "Acerca de...";
        lang = 0;
        Locale currentLocale = new Locale("es", "es");
        clr_int.setText("Borrar");
        clr_prod.setText("Borrar");
        clr_sup.setText("Borrar");
        ResourceBundle mess = ResourceBundle.getBundle("idioma", currentLocale);
        JComponent.setDefaultLocale(Locale.getDefault());
        err_msg2 = mess.getString("err_msg2");
        archivo_m.setText(mess.getString("archivo_m"));
        cont_ayuda.setText(mess.getString("cont_ayuda_m"));
        idioma_ing.setText(mess.getString("idioma_ing"));
        idioma_esp.setText(mess.getString("idioma_esp"));
        idioma_m.setText(mess.getString("idioma_m"));
        archivo_salir.setText(mess.getString("salir_m"));
        guardar_menu_arch.setText(mess.getString("guardar_m"));
        ayuda_m_acerca_de.setText(mess.getString("ayuda_m_acerca_de"));
        ayuda_m.setText(mess.getString("ayuda_m"));
        abrir_m.setText(mess.getString("abrir_m"));
        aceptar_int.setText(mess.getString("aceptar_int"));
        ayuda_m.setText(mess.getString("ayuda_m"));
        selec_int.setText(mess.getString("selec_int"));


        no_secc_lab_int.setText(mess.getString("no_secc_lab_int"));
        prof_t_int_lab.setText(mess.getString("prof_t_int_lab"));
        fs_grad_frac_int_lab.setText(mess.getString("fs_grad_frac_int_lab"));
        grad_gas_int_lab.setText(mess.getString("grad_gas_int_lab"));
        dens_lodo_int_lab.setText(mess.getString("dens_lodo_int_lab"));
        fs_tens2_int_lab.setText(mess.getString("fs_tens2_int_lab"));
        fs_est_int_lab.setText(mess.getString("fs_est_int_lab"));
        fs_col_int_lab.setText(mess.getString("fs_col_int_lab"));
        grad_form_int_lab.setText(mess.getString("grad_form_int_lab"));
        dens_zap_lab_int.setText(mess.getString("dens_zap_lab_int"));
        dif_pres_int_lab.setText(mess.getString("dif_pres_int_lab"));
        prof_zap_int_lab.setText(mess.getString("prof_zap_int_lab"));
        long_min_sec_lab_int.setText(mess.getString("long_min_sec_lab_int"));
        grad_frac_int_lab.setText(mess.getString("grad_frac_int_lab"));
        fs_tens1_int_lab.setText(mess.getString("fs_tens1_int_lab"));


        no_sec_lab_sup.setText(mess.getString("no_secc_lab_int"));
        prof_t_sup_lab.setText(mess.getString("prof_t_int_lab"));
        fs_grad_frac_sup_lab.setText(mess.getString("fs_grad_frac_int_lab"));
        grad_gas_sup_lab.setText(mess.getString("grad_gas_int_lab"));
        dens_lodo_sup_lab.setText(mess.getString("dens_lodo_int_lab"));
        fs_tens2_sup_lab.setText(mess.getString("fs_tens2_int_lab"));
        fs_est_sup_lab.setText(mess.getString("fs_est_int_lab"));
        fs_tens1_sup_lab.setText(mess.getString("fs_tens1_int_lab"));
        fs_col_sup_lab.setText(mess.getString("fs_col_int_lab"));
        grad_form_sup_lab.setText(mess.getString("grad_form_int_lab"));
        long_min_sec_lab_sup.setText(mess.getString("long_min_sec_lab_int"));
        grad_frac_sup_lab.setText(mess.getString("grad_frac_int_lab"));
        aceptar_sup.setText(mess.getString("aceptar_int"));
        selec_sup.setText(mess.getString("selec_int"));


        no_secc_lab_pro.setText(mess.getString("no_secc_lab_int"));
        prof_t_pro_lab.setText(mess.getString("prof_t_int_lab"));
//        fs_grad_frac_pro_lab.setText(mess.getString("fs_grad_frac_int_lab"));
        grad_gas_pro_lab.setText(mess.getString("grad_gas_int_lab"));
        dens_lodo_pro_lab.setText(mess.getString("dens_lodo_int_lab"));
        fs_tens2_pro_lab.setText(mess.getString("fs_tens2_int_lab"));
        fs_tens1_pro_lab.setText(mess.getString("fs_tens1_int_lab"));
        fs_est_pro_lab.setText(mess.getString("fs_est_int_lab"));
        fs_col_pro_lab.setText(mess.getString("fs_col_int_lab"));
        grad_form_pro_lab.setText(mess.getString("grad_form_int_lab"));
        //dens_zap_lab_pro.setText(mess.getString("dens_zap_lab_int"));
        dif_pres_pro_lab.setText(mess.getString("dif_pres_int_lab"));
        //prof_zap_pro_lab.setText(mess.getString("fs_tens1_int_lab"));
        long_min_sec_lab_pro.setText(mess.getString("long_min_sec_lab_int"));
        //grad_frac_pro_lab.setText(mess.getString("grad_frac_int_lab"));
        aceptar_pro.setText(mess.getString("aceptar_int"));
        selec_pro.setText(mess.getString("selec_int"));

        col_grado = mess.getString("col_grapi");
        col_peso = mess.getString("col_peso");

        jPanel3.setBorder(new TitledBorder(mess.getString("diam_disp")));
        jPanel5.setBorder(new TitledBorder(mess.getString("diam_disp")));
        jPanel9.setBorder(new TitledBorder(mess.getString("diam_disp")));


        jPanel7.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));
        jPanel8.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));
        jPanel11.setBorder(new TitledBorder(mess.getString("tubos_seleccionados")));

        tab_tabla_intermedio.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        tab_tabla_intermedio.getColumnModel().getColumn(1).setHeaderValue(col_peso);

        sup_tab_tabla.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        sup_tab_tabla.getColumnModel().getColumn(1).setHeaderValue(col_peso);

        tabla_prod_tab.getColumnModel().getColumn(0).setHeaderValue(col_grado);
        tabla_prod_tab.getColumnModel().getColumn(1).setHeaderValue(col_peso);

        jTabbedPane1.setTitleAt(0, mess.getString("sup"));
        jTabbedPane1.setTitleAt(1, mess.getString("int"));
        jTabbedPane1.setTitleAt(2, mess.getString("prod"));

        jPanel4.setBorder(BorderFactory.createTitledBorder(mess.getString("datos")));
        jPanel6.setBorder(BorderFactory.createTitledBorder(mess.getString("datos")));
        jPanel10.setBorder(BorderFactory.createTitledBorder(mess.getString("datos")));

        dens_lodo_int.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_prod.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_sup.setToolTipText(mess.getString("dens_lodo"));
        dens_zap_int.setToolTipText(mess.getString("dens_zap"));
        dif_pres_int.setToolTipText(mess.getString("dif_pres"));
        dif_pres_prod.setToolTipText(mess.getString("dif_pres"));
        fs_col_int.setToolTipText(mess.getString("fs_col"));
        fs_col_prod.setToolTipText(mess.getString("fs_col"));
        fs_col_sup.setToolTipText(mess.getString("fs_col"));
        fs_est_int.setToolTipText(mess.getString("fs_est"));
        fs_est_sup.setToolTipText(mess.getString("fs_est"));
        fs_estallido_prod.setToolTipText(mess.getString("fs_est"));
        fs_grad_frac_int.setToolTipText(mess.getString("fs_grad_frac"));
//        fs_grad_frac_prod.setToolTipText(mess.getString("fs_grad_frac"));
        fs_gradfrac_sup.setToolTipText(mess.getString("fs_grad_frac"));
        fs_tens1_int.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_prod.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_sup.setToolTipText(mess.getString("fs_tens1"));
        fs_tens2_int.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_prod.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_sup.setToolTipText(mess.getString("fs_tens2"));
        grad_form_int.setToolTipText(mess.getString("grad_form"));
        grad_form_prod.setToolTipText(mess.getString("grad_form"));
        grad_form_sup.setToolTipText(mess.getString("grad_form"));
        grad_frac_int.setToolTipText(mess.getString("grad_frac"));
        //grad_frac_prod.setToolTipText(mess.getString("grad_frac"));
        grad_frac_sup.setToolTipText(mess.getString("grad_frac"));
        grad_gas_int.setToolTipText(mess.getString("grad_gas"));
        grad_gas_prod.setToolTipText(mess.getString("grad_gas"));
        grad_gas_sup.setToolTipText(mess.getString("grad_gas"));
        long_min_int.setToolTipText(mess.getString("long_min"));
        long_min_secc_prod.setToolTipText(mess.getString("long_min"));
        long_min_secc_sup.setToolTipText(mess.getString("long_min"));
        no_secc_prod.setToolTipText(mess.getString("no_secc"));
        nosecciones_sup.setToolTipText(mess.getString("no_secc"));
        num_sec_int.setToolTipText(mess.getString("no_secc"));
        prof_tot_prod.setToolTipText(mess.getString("prof_tot"));
        prof_total_sup.setToolTipText(mess.getString("prof_tot"));
        prof_t_int.setToolTipText(mess.getString("prof_tot"));
        prof_zap_int.setToolTipText(mess.getString("prof_zap"));

        dens_lodo_int_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_pro_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_lodo_sup_lab.setToolTipText(mess.getString("dens_lodo"));
        dens_zap_lab_int.setToolTipText(mess.getString("dens_zap"));
        dif_pres_int_lab.setToolTipText(mess.getString("dif_pres"));
        dif_pres_pro_lab.setToolTipText(mess.getString("dif_pres"));
        fs_col_int_lab.setToolTipText(mess.getString("fs_col"));
        fs_col_pro_lab.setToolTipText(mess.getString("fs_col"));
        fs_col_sup_lab.setToolTipText(mess.getString("fs_col"));
        fs_est_int_lab.setToolTipText(mess.getString("fs_est"));
        fs_est_pro_lab.setToolTipText(mess.getString("fs_est"));
        fs_est_sup_lab.setToolTipText(mess.getString("fs_est"));
        fs_grad_frac_int_lab.setToolTipText(mess.getString("fs_grad_frac"));
//        fs_grad_frac_pro_lab.setToolTipText(mess.getString("fs_grad_frac"));
        fs_grad_frac_sup_lab.setToolTipText(mess.getString("fs_grad_frac"));
        fs_tens1_int_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_pro_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens1_sup_lab.setToolTipText(mess.getString("fs_tens1"));
        fs_tens2_int_lab.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_pro_lab.setToolTipText(mess.getString("fs_tens2"));
        fs_tens2_sup_lab.setToolTipText(mess.getString("fs_tens2"));
        grad_form_int_lab.setToolTipText(mess.getString("grad_form"));
        grad_form_pro_lab.setToolTipText(mess.getString("grad_form"));
        grad_form_sup_lab.setToolTipText(mess.getString("grad_form"));
        grad_frac_int_lab.setToolTipText(mess.getString("fs_grad_frac"));
        //grad_frac_pro_lab.setToolTipText(mess.getString("fs_grad_frac"));
        grad_frac_sup_lab.setToolTipText(mess.getString("fs_grad_frac"));
        grad_gas_int_lab.setToolTipText(mess.getString("grad_gas"));
        grad_gas_pro_lab.setToolTipText(mess.getString("grad_gas"));
        grad_gas_sup_lab.setToolTipText(mess.getString("grad_gas"));
        long_min_sec_lab_int.setToolTipText(mess.getString("long_min"));
        long_min_sec_lab_pro.setToolTipText(mess.getString("long_min"));
        long_min_sec_lab_sup.setToolTipText(mess.getString("long_min"));
        no_sec_lab_sup.setToolTipText(mess.getString("no_secc"));
        no_secc_lab_int.setToolTipText(mess.getString("no_secc"));
        no_secc_lab_pro.setToolTipText(mess.getString("no_secc"));
        prof_t_int_lab.setToolTipText(mess.getString("prof_tot"));
        prof_t_pro_lab.setToolTipText(mess.getString("prof_tot"));
        prof_t_sup_lab.setToolTipText(mess.getString("prof_tot"));
        prof_zap_int_lab.setToolTipText(mess.getString("prof_zap"));

        err_msg1 = mess.getString("err_msg1");
        err_msg2 = mess.getString("err_msg2");
        err_msg3 = mess.getString("err_msg3");
        err_msg4 = mess.getString("err_msg4");
        err_msg5 = mess.getString("err_msg5");
        err_msg6 = mess.getString("err_msg6");
        err_msg7 = mess.getString("err_msg7");
        err_msg8 = mess.getString("err_msg8");
        err_msg9 = mess.getString("err_msg9");
        err_msg10 = mess.getString("err_msg10");
        err_msg11 = mess.getString("err_msg11");
        err_msg12 = mess.getString("err_msg12");
        err_msg13 = mess.getString("err_msg13");
        err_msg14 = mess.getString("err_msg14");
        err_msg15 = mess.getString("err_msg15");
        err_msg16 = mess.getString("err_msg16");
        err_msg17 = mess.getString("err_msg17");
        err_msg18 = mess.getString("err_msg18");
        err_msg19 = mess.getString("err_msg19");
        err_msg20 = mess.getString("err_msg20");
        err_msg21 = mess.getString("err_msg21");
        err_msg22 = mess.getString("err_msg22");
        err_msg23 = mess.getString("err_msg23");
        err_msg24 = mess.getString("err_msg24");
        err_msg25 = mess.getString("err_msg25");
        err_msg26 = mess.getString("err_msg26");
        err_msg27 = mess.getString("err_msg27");
        err_msg28 = mess.getString("err_msg28");
        err_msg29 = mess.getString("err_msg29");
        err_msg30 = mess.getString("err_msg30");


    }//GEN-LAST:event_idioma_espActionPerformed

    private void abrir_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_mActionPerformed
        // TODO add your handling code here:


        JFileChooser chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        File archivo;
        FileReader fr;
        BufferedReader br;
        String op = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {

                archivo = new File(chooser.getSelectedFile().getAbsolutePath());
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                String a;

                try {
                    op = br.readLine();
                    System.out.println(" sdsds " + op);
                    if (!op.equals("1") && !op.equals("2") && !op.equals("3")) {

                        JOptionPane.showMessageDialog(this, err_msg3, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> linea = new ArrayList<String>();
                try {

                    while ((a = br.readLine()) != null) {
                        System.out.println("e " + a);
                        linea.add(a);

                    }

                    switch (Integer.parseInt(op)) {

                        case 2:

                            prof_t_int.setText(linea.get(0));
                            num_sec_int.setText(linea.get(1));
                            long_min_int.setText(linea.get(2));
                            grad_frac_int.setText(linea.get(3));
                            grad_gas_int.setText(linea.get(4));
                            dens_lodo_int.setText(linea.get(5));
                            prof_zap_int.setText(linea.get(6));
                            dif_pres_int.setText(linea.get(7));
                            fs_est_int.setText(linea.get(8));
                            fs_col_int.setText(linea.get(9));
                            fs_tens1_int.setText(linea.get(10));
                            fs_tens2_int.setText(linea.get(11));
                            grad_form_int.setText(linea.get(12));
                            fs_grad_frac_int.setText(linea.get(13));
                            dens_zap_int.setText(linea.get(14));
                            jTabbedPane1.setSelectedIndex(Integer.parseInt(op) - 1);

                            datos[0] = prof_t_int.getText().toString();
                            datos[1] = num_sec_int.getText().toString();
                            datos[2] = long_min_int.getText().toString();
                            datos[3] = grad_frac_int.getText().toString();
                            datos[4] = grad_gas_int.getText().toString();
                            datos[5] = dens_lodo_int.getText().toString();
                            datos[6] = prof_zap_int.getText().toString();
                            datos[7] = dif_pres_int.getText().toString();
                            datos[8] = fs_est_int.getText().toString();
                            datos[9] = fs_col_int.getText().toString();
                            datos[10] = fs_tens1_int.getText().toString();
                            datos[11] = fs_tens2_int.getText().toString();
                            datos[12] = grad_form_int.getText().toString();
                            datos[13] = fs_grad_frac_int.getText().toString();
                            datos[14] = dens_zap_int.getText().toString();


                            break;

                        case 1:

                            prof_total_sup.setText(linea.get(0));
                            nosecciones_sup.setText(linea.get(1));
                            long_min_secc_sup.setText(linea.get(2));
                            grad_gas_sup.setText(linea.get(3));
                            dens_lodo_sup.setText(linea.get(5));
                            grad_form_sup.setText(linea.get(4));
                            fs_est_sup.setText(linea.get(6));
                            fs_col_sup.setText(linea.get(7));
                            fs_tens1_sup.setText(linea.get(8));
                            fs_tens2_sup.setText(linea.get(9));
                            grad_frac_sup.setText(linea.get(10));
                            fs_gradfrac_sup.setText(linea.get(11));
                            jTabbedPane1.setSelectedIndex(Integer.parseInt(op) - 1);


                            break;

                        case 3:

                            prof_tot_prod.setText(linea.get(0));
                            no_secc_prod.setText(linea.get(1));
                            long_min_secc_prod.setText(linea.get(2));
                            //grad_frac_prod.setText(linea.get(3));
                            grad_gas_prod.setText(linea.get(4));
                            dens_lodo_prod.setText(linea.get(5));
                            //prof_zap_prod.setText(linea.get(6));
                            dif_pres_prod.setText(linea.get(6));
                            fs_estallido_prod.setText(linea.get(7));
                            fs_col_prod.setText(linea.get(8));
                            fs_tens1_prod.setText(linea.get(9));
                            fs_tens2_prod.setText(linea.get(10));
                            grad_form_prod.setText(linea.get(11));
//                            fs_grad_frac_prod.setText(linea.get(12));
                            //dens_zap_prod.setText(linea.get(14));
                            jTabbedPane1.setSelectedIndex(Integer.parseInt(op) - 1);

                            datos[0] = prof_tot_prod.getText().toString();
                            datos[1] = no_secc_prod.getText().toString();
                            datos[2] = long_min_secc_prod.getText().toString();
                            //datos[3] = grad_frac_prod.getText().toString();
                            datos[4] = grad_gas_prod.getText().toString();
                            datos[5] = dens_lodo_prod.getText().toString();
                            //datos[6] = prof_zap_prod.getText().toString();
                            datos[6] = dif_pres_prod.getText().toString();
                            datos[7] = fs_estallido_prod.getText().toString();
                            datos[8] = fs_col_prod.getText().toString();
                            datos[9] = fs_tens1_prod.getText().toString();
                            datos[10] = fs_tens2_prod.getText().toString();
                            datos[11] = grad_form_prod.getText().toString();
                            break;

                    }
                } catch (IOException ex) {
                    Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_abrir_mActionPerformed

    private void prof_total_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prof_total_supActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prof_total_supActionPerformed

    private void cont_ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cont_ayudaActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(this, "Por Favor refierase a nuestro manual de usuario", "Contenidos de Ayuda", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_cont_ayudaActionPerformed

    private void fs_est_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fs_est_supActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fs_est_supActionPerformed

    private void guardar_menu_archActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_menu_archActionPerformed
        // TODO add your handling code here:

        switch (jTabbedPane1.getSelectedIndex() + 1) {

            case 1:
                datos = new Object[12];
                datos[0] = prof_total_sup.getText().toString();
                datos[1] = nosecciones_sup.getText().toString();
                datos[2] = long_min_secc_sup.getText().toString();
                datos[3] = grad_gas_sup.getText().toString();
                datos[4] = grad_form_sup.getText().toString();
                datos[5] = dens_lodo_sup.getText().toString();
                //datos[6] = prof_zap_sup.getText().toString();
                //datos[7] = dif_pres_sup.getText().toString();
                datos[6] = fs_est_sup.getText().toString();
                datos[7] = fs_col_sup.getText().toString();
                datos[8] = fs_tens1_sup.getText().toString();
                datos[9] = fs_tens2_sup.getText().toString();
                datos[10] = grad_frac_sup.getText().toString();
                datos[11] = fs_gradfrac_sup.getText().toString();
                //datos[14] = dens_zap_sup.getText().toString();
                opcion = jTabbedPane1.getSelectedIndex() + 1;
                break;

            case 2:
                datos[0] = prof_t_int.getText().toString();
                datos[1] = num_sec_int.getText().toString();
                datos[2] = long_min_int.getText().toString();
                datos[3] = grad_frac_int.getText().toString();
                datos[4] = grad_gas_int.getText().toString();
                datos[5] = dens_lodo_int.getText().toString();
                datos[6] = prof_zap_int.getText().toString();
                datos[7] = dif_pres_int.getText().toString();
                datos[8] = fs_est_int.getText().toString();
                datos[9] = fs_col_int.getText().toString();
                datos[10] = fs_tens1_int.getText().toString();
                datos[11] = fs_tens2_int.getText().toString();
                datos[12] = grad_form_int.getText().toString();
                datos[13] = fs_grad_frac_int.getText().toString();
                datos[14] = dens_zap_int.getText().toString();
                opcion = jTabbedPane1.getSelectedIndex() + 1;
                break;

            case 3:
                datos = new Object[13];
                datos[0] = prof_tot_prod.getText().toString();
                datos[1] = no_secc_prod.getText().toString();
                datos[2] = long_min_secc_prod.getText().toString();
                //datos[3] = grad_frac_prod.getText().toString();
                datos[4] = grad_gas_prod.getText().toString();
                datos[5] = dens_lodo_prod.getText().toString();
                //datos[6] = prof_zap_prod.getText().toString();
                datos[6] = dif_pres_prod.getText().toString();
                datos[7] = fs_estallido_prod.getText().toString();
                datos[8] = fs_col_prod.getText().toString();
                datos[9] = fs_tens1_prod.getText().toString();
                datos[10] = fs_tens2_prod.getText().toString();
                datos[11] = grad_form_prod.getText().toString();
//                datos[12] = fs_grad_frac_prod.getText().toString();
                //datos[14] = dens_zap_prod.getText().toString();
                opcion = jTabbedPane1.getSelectedIndex() + 1;
                break;
        }

        FileWriter fichero = null;
        PrintWriter pw;
        System.out.println(opcion);
        JFileChooser chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {

                if (!chooser.getSelectedFile().toString().endsWith(".txt")) {
                    fichero = new FileWriter(chooser.getSelectedFile() + ".txt");
                } else {
                    fichero = new FileWriter(chooser.getSelectedFile());
                }
                System.out.println(chooser.getSelectedFile().getName());
                pw = new PrintWriter(fichero);


                pw.println(opcion);

                for (int j = 0; j < datos.length; j++) {

                    pw.println(datos[j]);

                }

                // }

            } catch (Exception e) {
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                }
            }

        }


    }//GEN-LAST:event_guardar_menu_archActionPerformed

    private void archivo_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivo_salirActionPerformed
        // TODO add your handling code here:

        System.exit(0);

    }//GEN-LAST:event_archivo_salirActionPerformed

    private void dif_pres_prodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dif_pres_prodFocusGained
        // TODO add your handling code here:

        dens_lodo_prod.setEnabled(false);

    }//GEN-LAST:event_dif_pres_prodFocusGained

    private void dens_lodo_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dens_lodo_prodFocusLost
        // TODO add your handling code here:
        if (dens_lodo_prod.getText().trim().equals("")) {
            dif_pres_prod.setEnabled(true);
        } else {

            if (Float.parseFloat(dens_lodo_prod.getText().trim()) > 40 || Float.parseFloat(dens_lodo_prod.getText().trim()) < 3) {

                JOptionPane.showMessageDialog(this, err_msg4, "Error", JOptionPane.ERROR_MESSAGE);
                dens_lodo_prod.setText("");
                dens_lodo_prod.requestFocus();

            }

        }
    }//GEN-LAST:event_dens_lodo_prodFocusLost

    private void dif_pres_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dif_pres_prodFocusLost
        // TODO add your handling code here:

        if (dif_pres_prod.getText().trim().equals("")) {
            dens_lodo_prod.setEnabled(true);
        } else {

            if (Float.parseFloat(dif_pres_prod.getText().trim()) > 5000 || Float.parseFloat(dif_pres_prod.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg5, "Error", JOptionPane.ERROR_MESSAGE);
                dif_pres_prod.setText("");
                dif_pres_prod.requestFocus();

            }

        }
    }//GEN-LAST:event_dif_pres_prodFocusLost

    private void dens_lodo_prodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dens_lodo_prodFocusGained
        // TODO add your handling code here:
        dif_pres_prod.setEnabled(false);
    }//GEN-LAST:event_dens_lodo_prodFocusGained

    private void fs_grad_frac_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_grad_frac_intFocusLost
        // TODO add your handling code here:
        if (!fs_grad_frac_int.getText().trim().equals("")) {
            if (Float.parseFloat(fs_grad_frac_int.getText().trim()) > 3 || Float.parseFloat(fs_grad_frac_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg6, "Error", JOptionPane.ERROR_MESSAGE);
                fs_grad_frac_int.setText("");
                fs_grad_frac_int.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_grad_frac_intFocusLost

    private void fs_gradfrac_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_gradfrac_supFocusLost
        // TODO add your handling code here:
        if (!fs_gradfrac_sup.getText().trim().equals("")) {
            if (Float.parseFloat(fs_gradfrac_sup.getText().trim()) > 3 || Float.parseFloat(fs_gradfrac_sup.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg8, "Error", JOptionPane.ERROR_MESSAGE);
                fs_gradfrac_sup.setText("");
                fs_gradfrac_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_gradfrac_supFocusLost

    private void grad_gas_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_gas_supFocusLost
        // TODO add your handling code here:
        if (!grad_gas_sup.getText().trim().equals("")) {
            if (Float.parseFloat(grad_gas_sup.getText().trim()) > 10 || Float.parseFloat(grad_gas_sup.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg9, "Error", JOptionPane.ERROR_MESSAGE);
                grad_gas_sup.setText("");
                grad_gas_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_gas_supFocusLost

    private void grad_form_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_form_supFocusLost
        // TODO add your handling code here:
        if (!grad_form_sup.getText().trim().equals("")) {
            if (Float.parseFloat(grad_form_sup.getText().trim()) > 10 || Float.parseFloat(grad_form_sup.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg10, "Error", JOptionPane.ERROR_MESSAGE);
                grad_form_sup.setText("");
                grad_form_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_form_supFocusLost

    private void grad_gas_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_gas_intFocusLost
        // TODO add your handling code here:
        if (!grad_gas_int.getText().trim().equals("")) {
            if (Float.parseFloat(grad_gas_int.getText().trim()) > 10 || Float.parseFloat(grad_gas_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg11, "Error", JOptionPane.ERROR_MESSAGE);
                grad_gas_int.setText("");
                grad_gas_int.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_gas_intFocusLost

    private void grad_gas_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_gas_prodFocusLost
        // TODO add your handling code here:

        if (!grad_gas_prod.getText().trim().equals("")) {
            if (Float.parseFloat(grad_gas_prod.getText().trim()) > 10 || Float.parseFloat(grad_gas_prod.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg12, "Error", JOptionPane.ERROR_MESSAGE);
                grad_gas_prod.setText("");
                grad_gas_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_gas_prodFocusLost

    private void dif_pres_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dif_pres_intFocusLost
        // TODO add your handling code here:
        if (!dif_pres_int.getText().trim().equals("")) {
            if (Float.parseFloat(dif_pres_int.getText().trim()) > 5000 || Float.parseFloat(dif_pres_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg13, "Error", JOptionPane.ERROR_MESSAGE);
                dif_pres_int.setText("");
                dif_pres_int.requestFocus();

            }
        }

    }//GEN-LAST:event_dif_pres_intFocusLost

    private void dens_lodo_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dens_lodo_supFocusLost
        // TODO add your handling code here:
        if (!dens_lodo_sup.getText().trim().equals("")) {
            if (Float.parseFloat(dens_lodo_sup.getText().trim()) > 40 || Float.parseFloat(dens_lodo_sup.getText().trim()) < 3) {

                JOptionPane.showMessageDialog(this, err_msg14, "Error", JOptionPane.ERROR_MESSAGE);
                dens_lodo_sup.setText("");
                dens_lodo_sup.requestFocus();

            }
        }

    }//GEN-LAST:event_dens_lodo_supFocusLost

    private void grad_frac_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_frac_intFocusLost
        // TODO add your handling code here:
        if (!grad_frac_int.getText().trim().equals("")) {
            if (Float.parseFloat(grad_frac_int.getText().trim()) > 50 || Float.parseFloat(grad_frac_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg15, "Error", JOptionPane.ERROR_MESSAGE);
                grad_frac_int.setText("");
                grad_frac_int.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_frac_intFocusLost

    private void grad_frac_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_frac_supFocusLost
        // TODO add your handling code here:
        if (!grad_frac_sup.getText().trim().equals("")) {
            if (Float.parseFloat(grad_frac_sup.getText().trim()) > 50 || Float.parseFloat(grad_frac_sup.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg17, "Error", JOptionPane.ERROR_MESSAGE);
                grad_frac_sup.setText("");
                grad_frac_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_frac_supFocusLost

    private void dens_lodo_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dens_lodo_intFocusLost
        // TODO add your handling code here:
        if (!dens_lodo_int.getText().trim().equals("")) {
            if (Float.parseFloat(dens_lodo_int.getText().trim()) > 40 || Float.parseFloat(dens_lodo_int.getText().trim()) < 3) {

                JOptionPane.showMessageDialog(this, err_msg18, "Error", JOptionPane.ERROR_MESSAGE);
                dens_lodo_int.setText("");
                dens_lodo_int.requestFocus();

            }
        }
    }//GEN-LAST:event_dens_lodo_intFocusLost

    private void grad_form_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_form_intFocusLost
        // TODO add your handling code here:
        if (!grad_form_int.getText().trim().equals("")) {
            if (Float.parseFloat(grad_form_int.getText().trim()) > 10 || Float.parseFloat(grad_form_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg20, "Error", JOptionPane.ERROR_MESSAGE);
                grad_form_int.setText("");
                grad_form_int.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_form_intFocusLost

    private void grad_form_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grad_form_prodFocusLost
        // TODO add your handling code here:
        if (!grad_form_prod.getText().trim().equals("")) {
            if (Float.parseFloat(grad_form_prod.getText().trim()) > 10 || Float.parseFloat(grad_form_prod.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg21, "Error", JOptionPane.ERROR_MESSAGE);
                grad_form_prod.setText("");
                grad_form_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_grad_form_prodFocusLost

    private void fs_tens2_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens2_supFocusLost
        // TODO add your handling code here:
        if (!fs_tens2_sup.getText().trim().equals("")) {
            if (Float.parseFloat(fs_tens2_sup.getText().trim()) > 500000 || Float.parseFloat(fs_tens2_sup.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg22, "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens2_sup.setText("");
                fs_tens2_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_tens2_supFocusLost

    private void fs_tens2_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens2_prodFocusLost
        // TODO add your handling code here:
        if (!fs_tens2_prod.getText().trim().equals("")) {
            if (Float.parseFloat(fs_tens2_prod.getText().trim()) > 500000 || Float.parseFloat(fs_tens2_prod.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg23, "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens2_prod.setText("");
                fs_tens2_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_tens2_prodFocusLost

    private void fs_tens2_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens2_intFocusLost
        // TODO add your handling code here:
        if (!fs_tens2_int.getText().trim().equals("")) {
            if (Float.parseFloat(fs_tens2_int.getText().trim()) > 500000 || Float.parseFloat(fs_tens2_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, err_msg24, "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens2_int.setText("");
                fs_tens2_int.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_tens2_intFocusLost

    private void fs_tens1_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens1_intFocusLost
        // TODO add your handling code here:
        if (!fs_tens1_int.getText().trim().equals("")) {
            if (Float.parseFloat(fs_tens1_int.getText().trim()) > 5 || Float.parseFloat(fs_tens1_int.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg25, "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens1_int.setText("");
                fs_tens1_int.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_tens1_intFocusLost

    private void fs_est_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_est_intFocusLost
        // TODO add your handling code here:
        if (!fs_est_int.getText().trim().equals("")) {
            if (Float.parseFloat(fs_est_int.getText().trim()) > 5 || Float.parseFloat(fs_est_int.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg26, "Error", JOptionPane.ERROR_MESSAGE);
                fs_est_int.setText("");
                fs_est_int.requestFocus();

            }
        }


    }//GEN-LAST:event_fs_est_intFocusLost

    private void fs_col_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_col_intFocusLost
        // TODO add your handling code here:
        if (!fs_col_int.getText().trim().equals("")) {
            if (Float.parseFloat(fs_col_int.getText().trim()) > 5 || Float.parseFloat(fs_col_int.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg27, "Error", JOptionPane.ERROR_MESSAGE);
                fs_col_int.setText("");
                fs_col_int.requestFocus();

            }
        }


    }//GEN-LAST:event_fs_col_intFocusLost

    private void fs_estallido_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_estallido_prodFocusLost
        // TODO add your handling code here:

        if (!fs_estallido_prod.getText().trim().equals("")) {
            if (Float.parseFloat(fs_estallido_prod.getText().trim()) > 5 || Float.parseFloat(fs_estallido_prod.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg28, "Error", JOptionPane.ERROR_MESSAGE);
                fs_estallido_prod.setText("");
                fs_estallido_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_estallido_prodFocusLost

    private void fs_col_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_col_prodFocusLost
        // TODO add your handling code here:
        if (!fs_col_prod.getText().trim().equals("")) {
            if (Float.parseFloat(fs_col_prod.getText().trim()) > 5 || Float.parseFloat(fs_col_prod.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg29, "Error", JOptionPane.ERROR_MESSAGE);
                fs_col_prod.setText("");
                fs_col_prod.requestFocus();

            }
        }

    }//GEN-LAST:event_fs_col_prodFocusLost

    private void fs_tens1_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens1_prodFocusLost
        // TODO add your handling code here:

        if (!fs_tens1_prod.getText().trim().equals("")) {

            if (Float.parseFloat(fs_tens1_prod.getText().trim()) > 5 || Float.parseFloat(fs_tens1_prod.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, err_msg30, "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens1_prod.setText("");
                fs_tens1_prod.requestFocus();

            }
        }

    }//GEN-LAST:event_fs_tens1_prodFocusLost

    private void fs_est_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_est_supFocusLost
        // TODO add your handling code here:

        if (!fs_est_sup.getText().trim().equals("")) {

            if (Float.parseFloat(fs_est_sup.getText().trim()) > 5 || Float.parseFloat(fs_est_sup.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 5", "Error", JOptionPane.ERROR_MESSAGE);
                fs_est_sup.setText("");
                fs_est_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_est_supFocusLost

    private void fs_col_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_col_supFocusLost
        // TODO add your handling code here:
        if (!fs_col_sup.getText().trim().equals("")) {

            if (Float.parseFloat(fs_col_sup.getText().trim()) > 5 || Float.parseFloat(fs_col_sup.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 5", "Error", JOptionPane.ERROR_MESSAGE);
                fs_col_sup.setText("");
                fs_col_sup.requestFocus();

            }
        }

    }//GEN-LAST:event_fs_col_supFocusLost

    private void fs_tens1_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fs_tens1_supFocusLost
        // TODO add your handling code here:

        if (!fs_tens1_sup.getText().trim().equals("")) {

            if (Float.parseFloat(fs_tens1_sup.getText().trim()) > 5 || Float.parseFloat(fs_tens1_sup.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 5", "Error", JOptionPane.ERROR_MESSAGE);
                fs_tens1_sup.setText("");
                fs_tens1_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_fs_tens1_supFocusLost

    private void long_min_secc_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_long_min_secc_prodFocusLost
        // TODO add your handling code here:

        if (!long_min_secc_prod.getText().trim().equals("")) {

            if (Integer.parseInt(long_min_secc_prod.getText().trim()) > 5000 || Integer.parseInt(long_min_secc_prod.getText().trim()) < 60) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 60 a 5000", "Error", JOptionPane.ERROR_MESSAGE);
                long_min_secc_prod.setText("");
                long_min_secc_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_long_min_secc_prodFocusLost

    private void long_min_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_long_min_intFocusLost
        // TODO add your handling code here:
        if (!long_min_int.getText().trim().equals("")) {

            if (Integer.parseInt(long_min_int.getText().trim()) > 5000 || Integer.parseInt(long_min_int.getText().trim()) < 60) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 60 a 5000", "Error", JOptionPane.ERROR_MESSAGE);
                long_min_int.setText("");
                long_min_int.requestFocus();

            }
        }

    }//GEN-LAST:event_long_min_intFocusLost

    private void long_min_secc_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_long_min_secc_supFocusLost
        // TODO add your handling code here:

        if (!long_min_secc_sup.getText().trim().equals("")) {

            if (Integer.parseInt(long_min_secc_sup.getText().trim()) > 5000 || Integer.parseInt(long_min_secc_sup.getText().trim()) < 60) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 60 a 5000", "Error", JOptionPane.ERROR_MESSAGE);
                long_min_secc_sup.setText("");
                long_min_secc_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_long_min_secc_supFocusLost

    private void nosecciones_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nosecciones_supFocusLost
        // TODO add your handling code here:

        if (!nosecciones_sup.getText().trim().equals("")) {

            if (Float.parseFloat(nosecciones_sup.getText().trim()) > 20 || Float.parseFloat(nosecciones_sup.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20", "Error", JOptionPane.ERROR_MESSAGE);
                nosecciones_sup.setText("");
                nosecciones_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_nosecciones_supFocusLost

    private void no_secc_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_no_secc_prodFocusLost
        // TODO add your handling code here:

        if (!no_secc_prod.getText().trim().equals("")) {

            if (Integer.parseInt(no_secc_prod.getText().trim()) > 20 || Integer.parseInt(no_secc_prod.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20", "Error", JOptionPane.ERROR_MESSAGE);
                no_secc_prod.setText("");
                no_secc_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_no_secc_prodFocusLost

    private void num_sec_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_num_sec_intFocusLost
        // TODO add your handling code here:

        if (!num_sec_int.getText().trim().equals("")) {

            if (Integer.parseInt(num_sec_int.getText().trim()) > 20 || Integer.parseInt(num_sec_int.getText().trim()) < 1) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20", "Error", JOptionPane.ERROR_MESSAGE);
                num_sec_int.setText("");
                num_sec_int.requestFocus();

            }
        }
    }//GEN-LAST:event_num_sec_intFocusLost

    private void prof_t_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prof_t_intFocusLost
        // TODO add your handling code here:

        if (!prof_t_int.getText().trim().equals("")) {

            if (Integer.parseInt(prof_t_int.getText().trim()) > 20000 || Integer.parseInt(prof_t_int.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20000", "Error", JOptionPane.ERROR_MESSAGE);
                prof_t_int.setText("");
                prof_t_int.requestFocus();

            }
        }

    }//GEN-LAST:event_prof_t_intFocusLost

    private void prof_tot_prodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prof_tot_prodFocusLost
        // TODO add your handling code here:

        if (!prof_tot_prod.getText().trim().equals("")) {

            if (Float.parseFloat(prof_tot_prod.getText().trim()) > 20000 || Float.parseFloat(prof_tot_prod.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20000", "Error", JOptionPane.ERROR_MESSAGE);
                prof_tot_prod.setText("");
                prof_tot_prod.requestFocus();

            }
        }
    }//GEN-LAST:event_prof_tot_prodFocusLost

    private void prof_total_supFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prof_total_supFocusLost
        // TODO add your handling code here:

        if (!prof_total_sup.getText().trim().equals("")) {

            if (Float.parseFloat(prof_total_sup.getText().trim()) > 20000 || Float.parseFloat(prof_total_sup.getText().trim()) < 0) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 1 a 20000", "Error", JOptionPane.ERROR_MESSAGE);
                prof_total_sup.setText("");
                prof_total_sup.requestFocus();

            }
        }
    }//GEN-LAST:event_prof_total_supFocusLost

    private void dens_zap_intFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dens_zap_intFocusLost
        // TODO add your handling code here:
        if (!dens_zap_int.getText().trim().equals("")) {
            if (Float.parseFloat(dens_zap_int.getText().trim()) > 40 || Float.parseFloat(dens_zap_int.getText().trim()) < 3) {

                JOptionPane.showMessageDialog(this, "El rango debe ser de 3 a 40", "Error", JOptionPane.ERROR_MESSAGE);
                dens_zap_int.setText("");
                dens_zap_int.requestFocus();

            }
        }
    }//GEN-LAST:event_dens_zap_intFocusLost

    private void clr_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clr_intActionPerformed
        // TODO add your handling code here:

        prof_t_int.setText("");
        dens_lodo_int.setText("");
        fs_col_int.setText("");
        fs_est_int.setText("");
        grad_form_int.setText("");
        grad_frac_int.setText("");
        grad_gas_int.setText("");
        num_sec_int.setText("");
        long_min_int.setText("");
        dens_zap_int.setText("");
        prof_zap_int.setText("");
        dif_pres_int.setText("");
        fs_tens1_int.setText("");
        fs_tens2_int.setText("");
        fs_tens1_int.setText("");
        fs_grad_frac_int.setText("");

    }//GEN-LAST:event_clr_intActionPerformed

    private void clr_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clr_prodActionPerformed
        // TODO add your handling code here:
        prof_tot_prod.setText("");
        no_secc_prod.setText("");

        fs_col_prod.setText("");
        fs_estallido_prod.setText("");
        grad_form_prod.setText("");

        grad_gas_prod.setText("");
        long_min_secc_prod.setText("");
        fs_tens1_prod.setText("");
        fs_tens2_prod.setText("");


        dif_pres_prod.setText("");
    }//GEN-LAST:event_clr_prodActionPerformed

    private void clr_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clr_supActionPerformed
        // TODO add your handling code here:

        prof_total_sup.setText("");
        dens_lodo_sup.setText("");
        fs_col_sup.setText("");
        fs_est_sup.setText("");
        grad_form_sup.setText("");
        grad_frac_sup.setText("");
        grad_gas_sup.setText("");
        nosecciones_sup.setText("");
        long_min_secc_sup.setText("");
        fs_tens1_sup.setText("");
        fs_tens2_sup.setText("");
        fs_tens2_sup.setText("");
        fs_gradfrac_sup.setText("");

    }//GEN-LAST:event_clr_supActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(
                            UIManager.getCrossPlatformLookAndFeelClassName());
//                    if (UIManager.getCrossPlatformLookAndFeelClassName().equals("javax.swing.plaf.metal.MetalLookAndFeel")) {
//
//                        try {
//                            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                                if ("Nimbus".equals(info.getName())) {
//                                    UIManager.setLookAndFeel(info.getClassName());
//                                    break;
//                                }
//                            }
//                        } catch (Exception e) {
//                            // If Nimbus is not available, you can set the GUI to another look and feel.
//                        }
//                    }

                } catch (Exception ex) {



                    System.out.println(ex);
                }




                try {
                    new ventanap().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
                }


                System.out.println("piny = " + asf.Piny());
                System.out.println("pids = " + asf.Pids());
                System.out.println("pext = " + asf.Pext());
                System.out.println("pidz = " + asf.Pidz());
                System.out.println("gint = " + asf.Gint3());
                System.out.println("pids2 = " + asf.Pids2(9400, 15.3, 15000));
                System.out.println("gint = " + asf.Pids3());


                try {

//                    asf.Estallido();
//                  asf.Colapso();
//                 asf.Colapso2();
//                    asf.tension();
//                    asf.tension_p(0, 400);    

                    ResultSet res2 = conn.ExecQuery("SELECT * FROM caracteristicas");
                    res2.next();

                } catch (SQLException ex) {
                    Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public int sel() {

        String diam = (String) lista.getSelectedItem();
        ResultSet re = conn.ExecQuery("SELECT id_diametro FROM diametros WHERE diametro = '" + diam + "'");

        try {
            re.next();
            return re.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int sel2() {

        String diam = (String) lista_pestania_produccion.getSelectedItem();
        System.out.println("gdffadhasjkdasd" + lista_pestania_produccion.getSelectedItem());
        String c = "SELECT id_diametro FROM diametros WHERE diametro = '" + diam + "'";
        System.out.println(c);
        ResultSet re = conn.ExecQuery(c);

        try {
            re.next();
            int a = re.getInt(1);
            System.out.println(a);
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int sel3() {

        String diam = (String) lista_superficial.getSelectedItem();
        System.out.println("gdffadhasjkdasd" + diam);
        ResultSet re = conn.ExecQuery("SELECT id_diametro FROM diametros WHERE diametro = '" + diam + "'");

        try {
            re.next();
            return re.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ventanap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir_m;
    private javax.swing.JButton aceptar_int;
    private javax.swing.JButton aceptar_pro;
    private javax.swing.JButton aceptar_sup;
    private javax.swing.JMenu archivo_m;
    private javax.swing.JMenuItem archivo_salir;
    private javax.swing.JMenu ayuda_m;
    private javax.swing.JMenuItem ayuda_m_acerca_de;
    private javax.swing.JButton clr_int;
    private javax.swing.JButton clr_prod;
    private javax.swing.JButton clr_sup;
    private javax.swing.JMenuItem cont_ayuda;
    private javax.swing.JFormattedTextField dens_lodo_int;
    private javax.swing.JLabel dens_lodo_int_lab;
    private javax.swing.JLabel dens_lodo_pro_lab;
    private javax.swing.JFormattedTextField dens_lodo_prod;
    private javax.swing.JFormattedTextField dens_lodo_sup;
    private javax.swing.JLabel dens_lodo_sup_lab;
    private javax.swing.JFormattedTextField dens_zap_int;
    private javax.swing.JLabel dens_zap_lab_int;
    private javax.swing.JFormattedTextField dif_pres_int;
    private javax.swing.JLabel dif_pres_int_lab;
    private javax.swing.JLabel dif_pres_pro_lab;
    private javax.swing.JFormattedTextField dif_pres_prod;
    private javax.swing.JFormattedTextField fs_col_int;
    private javax.swing.JLabel fs_col_int_lab;
    private javax.swing.JLabel fs_col_pro_lab;
    private javax.swing.JFormattedTextField fs_col_prod;
    private javax.swing.JFormattedTextField fs_col_sup;
    private javax.swing.JLabel fs_col_sup_lab;
    private javax.swing.JFormattedTextField fs_est_int;
    private javax.swing.JLabel fs_est_int_lab;
    private javax.swing.JLabel fs_est_pro_lab;
    private javax.swing.JFormattedTextField fs_est_sup;
    private javax.swing.JLabel fs_est_sup_lab;
    private javax.swing.JFormattedTextField fs_estallido_prod;
    private javax.swing.JFormattedTextField fs_grad_frac_int;
    private javax.swing.JLabel fs_grad_frac_int_lab;
    private javax.swing.JLabel fs_grad_frac_sup_lab;
    private javax.swing.JFormattedTextField fs_gradfrac_sup;
    private javax.swing.JFormattedTextField fs_tens1_int;
    private javax.swing.JLabel fs_tens1_int_lab;
    private javax.swing.JLabel fs_tens1_pro_lab;
    private javax.swing.JFormattedTextField fs_tens1_prod;
    private javax.swing.JFormattedTextField fs_tens1_sup;
    private javax.swing.JLabel fs_tens1_sup_lab;
    private javax.swing.JFormattedTextField fs_tens2_int;
    private javax.swing.JLabel fs_tens2_int_lab;
    private javax.swing.JLabel fs_tens2_pro_lab;
    private javax.swing.JFormattedTextField fs_tens2_prod;
    private javax.swing.JFormattedTextField fs_tens2_sup;
    private javax.swing.JLabel fs_tens2_sup_lab;
    private javax.swing.JFormattedTextField grad_form_int;
    private javax.swing.JLabel grad_form_int_lab;
    private javax.swing.JLabel grad_form_pro_lab;
    private javax.swing.JFormattedTextField grad_form_prod;
    private javax.swing.JFormattedTextField grad_form_sup;
    private javax.swing.JLabel grad_form_sup_lab;
    private javax.swing.JFormattedTextField grad_frac_int;
    private javax.swing.JLabel grad_frac_int_lab;
    private javax.swing.JFormattedTextField grad_frac_sup;
    private javax.swing.JLabel grad_frac_sup_lab;
    private javax.swing.JFormattedTextField grad_gas_int;
    private javax.swing.JLabel grad_gas_int_lab;
    private javax.swing.JLabel grad_gas_pro_lab;
    private javax.swing.JFormattedTextField grad_gas_prod;
    private javax.swing.JFormattedTextField grad_gas_sup;
    private javax.swing.JLabel grad_gas_sup_lab;
    private javax.swing.JMenuItem guardar_menu_arch;
    private javax.swing.JMenuItem idioma_esp;
    private javax.swing.JMenuItem idioma_ing;
    private javax.swing.JMenu idioma_m;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox lista;
    private javax.swing.JComboBox lista_pestania_produccion;
    private javax.swing.JComboBox lista_superficial;
    private javax.swing.JFormattedTextField long_min_int;
    private javax.swing.JLabel long_min_sec_lab_int;
    private javax.swing.JLabel long_min_sec_lab_pro;
    private javax.swing.JLabel long_min_sec_lab_sup;
    private javax.swing.JFormattedTextField long_min_secc_prod;
    private javax.swing.JFormattedTextField long_min_secc_sup;
    private javax.swing.JLabel no_sec_lab_sup;
    private javax.swing.JLabel no_secc_lab_int;
    private javax.swing.JLabel no_secc_lab_pro;
    private javax.swing.JFormattedTextField no_secc_prod;
    private javax.swing.JFormattedTextField nosecciones_sup;
    private javax.swing.JFormattedTextField num_sec_int;
    private javax.swing.JFormattedTextField prof_t_int;
    private javax.swing.JLabel prof_t_int_lab;
    private javax.swing.JLabel prof_t_pro_lab;
    private javax.swing.JLabel prof_t_sup_lab;
    private javax.swing.JFormattedTextField prof_tot_prod;
    private javax.swing.JFormattedTextField prof_total_sup;
    private javax.swing.JFormattedTextField prof_zap_int;
    private javax.swing.JLabel prof_zap_int_lab;
    private javax.swing.JButton selec_int;
    private javax.swing.JButton selec_pro;
    private javax.swing.JButton selec_sup;
    private javax.swing.JTable sup_tab_tabla;
    private javax.swing.JPanel superficial;
    private javax.swing.JTable tab_tabla_intermedio;
    private javax.swing.JTable tabla_prod_tab;
    // End of variables declaration//GEN-END:variables
}
