import java.math.BigInteger;

public class Pally {
    private int id;
    private int count;
    private BigInteger palindrome;

    public Pally(int id, int count, BigInteger palindrome) {
        this.id = id;
        this.count = count;
        this.palindrome = palindrome;
    }
    
    public int getId() {
        return id;
    }
    
    public int getCount() {
        return count;
    }
    
    public BigInteger getPalindrome() {
        return palindrome;
    }

    
}
