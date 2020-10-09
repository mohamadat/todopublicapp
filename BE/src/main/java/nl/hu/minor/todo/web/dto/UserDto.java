package nl.hu.minor.todo.web.dto;//package nl.hu.opdrachten.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@ToString
@NoArgsConstructor
@AllArgsConstructor
public @Data class UserDto {
    @NotNull
    private String uname;
    @NotNull
    private String pass;
    private UUID id;


    //getters and setters
}
