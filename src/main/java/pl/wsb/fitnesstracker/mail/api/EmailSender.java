package pl.wsb.fitnesstracker.mail.api;


import java.util.List;

/**
 * API interface for component responsible for sending emails.
 */
public interface EmailSender {

    /**
     * Sends the email message to the recipient from the provided {@link EmailDto}.
     *
     * @param emailDto information on email to be sent
     */
    void send(EmailDto emailDto);
}
