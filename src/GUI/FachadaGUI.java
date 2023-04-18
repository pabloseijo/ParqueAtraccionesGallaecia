package GUI;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class FachadaGUI {
    aplicacion.FachadaAplicacion fachadaAplicacion;
    
   public FachadaGUI(aplicacion.FachadaAplicacion fachadaAplicacion){
     this.fachadaAplicacion = fachadaAplicacion;
   } 
    
    
    // Esto hace que se inicie la ventana de autentifcacion 
    public void iniciaVista(){
      LoginGUI vAutentificacion;
    
      // Iniciar login y ventana inicial

      vAutentificacion = new LoginGUI(null, fachadaAplicacion);
    } 
   
}

