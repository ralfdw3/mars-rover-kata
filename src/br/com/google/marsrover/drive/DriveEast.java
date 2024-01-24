package br.com.google.marsrover.drive;

import br.com.google.marsrover.CardinalPoints;
import br.com.google.marsrover.Position;

public class DriveEast extends Drive {

	public DriveEast(Drive next) {
		super(next);
	}

	protected Position performDrive(Position position) {
		return new Position(position.getCardinalPoint(), position.getX() + 1, position.getY(), position.getNextMove());
	}

	@Override
	protected boolean mustDrive(Position position) {
		return position.getCardinalPoint() == CardinalPoints.E && position.getX() < 10 && position.getNextMove() == 'M';
	}

	@Override
	protected boolean checkObstacle(Position position, Position obstacle) {
		boolean rightMove = position.getCardinalPoint() == CardinalPoints.E && position.getX() < 10
				&& position.getNextMove() == 'M';

		boolean clearPathAhead = true;

		clearPathAhead = !(position.getX() + 1 == obstacle.getX() && position.getY() == obstacle.getY());

		//System.out.println(position.getPosition() + " -> " + obstacle.getPosition());

		//System.out.println("east: " + (rightMove && clearPathAhead));
		//System.out.println("east rightMove: " + (rightMove) );
		//System.out.println("east clearPathAhead: " + (clearPathAhead) );
		
		//System.out.println("pos x+1: " + (position.getX()+1) + " - obstacle x: " + obstacle.getX());
		//System.out.println("pos y: " + (position.getY()) + " - obstacle y: " + obstacle.getY());

		return rightMove && clearPathAhead;
	}

}
