package com.goncalomatias1.l05gr06.Controller;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Mock
    private Application mockApplication;

    private TestController testController;
    private Object testModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testModel = new Object();
        testController = new TestController(testModel);
    }

    @Test
    void testGetModel() {
        assertEquals(testModel, testController.getModel());
    }

    @Test
    void testStep() throws IOException {
        GUI.ACTION testAction = GUI.ACTION.NONE;
        testController.step(mockApplication, testAction);
    }

    private static class TestController extends Controller<Object> {

        public TestController(Object model) {
            super(model);
        }

        @Override
        public void step(Application application, GUI.ACTION action) {
        }
    }
}
