package com.application.microservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "public", name = "user")
@SequenceGenerator(schema = "public", name = "usr_seq", sequenceName = "usr_sq1", allocationSize = 1, initialValue = 1)
public class User {

    @Column(name = "id", unique = true, nullable = false)
    @Id
    @GeneratedValue(generator = "usr_seq")
    private Long id;

    @Column(name = "username", length = 60, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "id_user_status", length = 3, nullable = false)
    private Integer idUserStatus;

}
