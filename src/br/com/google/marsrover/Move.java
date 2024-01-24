package br.com.google.marsrover;

import java.util.List;

import br.com.google.marsrover.drive.DontDrive;
import br.com.google.marsrover.drive.Drive;
import br.com.google.marsrover.drive.DriveEast;
import br.com.google.marsrover.drive.DriveNorth;
import br.com.google.marsrover.drive.DriveSouth;
import br.com.google.marsrover.drive.DriveWest;
import br.com.google.marsrover.rotate.EastToNorth;
import br.com.google.marsrover.rotate.EastToSouth;
import br.com.google.marsrover.rotate.EndRotation;
import br.com.google.marsrover.rotate.NorthToEast;
import br.com.google.marsrover.rotate.NorthToWest;
import br.com.google.marsrover.rotate.Rotate;
import br.com.google.marsrover.rotate.SouthToEast;
import br.com.google.marsrover.rotate.SouthToWest;
import br.com.google.marsrover.rotate.WestToNorth;
import br.com.google.marsrover.rotate.WestToSouth;

public class Move {
	
	public Position rotate(Position position) {
		
		Rotate rotate = new NorthToEast(
				new NorthToWest(
						new EastToNorth(
								new EastToSouth(
										new SouthToEast(
												new SouthToWest(
														new WestToSouth(
																new WestToNorth(
																		new EndRotation()))))))));
				
		
		return rotate.rotate(position);
	}
	
	public Position drive(Position position) {
		
		Drive drive = new DriveNorth(
				new DriveEast(
						new DriveSouth(
								new DriveWest(
										new DontDrive()))));
		
		return drive.drive(position);
	}
	
	public Position driveWithObstacle(Position position, List<Position> obstacles) {
		
		Drive drive = new DriveNorth(
				new DriveEast(
						new DriveSouth(
								new DriveWest(
										new DontDrive()))));
		
		return drive.drive(position, obstacles);
	}

}
