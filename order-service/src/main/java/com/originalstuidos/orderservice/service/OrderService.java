package com.originalstuidos.orderservice.service;

import com.originalstuidos.orderservice.dto.OrderLineItems;
import com.originalstuidos.orderservice.dto.OrderRequest;
import com.originalstuidos.orderservice.model.Order;
import com.originalstuidos.orderservice.model.OrderListItem;
import com.originalstuidos.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderService {
private final OrderRepository orderRepository;
public WebClient webClient;
    public  void placeOrder(OrderRequest orderRequest){


        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderListItem> orderListItems = orderRequest.getOrderLineItems().stream().map(this::maptoDto).toList();
        order.setOrderListItem(orderListItems);
      boolean result = webClient.get().
                          uri("http://localhost:8083/api/inventory")
                          .retrieve()
                           .bodyToMono(boolean.class)
                            .block();
        orderRepository.save(order);
        if(result){
            orderRepository.save(order);
        }else
        {
            throw new IllegalArgumentException("product out of stock");
        }

    }

    private OrderListItem maptoDto(OrderLineItems orderLineItems) {
        OrderListItem orderListItem = new OrderListItem();
        orderListItem.setPrice(orderLineItems.getPrice());
        orderListItem.setQuantity(orderLineItems.getQuantity());
        orderListItem.setSkuCode(orderLineItems.getSkuCode());
        return orderListItem;
    }
}
