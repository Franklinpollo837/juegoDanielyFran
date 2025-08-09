 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Armas.armas;
import java.util.Random;

/**
 *
 * @author frank
 */
public class Elfo extends Personaje {
    private int dannioAcumulado;
    private String tipoMagia;
    private Random random = new Random();

    public Elfo(String nombre, armas arma, String tipoMagia) {
        super(nombre, 100, arma, "Elfo"); // valor por defecto
        this.tipoMagia = tipoMagia;
        this.dannioAcumulado = 0;

        // Si es magia de agua, ajustar vida máxima y vida actual a 115
        if (tipoMagia.equalsIgnoreCase("Agua")) {
            this.vida = 115;
            this.vidamaxima = 115;
        }
    }

    @Override
    public void atacar(Personaje objetivo) {
        int danio = 0;

     if (tipoMagia.equalsIgnoreCase("Fuego")) {
            danio = arma.calcularDanio();
           
            danio = (int) (danio*0.10);
        } else if (tipoMagia.equalsIgnoreCase("Tierra")) {
            danio = arma.calcularDanio();
            danio += (int) (danio * 0.02); // +2%
            // Chance de doble ataque
            if (random.nextDouble() < 0.30) {
                int extra = arma.calcularDanio();
                System.out.println("Ataque doble con magia de Tierra! Daño adicional: " + extra);
                danio= danio+extra;
            }
        } else if (tipoMagia.equalsIgnoreCase("Aire")) {
            danio = arma.calcularDanio();
        } else if (tipoMagia.equalsIgnoreCase("Agua")) {
            danio = arma.calcularDanio();
        } else {
            System.out.println("Tipo de magia desconocido. No se ejecutó el ataque.");
            return;
        }

        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " atacó a " + objetivo.getNombre() +
                " usando magia de " + tipoMagia + " causando " + danio + " puntos de daño.");
}
       public void recibirDanio(int cantidad) {
        super.recibirDanio(cantidad);
        dannioAcumulado += cantidad;
    }

    @Override
    public void curarse() {
       double porcentajeCura;

if (tipoMagia.equalsIgnoreCase("Agua")) {
    porcentajeCura = 0.90;
} else {
    porcentajeCura = 0.75;
}

int vidaRecuperada = (int) (dannioAcumulado * porcentajeCura);
this.vida += vidaRecuperada;

if (this.vida > this.vidamaxima) {
    this.vida = this.vidamaxima;
}

System.out.println(getNombre() + " usó un hechizo de sanación y recuperó " +
        vidaRecuperada + " puntos de vida. Vida actual: " + this.vida);

// Reiniciar el acumulador
dannioAcumulado = 0;
 }

    public String getTipoMagia() {
        return tipoMagia;
    }
    
        public void setTipoMagia(String tipoMagia) {
        this.tipoMagia = tipoMagia;
    }
     }

