/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Armas.armas;

/**
 *
 * @author danir
 */
public class Orco extends Personaje {

    public Orco(String nombre, double vida, armas arma, String tipoRaza) {
        super(nombre, vida, arma, tipoRaza);
    }

    @Override
    //con este metodo creamos la manera de atacar del orco
    public void atacar(Personaje objetivo)  {
      int danio = arma.calcularDanio();
        System.out.println(nombre + " ataca con " + arma.getNombreArma() + " y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
    

    
    

    
}
