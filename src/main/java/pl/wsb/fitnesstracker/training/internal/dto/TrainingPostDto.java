package pl.wsb.fitnesstracker.training.internal.dto;

import pl.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.Date;

public record TrainingPostDto(String userId, Date startTime,
                              Date endTime, double distance, double averageSpeed, ActivityType activityType) {
}
