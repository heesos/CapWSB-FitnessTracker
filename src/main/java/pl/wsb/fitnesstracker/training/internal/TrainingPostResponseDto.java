package pl.wsb.fitnesstracker.training.internal;

public record TrainingPostResponseDto(UserTrainingDto user, double distance, double averageSpeed) {
}
