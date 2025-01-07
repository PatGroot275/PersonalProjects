import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner(System.in);

    public static String getString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public static String getStringLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int getInteger(String message) {
        boolean flag = true;
        int x = 0;
        while (flag) {
            flag = false;
            System.out.println(message);
            try {
                x = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("You entered something wrong, please try again");
                flag = true;
            }
        }
        return x;
    }

    public static int getIntegerinRange(int max, int min, String message) {
        boolean flag = true;
        int x = 0;
        while (flag) {
            flag = false;
            System.out.println(message);
            try {
                x = scanner.nextInt();
                if (x > max || x < min) {
                    flag = true;
                    x = 0;
                    System.out.println("You entered something wrong, please try again");
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("You entered something wrong, please try again");
                flag = true;
            }
        }
        return x;
    }

    public static boolean stringCheckLength(String input, int length) {
        if (input.length() == length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean intCheckLength(int input, int length) {
        if (String.valueOf(input).length() == length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inArrayCheckerString(String[] parameters, String input) {
        for (String element : parameters) {
            if (element.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inArrayCheckerInt(int[] parameters, int input) {
        for (int element : parameters) {
            if (element == input) {
                return true;
            }
        }
        return false;
    }

    public static String getStringInArray(String[] parameters, String message) {
        boolean flag = true;
        boolean checker = true;
        String x = "";
        while (flag) {
            flag = false;
            System.out.println(message);
            x = scanner.nextLine();
            checker = inArrayCheckerString(parameters, x);
            if (checker) {
                break;
            } else {
                flag = true;
                x = null;
                System.out.println("You entered something wrong, please try again");
            }
        }
        return x;
    }

    public static int getIndexofthinginArray(String[] parameters, String input) {
        int x = 0;
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].equalsIgnoreCase(input)) {
                return i;
            }
        }
        return x;
    }

    public static String basicTimeParser(String message) {
        scanner.nextLine();
        boolean flag = true;
        String x = "";
        while (flag) {
            flag = false;
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                Scanner specialscanner = new Scanner(input);
                specialscanner.useDelimiter(":|\\s");
                int hour = specialscanner.nextInt();
                int minute = specialscanner.nextInt();
                String amPm = specialscanner.next().toLowerCase();
                specialscanner.close();
                if (hour < 1 || hour > 12 || minute < 0 || minute > 59 || (!amPm.equals("am") && !amPm.equals("pm"))) {
                    throw new IllegalArgumentException();

                } else {
                    x = String.format("%d:%02d %s", hour, minute, amPm.toUpperCase());
                }
            } catch (Exception e) {
                System.out.println("You entered something wrong, please try again");
                flag = true;
            }
        }
        return x;
    }

    public static int intMinuteValue(String input) {
        int returnedNewTime = 0;
        Scanner specialscanner = new Scanner(input);
        specialscanner.useDelimiter(":|\\s");
        int hour = specialscanner.nextInt();
        int minute = specialscanner.nextInt();
        String amPm = specialscanner.next().toLowerCase();
        specialscanner.close();
        if (hour == 12) {
            hour = 0;
        }
        if (amPm.equals("am")) {
            returnedNewTime = (hour * 60) + minute;
        }
        if (amPm.equals("pm")) {
            returnedNewTime = 720 + (hour * 60) + minute;
        }
        return returnedNewTime;
    }

    public static int menuCreationInt(String[] choices, String input) {
        boolean flag = true;
        int x = 0;
        boolean checker;
        String output = input + "\n";
        int[] chekkee = new int[choices.length];
        for (int i = 0; i < choices.length; i++) {
            output = output + (i + 1) + ") " + choices[i] + "\n";
            chekkee[i] = i;
        }
        while (flag) {
            flag = false;
            System.out.println(output);
            try {
                x = Integer.parseInt(scanner.nextLine());
                x = x - 1;
                checker = inArrayCheckerInt(chekkee, x);
                if (checker) {
                    break;
                } else {
                    flag = true;
                    x = 0;
                    System.out.println("You entered something wrong, please try again");
                }
            } catch (Exception e) {
                flag = true;
                x = 0;
                System.out.println("You entered something wrong, please try again");
            }
        }
        return x + 1;
    }

    public static String menuCreationString(String[] choices, String input) {
        boolean flag = true;
        int x = 0;
        boolean checker;
        String output = input + "\n";
        int[] chekkee = new int[choices.length];
        for (int i = 0; i < choices.length; i++) {
            output = output + (i + 1) + ") " + choices[i] + "\n";
            chekkee[i] = i;
        }
        while (flag) {
            flag = false;
            System.out.println(output);
            try {
                x = Integer.parseInt(scanner.nextLine());
                x = x - 1;
                checker = inArrayCheckerInt(chekkee, x);
                if (checker) {
                    break;
                } else {
                    flag = true;
                    x = 0;
                    System.out.println("You entered something wrong, please try again");
                }
            } catch (Exception e) {
                flag = true;
                x = 0;
                System.out.println("You entered something wrong, please try again");
            }
        }
        return choices[x];
    }
}