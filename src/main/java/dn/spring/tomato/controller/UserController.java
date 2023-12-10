package dn.spring.tomato.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dn.spring.tomato.model.Product;
import dn.spring.tomato.model.Tags;
import dn.spring.tomato.model.User;
import dn.spring.tomato.service.ProductService;
import dn.spring.tomato.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ProductService ps;

  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/id/{id}")
  public User getEmployeebyid(@PathVariable int id) {
    return userService.getUserById(id);

  }

  @PostMapping("/adduser")
  public String saveUser(@RequestBody User user) {
    userService.saveUser(user);
    return "Success";
  }

  @GetMapping("/test")
  public User test() {
    List<Product> list = new ArrayList<>();
    // List<Tags> tags = List.of(new Tags("FastFood"));
    Product p1 = new Product("Pizza Pepperoni", "10-20", 10, false, "italy", 4.5,
        "assets/food-1.jpg", null);
    list.add(p1);
    Product p2 = new Product("Meatball", "20-30", 20, true, "persia, middle east, china", 4.7, "assets/food-2.jpg",
        null);
    list.add(p2);

    User u1 = new User("User1", "user1@email", "123456", null, list);
    u1 = userService.saveUser(u1);

    User u2 = new User("User2", "user2@email", "123456", null, list);
    u2 = userService.saveUser(u2);

    ps.setUserToProduct(u1);
    ps.setUserToProduct(u2);

    return u2;
  }

}
