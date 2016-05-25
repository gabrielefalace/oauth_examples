package com.oauth.com.oauth.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooService {

    @RequestMapping(value = "/foo", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER') and principal == #content.owner and #content.text.length() <= 20")
    public String foo(@RequestBody Content content){
        String result = "It works";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return result;
    }

}
