/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author blueashym
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int i = 1; i < 11; i++) {
            principal("img-"+i);
        }
    }
    
    
    public static void principal(String aux){
                File imageFile = new File("ImgSrc/"+aux+".png");
        BufferedImage img = null;
//        Random aleatorio = new Random(System.currentTimeMillis());

        try {
            img = ImageIO.read(imageFile);
            int x = 0, y = 0;
            double countB = 0, countW = 0, countT = 0;
            Wichmanandhill w = new Wichmanandhill();
            double Totalpixel = img.getHeight() * img.getWidth();
            double[] a = w.generar((int) (Totalpixel / 16), 12345, 34567, 56789);
            double[] b = w.generar((int) (Totalpixel / 16), 12346, 34568, 56790);
            for (int i = 0; i < (Totalpixel / 16)-1; i++) {
//                x = aleatorio.nextInt(img.getWidth());
//                y = aleatorio.nextInt(img.getHeight());
                x = (int) (a[i]*img.getWidth());
                y = (int) (b[i]*img.getHeight());
                Color c = new Color(img.getRGB(x, y));
                countB += (c.equals(Color.BLACK)) ? 1 : 0;
                countW += (c.equals(Color.WHITE)) ? 1 : 0;
                countT += (!c.equals(Color.WHITE) && !c.equals(Color.BLACK)) ? 1 : 0;

            }

            System.out.println("Aproximado para la imagen "+aux+".png:\n"
                    + "Negro: " + Math.floor((countB / (Totalpixel / 16)) * 100) + "% area aprox: "+(int)(countB * 16) +" px^2\n"
                    + "Blanco: " + Math.floor((countW / (Totalpixel / 16)) * 100) + "% area aprox: "+(int)(countW * 16) +" px^2\n"
                    + "Otro: " + Math.floor((countT / (Totalpixel / 16)) * 100) + "% area aprox: "+(int)(countT * 16) +" px^2\n");

            randomPoints(img, img.getWidth(), img.getHeight(),aux);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void randomPoints(BufferedImage image, int width, int height, String aux) {

        try {
            //Random aleatorio = new Random(System.currentTimeMillis());
            int x = 0, y = 0;
            int total = width * height;
            Wichmanandhill w = new Wichmanandhill();
            double[] a = w.generar((int) (total / 16), 12345, 34567, 56789);
            double[] b = w.generar((int) (total / 16), 12346, 34568, 56790);
            for (int i = 0; i < (total/16); i++) {
                x = (int) (a[i]*width);
                y = (int) (b[i]*height);
                image.setRGB(x, y, Color.RED.getRGB());
            }

            File ouptut = new File("output/"+aux+".png");
            ImageIO.write(image, "png", ouptut);

        } catch (Exception e) {
        }
    }

}
