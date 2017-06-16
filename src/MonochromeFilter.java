import java.awt.Color;


/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *	Setzt das bmp auf Schwarz/Weiß
 */
public class MonochromeFilter extends PixelFilter{

	
	/**
	 * errechnen des Helligkeit & Rüggabe dieser als Farbe(Grauton)
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
