/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega.taller.pkg2;

import java.awt.Dimension;
import java.awt.Image;
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

        IconGif = new ImageIcon(fitxerImg);
        Image img = IconGif.getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        gifUIB = new JLabel(img2);
        this.add(gifUIB);
    }

    @Override
    public Dimension getPreferredSize() {
        if (gifUIB == null) {
            return new Dimension(500, 500);
        } else {
            return new Dimension(600, 600);
        }
    }

}
