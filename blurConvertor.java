import edu.duke.*;
import java.io.*;
/**
 * Write a description of blurConvertor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blurConvertor {
    public int ensureInImage (int coordinate, int size) {
    // coordinate cannot be negative
        if (coordinate < 0) {
            return 0;
        }
        // coordinate must be in range [0 .. size-1]
        if (coordinate >= size) {
            return size - 1;
        }
        return coordinate;
    }
    
    public Pixel  getPixelNearby (ImageResource image,int x,int y,int diameter) {
        int dx = (int)(Math.random() * diameter - diameter / 2);
        int dy = (int)(Math.random() * diameter - diameter / 2);
        int nx = (int)ensureInImage(x + dx, image.getWidth());
        int ny = (int)ensureInImage(y + dy, image.getHeight());
        return image.getPixel(nx, ny);
    }
    
    public ImageResource makeBlur(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        //change to blur1
        //for(Pixel pixel : inImage.pixels()){
        //change to blur2  
        for(Pixel pixel : outImage.pixels()){
            int x = pixel.getX();
            int y = pixel.getY();
            if (Math.random() > 0.5) {
                Pixel other = getPixelNearby(inImage, x, y, 5);
                outImage.setPixel(x, y, other);
            }
            else {
                outImage.setPixel(x, y, pixel);
            }
        
        }
    
    
    
    
        return outImage;
    }
    
    public void testBlur() {
        ImageResource ir = new ImageResource();
        ImageResource blur = makeBlur(ir);
        blur.draw();
    }
    
    public void saveBlur(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource blur = makeBlur(inImage);
            String file = inImage.getFileName();
            //String newFile = "blur-" + file;
            String newFile = "blur1-" + file;
            blur.setFileName(newFile);
            blur.draw();
            blur.save();
        }
    }

}
