package com.Springpro.Springpro_database22.Repository;

import com.Springpro.Springpro_database22.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query(" { 'name' :  ?0 }")
    List<User> findByNameByQuery(String name);
    Optional<User> findById(Long id);

    List<User> findAll();

}