package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.validation.Validator;

public class main {

    private static String fileName = "day4/resources/input.txt";
    public static void main(String[] args) {
        pairCalculate(fileName);
        overlapCalculate(fileName);
    }


    private static void overlapCalculate(String fileName2) {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            int total = 0;
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                String[] values = temp.split("\\W");
                int lowerBound1 = Integer.parseInt(values[0]);
                int upperBound1 = Integer.parseInt(values[1]);
                int lowerBound2 = Integer.parseInt(values[2]);
                int upperBound2 = Integer.parseInt(values[3]);
                if((upperBound1 >= upperBound2 && lowerBound1 <= upperBound2)|| (lowerBound1 <= lowerBound2 && upperBound1 >= lowerBound2)){
                    total += 1;
                }else if((upperBound2 >= upperBound1 && lowerBound2 <= upperBound1 )|| (lowerBound2 <= lowerBound1 && upperBound2 >= lowerBound1 )){
                    total +=1;
                }
            }

            System.out.println("Total Overlapping is " + total);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    private static void pairCalculate(String fileName) {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            int total = 0;
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                String[] values = temp.split("\\W");
                int lowerBound1 = Integer.parseInt(values[0]);
                int upperBound1 = Integer.parseInt(values[1]);
                int lowerBound2 = Integer.parseInt(values[2]);
                int upperBound2 = Integer.parseInt(values[3]);
                if(upperBound1 >= upperBound2 && lowerBound1 <= lowerBound2){
                    total += 1;
                }else if(upperBound2 >= upperBound1 && lowerBound2 <= lowerBound1){
                    total +=1;
                }
            }

            System.out.println("Total Containing is " + total);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
