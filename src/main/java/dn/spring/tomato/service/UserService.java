package dn.spring.tomato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dn.spring.tomato.model.Product;
import dn.spring.tomato.model.Tags;
import dn.spring.tomato.model.User;
import dn.spring.tomato.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public User getUserById(int id) {
    return userRepository.findById(id).get();
  }

  public User getUserByEmailAndPass(String email, String pass) {
    return userRepository.getUserByEmailAndPass(email, pass).orElse(null);
  }
}
