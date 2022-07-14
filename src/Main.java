import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer");
        listFactors(input);
    }

    //Displays all factors of a given number
    public static void listFactors(Scanner input){
        try{
            int number = input.nextInt();
            ArrayList<Integer> answer = calculateFactors(number);
            System.out.println("Factors: " + answer);
        }catch(Exception e){
            System.out.println("Input a correct integer value");
            throw new NumberFormatException("This value is not an integer");
        }
    }

    //Calculates all factors
    public static ArrayList<Integer> calculateFactors(int number)
    {
        try{
            ArrayList<Integer> factorsList = new ArrayList<Integer>();
            int absolute = number;
            if(number < 0){absolute = number * -1;}
            for(int i = 1; i <= absolute; i++ ) {
                if(number%i == 0){
                    factorsList.add(i);
                }
            }
            //handles negative number factors
            if(number < 0){
                ArrayList<Integer> negativeValues = new ArrayList<Integer>();
                factorsList.forEach(factor -> negativeValues.add(-factor));
                factorsList.addAll(negativeValues);
            }
            return factorsList;
        }catch(Exception e){
            throw e;
        }
    }
}