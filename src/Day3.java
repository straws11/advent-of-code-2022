import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
  public static void main(String[] args) {
    try {
        sumPriorities();
        sumGroupPriorities();
    } catch (Exception e) {
        e.printStackTrace();
    }
  } 

   static void sumPriorities() throws FileNotFoundException {
        File file = new File("src/Input3.txt");
        Scanner myReader = new Scanner(file);
        int total = 0;
        int priority;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String container1 = line.substring(0, (line.length()/2));
            String container2 = line.substring(line.length()/2);
            priority = 0;
            outerloop:
            for (int i = 0; i < container1.length(); i++) {
                for (int j = 0; j < container2.length(); j++) {
                    if (container1.charAt(i)==container2.charAt(j)) {
                        //get priority value of this item
                        priority = getPriority(container1.charAt(i));
                        total+=priority;
                        break outerloop;
                    }  
                }
            }
        
        }
        System.out.println(total);
    }

   static void sumGroupPriorities() throws FileNotFoundException {
    File file = new File("src/Input3.txt");
    Scanner myReader = new Scanner(file);
    int total = 0;
    int priority;

    while (myReader.hasNextLine()) {
        String group[] = {
            myReader.nextLine(),
            myReader.nextLine(),
            myReader.nextLine()
        };

        outerloop:
        for (int i = 0; i < group[0].length(); i++) {
            for (int j = 0; j < group[1].length(); j++) {
                if (group[0].charAt(i) == group[1].charAt(j)) {
                    for (int k = 0; k < group[2].length(); k++) {
                        if (group[0].charAt(i) == group[2].charAt(k)) {//match in all 3
                            System.out.println(group[0].charAt(i));
                            priority = getPriority(group[0].charAt(i));
                            System.out.println(priority);
                            total+=priority;
                            break outerloop;
                        }
                    }
                }
                
            }
            
        }
    }



    System.out.println(total);
   }

   static int getPriority(char c) {
    int priority;
    if (Character.toLowerCase(c) == c) {//if already lowercase
        priority = (int) c - 96;
    } else {
        priority = (int) c - 38;
    }
    return priority;
    }

}
