package entrega.taller.pkg2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class panelInfo extends JPanel {
    
    private JLabel nivelPartida, nivelPartidaN, nivelActual, nivelActualN, nivelesRestantes, nivelesRestantesN, puntuacion, puntuacionN;
    private Integer numPart, numAct, numRest, puntos;
    private Font Fuente;
    
    public panelInfo() {
        this.setLayout(null);
        Fuente = new Font("Arial", Font.BOLD, 13);
 
        this.setBackground(Color.BLACK);
        nivelPartida = new JLabel("NIVELES PARTIDA");
        nivelPartida.setOpaque(true);
        nivelPartida.setBackground(Color.white);
        nivelPartida.setBounds(5, 5, 150, 30);
        nivelPartida.setFont(Fuente);
        nivelPartida.setHorizontalAlignment(JLabel.CENTER);
 
        nivelActual = new JLabel("NIVEL ACTUAL");
        nivelActual.setOpaque(true);
        nivelActual.setBackground(Color.white);
        nivelActual.setBounds(5, 40, 150, 30);
        nivelActual.setFont(Fuente);
        nivelActual.setHorizontalAlignment(JLabel.CENTER);
 
        nivelPartidaN = new JLabel("000");
        nivelPartidaN.setOpaque(true);
        nivelPartidaN.setBackground(Color.white);
        nivelPartidaN.setBounds(160, 5, 40, 30);
        nivelPartidaN.setFont(Fuente);
        nivelPartidaN.setHorizontalAlignment(JLabel.CENTER);
        nivelPartidaN.setForeground(Color.red);
 
        nivelActualN = new JLabel("000");
        nivelActualN.setOpaque(true);
        nivelActualN.setBackground(Color.white);
        nivelActualN.setBounds(160, 40, 40, 30);
        nivelActualN.setFont(Fuente);
        nivelActualN.setHorizontalAlignment(JLabel.CENTER);
        nivelActualN.setForeground(Color.red);
 
        nivelesRestantes = new JLabel("NIVELES RESTANTES");
        nivelesRestantes.setOpaque(true);
        nivelesRestantes.setBackground(Color.white);
        nivelesRestantes.setBounds(285, 5, 150, 30);
        nivelesRestantes.setFont(Fuente);
        nivelesRestantes.setHorizontalAlignment(JLabel.CENTER);
 
        puntuacion = new JLabel("PUNTUACIÓN");
        puntuacion.setOpaque(true);
        puntuacion.setBackground(Color.white);
        puntuacion.setBounds(285, 40, 150, 30);
        puntuacion.setFont(Fuente);
        puntuacion.setHorizontalAlignment(JLabel.CENTER);
 
        nivelesRestantesN = new JLabel("000");
        nivelesRestantesN.setOpaque(true);
        nivelesRestantesN.setBackground(Color.white);
        nivelesRestantesN.setBounds(440, 5, 40, 30);
        nivelesRestantesN.setFont(Fuente);
        nivelesRestantesN.setHorizontalAlignment(JLabel.CENTER);
        nivelesRestantesN.setForeground(Color.red);
 
        puntuacionN = new JLabel("000");
        puntuacionN.setOpaque(true);
        puntuacionN.setBackground(Color.white);
        puntuacionN.setBounds(440, 40, 40, 30);
        puntuacionN.setFont(Fuente);
        puntuacionN.setHorizontalAlignment(JLabel.CENTER);
        puntuacionN.setForeground(Color.red);
 
        this.add(nivelPartida);
        this.add(nivelActual);
        this.add(nivelPartidaN);
        this.add(nivelActualN);
        this.add(nivelesRestantes);
        this.add(puntuacion);
        this.add(nivelesRestantesN);
        this.add(puntuacionN);
    }
    
    
    public void actValores(int nPart, int nAct, int nRest, int nPunt) {
        this.numPart = nPart;
        this.numAct = nAct;
        this.numRest = nRest;
        this.puntos = nPunt;
 
        //dependiendo de la longitud se necesita sumar 1 o 2
        String res = Integer.toString(nPart);
        if (res.length() == 1) {
            nivelPartidaN.setText("00" + res);
        } else {
            nivelPartidaN.setText("0" + res);
 
        }
        
        res = Integer.toString(nAct);
        if (res.length() == 1) {
            nivelActualN.setText("00" + res);
        } else {
            nivelActualN.setText("0" + res);
 
        }
        
        res = Integer.toString(nRest);
        if (res.length() == 1) {
            nivelesRestantesN.setText("00" + res);
        } else {
            nivelesRestantesN.setText("0" + res);
 
        }
        
        res = Integer.toString(nPunt);
        if (res.length() == 1) {
            puntuacionN.setText("00" + res);
        } else {
            puntuacionN.setText("0" + res);
 
        }
        
        this.repaint();
        
        
    }
    
    
        @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 85);

    }
    
}
