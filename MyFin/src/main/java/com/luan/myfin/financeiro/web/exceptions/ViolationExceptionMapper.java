package com.luan.myfin.financeiro.web.exceptions;

import com.luan.myfin.financeiro.base.models.ViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

        List<ViolationException> violationExceptions = new ArrayList<>();
        constraintViolations.forEach(violation -> {
            ViolationException violationException = new ViolationException();
            violationException.setMessage(violation.getMessage());
            violationException.setValue(String.valueOf(violation.getInvalidValue()));
            
            violationExceptions.add(violationException);
        });

        return Response.status(Response.Status.BAD_REQUEST).entity(violationExceptions).build();
    }

}
