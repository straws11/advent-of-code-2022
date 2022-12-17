import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9 {
    public static char grid[][] = new char[1000][1000];
    public static int xCoordinate = 500;//of head
    public static int yCoordinate = 500;//of head
    public static int tyCoordinate = 500;//tail
    public static int txCoordinate = 500;//tail

    public static void main(String[] args) throws FileNotFoundException {
        //do the stuff
        System.out.println(countTailPos());
    }

    private static int countTailPos() throws FileNotFoundException {
        int total = 0;
        Scanner myReader = new Scanner(new File("src/Input9.txt"));
        grid[500][500] = '#';
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            //string manipulation
            String direction = line.substring(0,1);
            int steps = Integer.parseInt(line.substring(2));
            
            while (steps > 0) {
                step(direction);
                steps--;
            }

        }
        //count all #s in grid
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j] == '#') total++;                
            }
        }
        
        return total;
    }

    private static void step(String direction) {
        switch (direction) {
            case "R":
                //if statement covers all of the positions of tail relative to head that it should move (3 cases total, all to the left of head)
                if (tyCoordinate != yCoordinate && txCoordinate < xCoordinate) {//at the back offset
                    //move down and behind
                    tyCoordinate = yCoordinate;
                    txCoordinate++;
                    grid[tyCoordinate][txCoordinate] = '#';
                } else if (tyCoordinate == yCoordinate && txCoordinate < xCoordinate) {//right behind but not offset
                    txCoordinate++;
                    grid[tyCoordinate][txCoordinate] = '#';
                }
                xCoordinate++;//head movement
                break;

            case "L":
                if (tyCoordinate != yCoordinate && txCoordinate > xCoordinate) {//at the back offset
                    tyCoordinate = yCoordinate;
                    txCoordinate--;
                    grid[tyCoordinate][txCoordinate] = '#';
                } else if (tyCoordinate == yCoordinate && txCoordinate > xCoordinate) {//on the left behind but not offset
                    txCoordinate--;
                   grid[tyCoordinate][txCoordinate] = '#';
                }
                xCoordinate--;//head movement
                break;
        
            case "U":
                if (txCoordinate != xCoordinate && tyCoordinate > yCoordinate) {//at the bottom offset
                    txCoordinate = xCoordinate;
                    tyCoordinate--;
                    grid[tyCoordinate][txCoordinate] = '#';
                } else if (txCoordinate == xCoordinate && tyCoordinate > yCoordinate) {//right below but not offset
                    tyCoordinate--;
                    grid[tyCoordinate][txCoordinate] = '#';
                }
                yCoordinate--;//head movement
                break;
        
            case "D":
                if (txCoordinate != xCoordinate && tyCoordinate < yCoordinate) {//at the top offset
                    txCoordinate = xCoordinate;
                    tyCoordinate++;
                    grid[tyCoordinate][txCoordinate] = '#';
                } else if (txCoordinate == xCoordinate && tyCoordinate < yCoordinate) {//right above but not offset
                    tyCoordinate++;
                    grid[tyCoordinate][txCoordinate] = '#';
                }
                yCoordinate++;//head movement
                break;
            
            default:
                break;
        }
        //after switch

    }
}
