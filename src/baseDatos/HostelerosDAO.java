/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.Hostelero;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class HostelerosDAO extends AbstractDAO{

    public HostelerosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los hosteleros.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Hostelero> con todos los hosteleros.
    */
    public ArrayList<Hostelero> getHosteleros() throws SQLException {
        ArrayList<Hostelero> resultado = new ArrayList<>();
        ResultSet rsHosteleros;
        PreparedStatement stmHosteleros = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleros = con.prepareStatement("SELECT * FROM Hosteleros ORDER BY fechaContratacion");
            rsHosteleros = stmHosteleros.executeQuery();
            Hostelero hostelero;
            while (rsHosteleros.next()) {
                hostelero = new Hostelero(rsHosteleros.getString("DNI"), rsHosteleros.getString("Nombre"), rsHosteleros.getString("Direccion"), rsHosteleros.getFloat("Salario"), rsHosteleros.getString("Telefono"), rsHosteleros.getDate("fechaContratacion"), rsHosteleros.getDate("fechaNacimiento"), rsHosteleros.getString("Formacion"), rsHosteleros.getInt("Espectaculo"));
                resultado.add(hostelero);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HostelerosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleros.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    /**
     * Elimina un hostelero de la base de datos
     *
     * @param dni: dni del hostelero
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void eliminarHostelero(String dni) throws SQLException{

        //Preparo la variable donde va a estar el statement
        PreparedStatement stmHostelero = null;

        //concecto con la base
        Connection con;
        con = super.getConexion();

        //intento la consulta y si se cumple la base de datos se actualiza
        try {
            stmHostelero = con.prepareStatement("DELETE from Hosteleros where DNI = ?");
            stmHostelero.setString(1, dni);
            stmHostelero.executeUpdate();
            stmHostelero.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspectaculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHostelero.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}