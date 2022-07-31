package ru.tirika.core.application.usecase;

public interface UseCase<D, R> {
    ResultExecution<R> execute(D data);
}
