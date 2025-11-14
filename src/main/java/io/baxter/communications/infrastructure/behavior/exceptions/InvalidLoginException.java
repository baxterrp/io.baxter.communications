package io.baxter.communications.infrastructure.behavior.exceptions;

public class InvalidLoginException extends RuntimeException{
    public InvalidLoginException(){
        super("Unauthorized");
    }
}
