package com.assignment.roomba;

import com.assignment.roomba.entities.InputJson;
import com.assignment.roomba.entities.RequestResponse;
import com.assignment.roomba.entities.OutputJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoombaServiceController {
    @Autowired
    private RoombaUtils roombaUtils;
    
    @Autowired
    private RequestResponseRepository repository;
    
    @RequestMapping("/roomba")
    public ResponseEntity<OutputJson> cleanTheRoom(@RequestBody InputJson inputJson){
        OutputJson result = roombaUtils.navigateThroughRoom(inputJson);
        repository.save(new RequestResponse(inputJson, result));
        ResponseEntity<OutputJson> entity = new ResponseEntity<>(result, HttpStatus.OK);        
        return entity;
    }
}
