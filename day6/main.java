package day6;
import java.util.*;
import java.util.stream.Stream;
import java.io.*;


public class main{
    private static String fileName = "day6/resources/input.txt";
    public static void main(String[] args) {
        calculateMarkers(fileName);
        
    }

    /**
     * @param fileName
     */
    private static void calculateMarkers(String fileName) {
        try{
            Scanner scanner = new Scanner(new File( fileName));

            char[] temp = scanner.nextLine().toCharArray();
            int total = 0;

            for(int i = 0; i < temp.length-14; i++){
                char[] temp2 = Arrays.copyOfRange(temp, i, i+14);
                List<Character> charList = new ArrayList<>();
                for(char c: temp2){
                    charList.add(c);
                }
                int count = charList.stream().distinct().toList().size();

                if(count == 14){
                    System.out.println(i+14);
                    return;
                }
                
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
       
    }
}