package jp.drjoy.service.mobile.api.controller.group;

import jp.drjoy.service.mobile.api.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by k.sumi on 6/19/2017.
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    /* Group Service */
    private GroupService groupService;

    /**
     * Constractor.
     *
     * @param groupService {@link GroupService}
     */
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping("/list")
    public String list() {
        return groupService.list();
    }
}
