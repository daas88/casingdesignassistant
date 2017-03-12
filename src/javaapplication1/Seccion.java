/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author daniel
 */
public class Seccion {

    public int getPcedente() {
        return pcedente;
    }

    public void setPcedente(int pcedente) {
        this.pcedente = pcedente;
    }
    private float longitud;
    private int resistencia;
    private String grado_api;
    private float peso;
    private int tope;
    private int fondo;
    private int pcedente;
    private float areap;
    private int diametro;

    public String getRosca_tipo() {
        return rosca_tipo;
    }

    public void setRosca_tipo(String rosca_tipo) {
        this.rosca_tipo = rosca_tipo;
    }

    public int getRosca_valor() {
        return rosca_valor;
    }

    public void setRosca_valor(int rosca_valor) {
        this.rosca_valor = rosca_valor;
    }
    private String rosca_tipo;
    private int rosca_valor;

    public float getAreap() {
        return areap;
    }

    public void setAreap(float areap) {
        this.areap = areap;
    }

    public Seccion(float longitud, int resistencia, String grado_api, float pes, int pced, float area) {

        this.longitud = longitud;
        this.resistencia = resistencia;
        this.grado_api = grado_api;
        peso = pes;
        pcedente = pced;
        areap = area;
    }

    public Seccion(float longitud, int resistencia, String grado_api, float pes,float area, int top, int bot) {

        this.longitud = longitud;
        this.resistencia = resistencia;
        this.grado_api = grado_api;
        peso = pes;
        tope = top;
        fondo = bot;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getGrado_api() {
        return grado_api;
    }

    public void setGrado_api(String grado_api) {
        this.grado_api = grado_api;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    
    
}
