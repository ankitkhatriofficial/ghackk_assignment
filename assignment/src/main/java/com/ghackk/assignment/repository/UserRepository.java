package com.ghackk.assignment.repository;

import com.ghackk.assignment.document.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Ankit Khatri
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(final String email);
}
