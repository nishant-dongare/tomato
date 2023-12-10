package dn.spring.tomato.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tags {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  int id;
  String tag;

  @ManyToMany()
  List<Product> products;

  public Tags(String tag) {
    this.tag = tag;
  }

}
