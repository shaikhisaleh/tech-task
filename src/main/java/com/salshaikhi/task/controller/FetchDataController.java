package com.salshaikhi.task.controller;

import com.salshaikhi.task.service.FetchDataService;
import io.github.bucket4j.Bucket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class FetchDataController {
    private final Bucket bucket;
    private final FetchDataService fetchDataService;

    public FetchDataController(Bucket bucket, FetchDataService fetchDataService) {
        this.bucket = bucket;
        this.fetchDataService = fetchDataService;
    }

    @GetMapping("/fetch-data")
    public ResponseEntity<String> fetchData(){
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(fetchDataService.fetchAndSaveData());
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }

}
