import java.awt.Color;
import java.awt.image.BufferedImage;

public class BlurFilter extends AreaFilter{
	
	private int radius;
	
	public BlurFilter(int radius){
		this.radius = radius;	
	}

	
	
	
	@Override
	protected int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
//
//		for ( int x = 0; x < width; x++ ) {
//			// Get the blur radius at x, y
//			int ra;
//			if ( blurMask != null ) {
//				if ( pass == 1 )
//					ra = (int)((mask[x] & 0xff)*hRadius/255f);
//				else
//					ra = (int)((mask[x] & 0xff)*vRadius/255f);
//			} else {
//				if ( pass == 1 )
//					ra = (int)(blurRadiusAt( x, y, width, height ) * hRadius);
//				else
//					ra = (int)(blurRadiusAt( y, x, height, width ) * vRadius);
//			}
//
		return 0;
	}

}