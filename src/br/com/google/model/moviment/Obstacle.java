package br.com.google.model.moviment;

import br.com.google.model.Position;

public class Obstacle extends Position{
	
	private Position obstacle;
	
	public Obstacle(int x, int y) {
		super(x,y);
	}

	public Position getObstacle() {
		return obstacle;
	}
	
	

}
