package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.internal.dto.*;
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

    TrainingPostResponseDto mapToPostResponseDto(Training training) {
        UserTrainingDto  user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        return new TrainingPostResponseDto(user, training.getDistance(), training.getAverageSpeed());
    }

    TrainingPutResponseDto mapToPutResponseDto(Training training) {
        UserTrainingDto  user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        return new TrainingPutResponseDto(user, training.getDistance(), training.getAverageSpeed(), training.getActivityType());
    }

    TrainingActivityDto mapToActivityDto(Training training) {
        UserTrainingDto  user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        return new TrainingActivityDto(user, training.getActivityType());
    }

}
