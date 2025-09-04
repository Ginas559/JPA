package jpa.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categoryname", columnDefinition = "NVARCHAR(255)")
    private String categoryname;

    public Category() {
    }

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    // Đồng bộ với servlet
    public String getName() {
        return categoryname;
    }

    public void setName(String name) {
        this.categoryname = name;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", categoryname=" + categoryname + "]";
    }
}
