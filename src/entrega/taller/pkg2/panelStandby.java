/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega.taller.pkg2;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class panelStandby extends JPanel {

    private File f;
    private String fitxerImg = "imatge/uib.gif";
    private BufferedImage img;

    private JLabel gifUIB;
    private ImageIcon IconGif;

    public panelStandby() {
        try {
            f = new File(fitxerImg);
            img = ImageIO.read(f);
        } catch (IOException ex) {

        }
        IconGif = new ImageIcon(fitxerImg);
        gifUIB = new JLabel(IconGif);
        this.add(gifUIB);
    }

    @Override
    public Dimension getPreferredSize() {
        if (gifUIB == null) {
            return new Dimension(500, 500);
        } else {
            return new Dimension(800,800);
        }
    }

}
