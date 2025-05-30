package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingService;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingServiceImpl implements TrainingProvider, TrainingService {

    private final TrainingRepository trainingRepository;
    private final UserProvider userProvider;

    @Override
    public Optional<Training> getTraining(final Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    @Override
    public List<Training> getAllTrainingsAfterGivenTime(Date afterTime) {
        return trainingRepository.findAll().stream().filter(training -> training.getEndTime().after(afterTime)).toList();
    }

    public List<Training>getAllTrainings() {
        return trainingRepository.findAll();
    }

    public List<Training>getUserTrainings(User user) {
        return null;
    }

    public List<Training>getFinishedTrainings(LocalDate date) {
        return null;
    }

    public List<Training>getTrainingsByActivity(ActivityType activity) {
        return null;
    }

    public Training addTraining(Training training) {
        if(userProvider.getUser(training.getUser().getId()).isPresent()) {
          return trainingRepository.save(training);
        }
        throw new IllegalArgumentException("User with that ID does not exist");
    }

    @Override
    public Training updateTraining(Long trainingId, Training training) {
        Optional<Training> trainingOptional = trainingRepository.findById(trainingId);
        if(trainingOptional.isPresent()) {
            trainingOptional.get().updateTraining(training);
            return trainingRepository.save(trainingOptional.get());
        }
        return null;
    }

    public List<Training> getAllTrainingsByUserId(Long userId) {
        return trainingRepository.findAll().stream().filter(training -> training.getUser().getId().equals(userId)).toList();
    }

}
