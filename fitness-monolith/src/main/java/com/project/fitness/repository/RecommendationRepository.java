package com.project.fitness.repository;

import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
    List<RecommendationResponse> findByUserId(String userId);

    List<RecommendationResponse> findByActivityId(String activityId);
}
