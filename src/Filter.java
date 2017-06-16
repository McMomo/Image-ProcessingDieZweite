import java.awt.image.BufferedImage;
/**
 * filter Interface
 * @author Dennis, Moritz
 *
 */
public interface Filter {
	public BufferedImage process(BufferedImage ... images);
	

}
