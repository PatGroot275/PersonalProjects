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

    public static void main(String[] args) throws Throwable {
        /*
         * testOnePally(BigInteger.valueOf(196), 1000);
         * System.exit(0);
         */

        getData();
        int limit = 100000; // 1 hundred thousand
        int currentID = pallys.size() + 1; // change this to be the highest point of pallys
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
            System.out.println(currentID);
        }
        setData();
    }

    // List of FAILED
    /*
     * 196
     * 295
     * 394
     * 493
     * 592
     */
}
