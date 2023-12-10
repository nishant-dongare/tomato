package dn.spring.tomato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dn.spring.tomato.model.Product;
import dn.spring.tomato.model.User;
import dn.spring.tomato.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public void addProduct(Product product) {
    productRepository.save(product);
  }

  public void setUserToProduct(User user) {
    user.getProductList().forEach(p -> {
      p.setUser(user);
      productRepository.save(p);
    });
  }

}
