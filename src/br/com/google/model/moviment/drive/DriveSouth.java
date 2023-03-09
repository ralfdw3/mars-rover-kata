package br.com.google.model.moviment.drive;

import br.com.google.model.CardinalPoints;
import br.com.google.model.Position;

public class DriveSouth extends Drive {

	public DriveSouth(Drive next) {
		super(next);
	}

	protected Position performDrive(Position position) {
		return new Position(position.getCardinalPoint(), position.getX(), position.getY() - 1, position.getNextMove());
	}

	@Override
	protected boolean mustDrive(Position position) {
		return position.getCardinalPoint() == CardinalPoints.S && position.getY() > 0 && position.getNextMove() == 'M';

	}

	@Override
	protected boolean checkObstacle(Position position, Position obstacle) {
		boolean rightMove = position.getCardinalPoint() == CardinalPoints.S && position.getY() > 0
				&& position.getNextMove() == 'M';

		boolean clearPathAhead = true;

		clearPathAhead = !(position.getX() == obstacle.getX() && position.getY() - 1 == obstacle.getY());

		//System.out.println(position.getPosition() + " -> " + obstacle.getPosition());

		//System.out.println("south: " + (rightMove && clearPathAhead));
		//System.out.println("south rightMove: " + (rightMove) );
		//System.out.println("south clearPathAhead: " + (clearPathAhead) );
		return rightMove && clearPathAhead;
	}

}
