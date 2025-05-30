package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

@Component
public class TrainingMapper {
    private final UserProvider userProvider;

    public TrainingMapper(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    TrainingDto mapToDto(Training training) {
        UserTrainingDto user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        return new TrainingDto(user, training.getStartTime(),training.getEndTime(),training.getDistance(),
                training.getAverageSpeed());
    }

    Training mapToEntity(TrainingPostDto trainingPostDto) {
        User user = userProvider.getUser(Long.valueOf(trainingPostDto.userId())).get();
        return new Training(user,trainingPostDto.startTime(),trainingPostDto.endTime(),trainingPostDto.activityType(), trainingPostDto.distance(),
                trainingPostDto.averageSpeed());
    }

    TrainingPostDto mapToPostDro(Training training) {
        return new TrainingPostDto(training.getUser().getId().toString(),
                training.getStartTime(),training.getEndTime(), training.getDistance(), training.getAverageSpeed(),training.getActivityType());
    }

}
