package orbnb.backend.message.service;

import orbnb.backend.message.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    List<Message> getAllMessages();

    Message addMessage(Message message);

    void deleteMessage(Long id_message);

    Optional<Message> getMessageById(Long id_message);

    void assignMessageSendToPerson(Long idMessage, Long idPerson);

    void assignMessageReceivedToPerson(Long idMessage, Long idPerson);

}