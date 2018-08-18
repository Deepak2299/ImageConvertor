import edu.duke.*;
import java.io.*;
/**
 * Write a description of RainbowConvertor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RainbowConvertor {
    
    public ImageResource makeRainbow(ImageResource inImage) {
        //I made a blank image of the same size
        int height = inImage.getHeight();
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inpixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            
    int y = pixel.getY();
    int avg = (inpixel.getRed() + inpixel.getGreen() + inpixel.getBlue()) / 3;
    if (y < height / 7) {
      //red
      if (avg < 128) {
        pixel.setRed(2 * avg);
        pixel.setGreen(0);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(2 * avg - 255);
        pixel.setBlue(2 * avg - 255);
      }
    } else if (y < height * 2 / 7) {
      //orange
      if (avg < 128) {
        pixel.setRed(2 * avg);
        pixel.setGreen((int)(0.8 * avg));
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen((int)((1.2*avg)-51));
        pixel.setBlue(2 * avg - 255);
      }
    } else if (y < height * 3 / 7) {
      //yellow
      if (avg < 128) {
        pixel.setRed(2 * avg);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(2 * avg - 255);
      }
    } else if (y < height * 4 / 7) {
      //green
      if (avg < 128) {
        pixel.setRed(0);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      } else {
        pixel.setRed(2*avg-255);
        pixel.setGreen(255);
        pixel.setBlue(2 * avg - 255);
      }
    } else if (y < height * 5 / 7) {
      //blue
      if (avg < 128) {
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(2*avg);
      } else {
        pixel.setRed(2*avg-255);
        pixel.setGreen(2 * avg - 255);
        pixel.setBlue(255);
      }
    } else if (y < height * 6 / 7) {
      //indigo
      if (avg < 128) {
        pixel.setRed((int)(0.8 * avg));
        pixel.setGreen(0);
        pixel.setBlue(2*avg);
      } else {
        pixel.setRed((int)(1.2*avg-51));
        pixel.setGreen(2 * avg - 255);
        pixel.setBlue(255);
      }
    } else {
      //violet
      if (avg < 128) {
        pixel.setRed((int)1.6*avg);
        pixel.setGreen(0);
        pixel.setBlue((int)1.6*avg);
      } else {
        pixel.setRed((int)0.4*avg+153);
        pixel.setGreen(2 * avg - 255);
        pixel.setBlue((int)0.4*avg+153);
      }
    }

            
        }
        //outImage is your answer
        return outImage;
    }
    
    public void testrainbow() {
        ImageResource ir = new ImageResource();
        ImageResource rainbow = makeRainbow(ir);
        rainbow.draw();
    }
    
    public void saveRainbow(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource rainbow = makeRainbow(inImage);
            String file = inImage.getFileName();
            String newFile = "rainbow-" + file;
            rainbow.setFileName(newFile);
            rainbow.draw();
            rainbow.save();
        }
    }
}
