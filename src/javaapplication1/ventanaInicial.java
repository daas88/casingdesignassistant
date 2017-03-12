/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class ventanaInicial extends javax.swing.JFrame {

    /**
     * Creates new form ventanaInicial
     */
    private DefaultTableModel modelo = new DefaultTableModel();
    private Object datos[] = new Object[15];
    ImageIcon icon = new ImageIcon("aaa.png");
    JLabel label = new JLabel();
    ArrayList<Seccion> arreglo = new ArrayList<Seccion>();
    ArrayList<Seccion> arreglo2 = new ArrayList<Seccion>();
    ArrayList<Seccion> arr = new ArrayList<Seccion>();
    ArrayList<Float> arre = new ArrayList<Float>();
    ArrayList<ImageIcon> imgs = new ArrayList<ImageIcon>();
    private String seccion = "#";
    private String seccion2 = "#";
    private String grado = "Nomenclatura API";
    private String peso = "Peso Nominal";
    private String longitud = "Longitud";
    private String profundidad = "Profundidad";
    private String pies = "pies";
    private String libras = "lbs";

    public ventanaInicial() {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
        //setLayout(new GridLayout(1, 2));
        setSize(941, 707);
        setLocationRelativeTo(null);
        setVisible(true);

        arr.add(new Seccion((float) 1500.0, 814000, "N-80", (float) 35.00, 80000, (float) 10.172));
        arr.get(arr.size() - 1).setFondo(12000);
        arr.add(new Seccion((float) 1500.0, 745000, "N-80", (float) 32.00, 80000, (float) 9.317));
        arr.get(arr.size() - 1).setFondo(10500);
        arr.add(new Seccion((float) 2400.0, 676000, "N-80", (float) 29.00, 80000, (float) 8.449));
        arr.get(arr.size() - 1).setFondo(9000);
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 20.00, 80000, (float) 6.656));
        arr.get(arr.size() - 1).setFondo(6600);
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 20.00, 80000, (float) 6.656));
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 19.00, 80000, (float) 6.656));
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 18.00, 80000, (float) 6.656));
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 17.00, 80000, (float) 6.656));
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 16.00, 80000, (float) 6.656));
        arr.add(new Seccion((float) 6600.0, 366000, "J-55", (float) 15.00, 80000, (float) 6.656));

        ImageIcon img = new ImageIcon(getClass().getResource("/javaapplication1/10.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);
        img = new ImageIcon(getClass().getResource("/javaapplication1/9.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);
        img = new ImageIcon(getClass().getResource("/javaapplication1/8.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/7.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/6.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/5.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/4.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/3.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/2.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/1.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);
//        mostrartubos(array);
//        arreglo = array;
//        op = ind;
    }

    public ventanaInicial(ArrayList<Seccion> array) {

        initComponents();
        consejo.setVisible(false);
        setSize(941, 767);
        setLocationRelativeTo(null);
        setVisible(true);

        ImageIcon img = new ImageIcon(getClass().getResource("/javaapplication1/10.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);
        img = new ImageIcon(getClass().getResource("/javaapplication1/9.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(220, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);
        img = new ImageIcon(getClass().getResource("/javaapplication1/8.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/7.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/6.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/5.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/4.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/3.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/2.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        img = new ImageIcon(getClass().getResource("/javaapplication1/1.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(240, 140, java.awt.Image.SCALE_SMOOTH));
        imgs.add(img);

        if (ventanap.idioma() == 1) {

            seccion = "#";
            seccion2 = "#";
            peso = "Nominal Weight (lbs)";
            grado = "API Name";
            longitud = "Length (ft)";
            profundidad = "Depth(ft)";
            scrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Design"));
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));
            jButton1.setText("Export");
            pies = "ft";

        } else {

            seccion = "#";
            seccion2 = "#";
            peso = "Peso Nominal (lbs)";
            grado = "Nomenclatura API";
            longitud = "Longitud (pies)";
            profundidad = "Profundidad (pies)";
            scrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Diseño"));
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
            jButton1.setText("Exportar");


        }
        
        if(buscar2(array)){
            
           consejo.setVisible(true); 
            
        }

        Collections.reverse(imgs);
        arreglo = array;
        mostrar(array);
        arreglo.remove(0);
        mostrartubos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        consejo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setResizable(false);

        scrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Diseño"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sección", "Profundidad", "Longitud", "Grado API", "Peso Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tabla.setEnabled(false);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        consejo.setText("asdjaskd aksjdhksaj  asjdhskajdh askjd hkasjdkajdhkasjdhask asdashs");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(consejo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(consejo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        FileWriter fichero = null;
        PrintWriter pw;
        JFileChooser chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos HTML", "html");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {

                if (!chooser.getSelectedFile().toString().endsWith(".html")) {
                    fichero = new FileWriter(chooser.getSelectedFile() + ".html");
                } else {
                    fichero = new FileWriter(chooser.getSelectedFile());
                }
                System.out.println(chooser.getSelectedFile().getName());
                pw = new PrintWriter(fichero);

//                for (int i = 0; i < arreglo.size(); i++) {
//                    pw.println("Linea " + arreglo.get(i).getGrado_api());
//                    pw.println("Linea " + arreglo.get(i).getPeso());
//                    pw.println("Linea " + arreglo.get(i).getLongitud());
//                    pw.println("Linea " + arreglo.get(i).getTope());
//                    pw.println("Linea " + arreglo.get(i).getFondo());

                pw.println("<table border=" + 1 + ">");
                pw.println("<tr>");
                pw.println("<th>" + seccion2 + "</th>");
                pw.println("<th>" + profundidad + "</th>");
                pw.println("<th>" + longitud + "</th>");
                pw.println("<th>" + grado + "</th>");
                pw.println("<th>" + peso + "</th>");
                pw.println("</tr>");
                for (int j = 0; j < tabla.getModel().getRowCount(); j++) {

                    pw.println(" <tr>");

                    for (int i = 0; i < tabla.getModel().getColumnCount(); i++) {

                        pw.println("<td>" + tabla.getModel().getValueAt(j, i).toString() + "</td>");

                    }

                    pw.println(" </tr>");

                }

                pw.println(" </table>");

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



    }//GEN-LAST:event_jButton1ActionPerformed

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    private void mostrar(ArrayList<Seccion> tubs) {

        Object[] etiquetas = {"" + seccion, "" + profundidad, "" + longitud, "" + grado, "" + peso};

        modelo.setColumnIdentifiers(etiquetas);
        System.out.println(tubs.size());
        String[] fila = new String[tabla.getColumnCount()];

        for (int i = 0; i < tubs.size(); i++) {

            fila[0] = Integer.toString(i + 1);
            fila[1] = Integer.toString(tubs.get(i).getTope()) + " - " + Integer.toString(tubs.get(i).getFondo());
            fila[2] = Integer.toString((int) tubs.get(i).getLongitud()) ;
            fila[3] = tubs.get(i).getGrado_api();
            fila[4] = Float.toString((int) tubs.get(i).getPeso());

            modelo.addRow(fila);
        }


        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
        tabla.getTableHeader().setFont( new Font( "Arial" , Font.PLAIN, 10 ));
    }

    private void mostrartubos2() {

        // mostrar(arr);
        int y = 1;
        //JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        JPanel panelImg = new JPanel();
        panelImg.setLayout(null);
        System.err.println(arreglo.size());
        panelImg.setPreferredSize(new Dimension(210, arreglo.size() * 198));

        //scrollPane.setPreferredSize(new Dimension(600,arr.size() * 401));

        Collections.sort(arreglo, new Comparator<Seccion>() {

            @Override
            public int compare(Seccion p1, Seccion p2) {
                return (int) (p2.getPeso() - p1.getPeso());
            }
        });

        for (int i = 0; i < arr.size(); i++) {


            arre.add(arr.get(i).getPeso());

        }


        for (int i = 0; i < 5; i++) {

            JLabel intervalo = new JLabel();
            JLabel longi = new JLabel();
            JLabel grad = new JLabel();
            JLabel etiqueta = new JLabel();
            JLabel sexion = new JLabel();
            //etiqueta.setText("jodr");
            etiqueta.setBounds(20, y, 240, 180);

            for (int j = 0; j < arre.size(); j++) {
                System.out.println(arr.get(i).getPeso() + " sdsd " + arre.get(j));
                if ((float) arr.get(i).getPeso() == arre.get(j)) {
                    arre.remove(j);
                    if (imgs.size() - 1 > j) {
                        etiqueta.setIcon(imgs.get(j));
                        imgs.remove(j);
                    } else {
                        etiqueta.setIcon(imgs.get(imgs.size() - 1));
                    }
                    System.out.println("sdsd");
                }

            }

            sexion.setText("" + (i + 1));
            grad.setText(arr.get(i).getGrado_api());
            longi.setText("" + arr.get(i).getLongitud());
            intervalo.setText(arr.get(i).getTope() + " - " + arr.get(i).getFondo());

            intervalo.setBounds(280, y, 80, 80);
            intervalo.setFont(new Font("Dialog", Font.BOLD, 10));
            sexion.setBounds(280, y + 40, 80, 80);
            sexion.setFont(new Font("Dialog", Font.BOLD, 10));
            grad.setBounds(280, y + 60, 80, 80);
            grad.setFont(new Font("Dialog", Font.BOLD, 10));
            longi.setBounds(280, y + 20, 80, 80);
            longi.setFont(new Font("Dialog", Font.BOLD, 10));

            //scrollPane.setBounds(10, 101, 742, 276);
            //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            panelImg.add(intervalo);
            panelImg.add(sexion);
            panelImg.add(grad);
            panelImg.add(longi);
            panelImg.add(etiqueta);

            y = y + 140;
        }

        panelImg.repaint();
        panelImg.revalidate();
        //scrollPane.setBounds(50, 10, 300, 700);
        //scrollPane.setPreferredSize(new Dimension(200, 500));
        //scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(panelImg);
        getContentPane().add(scrollPane);

    }

    private void mostrartubos() {

        int y = 1;
        JPanel panelImg = new JPanel();
        panelImg.setLayout(null);
        panelImg.setPreferredSize(new Dimension(210, arreglo.size() * 148));
        ArrayList<Seccion> aux;
        //Collections.reverse(arreglo);
        int inds[] = new int[arreglo.size()];
        aux = arreglo;

        for (int j = 0; j < arreglo.size(); j++) {

            inds[j] = j;

            for (int i = 0; i < arreglo.size(); i++) {


                if (arreglo.get(j).getPeso() == arreglo.get(i).getPeso()) {

                    System.out.println(arreglo.get(j).getPeso() + "ya");
                    System.out.println(arreglo.get(i).getPeso());
                    inds[i] = j;
                    //System.out.println(inds.get(i));

                }

            }

        }

        System.out.println("ssagjhgfjkasdgsdjk" + inds.length);

        for (int i = 0; i < arreglo.size(); i++) {

            JLabel intervalo = new JLabel();
            JLabel longi = new JLabel();
            JLabel grad = new JLabel();
            JLabel etiqueta = new JLabel();
            JLabel sexion = new JLabel();
            //etiqueta.setText("jodr");
            etiqueta.setBounds(20, y, 240, 180);

            if (imgs.size() > 1) {
                etiqueta.setIcon(imgs.get(inds[i]));

            } else {
                etiqueta.setIcon(imgs.get(0));
            }




//            switch ((int)arreglo.get(i).getPeso()){
//                
//                case 72:
//                    etiqueta.setIcon(imgs.get(0));
//                    System.out.println("aaaaaaa");
//                    break;
//                
//                case 68:
//                    etiqueta.setIcon(imgs.get(1));
//                    System.out.println("bbbbb");
//                    break;
//                
//                case 61:
//                    etiqueta.setIcon(imgs.get(2));
//                    break;
//
//                case 54:
//                    etiqueta.setIcon(imgs.get(3));
//                    break;                    
//
//                case 48:
//                    etiqueta.setIcon(imgs.get(4));
//                    break;                    
//                    
//                
//            }


            sexion.setText("" + arreglo.get(i).getPeso() + " " + libras);
            grad.setText(arreglo.get(i).getGrado_api());
            longi.setText("" + arreglo.get(i).getLongitud() + " " + pies);
            intervalo.setText(arreglo.get(i).getTope() + " " + pies + " - " + arreglo.get(i).getFondo() + " " + pies);

            intervalo.setBounds(280, y, 80, 80);
            intervalo.setFont(new Font("Dialog", Font.PLAIN, 9));
            sexion.setBounds(280, y + 40, 80, 80);
            sexion.setFont(new Font("Dialog", Font.PLAIN, 9));
            grad.setBounds(280, y + 60, 80, 80);
            grad.setFont(new Font("Dialog", Font.PLAIN, 9));
            longi.setBounds(280, y + 20, 80, 80);
            longi.setFont(new Font("Dialog", Font.PLAIN, 9));

            //scrollPane.setBounds(10, 101, 742, 276);
            //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            panelImg.add(intervalo);
            panelImg.add(sexion);
            panelImg.add(grad);
            panelImg.add(longi);
            panelImg.add(etiqueta);

            y = y + 140;
        }

        panelImg.repaint();
        panelImg.revalidate();
        //scrollPane.setBounds(50, 10, 300, 700);
        //scrollPane.setPreferredSize(new Dimension(200, 500));
        //scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(panelImg);
        getContentPane().add(scrollPane);

    }

    public static void main(String args[]) {

        ventanaInicial v = new ventanaInicial();
        v.mostrartubos2();

    }

    private boolean buscar2(ArrayList <Seccion> secs3) {

        for (int i = 0; i < secs3.size(); i++) {

            if (secs3.get(i).getGrado_api().equals("K-55") || secs3.get(i).getGrado_api().equals("J-55") || secs3.get(i).getGrado_api().equals("L-80") || secs3.get(i).getGrado_api().equals("N-80")) {
                return true;

            }

        }

        return false;

    }

    public void setDatos(Object[] datos) {
        this.datos = datos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consejo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
