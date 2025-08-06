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
         int danio = 0;

    // Revisar el nombre del arma
    String nombreArma = this.getArma().getNombre();

    if (nombreArma.equalsIgnoreCase("Escopeta")) {
        danio = getArma().calcularDanio();
        danio += danio * 0.02; // +2%
    } else if (nombreArma.equalsIgnoreCase("Rifle francotirador")) {
        danio = getArma().calcularDanio(); // daño entre 1 y 5
    }

    // Aplicar el daño
    objetivo.recibirDanio(danio);

    // Acumular daño para la sanación
    // (si esta clase también define recibirDanio, también se puede manejar ahí)
    System.out.println(getNombre() + " atacó a " + objetivo.getNombre() + " con " + nombreArma + " causando " + danio + " de daño.");
}
    
     public void recibirDanio(int cantidad) {
        super.recibirDanio(cantidad);
        dannioAcumulado += cantidad;
    }

    public void sanar() {
        int vidaRecuperada = (int)(dannioAcumulado * 0.5);
        this.vida += vidaRecuperada;
        if (this.vida > 100) {
            this.vida = 100;
        }
        dannioAcumulado = 0;
        System.out.println(nombre + " comió y recuperó " + vidaRecuperada + " puntos de vida.");
    }
}
   
    
    

