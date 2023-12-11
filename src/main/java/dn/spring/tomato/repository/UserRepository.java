package dn.spring.tomato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dn.spring.tomato.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u from dn.spring.tomato.model.User u WHERE u.email = :email AND u.passkey = :passkey")
  Optional<User> getUserByEmailAndPass(@Param("email") String email, @Param("pass") String passkey);
}
