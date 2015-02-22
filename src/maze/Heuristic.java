package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */


public class Heuristic {

    public int distanceHeuristic;
    public int startHeuristic;
    public int astarHeuristic;
    public int pacmanHeuristic;

    /* this method calculates both the basic distance heuristic and the Astar Heuristic of a Point variable.
    * The distance heuristic is the distance the point is from the end, while the Astar heuristic is the sum of
    * the distance from the start to the point and the end to the point.
     */
    public Heuristic(Point point, Maze maze) {
        distanceHeuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);
        startHeuristic = Math.abs(point.x-maze.start.x) + Math.abs(point.y - maze.end.y);
        astarHeuristic = distanceHeuristic + startHeuristic;
        pacmanHeuristic = pacmanHeuristic(point, maze);
    }

    public int pacmanHeuristic(Point point, Maze maze) {
        int farthestPoint = 0;
        int numDotsLeft = maze.dotCount;
        
        for(int i = 0; i < maze.columns; i++) {
            for(int j = 0; j < maze.rows; j++) {
                farthestPoint = Math.max(maze.grid[i][j].heuristic.distanceHeuristic, farthestPoint);
            }
        }
        
        Point firstPoint;
        Point secondPoint;
        int twoPointDistance = 0;
        int currentDistance = 0; // temporary variable
        
        /* Loop Through Maze for 1st Point */
        for(int i = 0; i < maze.columns; i++){
            for(int j = 0; j < maze.rows; j++){
            	if(maze.grid[i][j].pointType == PointType.DOT){
            		firstPoint = maze.grid[i][j];
            		
            		/* Loop through maze again to find distances for firstPoint to secondPoint */
            		for (int m = 0; m < maze.columns; m++){
            			for (int n = 0; n < maze.rows; n++){
            				if (maze.grid[m][n].pointType == PointType.DOT){
            					secondPoint = maze.grid[m][n];
            					 currentDistance = manhattanDistance(firstPoint, secondPoint);
            					 if (currentDistance > twoPointDistance)
            						 twoPointDistance = currentDistance;
            				}
            			}
            		}
            	}
            }
        }
        
        return Math.max(Math.max(farthestPoint, numDotsLeft), twoPointDistance);
    }
    
    public int manhattanDistance(Point firstPoint, Point secondPoint){
    	return Math.abs(firstPoint.x - secondPoint.x) + Math.abs(firstPoint.y - secondPoint.y);
    }
}
