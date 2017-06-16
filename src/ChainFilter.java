import java.awt.image.BufferedImage;

public class ChainFilter implements Filter {
	
	private Filter filter1;
	private Filter filter2;
	private Filter aktFilter = filter1;
	
	public ChainFilter(Filter filter1, Filter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
		this.aktFilter = filter1;
	}
	
	/**
	 * Rekursive Funktion zum verwenden zweier Filter auf das gleiche Bild
	 */
	@Override
	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;

		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;

		Filter imageOut = aktFilter;
		if(image2 == null ){
			image1 = imageOut.process(image1);
		} else {
			image1 = imageOut.process(image1, image2);
		}
		if(aktFilter == filter1){
			add(filter2);
			return process(image1);
		} else {
			return image1;
		}

   	}
	
	public void add(Filter filter){
		aktFilter = filter;
	}

}
