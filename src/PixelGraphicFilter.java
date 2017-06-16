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
		// System.out.println(Arrays.toString(pixel));
		// System.out.println(radius);

		// #1
		// if (index == 0) {
		// to = radius;
		// } else if (index % radius == 0) {
		//
		// from = to;
		// to += radius;
		// berechnung des durschnittswert
		// also der Durschnittsfarbe aller Pixel + diesem Pixel;
		// nur schwarz weiß klappt aber auch nicht
		// int valueNum = 0;
		// Color valueCol;
		// for (int i = 0; from < to; from++) {
		// int green = ((pixel[from] >> 8) & 0xff);
		// int blue = (pixel[from] >> 16) & 0xff;
		// int red = (pixel[from] & 0xff);
		//
		// int brightness = (green + blue + red) / 3;
		//
		// valueNum += brightness;
		// }
		// valueNum = valueNum / radius;
		// valueCol = new Color(valueNum, valueNum, valueNum);
		//
		// return valueCol.getRGB();

		// #2
		// berechnung des durschnittswert
		// also der Durschnittsfarbe aller Pixel + diesem Pixel;
		// Nur vereinzelnte Pixel gefärbt aber jetzt mit farbe
		// if (index == 0) {
		// to = radius;
		// } else if (index % radius == 0) {
		//
		// from = to;
		// to += radius;
		//
		// int green = 0, blue = 0, red = 0;
		//
		// Color commonColor;
		// for (int i = 0; from < to; from++) {
		// green += ((pixel[from] >> 8) & 0xff);
		// blue += (pixel[from] >> 16) & 0xff;
		// red += (pixel[from] & 0xff);
		//
		//
		//
		//
		// }
		// System.out.println("pre: "+red +" "+green+" "+blue);
		// red /= radius; green /= radius; blue /= radius;
		// System.out.println("after: "+red +" "+green+" "+blue);
		// commonColor = new Color(red, green, blue);
		//
		// return commonColor.getRGB();
			
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
		// System.out.println("pre: " + red + " " + green + " " + blue);
		red /= radius;
		green /= radius;
		blue /= radius;
		// System.out.println("after: " + red + " " + green + " " + blue);
		commonColor = new Color(red, green, blue);

		return commonColor.getRGB();
	}

}
