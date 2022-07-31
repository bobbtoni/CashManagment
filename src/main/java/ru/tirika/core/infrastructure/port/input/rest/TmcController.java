package ru.tirika.core.infrastructure.port.input.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.tirika.core.application.model.AddTmcCommand;
import ru.tirika.core.application.model.EditTmcCommand;
import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcAdd;
import ru.tirika.core.application.usecase.tmc.TmcEdit;
import ru.tirika.core.application.usecase.tmc.TmcFetch;
import ru.tirika.core.application.usecase.tmc.TmcGet;
import ru.tirika.core.application.usecase.tmc.TmcRemove;
import ru.tirika.core.domain.entity.Tmc;
import ru.tirika.core.infrastructure.port.input.rest.dao.RestResponse;

@RestController
@RequestMapping("/tmc")
public class TmcController {

    @Autowired
    private TmcFetch tmcFetchUseCase;
    @Autowired
    private TmcGet tmcGetUseCase;
    @Autowired
    private TmcAdd tmcAddUseCase;
    @Autowired
    private TmcRemove tmcRemoveUseCase;
    @Autowired
    private TmcEdit tmcEditUseCase;

    @GetMapping("/fetch")
    public RestResponse<Collection<Tmc>> fetch(@RequestParam(defaultValue = "0") long offset, @RequestParam(defaultValue = "500") long limit) {
        final ResultExecution<Collection<Tmc>> resultExecution = tmcFetchUseCase.execute(new FetchCommand(offset, limit));
        return RestResponse.by(resultExecution);
    }

    @GetMapping("/find")
    public RestResponse<Tmc> find(@RequestParam long id) {
        final ResultExecution<Tmc> resultExecution = tmcGetUseCase.execute(id);
        return RestResponse.by(resultExecution);
    }

    @PostMapping("/add")
    public RestResponse<Tmc> add(@RequestBody AddTmcCommand addTmcCommand) {
        final ResultExecution<Tmc> resultExecution = tmcAddUseCase.execute(addTmcCommand);
        return RestResponse.by(resultExecution);
    }

    @DeleteMapping("/remove")
    public RestResponse<Boolean> remove(@RequestParam long id) {
        final ResultExecution<Boolean> resultExecution = tmcRemoveUseCase.execute(id);
        return RestResponse.by(resultExecution);
    }

    @PostMapping("/edit")
    public RestResponse<Tmc> edit(@RequestBody EditTmcCommand editTmcCommand) {
        final ResultExecution<Tmc> resultExecution = tmcEditUseCase.execute(editTmcCommand);
        return RestResponse.by(resultExecution);
    }

}
