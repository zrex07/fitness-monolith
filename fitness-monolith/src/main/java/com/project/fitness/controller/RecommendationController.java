package com.project.fitness.controller;


import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    public final RecommendationService recommendationService;

    @PutMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(
            @RequestBody RecommendationRequest request
            ){
        return ResponseEntity.ok(recommendationService.generateRecommendation(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(@PathVariable String userId){

        List<RecommendationResponse> recommendationList = recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponse>> getActivityRecommendation(@PathVariable String activityId){

        List<RecommendationResponse> recommendationList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }

}
