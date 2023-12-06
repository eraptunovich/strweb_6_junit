package com.example.strweb_6;

import jakarta.xml.bind.annotation.XmlElement;

public class Product {
    private String name;
    private String description;
    private String ingredients;
    private double price;
    private int spiciness;
    private boolean vegetarian;

    public Product() {
    }

    @XmlElement(name = "name")
    public String getName() {
        return this.name;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return this.description;
    }

    @XmlElement(name = "ingredients")
    public String getIngredients() {
        return this.ingredients;
    }

    @XmlElement(name = "price")
    public double getPrice() {
        return this.price;
    }

    @XmlElement(name = "spiciness")
    public int getSpiciness() {
        return this.spiciness;
    }

    @XmlElement(name = "vegetarian")
    public boolean isVegetarian() {
        return this.vegetarian;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$ingredients = this.getIngredients();
        final Object other$ingredients = other.getIngredients();
        if (this$ingredients == null ? other$ingredients != null : !this$ingredients.equals(other$ingredients))
            return false;
        if (Double.compare(this.getPrice(), other.getPrice()) != 0) return false;
        if (this.getSpiciness() != other.getSpiciness()) return false;
        if (this.isVegetarian() != other.isVegetarian()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $ingredients = this.getIngredients();
        result = result * PRIME + ($ingredients == null ? 43 : $ingredients.hashCode());
        final long $price = Double.doubleToLongBits(this.getPrice());
        result = result * PRIME + (int) ($price >>> 32 ^ $price);
        result = result * PRIME + this.getSpiciness();
        result = result * PRIME + (this.isVegetarian() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Product(name=" + this.getName() + ", description=" + this.getDescription() + ", ingredients=" + this.getIngredients() + ", price=" + this.getPrice() + ", spiciness=" + this.getSpiciness() + ", vegetarian=" + this.isVegetarian() + ")";
    }

    public boolean isExpensive() {
        // Пусть продукт считается дорогим, если цена превышает 50
        return price > 50.0;
    }

    public String getDescriptionSummary() {
        // Возвращает первые 50 символов описания продукта
        if (description.length() <= 50) {
            return description;
        } else {
            return description.substring(0, 50) + "...";
        }
    }
}