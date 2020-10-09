package nl.hu.minor.todo.web.dto;//package nl.hu.opdrachten.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.hu.minor.todo.data.entity.User;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class ListDto {
    private UUID id;

    @NotNull
    private String title;
    @NotNull
    private String desc;
    private UUID uid;

//    private User user;

    private User user;

}
