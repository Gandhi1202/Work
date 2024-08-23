package com._gid.planner.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    //  private Integer userId;
    //  @Column(name="user_names")
    @ElementCollection
    private List<String> userNames;



    /*
     * public Integer getId() { return id; }
     *
     * public void setId(Integer id) { this.id = id; } public String getName() {
     * return name; }
     *
     * public void setName(String name) { this.name = name; }
     *
     * public Integer getUserId() { return userId; }
     *
     * public void setUserId(Integer userId) { this.userId = userId; }
     */

}
