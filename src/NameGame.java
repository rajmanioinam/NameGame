import java.io.File;
import java.util.Scanner;

public class NameGame {
    public static void main(String[] args){
        System.out.println("Name Game!!");

        try{
            File file = new File("NameGameList");
            Scanner scanner = new Scanner(file);
            String[] nameList = new String[10];
            int nameIndex = 0;
            while(scanner.hasNextLine()){
                nameList[nameIndex] = scanner.nextLine();
                nameIndex++;
            }
            int randomIndex = (int)(Math.random()*10);
            String generatedName = nameList[randomIndex];
            String guessedString = "";
            StringBuilder guessedName = new StringBuilder();
            System.out.println(generatedName);
            for (int i= 0; i<generatedName.length();i++) {
                guessedName.append("_");
            }
            System.out.println("You are guessing " + guessedName.toString() + "");

            int guessCounter = 0;
            while(guessCounter<5){
                System.out.println("Guess a letter: ");
                Scanner guess = new Scanner(System.in);
                String guessedLetter = guess.nextLine();
                guessedString +=" " + guessedLetter;
                System.out.println("You have guess " + guessedString);
                //StringBuilder myName = new StringBuilder("_____");
                //myName.setCharAt(4, 'x');
                //System.out.println(myName);
                guessCounter++;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
