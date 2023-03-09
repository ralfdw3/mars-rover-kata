package br.com.google.model.moviment.rotate;

import br.com.google.model.CardinalPoints;
import br.com.google.model.Position;

public class NorthToEast extends Rotate{


	public NorthToEast(Rotate next) {
		super(next);
	}
	
	protected Position performRotation(Position position) {
		return new Position(CardinalPoints.E, position.getX(), position.getY(), position.getNextMove());
	}
	
	@Override
	protected boolean mustRotate(Position position) {
		return position.getCardinalPoint() == CardinalPoints.N && position.getNextMove() == 'R';
	}
}
