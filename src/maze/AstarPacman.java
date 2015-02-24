package maze;
import java.util.*;

public class AstarPacman {

    /* Data */
    public PriorityQueue<State> frontier;
    ArrayList<State> predecessor;
    public int solutionDistance;
    public int nodesExpanded;
    
    /* Constructor */
    public AstarPacman(Maze maze){
        setHeuristics(maze);
        /* Implements a priorityQueue that uses the Astar Comparator to sort its values */
        Comparator<State> comparator = new StateComparator();
        frontier    = new PriorityQueue<State>((maze.grid.length * maze.grid[1].length), comparator);
        predecessor = new ArrayList<State>();
        findSolution(maze);
        solutionDistance = getSolution();
    }

    public Point findSolution(Maze maze){
		/* Load Start Point onto Frontier. Update stuff */
    	State initial = getState(maze);
        frontier.add(initial);
        nodesExpanded = 0;
		
		/* Actual Algorithm */
        while( ! frontier.isEmpty())
        {
            Point currentPoint = frontier.remove();
            nodesExpanded++;
            predecessor.add(currentPoint);
            Vector<Point> adjacentPoints = currentPoint.getAdjacentPoints(maze);
            
			/* Loop through adjacent points and update stuff */
            for(Point point : adjacentPoints){
                if (point.pointType != PointType.WALL){
                    frontier.add(point);
                    setFrontierHeuristics(maze);
                    
                    /* Yay - Ate a dot */
                    if (point.pointType == PointType.DOT){
                        point.pointType = PointType.EMPTY; //aravind will change this to include ASCII nums/chars.
                        maze.dotCount--;
                        frontier.clear();
                        setHeuristics(maze);
                        frontier.add(point);
                    }
                    
                    /* End Condition = All dots eaten */
                    if (maze.dotCount == 0)
                        return point;
                }
            }
        }
        return null;
    }

    public int getSolution(){
        return predecessor.size();
    }

    /*public void setHeuristics(Maze maze) {
        for(int i = 0; i < maze.columns; i++) {
            for(int j = 0; j < maze.rows; j++) {
                if(maze.grid[i][j].pointType != PointType.WALL) {
                    maze.grid[i][j].pacmanHeuristic = new PacmanHeuristic(maze.grid[i][j], maze);
                }
            }
        }
    }*/
    
    /*public void setFrontierHeuristics(Maze maze){
        for(State state : frontier){
        	state.pacmanHeuristic.updatePacmanHeuristic(state, maze);
        }
    }*/
    
    public State getState(Maze maze){
		Vector<Point> points= new Vector<Point>();
		for(int i = 0; i < maze.columns; i++) {
			for(int j = 0; j < maze.rows; j++) {
				if(maze.grid[i][j].pointType == PointType.DOT) 
					points.add(maze.grid[i][j]);
			}
		}
		State state = new State(maze.start, points);
		return state;
	}
}


