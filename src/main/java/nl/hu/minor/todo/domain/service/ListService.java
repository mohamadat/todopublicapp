package nl.hu.minor.todo.domain.service;

import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.data.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListService {
    @Autowired
    private ListRepository listRepository;
    public TodoList save(TodoList list) {
        return listRepository.save(list);
    }
    public List<TodoList> findalltasks() {
        return listRepository.findAll();
    }


    public TodoList findById(UUID lid) {
        Object toFind = listRepository.findById(lid);
        return listRepository.findById(lid).get();
    }

    public List<TodoList> findByuserid(UUID userid) {
//        Object toFind = listRepository.findByUid(userid);
        return listRepository.findByUid(userid);
    }
}
