package zork.dungeon;

public class Rank {

	private int score = 0;
	private int total = 350;
	private int moves = 0;
	private String rank = "Beginner";

	public int getScore() {
		return score;
	}

	public int getTotal() {
		return total;
	}

	public int getMoves() {
		return moves;
	}

	public String getRank() {
		return rank;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}