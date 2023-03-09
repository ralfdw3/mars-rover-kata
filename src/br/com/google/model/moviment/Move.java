package br.com.google.model.moviment;

import java.util.List;

import br.com.google.model.Position;
import br.com.google.model.moviment.drive.DontDrive;
import br.com.google.model.moviment.drive.Drive;
import br.com.google.model.moviment.drive.DriveEast;
import br.com.google.model.moviment.drive.DriveNorth;
import br.com.google.model.moviment.drive.DriveSouth;
import br.com.google.model.moviment.drive.DriveWest;
import br.com.google.model.moviment.rotate.EastToNorth;
import br.com.google.model.moviment.rotate.EastToSouth;
import br.com.google.model.moviment.rotate.EndRotation;
import br.com.google.model.moviment.rotate.NorthToEast;
import br.com.google.model.moviment.rotate.NorthToWest;
import br.com.google.model.moviment.rotate.Rotate;
import br.com.google.model.moviment.rotate.SouthToEast;
import br.com.google.model.moviment.rotate.SouthToWest;
import br.com.google.model.moviment.rotate.WestToNorth;
import br.com.google.model.moviment.rotate.WestToSouth;

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
