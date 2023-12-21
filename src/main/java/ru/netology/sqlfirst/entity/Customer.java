package ru.netology.sqlfirst.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column (name = "phone_number")
    private Long phoneNumber;

    // field for two-way communication with orders
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private List<Order> orders = new ArrayList<>();
//
//    public void addOrder(Order order) {
//        orders.add(order);
//        order.setCustomer(this);
//    }
//    public void removeOrder(Order order) {
//        orders.remove(order);
//        order.setCustomer(null);
//    }
}
