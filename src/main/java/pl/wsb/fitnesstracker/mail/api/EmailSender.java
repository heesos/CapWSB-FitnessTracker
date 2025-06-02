package pl.wsb.fitnesstracker.mail.api;


/**
 * API interface for component responsible for sending emails.
 */
public interface EmailSender {


    void sendEveryMonth();
    /**
     * Sends the email message to the recipient from the provided {@link EmailDto}.
     *
     * @param emailDto information on email to be sent
     */
    void send(EmailDto emailDto);
}
