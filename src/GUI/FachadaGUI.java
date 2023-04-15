package GUI;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class FachadaGUI {
    aplicacion.FachadaAplicacion fachadaAplicacion;
    // VPrincipal vp; // ventana inicial
    
   public FachadaGUI(aplicacion.FachadaAplicacion fachadaAplicacion){
     this.fachadaAplicacion = fachadaAplicacion;
     // this.vp = new VPrincipal(fa); // Inicializar ventana inicial
   } 
    
    
    // Esto hace que se inicie la ventana de autentifcacion 
    public void iniciaVista(){
      LoginGUI va;
    
      // Iniciar login y ventana inicial

    //   va = new LoginGUI(vp, true, fa);
    //   vp.setVisible(true);
    //   va.setVisible(true);
    } 
   
}

