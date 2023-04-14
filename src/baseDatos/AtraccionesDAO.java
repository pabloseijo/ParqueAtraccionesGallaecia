package baseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.Atraccion;
import aplicacion.TrabajadorMantenimiento;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class AtraccionesDAO extends AbstractDAO{

    public AtraccionesDAO (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Atraccion> consultarAtracciones(){
        java.util.List<Atraccion> resultado = new java.util.ArrayList<Atraccion>();
        Atraccion atraccionActual;
        Connection con;
        PreparedStatement stmAtracciones=null;
        ResultSet rsAtracciones;

        con=this.getConexion();

        try  {
        stmAtracciones=con.prepareStatement("select numeroRegistro, nombre, aforo, alturaMin, costeMantenimiento, enReparacion, ubicacion, descripcion from categoria");
        rsAtracciones=stmAtracciones.executeQuery();
        while (rsAtracciones.next())
        {
            atraccionActual = new Atraccion(rsAtracciones.getInt("numeroRegistro"), rsAtracciones.getString("nombre"), rsAtracciones.getInt("aforo"), rsAtracciones.getInt("alturaMin"), rsAtracciones.getFloat("costeMantenimiento"), rsAtracciones.getBoolean("enReparacion"), rsAtracciones.getString("ubicacion"), rsAtracciones.getString("descripcion"));
            resultado.add(atraccionActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAtracciones.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    
}

   
