
/**
 * Write a description of ImageInversionConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class ImageInversionConverter {
      public ImageResource makeInversion(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            int Red = 255-inPixel.getRed();
            int Green = 255-inPixel.getGreen();
            int Blue = 255-inPixel.getBlue();
            //set pixel's red to average
            pixel.setRed(Red);
            //set pixel's green to average
            pixel.setGreen(Green);
            //set pixel's blue to average
            pixel.setBlue(Blue);
        }
        //outImage is your answer
        return outImage;
    }
    
    public void testInversion() {
        ImageResource ir = new ImageResource();
        ImageResource inversion = makeInversion(ir);
        inversion.draw();
    }
    
    public void saveInversion(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource inversion = makeInversion(inImage);
            String file = inImage.getFileName();
            String newFile = "inverted-" + file;
            inversion.setFileName(newFile);
            inversion.draw();
            inversion.save();
        }
    }
}
