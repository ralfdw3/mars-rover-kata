# Mars Rover Kata

## Overview

This project involves developing an API that enables a rover to navigate around on a 10x10 grid. The rover is initialized with a starting point (0,0,N), where 0,0 represents the X,Y coordinates on the grid, and N is the initial direction (North). The rover can receive a sequence of commands as a char array, including rotation (L and R) and movement (M). The goal is to determine the finishing point after executing the provided commands.

## Rules

1. The initial starting point is (0,0,N).
2. The grid is 10x10, with coordinates ranging from 0 to 9 for both X and Y.
3. The rover can face North (N), South (S), East (E), or West (W).
4. Rotation commands: 
   - L: Rotate the rover 90 degrees to the left.
   - R: Rotate the rover 90 degrees to the right.
5. Movement command:
   - M: Move the rover one point in the current direction.
6. The rover receives a char array of commands, and the output is the finishing point in the format: `X:Y:Direction`.
7. If the rover reaches the end of the grid, it wraps around to the other side.
8. Obstacles may be present on the grid. If a sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle, including its coordinates and direction.

## Example

For instance, if the rover is given the command sequence `RMMLM`, the expected output might be `2:1:N`, indicating the rover's finishing point.

If the rover encounters an obstacle during its movement, the output might look like `0:2:2:N`, where 0:2:2 represents the obstacle's coordinates, and N is the rover's direction.

## Source

This Kata is inspired by the Mars Rover Tech Challenge and can be found [here](https://code.google.com/archive/p/marsrovertechchallenge/).

Feel free to explore the provided source for additional insights and challenges related to the Mars Rover problem.
