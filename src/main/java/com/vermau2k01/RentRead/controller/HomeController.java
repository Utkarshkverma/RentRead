package com.vermau2k01.RentRead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "Welcome to RentRead API\n" +
                "\n" +
                "Welcome to RentRead, your gateway to an immersive online book rental experience. Our API service allows you to explore a vast collection of books, manage your rentals seamlessly, and administer your account with ease. Whether you're an avid reader looking to discover new titles or an administrator overseeing the library, RentRead caters to your needs. Enjoy secure authentication through Basic Auth, ensuring your data is protected at all times. With role-based access controls, users and administrators alike can interact with our platform in a way that suits their permissions. Get started today and dive into a world of literature with RentRead API.";
    }
}
