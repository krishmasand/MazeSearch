package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */

public class Heuristic {

    public int distanceHeuristic; // Distance is from current Point to endPoint
    public int astarHeuristic;    // Technically, for f(n) = g(n) + h(n), this starts off as h(n) but then is f(n)
    
    public Heuristic(Point point, Maze maze) {
        distanceHeuristic = Math.abs(point.x - maze.end.x) + Math.abs(point.y - maze.end.y);
        astarHeuristic = distanceHeuristic; // for f(n) = g(n) + h(n), this is h(n). Our code will add g(n) to this later.
    }
}