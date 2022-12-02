import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

import javax.swing.ToolTipManager;

class main{
    private static String fileName = "day2/resources/input.txt";
    public static void main(String[] args) {
        computeWinner(fileName);
        computeInverseWinner(fileName);
    }


    private static void computeInverseWinner(String fileName) {
        try{
            int totalExtraPoints = 0;
            Scanner scanner = new Scanner(new File(fileName));

            while(scanner.hasNextLine()){
                String tempLine = scanner.nextLine();
                String[] words2 = tempLine.split(" ");

                switch(words2[0]){
                    case "A":
                    // Loss => Scissors
                    if(words2[1].equals("X")) totalExtraPoints += 3;

                    // Draw
                    if(words2[1].equals("Y")) totalExtraPoints += 4;

                    // Rock and Scissors (Win)
                    if(words2[1].equals("Z")) totalExtraPoints += 8;
                    break;

                    //Paper
                    case "B":
                   // Loss + Rock
                   if(words2[1].equals("X")) totalExtraPoints += 1;

                   // Draw
                   if(words2[1].equals("Y")) totalExtraPoints += 5;

                   // Win => scissors
                   if(words2[1].equals("Z")) totalExtraPoints += 9;
                   break;


                    //Scissors
                    case "C":
                  // Loss + Paper
                  if(words2[1].equals("X")) totalExtraPoints += 2;

                  // Draw
                  if(words2[1].equals("Y")) totalExtraPoints += 6;

                  // Win + Rock
                  if(words2[1].equals("Z")) totalExtraPoints += 7;
                  break;
                }
            }

            System.out.println("Extra Points (Inverse): " +  totalExtraPoints);
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }


    /**
     * computeWinner method 
     * @param fileName
     */
    private static void computeWinner(String fileName) {
        try{
            int totalPoints = 0;
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                switch(words[1]){
                    //Rock
                    case "X":
                    // Rock and Rock
                    if(words[0].equals("A")) totalPoints += 4;

                    // Rock and Paper (Loss)
                    if(words[0].equals("B")) totalPoints += 1;

                    // Rock and Scissors (Win)
                    if(words[0].equals("C")) totalPoints += 7;
                    break;

                    //Paper
                    case "Y":
                    if(words[0].equals("A")) totalPoints += 8;

                    if(words[0].equals("B")) totalPoints += 5;

                    if(words[0].equals("C")) totalPoints += 2;
                    break;


                    //Scissors
                    case "Z":
                    if(words[0].equals("A")) totalPoints += 3;

                    if(words[0].equals("B")) totalPoints += 9;

                    if(words[0].equals("C")) totalPoints += 6;
                    break;
                }
            }

            System.out.println("Total Points: " +  totalPoints);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
