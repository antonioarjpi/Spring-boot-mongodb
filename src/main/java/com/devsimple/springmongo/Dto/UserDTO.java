package com.devsimple.springmongo.Dto;

import com.devsimple.springmongo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO (User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
