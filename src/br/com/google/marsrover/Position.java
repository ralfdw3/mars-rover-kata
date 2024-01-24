package br.com.google.marsrover;

public class Position {
	
	CardinalPoints cardinalPoint;
	int x;
	int y;
	char nextMove;
	
	
	public Position(CardinalPoints cardinalPoint, int x, int y, char nextMove) {
		this.cardinalPoint = cardinalPoint;
		this.x = x;
		this.y = y;
		this.nextMove = nextMove;
	}
	
	public Position(CardinalPoints cardinalPoint, int x, int y) {
		this.cardinalPoint = cardinalPoint;
		this.x = x;
		this.y = y;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public CardinalPoints getCardinalPoint() {
		return cardinalPoint;
	}

	public char getNextMove() {
		return nextMove;
	}
	
	public void setNextMove(char nextMove) {
		this.nextMove = nextMove;
	}

	public String getPosition() {
		return this.x + " | " + this.y + " | " + this.cardinalPoint;
	}
	
}
