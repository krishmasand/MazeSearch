package maze;

public class StateHeuristic {
    public int heuristic;

	public StateHeuristic(State state) {
		updateStateHeuristic(state);
	}
	
	public void updateStateHeuristic(State state){
		int numDotsLeft_Heuristic = state.dots.size();
		heuristic = numDotsLeft_Heuristic;
	}
}