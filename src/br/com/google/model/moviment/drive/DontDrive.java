package br.com.google.model.moviment.drive;

import br.com.google.model.Position;

public class DontDrive extends Drive{
	
	public DontDrive() {
		super(null);
	}
	
	protected Position performDrive(Position position) {
		return position;
	}
	
	@Override
	protected boolean mustDrive(Position position) {
		return true;
	}

	@Override
	protected boolean checkObstacle(Position position, Position obstacles) {
		return true;
	}

}
