package Personajes;

import Armas.armas;

public class Bestia extends Personaje {

    public Bestia(String nombre, armas arma) {
        super(nombre, 100, arma, "Bestia");
    }

    @Override
    public void atacar(Personaje objetivo) {
        int danio = 0;

        if (arma.getNombreArma().equalsIgnoreCase("Puños")) {
            danio = 25;
            this.vida -= 10;
            if (this.vida < 0) {
                this.vida = 0;
            }
            System.out.println(nombre + " ataca con puños, inflige 25 de daño y sufre 10 de daño por el esfuerzo. Vida restante: " + vida);
        } else if (arma.getNombreArma().equalsIgnoreCase("Espada")) {
            danio = (int)(Math.random() * 10) + 1;
            System.out.println(nombre + " ataca con espada causando " + danio + " de daño.");
        } else {
            System.out.println("El arma no es válida para Bestia.");
            return;
        }

        objetivo.recibirDanio(danio);
    }

    @Override
    public void curarse() {
        int vidaRecuperada = (int)(vidamaxima * 0.45);
        vida += vidaRecuperada;

        if (vida > vidamaxima) {
            vida = (int) vidamaxima;
        }

        System.out.println(nombre + " duerme y recupera " + vidaRecuperada + " puntos de vida. Vida actual: " + vida);
    }
}