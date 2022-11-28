package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import modelos.MatrizNumeros;

/**
 *
 * @author Javier P. López
 */
public class Panel extends JPanel{
  
  public MatrizNumeros direccionDeMemoriaNumero = null;

  public Panel(MatrizNumeros direccionDeMemoriaNumero){
    this.direccionDeMemoriaNumero = direccionDeMemoriaNumero;
    this.setBackground(Color.ORANGE);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D g2 = (Graphics2D) g;
    
    this.direccionDeMemoriaNumero.dibujarMatrizNumerica(g2);
    
  }
    
}
