package zork.game;

import java.util.LinkedList;
import java.util.List;

public class Game {

	private String version;
	private String currentRoom;
	private List<Room> rooms = new LinkedList<Room>();
	private List<Item> inventory = new LinkedList<Item>();
	private List<Item> globalItems = new LinkedList<Item>();
	private Stats stats = new Stats();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public Stats getStats() {
		return stats;
	}

	public List<Item> getGlobalItems() {
		return globalItems;
	}
}
