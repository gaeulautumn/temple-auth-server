package com.temple.authserver.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/user")
    public List<User> listUser(@AuthenticationPrincipal OAuth2Authentication auth2Authentication){
        String username = auth2Authentication.getName();
        Set<String> scopes = auth2Authentication.getOAuth2Request().getScope();

        LOG.info("==>user name : {}", username);
        LOG.info("==>scopes : {}", scopes);

        return userService.findAll();
    }

    //@PreAuthorize("#oauth2.hasScope('write')")
    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userService.save(user);
    }

}
