import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        //do code
        findStart(4);
        findStart(14);
    }

    static void findStart(int length) throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("src/Input6.txt"));
        String line = myReader.nextLine();

        int i = length-1;//keeps track of end position of the string being looked at
        boolean dupe = false;
        boolean found = false;
        int lineSize = line.length();
        while (i<lineSize && !found) {
            //String feed = line.substring(0, i);
            //System.out.println(line.substring(i-3, i+1));
            outerloop:
            for (int j = i-length+1; j < i+1; j++) {//loop through all chars in string being looked at
                for (int k = j+1; k < i+1; k++) {//loop through all chars excl first one to check for dupee
                  //  System.out.println("compare"+line.charAt(j)+"with"+line.charAt(k));
                    if (line.charAt(j) == line.charAt(k)) {//if a duplicate exists
                        i++;
                        dupe = true;//invalidates that there are no dupes
                        break outerloop;
                    }     
                }
            }
            if (!dupe) {
                System.out.println("Found at position: "+(i+1) + " for size " + length);
                found = true;
            } else dupe = false;
        }
    }
}
