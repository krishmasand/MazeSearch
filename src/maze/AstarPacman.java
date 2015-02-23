package maze;
import java.util.*;

public class AstarPacman {

    /* Data */
    public PriorityQueue<Point> frontier;
    public Vector<Point> visited;
    ArrayList<Point> predecessor;
    public int solutionDistance;
    public int nodesExpanded;
    
    /* Constructor */
    public AstarPacman(Maze maze){
        setHeuristics(maze);
        /* Implements a priorityQueue that uses the Astar Comparator to sort its values */
        Comparator<Point> comparator = new AstarPacmanComparator();
        frontier    = new PriorityQueue<Point>((maze.grid.length * maze.grid[1].length), comparator);
        visited     = new Vector<Point>();
        predecessor = new ArrayList<Point>();
        findSolution(maze);
        solutionDistance = getSolution();
    }

    public Point findSolution(Maze maze){
		/* Load Start Point onto Frontier. Update stuff */
        frontier.add(maze.start);
        visited.add(maze.start);
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
                if ((point.pointType != PointType.WALL) && !visited.contains(point)){
                    frontier.add(point);
                    visited.add(point);
                    setFrontierHeuristics(maze);
                    
                    /* Yay - Ate a dot */
                    if (point.pointType == PointType.DOT){
                        point.pointType = PointType.EMPTY; //aravind will change this to include ASCII nums/chars.
                        maze.dotCount--;
                        frontier.clear();
                        visited.clear();
                        setHeuristics(maze);
                        frontier.add(point);
                        visited.add(point);
                        
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

    public void setHeuristics(Maze maze) {
        for(int i = 0; i < maze.columns; i++) {
            for(int j = 0; j < maze.rows; j++) {
                if(maze.grid[i][j].pointType != PointType.WALL) {
                    maze.grid[i][j].pacmanHeuristic = new PacmanHeuristic(maze.grid[i][j], maze);
                }
            }
        }
    }
    
    public void setFrontierHeuristics(Maze maze){
        for(Point point : frontier){
        	point.pacmanHeuristic.updatePacmanHeuristic(point, maze);
        }
    }
}
