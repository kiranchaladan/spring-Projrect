package com.originalstuidos.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "t_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Setter
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderListItem> orderListItem;

}
