package electiva5.parcial3.ms.delete.service;

import org.springframework.stereotype.Service;

import electiva5.parcial3.ms.delete.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).ifPresent(task -> {
            task.delete();
            taskRepository.save(task);
        });
    }
}
