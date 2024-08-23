package com._gid.planner.service;



import com._gid.planner.entity.Tasks;
import com._gid.planner.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Tasks> getTaskById(Integer id) {
        return tasksRepository.findById(id);
    }

    public Tasks saveTask(Tasks task) {
        return tasksRepository.save(task);
    }

    public void deleteTask(Integer id) {
        tasksRepository.deleteById(id);
    }

    public List<Tasks> getTaskByProjectId(Integer projectId) {
        // TODO Auto-generated method stub
        return tasksRepository.findByProjectId(projectId);
    }

    public List<Tasks> getTaskByUserId(Integer userId) {
        // TODO Auto-generated method stub
        return tasksRepository.findByUserId(userId);
    }

    public List<Tasks> getTaskByProjectIdAndUserId(Integer projectId, Integer userId) {
        // TODO Auto-generated method stub
        return tasksRepository.findByProjectIdAndUserId(projectId,userId);
    }

    /*
     * public List<Tasks> getTasksByProjectId(Integer projectId) { return
     * tasksRepository.findByProjectId(projectId); }
     *
     * public List<Tasks> getTasksByUserId(Integer userId) { return
     * tasksRepository.findByUserId(userId); }
     *
     * public List<Tasks> getTasksByUserIdAndProjectId(Integer userId, Integer
     * projectId) { return tasksRepository.findByUserIdAndProjectId(userId,
     * projectId); }
     */
}
