/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Produccion {

    private int index = 3;
    ArrayList<Object> record = new ArrayList<Object>();
    private conexion conecceon;
    private String consulta = "";
    private int diametro;
    private ArrayList<Seccion> secs = new ArrayList<Seccion>();
    private ArrayList<String> tubos = new ArrayList<String>();
    private ArrayList<Seccion> secs2 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs3 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs4 = new ArrayList<Seccion>();
    private ArrayList<Seccion> est_int = new ArrayList<Seccion>();
    private int h = 4000, secciones = 4, long_minima_sec = 1500, secc_cont = 0;
    private int pids2 = 0, pids3 = 0;
    private float gfr = (float) 15.9, Gg = (float) 0.1, densidad_lodo = (float) 9.3, fse = (float) 1.1, fsc = (float) 1.1, gform = (float) 0.64, pform, pids, pext, pidz, gint, h_actual = h, pdc, densidad_lodo_fondo, densidad_zapata, fs_tension1, fs_tension2, fs_grad_frac, dif_pres, prof_zapata, fsgfrac;

    public void setProf_zapata(float prof_zapata) {
        this.prof_zapata = prof_zapata;
    }

    public Produccion(conexion con) {

        conecceon = con;
        //ResultSet datos = conecceon.ExecQuery(consulta);

    }

    public float PForm() {

        pform = (float) (gfr * h);

        return pform;

    }

    public void dens_lodo() {

        densidad_lodo = (float) ((float) (pform + dif_pres) / (0.052 * h));

    }

    public float Pids() {

        pids = (float) (pform - Gg * h) * fse;
        return pids;

    }

    public float Pids2(int hz, double dens_hz, int h) {

        double pform = 0;
        double piny2 = 0.052 * 15.9 * hz;
        System.out.println("piny2 ====>" + piny2);
        float pis = 0;

//        if (gform != 0) {

        pform = ((0.052 * dens_hz * h) - 400);
        System.out.println("pform ====> " + pform);

//            pform = (int)(gform * h);
//            System.out.println("ssd ggf hgf gf h "+pform+"  "+gform);

//        } else {
//
//            
//        }

        if ((float) (piny2 - Gg * hz) < (float) (pform - Gg * h)) {


            pis = (float) (piny2 - 0.1 * hz);
            System.out.println("jsahkdhgasgdsfahdgfashdgfasgdsa " + pis);



        } else {

            pis = (float) (pform - Gg * h);
            System.out.println("jsahkdhgasgdsfahdgfashdgfasgdsa " + pis);

        }

        pids2 = (int) (fse * pis);
        System.out.println(pids2);
        return pids2;

    }

    public float Pids3() {

        pids3 = (int) (((gform * h) - (Gg * h)) * fse);
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee" + gform);
        return pids3;

    }

    public float Pext() {

        pext = (float) h * gform;
        return pext;
    }

    public float Pext2() {

        pext = (float) 12.5 * 9400;
        return pext;
    }

    public float Pidz() {
        pidz = (float) (pform - pext) * fse;
        return pidz;
    }

    public float Gint() {

        gint = (float) ((pids - pidz) / h);
        return gint;

    }

    public float Gint2() {

        gint = (float) ((pids2 - pidz) / h);
        return gint;

    }

    public float Gint3() {
        System.out.println("Pesdddsdsado = " + gint);
        gint = (float) ((pids3 - 0) / h);

        return gint;

    }

    public void tension_p(float dens, int dp) throws SQLException {

        ArrayList<Float> eles = new ArrayList<Float>();
        ArrayList<Float> pes = new ArrayList<Float>();
        ArrayList<Float> tes = new ArrayList<Float>();
        ArrayList<Float> tes2 = new ArrayList<Float>();


        if (dens == 0.0) {

            float ph = (gform * h) + dp;
            dens = (float) (ph / (0.052 * h));
            System.out.println("dsffdfds " + dens);
        }

        for (int i = 0; i < secs3.size(); i++) {

            eles.add(secs3.get(i).getLongitud() * secs3.get(i).getPeso());

            if (i == 0) {
                System.out.println(i + " " + secs3.get(i).getAreap() + " " + secs3.get(i).getFondo());
                pes.add(-(float) (0.052 * dens * secs3.get(i).getFondo() * secs3.get(i).getAreap()));


            } else {

                System.out.println(i + " " + secs3.get(i - 1).getAreap() + " " + secs3.get(i - 1).getFondo());
                pes.add((float) (0.052 * dens * secs3.get(i).getFondo() * (secs3.get(i).getAreap())));

            }
            System.out.println("L" + (i + 1) + "W" + (i + 1) + " = " + eles.get(i));
            System.out.println("PH" + (i + 1) + "A" + (i + 1) + " = " + pes.get(i));

        }

        float ee = 100000;

        for (int j = 0; j < pes.size() + 1; j++) {

            if (j == 0) {

                tes.add(pes.get(j));
                System.out.println("t" + (j + 1) + "= " + tes.get(j));

            } else {

                if (j < pes.size()) {

                    float aa = (tes.get(tes.size() - 1) + eles.get(j - 1));
                    System.out.println("t" + (j + 1) + "= " + aa);
                    tes.add(aa);
                    System.out.println(aa);

                    aa = (tes.get(tes.size() - 1) + pes.get(j));
                    System.out.println("t" + (j + 1) + "'= " + aa);
                    tes.add(aa);
                    //System.out.println(aa);
                } else {

                    float aa = (tes.get(tes.size() - 1) + eles.get(j - 1));
                    System.out.println("t" + (j + 1) + "= " + aa);
                    tes.add(aa);


                }
            }



        }

        for (int j = 0; j < tes.size(); j++) {

            if (j == 0) {

                tes2.add(tes.get(j) + ee);

            } else {

                if (tes.get(j) + ee > tes.get(j) * 2) {

                    tes2.add(tes.get(j) + ee);

                } else {

                    tes2.add((float) (tes.get(j) * 2));

                }



            }

        }

        for (int i = 0; i < secs3.size(); i++) {

            ResultSet res;
            System.out.println(secs3.size());
            res = conecceon.ExecQuery("SELECT tension_stc,tension_ltc,tension_but,tension_xtc,tension_tuberia FROM caracteristicas WHERE grado_api ='" + secs3.get(i).getGrado_api() + "' AND peso_nominal = '" + secs3.get(i).getPeso() + "' AND id_diametro = 4");
            float longitud = secs3.get(i).getLongitud();
            int tub = 0;
            int roscas = 0;
            int roscal = 0;
            int roscab = 0;
            int roscax = 0;


            try {

                res.next();

                roscas = res.getInt(1) * 1000;
                roscal = res.getInt(2) * 1000;
                roscab = res.getInt(3) * 1000;
                roscax = res.getInt(4) * 1000;
                tub = res.getInt(5) * 1000;
                //System.out.println(roscas+"  sd "); 
            } catch (SQLException ex) {
                Logger.getLogger(Asd.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (tes2.get(i + 1) > tub && tes2.get(i + 2) > tub) {


                res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_tuberia > '" + tes2.get(i + 2).intValue() / 1000 + "' AND id_diametro = 4");
                res.next();
                //secs4.remove(i);

                secs3.remove(i);

                secs3.add(i, new Seccion(longitud, res.getInt(11) * 1000, res.getString(1), res.getFloat(3), 0, res.getFloat(5)));
                System.out.println(secs3.get(i).getResistencia() + "ddd" + secs3.size());

            }


            roscas = res.getInt("tension_stc") * 1000;

            int tube = 0;
            boolean flag = false;


            if (tes2.get(i + 1) > roscas && tes2.get(i + 2) > roscas) {


                res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_stc > '" + tes2.get(i + 2).intValue() / 1000 + "' AND id_diametro = 4");
                res.next();


                if (res.getRow() > 0) {
                    secs3.remove(i);
                    System.out.println(" a sd ");
                    flag = true;
                    secs3.add(i, new Seccion(longitud, res.getInt(11) * 1000, res.getString(1), res.getFloat(3), 0, res.getFloat(5)));

                }

                if (!flag) {


                    res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_ltc > '" + tes2.get(i + 2).intValue() / 1000 + "' AND id_diametro = 4");

                    res.next();
                    System.out.println(" a sdl " + res.getInt(13) + tes2.get(i + 2).intValue() / 1000);
                    if (res.getRow() > 0) {

                        System.out.println(" a sd 1" + tes2.get(i + 2).intValue());
                        secs3.remove(i);
                        System.out.println(" a sd " + secs3.size());
                        flag = true;
                        secs3.add(i, new Seccion(longitud, res.getInt(11) * 1000, res.getString(1), res.getFloat(3), 0, res.getFloat(5)));
                        secs3.get(i).setRosca_valor(res.getInt(13));
                        secs3.get(i).setRosca_tipo("ltc");

                        System.out.println(secs3.get(i).getGrado_api() + "dsfsf" + i);
                        for (int j = 0; j < secs3.size(); j++) {


                            System.out.println(secs3.get(j).getGrado_api() + secs3.get(j).getPeso() + secs3.get(j).getResistencia());

                        }

                    }




                    System.out.println(tube + "ghgh");
                    res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_but > '" + tes2.get(i + 2).intValue() / 1000 + "' AND id_diametro = 4");
                    res.next();
                    if (res.getRow() > 0) {
                        secs3.remove(i);
                        flag = true;
                        secs3.add(i, new Seccion(longitud, res.getInt(11) * 1000, res.getString(1), res.getFloat(3), 0, res.getFloat(5)));

                    }



                    System.out.println(tube + "ghgh");
                    res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_xtc > '" + tes2.get(i + 2).intValue() / 1000 + "' AND id_diametro = 4");
                    res.next();
                    if (res.getRow() > 0) {
                        secs3.remove(i);
                        flag = true;
                        secs3.add(i, new Seccion(longitud, res.getInt(11) * 1000, res.getString(1), res.getFloat(3), 0, res.getFloat(5)));

                    }

                }



            }




        }




//        for (int i = 1; i < tes2.size(); i++) {
//
//            if (tub < tes2.get(i) && tub < tes2.get(i + 1)) {
//
//                res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_tuberia > '" + tub + "' AND id_diametro = 2");
//
//            }
//
//            int tube = 0;
//
//            while (true) {
//
//                res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_stc >  '" + rosca + "' AND id_diametro = 2");
//                res.next();
//                tube = res.getInt(12);
//
//                if (tube != 0 && tube > rosca) {
//
//                    float longitud = secs4.get(secs4.size() - 1).getLongitud();
//                    secs4.add(new Seccion(longitud, res.getInt(11), res.getString(1), res.getFloat(3), 0, res.getFloat(5)));
//
//                    break;
//
//                } else {
//
//                    res = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_ltc >  '" + rosca + "' AND id_diametro = 2");
//                    res.next();
//                    tube = res.getInt(12);
//
//                    if (tube != 0 && tube > rosca) {
//
//                        float longitud = secs4.get(secs4.size() - 1).getLongitud();
//                        secs4.add(new Seccion(longitud, res.getInt(11), res.getString(1), res.getFloat(3), 0, res.getFloat(5)));
//
//                        break;
//
//                    }
//
//                }
//
//            }
//
//
//
//
//
//        }



    }

    public ArrayList Estallido_Pro() throws SQLException {

        //h = 12000;
        h_actual = h;
        pidz = 0;
        System.out.println("Pesdddsdsado = " + pids3);
        lleanArr();
        String c = "(select * from caracteristicas where estallido_but < '" + (int) Pids3() + "' and id_diametro = " + diametro + " and  grado_api IN (";


        for (int i = 0; i < tubos.size(); i++) {

            if (i != tubos.size() - 1) {

                c = c + "'" + tubos.get(i) + "',";

            } else {

                c = c + "'" + tubos.get(i) + "'))";

            }


        }

        String c2 = "union (select * from caracteristicas where estallido_but > '" + (int) Pids3() + "' and id_diametro = " + diametro + " and  grado_api IN (";

        for (int i = 0; i < tubos.size(); i++) {

            if (i != tubos.size() - 1) {

                c2 = c2 + "'" + tubos.get(i) + "',";

            } else {

                c2 = c2 + "'" + tubos.get(i) + "') limit 1 )";

            }


        }


        System.out.println("Pesdddsdsado = " + c + c2);
        ResultSet res = conecceon.ExecQuery(c + c2 + " order by peso_nominal,grado_api ");

        res.afterLast();

        //res.previous();


        while (h_actual > 0 && secc_cont <= secciones && res.previous()) {

            System.out.println("adasdasvdjsadgsd");
            int res_actual = res.getInt(9);
            String gapi = res.getString(1);
            String peson = res.getString(3);
            System.out.println(gapi);
            System.out.println("Peso = " + peson);
            System.out.println("resistencia = " + res_actual);

            float long_sec = 0;
            double a = (double) pids3 / h;
            System.out.println("Pesdddsdsado = " + a + "" + res_actual);
            long_sec = (float) ((pids3 - res_actual) / a);

            System.out.println("h = " + long_sec);
            //System.out.println(secs.size());
            int t = (int) h_actual;
            h_actual = (h_actual - long_sec);
            est_int.add(new Seccion(long_sec, res.getInt(7), gapi, Float.parseFloat(peson), (int) t, (int) h_actual));

            System.out.println("dd" + h_actual);

            System.out.println("hact = " + h_actual);

            secc_cont++;
            System.out.println(secc_cont);

//            if (!res.isFirst()) {
//                res.previous();
//
//            }


        }


//
//        res.last();
//
//        h_actual = h;
//        for (int i = 0; i < aux.size(); i++) {
//
//            if (i == 0) {
//
//
//                String gapi = res.getString(1);
//                String peson = res.getString(3);
//                est_int.add(new Seccion(0, res.getInt(7), gapi, Float.parseFloat(peson), 0, (int) aux.get(i).getLongitud()));
//                h_actual = h_actual - est_int.get(i).getLongitud();
//                System.out.println("dffs" + h_actual);
//            } else {
//
//                if (!res.isFirst()) {
//                    res.previous();
//                }
//                String gapi = res.getString(1);
//                String peson = res.getString(3);
//
//                if (i + 1 == aux.size()) {
//
//                    h_actual = h_actual - secs.get(i).getLongitud();
//
//                    est_int.add(new Seccion(aux.get(i - 1).getLongitud(), res.getInt(7), gapi, Float.parseFloat(peson), est_int.get(i - 1).getFondo(), h));
//
//                } else {
//
//                    est_int.add(new Seccion(aux.get(i - 1).getLongitud(), res.getInt(7), gapi, Float.parseFloat(peson), est_int.get(i - 1).getFondo(), (int) aux.get(i).getLongitud()));
//                    h_actual = h_actual - est_int.get(i).getLongitud();
//
//
//                }
//
//            }
//
//
//            System.out.println(est_int.get(i).getGrado_api());
//            System.out.println(est_int.get(i).getResistencia());
//            System.out.println(est_int.get(i).getLongitud());
//            System.out.println(est_int.get(i).getPeso());
//            System.out.println(est_int.get(i).getTope());
//            System.out.println(est_int.get(i).getFondo());
//
//
//        }

        Collections.reverse(est_int);
        for (int i = 0; i < est_int.size(); i++) {
            System.out.println("Seccion: " + i);
            System.out.println(est_int.get(i).getGrado_api());
            System.out.println(est_int.get(i).getResistencia());
            System.out.println(est_int.get(i).getLongitud());
            System.out.println(est_int.get(i).getPeso());

        }

        return est_int;


    }

    public ArrayList Colapso_pro() throws SQLException {

        secs3.removeAll(secs3);
        ArrayList<String> pesos = new ArrayList<String>();
        ArrayList<String> grados = new ArrayList<String>();
        ArrayList<String> resistencias = new ArrayList<String>();

        float ph = (gform * h) + 400;
        float pc = 0;
        float dens_acero = (float) 65.4;
        float p_neutro = (float) (ph / (0.052 * h));
        int p_ant = 0;
        int l_ant = 0;
        float hp_neutro = (1 - (densidad_zapata / dens_acero)) * h;
        System.out.println("sadjaskjdsadhsakdh" + ph);
        pdc = ph * fsc;
        //gform = (float) 0.64;
        ResultSet r = conecceon.ExecQuery(consulta);
        String c = "(select * from caracteristicas where  resistencia_colapso < " + pdc + " and id_diametro = " + diametro + " and  grado_api =";
        String c2 = "union (select * from caracteristicas where resistencia_colapso > " + pdc + " and id_diametro = " + diametro + " and grado_api in (";
        while (r.next()) {

            if (!r.isLast()) {

                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + " ) union (select * from caracteristicas where resistencia_colapso < " + pdc + " and id_diametro = " + diametro + " and  grado_api =";

            } else {

                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + " ) ";

            }


        }

        r.beforeFirst();

        while (r.next()) {

            if (!r.isLast()) {

                c2 = c2 + "'" + r.getString("grado_api") + "'" + ",";

            } else {

                c2 = c2 + "'" + r.getString("grado_api") + "'" + " ) limit 1 )";

            }


        }

        System.out.println("akaka" + c + c2 + "order by peso_nominal,grado_api ");
        ResultSet resul = conecceon.ExecQuery(c + c2 + "order by peso_nominal,grado_api ");

        System.out.println("sadjaskjdsadhsakdh" + c);
        while (resul.next()) {

            System.out.println("sdss");
            System.out.println(resul.getInt("peso_nominal"));
            System.out.println(resul.getString("grado_api"));
            System.out.println(resul.getString("resistencia_colapso"));

        }

        int hactual = (int) h;

        secc_cont = 0;
        int j = 0;
        float hcalc = 0;

        resul.last();
//        
//
//        resul = conecceon.ExecQuery(consulta);
//        resul.last();
        int pto_cedente = 0;

        secs3.add(new Seccion(long_minima_sec, resul.getInt(6), resul.getString(1), resul.getFloat(3), resul.getFloat(4), (int) h, (int) (h - long_minima_sec)));
        secc_cont++;
        System.out.println(secs3.get(0).getGrado_api() + "----------------------" + secs3.get(0).getPeso());
        System.out.println(pdc + " sajdhksajhdjsa ______-----------------_-_-_____-" + resul.getString("grado_api") + " " + resul.getInt("peso_nominal"));
        l_ant = long_minima_sec;
        p_ant = resul.getInt(3);

        //hactual = hactual - l_ant;
        //resul.previous();

        while (resul.previous()) {

            pesos.add(Integer.toString(resul.getInt("peso_nominal")));
            grados.add(resul.getString("grado_api"));
            resistencias.add(resul.getString("resistencia_colapso"));
            System.out.println(resistencias.get(0));


        }
        int rcn = Integer.parseInt(resistencias.get(0));
        resul.last();
        resul.previous();
        System.out.println(hp_neutro + " sajdhksajhdjsa");
        float part = 0;


        System.out.println("************////**********Este es colapso 2*****************------------////////*****/*/*/*/*" + pdc);

        do {

            System.out.println("jota" + j);
            String peson = resul.getString(3);
            String gapi = resul.getString(1);

            if (j + 1 < secs2.size()) {
                rcn = Integer.parseInt(resistencias.get(j));
                pto_cedente = secs2.get(j + 1).getPcedente();
                System.out.println("sajdhksajhdjsa ==================================================" + resistencias.get(j));
            }


            boolean cond = true;
            float gc = pdc / h;

            float hsup = rcn / gc;
            System.out.println("achesu puesto =======D " + h);
            float hant;
            System.out.println("hsupp " + rcn);
            float L = hactual - hsup;

            if (hactual - hsup < long_minima_sec) {
                System.out.println("hactual: " + hactual);
                System.out.println("hsup: " + hsup);
                hsup = hactual - long_minima_sec;
                System.out.println("cambio: " + hsup);
            }
            System.out.println("gg " + hsup);
            part = (hp_neutro - hsup) * Integer.parseInt(pesos.get(j));
            System.out.println("__________--------" + part);
            while (cond) {
                //resul.last();
                //System.out.println(resul.getRow());

                //System.out.println(resul.getInt(1));
//                System.out.println("pedece=" + pdc);
//                System.out.println("gc= " + gc);

                if (L < long_minima_sec) {

                    L = long_minima_sec;

                } else {
                    L = hactual - hsup;
                }

                //System.out.println("hsup= " + hsup);
                //System.out.println("L= " + L);

                float area_plana = Float.parseFloat(resul.getString(5));
                float peso_n = (float) resul.getInt(3);

                if (hsup < hp_neutro) {

                    l_ant = hactual;

                    System.out.println(" este e el ache actual = " + hsup);
                    float r1 = (part / (area_plana * resul.getInt("pto_cedente")));
                    System.out.println(" este e el sssdasd = " + r1);
                    //System.out.println("fjsdbfhfsdgfjsdfjsdfxfjdkjfhgsdijgfdjsfgdusfgdasufgsduyfgdsufgdsufy " + area_plana);
                    ResultSet resul2 = conecceon.ExecQuery("(SELECT * FROM  tabla_colapso WHERE erre > '" + r1 + "' LIMIT 1 ) UNION ( SELECT * FROM  tabla_colapso WHERE erre < '" + r1 + "'  ORDER BY erre DESC LIMIT 1)");
                    resul2.next();

                    float y0 = Float.parseFloat(resul2.getString(2));
                    float x0 = Float.parseFloat(resul2.getString(1));

                    resul2.next();
                    float y1 = Float.parseFloat(resul2.getString(2));
                    float x1 = Float.parseFloat(resul2.getString(1));

                    float r2 = (float) (y0 + ((y1 - y0) / (x1 - x0)) * (r1 - x0));
                    //System.out.println("r2 " + r2);
                    hant = hcalc;
                    hcalc = (rcn * r2) / (100 * gc);


                } else {
                    p_ant = (int) peso_n;
                    hactual = hactual - long_minima_sec;
                    hcalc = hactual;

                }
                //System.out.println("hsup" + hsup);
                if (j + 1 < secs2.size()) {

                    if (buscar(secs2.get(j + 1)) != null && hcalc < buscar(secs2.get(j + 1)).getLongitud()) {


                        Seccion nvo = new Seccion(L, rcn, gapi, Float.parseFloat(peson), pto_cedente, area_plana);

                        //System.out.println(" " + nvo.getPeso());
                        nvo.setFondo((int) hactual);
                        nvo.setTope((int) buscar(nvo).getLongitud());
                        hactual = (int) nvo.getTope();
                        nvo.setLongitud(hactual - nvo.getTope());
                        secs3.add(nvo);
                        System.out.println("termdsadsadsadsadadsa" + nvo.getFondo() + " " + nvo.getTope());
                        for (int k = 0; k < secs2.size(); k++) {

                            Seccion aux = buscar(secs2.get(k));

                            if (aux != null && aux.getLongitud() < hactual) {

                                secs3.add(secs2.get(k));

                                break;

                            }

                        }


                        break;


                    }
                }

                if ((hsup - hcalc) < 30) {

                    cond = false;
                    hsup = hcalc;
                    secc_cont++;
                    Seccion nvo = new Seccion(L, rcn, gapi, Float.parseFloat(peson), area_plana, (int) (secs3.get(secs3.size() - 1).getFondo()), (int) (secs3.get(secs3.size() - 1).getFondo() - L));
                    //hactual = (int) nvo.getFondo();

                    if (secc_cont >= secciones) {

                        nvo.setFondo(40);
                        nvo.setLongitud(secs3.get(secs3.size() - 1).getTope() - secs3.get(secs3.size() - 1).getFondo());

                    }

                    System.out.println("grado= " + nvo.getGrado_api());

                    System.out.println("Peso= " + nvo.getPeso());
                    System.out.println("TOPE= " + nvo.getTope());
                    System.out.println("TOPE= " + nvo.getFondo());
                    System.out.println("hactual = " + hactual + " " + "hcalc = " + hcalc);

                    System.out.println("L= " + L);

                    if (buscar3(nvo) != null) {
                        System.out.println("*-*****************-***********" + nvo.getFondo() + " " + buscar3(nvo).getLongitud());
                    }

                    if (buscar3(nvo) != null && nvo.getFondo() < buscar3(nvo).getLongitud()) {

                        System.out.println("*-*****************-***********");
                        //System.out.println(secs3.get(i).getGrado_api() + "falla" + secs3.get(i).getFondo() + " - " + buscar3(secs3.get(i)).getLongitud());
                        ArrayList<Seccion> aux = est_int;
                        Collections.reverse(aux);

                        for (int k = 0; k < est_int.size(); k++) {


                            if (nvo.getFondo() > aux.get(k).getLongitud()) {
                                System.out.println("we" + nvo.getFondo() + " " + aux.get(k).getLongitud() + " " + aux.get(k).getGrado_api());
                                nvo.setGrado_api(aux.get(k).getGrado_api());
                                nvo.setPeso(aux.get(k).getPeso());
                                break;

                            }

                        }



                    }
                    secs3.add(nvo);




                    System.out.println("secciones = " + secc_cont);

                }

                hsup = hcalc;


            }

            hactual = (int) hsup;
            System.out.println("sin cambio = " + hactual);



            if (!resul.isFirst()) {
                resul.previous();
            } else {

                hactual = hactual - hactual;

            }

            j++;

            if (resistencias.size() > j) {
                rcn = Integer.parseInt(resistencias.get(j));
            }

        } while (hactual > 0 && secc_cont <= secciones);

        if (hactual > 0) {

            Collections.reverse(est_int);
            System.out.println("sdff ----------------------------------------------------------------------- " + hactual);


            if (buscar(secs3.get(secs3.size() - 1)) != null && buscar(secs3.get(secs3.size() - 1)).getLongitud() > 0) {

                System.out.println("sdffg " + hactual);
                for (int l = 0; l < est_int.size(); l++) {

                    Seccion aux = buscar(est_int.get(l));

                    if (aux != null && aux.getLongitud() < hactual) {

                        secs3.add(est_int.get(l));

                        break;

                    }

                }

            } else {

                System.out.println("sdff ------------------------------------------------------------------" + hactual);

                secs3.get(secs3.size() - 1).setFondo((int) secs3.get(secs3.size() - 2).getLongitud());
                secs3.get(secs3.size() - 1).setTope(0);

                secs3.get(secs3.size() - 1).setLongitud(h - secs3.get(secs3.size() - 1).getFondo());


            }

        }

//        secs3.get(secs3.size() - 1).setFondo(40);
//        secs3.get(secs3.size() - 1).setLongitud(secs3.get(secs3.size() - 1).getTope() - secs3.get(secs3.size() - 1).getFondo());


        for (int i = 0; i < secs3.size(); i++) {
//            
//            System.out.println("Seccion: " + (i + 1));
//            
//            if (i == 0) {
//                
//                secs3.get(i).setFondo((int) prof_zapata);
//                
//            } else {
//                
//                if (i == secs3.size()) {
//                    
//                    secs3.get(i).setFondo((int) secs3.get(i).getLongitud());
//                    
//                    
//                } else {
//                    
//                    
//                    secs3.get(i).setFondo((int) secs3.get(i - 1).getFondo() - (int) secs3.get(i - 1).getLongitud());
//                    
//                    
//                }
//                
//            }


            if (i > 0 && secs3.get(i).getPeso() == secs3.get(i - 1).getPeso() && secs3.get(i).getGrado_api().equals(secs3.get(i - 1).getGrado_api())) {

                Seccion nvo = new Seccion(secs3.get(i - 1).getTope() - secs3.get(i).getFondo(), rcn, secs3.get(i).getGrado_api(), secs3.get(i).getPeso(), secs3.get(i).getAreap(), (int) (secs3.get(i - 1).getTope()), (int) (secs3.get(i).getFondo()));
                System.out.println("-------------------------------///////////******-/*/-*/-*/" + secs3.remove(secs3.get(i)));
                System.out.println("-------------------------------///////////******-/*/-*/-*/" + secs3.remove(secs3.get(i - 1)));
                secs3.add(i - 1, nvo);


                //secs3.get(i-1).setFondo(nvo.getFondo());





            }

//            System.out.println("sec" + (i + 1));
//            System.out.println(secs3.get(i).getGrado_api());
//            System.out.println(secs3.get(i).getLongitud());
//            System.out.println(secs3.get(i).getTope());
//            System.out.println("prof = " + secs3.get(i).getFondo());
//
//            System.out.println(secs3.get(i).getPeso());


        }


//        for (int i = 0; i < secs3.size(); i++) {
//
//            if (buscar3(secs3.get(i)) != null && secs3.get(i).getFondo() < buscar3(secs3.get(i)).getLongitud()) {
//
//                System.out.println(secs3.get(i).getGrado_api() + "falla" + secs3.get(i).getFondo() + " - " + buscar3(secs3.get(i)).getLongitud());
//                ArrayList<Seccion> aux = est_int;
//                Collections.reverse(aux);
//
//                for (int k = 0; k < secs3.size(); k++) {
//
//
//                    if (secs3.get(i).getFondo() > aux.get(k).getLongitud()) {
//                        System.out.println("we" + secs3.get(i).getFondo() + " " + aux.get(k).getLongitud() + " " + aux.get(k).getGrado_api());
//                        secs3.get(i).setGrado_api(aux.get(k).getGrado_api());
//                        secs3.get(i).setPeso(aux.get(k).getPeso());
//                        break;
//
//                    }
//
//                }
//
//
//
//            }
//
//        }

        ArrayList<Seccion> aux3 = secs3;
        ArrayList<Seccion> aux2 = secs3;

        Collections.sort(secs3, new Comparator<Seccion>() {

            @Override
            public int compare(Seccion p1, Seccion p2) {
                return (int) (p1.getPeso() + p2.getPeso());
            }
        });


        Collections.reverse(aux2);
        aux3.add(0, new Seccion(40, aux2.get(aux2.size() - 1).getResistencia(), aux2.get(aux2.size() - 1).getGrado_api(), aux2.get(aux2.size() - 1).getPeso(), aux2.get(aux2.size() - 1).getAreap(), 40, 0));
        //Collections.reverse(aux2);
        return aux3;

    }

    private Seccion buscar(Seccion elem) {

        for (int i = 0; i < secs.size(); i++) {

            if (secs.get(i).getGrado_api().equals(elem.getGrado_api()) && secs.get(i).getPeso() == elem.getPeso()) {
                return secs.get(i);

            }

        }

        return null;

    }

    private Seccion buscar2(Seccion elem) {

        for (int i = 0; i < secs3.size(); i++) {

            if (secs3.get(i).getGrado_api().equals(elem.getGrado_api()) && secs3.get(i).getPeso() == elem.getPeso()) {
                return secs3.get(i);

            }

        }

        return null;

    }

    private Seccion buscar3(Seccion elem) {

        for (int i = 0; i < est_int.size(); i++) {

            if (est_int.get(i).getGrado_api().equals(elem.getGrado_api()) && est_int.get(i).getPeso() == elem.getPeso()) {
                return est_int.get(i);

            }

        }

        return null;

    }

    public float getGg() {
        return Gg;
    }

    public void setGg(float Gg) {
        this.Gg = Gg;
    }

    public float getDensidad_lodo() {
        return densidad_lodo;
    }

    public void setDensidad_lodo(float densidad_lodo) {
        this.densidad_lodo = densidad_lodo;
    }

    public float getFsc() {
        return fsc;
    }

    public void setFsc(float fsc) {
        this.fsc = fsc;
    }

    public float getFse() {
        return fse;
    }

    public void setFse(float fse) {
        this.fse = fse;
    }

    public float getGform() {
        return gform;
    }

    public void setGform(float gform) {
        this.gform = gform;
    }

    public float getGfr() {
        return gfr;
    }

    public void setGfr(float gfr) {
        this.gfr = gfr;
    }

    public float getGint() {
        return gint;
    }

    public void setGint(float gint) {
        this.gint = gint;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getLong_minima_sec() {
        return long_minima_sec;
    }

    public int getIndex() {
        return index;
    }

    public void setLong_minima_sec(int long_minima_sec) {
        this.long_minima_sec = long_minima_sec;
    }

    public int getSecciones() {
        return secciones;
    }

    public void setSecciones(int secciones) {
        this.secciones = secciones;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public void setDensidad_lodo_fondo(float densidad_lodo_fondo) {
        this.densidad_lodo_fondo = densidad_lodo_fondo;
    }

    public void setDif_pres(float dif_pres) {
        this.dif_pres = dif_pres;
    }

    public void setDensidad_zapata(float densidad_zapata) {
        this.densidad_zapata = densidad_zapata;
    }

    public void setFs_tension1(float fs_tension1) {
        this.fs_tension1 = fs_tension1;
    }

    public void setFs_tension2(float fs_tension2) {
        this.fs_tension2 = fs_tension2;
    }

    public float getFs_tension1() {
        return fs_tension1;
    }

    public float getFs_tension2() {
        return fs_tension2;
    }

    public float getFsgfrac() {
        return fsgfrac;
    }

    public void setFsgfrac(float fsgfrac) {
        this.fsgfrac = fsgfrac;
    }

    public float getDif_pres() {
        return dif_pres;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    private boolean buscatubo(String nue) {

        for (int j = 0; j < tubos.size(); j++) {

            if (nue.equals(tubos.get(j))) {
                return true;
            }
        }

        return false;

    }

    private void lleanArr() throws SQLException {

        ResultSet r = conecceon.ExecQuery(consulta);

        while (r.next()) {

            String au = r.getString("grado_api");

            if (tubos.isEmpty()) {
                tubos.add(au);
            } else if (!buscatubo(au)) {

                tubos.add(au);
            }
        }
    }
}
