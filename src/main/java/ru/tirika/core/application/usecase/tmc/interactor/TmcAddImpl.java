package ru.tirika.core.application.usecase.tmc.interactor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.AddTmcCommand;
import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcAdd;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.domain.event.TmcAddedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcAddImpl implements TmcAdd {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public TmcAddImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Tmc> execute(AddTmcCommand tmcModel) {
        final Tmc tmc = new Tmc(null, tmcModel.getTmcName(), tmcModel.getPrice(), BigDecimal.ZERO, tmcModel.getIdTmcGroup());
        final Tmc savedTmc = tmcPort.saveObject(tmc);

        eventManager.notify(new TmcAddedEvent(savedTmc));
        return ResultExecution.ok(savedTmc);
    }

}
