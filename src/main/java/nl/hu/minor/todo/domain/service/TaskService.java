package nl.hu.minor.todo.domain.service;

import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.data.repository.ListRepository;
import nl.hu.minor.todo.data.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ListRepository listRepository;

    public Task save(Task taskToSave) {
        return taskRepository.save(taskToSave);
    }
    public Task save2(Task taskToSave) {
        //test list
        TodoList listy = new TodoList();
        listy.setTitle("Default List");
        listy.setDesc("Default Desc");
        System.out.println("hoi test start");
        System.out.println(listy.toString());

        TodoList savedList = listRepository.save(listy);
        System.out.println("savedList" + savedList.toString());

        System.out.println("hoi test ends");

        taskToSave.setListy(savedList);
        return taskRepository.save(taskToSave);
    }

    public List<Task> findalltasks() {
        return taskRepository.findAll();
    }

    public List<Task> findBylistid(UUID fromString) {
        return taskRepository.findBylistid(fromString);
    }
}
