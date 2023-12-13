package dn.spring.tomato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dn.spring.tomato.model.Product;
import dn.spring.tomato.service.UserService;

@RestController
@RequestMapping("/foods")
public class ProductController {

  @Autowired
  private UserService userService;

  @GetMapping("/allfoods")
  List<Product> productList() {
    return userService.getUserById(1).getProductList();
  }

}
