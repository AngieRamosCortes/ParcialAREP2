package co.edu.escuelaing.mathservice.controller;

import co.edu.escuelaing.mathservice.model.MathResponse;
import co.edu.escuelaing.mathservice.service.MathCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathCalculator calculator;

    private String getInstanceInfo() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String port = System.getProperty("server.port", "8080");
            return hostname + ":" + port;
        } catch (Exception e) {
            return "unknown";
        }
    }

    @GetMapping("/collatzsequence")
    public MathResponse collatzSequence(@RequestParam(value = "value") int value) {
        String result = calculator.collatzSequence(value);
        return new MathResponse("collatzsequence", value, result, getInstanceInfo());
    }

    @GetMapping("/health")
    public String health() {
        return "OK - Instance: " + getInstanceInfo();
    }
}
