package nl.hu.minor.todo.web.controller;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.domain.service.ListService;
import nl.hu.minor.todo.domain.service.TaskService;
import nl.hu.minor.todo.domain.service.UserService;
import nl.hu.minor.todo.web.dto.ListDto;
import nl.hu.minor.todo.web.dto.TaskDto;
import nl.hu.minor.todo.web.dto.UserDto;
import nl.hu.minor.todo.web.mapper.ListMapper;
import nl.hu.minor.todo.web.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Data
@Validated
public class ListController {

    @Autowired
    private ListMapper listMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private ListService listService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @PostMapping("list")
    public Object create(@Valid @RequestBody final ListDto dto) {

        TodoList list = listMapper.INSTANCE.toModel(dto);
        System.out.println(dto.getUid());
//        add user to the list
        if (dto.getUid() == null){return new ResponseEntity( HttpStatus.UNAUTHORIZED);}
        list.setUser(userService.findUser(dto.getUid()));
        list.setUid(dto.getUid());
        final TodoList savedlist = listService.save(list);
//        return null;

        return  listMapper.INSTANCE.toDto(savedlist);
//        return new ResponseEntity<ListDto>(
//                listMapper.INSTANCE.toDto(savedlist), HttpStatus.OK);

//        return new ResponseEntity<UserDto>( HttpStatus.UNAUTHORIZED);}
    }

    //to save a task to old list
    @PostMapping("list/{listId}")
    public Object addTaskToList(@Valid @RequestBody final TaskDto dto) {
        Task task = taskMapper.INSTANCE.toModel(dto);
//        if (dto.getLid() == null){return new ResponseEntity( HttpStatus.BAD_REQUEST);}
        task.setListy(listService.findById(dto.getLid()));
        task.setListid(dto.getLid());
        final Task savedTask = taskService.save(task);

        return  taskMapper.INSTANCE.toDto(savedTask);
    }

    @GetMapping("list")
    public List<ListDto> allLists() {
        final var allusers = listService.findalltasks();
        return allusers.stream().map(listMapper::toDto).collect(Collectors.toList());

    }
    @GetMapping("list/user/{userid}")
    public List<ListDto> allLists(@PathVariable("userid") UUID userid) {
        final var userslists = listService.findByuserid(userid);
        return userslists.stream().map(listMapper::toDto).collect(Collectors.toList());

    }


    @GetMapping("list/tasks/{userid}")
    public List<ListDto> getlistsbyuserid(@PathVariable("userid") UUID userid) {
        System.out.println("userid" + userid);
        final var allUserLists = listService.findByuserid(userid);
        return allUserLists.stream().map(listMapper::toDto).collect(Collectors.toList());

    }
}

