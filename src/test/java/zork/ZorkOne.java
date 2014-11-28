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
		setCurrentRoom("West of House");
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
		getRooms().add(southHouse());
		getRooms().add(behindHouse());
	}

	private Room behindHouse() {
		Room room = new Room("Behind House",
				"You are behind the white house. A path leads into the forest to the east. In one corner of the house there is a small window which is slightly ajar.");

		Item window = new Item("window", "With great effort, you open the window far enough to allow entry.");
		window.addProperties(CLOSED, OPENABLE, CLOSABLE);
		window.onAction("enter", "Kitchen");
		room.addItem(window);

		return room;
	}

	private Room southHouse() {
		Room room = new Room("South of House", "You are facing the south side of a white house. There is no door here, and all the windows are boarded.");

		room.setDirection("E", "Behind House");

		return room;
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

		Item mailbox = new Item("small mailbox", "Opening the small mailbox reveals a leaflet.");
		mailbox.addSynonyms("small", "mailbox", "mail-box", "box");
		mailbox.addProperties(OPENABLE, CLOSABLE, CLOSED, FIXED);
		mailbox.addItem(leaflet);
		mailbox.onAction("enter", "You hit your head against the small mailbox as you attempt this feat.");

		room.addItem(mailbox);

		Item door = new Item("door", "");
		door.addProperties(SCENERY, CLOSED);
		door.onAction("enter", "The door is locked, and there is evidently no key.");

		room.addItem(door);

		Item house = new Item(
				"white house",
				"The house is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy.");
		house.addSynonyms("house", "white");
		house.addProperties(SCENERY);
		house.onAction("enter", "I can't see how to get in from here.");
		room.addItem(house);

		room.setDirection("S", "South of House");
		room.setDirection("E", "The door is locked, and there is evidently no key.");

		return room;
	}

}
