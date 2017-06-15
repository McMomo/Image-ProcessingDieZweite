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

	public BlurFilter(int radius) {
		this.radius = radius;

	}

	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
		//
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
		if (index == 0) {
			to = radius;
		} else if (index % radius == 0) {

			from = to;
			to += radius;

		}

		// berechnung des durschnittswert
		// also der Durschnittsfarbe aller Pixel + diesem Pixel;
		int valueNum = 0;
		Color valueCol;
		for (int i = 0; from < to; from++) {
			int green = ((pixel[from] >> 8) & 0xff);
			int blue = (pixel[from] >> 16) & 0xff;
			int red = (pixel[from] & 0xff);

			int brightness = (green + blue + red) / 3;

			valueNum += brightness;
		}
		valueNum = valueNum / radius;
		valueCol = new Color(valueNum, valueNum, valueNum);

		return valueCol.getRGB();

	}

}