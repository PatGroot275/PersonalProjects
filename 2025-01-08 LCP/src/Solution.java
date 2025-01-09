class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrefixSuffixPairs(new String[] { "a","abb" }));
    }

    public boolean isPrefixAndSuffix(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }
        char[] arrayA = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = a.charAt(i);
        }
        char[] arrayB = new char[b.length()];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = b.charAt(i);
        }
        boolean prefix = false;
        int countPre = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] == arrayB[i]) {
                countPre++;
            }
        }
        if (countPre == arrayA.length) {
            prefix = true;
        }
        boolean suffix = false;
        int countSuf = 0;
        for (int i = arrayB.length - arrayA.length; i < arrayB.length; i++) {
            if (arrayA[i - (arrayB.length - arrayA.length)] == arrayB[i]) {
                countSuf++;
            }
        }
        if (countSuf == arrayA.length) {
            suffix = true;
        }
        if (prefix && suffix) {
            return true;
        }
        return false;

    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}