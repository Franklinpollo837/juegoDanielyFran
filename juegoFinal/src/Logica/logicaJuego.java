/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;
import Armas.* ;
import BD.ConexionBD;
import Personajes.*;
import java.util.Scanner;
import UsuarioPack.Usuario;
/**
 *
 * @author frank
 */
// Vamos a dar inicio del proyecto 
public class logicaJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logica.SelecionPersonaje creacion = new Logica.SelecionPersonaje();// instancia para la selecion y creacion del personaje
        Scanner sc = new Scanner(System.in);
        
         ConexionBD.conectar();//metodo para llamar a la base de datos
       int NJugadores= 0;// variable para indicar el numero maximo de jugadores
       int jugadorN1=0;//variable para jugador 1
       int jugadorN2=0;//variable para jugador 2
       String Nombre1;//variable para jugador 1
       String Nombre2;//variable para jugador 2
       Personaje Personaje1 = null;
        Personaje Personaje2 = null;
        Usuario usuario1 = null;
        Usuario usuario2 = null;
        
         System.out.println("JUEGO INICIADO");
         System.out.println("");
         System.out.println("");
         //while inicial
        while(NJugadores<2){
            int valor=0;
            
            System.out.println("seleccione su numero de jugador");
            System.out.println("1 = Jugador 1");
            System.out.println("2 = Jugador 2");
            while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                valor = sc.nextInt();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.next(); 
            }
        }
            //aqui se hace la creacion de lo jugadores/usuarios
             switch (valor) {
                case 1 -> {
                    if (jugadorN1 == 0) {
                        jugadorN1 = 1;
                        NJugadores++;
                        System.out.println("dijite su nombre como jugador:");
                        Nombre1= sc.next();
                        //instancia del usuario
                        usuario1 = new UsuarioPack.Usuario(Nombre1, 0);
                        System.out.println("Jugador 1 asignado correctamente\n");
                        System.out.println("selecion de personaje:\n");
                        Personaje1 = creacion.seleccionar(Nombre1);
                        
                        
                        
                    } else {
                        System.out.println("El Jugador 1 ya fue asignado!");
                    }
                }

                case 2 -> {
                    if (jugadorN2 == 0) {
                        jugadorN2 = 2;
                        NJugadores++;
                         System.out.println("dijite su nombre como jugador:");
                        Nombre2= sc.next();
                        //instancia del usuario
                        usuario2 = new UsuarioPack.Usuario(Nombre2, 0);
                        System.out.println("Jugador 2 asignado correctamente\n");
                         System.out.println("seleciona tu personaje:\n");
                        Personaje2 = creacion.seleccionar(Nombre2);
                    } else {
                        System.out.println("El Jugador 2 ya fue asignado!");
                    }
                }

                default -> System.out.println("Opción inválida. Solo puedes elegir 1 o 2.\n");
            }
            }
        Logica.Turnos combate = new Logica.Turnos(Personaje1, Personaje2, usuario1, usuario2);
        boolean d = true;
        int escoger;
        while(d){
      System.out.println("Listo para la batalla?\n");
    System.out.println("1 = Iniciar Batalla");
    System.out.println("2 = Ver stats de las batallas");
    System.out.println("3 = Salir");

    // Validar entrada
    while (true) {
        if (sc.hasNextInt()) {
            escoger = sc.nextInt();
            break;
        } else {
            System.out.println("Ingrese un número válido");
            sc.next();
        }
    }

    // Usar la opción elegida
    switch (escoger) {
        case 1 -> {
            System.out.println("Iniciando batalla...\n");
            combate.combate();
         
        }
        
        case 2 -> {
            System.out.println("Mostrando stats...");

         
            System.out.println("Partidas ganas por parte de "+usuario1.getNombre()+ " son de: "+usuario1.getNganadas()+"\n");
            System.out.println("Partidas ganas por parte de "+usuario2.getNombre()+ " son de: "+usuario2.getNganadas()+"\n");
        }
        case 3 -> {
            System.out.println("Saliendo...");
            d = false; // rompe el bucle externo
        }
        default -> System.out.println("Opción no válida");
    }
            
        }
        
    }
        
        
        
        
 
       
    }
   
