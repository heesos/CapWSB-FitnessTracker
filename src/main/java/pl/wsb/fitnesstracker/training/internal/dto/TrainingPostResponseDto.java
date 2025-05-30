package pl.wsb.fitnesstracker.training.internal.dto;

public record TrainingPostResponseDto(UserTrainingDto user, double distance, double averageSpeed) {
}
