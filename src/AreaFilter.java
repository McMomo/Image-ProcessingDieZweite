import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class AreaFilter implements Filter{
	
	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;
		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;
		int width = images[0].getWidth();
        int height = images[0].getHeight();
        int index = 0;
        int[] pixels = new int[width*height];
        int[] maskPixels = new int[width*height];
        for (int i = 0; i < width; i++ ) {
        	for(int j = 0; j < height; j++){
        		if(image2 == null || 
        				image2.getRGB(i, j) == new Color(255,255,255).getRGB()){
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
        			
>>>>>>> Stashed changes
=======
>>>>>>> master
        			image1.setRGB(i, j, calculate(pixels, maskPixels, index, width, height));
                	
        		}
        	}
        }
        return image1;
	}

	
	protected abstract int calculate(int [] pixel, int [] maskPixel, 
			int index, int width, int height);

}
