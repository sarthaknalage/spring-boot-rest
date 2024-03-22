package sarthak.corp.rest_api.mail.sending;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "persistent")
public interface InterPersistent extends CrudRepository<Student, Integer> {

}
