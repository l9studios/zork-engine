package zork;

import static zork.game.Property.CLOSABLE;
import static zork.game.Property.CLOSED;
import static zork.game.Property.FIXED;
import static zork.game.Property.OPENABLE;
import static zork.game.Property.READABLE;
import static zork.game.Property.SCENERY;
import static zork.game.Property.TAKEABLE;
import zork.game.Game;
import zork.game.Item;
import zork.game.Room;

public class ZorkOne extends Game {

	public ZorkOne() {
		setVersion("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n"
				+ "Revision 88 / Serial number 840726\n");
		addGlobalItems();
		addRooms();
	}

	private void addGlobalItems() {
		Item player = new Item("me", "That's difficult unless your eyes are prehensile.");
		player.addSynonyms("cretin", "myself");
		getGlobalItems().add(player);

		Item ground = new Item("ground", "There's nothing special about the ground.");
		ground.addSynonyms("sand", "earth", "here", "hole");
		getGlobalItems().add(ground);
	}

	private void addRooms() {
		getRooms().add(westHouse());
	}

	private Room westHouse() {
		Room room = new Room("West of House",
				"This is an open field west of a white house, with a boarded front door.\nThere is a small mailbox here.");

		Item leaflet = new Item(
				"leaflet",
				"    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n"
						+ "    Zork was created at the MIT Laboratory for Computer Science by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.  It was inspired by the Adventure game of Crowther and Woods, and the long tradition of fantasy and science fiction games.\n"
						+ "    On-line information may be obtained with the command HELP (synonyms are ABOUT, INFO, HINT, etc.).");
		leaflet.addProperties(TAKEABLE, READABLE);

		Item mailbox = new Item("small mailbox", "There is a small mailbox here.");
		mailbox.addSynonyms("small", "mailbox", "mail-box", "box");
		mailbox.addProperties(OPENABLE, CLOSABLE, CLOSED, FIXED);
		mailbox.addItem(leaflet);

		room.addItem(mailbox);

		Item door = new Item("door", "The door is closed.");
		door.addProperties(SCENERY, CLOSED);

		room.addItem(door);

		Item house = new Item(
				"white house",
				"The house is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy.");
		house.addSynonyms("house", "white");
		house.addProperties(SCENERY);
		room.addItem(house);

		setCurrentRoom(room.getName());

		return room;
	}

}
