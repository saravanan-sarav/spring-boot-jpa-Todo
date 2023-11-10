package com.codewithsarav.springbootjpa.repository;

import com.codewithsarav.springbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.userName=:userName and u.password=:password")
    User findUserIsValid(@Param("userName") String userName,@Param("password") String password);
}
