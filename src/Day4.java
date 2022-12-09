import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        try {
            fullContain();
            partialContain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void fullContain() throws FileNotFoundException {
        int count = 0;
        Scanner myReader = new Scanner(new File("src/Input4.txt"));

        while (myReader.hasNext()) {
            String line = myReader.nextLine();
            String firstElf = line.substring(0, line.indexOf(","));
            String secondElf = line.substring(line.indexOf(",")+1);
            //first elf range vals
            int begin1 = Integer.parseInt(firstElf.substring(0, firstElf.indexOf("-")));
            int end1 = Integer.parseInt(firstElf.substring(firstElf.indexOf("-")+1));
            //second elf range vals
            int begin2 = Integer.parseInt(secondElf.substring(0, secondElf.indexOf("-")));
            int end2 = Integer.parseInt(secondElf.substring(secondElf.indexOf("-")+1));

            if ((begin1<=begin2 && end1>=end2) || (begin2<=begin1 && end2>=end1)) {
                    count++;
            }

        }

        System.out.println(count);
    }

    public static void partialContain() throws FileNotFoundException {
        int count= 0;
        Scanner myReader = new Scanner(new File("src/Input4.txt"));

        while (myReader.hasNext()) {
            String line = myReader.nextLine();

            String firstElf = line.substring(0, line.indexOf(","));
            String secondElf = line.substring(line.indexOf(",")+1);
            //first elf range vals
            int begin1 = Integer.parseInt(firstElf.substring(0, firstElf.indexOf("-")));
            int end1 = Integer.parseInt(firstElf.substring(firstElf.indexOf("-")+1));
            //second elf range vals
            int begin2 = Integer.parseInt(secondElf.substring(0, secondElf.indexOf("-")));
            int end2 = Integer.parseInt(secondElf.substring(secondElf.indexOf("-")+1));

            for (int i = begin1; i < end1; i++) {
                if (i>=begin2 && i<=end2) {
                    System.out.println("i: "+i);

                    System.out.println(line);
                    count++;
                    break;
                }
            }

        }
        System.out.println(count);
        
    }

}
