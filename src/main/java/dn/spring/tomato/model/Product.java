package dn.spring.tomato.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String cookTime;
  private int price;
  private boolean favorite;
  private String origins;
  private double stars;
  private String imageUrl;

  @ManyToOne()
  @JsonIgnore
  @JoinColumn(name = "userId")
  private User user;

  @ManyToMany(cascade = CascadeType.ALL)
  List<Tags> tags;

  public Product(String name, String cookTime, int price, boolean favorite, String origins, double stars,
      String imageUrl, List<Tags> tags) {
    this.name = name;
    this.cookTime = cookTime;
    this.price = price;
    this.favorite = favorite;
    this.origins = origins;
    this.stars = stars;
    this.imageUrl = imageUrl;
    this.tags = tags;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCookTime() {
    return cookTime;
  }

  public int getPrice() {
    return price;
  }

  public boolean isFavorite() {
    return favorite;
  }

  public String getOrigins() {
    return origins;
  }

  public double getStars() {
    return stars;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
