package entrega.taller.pkg2;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jordi
 */
public class EntregaTaller2 extends JFrame implements MouseListener, ActionListener {

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem nuevaPartidaMenu, salirMenu;
    private JButton nuevaPartidaBoton, salirBoton;

    private panelVisualizacion pv;
    private panelInfo pi;

    private BorderLayout Layout;

    private int numNiveles, nivDificultad, puntuacion, nivActual, nivRes;
    private boolean partidaCurso, anteriorFin;

    public EntregaTaller2() {
        Layout = new BorderLayout();
        setLayout(Layout);

        //Configurar y mostrar JFrame
        pv = new panelVisualizacion();
        this.add(pv, CENTER);
        
        pi = new panelInfo();
        this.add(pi,NORTH);
        pi.setVisible(true);
        
        

        //pb = new panelBotones();
        this.setTitle("KukuKube");
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EntregaTaller2.EXIT_ON_CLOSE);

        pv.addMouseListener(this);

        //Configurar y mostrar componentes
        initComponents();

    }

    private void initComponents() {

        //crear el JMenuBar
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        //Crear el JMenu y lo pasamos al JMenuBar
        menu = new JMenu("MENÚ");
        barraMenu.add(menu);

        //Creamos los objetos del JMenu
        nuevaPartidaMenu = new JMenuItem("Nueva Partida");
        menu.add(nuevaPartidaMenu);
        nuevaPartidaMenu.addActionListener(this);
        salirMenu = new JMenuItem("Salir");
        menu.add(salirMenu);
        salirMenu.addActionListener(this);

        //Panel botones
        Font fuente = new Font("Arial", Font.BOLD, 20);
        JPanel panelBotones = new JPanel();
        GridLayout Layout2 = new GridLayout(0, 2);
        panelBotones.setLayout(Layout2);

        nuevaPartidaBoton = new JButton();
        nuevaPartidaBoton.setText("NUEVA PARTIDA");
        nuevaPartidaBoton.setFont(fuente);
        nuevaPartidaBoton.setBackground(Color.black);
        nuevaPartidaBoton.setForeground(Color.WHITE);
        nuevaPartidaBoton.addActionListener(this);
        panelBotones.add(nuevaPartidaBoton);

        salirBoton = new JButton();
        salirBoton.setText("SALIR");
        salirBoton.setFont(fuente);
        salirBoton.setBackground(Color.black);
        salirBoton.setForeground(Color.WHITE);
        salirBoton.addActionListener(this);
        panelBotones.add(salirBoton);

        add(panelBotones, SOUTH);
        
    }

    public static void main(String[] args) {
        EntregaTaller2 et = new EntregaTaller2();
        et.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //si la partida esta finalizada el usuario no podra clickar en el tablero
        if(partidaCurso == false){
            return;
        }
        
        //saber la poscion donde se ha dado click
        int x = 0, y = 0, i, j = 0;
        int aux1, aux2;
        x = e.getX();
        y = e.getY();
        boolean flag = false;
        for (i = 0; i < pv.dimensionTablero() && !flag; i++) {
            for (j = 0; j < pv.dimensionTablero() && !flag; j++) {
                flag = pv.comprovarClick(i, j, x, y);
            }
        }
        i--;
        j--;
        
        //cojer esa casilla
        Casilla c = pv.cojerCasilla(i, j);
        
        //hacer las operaciones correspondientes dependiendo si es la diferente, o no
        if (c.estaOcupada()) {
            if (pv.getNivel() <= numNiveles + 1) {
                puntuacion = puntuacion + (nivActual + 1);
                nivActual++;
                nivRes =numNiveles - nivActual;
                pv.nuevapantalla(nivDificultad);
                pi.actValores(numNiveles, nivActual, nivRes, puntuacion);
            } else {
                puntuacion = puntuacion + (nivActual + 1);
                pi.actValores(numNiveles, nivActual, nivRes, puntuacion);
                JOptionPane.showMessageDialog(null, "Partida terminada con un total de " + puntuacion + " puntos" , "Fin de partida", JOptionPane.INFORMATION_MESSAGE);
                partidaCurso = false;
                anteriorFin = true;
            }

        } else {
            if (pv.getNivel() <= numNiveles + 1) {
                nivActual++;
                nivRes =numNiveles - nivActual;
                
                c.cambiarBorde(Color.red);
                
                c = pv.cojerCasilla(pv.casillaX(), pv.casillaY());
                c.cambiarBorde(Color.green);
                pv.repaint();

                JOptionPane.showMessageDialog(null, "CUADRADO SELECCIONADO ERRONEO", "FALLO", JOptionPane.ERROR_MESSAGE);
                pv.nuevapantalla(nivDificultad);
                pi.actValores(numNiveles, nivActual, nivRes, puntuacion);
            } else {
                c.cambiarBorde(Color.red);
                
                c = pv.cojerCasilla(pv.casillaX(), pv.casillaY());
                c.cambiarBorde(Color.green);
                pv.repaint();
                
                pi.actValores(numNiveles, nivActual, nivRes, puntuacion);
                
                JOptionPane.showMessageDialog(null, "Partida terminada con un total de " + puntuacion + " puntos" , "Fin de partida", JOptionPane.INFORMATION_MESSAGE);
                partidaCurso = false;
                anteriorFin = true;
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salirMenu) {
            this.dispose(); //cierra el programa
        }
        if (e.getSource() == salirBoton) {
            this.dispose(); //cierra el programa
        }
        if (e.getSource() == nuevaPartidaBoton) {
            iniciarPartida();
        }
        if(e.getSource() == nuevaPartidaMenu){
           iniciarPartida();
        }

    }
    
    private void iniciarPartida(){
        if (partidaCurso) {
                JOptionPane.showMessageDialog(null, "¡No se puede iniciar una nueva partida habiendo una en curso", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Boolean jugar = true;
                if(anteriorFin){
                    pv.acabarPartida();
                }
                if (insercióndatos(jugar)) {
                    pv.nuevaPartida(nivDificultad);
                    partidaCurso = true;
                    puntuacion = 0;
                    nivActual = 1;
                    nivRes = numNiveles-nivActual;
                    pi.actValores(numNiveles, nivActual, nivRes, puntuacion);
                }
            }
    }

    private Boolean insercióndatos(boolean aux) {
        try {
            String niveles = JOptionPane.showInputDialog(this, "Números de niveles (1-10)", "Configuración de la partida", JOptionPane.QUESTION_MESSAGE);
            String dificultad = JOptionPane.showInputDialog(this, "Dificultad de la partida (1-10)", "Configuración de la partida", JOptionPane.QUESTION_MESSAGE);

            numNiveles = Integer.parseInt(niveles);
            nivDificultad = Integer.parseInt(dificultad);

            if ((numNiveles > 10 || nivDificultad > 10) || (numNiveles < 1 || nivDificultad < 1)) {
                JOptionPane.showMessageDialog(null, "ERROR EN LA INSERCIÓN DE DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                aux = false;

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA INSERCIÓN DE DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = false;
        }

        return aux; //si se falla la insercion de datos, no se creara ningun panel de juego
    }

}
