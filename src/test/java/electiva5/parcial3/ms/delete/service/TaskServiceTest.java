package electiva5.parcial3.ms.delete.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.context.ActiveProfiles;

import electiva5.parcial3.ms.delete.model.Task;
import electiva5.parcial3.ms.delete.repository.TaskRepository;

import java.util.*;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteTask_shouldSetDeletedAt() {
        Task task = spy(Task.builder().id(1L).build());

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.deleteTask(1L);

        verify(task).delete();
        verify(taskRepository).save(task);
    }

}
