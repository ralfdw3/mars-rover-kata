package br.com.google.marsrover.movement;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Movement {

    public static final int GRID_LIMIT = 10;
    public static final int ADD_ONE_GRID_POSITION = 1;

    public void moveRover(Position position, List<Obstacle> obstacles) {
        Position newPosition;

        switch (position.getCardinalPoint()) {
            case N -> newPosition = moveUpwards(position);
            case E -> newPosition = moveRight(position);
            case S -> newPosition = moveDownwards(position);
            case W -> newPosition = moveLeft(position);
            default -> throw new RuntimeException("Rover may be stuck :)");
        }
        checkForObstacles(newPosition, obstacles);
    }

    private void checkForObstacles(Position newPosition, List<Obstacle> obstacles) {
        Optional<Obstacle> obstacle = obstacles.stream()
                .filter(o -> existsObstacleWhereTheRoverWillMove(newPosition, o))
                .findFirst();

        if (obstacle.isPresent()) {
            throw new RuntimeException("Unable to move because there is and obstacle: " + obstacle.get().description());
        }
    }

    private static boolean existsObstacleWhereTheRoverWillMove(Position newPosition, Obstacle o) {
        return Objects.equals(o.position().getX(), newPosition.getX()) && Objects.equals(o.position().getY(), newPosition.getY());
    }

    private static Position moveUpwards(Position position) {
        if (position.getY() < GRID_LIMIT) {
            position.setY(position.getY() + ADD_ONE_GRID_POSITION);
            return position;
        }
        return position;
    }

    private static Position moveRight(Position position) {
        if (position.getX() < GRID_LIMIT) {
            position.setX(position.getX() + ADD_ONE_GRID_POSITION);
            return position;
        }
        return position;
    }

    private static Position moveDownwards(Position position) {
        if (position.getY() < GRID_LIMIT) {
            position.setY(position.getY() - ADD_ONE_GRID_POSITION);
            return position;
        }
        return position;
    }

    private static Position moveLeft(Position position) {
        if (position.getX() < GRID_LIMIT) {
            position.setX(position.getX() - ADD_ONE_GRID_POSITION);
            return position;
        }
        return position;
    }

    public void rotateToRight(Position position) {

        switch (position.getCardinalPoint()) {
            case N -> position.setCardinalPoint(CardinalPoints.E);
            case E -> position.setCardinalPoint(CardinalPoints.S);
            case S -> position.setCardinalPoint(CardinalPoints.W);
            case W -> position.setCardinalPoint(CardinalPoints.N);
            default -> throw new RuntimeException("Couldnt rotate the rover to the right");
        }
    }

    public void rotateToLeft(Position position) {
        switch (position.getCardinalPoint()) {
            case N -> position.setCardinalPoint(CardinalPoints.W);
            case E -> position.setCardinalPoint(CardinalPoints.N);
            case S -> position.setCardinalPoint(CardinalPoints.E);
            case W -> position.setCardinalPoint(CardinalPoints.S);
            default -> throw new RuntimeException("Couldnt rotate the rover to the left");
        }
    }
}
