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
public class Superficial {

    private int index = 1;
    private ArrayList<String> tubos = new ArrayList<String>();
    ArrayList<Object> record = new ArrayList<Object>();
    private conexion conecceon;
    private String consulta = "";
    private ArrayList<Seccion> secs = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs2 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs3 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs4 = new ArrayList<Seccion>();
    private ArrayList<Seccion> est_int = new ArrayList<Seccion>();
    private int diametro;
    private int h = 4000, secciones = 4, long_minima_sec = 1500, secc_cont = 0;
    private int pids2 = 0, pids3 = 0;
    private float gfr = (float) 15.9, Gg = (float) 0.1, densidad_lodo = (float) 9.3, fse = (float) 1.1, fsc = (float) 1.1, gform = (float) 0.64, piny, pids, pext, pidz, gint, h_actual = h, pdc, densidad_lodo_fondo, densidad_zapata, fs_tension1, fs_tension2, fs_grad_frac;

    public Superficial(conexion con) {

        //ResultSet datos = coneccion.ExecQuery("Select * FROM caracteristicas");
        conecceon = con;
    }

    public float Piny() {

        piny = (float) 0.052 * (gfr * h);
        return piny;

    }

    public float Pids() {

        pids = (float) (2995 - Gg * h) * fse;
        System.out.println("piny ====>" + piny);
        System.out.println("Gg ====>" + Gg);
        System.out.println("h ====>" + h);
        System.out.println("fse ====>" + fse);
        return pids;


    }

    public float Pids2(int hz, double dens_hz) {

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

        pids3 = (int) (((gform * 12000) - (Gg * 12000)) * fse);
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
        pidz = (float) (piny - pext) * fse;
        return pidz;
    }

    public float Gint() {

        gint = (float) ((pids - pidz) / h);
        return gint;

    }

    public float Gint2() {

        gint = (float) ((pids2 - pidz) / 15000);
        return gint;

    }

    public float Gint3() {
        System.out.println("Pesdddsdsado = " + gint);
        gint = (float) ((pids3 - 0) / 12000);

        return gint;

    }

    public int getIndex() {
        return index;
    }

    public void Estallido() throws SQLException {

        secs.removeAll(secs);
        Piny();
        Pids();
        Pext();
        Pidz();
        Gint();
        lleanArr();
        lleanArr();
        String c = "select * from caracteristicas where estallido_stc < '" + (int) pids + "' and id_diametro = " + diametro + " and  grado_api IN (";

        for (int i = 0; i < tubos.size(); i++) {

            if (i != tubos.size() - 1) {

                c = c + "'" + tubos.get(i) + "',";

            } else {

                c = c + "'" + tubos.get(i) + "');";

            }


        }
        String c2 = "select * from caracteristicas where estallido_stc > '" + (int) pids + "' and id_diametro = " + diametro + " and  grado_api IN (";

        for (int i = 0; i < tubos.size(); i++) {

            if (i != tubos.size() - 1) {

                c2 = c2 + "'" + tubos.get(i) + "',";

            } else {

                c2 = c2 + "'" + tubos.get(i) + "');";

            }


        }

        System.out.println(c);
        System.out.println(c2);
        ResultSet res = conecceon.ExecQuery(c);
        ResultSet res2 = conecceon.ExecQuery(c2);
        res.last();
        //res.previous();
        ArrayList<Seccion> aux = new ArrayList<Seccion>();

        while (h_actual > 0 && secc_cont <= secciones) {


            int res_actual = res.getInt(7);
            String gapi = res.getString(1);
            String peson = res.getString(3);
            System.out.println();
            System.out.println("Peso = " + c);
            System.out.println("resistencia = " + res.getString(7));

            float long_sec = 0;

            long_sec = ((pids - res_actual) / gint);

            System.out.println("h = " + long_sec);
            //System.out.println(secs.size());
            int t = (int) h_actual;
            h_actual = (h_actual - long_sec);
            aux.add(new Seccion(long_sec, res.getInt(7), gapi, Float.parseFloat(peson), (int) t, (int) h_actual));
            System.out.println("dd" + h_actual);

            System.out.println("hact = " + h_actual);

            secc_cont++;
            System.out.println(secc_cont);

            if (!res.isFirst()) {
                res.previous();

            }


        }

        secs = aux;
        res.last();

        h_actual = h;
//        for (int i = 0; i < aux.size(); i++) {
//
//            if (i == 0) {
//
//
//                String gapi = res.getString(1);
//                String peson = res.getString(3);
//                secs.add(new Seccion(0, res.getInt(7), gapi, Float.parseFloat(peson), 0, (int) aux.get(i).getLongitud()));
//                h_actual = h_actual - secs.get(i).getLongitud();
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
//                    //h_actual = h_actual - secs.get(i).getLongitud();
//
//                    secs.add(new Seccion(aux.get(i - 1).getLongitud(), res.getInt(7), gapi, Float.parseFloat(peson), secs.get(i - 1).getFondo(), h));
//
//                } else {
//
//                    secs.add(new Seccion(aux.get(i - 1).getLongitud(), res.getInt(7), gapi, Float.parseFloat(peson), secs.get(i - 1).getFondo(), (int) aux.get(i).getLongitud()));
//                    h_actual = h_actual - secs.get(i).getLongitud();
//
//                }
//
//            }
//
//
//        }
        est_int = secs;
        while (res2.next()) {

            String gapi = res2.getString(1);
            String peson = res2.getString(3);
            est_int.add(new Seccion(0, res2.getInt(7), gapi, Float.parseFloat(peson), 0, 0));


        }


        for (int i = 0; i < secs.size(); i++) {
            System.out.println("Seccion: " + i);
            System.out.println(secs.get(i).getGrado_api());
            System.out.println(secs.get(i).getResistencia());
            System.out.println(secs.get(i).getLongitud());
            System.out.println(secs.get(i).getPeso());

        }


    }

    public ArrayList Colapso() throws SQLException {

        secs2.removeAll(secs2);
        pdc = (float) (0.052 * densidad_lodo * h * fsc);
        int q = 0;
        int hactual = (int) h_actual;
        secc_cont = 0;
        String c = "(select * from caracteristicas where resistencia_colapso < '" + (int) pdc + "' and id_diametro = " + diametro + "  and grado_api != '" + "K-55" + "') UNION ALL (select * from caracteristicas where resistencia_colapso > '" + (int) pdc + "' and id_diametro = " + diametro + "  and grado_api != '" + "K-55" + "' LIMIT 1 ) ";
        System.out.println(c);
        ResultSet resul = conecceon.ExecQuery(c);

        resul.last();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaeeeeee " + resul.getString(1));
        boolean vacio = false;
        int rcn = 0;
        int d = 0;
        int pto_cedente = 0;
        String peson = "";
        String gapi = "";
        float area_plana = 0;
        float peso_n = 0;
        int peso_arriba = 0;
        int long_arriba = 0;
        boolean rompio = false;


        secs2.add(new Seccion(long_minima_sec, resul.getInt(6), resul.getString(1), (float) resul.getInt(3), pto_cedente, Float.parseFloat(resul.getString(5))));
        secs2.get(0).setTope(h);
        secs2.get(0).setFondo(h - long_minima_sec);
        secc_cont++;
        long_arriba = long_minima_sec;
        peso_arriba = resul.getInt(3);

        hactual = hactual - long_arriba;

        if (!resul.isFirst()) {
            System.out.println("ffffffff " + pdc);
            resul.previous();
        }


        do {

            System.out.println(" ass " + hactual);
            rompio = false;
            if (!vacio) {
                peson = resul.getString(3);
                gapi = resul.getString(1);
                rcn = resul.getInt(6);
                pto_cedente = resul.getInt(16);
                area_plana = Float.parseFloat(resul.getString(5));
                peso_n = (float) resul.getInt(3);
            }

            boolean cond = true;

            float gc = pdc / h;

            float hsup = rcn / gc;
            float L = hactual - hsup;

            if (hactual - hsup < long_minima_sec) {
                //System.out.println("hactual: "+hactual);
                //System.out.println("hsup: "+hsup);
                hsup = hactual - long_minima_sec;
                //System.out.println("cambio: "+hsup);
            }

            while (cond) {

                System.out.println("webo " + q++);
                //resul.last();
                //System.out.println(resul.getRow());

                //System.out.println("ww "+resul.getString(1));
//                System.out.println("pedece=" + pdc);
//                System.out.println("gc= " + gc);


                float hcalc;


                if (L < long_minima_sec) {

                    L = long_minima_sec;

                } else {
                    L = hactual - hsup;
                }

                //System.out.println("hsup= " + hsup);
                //System.out.println("L= " + L);
                float r1 = 0;

                if (d == 0) {

                    r1 = ((L * peso_n)) / (area_plana * pto_cedente);

                    System.out.println("esteee es R = " + L + " " + peso_n);
                    peso_arriba = (int) peso_n;
                    long_arriba = (int) L;
                    System.out.println("esteee es R = " + long_arriba + " " + peso_arriba);

                } else {
                    System.out.println("esteee es R = " + long_arriba + " " + peso_arriba);
                    r1 = ((long_arriba * peso_arriba) + (L * peso_arriba)) / (area_plana * pto_cedente);
                    System.out.println("wwww else esteee es R = " + long_arriba + " " + peso_arriba);
                    System.out.println("no if esteee es R = " + L + " " + peso_n);
                    peso_arriba = (int) peso_n;
                    long_arriba = (int) L;


                }

                ResultSet resul2 = conecceon.ExecQuery("(SELECT * FROM  tabla_colapso WHERE erre > '" + r1 + "' LIMIT 1 ) UNION ( SELECT * FROM  tabla_colapso WHERE erre < '" + r1 + "'  ORDER BY erre DESC LIMIT 1)");
                System.out.println("columnas = " + r1);
                resul2.next();

                float y0 = Float.parseFloat(resul2.getString(2));
                float x0 = Float.parseFloat(resul2.getString(1));

                resul2.next();
                float y1 = Float.parseFloat(resul2.getString(2));
                float x1 = Float.parseFloat(resul2.getString(1));

                float r2 = (float) (y0 + ((y1 - y0) / (x1 - x0)) * (r1 - x0));
                hcalc = (rcn * r2) / (100 * gc);

                if (hcalc > h) {

                    System.out.print("break = " + hactual);
                    rompio = true;
                    break;
                }

                System.out.println(" ass " + hsup + "sdsd" + hcalc);

                if ((hsup - hcalc) < 30) {


                    System.out.println("hactual = " + hactual + " " + "hcalc = " + hcalc);
                    System.out.println("grado= " + gapi);
                    System.out.println("Peso= " + peson);
                    Seccion se = new Seccion(L, rcn, gapi, Float.parseFloat(peson), area_plana, (int) (secs2.get(secs2.size() - 1).getFondo()), (int) (secs2.get(secs2.size() - 1).getFondo() - L));
                    secs2.add(se);

                    secc_cont++;
                    System.out.println("21863t56821egywtge8yqgedqhdgj " + secc_cont);
                    cond = false;
                    hsup = hcalc;
                    break;

                }

                hsup = hcalc;

            }

            hactual = (int) hsup;
            System.out.println("sin cambio = " + hactual);


            if (!resul.isFirst()) {
                resul.previous();


            } else {


                vacio = true;
                hactual = hactual - hactual;
                System.out.println("vacio");

            }

            d++;

            System.out.println("huehue" + d);

        } while (hactual > 0 && secc_cont < secciones);


        secs2.get(secs2.size() - 1).setFondo(40);
        secs2.get(secs2.size() - 1).setLongitud(secs2.get(secs2.size() - 1).getTope() - secs2.get(secs2.size() - 1).getFondo());


//        for (int i = 0; i < secs2.size(); i++) {
//
//            for (int h = 0; h < est_int.size(); h++) {
//
//                Seccion aux = buscar(est_int.get(h));
//
//                if (aux != null && aux.getLongitud() < secs2.get(i).getTope()) {
//
//                    secs2.remove(i);
//                    secs2.add(h, aux);
//                   
//                }
//
//            }
//
//        }

        for (int i = 0; i < secs2.size(); i++) {

            if (buscar2(secs2.get(i)) != null && secs2.get(i).getTope() < buscar2(secs2.get(i)).getLongitud()) {

                System.out.println(secs2.get(i).getGrado_api() + "falla" + secs2.get(i).getTope() + " - " + buscar2(secs2.get(i)).getLongitud());

                for (int j = 0; j < secs2.size(); j++) {


                    if (secs2.get(j).getTope() < buscar2(secs2.get(i)).getLongitud()) {
                        System.out.println("wawaw");
                        secs2.get(i).setGrado_api(est_int.get(j).getGrado_api());
                        secs2.get(i).setPeso(est_int.get(j).getPeso());

                    }

                }



            }

        }

        int j = 0;

        while (j < secs2.size()) {


            if (j < secs2.size() && secs2.get(j).getPeso() == secs2.get(j + 1).getPeso()) {

                System.out.println("wawaw");
                secs2.add(new Seccion(40, secs2.get(j + 1).getResistencia(), secs2.get(j + 1).getGrado_api(), secs2.get(j + 1).getPeso(), secs2.get(j + 1).getAreap(), 40, 0));

            } else {


                break;
            }
            j++;
        }

        ArrayList<Seccion> aux3 = secs2;
        ArrayList<Seccion> aux2 = secs2;

        Collections.sort(secs2, new Comparator<Seccion>() {

            @Override
            public int compare(Seccion p1, Seccion p2) {
                return (int) (p1.getPeso() + p2.getPeso());
            }
        });


        Collections.reverse(aux2);
        aux3.add(0, new Seccion(40, aux2.get(aux2.size() - 1).getResistencia(), aux2.get(aux2.size() - 1).getGrado_api(), aux2.get(aux2.size() - 1).getPeso(), aux2.get(aux2.size() - 1).getAreap(), 40, 0));
        //Collections.reverse(aux2);


        for (int i = 0; i < secs2.size(); i++) {
            
            System.out.println(secs2.get(i).getGrado_api());
            System.out.println(secs2.get(i).getResistencia());
            System.out.println(secs2.get(i).getLongitud());
            System.out.println(secs2.get(i).getPeso());
            System.out.println(secs2.get(i).getTope());
            System.out.println(secs2.get(i).getFondo());

        }

        return aux3;


    }

    public void setDiam(int diam) {
        this.diametro = diam;
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

        for (int i = 0; i < est_int.size(); i++) {

            if (est_int.get(i).getGrado_api().equals(elem.getGrado_api()) && est_int.get(i).getPeso() == elem.getPeso()) {
                return est_int.get(i);

            }

        }

        return null;

    }

    public void tension(float dens, int dp) throws SQLException {

        ArrayList<Float> eles = new ArrayList<Float>();
        ArrayList<Float> pes = new ArrayList<Float>();
        ArrayList<Float> tes = new ArrayList<Float>();
        ArrayList<Float> tes2 = new ArrayList<Float>();
        secs4 = secs3;
        h = 12000;
        gform = (float) 0.64;

        if (dens == 0.0) {

            float ph = (gform * h) + dp;
            dens = (float) (ph / (0.052 * h));
            System.out.println("dsffdfds " + dens);
        }


        for (int i = 0; i < secs3.size(); i++) {

            eles.add(secs3.get(i).getLongitud() * secs3.get(i).getPeso());

            if (i == 0) {

                pes.add(-(float) (0.052 * densidad_lodo * secs3.get(i).getFondo() * secs3.get(i).getAreap()));


            } else {

                pes.add((float) (0.052 * densidad_lodo * secs3.get(i).getFondo() * (secs3.get(i - 1).getAreap() - secs3.get(i).getAreap())));

            }
            System.out.println("L" + (i + 1) + "W" + (i + 1) + " = " + eles.get(i));
            System.out.println("PH" + (i + 1) + "A" + (i + 1) + " = " + pes.get(i));

        }

        float ee = 100000;

        for (int j = 0; j < pes.size() + 1; j++) {

            if (j == 0) {

                tes.add(pes.get(j));
                //System.out.println("t"+(j+1)+"= "+tes.get(j));

            } else {

                if (j < pes.size()) {

                    float aa = (tes.get(tes.size() - 1) + eles.get(j - 1));
                    //System.out.println("t"+(j+1)+"= "+tes.get(tes.size()-1)+" "+eles.get(j-1));
                    tes.add(aa);
                    // System.out.println(aa);
                    //System.out.println("t"+(j+1)+"'= "+tes.get(j)+" "+pes.get(j));
                    aa = (tes.get(tes.size() - 1) + pes.get(j));
                    tes.add(aa);
                    //System.out.println(aa);
                } else {

                    float aa = (tes.get(tes.size() - 1) + eles.get(j - 1));
                    //System.out.println("t"+(j+1)+"= "+tes.get(tes.size()-1)+" "+eles.get(j-1));
                    tes.add(aa);


                }
            }

        }

        for (int j = 0; j < tes.size(); j++) {

            if (j == 0) {

                tes2.add(tes.get(j) + ee);

            } else {

                if (tes.get(j) + ee > tes.get(j) * 1.6) {

                    tes2.add(tes.get(j) + ee);

                } else {

                    tes2.add((float) (tes.get(j) * 1.6));

                }

            }

        }

        for (int j = 0; j < tes2.size(); j++) {

            System.out.println(tes2.get(j));

        }


        ResultSet res;

        //for (int i = 0; i < secs3.size(); i++) {

        res = conecceon.ExecQuery("SELECT tension_stc,tension_tuberia FROM caracteristicas WHERE grado_api ='" + secs3.get(secs3.size() - 1).getGrado_api() + "' AND peso_nominal = '" + secs3.get(secs3.size() - 1).getPeso() + "' AND id_diametro = 2");
        int tub = 0;
        int rosca = 0;

        try {

            res.next();

            rosca = res.getInt(1) * 1000;
            tub = res.getInt(2) * 1000;

        } catch (SQLException ex) {
            Logger.getLogger(Asd.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tes2.get(tes2.size() - 1) > tub) {

            ResultSet tubos = conecceon.ExecQuery("SELECT * FROM caracteristicas WHERE tension_tuberia*1000 > '" + tub + "' AND id_diametro = 2 LIMIT 1");
            tubos.next();
            float longitud = secs4.get(secs4.size() - 1).getLongitud();
            secs4.remove(secs4.remove(secs4.size() - 1));
            secs4.add(new Seccion(longitud, tubos.getInt(11), tubos.getString("grado_api"), tubos.getFloat("peso_nominal"), tubos.getInt("pto_cedente"), tubos.getFloat("area_plana")));


        } else {

            if (tes2.get(tes2.size() - 1) > rosca) {

                ResultSet roscas = conecceon.ExecQuery("SELECT tension_stc FROM caracteristicas WHERE tension_stc*1000 > '" + rosca + "' AND id_diametro = 2 LIMIT 1");

                if (roscas.getRow() == 0) {
                }


            }

        }


    }

    private void lleanArr() throws SQLException {

        ResultSet r = conecceon.ExecQuery(consulta);
        tubos.removeAll(tubos);
        while (r.next()) {

            String au = r.getString("grado_api");

            if (tubos.isEmpty()) {
                tubos.add(au);
            } else if (!buscatubo(au)) {

                tubos.add(au);
            }
        }
    }

    private boolean buscatubo(String nue) {

        for (int j = 0; j < tubos.size(); j++) {

            if (nue.equals(tubos.get(j))) {
                return true;
            }
        }

        return false;

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

    public void setFs_tension1(float fs_tension1) {
        this.fs_tension1 = fs_tension1;
    }

    public void setFs_tension2(float fs_tension2) {
        this.fs_tension2 = fs_tension2;
    }

    public void setFs_grad_frac(float fs_grad_frac) {
        this.fs_grad_frac = fs_grad_frac;
    }
}
