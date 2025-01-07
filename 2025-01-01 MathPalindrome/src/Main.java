/* 
 * The following code is designed to find mathematic palindromes, ex: 121 or 876678
 * If the number is not a palidrome, the reverse of the number will be added to the number until it is a palindrome
 * There are certain numbers that cannot be 'solved' to a palindrome that this program has found, ex: 196, 295, 394
 * This goes up to 100,000 
 * The data has been saved to a separate file 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Pally> pallys = new ArrayList<>();

    public static BigInteger reverser(BigInteger x) {
        String y = x.toString();
        StringBuilder replacement = new StringBuilder();
        for (int i = y.length() - 1; i >= 0; i--) {
            replacement.append(y.charAt(i));
        }
        return new BigInteger(replacement.toString());
    }

    public static void getData() throws FileNotFoundException {
        File file = new File("lib\\data.csv");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",");
            pallys.add(new Pally(Integer.parseInt(data[0]), Integer.parseInt(data[1]), new BigInteger(data[2])));
        }
        fileScanner.close();
    }

    public static void setData() throws IOException {
        File file = new File("lib\\data.csv");
        FileWriter fileWriter = new FileWriter(file);
        for (Pally pally : pallys) {
            fileWriter.write(pally.getId() + "," + pally.getCount() + "," + pally.getPalindrome() + "\n");
        }
        fileWriter.close();
    }

    public static void testOnePally(BigInteger number, int iterations) throws Throwable {
        File file = new File("lib\\onepally.csv");
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < iterations; i++) {
            fileWriter.write(number + "\n");
            number = number.add(reverser(number));
        }
        fileWriter.close();

    }

    public static void extractNullPallys() throws IOException {
        /* 
         * pull data
         * for pallys in pally
         * look for 1001 iterations, then add it to the new csv file
         */
        getData();

        File file = new File("lib\\nullPallys.csv");
        FileWriter fileWriter = new FileWriter(file);

        for (Pally pally : pallys) {
            if (pally.getCount() == 1001) {
                fileWriter.write(pally.getId() + "\n");
            }
        }
        fileWriter.close();

    }

    public static void main(String[] args) throws Throwable {
        //testOnePally(BigInteger.valueOf(196), 100);
        //extractNullPallys();

        getData();
        int limit = 100000;
        int currentID = pallys.size() + 1; 
        while (currentID <= limit) {

            int iterations = 0;
            BigInteger result = BigInteger.valueOf(currentID);
            boolean innerExit = false;

            while (!innerExit) {
                if (iterations > 1000) {
                    result = BigInteger.valueOf(0);
                    innerExit = true;
                }

                if (result.equals(reverser(result))) {
                    innerExit = true;
                } else {
                    result = result.add(reverser(result));
                    iterations++;
                }
            }

            pallys.add(new Pally(currentID, iterations, result));
            currentID++;
        }
        setData();
    }
}
