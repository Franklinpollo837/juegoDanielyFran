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
public class Humanos extends Personaje{
 private int dannioAcumulado;
 
 public Humanos(String nombre, armas arma) {
        super(nombre, 100, arma, "Humano");
        this.dannioAcumulado = 0;
    }
 
    @Override
    public void atacar(Personaje objetivo) {
        int danio = arma.calcularDanio();

        // Si el arma es escopeta, +2%
        if (arma.getNombreArma().equalsIgnoreCase("Escopeta")) {
            danio += danio * 0.02;
        }

        objetivo.recibirDanio(danio);
        System.out.println(nombre + " atacó con " + arma.getNombreArma()+ " causando " + danio + " de daño.");
    }
    
     @Override
    public void recibirDanio(int cantidad) {
        super.recibirDanio(cantidad);
        dannioAcumulado += cantidad;
    }

    @Override
    public void curarse() {
          int vidaRecuperada = (int)(dannioAcumulado * 0.50);
        vida += vidaRecuperada;

        if (vida > vidamaxima) {
            vida = (int) vidamaxima;
        }

        System.out.println(nombre + " comió y recuperó " + vidaRecuperada + " puntos de vida. Vida actual: " + vida);
        dannioAcumulado = 0;
    }
    
}
