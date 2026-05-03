package com.project.fitness.dto;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {

    private String userId;
    private String activityId;
    private Activity activity;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

}
