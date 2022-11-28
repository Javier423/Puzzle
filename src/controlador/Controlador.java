package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.MatrizNumeros;
import modelos.Numero;
import vista.Panel;

/**
 *
 * @author Javier P. López
 */
public class Controlador extends MouseAdapter {

  public MatrizNumeros numero = null;
  public Panel panel = null;

  public Controlador(MatrizNumeros numero, Panel panel) {
    this.numero = numero;
    this.panel = panel;
    this.panel.setFocusable(true);
    this.panel.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

    for (int i = 0; i < numero.matrizNumerica.length; i++) {
      for (int j = 0; j < numero.matrizNumerica[i].length; j++) {

        if (numero.matrizNumerica[i][j].elRatonEstaDentroDelCuadrado(e.getX(), e.getY())) {

          boolean exito = this.moverElemento(i, j);
          if (!exito) {
            if (numero.matrizNumerica[i][j].idNumero.equals("")) {

            } else {
              System.out.println("No hay exito");
            }
          }

          break;
        }

      }
    }
  }

  public boolean moverElemento(int i, int j) {

    boolean seMovio = false;
    if (busquedaHaciaArriba(i)) {

      Numero direccionTemporal = numero.matrizNumerica[i - 1][j];
      if (direccionTemporal.idNumero.equals("")) {
        direccionTemporal.posicionY += 100;

        Numero direccionNodoMover = numero.matrizNumerica[i][j];
        direccionNodoMover.posicionY -= 100;

        numero.matrizNumerica[i][j] = direccionTemporal;
        numero.matrizNumerica[i - 1][j] = direccionNodoMover;
        seMovio = true;
      }

    }
    if (busquedaHaciaAbajo(i)) {

      Numero direccionTemporal = numero.matrizNumerica[i + 1][j];
      if (direccionTemporal.idNumero.equals("")) {
        direccionTemporal.posicionY -= 100;

        Numero direccionNodoMover = numero.matrizNumerica[i][j];
        direccionNodoMover.posicionY += 100;

        numero.matrizNumerica[i][j] = direccionTemporal;
        numero.matrizNumerica[i + 1][j] = direccionNodoMover;
        seMovio = true;

      }

    }
    if (busquedaHaciaIzquierda(j)) {

      Numero direccionTemporal = numero.matrizNumerica[i][j - 1];
      if (direccionTemporal.idNumero.equals("")) {
        direccionTemporal.posicionX += 100;

        Numero direccionNodoMover = numero.matrizNumerica[i][j];
        direccionNodoMover.posicionX -= 100;

        numero.matrizNumerica[i][j] = direccionTemporal;
        numero.matrizNumerica[i][j - 1] = direccionNodoMover;
        seMovio = true;

      }

    }
    if (busquedaHaciaDerecha(j)) {

      Numero direccionTemporal = numero.matrizNumerica[i][j + 1];

      if (direccionTemporal.idNumero.equals("")) {

        direccionTemporal.posicionX -= 100;

        Numero direccionNodoMover = numero.matrizNumerica[i][j];
        direccionNodoMover.posicionX += 100;

        numero.matrizNumerica[i][j] = direccionTemporal;
        numero.matrizNumerica[i][j + 1] = direccionNodoMover;
        seMovio = true;

      }
    }

    this.panel.repaint();

    return seMovio;
  }

  public boolean busquedaHaciaArriba(int y) {
    return (y - 1) >= 0;
  }

  public boolean busquedaHaciaAbajo(int y) {
    return (y + 1) <= this.numero.matrizNumerica.length - 1;
  }

  public boolean busquedaHaciaIzquierda(int x) {
    return (x - 1) >= 0;
  }

  public boolean busquedaHaciaDerecha(int x) {
    return (x + 1) <= this.numero.matrizNumerica.length - 1;
  }

}
