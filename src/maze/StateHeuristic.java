package maze;

public class StateHeuristic {
    public int heuristic;

	public StateHeuristic(State state) {
		updateStateHeuristic(state);
	}
	
	public void updateStateHeuristic(State state){
		int numDotsLeft_Heuristic = state.dots.size();
		int closestDot_Heuristic = Integer.MAX_VALUE;
        closestDot_Heuristic = findClosestDot(state);
		heuristic = closestDot_Heuristic + (numDotsLeft_Heuristic - 1);
	}
	
	private int manhattanDistance(Point firstPoint, Point secondPoint){
        return Math.abs(firstPoint.x - secondPoint.x) + Math.abs(firstPoint.y - secondPoint.y);
    }

    private int findClosestDot(State state) {
        int temp = Integer.MAX_VALUE;
        for(Point point: state.dots) {
            temp = Math.min(manhattanDistance(point, state.pacmanLocation), temp);
        }
        return temp;
    }
}