package com.workflow.conductor.globalprop;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.globalprop.request.CreateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.request.UpdateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.response.GlobalPropertyResponse;
import com.workflow.conductor.usecase.globalprop.CreateGlobalProperty;
import com.workflow.conductor.usecase.globalprop.DeleteGlobalProperty;
import com.workflow.conductor.usecase.globalprop.FindGlobalProperty;
import com.workflow.conductor.usecase.globalprop.UpdateGlobalProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.GLOBAL_PROPERTY;

@RestController
@RequestMapping(GLOBAL_PROPERTY)
class GlobalPropertyController {

    private final FindGlobalProperty findGlobalProperty;
    private final CreateGlobalProperty createGlobalProperty;
    private final UpdateGlobalProperty updateGlobalProperty;
    private final DeleteGlobalProperty deleteGlobalProperty;

    @Autowired
    public GlobalPropertyController(FindGlobalProperty findGlobalProperty, CreateGlobalProperty createGlobalProperty, UpdateGlobalProperty updateGlobalProperty, DeleteGlobalProperty deleteGlobalProperty) {
        this.findGlobalProperty = findGlobalProperty;
        this.createGlobalProperty = createGlobalProperty;
        this.updateGlobalProperty = updateGlobalProperty;
        this.deleteGlobalProperty = deleteGlobalProperty;
    }

    @GetMapping
    List<GlobalPropertyResponse> getAllProperties() {
        List<GlobalProperty> globalProperties = findGlobalProperty.getAllGlobalProperties();
        return globalProperties.stream()
                .map(GlobalPropertyResponse::from)
                .toList();
    }

    @GetMapping("{id}")
    GlobalPropertyResponse getProperty(@PathVariable long id) {
        GlobalProperty globalProperty = findGlobalProperty.getGlobalProperty(id);
        return GlobalPropertyResponse.from(globalProperty);
    }

    @PostMapping
    void createProperty(@RequestBody CreateGlobalPropertyCommand command) {
        GlobalProperty globalProperty = command.toDomain();
        createGlobalProperty.createGlobalProperty(globalProperty);
    }

    @PutMapping
    void updateProperty(@RequestBody UpdateGlobalPropertyCommand command) {
        GlobalProperty globalProperty = command.toDomain();
        updateGlobalProperty.updateGlobalProperty(globalProperty);
    }

    @DeleteMapping("{id}")
    void deleteProperty(@PathVariable long id) {
        deleteGlobalProperty.deleteGlobalProperty(id);
    }
}
