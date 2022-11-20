

public class app {
    public static void main(String[] args) {
        Product currentProduct;
        currentProduct = new CreateProduct()
                .setCount(5)
                .setName("box")
                .setDescription("картонная коробка")
                .setPrice(200)
                .Create();
        currentProduct.print();

        currentProduct = new CreateProduct()
                .setName("pen")
                .setCount(150)
                .setDescription("Красные шариковые ручки")
                .Create();
        currentProduct.print();

        currentProduct = new CreateProduct()
                .setName("t")
                .Create();
        currentProduct.print();
        currentProduct = new CreateProduct()
                .setName("cats")
                .setCount(1005)
                .Create();
        currentProduct.print();

    }
}