package com.heaptrace.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ExperimentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private ZonedDateTime createdAt;
	private String solverMode;
}
