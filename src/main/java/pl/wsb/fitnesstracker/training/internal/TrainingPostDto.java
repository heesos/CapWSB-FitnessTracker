package pl.wsb.fitnesstracker.training.internal;

import java.util.Date;

public record TrainingPostDto(String userId, Date startTime,
                              Date endTime, double distance, double averageSpeed, ActivityType activityType) {
}
