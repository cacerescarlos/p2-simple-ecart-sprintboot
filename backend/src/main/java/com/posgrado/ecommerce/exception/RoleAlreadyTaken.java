package com.posgrado.ecommerce.exception;

public class RoleAlreadyTaken extends RuntimeException {
    private static final String ERROR_MESSAGE = "Role with name %s already exists.";

    public RoleAlreadyTaken(String role) {
        super(String.format(ERROR_MESSAGE, role));
    }
}
