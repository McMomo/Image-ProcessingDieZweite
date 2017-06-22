import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * 
 * @author Moritz Bantleon, Dennis Schad
 *
 *
 */
public class Controller {
	
	/**
	 * 
	 * einlesen der args
	 *
	 *
	 */
    public static void main(String[] args) {
    	
    	BufferedImage image,mask = null;
    	
    	try {
			image = ImageIO.read(new File(args[1]));
			if(args[2].equalsIgnoreCase("-m")){
				mask = ImageIO.read(new File(args[3]));
			}
			if (args[0].equals("test")){
				getFilter(args[0], args);
			}else{
			Filter imageOut = getFilter(args[0], args);
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
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    /**
     * 
     * Map mit den verschieden Filtern
     *
     *
     */
    public static Filter getFilter(String chosenFilter , String [] args){
    	
    	
		int [] threshArr = {64, 128, 192};
	
		HashMap<String, Filter> filter = new HashMap<String, Filter>();
    	
    	
    
		//Pixel Filter
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
		
		//Area Filter
		filter.put("blur_3", new BlurFilter(3));
		filter.put("blur_5", new BlurFilter(5));
		filter.put("pixel_20", new PixelGraphicFilter(20));
		filter.put("pixel_40", new PixelGraphicFilter(40));
		filter.put("pixel_60", new PixelGraphicFilter(60));
		
		//Histogramm
		filter.put("histogram", new HistogramAnalyser());
		
		//Kombi-filter
		filter.put("colorhistogram_red", new ChainFilter(new ColorBandFilter("red"),new HistogramAnalyser()));
		filter.put("colorhistogram_green", new ChainFilter(new ColorBandFilter("green"),new HistogramAnalyser()));
		filter.put("colorhistogram_blue", new ChainFilter(new ColorBandFilter("blue"),new HistogramAnalyser()));
		filter.put("warhol", new ChainFilter(new ThresholdFilter(threshArr), new ColorReplacementFilter(new Color(255,255,255)), new ColorReplacementFilter(new Color(2*(255/4),2*(255/4),2*(255/4))),new ColorReplacementFilter(new Color(3*(255/4),3*(255/4),3*(255/4))))); 
		//Überschreiben des bildes ist das Problem
		//filter.put("warhol", new ChainFilter(new ThresholdFilter(threshArr), new ColorReplacementFilter(new Color(3*(255/4),3*(255/4),3*(255/4))))); 
		filter.put("brightness_100", new BrightnessFilter(100));
		filter.put("brightness_minus100", new BrightnessFilter(-100));
		
		
		if (chosenFilter.equalsIgnoreCase("test")){
    		testFilter(filter, args);
    		
    	}
    	
		
		return filter.get(chosenFilter);
		
		

	}
    
    public static void testFilter(HashMap<String, Filter> filter, String [] args){
    	BufferedImage image,mask = null;
    	String outPutName ="";
    	
    	Iterator iterator = filter.entrySet().iterator();
    	while (iterator.hasNext()) {
    		 
    	    Map.Entry aktFilter = (Map.Entry)iterator.next();
        	
        	try {
    			image = ImageIO.read(new File(args[1]));
    			if(args[2].equalsIgnoreCase("-m")){
    				mask = ImageIO.read(new File(args[3]));
    			}
 
    			Filter imageOut = getFilter(aktFilter.getKey().toString(), args);
    			

    			System.out.println(imageOut.toString());
    			//System.out.println(aktFilter.getKey().toString());
    			
    		
    			ImageIO.write(filter.get(aktFilter.getKey().toString()).process(image, mask), "bmp", new File("outPutImage" + "_" + aktFilter.getKey().toString() + ".bmp"));
    			 
    			
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		 
    	}
    	
    }
    
}

