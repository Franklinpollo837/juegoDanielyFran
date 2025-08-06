/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Armas.armas;

/**
 *
 * @author frank
 */
// creamos los atributos de Personajes 
public abstract class Personaje {
    public String nombre;
    public  double vida;
    public armas arma;
    public String tipoRaza;
    public double vidamaxima;
    
    //personajes
    
    
// creamos el constructor
    public Personaje(String nombre, double vida, armas arma, String tipoRaza) {  
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.vidamaxima = vida;
        this.tipoRaza = tipoRaza;
    }
    public String getNombre() {
        return nombre;
    }

    public String getTipoRaza() {
        return tipoRaza;
    }

    public void setTipoRaza(String tipoRaza) {
        this.tipoRaza = tipoRaza;
    }

    public double getVidamaxima() {
        return vidamaxima;
    }

    public void setVidamaxima(double vidamaxima) {
        this.vidamaxima = vidamaxima;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public armas getArma() {
        return arma;
    }

    public void setArma(armas arma) {
        this.arma = arma;
    }

    public String getTipoRazo() {
        return tipoRaza;
    }

// creamos getter y setter
    public void setTipoRazo(String tipoRazo) {
        this.tipoRaza = tipoRazo;
    }

// toString

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + ", arma=" + arma + ", tipoRazo=" + tipoRaza+ '}';
    }
    public void recibirDanio(double cantidad) {
    this.vida -= cantidad;
    if (this.vida < 0) {
        this.vida = 0;
    }
    System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + vida);
}
   
    public abstract void atacar(Personaje objetivo); // metodo abstracto para ser heredado
    // se cambia despues en sus clases
    public abstract void curarse();
}
