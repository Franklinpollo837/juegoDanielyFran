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
    private boolean curacionPendiente = false;
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

    @Override
    public void curarse() {
      double cantidadCurada = vidamaxima * 0.25;
        vida += cantidadCurada;
        if (vida > vidamaxima) {
            vida = vidamaxima;
        }
        curacionPendiente = true;
        System.out.println(nombre + " usa una pócima y se cura " + cantidadCurada + ". Vida actual: " + vida);
    }
    
    public void sanarTurnoSiguiente() {
        if (curacionPendiente) {
            double cantidadCurada = vidamaxima * 0.15;
            vida += cantidadCurada;
            if (vida > vidamaxima) {
                vida = vidamaxima;
            }
            curacionPendiente = false;
            System.out.println(nombre + " recibe sanación adicional de " + cantidadCurada + ". Vida actual: " + vida);
        }
    }

    
    

    
}
