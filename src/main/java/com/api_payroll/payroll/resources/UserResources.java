package com.api_payroll.payroll.resources;

import com.api_payroll.payroll.domain.User;
import com.api_payroll.payroll.dto.UserDTO;
import com.api_payroll.payroll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResources {

    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public  ResponseEntity <UserDTO> findById(@PathVariable String id){
        User obj = service.findByID(id);
       return ResponseEntity.ok().body(new UserDTO(obj));
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insertUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public  ResponseEntity <UserDTO> deleteById(@PathVariable String id){
        User obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

