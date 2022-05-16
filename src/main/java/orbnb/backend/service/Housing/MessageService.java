package orbnb.backend.service.Housing;

import orbnb.backend.model.Message;

import java.util.List;

public interface MessageService {

    public List<Message> retrieveAllMessages();

    public Message addMessage(Message message);

    public void deleteMessage(Long id_message);

    public Message retrieveMessage(Long id_message);
}
