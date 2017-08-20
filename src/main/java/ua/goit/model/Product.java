package ua.goit.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(schema = "spring_homework", name = "products")
@NamedQueries({@NamedQuery(name = "getAllProducts", query = "FROM Product")})
public class Product extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private BigDecimal cost;
    @Column
    private String description;

    public Product() {
    }

    public Product(String name, String manufacturer, BigDecimal cost, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
