import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class PixelGraphicFilter extends AreaFilter {

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> master
	private int radius;
	
	public PixelGraphicFilter(int radius){
		this.radius = radius;	
	}
	@Override
	public BufferedImage process(BufferedImage ... images) {
		// TODO Auto-generated method stub
		return null;
=======
	
	private int from = 0;
	private int to;
	private int radius;
	
	public PixelGraphicFilter(int radius){
		this.radius = radius;
		to = radius;
>>>>>>> Stashed changes
	}
	

	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
		System.out.println(Arrays.toString(pixel));
		
		
		
		//berechnung des durschnittswert
		int valueNum = 0;
		Color valueCol;
		for (int i = 0; from < to; from++ ){
			int green = ((pixel[from] >> 8) & 0xff);
			int blue = (pixel[from] >> 16) & 0xff;
			int red = (pixel[from] & 0xff);
			
			int brightness = (green + blue + red) /3;

			valueNum += brightness;
		}
		valueNum = valueNum/radius;
		valueCol = new Color(valueNum,valueNum,valueNum);
		
		return valueCol.getRGB();
	}

}
