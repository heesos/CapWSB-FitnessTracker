package pl.wsb.fitnesstracker.training.internal;

import java.util.Date;

public record TrainingDto(UserTrainingDto user, Date startTime,
                          Date endTime, double distance, double averageSpeed) {
}
