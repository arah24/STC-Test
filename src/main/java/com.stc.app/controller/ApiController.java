package com.stc.app.controller;

import com.stc.app.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/files")
    public ResponseEntity<String> getFiles() throws Exception {
        return ResponseEntity.ok(apiService.getFile());
    }

    @PostMapping("/files/item")
    public void createFile(@RequestBody String item) throws Exception {
        apiService.createFile(item);
    }

}
