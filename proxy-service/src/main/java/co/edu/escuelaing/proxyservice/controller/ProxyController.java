package co.edu.escuelaing.proxyservice.controller;

import co.edu.escuelaing.proxyservice.service.HttpClient;
import co.edu.escuelaing.proxyservice.service.RoundRobinLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @Autowired
    private RoundRobinLoadBalancer loadBalancer;

    @Autowired
    private HttpClient httpClient;

    @GetMapping("/collatzsequence")
    public ResponseEntity<String> collatzSequence(@RequestParam(value = "value") int value) {
        try {
            String server = loadBalancer.getNextServer();
            String url = server + "/math/collatzsequence?value=" + value;
            String response = httpClient.get(url);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Proxy OK - Servidores: " + loadBalancer.getServers());
    }
}
