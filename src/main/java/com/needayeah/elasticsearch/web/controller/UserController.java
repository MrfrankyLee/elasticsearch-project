package com.needayeah.elasticsearch.web.controller;

import com.needayeah.elasticsearch.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
@Api(value = "/api/user", description = "用户")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(notes = "getOne", httpMethod = "POST", value = "通过id查询用户信息")
    @RequestMapping(value = "/getOne",method = RequestMethod.POST)
    public ResponseEntity getOne(@RequestParam(name = "id" ,required = true)@ApiParam(value = "ID") long id){


        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

}
