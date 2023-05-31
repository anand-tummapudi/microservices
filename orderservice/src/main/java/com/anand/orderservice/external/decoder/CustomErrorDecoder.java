package com.anand.orderservice.external.decoder;

import com.anand.orderservice.exception.CustomException;
import com.anand.orderservice.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());
        ErrorResponse errorResponse;
        try {
            errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
            throw new CustomException("Internal Server Error","INTERNAL_SERVER_ERROR",500);
        }
        return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(),response.status());
    }
}
