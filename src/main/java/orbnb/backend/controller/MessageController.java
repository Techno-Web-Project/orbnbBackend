package orbnb.backend.controller;


import orbnb.backend.model.Message;
import orbnb.backend.service.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    //http://localhost:8081/SpringMVC/message/retrieve-all-messages

    @GetMapping("/retrieve-all-messages")
    @ResponseBody
    public List<Message> getMessages(){
        List<Message> listMessages = messageService.retrieveAllMessages();
        return listMessages;
    }

    //http://localhost:8081/SpringMVC/message/retrieve-message/{id_message}

    @GetMapping("/retrieve-message/{id_message}")
    @ResponseBody
    public Message getMessage(@PathVariable("id_message") Long id_message){
        return messageService.retrieveMessage(id_message);
    }


    //http://localhost:8081/SpringMVC/message/add_message

    @PostMapping("/add_message")
    @ResponseBody
    public Message addMessage(@RequestBody Message m){
        Message message = messageService.addMessage(m);
        return message;
    }


    //http://localhost:8081/SpringMVC/message/remove-message/{id_message}

    @DeleteMapping("/remove-message/{id_message}")
    @ResponseBody
    public void removeMessage(@PathVariable("id_message") Long id_message){
        messageService.deleteMessage(id_message);
    }

}
