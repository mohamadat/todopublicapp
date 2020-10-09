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
public @Data class User {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;
    @Column(unique=true)
    private String uname;
    private String pass;


    @OneToMany
    private List<TodoList> lists;

}


