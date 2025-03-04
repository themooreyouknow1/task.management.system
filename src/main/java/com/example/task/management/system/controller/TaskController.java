package com.example.task.management.system.controller;

import com.example.task.management.system.model.Task;
import com.example.task.management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }
    @GetMapping("/new")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "task-form";
    }
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task-form";
        }else{
            return "redirect:/tasks";
        }
    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        if (task.getId() != 0){
            taskService.updateTask(task.getId(), task);
        }else{
            taskService.createTask(task);
        }
        return "redirect:/tasks";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            taskService.deleteTaskById(id);
        }
        return "redirect:/tasks";
    }
}
