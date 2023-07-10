package com.adsh.mongodbtest.repository;

import com.adsh.mongodbtest.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{'name': ?0}") // 0: It indicates which parameter this is
    Optional<Expense> findByName(String name); // Defining this method because of name is the index for this DB
}
