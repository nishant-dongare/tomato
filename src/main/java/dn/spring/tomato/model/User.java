package dn.spring.tomato.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, length = 20)
  private String name;

  @Column(nullable = false, length = 15)
  private String email;

  @Column(nullable = false, length = 12)
  private String passkey;

  @Column
  private String address;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Product> products;

  public User() {
  }

  public User(String name, String email, String passkey, String address, List<Product> products) {
    this.name = name;
    this.email = email;
    this.passkey = passkey;
    this.address = address;
    this.products = products;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPasskey() {
    return passkey;
  }

  public String getAddress() {
    return address;
  }

  public List<Product> getProductList() {
    return products;
  }

  public void setProduct(List<Product> products) {
    this.products = products;
  }

}
