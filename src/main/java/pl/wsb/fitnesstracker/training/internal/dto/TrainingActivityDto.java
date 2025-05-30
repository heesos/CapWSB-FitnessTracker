package pl.wsb.fitnesstracker.training.internal.dto;

import pl.wsb.fitnesstracker.training.internal.ActivityType;

public record TrainingActivityDto(UserTrainingDto user, ActivityType activityType) {
}
