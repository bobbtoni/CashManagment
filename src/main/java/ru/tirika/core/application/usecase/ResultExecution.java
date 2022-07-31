package ru.tirika.core.application.usecase;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class ResultExecution<R> {
    private final Collection<String> errors;
    private final R result;

    private ResultExecution(R result, String... errors) {
        this.result = result;
        this.errors = new HashSet<>();
        for (String error : errors) {
            this.errors.add(error);
        }
    }

    public static <R> ResultExecution<R> ok(R result) {
        return new ResultExecution<R>(result);
    }

    public static <R> ResultExecution<R> fail(String... errors) {
        return new ResultExecution<R>(null, errors);
    }

    public boolean isSuccess() {
        return errors.isEmpty();
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public R getResult() {
        if (isSuccess()) {
            return result;
        } else {
            throw new IllegalStateException("Результат не может быть получен. Выполнение операции закончилось с ошибкой");
        }
    }

    public Collection<String> getErrors() {
        return Collections.unmodifiableCollection(errors);
    }
}
