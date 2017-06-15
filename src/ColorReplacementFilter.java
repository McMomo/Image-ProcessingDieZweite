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

	@Override
	protected int calculate(int pixelColor) {
		
		if (color2 == null){
			color2 = new Color((int)(Math.random()*255)+1,(int)(Math.random()*255)+1,(int)(Math.random()*255)+1);
		}
		
		
		int green = ((pixelColor >> 8) & 0xff);
		int blue = (pixelColor >> 16) & 0xff;
		int red = (pixelColor & 0xff);
		
		int brightness = (green + blue + red) /3;
		int col1Bright = (color1.getBlue()+color1.getGreen()+color1.getRed())/3;
		int col2Bright = (color2.getBlue()+color2.getGreen()+color2.getRed())/3;
		int colBright = (col1Bright+col2Bright)/2;
		
		Color colValue = new Color(colBright,colBright, colBright);
		Color value = new Color (brightness,brightness,brightness);
		
		if (value.getRGB() >= colValue.getRGB()){
			return color1.getRGB();
		} else {
			return color2.getRGB();
		}
		
		
	
	}

}
