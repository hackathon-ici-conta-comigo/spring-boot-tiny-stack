package com.codegik.tinystack.rest;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.Period;
import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.dto.ProfileDTO;
import com.codegik.tinystack.rest.util.Calendar;
import com.codegik.tinystack.service.ProfileService;

@RestController
@RequestMapping("/api")
public class SearchResource {

    private final Logger log = LoggerFactory.getLogger(SearchResource.class);

    @Inject
    private ProfileService profileService;

    @GetMapping("/search")
    public ResponseEntity<List<ProfileDTO>> create(@RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "initialAgeGroup", required = false) Integer initialAgeGroup,
            @RequestParam(name = "endAgeGroup", required = false) Integer endAgeGroup,
            @RequestParam(name = "city") String city) {
        return new ResponseEntity<List<ProfileDTO>>(profileService.findAllByFilters(name, Period.create()
                .withInitialDate(null != endAgeGroup ? Calendar.toDate(LocalDate.now().minusYears(endAgeGroup)) : null)
                .withEndDate(
                        null != initialAgeGroup ? Calendar.toDate(LocalDate.now().minusYears(initialAgeGroup)) : null),
                city), HttpStatus.OK);
    }

}
