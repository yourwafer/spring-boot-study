package com.tw.study.springboot.endpoint.handler;

import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseExceptionMapper implements ExceptionMapper<RuntimeException> {
    private static final Logger LOG = Logger.getLogger(ResponseExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException exception) {
//        String fullStackTrace = ExceptionUtils.getFullStackTrace(exception);
//        LOG.warn("ResponseException with status: " + exception.getStatus());
//        LOG.warn(fullStackTrace);

        return Response.status(500).build();
    }
}