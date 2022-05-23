package orbnb.backend.message;

import orbnb.backend.message.Message;
import orbnb.backend.personRate.PersonRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    Message findMessageByIdmessage(Long id);
}
