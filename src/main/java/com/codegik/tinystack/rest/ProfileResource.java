package com.codegik.tinystack.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.Role;
import com.codegik.tinystack.rest.util.PaginationUtil;
import com.codegik.tinystack.service.ProfileService;

@RestController
@RequestMapping("/api")
public class ProfileResource {

  private final Logger log = LoggerFactory.getLogger(UserResource.class);

  @Inject
  private ProfileService profileService;

  @CrossOrigin
  @PostMapping("/profile")
  public ResponseEntity<Profile> create(@RequestBody Profile profile) {
    return new ResponseEntity<Profile>(profileService.create(profile), HttpStatus.OK);
  }

  @GetMapping("/participants")
  public ResponseEntity<List<Profile>> findAll(Pageable pageable) throws URISyntaxException {
    Role role = new Role();
    role.setName("ALUNO");
    Page<Profile> page = profileService.findAll(pageable);
    HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/profiles");
    return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
  }

}
