package nl.hu.minor.todo.data.repository;
import nl.hu.minor.todo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUname(String name);
}
