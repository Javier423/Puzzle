package modelos;

import java.awt.Graphics2D;
import java.util.Arrays;

/**
 *
 * @author Javier P. López
 */
public class MatrizNumeros {

  public Numero[][] matrizNumerica = null;
  public int[] matrizAleatorios = null;
  public int ancho, largo;

  public MatrizNumeros(int anchoMatriz, int largoMatriz) {
    ancho = anchoMatriz;
    largo = largoMatriz;
    this.matrizNumerica = new Numero[anchoMatriz][largoMatriz];
    generarNumeroAleatorio(anchoMatriz * largoMatriz);
    rellenarMatrizConDatos();
  }

  public void rellenarMatrizConDatos() {

    int posX = 0;
    int posY = 0;
    int contador = 0;
    int lado = Numero.lado;
    System.out.println(Arrays.toString(matrizAleatorios));
    for (int i = 0; i < this.matrizNumerica.length; i++) {
      for (int j = 0; j < this.matrizNumerica[i].length; j++) {

        this.matrizNumerica[i][j] = new Numero(String.valueOf(matrizAleatorios[contador]), posX, posY);

        posX = posX + lado;
        contador = contador + 1;

      }

      posX = 0;
      posY = posY + lado;

    }
    this.matrizNumerica[ancho - 1][largo - 1].idNumero = "";

  }

  public void generarNumeroAleatorio(int maximo) {

    matrizAleatorios = new int[maximo];
    boolean bandera = true;
    int conteo = 0;

    while (bandera) {
      int aleatorio = (int) (Math.random() * maximo);
      if (conteo == matrizAleatorios.length - 1) {
        break;
      } else if (!existeAlgunNumeroEnLaMatriz(matrizAleatorios, aleatorio)) {
        matrizAleatorios[conteo] = aleatorio;
        conteo = conteo + 1;
      }
    }
  }

  public boolean existeAlgunNumeroEnLaMatriz(int[] matriz, int comparacion) {
    boolean estado = false;
    for (int i = 0; i < matriz.length; i++) {
      if (matriz[i] == comparacion) {
        estado = true;
        break;
      }
    }
    return estado;
  }

  public void dibujarMatrizNumerica(Graphics2D g) {

    for (int i = 0; i < this.matrizNumerica.length; i++) {

      for (int j = 0; j < this.matrizNumerica[i].length; j++) {

          this.matrizNumerica[i][j].dibujarNumero(g);
          
      }

    }

  }

}
