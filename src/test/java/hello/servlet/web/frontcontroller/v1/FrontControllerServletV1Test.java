package hello.servlet.web.frontcontroller.v1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrontControllerServletV1Test {

    @Test
    void isSingleton() {
        //given
        FrontControllerServletV1 v1 = new FrontControllerServletV1();

        //when
        Map<String, ControllerV1> controller = v1.getController();
        String uri = "/front-controller/v1/members/new-form";

        ControllerV1 controllerV1 = controller.get(uri);
        ControllerV1 controllerV2 = controller.get(uri);
        System.out.println("controllerV1 = " + controllerV1);
        System.out.println("controllerV2 = " + controllerV2);

        //then
        Assertions.assertThat(controllerV1).isEqualTo(controllerV2);

    }

}