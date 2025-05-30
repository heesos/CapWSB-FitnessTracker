package pl.wsb.fitnesstracker.training.internal.dto;

import pl.wsb.fitnesstracker.training.internal.ActivityType;

public record TrainingPutResponseDto(UserTrainingDto user, double distance, double averageSpeed, ActivityType activityType) {
}
