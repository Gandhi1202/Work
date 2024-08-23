package com._gid.planner.controller;

import com._gid.planner.entity.Tasks;
import com._gid.planner.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")

public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping
    public List<Tasks> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable Integer id) {
        Optional<Tasks> task = tasksService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
        Tasks createdTask = tasksService.saveTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable Integer id, @RequestBody Tasks task) {
        if (!tasksService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        task.setId(id);
        return ResponseEntity.ok(tasksService.saveTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        if (!tasksService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        tasksService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // it will get the all the data through the project id
    @GetMapping("projects/{id}")
    public List<Tasks> getByProjectId(@PathVariable("id") Integer projectId)
    {
        return tasksService.getTaskByProjectId(projectId);
    }

    //it will get the data by user id
    //methods names are all ways like as variable name like UserId(variable)  method for this
    //if the variable name is user_id  need to match the method and variable method like getByUser_id(Integer user_id23)
    @GetMapping("user/{id}")
    public List<Tasks> getByUserId(@PathVariable("id") Integer userId)
    {
        return tasksService.getTaskByUserId(userId);

    }

    //get the tasks by project id and user id if the both value are present in the row it will show task data else data will not showing
    @GetMapping("/projects/{pid}/user/{uid}")
    public List<Tasks> getTaskByProjectIdAndUserId(@PathVariable("pid") Integer projectId, @PathVariable("uid") Integer userId)
    {
        return tasksService.getTaskByProjectIdAndUserId(projectId,userId);

    }

}
