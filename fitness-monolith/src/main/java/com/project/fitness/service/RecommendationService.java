package com.project.fitness.service;


import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {


    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public RecommendationResponse generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found" + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found" + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return mapToResponse(savedRecommendation);
    }

    private RecommendationResponse mapToResponse(Recommendation savedRecommendation) {
        RecommendationResponse response = new RecommendationResponse();
        response.setRecommendation(savedRecommendation.getRecommendation());
        response.setId(savedRecommendation.getId());
        response.setActivity(savedRecommendation.getActivity());
        response.setType(savedRecommendation.getType());
        response.setImprovements(savedRecommendation.getImprovements());
        response.setSuggestions(savedRecommendation.getSuggestions());
        response.setUserId(savedRecommendation.getUser().getId());
        response.setSafety(savedRecommendation.getSafety());
        response.setCreatedAt(savedRecommendation.getCreatedAt());
        response.setUpdatedAt(savedRecommendation.getUpdatedAt());

        return response;
    }

    public List<RecommendationResponse> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<RecommendationResponse> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
