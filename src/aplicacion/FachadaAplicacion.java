package aplicacion;

import java.sql.*;

import javax.swing.AbstractAction;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class FachadaAplicacion {

    GUI.FachadaGUI fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios gu;

    public FachadaAplicacion()  {
        fgui=new GUI.FachadaGUI(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
    }
    


    public static void main(String[] args) throws SQLException {
        FachadaAplicacion fa;
     
        fa= new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        return gu.comprobarAutentificacion(idUsuario, clave);
      }

    

}
