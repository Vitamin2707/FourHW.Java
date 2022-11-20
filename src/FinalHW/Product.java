public class Product {
    public int count;
    public String name;
    public double price;
    public String description;

    public void print() {
        System.out.printf(
                "%d шт. %s %.2fр %s%n",
            this.count,
            this.name,
            this.price,
            this.description);
    }
}
