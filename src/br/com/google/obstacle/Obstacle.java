package br.com.google.obstacle;

import br.com.google.marsrover.Position;

public class Obstacle extends Position {
	
	private Position obstacle;
	
	public Obstacle(int x, int y) {
		super(x,y);
	}

	public Position getObstacle() {
		return obstacle;
	}
	
	

}
