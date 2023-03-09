package br.com.google.model.moviment.rotate;

import br.com.google.model.Position;

public abstract class Rotate {
	
	public Rotate next;
	
	public Rotate(Rotate next) {
		this.next = next;
	}
	
	public Position rotate(Position position) {
		if(mustRotate(position)) {
			return performRotation(position);
		}
		return next.rotate(position);
	}
	
	protected abstract Position performRotation(Position position);
	protected abstract boolean mustRotate(Position position);

}
