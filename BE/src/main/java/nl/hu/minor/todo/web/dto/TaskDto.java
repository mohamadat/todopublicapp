package nl.hu.minor.todo.web.dto;

import lombok.*;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.data.entity.User;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class TaskDto {
    private UUID id;

    @NotNull
    private String title;
    @NotNull
    private String body;
    private List<User> editors;
    private UUID lid;
    private TodoList listy;


}
