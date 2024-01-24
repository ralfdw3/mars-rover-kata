package br.com.google.marsrover.rotate;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;

public class SouthToEast extends Rotate{


	public SouthToEast(Rotate next) {
		super(next);
	}
	
	protected Position performRotation(Position position) {
		return new Position(CardinalPoints.E, position.getX(), position.getY(), position.getNextMove());
	}
	
	@Override
	protected boolean mustRotate(Position position) {
		return position.getCardinalPoint() == CardinalPoints.S && position.getNextMove() == 'L';
	}
}
