package com._gid.planner.repository;


import java.util.List;

import com._gid.planner.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



@Repository
public interface TasksRepository extends JpaRepository<Tasks,Integer>{

    //    public List<Tasks> findByProjectId(Project projectId);

    @Query("SELECT t FROM Tasks t WHERE t.project.id = :projectId")
    public List<Tasks> findByProjectId(@Param("projectId") Integer projectId);

    //this method is connect to the findByUserId in the service class
    public List<Tasks> findByUserId(Integer userId);
    //this method is connect to the findByProjectIdAndUserId in the service class
    public	List<Tasks> findByProjectIdAndUserId(Integer projectId, Integer userId);


    /* public List<Tasks> findByProjectId(Integer projectId); */

    /* public List<Tasks> findByUserId(Integer userId); */


    /*
     * @Query("SELECT t FROM Tasks t WHERE t.user_id = :user_id") List<Tasks>
     * findByUserId(@Param("user_id") Integer userId);
     */


    /*
     * public List<Tasks> findByUserIdAndProjectId(Integer userId, Integer
     * projectId);
     */
}
