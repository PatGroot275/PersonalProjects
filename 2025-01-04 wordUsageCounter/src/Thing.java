public class Thing {
    private String name;
    private int count;

    public Thing(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
}
