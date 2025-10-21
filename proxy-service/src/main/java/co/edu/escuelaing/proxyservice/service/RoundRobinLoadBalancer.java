package co.edu.escuelaing.proxyservice.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoundRobinLoadBalancer {

    private final List<String> servers;
    private final AtomicInteger currentIndex;

    public RoundRobinLoadBalancer() {
        this.servers = new ArrayList<>();
        this.currentIndex = new AtomicInteger(0);
        
        // Leer las direcciones de los servidores desde variables de entorno
        String server1 = System.getenv("MATH_SERVICE_1");
        String server2 = System.getenv("MATH_SERVICE_2");
        
        // Si no están definidas, usar valores por defecto
        if (server1 == null || server1.isEmpty()) {
            server1 = "http://localhost:8081";
        }
        if (server2 == null || server2.isEmpty()) {
            server2 = "http://localhost:8082";
        }
        
        servers.add(server1);
        servers.add(server2);
        
        System.out.println("LoadBalancer configurado con servidores:");
        System.out.println("  - " + server1);
        System.out.println("  - " + server2);
    }

    /**
     * Obtiene el siguiente servidor usando el algoritmo Round Robin
     */
    public String getNextServer() {
        if (servers.isEmpty()) {
            throw new IllegalStateException("No hay servidores disponibles");
        }
        
        int index = currentIndex.getAndIncrement() % servers.size();
        return servers.get(index);
    }

    public List<String> getServers() {
        return new ArrayList<>(servers);
    }
}
