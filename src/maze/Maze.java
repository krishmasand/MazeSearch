package maze;
import java.io.*;

public class Maze {
	Point[][] grid;
	int rows = 0;
	int columns = 0;

	Point start;
	Point end;

    /* When scanning the maze, count up the number of dots that are in the maze (for 1.3 only) */
    int dotCount = 0;

	public Maze(String name) throws FileNotFoundException, IOException{

		File file = new File(name + ".txt");
		if ( !file.exists() ){
		    System.out.println( "File does not exist" );
			return;
		}
		BufferedReader br = new BufferedReader(new FileReader(name + ".txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	
	        while (line != null) {
	        	rows++;
	        	if (rows == 1) columns = line.length();
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	    } finally {
	       br.close();
	    }
	    
	    grid = new Point[columns][rows];
	    
	    BufferedReader br2 = new BufferedReader(new FileReader(name + ".txt"));
	    try {
	        String line = br2.readLine();
	        int rowIndex = 0;
	        PointType type = null;
	        boolean startBool = false;
	        boolean endBool = false;
	
	        while (line != null) {
	        	
	        	//if (rows == 1) columns = line.length();
	        	for(int i = 0; i < columns; i++){
	        		if(line.charAt(i)=='%'){
	        			type = PointType.WALL;
	        		}
	        		else if(line.charAt(i)==' '){
	        			type = PointType.EMPTY;
	        			
	        		}
	        		else if(line.charAt(i)=='.'){
	        			type = PointType.DOT;
	        			endBool = true;
	        			dotCount++;
	        		}
	        		else if(line.charAt(i)=='P'){
	        			type = PointType.START;
	        			startBool = true;
	        		}
	        		
	        		grid[i][rowIndex] = new Point(i, rowIndex, type);
	        		if(startBool){
	        			startBool = false;
	        			start = grid[i][rowIndex];
	        		}
	        		if(endBool){
	        			endBool = false;
	        			end = grid[i][rowIndex];
	        		}
	        		

	        	}
	            line = br2.readLine();
	            rowIndex++;
	        }
	        //mazeString = sb.toString();
	    } finally {
	       br2.close();
	    }
	    	

    }
    
	public boolean validPosition(Point point){
		return (point.x >= 0 && point.y >= 0 && point.x < columns && point.y < rows);
	}
	
	
    public String toString(){
    	String ret1 = "";
		for(int j = 0; j < rows; j++){
			for(int i = 0; i < columns; i++){
				ret1+=(grid[i][j]);
			}
			ret1+="\n";
		}
    	return ret1;
    }
	
	

}
