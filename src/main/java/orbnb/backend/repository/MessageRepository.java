package orbnb.backend.repository;

import orbnb.backend.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {

    List<Message> findAll();

    Message save(Message message);

    @Override
    void delete(Message entity);

    @Query("select m from Message m where m.id_message=:id")
    Message findMessageById(@Param("id") Long id_message);
}