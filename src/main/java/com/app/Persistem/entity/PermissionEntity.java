package com.app.Persistem.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true, nullable = false, updatable = false   )
    private  String name;

}










