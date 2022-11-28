package numpuz;

import javax.swing.JFrame;
import vista.Panel;
import controlador.Controlador;
import modelos.MatrizNumeros;
/**
 *
 * @author Javier P. López
 */
public class Numpuz {

  public static void main(String[] args) {
    
    int ancho = 4;
    int largo = 4;
    
    MatrizNumeros numeroMatriz = new MatrizNumeros(ancho,largo);
    Panel panel = new Panel(numeroMatriz);
    new Controlador(numeroMatriz, panel);
    JFrame ventana = new JFrame("Numpuz");
    ventana.setBounds(100, 100, ancho * 104, largo * 110);
    ventana.add(panel);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setVisible(true);
    
  }
  
}
