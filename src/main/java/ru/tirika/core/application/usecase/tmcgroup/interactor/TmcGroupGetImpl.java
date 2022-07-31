package ru.tirika.core.application.usecase.tmcgroup.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupGet;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.domain.event.TmcGroupGetEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGroupGetImpl implements TmcGroupGet {

    private final TmcGroupPort tmcGroupPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGroupGetImpl(TmcGroupPort tmcGroupPort, EventManager eventManager) {
        this.tmcGroupPort = tmcGroupPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<TmcGroup> execute(Long id) {
        final TmcGroup tmcGroup = tmcGroupPort.findObject(id);
        eventManager.notify(new TmcGroupGetEvent(tmcGroup));

        final ResultExecution<TmcGroup> result;
        if (tmcGroup == null) {
            result = ResultExecution.fail("Not Found");
        } else {
            result = ResultExecution.ok(tmcGroup);
        }
        return result;
    }

}
