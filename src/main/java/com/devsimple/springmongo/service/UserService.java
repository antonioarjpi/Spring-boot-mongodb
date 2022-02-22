package com.devsimple.springmongo.service;

import com.devsimple.springmongo.Dto.UserDTO;
import com.devsimple.springmongo.model.User;
import com.devsimple.springmongo.repository.UserRepository;
import com.devsimple.springmongo.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! "));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(user);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

}
