import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class PixelFilter implements Filter {
	
	public BufferedImage process(BufferedImage ... images) {
		BufferedImage image1, image2;
		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;
		int width = image1.getWidth();
        int height = image1.getHeight();
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
        		if(image2 == null || 
        				image2.getRGB(i, j) == new Color(255,255,255).getRGB()){
    				image1.setRGB(i, j, calculate(image1.getRGB(i, j)));
        		}

			}
		}
		return image1;
	}
	
	protected abstract int calculate(int pixelColor);

}
