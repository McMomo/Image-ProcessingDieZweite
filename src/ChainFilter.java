
//
//#1 Dennis
//
import java.awt.image.BufferedImage;

public class ChainFilter implements Filter {

	private Filter filter1;
	private Filter filter2;
	private Filter filter3;
	private Filter filter4;
	private Filter aktFilter = filter1;

	public ChainFilter(Filter filter1, Filter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
		this.aktFilter = filter1;
	}

	public ChainFilter(Filter filter1, Filter filter2, Filter filter3, Filter filter4) {
		this.filter1 = filter1;
		this.filter2 = filter2;
		this.filter3 = filter3;
		this.filter4 = filter4;
		this.aktFilter = filter1;
	}

	@Override
	public BufferedImage process(BufferedImage... images) {
		BufferedImage image1, image2;

		image1 = (images.length > 0) ? images[0] : null;
		image2 = (images.length > 1) ? images[1] : null;

		Filter imageOut = aktFilter;
		if (image2 == null) {
			image1 = imageOut.process(image1);
		} else {
			image1 = imageOut.process(image1, image2);
		}

		if (filter4 != null) {
			add(filter1);
			add(filter2);
			add(filter3);
			add(filter4);
		}

		if (aktFilter == filter1) {
			add(filter2);
			return process(image1);
		} else {
			return image1;
		}

	}

	public void add(Filter filter) {
		aktFilter = filter;
	}

}

// #2
//import java.awt.image.BufferedImage;
//
//public class ChainFilter implements Filter {
//
//	private Filter filterChain[];
//	private BufferedImage image1, image2;
//
//	public ChainFilter(Filter[] filterChain) {
//		this.filterChain = filterChain;
//	}
//
//	@Override
//	public BufferedImage process(BufferedImage... images) {
//
//		image1 = (images.length > 0) ? images[0] : null;
//		image2 = (images.length > 1) ? images[1] : null;
//
//		for (int i = 0; i < filterChain.length;i++) {
//			image1 = add(filterChain[i]);
//		}
//
//		return image1;
//	}
//
//	public BufferedImage add(Filter filter) {
//		if (image2 != null){
//		image1 = filter.process(image1, image2);
//		}else {
//		image1 = filter.process(image1);
//			
//		}
//		return image1;
//	}
//
//}
