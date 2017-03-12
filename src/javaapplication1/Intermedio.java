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

/**
 *
 * @author daniel
 */
public class Intermedio {
    
    private int index = 2;
    ArrayList<Object> record = new ArrayList<Object>();
    private ArrayList<String> tubos = new ArrayList<String>();
    private ArrayList<Float> pesos = new ArrayList<Float>();
    private conexion conecceon;
    private int diametro;
    private String consulta = "";
    private ArrayList<Seccion> secs = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs2 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs3 = new ArrayList<Seccion>();
    private ArrayList<Seccion> secs4 = new ArrayList<Seccion>();
    private ArrayList<Seccion> est_int = new ArrayList<Seccion>();
    private int h = 4000, secciones = 4, long_minima_sec = 1500, secc_cont = 0;
    private float pids2 = 0, pids3 = 0;
    private float gfr = (float) 15.9, Gg = (float) 0.1, densidad_lodo = (float) 9.3, fse = (float) 1.1, fsc = (float) 1.1, gform = (float) 0.64, piny, pids, pext, pidz, gint, h_actual = h, pdc, densidad_lodo_fondo, densidad_zapata, fs_tension1, fs_tension2, fs_grad_frac, prof_zapata, dif_pres;
    
    public Intermedio(conexion con) {

//       ResultSet datos = coneccion.ExecQuery("Select * FROM caracteristicas");
        conecceon = con;
        
    }
    
    private void init() {
        
        Pids2();
        Piny();
        Pext2();
        Pidz();
        Gint2();
        
        
    }
    
    public float Piny() {
        
        piny = (float) 0.052 * (gfr * prof_zapata);
        return piny;
        
    }
    
    public float Pids() {
        
        pids = (float) (piny - Gg * h) * fse;
        return pids;
        
    }
    
    public float Pids2() {
        
        double pform = 0;
        double piny2 = 0.052 * gfr * prof_zapata;
        piny = (float) piny2;
        System.out.println("piny2 ====>" + piny2);
        float pis = 0;

//        if (gform != 0) {

        pform = ((0.052 * densidad_zapata * h) - 400);
        System.out.println("pform ====> " + pform);

//            pform = (int)(gform * h);
//            System.out.println("ssd ggf hgf gf h "+pform+"  "+gform);

//        } else {
//
//            
//        }
        System.out.println("jsahkdhgasgdsfahdgfashdgfasgdsa " + (piny2 - Gg * prof_zapata) + " " + (pform - Gg * prof_zapata));
        if ((float) (piny2 - Gg * prof_zapata) < (float) (pform - Gg * prof_zapata)) {
            
            
            pis = (float) (piny2 - 0.1 * prof_zapata);
            System.out.println("jsahkdhgasgdsfahdgfashdgfasgdsa " + pis);
            
            
            
        } else {
            
            pis = (float) (pform - Gg * prof_zapata);
            System.out.println("jsahkdhgasgdsfahdgfashdgfasg " + pis);
            
        }
        
        pids2 = (fse * pis);
        System.out.println("kokoko" + pids2);
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
        
        
        pext = (float) 0.052 * densidad_zapata * prof_zapata;
        
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
        
        
        gint = (float) ((pids2 - pidz) / prof_zapata);
        
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
    
   
    
    public void setDiam(int diam) {
        this.diametro = diam;
    }
     public ArrayList Colapso2() throws SQLException {
        
        secs3.removeAll(secs3);
        ArrayList<String> pesos = new ArrayList<String>();
        ArrayList<String> grados = new ArrayList<String>();
        ArrayList<String> resistencias = new ArrayList<String>();
        
        float ph = (gform * prof_zapata) + 400;
        float pc = 0;
        float dens_acero = (float) 65.4;
        float p_neutro = (float) (ph / (0.052 * prof_zapata));
        int p_ant = 0;
        int l_ant = 0;
        float hp_neutro = (1 - (densidad_zapata / dens_acero)) * prof_zapata;
        
        pdc = ph * fsc;
        //gform = (float) 0.64;
        ResultSet r = conecceon.ExecQuery(consulta);
        String c = "((select * from caracteristicas where  resistencia_colapso < " + pdc + " and id_diametro = " + diametro + " and  grado_api =";
        String c2 = "union (select * from caracteristicas where resistencia_colapso > " + pdc + " and id_diametro = " + diametro + " and grado_api in (";
        while (r.next()) {
            
            if (!r.isLast()) {
                
                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + " ) union (select * from caracteristicas where resistencia_colapso < " + pdc + " and id_diametro = " + diametro + " and  grado_api =";
                
            } else {
                
                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + ")order by pto_cedente,grado_api )";
                
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
        
        System.out.println("akaka" + c + c2 + "order by pto_cedente,grado_api ");
        ResultSet resul = conecceon.ExecQuery(c + c2 );
        resul.last();
        
        while (resul.next()) {
            
            System.out.println("sdss");
            System.out.println(resul.getInt("peso_nominal"));
            System.out.println(resul.getString("grado_api"));
            System.out.println(resul.getString("resistencia_colapso"));
            
        }
        
        int hactual = (int) prof_zapata;
        
        secc_cont = 0;
        int j = 0;
        float hcalc = 0;
        
        resul.previous();
//        
//
//        resul = conecceon.ExecQuery(consulta);
//        resul.last();
        int pto_cedente = 0;
        
        secs3.add(new Seccion(long_minima_sec, resul.getInt(6), resul.getString(1), resul.getFloat(3), resul.getFloat(4), (int) prof_zapata, (int) (prof_zapata - long_minima_sec)));
        secc_cont++;
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
            float gc = pdc / prof_zapata;
            
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
                        for (int h = 0; h < secs2.size(); h++) {
                            
                            Seccion aux = buscar(secs2.get(h));
                            
                            if (aux != null && aux.getLongitud() < hactual) {
                                
                                secs3.add(secs2.get(h));
                                
                                break;
                                
                            }
                            
                        }
                        
                        
                        break;
                        
                        
                    }
                }
                
                if ((hsup - hcalc) < 30) {
                    
                    cond = false;
                    hsup = hcalc;
                    
                    Seccion nvo = new Seccion(L, rcn, gapi, Float.parseFloat(peson), area_plana, (int) (secs3.get(secs3.size() - 1).getFondo()), (int) (secs3.get(secs3.size() - 1).getFondo() - L));
                    
                    System.out.println("grado= " + nvo.getGrado_api());
                    
                    System.out.println("Peso= " + nvo.getPeso());
                    System.out.println("TOPE= " + nvo.getTope());
                    System.out.println("TOPE= " + nvo.getFondo());
                    System.out.println("hactual = " + hactual + " " + "hcalc = " + hcalc);
                    
                    System.out.println("L= " + L);
                    
                    
                    
                    secs3.add(nvo);
                    secc_cont++;
                    
                    
                    
                    System.out.println("secciones = " + secciones +"  "+secc_cont);
                    
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
            
        } while (hactual < prof_zapata && secc_cont < secciones);
        
//        if (hactual > 0) {
//            
//            Collections.reverse(est_int);
//            System.out.println("sdff ----------------------------------------------------------------------- " + hactual);
//            
//            
//            if (buscar(secs3.get(secs3.size() - 1)) != null && buscar(secs3.get(secs3.size() - 1)).getLongitud() > 0) {
//                
//                System.out.println("sdffg " + hactual);
//                for (int l = 0; l < est_int.size(); l++) {
//                    
//                    Seccion aux = buscar(est_int.get(l));
//                    
//                    if (aux != null && aux.getLongitud() < hactual) {
//                        
//                        secs3.add(est_int.get(l));
//                        
//                        break;
//                        
//                    }
//                    
//                }
//                
//            } else {
//                
//                System.out.println("sdff ------------------------------------------------------------------" + hactual);
//                
//                secs3.get(secs3.size() - 1).setFondo((int) secs3.get(secs3.size() - 2).getLongitud());
//                secs3.get(secs3.size() - 1).setTope(0);
//                
//                secs3.get(secs3.size() - 1).setLongitud(h - secs3.get(secs3.size() - 1).getFondo());
//                
//                
//            }
//            
//        }
        
        secs3.get(secs3.size() - 1).setFondo(40);
        secs3.get(secs3.size() - 1).setLongitud(secs3.get(secs3.size() - 1).getTope() - secs3.get(secs3.size() - 1).getFondo());
        
        
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
            System.out.println("sec" + (i + 1));
            System.out.println(secs3.get(i).getGrado_api());
            System.out.println(secs3.get(i).getLongitud());
            System.out.println("prof = " + secs3.get(i).getFondo());
            System.out.println(secs3.get(i).getTope());
            System.out.println(secs3.get(i).getPeso());
            
            
        }
        
        
        for (int i = 0; i < secs3.size(); i++) {
            
            if (buscar3(secs3.get(i)) != null && secs3.get(i).getFondo() < buscar3(secs3.get(i)).getLongitud()) {
                
                System.out.println(secs3.get(i).getGrado_api() + "falla" + secs3.get(i).getFondo() + " - " + buscar3(secs3.get(i)).getLongitud());
                ArrayList<Seccion> aux = est_int;
                Collections.reverse(aux);
                
                for (int k = 0; k < secs3.size(); k++) {
                    
                    
                    if (secs3.get(i).getFondo() > aux.get(k).getLongitud()) {
                        System.out.println("we" + secs3.get(i).getFondo() + " " + aux.get(k).getLongitud() + " " + aux.get(k).getGrado_api());
                        secs3.get(i).setGrado_api(aux.get(k).getGrado_api());
                        secs3.get(i).setPeso(aux.get(k).getPeso());
                        break;
                        
                    }
                    
                }
                
                
                
            }
            
        }
        
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
    public void Estallido_Int() throws SQLException {
        
        est_int.removeAll(est_int);
        init();
        h_actual = h;
        lleanArr();
        lleanArr2();
        System.out.println("Pesdddsdsado = " + pids2);
        ResultSet r = conecceon.ExecQuery(consulta);
        //r.next();
        String c = "(select * from caracteristicas where estallido_ltc < " + Pids2() + " and id_diametro = " + diametro + " and  grado_api =";
        
        while (r.next()) {
            
            if (!r.isLast()) {
                
                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + " ) union (select * from caracteristicas where estallido_ltc < " + pids2 + " and id_diametro = " + diametro + " and  grado_api =";
                
            } else {
                
                c = c + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + ") order by peso_nominal,grado_api;";
                
            }
            
            
        }
        r.beforeFirst();
        
        String c2 = "(select * from caracteristicas where estallido_ltc > " + Pids2() + " and id_diametro = " + diametro + " and  grado_api =";
        
        while (r.next()) {
            
            if (!r.isLast()) {
                
                c2 = c2 + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + " ) union (select * from caracteristicas where estallido_ltc > " + pids2 + " and id_diametro = " + diametro + " and  grado_api =";
                
            } else {
                
                c2 = c2 + "'" + r.getString("grado_api") + "' and peso_nominal =  " + r.getString("peso_nominal") + ") order by peso_nominal,grado_api;";
                
            }
            
            
        }
        
        System.out.println("Pesdddsdsado = " + c2);
        //consulta = c;
        //c = "";
        ResultSet res = conecceon.ExecQuery(c);
        
        
        ResultSet res2 = conecceon.ExecQuery(c2);
        res.afterLast();

        //res.previous();
        ArrayList<Seccion> aux = new ArrayList<Seccion>();
        
        while (h_actual > 0 && secc_cont <= secciones && res.previous()) {
            
            
            int res_actual = res.getInt(8);
            String gapi = res.getString(1);
            String peson = res.getString(3);
            System.out.println(gapi);
            System.out.println("Peso = " + peson);
            System.out.println("resistencia = " + pids2);
            
            float long_sec = 0;
            
            long_sec = (float) ((pids2 - res_actual) / gint);
            
            System.out.println("h = " + pids2 + " " + res_actual);
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
        Collections.reverse(est_int);
        while (res2.next()) {
            
            String gapi = res2.getString(1);
            String peson = res2.getString(3);
            est_int.add(new Seccion(0, res2.getInt(7), gapi, Float.parseFloat(peson), 0, 0));
            
            
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
    
    public void setProf_zapata(float prof_zapata) {
        this.prof_zapata = prof_zapata;
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
    
    public void setDensidad_zapata(float densidad_zapata) {
        this.densidad_zapata = densidad_zapata;
    }
    
    public void setFs_tension1(float fs_tension1) {
        this.fs_tension1 = fs_tension1;
    }
    
    public void setFs_tension2(float fs_tension2) {
        this.fs_tension2 = fs_tension2;
    }
    
    public void setDif_pres(float dif_pres) {
        this.dif_pres = dif_pres;
    }
    
    public void setFs_grad_frac(float fs_grad_frac) {
        this.fs_grad_frac = fs_grad_frac;
    }
    
    private boolean buscatubo(String nue) {
        
        for (int j = 0; j < tubos.size(); j++) {
            
            if (nue.equals(tubos.get(j))) {
                return true;
            }
        }
        
        return false;
        
    }
    
    private boolean buscatubo2(Float nue) {
        
        for (int j = 0; j < pesos.size(); j++) {
            
            if (nue.equals(pesos.get(j))) {
                return true;
            }
        }
        
        return false;
        
    }
    
    private void lleanArr2() throws SQLException {
        
        ResultSet r = conecceon.ExecQuery(consulta);
        pesos.removeAll(pesos);
        while (r.next()) {
            
            float au = r.getFloat("peso_nominal");
            
            if (pesos.isEmpty()) {
                pesos.add(au);
            } else if (!buscatubo2(au)) {
                
                pesos.add(au);
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
}
