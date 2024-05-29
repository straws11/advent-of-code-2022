import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10 {
    public static int cycleTracker = 20;
    public static int cycle = 0;
  public static void main(String[] args) throws FileNotFoundException {
    //do code
    System.out.println(sumSignalStrength());
  } 

  public static int sumSignalStrength() throws FileNotFoundException {
    Scanner myReader = new Scanner(new File("src/Input10.txt"));
    int total = 0;
    int register = 1;
    while (myReader.hasNextLine()) {
        String line = myReader.nextLine();
        if (line.substring(0, 4).equals("noop")) {
            cycle++;
            total+=checkCycle(register);
        } else if (line.substring(0, 4).equals("addx")) {
            int addAmt = Integer.parseInt(line.substring(5));
            cycle++;
            total+=checkCycle(register);
            cycle++;
            total+=checkCycle(register);
            register+= addAmt;
        }
    
    }

    return total;
  }

    private static int checkCycle(int register) {
        if (cycleTracker <= 220) {
            if (cycle == cycleTracker){
                System.out.println(register);
                cycleTracker+=40; //increase to next value that I should check for
                return register * (cycleTracker-40);
            }
        }
        return 0;
    }

}
