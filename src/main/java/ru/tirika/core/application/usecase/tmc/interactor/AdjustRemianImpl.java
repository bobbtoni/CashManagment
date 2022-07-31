package ru.tirika.core.application.usecase.tmc.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.AddRemianTmcCommand;
import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.AdjustRemian;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.domain.event.AdjustedRemianEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class AdjustRemianImpl implements AdjustRemian {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public AdjustRemianImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Void> execute(AddRemianTmcCommand remianModel) {
        final Tmc tmc = tmcPort.findObject(remianModel.getIdTmc());
        final Tmc editedTmc = new Tmc(tmc.getId(), tmc.getName(), tmc.getPrice(), remianModel.getRemainedCount(), tmc.getIdGroup());
        tmcPort.saveObject(editedTmc);

        eventManager.notify(new AdjustedRemianEvent(tmc.getId(), remianModel.getRemainedCount()));
        return ResultExecution.ok(null);
    }

}
