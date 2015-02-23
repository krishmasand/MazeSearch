package maze;

import java.util.Vector;

public class Point {
	/* Data */
	public int x;
	public int y;
	PointType pointType;
    Heuristic heuristic;
    PacmanHeuristic pacmanHeuristic;
    
	/* Standard Constructor */
	public Point(int xCoordinate, int yCoordinate){
		x = xCoordinate;
		y = yCoordinate;
		pointType = null;
	}
	
	/* May not need this */
	public Point(int xCoordinate, int yCoordinate, PointType type){
		x = xCoordinate;
		y = yCoordinate;
		pointType = type;
	}
	
	/* Copy Constructor */
	public Point(Point otherPoint){
		x = otherPoint.x;
		y = otherPoint.y;
		pointType = otherPoint.pointType;
	}
	
	/* Returns: WALLS, DOTS, and EMPTY spaces */
	public Vector<Point> getAdjacentPoints(Maze maze){
		Vector<Point> points = new Vector<Point>();
		
		/* Find up to 4 valid (not off the map) Positions */
		if(maze.validPosition(maze.grid[x+1][y]))
			points.add(maze.grid[x+1][y]);
		if(maze.validPosition(maze.grid[x-1][y]))
			points.add(maze.grid[x-1][y]);
		if(maze.validPosition(maze.grid[x][y+1]))
			points.add(maze.grid[x][y+1]);
		if(maze.validPosition(maze.grid[x][y-1]))
			points.add(maze.grid[x][y-1]);

		return points;
		
	}
	// Overriding equals() to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // If the object is compared with itself then return true  
            return true;
        }
 
        /* Check if obj is an instance of Position or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Point)) {
            return false;
        }
         
        /* typecast obj to Position so that we can compare data members */
        Point pos = (Point) obj;
        return (pos.x == x && pos.y == y);
    }
    
    public String toString(){
    	if(pointType == PointType.WALL){
    		return "%";
    	}
    	else if(pointType == PointType.EMPTY){
    		return " ";
    	}
    	else if(pointType == PointType.DOT){
    		return ".";
    	}
    	else if(pointType == PointType.START){
    		return "P";
    	}
    	return null;
    }
}
