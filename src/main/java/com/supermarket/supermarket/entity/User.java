package com.supermarket.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private Long id;
    @JsonIgnore
    private String encodedPassword;
}
