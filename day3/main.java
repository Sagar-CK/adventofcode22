package day3;

import java.io.*;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class main {
    private static String fileName = "day3/resources/input.txt";
    public static void main(String[] args) {
        calculatePriority(fileName);
        calculatePriorityGroup(fileName);
    }

    private static void calculatePriorityGroup(String fileName) {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            int total = 0;
            while(scanner.hasNextLine()){
                String tempLine1 = scanner.nextLine();
                String tempLine2 = scanner.nextLine();
                String tempLine3 = scanner.nextLine();
                Set<Character> set1 = setOf(tempLine1);
                set1.retainAll(setOf(tempLine2));
                set1.retainAll(setOf(tempLine3));

                List<Character> tempList = new ArrayList<>(set1);
                for(char x :  tempList){
                    total += Character.isUpperCase(x) ? (int) x - 38 : (int) x - 96;
                }
            }

            System.out.println("Total is: " + total);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * @param fileName
     */
    private static void calculatePriority(String fileName) {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            int total = 0;
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                String part1 = temp.substring(0, temp.length()/2);
                String part2 = temp.substring(temp.length()/2, temp.length());
                Set<Character> set1 = setOf(part1);
                set1.retainAll(setOf(part2));

                List<Character> tempList = new ArrayList<>(set1);
                for(char x :  tempList){
                    total += Character.isUpperCase(x) ? (int) x - 38 : (int) x - 96;
                }
            }

            System.out.println("Total is: " + total);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static Set<Character> setOf(String part1) {
        Set<Character> temp = new HashSet<Character>(part1.length());
        char[] tempList = part1.toCharArray();
        for(char x : tempList){
            temp.add(Character.valueOf(x));
        }

        return temp;
    }
}
