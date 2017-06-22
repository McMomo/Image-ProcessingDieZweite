import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *färben von pixen in einem bestimmten radius mit einer farbe
 */
public class PixelGraphicFilter extends AreaFilter {

	private int from = 0;
	private int to;
	private int radius;

	public PixelGraphicFilter(int radius) {
		this.radius = radius;

	}
	
	/**
	 * 
	 * berechnen eines Mittelwerts aller farben im gebiet
	 * rückgabe dieser farbe
	 *
	 */
	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {

		if (index == 0) {
			to = radius;
		} else if (index % radius == 0) {

			from = to;
			to += radius;

		} 

		int green = 0, blue = 0, red = 0;

		Color commonColor;

		for (int i = from; i < to; i++) {

			green += ((pixel[i] >> 8) & 0xff);
			blue += ((pixel[i]) & 0xff);
			red += ((pixel[i] >> 16) & 0xff);

		}
		
		red /= radius;
		green /= radius;
		blue /= radius;
		
		commonColor = new Color(red, green, blue);

		return commonColor.getRGB();
	}

}
