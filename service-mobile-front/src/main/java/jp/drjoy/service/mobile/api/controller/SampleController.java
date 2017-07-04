package jp.drjoy.service.mobile.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import jp.drjoy.service.mobile.api.service.SampleService;
import jp.drjoy.service.mobile.model.SampleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


// TODO 削除
@RestController
public class SampleController {

    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @ApiOperation(value = "post message")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account created successfully."),
            @ApiResponse(code = 401, message = "You are not authorized to create an item."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @RequestMapping(value = "/mobile/api/items", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Void> post(@RequestBody SampleItem item) {
        sampleService.register(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "list of items", response = SampleItem.class, responseContainer = "list")
    @RequestMapping(value="/mobile/api/items", method = RequestMethod.GET)
    public ResponseEntity<List<SampleItem>> get() {
        List<SampleItem> items = sampleService.all();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @ApiOperation(value = "find item by item id.", response = SampleItem.class)
    @RequestMapping(value="/mobile/api/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<SampleItem> get(@PathVariable("id") String id) {
        SampleItem item = sampleService.findById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @ApiOperation(value = "put message", response = SampleItem.class, responseContainer = "list")
    @RequestMapping(value="/mobile/api/items/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody SampleItem item) {
        if (!id.equals(item.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        sampleService.modify(item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "delete message", response = SampleItem.class, responseContainer = "list")
    @RequestMapping(value ="/mobile/api/items/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        sampleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
