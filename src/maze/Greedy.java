package maze;
import java.util.*;

public class Greedy {

    /* Data */
    public PriorityQueue<Point> frontier;
    public Vector<Point> visited;
    Map<Point, Point> predecessor;
    public int solutionDistance;
    public int nodesExpanded;

    /* Constructor */
    public Greedy(Maze maze){
        setHeuristics(maze);
        Comparator<Point> comparator = new PointComparator();
        frontier    = new PriorityQueue<Point>((maze.grid.length * maze.grid[1].length), comparator);
        visited     = new Vector<Point>();
        predecessor = new HashMap<Point, Point>();
        Point endPoint = findSolution(maze);
        solutionDistance = getSolution(maze, endPoint);
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
            Vector<Point> adjacentPoints = currentPoint.getAdjacentPoints(maze);
		
			/* Loop through adjacent points and update stuff */
            for(Point point : adjacentPoints){
                if ((point.pointType == PointType.EMPTY || point.pointType == PointType.DOT) && !visited.contains(point)){
                    predecessor.put(point, currentPoint);
                    frontier.add(point);
                    visited.add(point);
                    if (point == maze.end)
                        return point;
                }
            }
        }
        return null;
    }

    /* Assumes the Hashmap "predecessor" has already been updated
     * - Puts Dots on solution Path
     * - Returns distance of solution
     * */
    public int getSolution(Maze maze, Point currentPoint){
        int distance = 0;
        while(predecessor.containsKey(currentPoint)) {
            distance++;

            currentPoint = predecessor.get(currentPoint);
            if(!currentPoint.equals(maze.start))		//This is so we don't have a DOT cover up the "P"
                currentPoint.pointType = PointType.DOT;

        }
        return distance;
    }

    public void setHeuristics(Maze maze) {
        for(int i = 0; i < maze.columns; i++) {
            for(int j = 0; j < maze.rows; j++) {
                if(maze.grid[i][j].pointType == PointType.EMPTY || maze.grid[i][j].pointType == PointType.DOT) {
                    maze.grid[i][j].heuristic = new Heuristic(maze.grid[i][j], maze);
                }
            }
        }
    }
}
