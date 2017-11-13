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
            //String guessedString = "";
            String wrongGuess = "";
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

                //guessedString +=" " + guessedLetter;

                boolean correctGuess = false;
                int fromIndex = 0;
                while (generatedName.indexOf(guessedLetter, fromIndex)!=-1){
                    correctGuess = true;
                    fromIndex = generatedName.indexOf(guessedLetter, fromIndex);
                    guessedName.setCharAt(fromIndex, guessedLetter.toCharArray()[0]);
                    fromIndex++;
                }
                if(!correctGuess){
                    wrongGuess += " " + guessedLetter;
                    guessCounter++;
                }
                System.out.println("You have guessed (" +  guessCounter + ") wrong letters: " + wrongGuess);
                if(generatedName.equals(guessedName.toString())){
                    break;
                }
            }
            if(generatedName.equals(guessedName.toString())){
                System.out.println("You win!!");
                System.out.println("Correct name is: " + generatedName);
            }
            else{
                System.out.println("You Lose!!");
                System.out.println("Correct name is: " + generatedName);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
