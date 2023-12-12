package dn.spring.tomato.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Tags {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String tag;

  @ManyToMany()
  @JoinTable(name = "product_tags", joinColumns = {
      @JoinColumn(name = "tag_id", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "product_id", referencedColumnName = "id") })
  List<Product> products;

  public Tags(String tag) {
    this.tag = tag;
  }

}
