package com.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, ObjectId> {

}
