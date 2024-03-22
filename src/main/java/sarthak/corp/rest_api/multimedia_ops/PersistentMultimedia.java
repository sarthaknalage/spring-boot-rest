package sarthak.corp.rest_api.multimedia_ops;

import org.springframework.data.repository.CrudRepository;

public interface PersistentMultimedia extends CrudRepository<FileInformation, Integer> {

}
