

public class CreateProduct {
    Product temp;

    public CreateProduct() {
        temp = new Product();
        temp.count = CONST.NIL_VALUE;
        temp.price = CONST.NIL_VALUE;
        temp.name = CONST.EMPTY;
        temp.description = CONST.EMPTY;
    }
    
    public CreateProduct setCount(int count) {
        if (count > 1000) {
            setDescription("отдельный склад");
            temp.count = count;
            return this;
        }
        temp.count = count;
        return this;
    }
    public CreateProduct setPrice(int price) {
        
        temp.price = price;
        return this;
    }

    public CreateProduct setName(String name) {
        if (name.length() > 2) {
            
            temp.name = name;
        }
        else {
            temp.name = "поняла где прописать условие";
        }
        return this;
    }

    public CreateProduct setDescription(String description) {
        temp.description = description;
        return this;
        
    }

    public Product Create() {
        return temp;
    }
}
