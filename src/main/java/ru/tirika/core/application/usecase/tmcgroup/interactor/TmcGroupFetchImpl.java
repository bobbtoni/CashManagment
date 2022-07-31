package ru.tirika.core.application.usecase.tmcgroup.interactor;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupFetch;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.domain.event.TmcGroupFetchedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGroupFetchImpl implements TmcGroupFetch {

    private final TmcGroupPort tmcGroupPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGroupFetchImpl(TmcGroupPort tmcGroupPort, EventManager eventManager) {
        this.tmcGroupPort = tmcGroupPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Collection<TmcGroup>> execute(FetchCommand data) {
        final Collection<TmcGroup> tmcGroups = tmcGroupPort.findPartitionalObjects(data.getOffset(), data.getLimit());
        eventManager.notify(new TmcGroupFetchedEvent(LocalDateTime.now(), tmcGroups.size()));
        return ResultExecution.ok(tmcGroups);
    }

}
