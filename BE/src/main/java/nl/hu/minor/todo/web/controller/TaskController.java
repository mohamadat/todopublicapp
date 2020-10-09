package nl.hu.minor.todo.web.controller;//package nl.hu.opdrachten.web.controller;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.domain.service.ListService;
import nl.hu.minor.todo.domain.service.TaskService;
import nl.hu.minor.todo.web.dto.ListDto;
import nl.hu.minor.todo.web.dto.TaskDto;
import nl.hu.minor.todo.web.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Data
@Validated
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ListService listService;


    @PostMapping("task")
    public Object create(@Valid @RequestBody final TaskDto dto) {

        Task task = taskMapper.INSTANCE.toModel(dto);
        if (dto.getLid() == null){return new ResponseEntity( HttpStatus.BAD_REQUEST);}
        task.setListy(listService.findById(dto.getLid()));
        task.setListid(dto.getLid());
        final Task savedTask = taskService.save(task);

        return  taskMapper.INSTANCE.toDto(savedTask);
    }


    @GetMapping("task")
    public List<TaskDto> alltasks() {
        final var allTasks = taskService.findalltasks();
        return allTasks.stream().map(taskMapper::toDto).collect(Collectors.toList());


    }


    @GetMapping("list/{listId}")
    public List<TaskDto> gettasksbylist(@PathVariable("listId") UUID listId) {
        System.out.println("listId" + listId);
        final var allTasks = taskService.findBylistid(listId);
        return allTasks.stream().map(taskMapper::toDto).collect(Collectors.toList());
    }


}

