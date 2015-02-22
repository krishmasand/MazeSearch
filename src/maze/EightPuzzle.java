package maze;

import java.util.*;

public class EightPuzzle implements Comparable <Object> {


    int[] puzzle = new int[9];
    int h_n= 0;
    int hueristic_type = 0;
    int g_n = 0;
    int f_n = 0;
    EightPuzzle parent = null;


    public EightPuzzle(int[] p, int h_type, int cost)
    {
        this.puzzle = p;
        this.hueristic_type = h_type;
        this.h_n = (h_type == 1) ?  h1(p) : h2(p);
        this.g_n = cost;
        this.f_n = h_n + g_n;
    }
    public int getF_n()
    {
        return f_n;
    }
    public void setParent(EightPuzzle input)
    {
        this.parent = input;
    }
    public EightPuzzle getParent()
    {
        return this.parent;
    }

    public int inversions()
    {
                /*
                 * Definition: For any other configuration besides the goal, 
                 * whenever a tile with a greater number on it precedes a 
                 * tile with a smaller number, the two tiles are said to be inverted
                 */
        int inversion = 0;
        for(int i = 0; i < this.puzzle.length; i++ )
        {
            for(int j = 0; j < i; j++)
            {
                if(this.puzzle[i] != 0 && this.puzzle[j] != 0)
                {
                    if(this.puzzle[i] < this.puzzle[j])
                        inversion++;
                }
            }
        }
        return inversion;

    }
    public int h1(int[] list)
    // h1 = the number of misplaced tiles
    {
        int gn = 0;
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != i && list[i] != 0)
                gn++;
        }
        return gn;
    }
    public LinkedList<EightPuzzle> getChildren()
    {
        LinkedList<EightPuzzle> children = new LinkedList<EightPuzzle>();
        int loc = 0;
        int temparray[] = new int[this.puzzle.length];
        EightPuzzle rightP, upP, downP, leftP;
        while(this.puzzle[loc] != 0)
        {
            loc++;
        }
        if(loc % 3 == 0){
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc + 1];
            temparray[loc + 1] = 0;
            rightP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            rightP.setParent(this);
            children.add(rightP);

        }else if(loc % 3 == 1){
            //add one child swaps with right
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc + 1];
            temparray[loc + 1] = 0;

            rightP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            rightP.setParent(this);
            children.add(rightP);
            //add one child swaps with left
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc - 1];
            temparray[loc - 1] = 0;

            leftP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            leftP.setParent(this);
            children.add(leftP);
        }else if(loc % 3 == 2){
            // add one child swaps with left
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc - 1];
            temparray[loc - 1] = 0;

            leftP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            leftP.setParent(this);
            children.add(leftP);
        }

        if(loc / 3 == 0){
            //add one child swaps with lower
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc + 3];
            temparray[loc + 3] = 0;

            downP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);

            downP.setParent(this);

            children.add(downP);


        }else if(loc / 3 == 1 ){
            //add one child, swap with upper
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc - 3];
            temparray[loc - 3] = 0;

            upP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            upP.setParent(this);

            children.add(upP);
            //add one child, swap with lower
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc + 3];
            temparray[loc + 3] = 0;

            downP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            downP.setParent(this);

            children.add(downP);
        }else if (loc / 3 == 2 ){
            //add one child, swap with upper
            temparray = this.puzzle.clone();
            temparray[loc] = temparray[loc - 3];
            temparray[loc - 3] = 0;

            upP = new EightPuzzle(temparray, this.hueristic_type, this.g_n + 1);
            upP.setParent(this);

            children.add(upP);
        }

        return children;
    }
    public int h2(int[] list)
    // h2 = the sum of the distances of the tiles from their goal positions
    // for each item find its goal position
    // calculate how many positions it needs to move to get into that position
    {
        int gn = 0;
        int row = 0;
        int col = 0;
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != 0)
            {
                row = list[i] / 3;
                col = list[i] % 3;
                row = Math.abs(row - (i / 3));
                col = Math.abs(col - (i % 3));
                gn += row;
                gn += col;
            }

        }
        return gn;
    }
    //      public boolean puzzleCheck(EightPuzzle test){
//              for(int i = 0; i < this.puzzle.length; i++)
//              {
//                      if(this.puzzle[i] != test.puzzle[i])
//                              return false;
//              }
//              return true;
//      }
    public String toString()
    {
        String x = "";
        for(int i = 0; i < this.puzzle.length; i++){
            x += puzzle[i] + " ";
            if((i + 1) % 3 == 0)
                x += "\n";
        }
        return x;
    }
    public int compareTo(Object input) {


        if (this.f_n < ((EightPuzzle) input).getF_n())
            return -1;
        else if (this.f_n > ((EightPuzzle) input).getF_n())
            return 1;
        return 0;
    }

    public boolean equals(EightPuzzle test){
        if(this.f_n != test.getF_n())
            return false;
        for(int i = 0 ; i < this.puzzle.length; i++)
        {
            if(this.puzzle[i] != test.puzzle[i])
                return false;
        }
        return true;
    }
    public boolean mapEquals(EightPuzzle test){
        for(int i = 0 ; i < this.puzzle.length; i++)
        {
            if(this.puzzle[i] != test.puzzle[i])
                return false;
        }
        return true;
    }

}