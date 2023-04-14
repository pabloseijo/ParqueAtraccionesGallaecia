
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacion.Espectaculo;
import aplicacion.Asistir;
import aplicacion.TrabajadorEspectaculo;
/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class EspectaculosDAO extends AbstractDAO{

    public EspectaculosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    public java.util.List<Espectaculo> consultarEspectaculos(){
        java.util.List<Espectaculo> resultado = new java.util.ArrayList<Espectaculo>();
        Espectaculo espectaculoActual;
        Connection con;
        PreparedStatement stmEspectaculos=null;
        ResultSet rsEspectaculos;

        con=this.getConexion();

        try  {
        stmEspectaculos=con.prepareStatement("select nombre, descripcion from categoria");
        rsEspectaculos=stmEspectaculos.executeQuery();
        while (rsEspectaculos.next())
        {
            espectaculoActual = new Espectaculo(rsEspectaculos.getInt("id"), rsEspectaculos.getString("nombre"), rsEspectaculos.getString("sesion"), rsEspectaculos.getString("horaInicio"), rsEspectaculos.getString("horaFin"), rsEspectaculos.getString("tematica"), rsEspectaculos.getString("descripcion"), rsEspectaculos.getString("ubicacion"));
            resultado.add(espectaculoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEspectaculos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
}
