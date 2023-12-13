package dn.spring.tomato.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  @JsonIgnore
  @JoinTable(name = "product_tags", joinColumns = {
      @JoinColumn(name = "tag_id", referencedColumnName = "id") }, inverseJoinColumns = {
          @JoinColumn(name = "product_id", referencedColumnName = "id") })
  List<Product> products;

  public Tags() {
  }

  public Tags(String tag) {
    this.tag = tag;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "Tags [id=" + id + ", tag=" + tag + ", products=" + products + "]";
  }

}
