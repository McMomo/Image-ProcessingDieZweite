import java.awt.Color;

public class MonochromeFilter extends PixelFilter{

	/**
	 * Berechnet den Grauwert eines Bildes und gibt ein Schwarz-Weiß Bild zurück
	 */
	@Override
	protected int calculate(int pixelColor) {
		
		int green = ((pixelColor >> 8) & 0xff);
		int blue = (pixelColor >> 16) & 0xff;
		int red = (pixelColor & 0xff);
		int brightness = (green + blue + red) /3;
		
		// TODO Auto-generated method stub
		return new Color(brightness, brightness, brightness).getRGB();
	}

}
