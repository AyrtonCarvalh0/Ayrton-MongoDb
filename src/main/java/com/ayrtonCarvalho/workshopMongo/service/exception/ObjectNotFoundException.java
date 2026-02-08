package com.ayrtonCarvalho.workshopMongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
