package br.com.google.marsrover.drive;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;

public class DriveNorth extends Drive {

	public DriveNorth(Drive next) {
		super(next);
	}

	protected Position performDrive(Position position) {
		return new Position(position.getCardinalPoint(), position.getX(), position.getY() + 1, position.getNextMove());
	}

	@Override
	protected boolean mustDrive(Position position) {
		return position.getCardinalPoint() == CardinalPoints.N && position.getY() < 10 && position.getNextMove() == 'M';
	}

	@Override
	protected boolean checkObstacle(Position position, Position obstacle) {
		boolean rightMove = position.getCardinalPoint() == CardinalPoints.N && position.getY() < 10
				&& position.getNextMove() == 'M';

		boolean clearPathAhead = true;

		clearPathAhead = !(position.getX() == obstacle.getX() && position.getY() + 1 == obstacle.getY());

		//System.out.println(position.getPosition() + " -> " + obstacle.getPosition());

		//System.out.println("north: " + (rightMove && clearPathAhead));
		//System.out.println("north rightMove: " + (rightMove) );
		//System.out.println("north clearPathAhead: " + (clearPathAhead) );


		return rightMove && clearPathAhead;
	}

}
