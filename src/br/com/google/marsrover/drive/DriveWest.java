package br.com.google.marsrover.drive;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;

public class DriveWest extends Drive {

	public DriveWest(Drive next) {
		super(next);
	}

	protected Position performDrive(Position position) {
		return new Position(position.getCardinalPoint(), position.getX() - 1, position.getY(), position.getNextMove());
	}

	@Override
	protected boolean mustDrive(Position position) {
		return position.getCardinalPoint() == CardinalPoints.W && position.getX() > 0 && position.getNextMove() == 'M';
	}

	@Override
	protected boolean checkObstacle(Position position, Position obstacle) {
		boolean rightMove = position.getCardinalPoint() == CardinalPoints.W && position.getX() > 0
				&& position.getNextMove() == 'M';

		boolean clearPathAhead = true;

		clearPathAhead = !(position.getX() - 1 == obstacle.getX() && position.getY() == obstacle.getY());

		//System.out.println(position.getPosition() + " -> " + obstacle.getPosition());

		//System.out.println("west rightMove: " + (rightMove) );
		//System.out.println("west clearPathAhead: " + (clearPathAhead) );
		return rightMove && clearPathAhead;
	}

}
