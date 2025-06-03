package pl.wsb.fitnesstracker.mail.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.mail.api.EmailDto;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.internal.dto.TrainingDto;
import pl.wsb.fitnesstracker.training.internal.dto.UserTrainingDto;

import java.text.SimpleDateFormat;

@Component
public class EmailMapper {

    private static final String EMAIL_SUBJECT = "Your monthly training raport";

    static EmailDto mapToDto(Training training) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");

        UserTrainingDto user = new UserTrainingDto(training.getUser().getId(),
                training.getUser().getFirstName(),
                training.getUser().getLastName(),
                training.getUser().getEmail());
        TrainingDto trainingDto = new TrainingDto(user, training.getStartTime(),training.getEndTime(),training.getDistance(),
                training.getAverageSpeed());

        String start = dateFormat.format(trainingDto.startTime());
        String end = dateFormat.format(trainingDto.endTime());

        String emailBody = String.format(
                "Your training started at %s and ended at %s. You covered %.2f km with an average speed of %.2f km/h.",
                start, end, trainingDto.distance(),trainingDto.averageSpeed());

        return new EmailDto(trainingDto.user().email(),EMAIL_SUBJECT, emailBody);
    }
}
