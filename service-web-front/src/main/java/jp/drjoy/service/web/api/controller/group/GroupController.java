package jp.drjoy.service.web.api.controller.group;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by k.sumi on 6/19/2017.
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @RequestMapping("/list")
    public String list() {
        return "Web group list";
    }
}
