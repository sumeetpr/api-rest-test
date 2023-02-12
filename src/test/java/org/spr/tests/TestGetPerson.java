package org.spr.tests;

import org.spr.helpers.PersonServiceHelper;
import org.spr.models.PersonPojo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.util.List;

public class TestGetPerson {

    private  PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllPersons(){

        List<PersonPojo> response = personServiceHelper.getAllPersons();
        Assert.assertNotNull(response, "Thes persons not null");
//        Assert.assertEquals(response.get(0).getName(), "sumeet");

    }
}
