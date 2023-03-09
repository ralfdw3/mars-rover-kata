package br.com.google.model.moviment.rotate;

import br.com.google.model.Position;

public class EndRotation extends Rotate{
	
	public EndRotation() {
		super(null);
	}
	
	protected Position performRotation(Position position) {
		return position;
	}
	
	@Override
	protected boolean mustRotate(Position position) {
		return true;
	}



}
