/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;
import Armas.*;
import BD.ConexionBD;
import Personajes.*;
import java.util.Scanner;
import UsuarioPack.Usuario;

public class logicaJuego {

    public static void main(String[] args) {
        Logica.SelecionPersonaje creacion = new Logica.SelecionPersonaje();
        Scanner sc = new Scanner(System.in);
        
        ConexionBD.conectar();
        int NJugadores = 0;
        int jugadorN1 = 0;
        int jugadorN2 = 0;
        String Nombre1;
        String Nombre2;
        Personaje Personaje1 = null;
        Personaje Personaje2 = null;
        Usuario usuario1 = null;
        Usuario usuario2 = null;
        
        System.out.println("JUEGO INICIADO\n");

        while(NJugadores < 2) {
            int valor = 0;
            
            System.out.println("Seleccione su número de jugador");
            System.out.println("1 = Jugador 1");
            System.out.println("2 = Jugador 2");
            
            while (true) {
                if (sc.hasNextInt()) {
                    valor = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    break;
                } else {
                    System.out.println("Ingrese un número válido");
                    sc.next();
                }
            }

            switch (valor) {
                case 1 -> {
                    if (jugadorN1 == 0) {
                        jugadorN1 = 1;
                        NJugadores++;
                        System.out.println("Digite su nombre como jugador:");
                        Nombre1 = sc.nextLine();
                        
                        // Creación del personaje para jugador 1
                        Personaje1 = null;
                        while (Personaje1 == null) {
                            Personaje1 = creacion.seleccionar(Nombre1);
                            if (Personaje1 == null) {
                                System.out.println("No se pudo crear el personaje. Intente de nuevo.");
                            }
                        }
                        
                        // Creación del usuario para jugador 1
                        usuario1 = new Usuario(Nombre1, 0);
                        new BD.PersonajeDAO().guardarPersonaje(Personaje1);
                        System.out.println("Jugador 1 asignado correctamente\n");
                    } else {
                        System.out.println("El Jugador 1 ya fue asignado!");
                    }
                }

                case 2 -> {
                    if (jugadorN2 == 0) {
                        jugadorN2 = 2;
                        NJugadores++;
                        System.out.println("Digite su nombre como jugador:");
                        Nombre2 = sc.nextLine();
                        
                        // Creación del personaje para jugador 2
                        Personaje2 = null;
                        while (Personaje2 == null) {
                            Personaje2 = creacion.seleccionar(Nombre2);
                            if (Personaje2 == null) {
                                System.out.println("No se pudo crear el personaje. Intente de nuevo.");
                            }
                        }
                        
                        // Creación del usuario para jugador 2
                        usuario2 = new Usuario(Nombre2, 0);
                        new BD.PersonajeDAO().guardarPersonaje(Personaje2);
                        System.out.println("Jugador 2 asignado correctamente\n");
                    } else {
                        System.out.println("El Jugador 2 ya fue asignado!");
                    }
                }

                default -> System.out.println("Opción inválida. Solo puedes elegir 1 o 2.\n");
            }
        }

        // Verificación final antes del combate
        if (Personaje1 == null || Personaje2 == null || usuario1 == null || usuario2 == null) {
            System.out.println("Error crítico: No se pudieron crear todos los jugadores");
            return;
        }

        Logica.Turnos combate = new Logica.Turnos(Personaje1, Personaje2, usuario1, usuario2);
        boolean continuar = true;
        
        while(continuar) {
            System.out.println("\nListo para la batalla?");
            System.out.println("1 = Iniciar Batalla");
            System.out.println("2 = Ver stats de las batallas");
            System.out.println("3 = Salir");

            int escoger;
            while (true) {
                if (sc.hasNextInt()) {
                    escoger = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Ingrese un número válido");
                    sc.next();
                }
            }

            switch (escoger) {
                case 1 -> {
                    System.out.println("\nIniciando batalla...");
                    combate.combate();
                }
                
                case 2 -> {
                    System.out.println("\nEstadísticas:");
                    System.out.println("Partidas ganadas por "+usuario1.getNombre()+": "+usuario1.getNganadas());
                    System.out.println("Partidas ganadas por "+usuario2.getNombre()+": "+usuario2.getNganadas()+"\n");
                }
                
                case 3 -> {
                    System.out.println("Saliendo del juego...");
                    continuar = false;
                }
                
                default -> System.out.println("Opción no válida");
            }
        }
        
        sc.close();
}
}