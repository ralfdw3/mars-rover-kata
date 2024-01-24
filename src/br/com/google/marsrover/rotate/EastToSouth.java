package br.com.google.marsrover.rotate;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;

public class EastToSouth extends Rotate{


	public EastToSouth(Rotate next) {
		super(next);
	}
	
	protected Position performRotation(Position position) {
		return new Position(CardinalPoints.S, position.getX(), position.getY(), position.getNextMove());
	}
	
	@Override
	protected boolean mustRotate(Position position) {
		return position.getCardinalPoint() == CardinalPoints.E && position.getNextMove() == 'R';
	}
}
