package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.internal.dto.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingServiceImpl trainingService;
    private final TrainingMapper trainingMapper;


    @GetMapping
    List<TrainingDto> getAllTrainings() {
        return trainingService.getAllTrainings()
                .stream()
                .map(trainingMapper::mapToDto)
                .toList();
    }

    @GetMapping("/{userid}")
    List<TrainingDto> getAllTrainingsByUserId(@PathVariable Long userid) {
        return trainingService.getAllTrainingsByUserId(userid)
                .stream()
                .map(trainingMapper::mapToDto)
                .toList();
    }

    @GetMapping("/finished/{afterTime}")
    List<TrainingDto> getAllTrainingsAfterGivenTime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date afterTime) {
        return trainingService.getAllTrainingsAfterGivenTime(afterTime)
                .stream()
                .map(trainingMapper::mapToDto)
                .toList();
    }

    @PostMapping
    ResponseEntity<TrainingPostResponseDto> addTraining(@RequestBody TrainingPostDto trainingPostDto) {
        Training training = trainingMapper.mapToEntity(trainingPostDto);
        Training newTraining = trainingService.addTraining(training);
        TrainingPostResponseDto newTrainingPostDto = trainingMapper.mapToPostResponseDto(newTraining);
        return ResponseEntity.status(201).body(newTrainingPostDto);
    }

    @PutMapping("/{trainingId}")
    ResponseEntity<TrainingPutResponseDto> updateTraining(@RequestBody TrainingPostDto trainingUpdateDto, @PathVariable Long trainingId) {
        Training training = trainingMapper.mapToEntity(trainingUpdateDto);
        Training newTraining = trainingService.updateTraining(trainingId,training);
        TrainingPutResponseDto trainingPutResponseDto = trainingMapper.mapToPutResponseDto(newTraining);
        return ResponseEntity.ok(trainingPutResponseDto);
    }

    @GetMapping("/activityType")
    ResponseEntity<List<TrainingActivityDto>> getTrainingsByActivityType(@RequestParam ActivityType activityType) {
        List<TrainingActivityDto> trainingActivityDtoList = trainingService.getAllTrainingsByActivityType(activityType)
                .stream()
                .map(trainingMapper::mapToActivityDto)
                .toList();

        return ResponseEntity.ok(trainingActivityDtoList);
    }
}
