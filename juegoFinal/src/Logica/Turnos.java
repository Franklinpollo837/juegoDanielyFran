/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Personajes.Orco;
import Personajes.Personaje;
import UsuarioPack.Usuario;
import java.util.Random;
import java.util.Scanner;

public class Turnos {
    private final Personaje jugador1;
    private final Personaje jugador2;
    private final Usuario usuario1;
    private final Usuario usuario2;
    private Personaje actual;
    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    public Turnos(Personaje j1, Personaje j2, Usuario usuario1, Usuario usuario2) {
        if (j1 == null || j2 == null || usuario1 == null || usuario2 == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.actual = null; // Se establecerá en TurnoInicial()
    }

    private void TurnoInicial() {
        this.actual = random.nextBoolean() ? jugador2 : jugador1;
        System.out.println("El turno inicial es para: " + actual.getNombre());
    }

    private Personaje siguienteTurno() {
        this.actual = (actual == jugador1) ? jugador2 : jugador1;
        System.out.println("Turno cambiado a: " + actual.getNombre());
        return actual;
    }

    private Personaje Oponente() {
        return (actual == jugador1) ? jugador2 : jugador1;
    }

    public void combate() {
        try {
            TurnoInicial();
            
            while (jugador1.getVida() > 0 && jugador2.getVida() > 0) {
                System.out.println("\n--- NUEVO TURNO ---");
                System.out.println("Vida " + jugador1.getNombre() + ": " + jugador1.getVida());
                System.out.println("Vida " + jugador2.getNombre() + ": " + jugador2.getVida());

                // Efectos especiales para Orcos
                if (actual instanceof Orco) {
                    ((Orco) actual).sanarTurnoSiguiente();
                }

                actual.aplicarEfectosPorTurno();

                if (actual.getVida() <= 0) {
                    System.out.println(actual.getNombre() + " ha caído antes de actuar.");
                    break;
                }

                System.out.println("\nTurno de: " + actual.getNombre());
                System.out.println("1. Atacar");
                System.out.println("2. Curar vida");

                int eleccion = obtenerEleccionValida();

                switch (eleccion) {
                    case 1 -> actual.atacar(Oponente());
                    case 2 -> actual.curarse();
                }

                siguienteTurno();
            }

            mostrarResultadoFinal();
            
        } catch (Exception e) {
            System.err.println("Error inesperado en el combate: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int obtenerEleccionValida() {
        while (true) {
            try {
                if (sc.hasNextInt()) {
                    int eleccion = sc.nextInt();
                    sc.nextLine();
                    if (eleccion == 1 || eleccion == 2) {
                        return eleccion;
                    }
                }
                System.out.println("Ingrese una opción válida (1 o 2):");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error en la entrada. Intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private void mostrarResultadoFinal() {
        System.out.println("\n¡La batalla ha terminado!");
        if (jugador1.getVida() <= 0) {
            System.out.println(jugador2.getNombre() + " ha ganado!");
            usuario2.PartidasGanadas();
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado!");
            usuario1.PartidasGanadas();
}
}
}