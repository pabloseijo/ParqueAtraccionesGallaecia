package aplicacion;

import baseDatos.AsistirDAO;
import baseDatos.DAOUsuarios;
import baseDatos.AtraccionesDAO;
import baseDatos.ComerDAO;
import baseDatos.EspectaculosDAO;
import baseDatos.HosteleriaDAO;
import baseDatos.HostelerosDAO;
import baseDatos.IrDAO;
import baseDatos.TrabajadorEspectaculoDAO;
import baseDatos.VisitantesDAO;
import java.sql.*;

import javax.swing.AbstractAction;

/**
 *
@author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;

    public FachadaAplicacion()  {
        fgui=new gui.FachadaGui(this);
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

    

}
