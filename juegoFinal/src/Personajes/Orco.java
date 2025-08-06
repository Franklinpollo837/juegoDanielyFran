/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

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
    private boolean curacionPendiente = false;
    
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
        
        if (arma.tieneSangrado()){
            objetivo.activarSangrado(2);
            System.out.println(objetivo.getNombre() + " empieza a sangrar por 2 turnos.");
        }
        System.out.println(getNombre() + " atacó con " + arma.getNombreArma()+ " causando " + danio + " de daño.");
    }

    @Override
    public void curarse() {
         int cura = (int)(dannioAcumulado * 0.25);
        this.vida += cura;

        if (this.vida > this.vidamaxima) {
            this.vida = this.vidamaxima;
        }

        System.out.println(getNombre() + " usó una poción y recuperó " + cura + " de vida. Vida actual: " + this.vida);

        tieneCuraPendiente = true; // activa el bono para el siguiente turno
        dannioAcumulado = 0;
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
