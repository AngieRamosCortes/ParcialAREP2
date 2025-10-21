# Sistema de Microservicios - Calculadora Matemática

**Autor:** Angie Ramos  
**Materia:** Arquitecturas Empresariales  
**Universidad:** Escuela Colombiana de Ingeniería Julio Garavito

## Descripción del Proyecto

Este proyecto implementa un sistema de microservicios para realizar cálculos matemáticos complejos. La arquitectura está basada en el patrón de Service Proxy con balanceo de carga Round-Robin, para ser desplegada en AWS EC2.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación
- **Spring Boot 3.3.0**: Framework para el desarrollo de microservicios
- **Maven**: Gestión de dependencias y construcción del proyecto
- **HTML5 + JavaScript**: Cliente web 
- **AWS EC2**: Despliegue en la nube
- **Git & GitHub**: Control de versiones

## Estructura del Proyecto

```
C:.
│   LICENSE
│   pom.xml
│   README.md
│
├───math-service
│   │   pom.xml
│   │
│   └───src
│       └───main
│           ├───java
│           │   └───co
│           │       └───edu
│           │           └───escuelaing
│           │               └───mathservice
│           │                   │   MathServiceApplication.java
│           │                   │
│           │                   ├───controller
│           │                   │       MathController.java
│           │                   │
│           │                   ├───model
│           │                   │       MathResponse.java
│           │                   │
│           │                   └───service
│           │                           MathCalculator.java
│           │
│           └───resources
│                   application.properties
│
└───proxy-service
    │   pom.xml
    │
    └───src
        └───main
            ├───java
            │   └───co
            │       └───edu
            │           └───escuelaing
            │               └───proxyservice
            │                   │   ProxyServiceApplication.java
            │                   │
            │                   ├───controller
            │                   │       ProxyController.java
            │                   │
            │                   └───service
            │                           HttpClient.java
            │                           RoundRobinLoadBalancer.java
            │
            └───resources
                │   application.properties
                │
                └───static
                        index.html
```

## Prerequisitos

### Para Desarrollo Local
Hemos usado Spring Initializr
<img width="643" height="276" alt="image" src="https://github.com/user-attachments/assets/9af8e5f1-3eee-4e56-a9e1-d64f5e789c3a" />


1. **Java Development Kit (JDK) 17**
   ```bash
   java -version
   ```

2. **Maven 3.6+**
   ```bash
   mvn -version
   ```

3. **Git**
   ```bash
   git --version
   ```

### Para Despliegue en AWS

1. Cuenta de AWS Academy
2. 3 instancias EC2 (Amazon Linux 2)
3. Configuración de Security Groups para permitir tráfico en los puertos necesarios

## Instalación y Ejecución Local

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/AngieRamosCortes/ParcialAREP2
cd ParcialAREP2
```

### Paso 2: Compilar el Proyecto

```bash
mvn clean package
```

Esto generará los archivos JAR en:
- `math-service/target/math-service-1.0.0.jar`
- `proxy-service/target/proxy-service-1.0.0.jar`
<img width="227" height="132" alt="image" src="https://github.com/user-attachments/assets/ccfd981b-07bb-4914-aec6-12caac5f6d48" />

### Paso: Acceder a la Aplicación

Abrir en el navegador: `http://localhost:8080`

#### 1. Crear 3 Instancias EC2

- **Instancia 1**: Math ServiceOne
- **Instancia 2**: Math ServiceTwo
- **Instancia 3**: ProxySpring
<img width="1365" height="624" alt="image" src="https://github.com/user-attachments/assets/7191f400-fae8-4acf-a521-21da55482938" />
<img width="1081" height="187" alt="image" src="https://github.com/user-attachments/assets/b8e1488e-be1a-4667-8ee7-243a65814e2d" />
<img width="1365" height="625" alt="image" src="https://github.com/user-attachments/assets/3d23bb59-ba95-4b60-b310-a5130b5bd48c" />
<img width="1074" height="183" alt="image" src="https://github.com/user-attachments/assets/6e93a75e-3946-4b31-b58d-9ee3f9fc9963" />
<img width="1365" height="625" alt="image" src="https://github.com/user-attachments/assets/fd63491e-7bdf-4dd8-84e2-586209750a20" />
<img width="1077" height="182" alt="image" src="https://github.com/user-attachments/assets/2fbcb016-b795-4973-9009-63a91488e440" />


**Especificaciones recomendadas:**
- AMI: Amazon Linux 2 o Ubuntu Server 22.04
- Tipo: t3.micro (Free Tier eligible)
- Security Group: Permitir tráfico en puertos
  
<img width="1365" height="628" alt="image" src="https://github.com/user-attachments/assets/ff85506d-c8ce-432a-a7b8-1f7bdef252fa" />

#### 3. Instalar Java en cada instancia

Conectarse a cada instancia via SSH:
<img width="1365" height="516" alt="image" src="https://github.com/user-attachments/assets/acd56d66-75e0-4cc0-9891-93e4a1cf8cc5" />

**Para Amazon Linux 2:**
```bash
sudo yum update -y
sudo yum install java-17-amazon-corretto-devel -y
java -version
```
## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Autor

**Angie Ramos**  
Estudiante de Ingeniería de Sistemas  
Escuela Colombiana de Ingeniería Julio Garavito  
Materia: Arquitecturas Empresariales

## Agradecimientos

- Profesor de Arquitecturas Empresariales por la guía del parcial
- Documentación oficial de Spring Boot
- AWS Academy por los recursos educativos
- Comunidad de Stack Overflow por resolver dudas técnicas

---
