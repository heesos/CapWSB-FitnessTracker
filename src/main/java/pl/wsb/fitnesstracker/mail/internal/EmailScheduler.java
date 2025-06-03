package pl.wsb.fitnesstracker.mail.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.mail.api.EmailDto;
import pl.wsb.fitnesstracker.mail.api.EmailSender;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final EmailSender emailSender;
    private final TrainingProvider trainingProvider;

    @Scheduled(cron = "0 0 8 1 * ?")  // At 08:00 AM on the 1st day of every month
    public void scheduleMonthlyEmails() {
        List<EmailDto> emails = trainingProvider.getAllTrainings().stream().map(EmailMapper::mapToDto).toList();
        for (EmailDto emailDto : emails) {
                emailSender.send(emailDto);
            }
        }
}
