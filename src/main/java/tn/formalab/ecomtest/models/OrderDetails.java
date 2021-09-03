package tn.formalab.ecomtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    @JsonIgnoreProperties("orderDetails")
    public Product product;

    @ManyToOne
    @JoinColumn(name = "idorder")
    @JsonIgnoreProperties("order")
    public Order order;

    @Column(name = "quantite")
    public Integer quantite;

    @Column(name = "prixunitaire")
    public Double prixUnitaire;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }
}
