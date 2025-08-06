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
    public String tipoRazo;
    
// creamos el constructor
    public Personaje(String nombre, double vida) {
        this.nombre = nombre;
        this.vida = vida;
    }
// creamos getter y setter
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
// toString 
    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + '}';
    }
    
    
    
}
