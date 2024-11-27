package software.darragh.website.controllers;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/hx")
public class HxController {

    @GetMapping("/main/{content}")
    @HxRequest(target = "main", triggerName="main-change")
    public HtmxResponse mainContent(@PathVariable String content) {
        var response = HtmxResponse.builder();

        response.view("fragments/main :: " + content);

        response.view(new ModelAndView(
                "fragments/common :: nav-list",
                Map.of("current", content)
        ));

        return response.build();
    }
}
