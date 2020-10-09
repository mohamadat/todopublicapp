package nl.hu.minor.todo.data.repository;


import nl.hu.minor.todo.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findBylistid(UUID fromString);
//    Optional<Task> findByIban(int iban);
}
