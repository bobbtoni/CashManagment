package ru.tirika.core.application.usecase.tmc.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcGet;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.domain.event.TmcGetEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGetImpl implements TmcGet {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGetImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Tmc> execute(Long id) {
        final Tmc tmc = tmcPort.findObject(id);
        eventManager.notify(new TmcGetEvent(tmc));

        final ResultExecution<Tmc> result;
        if (tmc == null) {
            result = ResultExecution.fail("Not Found");
        } else {
            result = ResultExecution.ok(tmc);
        }
        return result;
    }

}
