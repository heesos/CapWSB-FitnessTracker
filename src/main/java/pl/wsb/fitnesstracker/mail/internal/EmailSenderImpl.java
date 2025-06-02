package pl.wsb.fitnesstracker.mail.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.mail.api.EmailDto;
import pl.wsb.fitnesstracker.mail.api.EmailSender;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;
    private final TrainingProvider trainingProvider;

    @Override
    public void sendEveryMonth() {
        EmailDto email = null;
        try {

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(mailProperties.getFrom());
            mailMessage.setTo(email.toAddress());
            mailMessage.setText(email.content());
            mailMessage.setSubject(email.subject());

            javaMailSender.send(mailMessage);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            throw new MailException(e.getMessage()) {
                @Override
                public Throwable getRootCause() {
                    return super.getRootCause();
                }
            };
        }
    }

    @Override
    public void send(EmailDto emailDto) {
        try {

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(mailProperties.getFrom());
            mailMessage.setTo("iuy24389@toaik.com"); //swap it with dto email later
            mailMessage.setText(emailDto.content());
            mailMessage.setSubject(emailDto.subject());

            javaMailSender.send(mailMessage);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            throw new MailException(e.getMessage()) {
                @Override
                public Throwable getRootCause() {
                    return super.getRootCause();
                }
            };
        }
    }
}
