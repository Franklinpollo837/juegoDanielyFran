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
// creamos los atributos de Personajes 
public abstract class Personaje {
    public String nombre;
    public  int vida;
    public armas arma;
    public String tipoRaza;
    public int vidamaxima;
    public int turnosSangrando = 0;
    public int fuerza;
    
    //personajes
    
    
// creamos el constructor
   public Personaje(String nombre, int vida, armas arma, String tipoRaza) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidamaxima = vida;
        this.arma = arma;
        this.fuerza = fuerza;
        this.tipoRaza = tipoRaza;
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getTipoRaza() {
        return tipoRaza;
    }

    public void setTipoRaza(String tipoRaza) {
        this.tipoRaza = tipoRaza;
    }

     public int getVidamaxima() {
        return vidamaxima;
    }
  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
       public void setVidamaxima(int vidamaxima) {
        this.vidamaxima = vidamaxima;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = (int) vida;
    }

    public armas getArma() {
        return arma;
    }

    public void setArma(armas arma) {
        this.arma = arma;
    }

    public String getTipoRazo() {
        return tipoRaza;
    }

// creamos getter y setter
    public void setTipoRazo(String tipoRazo) {
        this.tipoRaza = tipoRazo;
    }
    
public int getFuerza() {
    return fuerza;
}

public void setFuerza(int fuerza) {
    this.fuerza = fuerza;
}
// toString

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + ", arma=" + arma + ", tipoRazo=" + tipoRaza+ '}';
    }
    public void recibirDanio(int cantidad) {
    this.vida -= cantidad;
    if (this.vida < 0) {
        this.vida = 0;
    }
    System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + vida);
}
   //con este metodo activamos el sangrado del hacha
public void activarSangrado(int turnos) {
    this.turnosSangrando = turnos;

}
// y aqui se aplica el efecto
    public void aplicarEfectosPorTurno() {
    if (turnosSangrando > 0) {
        this.vida -= 3;
        System.out.println("El oponente recibe 3 puntos de daño por sangrado");
        turnosSangrando--;
    }

    if (vida < 0) vida = 0; // para evitar vida negativa
      }
    
    public void reiniciar() {
    this.vida = this.vidamaxima;        // Restaurar vida al máximo
    this.turnosSangrando = 0;            // Quitar sangrado
   
   
}
    public abstract void atacar(Personaje objetivo); // metodo abstracto para atacar
    // se cambia despues en sus clases
    public abstract void curarse();
    // metodo abstracto para curarse
    // se cambia despues en sus clases
}
