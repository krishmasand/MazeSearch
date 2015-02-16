package maze;
import java.util.*;

public class BFS {

	/* Data */
	public Queue<Point> frontier;
	public Vector<Point> visited;
	Map<Point, Point> predecessor = new HashMap<Point, Point>();
	public int solutionDistance;
	
	/* Constructor */
	public BFS(Maze maze){
		Point endPoint = findSolution(maze);
		solutionDistance = getSolutionsDistance(endPoint);
	}
	
	public Point findSolution(Maze maze){
		/* Load Start Point onto Frontier */
		frontier.add(maze.start);
		visited.add(maze.start);
		
		/* Actual Algorithm */
		while( ! frontier.isEmpty())
		{
			Point currentPoint = frontier.remove();
			Vector<Point> adjacentPoints = currentPoint.getAdjacentPoints(maze);
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
	
	/* Assumes the Hashmap "predecessor" has already been updated */
	public int getSolutionsDistance(Point currentPoint){
		int distance = 0;
		while(predecessor.containsKey(currentPoint)) {
			currentPoint = predecessor.get(currentPoint);
			distance++;
		}
		return distance;
	}
}
