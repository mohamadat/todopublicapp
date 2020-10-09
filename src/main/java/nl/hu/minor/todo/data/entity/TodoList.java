package nl.hu.minor.todo.data.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

@ToString
public @Data class TodoList {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;
    private String title;
    private String desc;

    @OneToMany
    private List<Task> tasks;
    private UUID uid;

    @ManyToOne
    private User user;

}


