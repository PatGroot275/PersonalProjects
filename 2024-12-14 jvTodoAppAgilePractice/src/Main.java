import java.util.ArrayList;

public class Main {
    public static ArrayList<String> array = new ArrayList<>();

    public static String[] options = { "View TODOS", "Add a TODO", "Remove a TODO" };

    public static void main(String[] args) throws Exception {
        boolean run = true;
        while (run) {

            switch (Utility.menuCreationInt(options, "Select an option:")) {
                case 1:
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println(i + 1 + ") " + array.get(i).toString());

                    }
                    break;
                case 2:
                    array.add(Utility.getStringLine("What's the content"));
                    break;
                case 3:
                    if (array.size() == 0) {
                        break;
                    }
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println(i + 1 + ") " + array.get(i).toString());

                    }
                    array.remove(Utility.getIntegerinRange(array.size(), 1, "Select one to delete") - 1);
                    break;
            }
        }
    }
}
