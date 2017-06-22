import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *	Methode für Filter welche bestimmte gebite bearbeiten nicht nur einzelne Pixel
 */
public abstract class AreaFilter implements Filter {

	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;
		
		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;
		
		int width = images[0].getWidth();
		int height = images[0].getHeight();
		int index = 0;

		int[] pixels = new int[width * height];
		int[] maskPixels = new int[width * height];
		
		pixels = copy(image1, pixels, width, height);
		if (image2 == null) {
			System.out.println("keine Maske vorhanden");
		} else {
			maskPixels = copy(image2, maskPixels, width, height);
		}
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (image2 == null ||image2.getRGB(i, j) == new Color(255, 255, 255).getRGB()) {

					
					image1.setRGB(i, j, calculate(pixels, maskPixels, index, width, height));
					index++;
				}
			}
		}
		return image1;
	}

	protected abstract int calculate(int[] pixel, int[] maskPixel, int index, int width, int height);

	
	/**
	 * kopieren eines bmps
	 * 
	 * 
	 * @param image
	 * @param array
	 * @param width
	 * @param height
	 * @return
	 */
	public int[] copy(BufferedImage image, int[] array, int width, int height) {
		int idx = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				array[idx] = image.getRGB(i, j);
				idx++;
			}
		}

		return array;
	}
}
