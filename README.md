# Sistema de Microservicios - Calculadora Matemática

**Autor:** Angie Ramos  
**Materia:** Arquitecturas Empresariales  
**Universidad:** Escuela Colombiana de Ingeniería Julio Garavito

## Descripción del Proyecto

Este proyecto implementa un sistema de microservicios para realizar cálculos matemáticos complejos. La arquitectura está basada en el patrón de Service Proxy con balanceo de carga Round-Robin, desplegada en AWS EC2.

```

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación
- **Spring Boot 3.3.0**: Framework para el desarrollo de microservicios
- **Maven**: Gestión de dependencias y construcción del proyecto
- **HTML5 + JavaScript**: Cliente web asíncrono
- **AWS EC2**: Despliegue en la nube
- **Git & GitHub**: Control de versiones

## Estructura del Proyecto

```
LabApp-main/
├── math-service/              # Servicio de cálculos matemáticos
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── co/edu/escuelaing/mathservice/
│   │       │       ├── MathServiceApplication.java
│   │       │       ├── controller/
│   │       │       │   └── MathController.java
│   │       │       ├── service/
│   │       │       │   └── MathCalculator.java
│   │       │       └── model/
│   │       │           └── MathResponse.java
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
├── proxy-service/             # Servicio proxy con balanceo Round-Robin
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── co/edu/escuelaing/proxyservice/
│   │       │       ├── ProxyServiceApplication.java
│   │       │       ├── controller/
│   │       │       │   └── ProxyController.java
│   │       │       └── service/
│   │       │           ├── RoundRobinLoadBalancer.java
│   │       │           └── HttpClient.java
│   │       └── resources/
│   │           ├── application.properties
│   │           └── static/
│   │               └── index.html
│   └── pom.xml
├── pom.xml                    # POM padre del proyecto
└── README.md
```

## Prerequisitos

### Para Desarrollo Local

1. **Java Development Kit (JDK) 17**
   ```bash
   java -version
   # Debe mostrar: java version "17.x.x"
   ```

2. **Maven 3.6+**
   ```bash
   mvn -version
   # Debe mostrar: Apache Maven 3.6.x o superior
   ```

3. **Git**
   ```bash
   git --version
   ```

### Para Despliegue en AWS

1. Cuenta de AWS Academy o AWS personal
2. 3 instancias EC2 (Amazon Linux 2)
3. Configuración de Security Groups para permitir tráfico en los puertos necesarios

## Instalación y Ejecución Local

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/ParcialAREP2.git
cd ParcialAREP2
```

### Paso 2: Compilar el Proyecto

```bash
mvn clean package
```

Esto generará los archivos JAR en:
- `math-service/target/math-service-1.0.0.jar`
- `proxy-service/target/proxy-service-1.0.0.jar`

### Paso: Acceder a la Aplicación

Abrir en el navegador: `http://localhost:8080`

#### 1. Crear 3 Instancias EC2

- **Instancia 1**: Math ServiceOne
- **Instancia 2**: Math ServiceTwo
- **Instancia 3**: Proxy Service

**Especificaciones recomendadas:**
- AMI: Amazon Linux 2 o Ubuntu Server 22.04
- Tipo: t3.micro (Free Tier eligible)
- Security Group: Permitir tráfico en puertos
```

#### 3. Instalar Java en cada instancia

Conectarse a cada instancia via SSH:

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
