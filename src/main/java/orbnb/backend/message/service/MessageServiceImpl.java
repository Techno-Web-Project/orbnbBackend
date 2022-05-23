package orbnb.backend.message.service;

import orbnb.backend.message.Message;
import orbnb.backend.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAllMessages(){
        return this.messageRepository.findAll();
    }

    public Message addMessage(Message message){
        return this.messageRepository.save(message);
    }

    public void deleteMessage(Long id_message){
        messageRepository.deleteById(id_message);
    }

    public Optional<Message> getMessageById(Long id_message){
        return this.messageRepository.findById(id_message);
    }

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }
}
