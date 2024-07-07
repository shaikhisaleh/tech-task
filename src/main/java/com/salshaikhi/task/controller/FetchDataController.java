package com.salshaikhi.task.controller;

import com.salshaikhi.task.service.FetchDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class FetchDataController {

    private final FetchDataService fetchDataService;

    public FetchDataController(FetchDataService fetchDataService) {
        this.fetchDataService = fetchDataService;
    }


    @GetMapping("/fetch-data")
    public ResponseEntity<String> fetchData(){
        return ResponseEntity.ok(fetchDataService.fetchAndSaveData());
    }

}
