package electiva5.parcial3.ms.delete.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import electiva5.parcial3.ms.delete.dto.ApiResponse;
import electiva5.parcial3.ms.delete.service.TaskService;

@ActiveProfiles("test")
public class DeleteControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private DeleteController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskService).deleteTask(1L);

        ResponseEntity<ApiResponse<Void>> response = taskController.deleteTask(1L);

        assertTrue(response.getBody().isSuccess());
        assertEquals("Task deleted", response.getBody().getMessage());
        verify(taskService, times(1)).deleteTask(1L);
    }
}
