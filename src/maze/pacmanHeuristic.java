package maze;


public class PacmanHeuristic {
    public int pacmanHeuristic;

	public PacmanHeuristic(Point point, Maze maze) {
		updatePacmanHeuristic(point, maze);
	}
	
	public void updatePacmanHeuristic(Point point, Maze maze){
		int numDotsLeft_Heuristic;
		int farthestDot_Heuristic;
		int twoDotDistance_Heuristic;
		
        numDotsLeft_Heuristic = maze.dotCount;
        farthestDot_Heuristic = calculateFarthestDot(point, maze);
        twoDotDistance_Heuristic = calculateTwoDotDistance(maze);
        
        pacmanHeuristic = Math.max(Math.max(numDotsLeft_Heuristic, farthestDot_Heuristic), twoDotDistance_Heuristic);
	}
	
	private int manhattanDistance(Point firstPoint, Point secondPoint){
        return Math.abs(firstPoint.x - secondPoint.x) + Math.abs(firstPoint.y - secondPoint.y);
    }
    
    private int calculateFarthestDot(Point currentPoint, Maze maze){
        int farthestDot = 0;
        for(int i = 0; i < maze.columns; i++){
            for(int j = 0; j < maze.rows; j++){
            	farthestDot = Math.max(manhattanDistance(currentPoint, maze.grid[i][j]), farthestDot);
            }
        }
        return farthestDot;
    }
    
    private int calculateTwoDotDistance(Maze maze){
        Point firstPoint;
        Point secondPoint;
        int result = 0;
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
                                if (currentDistance > result)
                                    result = currentDistance;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}