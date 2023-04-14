package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import aplicacion.Comer;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class ComerDAO extends AbstractDAO{

    public ComerDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    public java.util.List<Comer> consultarComer(){
        java.util.List<Comer> resultado = new java.util.ArrayList<Comer>();
        Comer comerActual;
        Connection con;
        PreparedStatement stmComer=null;
        ResultSet rsComer;

        con=this.getConexion();

        try  {
        stmComer=con.prepareStatement("select FechaVisita, Visitante, Establecimiento from Comer");
        rsComer=stmComer.executeQuery();
        while (rsComer.next())
        {
            comerActual = new Comer(rsComer.getString("FechaVisita"), rsComer.getString("Visitante"), rsComer.getString("Establecimiento"));
            resultado.add(comerActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmComer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
}
