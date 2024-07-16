package com.Springpro.Springpro_database22.Repository;

import com.Springpro.Springpro_database22.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findAll();
}