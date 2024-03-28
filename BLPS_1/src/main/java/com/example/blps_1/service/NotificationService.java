package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private ClientService clientService;
    private ProductService productService;
    private final JavaMailSender javaMailSender;

    //Добавить подписку пользователя на уведомление о прибытии интересующего продукта
    public boolean setNotificationStatus(Long clientId, ProductDTO productDTO){
        Client client = clientService.readById(clientId);
        Product product = productService.readByName(productDTO);
        if(client.getNotifications().contains(product)){return false;}
        client.getNotifications().add(product);
        clientService.update(client);
        return true;
    }

    public boolean deleteNotificationStatus(Long clientId, ProductDTO productDTO){
        Client client = clientService.readById(clientId);
        Product product = productService.readByName(productDTO);
        if(client.getNotifications().contains(product)){return false;}
        client.getNotifications().remove(product);
        clientService.update(client);
        return true;
    }

    //Отправка письма на почту заданного клиента
    public void sendNotification(Long clientId, String topic, String body){
        Client client = clientService.readById(clientId);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(client.getMail());
        message.setSubject(topic);
        message.setText(body);
        javaMailSender.send(message);
    }
}
