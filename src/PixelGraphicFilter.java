import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class PixelGraphicFilter extends AreaFilter {

	private int from = 0;
	private int to;
	private int radius;

	public PixelGraphicFilter(int radius) {
		this.radius = radius;

	}

	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
		//System.out.println(Arrays.toString(pixel));
		//System.out.println(radius);
		if (index == 0) {
			to = radius;
		} else if (index % radius == 0) {

			from = to;
			to += radius;

		}

		// berechnung des durschnittswert
		// also der Durschnittsfarbe aller Pixel + diesem Pixel;
//		int valueNum = 0;
//		Color valueCol;
//		for (int i = 0; from < to; from++) {
//			int green = ((pixel[from] >> 8) & 0xff);
//			int blue = (pixel[from] >> 16) & 0xff;
//			int red = (pixel[from] & 0xff);
//
//			int brightness = (green + blue + red) / 3;
//
//			valueNum += brightness;
//		}
//		valueNum = valueNum / radius;
//		valueCol = new Color(valueNum, valueNum, valueNum);
//
//		return valueCol.getRGB();
		int green = 0, blue = 0, red = 0;
		
		Color commonColor;
		for (int i = 0; from < to; from++) {
			green += ((pixel[from] >> 8) & 0xff);
			blue += (pixel[from] >> 16) & 0xff;
			red += (pixel[from] & 0xff);

			

			
		}
		red /= radius; green /= radius; blue /= radius;
		//System.out.println(red +" "+green+" "+blue);
		commonColor = new Color(red, green, blue);

		return commonColor.getRGB();
	}

}
