
package entrega.taller.pkg2;

import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class panelVisualizacion extends JPanel {
    private panelStandby psb;
    private panelJuego pj;
    private static int cnt;
    private int x,y;

    public panelVisualizacion() {
       psb = new panelStandby();
       
 
       this.add(psb);
    }
   
    public void nuevaPartida(int dificultad){
        cnt = 2;
        psb.setVisible(false);
        
        pj = new panelJuego(cnt++);
        pj.generarCasilla(dificultad);
        x = pj.returnX();
        y = pj.returnY();
        
        pj.repaint();
        this.add(pj);
        this.repaint();
    }
    
    public void nuevapantalla(int dificultad){
        pj.setVisible(false);
        this.repaint();
        
        pj = new panelJuego(cnt++);
        pj.generarCasilla(dificultad);
        x = pj.returnX();
        y = pj.returnY();

        this.add(pj);
        this.repaint();
    }
    
    public void acabarPartida(){
        pj.setVisible(false);
        psb.setVisible(true);
    }
    
    public int casillaX(){
        return x;
    }
    
    public int casillaY(){
        return y;
    }
    
    public int getNivel(){
        return cnt;
    }
    
    public int dimensionTablero(){
        int aux;
        aux = pj.getDimensio();
        return aux;
    }
    
    public boolean comprovarClick(int i,int j, int x, int y){
        boolean aux = pj.click(i, j, x, y);
        return aux;
    }
    
    public Casella cojerCasilla(int i, int j){
        Casella aux = pj.getCasella(i, j);
        return aux;
    }
    
}
