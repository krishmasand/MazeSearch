package maze;

public class StateHeuristic {
    public int heuristic;

	public StateHeuristic(State state) {
		updateStateHeuristic(state);
	}
	
	public void updateStateHeuristic(State state){
		int numDotsLeft_Heuristic = state.dots.size();
		int closestDot_Heuristic = Integer.MAX_VALUE;
		
		heuristic = closestDot_Heuristic + (numDotsLeft_Heuristic - 1);
	}
	
	private int manhattanDistance(Point firstPoint, Point secondPoint){
        return Math.abs(firstPoint.x - secondPoint.x) + Math.abs(firstPoint.y - secondPoint.y);
    }
}