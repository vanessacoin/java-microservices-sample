package com.vanessa.orderservice.service;

import com.vanessa.orderservice.model.Order;
import com.vanessa.orderservice.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private RestTemplate restTemplate;
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    public Order createOrder(Long orderId, String product, int quantity, Long userId) {
        // Faz uma chamada para o UserService
        String userServiceUrl = "http://localhost:8081/users/" + userId;
        
        // Usa um objeto genérico ou uma classe interna para representar o User
        UserResponse userResponse = restTemplate.getForObject(userServiceUrl, UserResponse.class);
        
        // Cria e retorna a ordem de serviço com os dados do usuário
        return new Order(orderId, product, quantity, userResponse);
    }

    // Classe interna para capturar os dados do usuário
    private static class UserResponse {
        private Long id;
        private String name;
        private String email;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
