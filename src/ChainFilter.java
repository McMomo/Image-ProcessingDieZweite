import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChainFilter implements Filter {
	
	private Filter filter1;
	private Filter filter2;
	
	public ChainFilter(Filter filter1, Filter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	@Override
	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;
		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;

		Filter imageOut = filter1;
		if(image2 == null ){
			image1 = imageOut.process(image1);
		} else {
			image1 = imageOut.process(image1, image2);
		}
		return process(image1, image2);

   	}

}
