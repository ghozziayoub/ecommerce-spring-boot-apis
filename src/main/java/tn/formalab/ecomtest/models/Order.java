package tn.formalab.ecomtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "createdAt", nullable = false)
    public Date createdAt = new Date();

    @Column(name = "totalPrice", nullable = false)
    public Double totalPrice;

    @Column(name = "state", nullable = false)
    public String state = "IN PROGRESS"; // IN PROGRESS , ACCEPTED , REJECTED

    @ManyToOne
    @JoinColumn(name = "idclient")
    @JsonIgnoreProperties("orders")
    public User user;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties({"order"})
    public List<OrderDetails> orderDetails = new ArrayList<>();

    public Order(User user, Double totalPrice) {
        this.totalPrice = totalPrice;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", totalPrice=" + totalPrice +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
