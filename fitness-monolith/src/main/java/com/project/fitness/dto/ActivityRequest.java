package com.project.fitness.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.fitness.model.ActivityType;
import com.project.fitness.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMatrics;

    private Integer duration;
    private Integer coloriesBurned;
    private LocalDateTime startTime;
}
