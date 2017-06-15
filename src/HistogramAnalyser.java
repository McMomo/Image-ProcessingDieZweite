/**
 * 
 * @author moritz
 *
 *         Helligkeitswert wird berechnet. In einem Array,Helligkeitswert als
 *         Index, wird eine Stelle hochgezählt.
 * 
 */
public class HistogramAnalyser extends PixelFilter {

	public int brightPic[] = new int[256];
	public float hundretPro = 0;

	@Override
	protected int calculate(int pixelColor) {
		int green = ((pixelColor >> 8) & 0xff);
		int blue = (pixelColor >> 16) & 0xff;
		int red = (pixelColor & 0xff);

		int brightness = (green + blue + red) / 3;

		brightPic[brightness] += 1;
		hundretPro++; // zählt 100% der sterne

		return pixelColor;
	}

	/**
	 * zusammenfassen der Komponenten "Schnellwert" & "Sterne in Prozent"
	 * 
	 */
	public String toString() {
		String toPrint = "";
		String rest = "";

		for (int i = 0; i < brightPic.length; i++) {

			float starsCount = 0;
			String stars = "";

			starsCount = (100f/256f)*brightPic[i];

			//starsCount = (100f / hundretPro) * brightPic[i];

			// System.out.println(starsCount);
			if (starsCount != 0) {
				for (int j = 0; j < starsCount; j++) {
					stars += "*";
				}

				toPrint += i + ": " + stars + "\n";
			} else {
				rest+= "*";
			}
		}
		toPrint += "\nUnter 1% oder 0% \n" + rest;
		return toPrint;
	}

}