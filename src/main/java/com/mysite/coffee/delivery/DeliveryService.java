package com.mysite.coffee.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;


    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
