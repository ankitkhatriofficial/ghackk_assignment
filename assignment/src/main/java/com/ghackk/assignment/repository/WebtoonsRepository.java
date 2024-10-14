package com.ghackk.assignment.repository;

import com.ghackk.assignment.document.Webtoons;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ankit Khatri
 */
public interface WebtoonsRepository extends MongoRepository<Webtoons, ObjectId> {
}
