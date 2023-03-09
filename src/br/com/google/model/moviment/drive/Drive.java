package br.com.google.model.moviment.drive;

import java.util.List;

import br.com.google.model.Position;

public abstract class Drive {

	public Drive next;

	public Drive(Drive next) {
		this.next = next;
	}

	public Position drive(Position position) {
		if (mustDrive(position)) {
			return performDrive(position);
		}
		return next.drive(position);
	}

	public Position drive(Position position, List<Position> obstacles) {
		boolean rightMove = mustDrive(position);
		boolean clearPathAhead = true;

		for (Position obstacle : obstacles) {

			clearPathAhead = checkObstacle(position, obstacle);
			
			if (!clearPathAhead)
				break;
		}

		if (rightMove && clearPathAhead)
			return performDrive(position);
		
		return next.drive(position, obstacles);
	}

	protected abstract Position performDrive(Position position);

	protected abstract boolean mustDrive(Position position);

	protected abstract boolean checkObstacle(Position position, Position obstacle);

}
