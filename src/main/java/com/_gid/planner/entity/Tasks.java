package com._gid.planner.entity;

//import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @NotNull
    private String title;

    private String description;

    private String status;

    private LocalDateTime assignDate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String Priority;

    private LocalDateTime deadLine;

    private Double completed;


    @NotNull

    @ManyToOne

    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    /*
     * @NotNull
     *
     * @ManyToOne
     *
     * @Column(name = "project_id") private Project project;
     */

    /*
     * @ManyToOne
     *
     * @JoinColumn(name = "user_id", nullable = false,insertable=false,
     * updatable=false) private User user; // Adding the 'user' field here
     */

}
