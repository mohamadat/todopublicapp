package nl.hu.minor.todo;

import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.web.dto.TaskDto;
import nl.hu.minor.todo.web.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class TodoApplicationTests {

	@Test
	void contextLoads() {
	}

//
//	@Test
//	public void shouldMaptastToDto() {
//		//given
//		Task task = new Task(UUID.randomUUID(), "title", "lolo" );
//
//		//when
//		TaskDto taskDto = TaskMapper.INSTANCE.toDto( task );
//
//		//then
//		assertThat(taskDto).isNotNull();
//
//	}

}
