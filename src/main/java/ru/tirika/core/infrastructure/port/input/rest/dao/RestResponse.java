package ru.tirika.core.infrastructure.port.input.rest.dao;

import java.util.Collection;
import java.util.Collections;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.tirika.core.application.usecase.ResultExecution;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestResponse<R> {
    private final Collection<String> errors;
    private final R result;

    public static <R> RestResponse<R> by(final ResultExecution<R> resultExecution) {
        final RestResponse<R> response;
        if (resultExecution.isSuccess()) {
            response = new RestResponse<R>(Collections.EMPTY_LIST, resultExecution.getResult());
        } else {
            response = new RestResponse<R>(resultExecution.getErrors(), null);
        }
        return response;
    }
}
