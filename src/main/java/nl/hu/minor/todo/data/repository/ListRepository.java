package nl.hu.minor.todo.data.repository;

import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.data.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ListRepository extends JpaRepository<TodoList, UUID> {
    List<TodoList> findByUid(UUID userid);
}
