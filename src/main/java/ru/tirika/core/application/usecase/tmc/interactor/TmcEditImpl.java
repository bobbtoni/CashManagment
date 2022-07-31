package ru.tirika.core.application.usecase.tmc.interactor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.EditTmcCommand;
import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcEdit;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.domain.event.TmcEditedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcEditImpl implements TmcEdit {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public TmcEditImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Tmc> execute(EditTmcCommand editTmcCommand) {
        final Tmc currentTmc = tmcPort.findObject(editTmcCommand.getIdTmc());
        final String newName;
        if (editTmcCommand.getNewName() != null) {
            newName = editTmcCommand.getNewName();
        } else {
            newName = currentTmc.getName();
        }
        final BigDecimal newPrice;
        if (editTmcCommand.getNewPrice() != null) {
            newPrice = editTmcCommand.getNewPrice();
        } else {
            newPrice = currentTmc.getPrice();
        }
        final Tmc editableTmc = new Tmc(currentTmc.getId(), newName, newPrice, currentTmc.getRemainCount(), currentTmc.getIdGroup());
        tmcPort.saveObject(editableTmc);

        eventManager.notify(new TmcEditedEvent(currentTmc, editableTmc));
        return ResultExecution.ok(editableTmc);
    }

}
