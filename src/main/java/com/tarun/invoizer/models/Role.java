package com.tarun.invoizer.models;

import com.tarun.invoizer.models.enums.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
