/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

/**
 *
 * @author frank
 */
public class armas {
    public String nombreArma;
    public String tipoArma;
    public int dannioMinimo;
    public int dannioMaximo;
    public boolean causaSangrado = false;

    public armas(String nombreArma, String tipoArma, int dannioMinimo, int dannioMaximo) {
        this.nombreArma = nombreArma;
        this.tipoArma = tipoArma;
        this.dannioMinimo = dannioMinimo;
        this.dannioMaximo = dannioMaximo;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public int getDannioMinimo() {
        return dannioMinimo;
    }

    public void setDannioMinimo(int dannioMinimo) {
        this.dannioMinimo = dannioMinimo;
    }

    public int getDannioMaximo() {
        return dannioMaximo;
    }

    public void setDannioMaximo(int dannioMaximo) {
        this.dannioMaximo = dannioMaximo;
    }
    public int calcularDanio() {
        return (int) (Math.random() * (dannioMaximo - dannioMinimo + 1)) + dannioMinimo;
    }

    @Override
    public String toString() {
        return "armas{" + "nombreArma=" + nombreArma + ", tipoArma=" + tipoArma + ", dannioMinimo=" + dannioMinimo + ", dannioMaximo=" + dannioMaximo + '}';
    }

    public boolean tieneSangrado() {
    return causaSangrado;
}
    
    
    
}
