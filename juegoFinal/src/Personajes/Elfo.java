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
public class Elfo extends Personaje {
    private int dannioAcumulado;
    private String tipoMagia;

    public Elfo(int dannioAcumulado, String tipoMagia, String nombre, double vida, armas arma, String tipoRaza) {
        super(nombre, vida, arma, tipoRaza);
        this.dannioAcumulado = dannioAcumulado;
        this.tipoMagia = tipoMagia;
    }

    @Override
    public void atacar(Personaje objetivo) {
        int danio = 0;

    if (tipoMagia.equalsIgnoreCase("Fuego")) {
        danio = getArma().calcularDanio();
        danio += danio * 0.10; // +10%
    } 
    else if (tipoMagia.equalsIgnoreCase("Tierra")) {
        danio = getArma().calcularDanio();
        danio += danio * 0.02; // +2%
        if (Math.random() < 0.3) { // 30% de atacar dos veces
            int extra = getArma().calcularDanio();
            System.out.println("¡Ataque doble con tierra! Daño adicional: " + extra);
            danio += extra;
        }
    } 
    else if (tipoMagia.equalsIgnoreCase("Aire")) {
        danio = getArma().calcularDanio(); // luego podés agregar daño extra si está a distancia
    } 
    else if (tipoMagia.equalsIgnoreCase("Agua")) {
        danio = getArma().calcularDanio();
    }

    objetivo.recibirDanio(danio);
    System.out.println(getNombre() + " ataco a " + objetivo.getNombre() + " usando magia de " + tipoMagia + " causando " + danio + " de daño.");
}
       public void recibirDanio(int cantidad) {
        super.recibirDanio(cantidad);
        dannioAcumulado += cantidad;
    }

    public void sanar() {
        double porcentajeCura = tipoMagia.equalsIgnoreCase("Agua") ? 0.90 : 0.75;
        int vidaRecuperada = (int)(dannioAcumulado * porcentajeCura);
        this.vida += vidaRecuperada;

        if (tipoMagia.equalsIgnoreCase("Agua") && this.vida > 115) {
            this.vida = 115;
        } else if (this.vida > 100) {
            this.vida = 100;
        }

        dannioAcumulado = 0;

        System.out.println(getNombre() + " uso un hechizo de sanacion y recupero " + vidaRecuperada + " puntos de vida.");
    }

    public String getTipoMagia() {
        return tipoMagia;
    }
    }
    
    

