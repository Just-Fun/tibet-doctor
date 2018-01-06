package com.serzh.tibetdoctor.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/**
 * @author sergii.zagryvyi on 06.01.2018
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlingControllerAdvice {

    /**
     * Convert a predefined exception to an HTTP Status code and specify the
     * name of a specific view that will be used to display the error.
     *
     * @return Exception view.
     */
    @ExceptionHandler({SQLException.class, Exception.class})
    public String databaseError(Exception exception, Model model) {
        // Nothing to do. Return value 'databaseError' used as logical view name
        // of an error page, passed to view-resolver(s) in usual way.
        String exceptionMessage = exception.getMessage();

        log.error("Something went wrong: ", exceptionMessage);
        exceptionMessage = exceptionMessage.replaceAll("/", "").replaceAll(";", "");

        return "redirect:/error/" + exceptionMessage;
    }
}
