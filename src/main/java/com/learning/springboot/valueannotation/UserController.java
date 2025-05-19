package com.learning.springboot.valueannotation;

import com.learning.springboot.exception.CustomException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
//    @Qualifier("onlineOrder")
    private Order order;

    @GetMapping("/order")
    public String getOrder(){
        return order.createOrder();
    }

    @PostConstruct
    public void init(){
        System.out.println("UserController Created with "+order.createOrder());
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());

        Link link = Link.of("http://localhost:8080/user/getUser"+userResponse.getEmail())
                .withRel("user")
        .withType("GET");

        userResponse.addLink(link);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable Integer id) {
        throw new CustomException(HttpStatus.BAD_REQUEST,"User not found");
//        throw new NullPointerException("User not found");
    }
}
