package zork.language;


public abstract class Preposition extends Token implements Cloneable {

	@Override
	public int getNumberOfArgs() {
		return 1;
	}

}
