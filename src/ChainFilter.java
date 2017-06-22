


import java.awt.image.BufferedImage;
/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *	verkettung mehrerer Filter miteinander
 */
public class ChainFilter implements Filter {

	private Filter filter1;
	private Filter filter2;
	private Filter aktFilter = filter1;
	private Arraylist filters;

	public ChainFilter(Filter ... filter) {
		this.filters = new Arraylist();
		this.add(filter);
	}

	@Override
	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;

		
		for(int f = 0; f < this.filters.size(); f++) {
		    images[0] = filters.get(f).process(images);
		}
		
		
		
		/*image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;

		Filter imageOut = aktFilter;
		if (image2 == null) {
			image1 = imageOut.process(image1);
		} else {
			image1 = imageOut.process(image1, image2);
		}

		if (aktFilter == filter1) {
			add(filter2);
			return process(image1);
		} else {
			return image1;
		}*/

		return images[0];
	}

	public void add(Filter ... filter) {
		for(int i = 0; i < filter.length; i++){
			this.filters.add(filter[i]);
		}
	}

}


