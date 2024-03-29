package com.happydev.FoodCoService.util;

import com.happydev.FoodCoService.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InternalServices {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Address getAddress(String addressId) {

        String apiUrl = Constants.URL_LOCAL_BASE+Constants.URL_API+Constants.URL_ADDRESS+"/"+addressId;
        return webClientBuilder.build()
                .get().uri(apiUrl).retrieve().bodyToMono(Address.class).block();
    }
}
