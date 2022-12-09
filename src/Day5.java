import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    public char stacks[][] = new char[9][50];
    public int size[] = {0,0,0,0,0,0,0,0,0};//contains current fill levels of each box stack
    
    public static void main(String[] args) {
        try {
            Day5 day = new Day5();//static nonsense has me doing this
            day.fillArrays();
            day.moveBoxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveBoxes() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("src/Input5.txt"));
        int i = 0;
        while (i<10) {//just to move past the boxes
            myReader.nextLine();
            i++;
        }
        //read all the instructions
        while (myReader.hasNext()) {
            //all the string manipulation to get values
            String line = myReader.nextLine().replace("move ","");
            int pos = line.indexOf(" ");
            int moveAmount = Integer.parseInt(line.substring(0, pos));
            //System.out.println(moveAmount);
            String line2 = line.replace(Integer.toString(moveAmount)+ " from ", "");
            int fromInt = Integer.parseInt(line2.substring(0, line2.indexOf(" ")))-1;

            String line3 = line2.replace(Integer.toString(fromInt+1)+ " to ","");
            //System.out.println(line3);
            int toInt = Integer.parseInt(line3.substring(0))-1;
            
            //System.out.println("fro" + fromInt + "to" + toInt);

            //loop down from size[x] moveamount times and move each to the right stack

                                // move 7 from 6 to 8
            int sizeThing = size[fromInt];
            for (int j = size[fromInt]-1; j >= sizeThing-moveAmount; j--) {
                stacks[toInt][ size[toInt] ] = stacks[fromInt][ j ];
                stacks[fromInt][j]= ' ';
                size[toInt]++;
                size[fromInt]--;
            }
        }
        for (char[] row : stacks) System.out.println(Arrays.toString(row));
    }

    private void fillArrays() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("src/Input5.txt"));
        //read lines to form arrays
        int i = 0;
        while (i<8) {
            String line = myReader.nextLine();
            //System.out.println(line);
            for (int j = 1; j < 37 ; j+=4) {//loops through entire textfile line and adds to each array
                //System.out.println(line.charAt(j));
                int stackPos = ((j+3)/4)-1;
                if (!(line.charAt(j) == ' ')) {
                    stacks[stackPos][size[stackPos]] = line.charAt(j);//j = boxNum*4 - 3
                    size[stackPos]++;
                }
            }
            
            i++;
        }
        for (int z = 0; z < 9; z++) reverse(stacks[z],size[z]);
        //for (char[] row : stacks) System.out.println(Arrays.toString(row));

        
    }

    static void reverse(char a[], int n)
    {
        char[] b = new char[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j--;
        }
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }


}
