package com.codegik.tinystack.rest;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Inject
    private UserService userService;

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<Profile> create(@RequestBody Profile profile) {
        return new ResponseEntity<Profile>(userService.create(profile), HttpStatus.OK);
    }

}
