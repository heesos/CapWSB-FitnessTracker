package pl.wsb.fitnesstracker.training.api;

public interface TrainingService {

    Training addTraining(Training training);
    Training updateTraining(Long trainingId, Training training);
}
