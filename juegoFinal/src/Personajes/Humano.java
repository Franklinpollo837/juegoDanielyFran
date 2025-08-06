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
public class Humano extends Personaje {
    private int dannioAcumulado;

    public Humano(int dannioAcumulado, String nombre, double vida, armas arma, String tipoRaza) {
        super(nombre, vida, arma, tipoRaza);
        this.dannioAcumulado = dannioAcumulado;
    }

    @Override
    public void atacar(Personaje objetivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
  
}
