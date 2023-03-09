package br.com.google.model.moviment.rotate;

import br.com.google.model.CardinalPoints;
import br.com.google.model.Position;

public class WestToSouth extends Rotate{


	public WestToSouth(Rotate next) {
		super(next);
	}
	
	protected Position performRotation(Position position) {
		return new Position(CardinalPoints.S, position.getX(), position.getY(), position.getNextMove());
	}
	
	@Override
	protected boolean mustRotate(Position position) {
		return position.getCardinalPoint() == CardinalPoints.W && position.getNextMove() == 'L';
	}
}
