package seed;


public class BlockSeedGenerator extends SeedGenerator {

	@Override
	protected void generateList() {
		add(10, 10);
		add(10, 11);
		add(11, 10);
		add(11, 11);

	}

}
