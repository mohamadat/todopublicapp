package nl.hu.minor.todo.web.mapper;
import nl.hu.minor.todo.data.entity.Task;
import nl.hu.minor.todo.web.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    @Mappings({
            @Mapping(target="lid", source="task.listid"),
    })
    TaskDto toDto(Task task);

    @Mappings({
            @Mapping(target="listid", source="dto.lid"),
    })
    Task toModel(TaskDto dto);
}
