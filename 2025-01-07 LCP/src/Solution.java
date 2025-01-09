import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String[] words = { "mass", "as", "hero", "superhero" };
        List<String> res = XstringMatching(words);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    public static List<String> stringMatching(String[] words) {
        List<String> results = new ArrayList<>(words.length);
        // i is the checker
        // j is the subject the checker is being compared to
        for (int i = 0; i < words.length; i++) {
            char[] checker = stringToChar(words[i]);
            for (int j = 0; j < words.length; j++) {
                char[] subject = stringToChar(words[j]);
                if (i == j) {
                    break;
                }
                if (checker.length >= subject.length) {
                    break;
                }
                int checkLength = 0;
                // for each character START
                for (int k = 0; k < subject.length; k++) {
                    for (int k2 = 0; k2 < checker.length; k2++) {
                        if (k2 + k == subject.length - 1) {
                            break;
                        }
                        if (checker[k2] == subject[k + k2]) {
                            checkLength++;
                        }
                    }
                    if (checkLength == checker.length) {
                        results.set(i, words[i]);
                        break;
                    }
                }
                // resultss

            }
        }

        return results;
    }

    public static List<String> XstringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static char[] stringToChar(String x) {
        char[] arr = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            arr[i] = x.charAt(i);
        }

        return arr;
    }
}

/*
 * for each word check it through each word
 * nested loop
 * move both word tests into character arrays
 * remember which indexes are true
 */
