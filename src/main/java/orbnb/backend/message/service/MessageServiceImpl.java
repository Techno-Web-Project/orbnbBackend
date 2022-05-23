package orbnb.backend.message.service;

import orbnb.backend.message.Message;
import orbnb.backend.message.MessageRepository;
import orbnb.backend.person.Person;
import orbnb.backend.person.PersonRepository;
import orbnb.backend.person.service.PersonService;
import orbnb.backend.personRate.PersonRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PersonRepository personRepository;

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

    @Override
    public void assignMessageToPerson(Long id_message, Long id_person) {
        Message message = this.messageRepository.findMessageById_message(id_message);
        Person person = this.personRepository.findPersonById(id_person);
        person.getMessage().add(message);
        message.setId_message(id_message);
        personRepository.save(person);
    }

}
