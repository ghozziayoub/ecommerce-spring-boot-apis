package tn.formalab.ecomtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "imageUrl", nullable = false)
    public String imageUrl;

    @Column(name = "price", nullable = false)
    public Double price;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    @JsonIgnoreProperties("products")
    public Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"product","order"})
    public List<OrderDetails> orderDetails;

}
