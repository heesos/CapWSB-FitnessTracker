package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingService;
import pl.wsb.fitnesstracker.training.internal.TrainingRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
// TODO: Provide Implementation and correct the return type of the method getTraining
public class TrainingServiceImpl implements TrainingProvider, TrainingService {

    private final TrainingRepository trainingRepository;


    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
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

    public boolean addTraining(Training training) {
        return false;
    }

    public boolean updateTraining(Training training) {
        return false;
    }
}
