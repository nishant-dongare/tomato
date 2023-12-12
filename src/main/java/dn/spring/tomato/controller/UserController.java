package dn.spring.tomato.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dn.spring.tomato.model.Product;
import dn.spring.tomato.model.Tags;
import dn.spring.tomato.model.User;
import dn.spring.tomato.service.ProductService;
import dn.spring.tomato.service.UserService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

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
  public User getUserById(@PathVariable int id) {
    return userService.getUserById(id);

  }

  @PostMapping("/adduser")
  public String saveUser(@RequestBody User user) {
    userService.saveUser(user);
    return "Success";
  }

  @PostMapping("/auth")
  public User checkUser(@RequestBody UserAuth uauth) {
    User user = userService.getUserByEmailAndPass(uauth.getEmail(), uauth.getPasskey());
    return user == null ? new User() : user;
  }

  @GetMapping("/test")
  public User test() {
    // List<Tags> tags = new ArrayList<>();
    // // tags.add(new Tags("FastFood"));

    List<Tags> tags = List.of(new Tags("FastFood"));
    User u1 = new User("User1", "user1@email", "123456", null);

    Product p1 = new Product(u1, "Pizza Pepperoni", "10-20", 10, false, "italy", 4.5,
        "assets/food-1.jpg", tags);
    Product p2 = new Product(u1, "Meatball", "20-30", 20, true, "persia, middle east, china", 4.7, "assets/food-2.jpg",
        tags);

    u1.setProductList(List.of(p1, p2));

    u1 = userService.saveUser(u1);
    return u1;
  }

  static class UserAuth {
    private String email;
    private String passkey;

    public String getEmail() {
      return email;
    }

    public String getPasskey() {
      return passkey;
    }
  }

}
