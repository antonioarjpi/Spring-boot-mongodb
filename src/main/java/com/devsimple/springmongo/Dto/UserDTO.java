package com.devsimple.springmongo.Dto;

import com.devsimple.springmongo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO (User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
