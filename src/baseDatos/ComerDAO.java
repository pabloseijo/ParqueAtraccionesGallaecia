package baseDatos;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import aplicacion.Comer;
import aplicacion.Visitante;
import aplicacion.Hosteleria;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class ComerDAO extends AbstractDAO{

    public ComerDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    /**
     * Devuelve todas las veces que algún visitante comió
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public ArrayList<Comer> consultarComer() throws SQLException {
        ArrayList<Comer> resultado = new ArrayList<>();
        Comer comerActual;
        Connection con;
        PreparedStatement stmComer = null;
        ResultSet rsComer;

        con = this.getConexion();

        try  {
        stmComer=con.prepareStatement("SELECT FechaVisita, horaVisita, Visitante, Establecimiento FROM Comer");
        rsComer=stmComer.executeQuery();
        while (rsComer.next())
        {
            comerActual = new Comer(rsComer.getDate("FechaVisita"), rsComer.getTime("horaVisita"), rsComer.getString("Visitante"), rsComer.getInt("Establecimiento"));
            resultado.add(comerActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
        } finally{
          try {stmComer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    /**
     * Añade una reserva de mesa al usuario
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void reservarMesa(Date fecha, Time hora, String dni, int establecimiento) {
        Connection con;

        con = super.getConexion();

        PreparedStatement stmComer = null;

        try {
            stmComer = con.prepareStatement("INSERT INTO Comer (FechaVisita, horaVisita, Visitante, Establecimiento) VALUES (? ? ? ?)");
            stmComer.setDate(1, fecha);
            stmComer.setTime(2, hora);
            stmComer.setString(3, dni);
            stmComer.setInt(4, establecimiento);
            stmComer.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmComer.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
