import java.awt.Color;

public class ThresholdFilter extends PixelFilter{
	
	private Color greyBottom;
	private Color greyMid;
	private Color greyTop;

	public ThresholdFilter(int greyValue) {
		this.greyBottom = new Color(greyValue, greyValue, greyValue);
	}
	
	public ThresholdFilter(int [] greyValue) {
		this.greyBottom = new Color(greyValue[0], greyValue[0], greyValue[0]);
		this.greyMid = new Color(greyValue[1], greyValue[1], greyValue[1]);
		this.greyTop = new Color(greyValue[2], greyValue[2], greyValue[2]);
	}

	/**
	 * Berechnet den Threshold anhand einer vorgegebenen Pixelhelligkeit
	 */
	@Override
	protected int calculate(int pixelColor) {
		if(greyTop == null || greyMid == null){
			greyTop = greyBottom;
			greyMid = greyBottom;			
		}
		int greyVal1 = 3*(255/4);
		int greyVal2 = 2*(255/4);
		int red = (pixelColor & 0xff);
		int green = ((pixelColor >> 8) & 0xff);
		int blue = (pixelColor >> 16) & 0xff;
		
		int brightness = (green + blue + red) /3;
		
		Color brightnessT = new Color(brightness, brightness, brightness);
		if(brightnessT.getRGB() >= greyTop.getRGB()){
			return new Color(255,255,255).getRGB();
		} else {
			if (brightnessT.getRGB() <= greyBottom.getRGB()) {
				return new Color(0, 0, 0).getRGB();
			} else {
				if (brightnessT.getRGB() >= greyMid.getRGB()) {
					return new Color(greyVal1, greyVal1, greyVal1).getRGB();
				} else {
					return new Color(greyVal2, greyVal2, greyVal2).getRGB();
				}
			}
		}
	}
}
