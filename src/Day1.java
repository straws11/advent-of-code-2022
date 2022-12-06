import java.io.File;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws Exception {
        //read file
        File file = new File("src/Input.txt");
        Scanner myReader =  new Scanner(file);
        
        int total = 0;
        int largest = 0;
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

}
