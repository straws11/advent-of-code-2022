import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        try {
            initialCalc();
            correctCalc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void correctCalc() throws FileNotFoundException {
        int totalScore = 0;
        int lineScore;
        File file = new File("src/Input2.txt");
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            //System.out.println((int) line.charAt(2)-87);
            //lineScore = ((int) line.charAt(0)) - 64 + 3 * (((int) line.charAt(2)) - 87 - 1);
            lineScore=0;
            switch (line) {
                case "A X":
                    lineScore+=3;
                    break;
                case "A Y":
                    lineScore+=4;
                    break;
                case "A Z":
                    lineScore+=8;
                    break;
                case "B X":
                    lineScore+=1;
                    break;
                case "B Y":
                    lineScore+=5;
                    break;
                case "B Z":
                    lineScore+=9;
                    break;
                case "C X":
                    lineScore+=2;
                    break;
                case "C Y":
                    lineScore+=6;
                    break;
                case "C Z":
                    lineScore+=7;
                    break;
            
                default:
                    break;
            }


            System.out.println(lineScore);
            totalScore+=lineScore;
        }

        System.out.println("Total Correct Score: " + totalScore);
    }

    static void initialCalc() throws FileNotFoundException {
        int totalScore = 0;
        int lineScore;
        File file = new File("src/Input2.txt");
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            lineScore = 0;
            switch (line.charAt(2)) {
                case 'X'://rock
                    lineScore+=1;
                    switch (line.charAt(0)) {
                        case 'A'://rock
                            lineScore+=3;
                            break;
                        case 'B'://paper
                            lineScore+=0;
                            break;
                        case 'C'://scissors
                            lineScore+=6;
                            break;
                        default:
                            break;
                    }
                    break;
                case 'Y'://paper
                    lineScore+=2;
                    switch (line.charAt(0)) {
                        case 'A'://rock
                            lineScore+=6;
                            break;
                        case 'B'://paper
                            lineScore+=3;
                            break;
                        case 'C'://scissors
                            lineScore+=0;
                            break;
                        default:
                            break;
                    }
                    break;
                case 'Z'://scissors
                    lineScore+=3;
                    switch (line.charAt(0)) {
                        case 'A'://rock
                            lineScore+=0;
                            break;
                        case 'B'://paper
                            lineScore+=6;
                            break;
                        case 'C'://scissors
                            lineScore+=3;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
           /* char compareChar = (char) ((int) line.charAt(0)+23);
            if (compareChar=='[') compareChar = 'X';//rock beats scissors
            int compareResult = Character.compare(line.charAt(2),compareChar);

            if (compareResult==0) lineScore = lineScore + 3;//tie
                else if (compareResult>0) lineScore = lineScore + 6;//win
                else lineScore = lineScore + 0;//lose*/
            totalScore = totalScore + lineScore;
        }
        System.out.println(totalScore);
    }
}
