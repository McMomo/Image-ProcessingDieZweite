import java.awt.Color;

public class ColorBandFilter extends PixelFilter{

	private String channel;
	
	public ColorBandFilter(String channel){
		this.channel = channel;
	}
	
	
	/**
	 * verschiebt Bitweise mit Farbmasken den gewählten Pixel im Bild
	 */
	@Override
	protected int calculate(int pixelColor) {
		

// Würde auch funktionieren
//		if(channel.equals("green")){
//			return (m  & 0xff00);
//		}
//		if(channel.equals("blue")){
//			return (m  & 0xff00) >> 8;
//		}
//		if(channel.equals("red")){
//			return (m & 0xff0000);
//		} else return 0;
		if(channel.equals("green")){
			return new Color(0, ((pixelColor >> 8) & 0xff), 0).getRGB();
			
		}
		if(channel.equals("blue")){
			
			return new Color(0, 0, ((pixelColor  >> 16) & 0xff)).getRGB();
		}
		if(channel.equals("red")){
			return new Color((pixelColor & 0xff), 0, 0).getRGB();
		} else return 0;
	}
}
