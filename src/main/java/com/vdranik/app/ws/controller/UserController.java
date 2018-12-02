package com.vdranik.app.ws.controller;

import com.vdranik.app.ws.service.UserService;
import com.vdranik.app.ws.shared.dto.UserDto;
import com.vdranik.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vdranik.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public String getUser(){
    return "get user was called";
  }

  @PostMapping
  public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
    UserRest returnValue = new UserRest();
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userDetails, userDto);

    UserDto createdUser = userService.createUser(userDto);
    BeanUtils.copyProperties(createdUser, returnValue);
    return returnValue;
  }

  @PutMapping
  public String updateUser(){
    return "updateUser was called";
  }

  @DeleteMapping
  public String deleteUser(){
    return "deleteUser was called";
  }
}
