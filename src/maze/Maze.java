package maze;
import java.io.*;

import maze.*;

public class Maze {
	Point[][] grid;
	int rows;
	int columns;

	Point start;
	Point end;
	Point currentLocation;

	public Maze(){

    }
    
	public boolean validPosition(Point point){
		return (point.x >= 0 && point.y >= 0 && point.x < columns && point.y < rows);
	}

}
