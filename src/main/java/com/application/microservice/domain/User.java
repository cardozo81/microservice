package com.application.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user", schema = "public")
public class User {

    @Column(name = "id", unique = true, nullable = false)
    @Id
    private Long id;

    @Column(name = "username", length = 60, nullable = false, unique = true)
    private String username;

    @Column(name = "id_user_status", length = 3, nullable = false)
    private Integer idUserStatus;

}
