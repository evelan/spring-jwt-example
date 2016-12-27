package me.jpomykala.jwt.repository;

import me.jpomykala.jwt.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evelan on 09/12/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
}
