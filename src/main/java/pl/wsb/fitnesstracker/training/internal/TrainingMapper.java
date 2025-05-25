package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;

@Component
public class TrainingMapper {
    TrainingDto mapToDto(Training training) {
        UserTrainingDto user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        return new TrainingDto(user, training.getStartTime(),training.getEndTime(),training.getDistance(),
                training.getAverageSpeed());
    }

}
