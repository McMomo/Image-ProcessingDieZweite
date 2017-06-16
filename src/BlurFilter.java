import java.awt.Color;
import java.awt.image.BufferedImage;

public class BlurFilter extends AreaFilter {

	// private int radius;
	//
	// public BlurFilter(int radius){
	// this.radius = radius;
	// }

	private int from = 0;
	private int to;
	private int radius;
	private int idx = 0;

	public BlurFilter(int radius) {
		this.radius = radius;

	}

	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
		// #1
		// for ( int x = 0; x < width; x++ ) {
		// // Get the blur radius at x, y
		// int ra;
		// if ( blurMask != null ) {
		// if ( pass == 1 )
		// ra = (int)((mask[x] & 0xff)*hRadius/255f);
		// else
		// ra = (int)((mask[x] & 0xff)*vRadius/255f);
		// } else {
		// if ( pass == 1 )
		// ra = (int)(blurRadiusAt( x, y, width, height ) * hRadius);
		// else
		// ra = (int)(blurRadiusAt( y, x, height, width ) * vRadius);
		// }
		//

		// #2
		// if (index == 0) {
		// to = radius;
		// } else if (index % radius == 0) {
		//
		// from = to;
		// to += radius;
		//
		// }
		//
		// // berechnung des durschnittswert
		// // also der Durschnittsfarbe aller Pixel + diesem Pixel;
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

		// }


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
			// idx++; System.out.println(idx);

			return commonColor.getRGB();
		} 
	

}