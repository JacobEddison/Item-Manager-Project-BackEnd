package com.qa;

import com.qa.controllers.ArmourControllerTest;
import com.qa.controllers.LoadoutControllerTest;

import com.qa.service.ArmourServiceTest;
import com.qa.service.LoadoutServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ArmourControllerTest.class, ArmourServiceTest.class, LoadoutControllerTest.class, LoadoutServiceTest.class, AppTest.class})
public class MokitoTestSuite {
}
