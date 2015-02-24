package maze;

import java.util.*;

public class State {
	/* Data */
	Point pacmanLocation;
	ArrayList<Point> dots;
	int costSoFar;
	StateHeuristic heuristic;  // Heuristic must be manually set.
    
    
	/* Constructor - Heuristic must be set manually */
	public State(Point pacmanLocation, ArrayList<Point> dots, int costSoFar){
		this.pacmanLocation = pacmanLocation;
		this.dots = new ArrayList<Point>(dots); //deep copy
		this.costSoFar = costSoFar;
	}
	
	/* Returns: WALLS, DOTS, and EMPTY spaces */
	public ArrayList<State> getAdjacentStates(Maze maze){
		ArrayList<State> states = new ArrayList<State>();
		int x = pacmanLocation.x;
		int y = pacmanLocation.y;
		State tempState;
		Point tempPacman;
		
		/* Find up to 4 valid (not off the map) Positions, that are also not walls */
		if(maze.validPosition(maze.grid[x+1][y]) && maze.grid[x+1][y].pointType != PointType.WALL){
			tempPacman = new Point(x+1, y);
			tempState = new State(tempPacman, dots, costSoFar + 1);
			if(maze.grid[x+1][y].pointType == PointType.DOT)
				tempState.dots.remove(new Point(x+1, y));
			states.add(tempState);
		}
		if(maze.validPosition(maze.grid[x-1][y]) && maze.grid[x-1][y].pointType != PointType.WALL){
			tempPacman = new Point(x-1, y);
			tempState = new State(tempPacman, dots, costSoFar + 1);
			if(maze.grid[x-1][y].pointType == PointType.DOT)
				tempState.dots.remove(new Point(x-1, y));
			states.add(tempState);
		}
		if(maze.validPosition(maze.grid[x][y+1]) && maze.grid[x][y+1].pointType != PointType.WALL){
			tempPacman = new Point(x, y+1);
			tempState = new State(tempPacman, dots, costSoFar + 1);
			if(maze.grid[x][y+1].pointType == PointType.DOT)
				tempState.dots.remove(new Point(x, y+1));
			states.add(tempState);
		}
		if(maze.validPosition(maze.grid[x][y-1]) && maze.grid[x][y-1].pointType != PointType.WALL){
			tempPacman = new Point(x, y-1);
			tempState = new State(tempPacman, dots, costSoFar + 1);
			if(maze.grid[x][y-1].pointType == PointType.DOT)
				tempState.dots.remove(new Point(x, y-1));
			states.add(tempState);
		}
		return states;
	}

	// Overriding equals() to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // If the object is compared with itself then return true  
            return true;
        }
 
        /* Check if obj is an instance of State or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof State)) return false;
         
        /* typecast obj to State so that we can compare data members */
        State pos = (State) obj;
        if(!(pos.pacmanLocation.equals(this.pacmanLocation))) return false;
        if(pos.dots.containsAll(this.dots) && this.dots.containsAll(pos.dots)) return true;
        else return false;
    }
}
