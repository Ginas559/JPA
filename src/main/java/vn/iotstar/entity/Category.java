package vn.iotstar.entity;

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

    @Column(columnDefinition = "NVARCHAR(255)")
    private String categoryname;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Category() {
    }

    public Category(int id, String categoryname) {
        this.id = id;
        this.categoryname = categoryname;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCategoryname() { return categoryname; }
    public void setCategoryname(String categoryname) { this.categoryname = categoryname; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
