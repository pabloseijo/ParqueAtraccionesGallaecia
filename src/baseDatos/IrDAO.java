package baseDatos;

import aplicacion.Atraccion;
import aplicacion.Comer;
import baseDatos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import aplicacion.Ir;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class IrDAO extends AbstractDAO{

    public IrDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
     * Devuelve todas las veces que algún visitante fue a una atracción
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public ArrayList<Ir> consultarIr() throws SQLException {
        ArrayList<Ir> resultado = new ArrayList<>();
        Ir irActual;
        Connection con;
        PreparedStatement stmIr = null;
        ResultSet rsIr;

        con = this.getConexion();

        try  {
            stmIr = con.prepareStatement("SELECT FechaVisita, horaVisita, Visitante, Atraccion FROM Ir");
            rsIr = stmIr.executeQuery();
            while (rsIr.next())
            {
                irActual = new Ir(rsIr.getDate("FechaVisita"), rsIr.getTime("horaVisita"), rsIr.getString("Visitante"), rsIr.getInt("Atraccion"));
                resultado.add(irActual);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally{
            try {stmIr.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    /**
     * Añade una reserva una entrada para una atraccion al usuario
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void reservarEntrada(Date fecha, Time hora, String dni, String nombreAtraccion) throws SQLException {

        Connection con;

        con = super.getConexion();

        PreparedStatement stmIr = null;

        try {
            Atraccion atraccion= getFachadaAplicacion().getFachadaBD().buscaAtraccion(nombreAtraccion);
            stmIr = con.prepareStatement("INSERT INTO Ir (FechaVisita,horaVisita,Visitante,Atraccion) VALUES(?,?,?,?)");
            stmIr.setDate(1, fecha);
            stmIr.setTime(2, hora);
            stmIr.setString(3, dni);
            stmIr.setInt(4, atraccion.getNumeroRegistro());
            stmIr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IrDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmIr.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }


}



