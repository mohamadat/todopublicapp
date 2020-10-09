package nl.hu.minor.todo.data.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

@ToString
public @Data class Task {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;
    private String title;
    private String body;

//    @NotNull
    private UUID listid;

    @ManyToOne
    private TodoList listy;

    @OneToMany
    private List<User> editors;

}


