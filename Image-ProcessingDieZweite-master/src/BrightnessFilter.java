import java.awt.Color;

public class BrightnessFilter extends PixelFilter {

	private int brightness;
	
	public BrightnessFilter(int brightness) {
		this.brightness = brightness;
	}
	
	@Override
	protected int calculate(int pixelColor) {
		Color color = new Color(pixelColor);
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		

		
		if(brightness > -150 && brightness < 150){
			red += brightness;
			blue += brightness;
			green += brightness;
		}
		if(red > 255) red = 255;
		if(blue > 255) blue = 255;
		if(green > 255) green = 255;

		if(red < 0) red = 0;
		if(blue < 0) blue = 0;
		if(green < 0) green = 0;
		
		return new Color(red,green,blue).getRGB();
	}

}