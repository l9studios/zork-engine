package zork.commands;

import org.junit.Test;

public class UnknownTest {

	@Test(expected = IllegalStateException.class)
	public void unknownHasNoSynonyms() {
		Command u = new Unknown();

		u.getSynonyms();
	}

}
