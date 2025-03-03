package com.example.task.management.system.repository;

import com.example.task.management.system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
