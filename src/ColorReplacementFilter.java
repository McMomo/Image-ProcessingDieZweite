import java.awt.Color;

public class ColorReplacementFilter extends PixelFilter {

	private Color color1;
	private Color color2;

	public ColorReplacementFilter(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;

	}
	
	public ColorReplacementFilter(Color color1) {
		this.color1 = color1;
		
	}
	
	/**
	 * berechnet über einen vorgegebenen Grauwert eine Helligkeit und gibt neue Farben zurück
	 */
	@Override
	protected int calculate(int pixelColor) {
		
		if (color2 == null){
			color2 = new Color((int)(Math.random()*255)+1,(int)(Math.random()*255)+1,(int)(Math.random()*255)+1);
		}
		
		
		int green = ((pixelColor >> 8) & 0xff);
		int blue = ((pixelColor) & 0xff);
		int red = ((pixelColor  >> 16) & 0xff);
		
		int brightness = (green + blue + red) /3;
		
		if (new Color(brightness,brightness,brightness).getRGB() == color1.getRGB()){
			return color2.getRGB();
		} else {
			return pixelColor;
		}

		
	
	}

}
