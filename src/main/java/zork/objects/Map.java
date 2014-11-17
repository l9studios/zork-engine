package zork.objects;

import java.util.LinkedList;
import java.util.List;

public class Map {

	protected String welcome;
	protected List<Room> rooms = new LinkedList<Room>();
	protected List<Action> actions = new LinkedList<Action>();

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String welcome() {
		return welcome + "\n";
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}
	
	public List<Action> getActions() {
		return actions;
	}
}
