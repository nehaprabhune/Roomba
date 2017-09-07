package com.assignment.roomba;

import com.assignment.roomba.entities.RequestResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestResponseRepository extends MongoRepository<RequestResponse, Integer>{
    
}
