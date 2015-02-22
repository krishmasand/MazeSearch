package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */

public class Heuristic {

    public int distanceHeuristic;
    public int astarHeuristic;

    
    public Heuristic(Point point, Maze maze) {
    	// Distance is from current Point to endPoint
        distanceHeuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);

        // for f(n) = g(n) + h(n), this is h(n). Our code will add g(n) to this later.
        astarHeuristic = distanceHeuristic; 
    }
}