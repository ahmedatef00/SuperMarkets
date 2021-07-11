package com.supermarket.supermarket.exception;

public class SupermarketNotFoundException extends Throwable {
    public SupermarketNotFoundException(Long id) {
        super("Could not find Supermarke with id" + id + ".");
    }
}
