package com.api_payroll.payroll.resources;

import com.api_payroll.payroll.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResources {
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity <List<User>> findAll(){
        User hugo = new User("13", "HUGO", "maria@gmail.com");
        User alex = new User("2", "Alex", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(hugo, alex));
        return ResponseEntity.ok().body(list);
    }
}
