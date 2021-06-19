package com.sunny.enterprise.core.product.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
    UnsupportedProduct.class
    })
    @Nullable
    public ResponseEntity<Object> handler(Exception ex, WebRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof UnsupportedProduct) {
            HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
            return handleExceptionInternal(ex, null, headers, status, request);
        } else {
            throw ex;
        }
    }
}