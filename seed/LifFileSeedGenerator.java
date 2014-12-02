package seed;

import java.io.File;

public class LifFileSeedGenerator extends SeedGenerator {

	private final File file;

	public LifFileSeedGenerator(File file) {
		this.file = file;
	}

	@Override
	protected void generateList() {

		LifFileReader lifFileReader = new LifFileReader(file);
		lifFileReader.addtoSeedGenerator(this);

	}
}
