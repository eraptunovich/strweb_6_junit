package com.example.strweb_6;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "menu")
public class Menu {
    private List<Category> categories;

    public Menu() {
    }

    @XmlElement(name = "category")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Menu)) return false;
        final Menu other = (Menu) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Menu;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        return result;
    }

    public String toString() {
        return "Menu(categories=" + this.getCategories() + ")";
    }
}
