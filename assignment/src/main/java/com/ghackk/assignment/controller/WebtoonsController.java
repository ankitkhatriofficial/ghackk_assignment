package com.ghackk.assignment.controller;

import com.ghackk.assignment.dto.WebtoonsDto;
import com.ghackk.assignment.service.WebtoonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ankit Khatri
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/webtoons")
public class WebtoonsController {

    private final WebtoonsService webtoonsService;

    @PostMapping("/")
    public ResponseEntity<?> createNewWebtoons(@RequestBody WebtoonsDto webtoonsDto){
        return ResponseEntity.ok(this.webtoonsService.createNewWebtoons(webtoonsDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWebtoons(@PathVariable String id){
        return ResponseEntity.ok(this.webtoonsService.getWebtoonsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWebtoons(@PathVariable String id, @RequestBody WebtoonsDto webtoonsDto){
        return ResponseEntity.ok(this.webtoonsService.updateWebtoons(id, webtoonsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWebtoons(@PathVariable String id){
        this.webtoonsService.deleteWebtoons(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
