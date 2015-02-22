package maze;

/*
Heuristic object that calculates Heuristics for A* Search and Greedy Best First Search
 */

import java.lang.*;

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
        startHeuristic = Math.abs(point.x - maze.start.x) + Math.abs(point.y - maze.end.y);
        astarHeuristic = distanceHeuristic;
        //pacmanHeuristic = pacmanHeuristic(point, maze);
    }
}

//    public int pacmanHeuristic(Point point, Maze maze) {
//        int farthestPoint = 0;
//        for(int i = 0; i < maze.columns; i++) {
//            for(int j = 0; j < maze.rows; j++) {
//                farthestPoint = Math.max(maze.grid[i][j].heuristic.distanceHeuristic, farthestPoint);
//            }
//        }
//        int numDotsleft = maze.dotCount;
//        return 0;
//    }
//
//}
