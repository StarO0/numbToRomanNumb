import java.util.Arrays;
import java.util.Scanner;

public class Main {


        public static String intToRoman(int n) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder romanNum = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                while (n >= values[i]) {
                    romanNum.append(symbols[i]);
                    n -= values[i];
                }
            }

            return romanNum.toString();
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Write yr number(0-9999): ");
            int n = scan.nextInt();
            System.out.println(n + " in roman: " + intToRoman(n));
        }
}


