package com.api_payroll.payroll.service;

import com.api_payroll.payroll.domain.User;
import com.api_payroll.payroll.dto.UserDTO;
import com.api_payroll.payroll.repository.UserRepository;
import com.api_payroll.payroll.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findByID(String id){
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insertUser(User obj){
        return repo.insert(obj);
    }

    public User delete(String id){
        findByID(id);
        repo.deleteById(id);
        return null;
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void updateData(User newObj ,User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
