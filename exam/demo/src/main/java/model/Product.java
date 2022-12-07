package model;

public class Product {
    private int id;
    private String productName;
    private float price;
    private int amount;
    private String color;
    private String descriptions;

    private int idCategory;

    public Product() {
    }

    public Product(String color) {
        this.color = color;
    }

    public Product(int id, String productName, float price, int amount, String color, String descriptions) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.descriptions = descriptions;
    }

    public Product(int id, String productName, float price, int amount, String color, String descriptions, int idCategory) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.descriptions = descriptions;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}

