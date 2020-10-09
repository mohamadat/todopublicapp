package nl.hu.minor.todo.web.mapper;
import nl.hu.minor.todo.data.entity.TodoList;
import nl.hu.minor.todo.web.dto.ListDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListMapper {
    ListMapper INSTANCE = Mappers.getMapper(ListMapper.class);
    ListDto toDto(TodoList list);
    TodoList toModel(ListDto dto);
}
