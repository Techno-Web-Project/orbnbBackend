package orbnb.backend.service.Housing;

import orbnb.backend.model.Message;
import orbnb.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> retrieveAllMessages(){
        return messageRepository.findAll();
    }

    public Message addMessage(Message message){
        messageRepository.save(message);
        return message;
    }

    public void deleteMessage(Long id_message){
        messageRepository.deleteById(id_message);
    }

    public Message retrieveMessage(Long id_message){
        return messageRepository.findMessageById(id_message);
    }
}
