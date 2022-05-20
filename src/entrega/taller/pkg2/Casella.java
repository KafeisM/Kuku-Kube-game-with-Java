
package entrega.taller.pkg2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author jordi
 */
public class Casella {
    private Rectangle2D.Float rec;
    private Color col;
    private Color borde;
    private Boolean ocupada;
    
    public Casella(Rectangle2D.Float r, Color c){
        col = c;
        rec = r;   
        borde = Color.white;
    }
    
    public void cambiarColor(Color c){
        col = c;
    }
    
    public void cambiarBorde(Color c){
        borde = c;
    }

    public void setOcupada(Boolean oc) {
        ocupada = oc;
    }

    public Boolean estaOcupada() {
        return ocupada;
    }
     
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.col);
        g2d.fill(this.rec); // Fills the interior of a Shape using the settings of the Graphics2D context
        g2d.setColor(borde);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(rec);
 
    }
    
    public Rectangle2D.Float getRec() {
        return rec;
    }
}
