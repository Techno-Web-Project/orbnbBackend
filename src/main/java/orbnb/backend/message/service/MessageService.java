package orbnb.backend.message.service;

import orbnb.backend.message.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    public List<Message> getAllMessages();

    public Message addMessage(Message message);

    public void deleteMessage(Long id_message);

    public Optional<Message> getMessageById(Long id_message);

    void assignMessageToPerson(Long id_message, Long id_person);

}