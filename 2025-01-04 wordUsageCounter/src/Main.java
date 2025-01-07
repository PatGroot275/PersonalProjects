import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("src\\input.txt");
        Scanner scanner = new Scanner(reader).useDelimiter("\\W+");

        ArrayList<Thing> things = new ArrayList<>();
        int totalWords = 0;
        int uniqueWords = 0;

        while (scanner.hasNext()) {
            String x = scanner.next().trim().toLowerCase();
            totalWords++;
            boolean found = false;
            for (Thing thing : things) {
                if (thing.getName().equals(x)) {
                    thing.setCount(thing.getCount() + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                things.add(new Thing(x, 1));
                uniqueWords++;
            }
        }

        for (int i = 1; i < things.size(); i++) {
            int j = i - 1;
            Thing temp = things.get(i);
            while (j >= 0 && things.get(j).getCount() < temp.getCount()) {
                things.set(j + 1, things.get(j));
                j = j - 1;
            }
            things.set(j + 1, temp);
        }

        FileWriter writer = new FileWriter("src\\output.txt");
        for (Thing thing : things) {
            writer.write(thing.getName() + ": " + thing.getCount() + "\n");
        }
        writer.close();
        scanner.close();
        reader.close();

        double div = uniqueWords / totalWords;
        //453?
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words:" + uniqueWords);
        System.out.println("Ratio (unique divided by total): " + div);
    }
}
