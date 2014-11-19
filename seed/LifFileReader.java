package seed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LifFileReader {

	private final File file;

	public LifFileReader(File file) {
		this.file = file;
	}

	public void addtoSeedGenerator(SeedGenerator lifFileSeedGenerator) {
		BufferedReader bufferdReader = null;
		try {
			bufferdReader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = bufferdReader.readLine()) != null) {
				if (line.startsWith("#")) {
					break;
				}
				String[] lineVariables = line.split(" ");
				if (lineVariables.length == 2) {
					int x = Integer.parseInt(lineVariables[0]);
					int y = Integer.parseInt(lineVariables[1]);
					lifFileSeedGenerator.add(x, y);
				}
			}
			bufferdReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferdReader != null) {
				try {
					bufferdReader.close();
				} catch (Throwable t) { /* ensure close happens */
				}
			}
		}
	}

}
