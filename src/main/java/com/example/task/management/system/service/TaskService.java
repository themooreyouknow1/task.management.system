package com.example.task.management.system.service;


import com.example.task.management.system.model.Task;
import com.example.task.management.system.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
        }
        return taskRepository.save(updatedTask);
    }
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
