package orbnb.backend.message;


import orbnb.backend.booking.Booking;
import orbnb.backend.housing.Housing;
import orbnb.backend.message.Message;
import orbnb.backend.message.service.MessageService;
import orbnb.backend.person.Person;
import orbnb.backend.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/messageApi")
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    PersonService personService;

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<Message>> getMessages(){
        return new ResponseEntity<>(this.messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/getMessageById/{id_message}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable("id_message") Long id_message){
        return new ResponseEntity<>(this.messageService.getMessageById(id_message), HttpStatus.OK);
    }

    @PostMapping("/addMessage")
    @ResponseBody
    public ResponseEntity<Message> addMessage(@RequestBody Message message){
        return new ResponseEntity<>(this.messageService.addMessage(message), HttpStatus.CREATED);
    }


    @DeleteMapping("/removeMessage/{id_message}")
    @ResponseBody
    public void removeMessage(@PathVariable("id_message") Long id_message){
        this.messageService.deleteMessage(id_message);
    }

}
