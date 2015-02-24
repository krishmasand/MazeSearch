package maze;

import java.util.Vector;

public class State {
	/* Data */
	Point startPoint;
	Vector<Point> dotsLeft;
	PacmanHeuristic pacmanHeuristic;    
    
	/* Constructor - pacmanHeuristic must be set manually */
	public State(Point startPoint, Vector<Point> dotsLeft){
		this.startPoint = startPoint;
		this.dotsLeft = new Vector<Point>(dotsLeft); //deep copy
	}
	

	// Overriding equals() to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // If the object is compared with itself then return true  
            return true;
        }
 
        /* Check if obj is an instance of State or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof State)) {
            return false;
        }
         
        /* typecast obj to State so that we can compare data members */
        State pos = (State) obj;
        return (pos.x == x && pos.y == y);
    }
}
