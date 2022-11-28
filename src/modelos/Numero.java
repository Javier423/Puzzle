package modelos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Javier P. López
 */
public class Numero {

  public int posicionX = 0, posicionY = 0;
  public String idNumero = "";
  public static int lado = 100;

  public Numero(String idNumero, int posX, int posY) {

    this.idNumero = idNumero;
    this.posicionX = posX;
    this.posicionY = posY;

  }

  public void dibujarNumero(Graphics2D g) {

    if (this.idNumero.equals("") || idNumero.isBlank()) {
      //g.setColor(Color.PINK);

    } else {
      g.setColor(Color.GREEN);
      g.fillRect(posicionX, posicionY, lado, lado);
      g.setColor(Color.BLACK);
      g.drawRect(posicionX, posicionY, lado, lado);
      BasicStroke grosor = new BasicStroke(1.8f);
      Font fuente = new Font("Arial", Font.ITALIC, 70);
      g.setStroke(grosor);
      g.setFont(fuente);
      g.setColor(Color.WHITE);
      int posicionFuenteX = (posicionX + 15);
      int posicionFuenteY = posicionY + (lado / 2) + 15;

      g.drawString(idNumero, posicionFuenteX, posicionFuenteY);
    }

  }

  public boolean elRatonEstaDentroDelCuadrado(int ratonX, int ratonY) {

    boolean estaDentro = true;
    Point puntoRaton = new Point(ratonX, ratonY);

    if ((puntoRaton.x < posicionX) || (puntoRaton.x > posicionX + lado) || (puntoRaton.y < posicionY) || (puntoRaton.y > posicionY + lado)) {
      estaDentro = false;
    }

    return estaDentro;

  }

}
