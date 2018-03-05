package com.luan.myfin.financeiro.web.exceptions;

import com.luan.myfin.financeiro.base.models.GenericException;
import com.luan.myfin.financeiro.ejb.events.ExceptionEvent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExpectionMapper implements ExceptionMapper<Exception>{
    
    @Inject
    private Event<ExceptionEvent> event;

    @Override
    public Response toResponse(Exception exception){
        
        GenericException genericException = new GenericException();
        
        if(exception.getMessage() == null){
            genericException.setMessage("Véi, deu muito ruim aqui. A culpa é do programador, sorry :(");
        }else{
            genericException.setMessage(exception.getMessage());
        }
        
        ExceptionEvent exceptionEvent = new ExceptionEvent();
        exceptionEvent.setException(exception);
        event.fire(exceptionEvent);
        
        return Response.serverError().entity(genericException).build();
    }
    
}
