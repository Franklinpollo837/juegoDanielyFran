/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Personajes.Personaje;
import UsuarioPack.Usuario;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author danir
 */
public class Turnos {
     private Personaje jugador1;
    private Personaje jugador2;
    private Usuario usuario1;
    private Usuario usuario2;
    private Personaje actual;
       Scanner sc = new Scanner(System.in);
    public Turnos(Personaje j1, Personaje j2, Usuario usuario1, Usuario usuario2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        
    }
    Random random = new Random();
    //metodod que simmula el cambio de turno para la batalla
    public void TurnoInicial() {
        if (random.nextBoolean()) {
            actual = jugador2;
        } else {
            actual = jugador1;
        }
    }
    
    public Personaje siguienteTurno(Personaje jugador1, Personaje jugador2 ) {
        if (actual == jugador1) {
            actual = jugador2;
        } else {
            actual = jugador1;
        }
        return actual;
    }
    private Personaje Oponente() {
    if (actual == jugador1) {
        return jugador2;
    } else {
        return jugador1;
    }
}
    
    //metodo de las batallas
    public void combate(){
        TurnoInicial();
        int elecion;
        while(jugador1.getVida() >0 && jugador2.getVida() >0){
            System.out.println("\nTurno de: "+actual.getNombre());
            //empiza turno
            System.out.println("\nQue accion quiere realizar?\n");
            System.out.println("1 = Atacar");
            System.out.println("2 = Curar vida");
            while (true) {
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                elecion = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }
            
            switch(elecion){
                case 1->{
                    actual.atacar(Oponente());
                }
                case 2->{
                    actual.curarse();
                }
            }
          siguienteTurno(jugador1, jugador2);  
        }
        //mostrar al ganador
        System.out.println("\n¡La batalla ha terminado!");
        if (jugador1.getVida() <= 0) {
            System.out.println(jugador2.getNombre() + " ha ganado.");
      
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado.");
           
        }
    }
        
}
