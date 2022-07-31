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

import ru.tirika.core.application.model.AddTmcGroupCommand;
import ru.tirika.core.application.model.EditTmcGroupCommand;
import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupAdd;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupEdit;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupFetch;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupGet;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupRemove;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.infrastructure.port.input.rest.dao.RestResponse;

@RestController
@RequestMapping("/tmc_group")
public class TmcGroupController {

    @Autowired
    private TmcGroupEdit tmcGroupEditUseCase;
    @Autowired
    private TmcGroupAdd tmcGroupAddUseCase;
    @Autowired
    private TmcGroupRemove tmcGroupRemoveUseCase;
    @Autowired
    private TmcGroupFetch tmcGroupFetchUseCase;
    @Autowired
    private TmcGroupGet tmcGroupGetUseCase;

    @GetMapping("/fetch")
    public RestResponse<Collection<TmcGroup>> fetch(@RequestParam(defaultValue = "0") long offset, @RequestParam(defaultValue = "500") long limit) {
        final ResultExecution<Collection<TmcGroup>> resultExecution = tmcGroupFetchUseCase.execute(new FetchCommand(offset, limit));
        return RestResponse.by(resultExecution);
    }

    @GetMapping("/find")
    public RestResponse<TmcGroup> find(@RequestParam long id) {
        final ResultExecution<TmcGroup> resultExecution = tmcGroupGetUseCase.execute(id);
        return RestResponse.by(resultExecution);
    }

    @PostMapping("/add")
    public RestResponse<TmcGroup> add(@RequestBody AddTmcGroupCommand addTmcGroupCommand) {
        final ResultExecution<TmcGroup> resultExecution = tmcGroupAddUseCase.execute(addTmcGroupCommand);
        return RestResponse.by(resultExecution);
    }

    @DeleteMapping("/remove")
    public RestResponse<Boolean> remove(@RequestParam long id) {
        final ResultExecution<Boolean> resultExecution = tmcGroupRemoveUseCase.execute(id);
        return RestResponse.by(resultExecution);
    }

    @PostMapping("/edit")
    public RestResponse<TmcGroup> edit(@RequestBody EditTmcGroupCommand editTmcGroupCommand) {
        final ResultExecution<TmcGroup> resultExecution = tmcGroupEditUseCase.execute(editTmcGroupCommand);
        return RestResponse.by(resultExecution);
    }

}
