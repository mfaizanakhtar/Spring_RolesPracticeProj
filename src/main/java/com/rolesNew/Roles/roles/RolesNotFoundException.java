package com.rolesNew.Roles.roles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RolesNotFoundException extends RuntimeException {
    public RolesNotFoundException(String message) {
        super(message);
    }
}
