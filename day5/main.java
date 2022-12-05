package day5;
import java.util.*;
import java.io.*;


public class main{
    private static String fileName = "day5/resources/input.txt";
    public static void main(String[] args) {
        calculateMoves(fileName);
    }

    private static void calculateMoves(String fileName) {
        
        ArrayList<Character> ArrayList1 = new ArrayList<>();
        ArrayList<Character> ArrayList2 = new ArrayList<>();
        ArrayList<Character> ArrayList3 = new ArrayList<>();
        ArrayList<Character> ArrayList4 = new ArrayList<>();
        ArrayList<Character> ArrayList5 = new ArrayList<>();
        ArrayList<Character> ArrayList6 = new ArrayList<>();
        ArrayList<Character> ArrayList7 = new ArrayList<>();
        ArrayList<Character> ArrayList8 = new ArrayList<>();
        ArrayList<Character> ArrayList9 = new ArrayList<>();


        ArrayList<ArrayList> ArrayListList = new ArrayList<>(Arrays.asList(ArrayList1, ArrayList2, ArrayList3,
        ArrayList4, ArrayList5, ArrayList6, ArrayList7, ArrayList8, ArrayList9));

        try{
            Scanner scanner = new Scanner(new File(fileName));
            int i = 8;
            while(i > 0){
                String tempLine = scanner.nextLine();
                char[] tempChars = tempLine.toCharArray();

                if(tempChars[1] != ' '){
                    ArrayList1.add(0, tempChars[1]);
                }
                if(tempChars[5] != ' '){
                    ArrayList2.add(0, tempChars[5]);
                }
                if(tempChars[9] != ' '){
                    ArrayList3.add(0, tempChars[9]);
                }
                if(tempChars[13] != ' '){
                    ArrayList4.add(0,tempChars[13]);
                }
                if(tempChars[17] != ' '){
                    ArrayList5.add(0,tempChars[17]);
                }
                if(tempChars[21] != ' '){
                    ArrayList6.add(0,tempChars[21]);
                }
                if(tempChars[25] != ' '){
                    ArrayList7.add(0, tempChars[25]);
                }
                if(tempChars[29] != ' '){
                    ArrayList8.add(0, tempChars[29]);
                }
                if(tempChars[33] != ' '){
                    ArrayList9.add(0, tempChars[33]);
                }
                i--;
            }

            scanner.nextLine();
            scanner.nextLine();

            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] list = currentLine.split("\\s");

                int numLoop = Integer.parseInt(list[1]);
                int ArrayList1var = Integer.parseInt(list[3]);
                int ArrayList2var = Integer.parseInt(list[5]);

     

                ArrayList<Character> first = ArrayListList.get(ArrayList1var-1);
                ArrayList second = ArrayListList.get(ArrayList2var-1);

                ArrayList<Character> tempList = new ArrayList<>();

                while(numLoop > 0){
                    tempList.add(first.get(first.size()-1));
                    first.remove(first.size()-1);
                    numLoop--;
                }

                Collections.reverse(tempList);

                for(Character c: tempList){
                    second.add(c);
                }


                System.out.println(ArrayListList.get(0));
                System.out.println(ArrayListList.get(1));
                System.out.println(ArrayListList.get(2));
            }

            int j = 0;
            while(j <= 8){
                System.out.print(ArrayListList.get(j).get(ArrayListList.get(j).size()-1));
                j++;
            }
        }catch(FileNotFoundException e){
        }
    }
}