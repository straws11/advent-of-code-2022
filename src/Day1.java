import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Input1.txt");
        Scanner myReader = new Scanner(file);
        
        try {
            System.out.println("Max Cals");
            getMaxCalories(myReader);
            System.out.println("Total Top 3 Cals");
            getTop3Calories();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getMaxCalories(Scanner myReader) throws Exception {
         //read file
         int total = 0;
         int largest = 0;
         myReader.reset();
         while (myReader.hasNextLine()) {
             String line = myReader.nextLine();
             if (!line.equals("")) {
                 //is NOT blank line
                 total+= Integer.valueOf(line);
 
             } else {//reset var
                 if (total>largest) largest = total;
                 total = 0;
             }
         }
         System.out.println(largest);    
    }

    static void getTop3Calories() throws Exception {
        int total = 0;
        int largest[] = {0,0,0};
        File file = new File("src/Input1.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if (!line.equals("")) {
                //is NOT blank line
                total+= Integer.valueOf(line);

            } else {//reset var
                for (int i = 0; i < largest.length; i++) {
                    if (total>largest[i]) {
                        for (int j = largest.length-1; j < i; j--) {
                            largest[j] = largest[j-1]; 
                        }
                        largest[i] = total;
                        break;
                    }
                }
                total = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < largest.length; i++) {
            sum+=largest[i];
        }
        System.out.println(sum);             
    }
}
