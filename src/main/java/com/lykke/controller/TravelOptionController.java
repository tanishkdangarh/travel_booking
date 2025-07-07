package com.lykke.controller;

import com.lykke.model.TravelOption;
import com.lykke.service.TravelOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/travel")
public class TravelOptionController {

    @Autowired
    private TravelOptionService travelOptionService;

    @GetMapping("/options")
    public ResponseEntity<List<TravelOption>> listOptions(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String type) {
        return ResponseEntity.ok(travelOptionService.getAvailableOptions(source, destination, type));
    }
}