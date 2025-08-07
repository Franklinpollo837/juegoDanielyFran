/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

/**
 *
 * @author frank
 */
import bd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonajeDAO {

    public static void insertarJugador(String nombre) {
        String sql = "INSERT INTO jugador(nombre, partidas_ganadas, partidas_perdidas) VALUES (?, 0, 0)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            System.out.println("Jugador insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar jugador: " + e.getMessage());
        }
    }
}