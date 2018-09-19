package com.example.demo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
@ToString(exclude = "user")
public class Profile {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private String profileName;

    @MapsId
    @OneToOne
    private User user;

    public void assignUser(Long userId) {
        this.id = userId;
        User user = new User();
        user.setId(userId);
        this.user = user;
    }
}
