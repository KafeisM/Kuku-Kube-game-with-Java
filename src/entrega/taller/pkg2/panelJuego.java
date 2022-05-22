package entrega.taller.pkg2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class panelJuego extends JPanel {

    private static int dimension;
    private static int maximo;
    private static int lado;
    private Casilla t[][];
    private Color col;
    private int R, G, B;
    private Random ran;
    private int aux1, aux2;

    public panelJuego(int dim) {
        dimension = dim;
        maximo = 500;
        lado = (maximo / dimension) - 3;

        this.setSize(500, 500);
        this.setBackground(Color.white);

        t = new Casilla[dimension][dimension];
        Casilla c;
        ran = new Random();
        R = ran.nextInt(256);
        G = ran.nextInt(256);
        B = ran.nextInt(256);

        int y = 0;
        for (int i = 0; i < dimension; i++) {
            int x = 0;
            for (int j = 0; j < dimension; j++) {
                col = new Color(R, G, B);
                Rectangle2D.Float r = new Rectangle2D.Float(x, y, lado, lado);
                c = new Casilla(r, col);
                t[i][j] = c;
                c.setOcupada(false);

                x += lado + 3;
            }
            y += lado + 3;
        }

    }

    public final void generarCasilla(int dificultad) {
        int x, y;
        Casilla c;

        x = ran.nextInt(dimension);
        y = ran.nextInt(dimension);
        aux1 = x;
        aux2 = y;
        c = t[x][y];
        t[x][y] = c;
        c.setOcupada(true);

        switch (dificultad) {
            case 1:
                calculoDif(55);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 2:
                calculoDif(50);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 3:
                calculoDif(45);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 4:
                calculoDif(40);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 5:
                calculoDif(35);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 6:
                calculoDif(30);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 7:
                calculoDif(25);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 8:
                calculoDif(20);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 9:
                calculoDif(15);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
            case 10:
                calculoDif(10);
                col = new Color(R, G, B);
                c.cambiarColor(col);
                break;
        }
    }

    private void calculoDif(int dif) {
        R = R - dif;
        G = G - dif;
        B = B - dif;

        if (R < 0) {
            R = 0;
        }

        if (G < 0) {
            G = 0;
        }

        if (B < 0) {
            B = 0;
        }
    }

    public int returnX() {
        return aux1;
    }

    public int returnY() {
        return aux2;
    }

    public static int getDimension() {
        return dimension;
    }

    public Casilla getCasella(int i, int j) {
        return t[i][j];
    }

    public boolean click(int i, int j, int x, int y) {
        return t[i][j].getRec().contains(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                t[i][j].paintComponent(g); //pintar les caselles
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);

    }
}
