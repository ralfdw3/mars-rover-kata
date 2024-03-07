package br.com.google.marsrover.movement;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Movement {

    public static final int GRID_LIMIT = 10;
    public static final int ONE_GRID_POSITION = 1;

    public void moveRover(Position position, List<Obstacle> obstacles) {
        switch (position.getCardinalPoint()) {
            case N -> moveUpwards(position, obstacles);
            case E -> moveRight(position, obstacles);
            case S -> moveDownwards(position, obstacles);
            case W -> moveLeft(position, obstacles);
            default -> throw new RuntimeException("Rover may be stuck :)");
        }
    }

    private static void moveUpwards(Position position, List<Obstacle> obstacles) {
        checkForObstacles(position, obstacles);

        if (position.getY() < GRID_LIMIT) {
            position.setY(position.getY() + ONE_GRID_POSITION);
        }
    }

    private static void moveRight(Position position, List<Obstacle> obstacles) {
        checkForObstacles(position, obstacles);

        if (position.getX() < GRID_LIMIT) {
            position.setX(position.getX() + ONE_GRID_POSITION);
        }
    }

    private static void moveDownwards(Position position, List<Obstacle> obstacles) {
        checkForObstacles(position, obstacles);

        if (position.getY() < GRID_LIMIT) {
            position.setY(position.getY() - ONE_GRID_POSITION);
        }
    }

    private static void moveLeft(Position position, List<Obstacle> obstacles) {
        checkForObstacles(position, obstacles);

        if (position.getX() < GRID_LIMIT) {
            position.setX(position.getX() - ONE_GRID_POSITION);
        }
    }

    private static void checkForObstacles(Position position, List<Obstacle> obstacles) {
        Optional<Obstacle> obstacle = obstacles.stream()
                .filter(o -> existsObstacleWhereTheRoverWillMove(position, o))
                .findFirst();

        if (obstacle.isPresent()) {
            throw new RuntimeException("Unable to move because there is and obstacle: " + obstacle.get().description());
        }
    }

    private static boolean existsObstacleWhereTheRoverWillMove(Position position, Obstacle obstacle) {
        switch (position.getCardinalPoint()) {
            case N -> position.setY(position.getY() + ONE_GRID_POSITION);
            case E -> position.setX(position.getX() + ONE_GRID_POSITION);
            case S -> position.setY(position.getY() - ONE_GRID_POSITION);
            case W -> position.setX(position.getX() - ONE_GRID_POSITION);
        }

        return Objects.equals(obstacle.position().getX(), position.getX()) && Objects.equals(obstacle.position().getY(), position.getY());
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
