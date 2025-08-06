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
public class Personaje {
    public String nombre;
    public  double vida;
    public armas arma;
    public String tipoRaza;
    
    
// creamos el constructor
    public Personaje(String nombre, double vida, armas arma, String tipoRazo) {  
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.tipoRaza = tipoRazo;
    }
    public String getNombre() {
        return nombre;
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
   
    
    
}
