package br.com.google.marsrover.moviment;

public class Obstacle {

    private final String description;
    private final Position position;

    public String getDescription() {
        return description;
    }

    public Position getPosition() {
        return position;
    }

    public Obstacle(Position position, String description) {
        this.position = position;
        this.description = description;
    }
}
