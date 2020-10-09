package nl.hu.minor.todo.web.controller;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.User;
import nl.hu.minor.todo.domain.service.UserService;
import nl.hu.minor.todo.web.dto.TaskDto;
import nl.hu.minor.todo.web.dto.UserDto;
import nl.hu.minor.todo.web.mapper.TaskMapper;
import nl.hu.minor.todo.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Data
@Validated
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping("user")
    public UserDto create(@Valid @RequestBody final UserDto dto) {
        User user = userMapper.INSTANCE.toModel(dto);
        final User savedUser = userService.save(user);
        return userMapper.INSTANCE.toDto(savedUser);
    }

    @PostMapping("/login")
    public Object login(@Valid @RequestBody final UserDto dto) {
        User toLoguser = userMapper.INSTANCE.toModel(dto);
        final User savedUser = userService.findByUname(toLoguser.getUname());

        //check user exists and password
        if (savedUser != null &&
                dto.getPass() != "" &&
                dto.getPass().equals(savedUser.getPass()) ){
//            return new ResponseEntity<UserDto>(userMapper.INSTANCE.toDto(savedUser), HttpStatus.OK);
           return userMapper.INSTANCE.toDto(savedUser);

        }
        else
        {return new ResponseEntity<UserDto>( HttpStatus.UNAUTHORIZED);}
    }



    @GetMapping("user")
    public List<UserDto> allUsers() {
        final var allusers = userService.findallusers();
        return allusers.stream().map(userMapper::toDto).collect(Collectors.toList());

    }
}

