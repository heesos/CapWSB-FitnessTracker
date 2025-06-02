package pl.wsb.fitnesstracker.mail.internal;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;


//controller just to check if I am able to send any email on request
//finally it should be done using CRON in the service class
@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailSenderImpl emailSender;
    private final TrainingProvider trainingProvider;
    private final EmailMapper emailMapper;

    @PostMapping("/sendMail")
    public String sendMail() {
        emailSender.send(emailMapper.mapToDto(trainingProvider.getTraining(1L).get()));
        return "";
    }
}
