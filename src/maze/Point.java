package maze;

import maze.*;

public class Point {
	/* Data */
	public int x;
	public int y;
	PointType pointType;
	
	/* Standard Constructor */
	public Point(int xCoordinate, int yCoordinate, PointType type){
		x = xCoordinate;
		y = yCoordinate;
		pointType = type;
	}
	
	/* Copy Constructor */
	public Point(Point otherPoint){
		x = otherPoint.x;
		y = otherPoint.y;
		pointType = otherPoint.pointType;
	}
	
	// Overriding equals() to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // If the object is compared with itself then return true  
            return true;
        }
 
        /* Check if obj is an instance of Position or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Point)) {
            return false;
        }
         
        /* typecast obj to Position so that we can compare data members */
        Point pos = (Point) obj;
        return (pos.x == x && pos.y == y);
    }
}
