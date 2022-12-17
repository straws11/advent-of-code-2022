import java.beans.Visibility;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {

    public static int trees[][] = new int[99][99];

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total visible trees: " +visibleTrees());
        System.out.println("Highest scenic score: "+ highestScenicScore());
    }
    
    private static int visibleTrees() throws FileNotFoundException {
        int total = 99*4 - 4;//entirety of outside
        readTrees();
        //for each row
        for (int row = 1; row < 98; row++) {//1 and 98 because both outside rows do not need to be considered
            //for each column
            for (int col = 1; col < 98; col++) {//1 and 98 because both outside columns do not need to be considered
                //so for each item do this:
                int visibleSides = 4;
                int curTreeHeight  = trees[row][col];
                //up
                for (int i = 0; i < row ; i++) {
                    if (trees[i][col] >= curTreeHeight) {//checking if any tree vertically in grid is same height or taller
                        visibleSides--;
                        break;
                    }
                }
                //down
                for (int i = row+1; i < 99 ; i++) {
                    if (trees[i][col] >= curTreeHeight) {//checking if any tree vertically in grid is same height or taller
                        visibleSides--;
                        break;
                    }
                }

                //left
                for (int i = 0; i < col; i++) {
                    if (trees[row][i] >= curTreeHeight) {
                        visibleSides--;
                        break;
                    }
                }
                //right
                for (int i = col+1; i < 99; i++) {
                    if (trees[row][i] >= curTreeHeight) {
                        visibleSides--;
                        break;
                    }
                }
                
                if (visibleSides>0) total++;
            }   
        }
        return total;
    }

    public static int highestScenicScore() throws FileNotFoundException {
        int highestScore = 0;
        readTrees();
        for (int row = 1; row < 98; row++) {//1 and 98 because both outside rows do not need to be considered
            //for each column
            for (int col = 1; col < 98; col++) {//1 and 98 because both outside columns do not need to be considered
                //so for each item do this:
                int scenicScore = 1;
                int distance = 1;
                int curTreeHeight  = trees[row][col];
    
                //up
                for (int i = row-1; i > -1; i--) {
                    if (trees[i][col] < curTreeHeight && i != 0) distance++;//this && solution is bad, I just don't want to improve it now, i can definitely make this better
                    else break;
                }
                scenicScore = scenicScore * distance;
                distance = 1;
                //down
                for (int i = row+1; i < 99; i++) {
                    if (trees[i][col] < curTreeHeight && i != 98) distance++;
                    else break;
                }
                scenicScore = scenicScore * distance;
                distance = 1;
                //right
                for (int i = col+1; i < 99; i++) {
                    if (trees[row][i] < curTreeHeight && i != 98) distance++;
                    else break;
                }
                scenicScore = scenicScore * distance;
                distance = 1;
                //left
                for (int i = col-1; i > -1; i--) {
                    if (trees[row][i] < curTreeHeight && i != 0) distance++;
                    else break;
                }
                scenicScore = scenicScore * distance;

                //after item is done, check against previous best
                if (scenicScore>highestScore) highestScore = scenicScore;
            }
        }

        return highestScore;
    }

    public static void readTrees() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("src/Input8.txt"));

        //fills entire array
        int row = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            for (int col = 0; col < 99; col++) {
                trees[row][col] = Integer.parseInt(line.substring(col,col+1));
            }
            row++;
        }
    }
}
