/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Armas.Hacha;
import Armas.armas;
import java.util.Random;

/**
 *
 * @author danir
 */
public class Orco extends Personaje {
     private int dannioAcumulado;
    private boolean tieneCuraPendiente;
    private Random random = new Random();

    
     public Orco(String nombre, armas arma) {
        super(nombre, 100, arma, "Orco");
        this.dannioAcumulado = 0;
        this.tieneCuraPendiente = false;
    }

    @Override
    //con este metodo creamos la manera de atacar del orco
    public void atacar(Personaje objetivo)  {
        int danio = arma.calcularDanio();
        objetivo.recibirDanio(danio);
        
        if (arma instanceof Hacha){
           
            System.out.println(objetivo.getNombre() + " empieza a sangrar por 2 turnos.");
             objetivo.activarSangrado(2);
        }
        System.out.println(getNombre() + " atacó con " + arma.getNombreArma()+ " causando " + danio + " de daño.");
    }

    @Override
      public void curarse() {
        // Cura inmediata: 25% de la vida máxima
        double cantidadInmediata = this.vidamaxima * 0.25;
        this.vida += cantidadInmediata;
        if (this.vida > this.vidamaxima) this.vida = this.vidamaxima;

        // activa la curación del siguiente turno (15%)
        int cantidadCuradaInt = (int) cantidadInmediata;  
    
    System.out.println(getNombre() + " usó una poción y recuperó " + cantidadCuradaInt + " de vida. Vida actual: " + this.vida);
}
    
    public void sanarTurnoSiguiente() {
           if (tieneCuraPendiente) {
            int extra = (int)(vidamaxima * 0.15);
            this.vida += extra;

            if (this.vida > this.vidamaxima) {
                this.vida = this.vidamaxima;
            }

            System.out.println(getNombre() + " recupera " + extra + " de vida adicional por la poción anterior. Vida actual: " + this.vida);
            tieneCuraPendiente = false;
    }   
}
    }
