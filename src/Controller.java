import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class Controller {

    public static void main(String[] args) {
    	
    	BufferedImage image,mask = null;
    	
    	try {
			image = ImageIO.read(new File(args[1]));
			if(args[2].equalsIgnoreCase("-m")){
				mask = ImageIO.read(new File(args[3]));
			}
			
			Filter imageOut = getFilter(args[0]);
			if(mask == null ){
				image = imageOut.process(image);
			} else {
				image = imageOut.process(image, mask);
			}

			System.out.println(imageOut.toString());
			
			if(args[2].equalsIgnoreCase("-m")){
				ImageIO.write(image, "bmp", new File(args[4]));
			} else {
				ImageIO.write(image, "bmp", new File(args[2]));
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    public static Filter getFilter(String chosenFilter){
    	
		int [] threshArr = {64, 128, 192};
	
		HashMap<String, Filter> filter = new HashMap<String, Filter>();
		filter.put("blur_3", new BlurFilter(3));
		filter.put("blur_5", new BlurFilter(5));
		filter.put("monochrom", new MonochromeFilter());
		filter.put("colorband_red", new ColorBandFilter("red"));
		filter.put("colorband_green", new ColorBandFilter("green"));
		filter.put("colorband_blue", new ColorBandFilter("blue"));
		filter.put("threshold_128", new ThresholdFilter(128));
		filter.put("threshold_192", new ThresholdFilter(192));
		filter.put("multithreshold", new ThresholdFilter(threshArr));
		filter.put("colorreplacement_64", new ColorReplacementFilter(new Color(64,64,64)));
		filter.put("colorreplacement_128", new ColorReplacementFilter(new Color(128,128,128)));
		filter.put("colorreplacement_192", new ColorReplacementFilter(new Color(192,192,192)));
		filter.put("pixel_20", new PixelGraphicFilter(20));
		filter.put("pixel_40", new PixelGraphicFilter(40));
		filter.put("pixel_60", new PixelGraphicFilter(60));
		filter.put("histogram", new HistogramAnalyser());
		filter.put("warhol", new ChainFilter(new ThresholdFilter(threshArr), new ColorReplacementFilter(new Color(3*(255/4),3*(255/4),3*(255/4)))));
		filter.put("colorhistogram_green", new HistogramAnalyser());
		filter.put("colorhistogram_blue", new HistogramAnalyser());
		
		return filter.get(chosenFilter);
		
		

	}
    
}

