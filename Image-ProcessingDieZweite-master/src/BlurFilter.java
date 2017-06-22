import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *Verschwimmen von benachbarten pixeln miteinander
 */
public class BlurFilter extends AreaFilter {


	private int from = 0;
	private int to;
	private int radius;
	private int idx = 0;

	public BlurFilter(int radius) {
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