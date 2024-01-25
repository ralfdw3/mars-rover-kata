package br.com.google.marsrover.moviment;

public class Obstacle extends Position {

    private String description;

    public String getDescription() {
        return description;
    }

    public Obstacle(Position position, String description) {
        super(position.getCardinalPoint(), position.getX(), position.getY());
        this.description = description;
    }
}
