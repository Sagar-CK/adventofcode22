package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main{

    private static String fileName = "day1/resources/input.txt";
    /**
     * @param args
     */
    public static void main(String[] args) {
        calculateCalories(fileName);
    }

    public static void calculateCalories(String fileName){
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int tempTotal = 0;
            int max1 = 0;
            int max2 = 0;
            int max3 = 0;
            while(scanner.hasNextLine()){
                try{
                    tempTotal += Integer.parseInt(scanner.nextLine());
                }catch(NumberFormatException e){
                    if(tempTotal > max1){
                        int temp = max2;
                        max2 = max1;
                        max3 = temp;
                        max1 = tempTotal;
                    }else if(tempTotal > max2){
                        max3 = max2;
                        max2 = tempTotal;
                    }else if(tempTotal > max3){
                        max3 = tempTotal;
                    }

                    tempTotal = 0;
                }
           

            }

            System.out.println("Total for top 3 is: " + (max1+max2+max3));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}