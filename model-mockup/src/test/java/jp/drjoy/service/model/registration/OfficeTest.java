package jp.drjoy.service.model.registration;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by gmaeda on 2017/06/07.
 */
public class OfficeTest {
    @Test
    public void setOrganization() throws Exception {
        Office office = new Office();
        Office.Node org = new Office.Node("1", "組織1", "sosiki1");
        org.setChildren(Arrays.asList(
            new Office.Node("1-1", "組織1-1", "sosiki1-1"),
            new Office.Node("1-2", "組織1-2", "sosiki1-2")
        ));
        office.setOrganization(org);
    }

}
