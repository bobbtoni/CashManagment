package ru.tirika.core.application.usecase.tmc.interactor;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcFetch;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.domain.event.TmcFetchedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcFetchImpl implements TmcFetch {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public TmcFetchImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Collection<Tmc>> execute(FetchCommand fetchCommand) {
        final Collection<Tmc> tmcs = tmcPort.findPartitionalObjects(fetchCommand.getOffset(), fetchCommand.getLimit());
        eventManager.notify(new TmcFetchedEvent(LocalDateTime.now(), tmcs.size()));
        return ResultExecution.ok(tmcs);
    }

}
