# Spring Boot JPA MySQL - Ejemplo de orquestración con docker-compose


El ejemplo muestra una sencilla API Rest implementada en spring boot (spring mvc) junto con Hibernate como proveedor JPA (persistencia de datos).

Se usa como base de datos para persistir la información, Mysql.

El ejemplo pretende ilustrar las capacidades de docker-compose para orquestrar el despliegue de varias piezas o servicios, en concreto:

- inter-dependencias entre servicios
- mapeo de volúmenes contra disco host
- uso de volúmenes sin mapeo contra disco host
- mapeo de puertos
- expansión de variables de entorno
- uso de ficheros de configuración para proporcionar variables de entorno (env files).
- referencias entre hosts en docker, dentro de la misma red.

# Soporte Kubernetes

###Ejecutar dashboard minikube:
minikube dashboard

###Habilitar la extensión para ingress de minikube
minikube addons enable ingress

###Creación de pod para la BBDD mysql.
minikube kubectl -- create -f mysql-pod.yaml

###Exposición del pod de la BBDD mysql por medio de un servicio.
minikube kubectl -- create -f mysql-service.yaml

###Build de la imagen en local, creando un tag de ejemplo example/boot:latest
docker build . -t example/boot2

###Carga de la imagen desde el registro de docker local al registro del cluster kubernetes (minikube)
minikube image load example/boot2:latest


###Obtención de la IP del pod de mysql: 
kubectl get pod k8s-mysql -o template --template={{.status.podIP}}

### NOTA:
Para el deployment se puede usar la IP del POD del comando anterior, para conectarse por IP.
También se puede ilustrar la conexión mediante el nombre del servicio que es lo que ilustra el yaml en el repo.

###Creación del deployment de la app web
minikube kubectl -- create -f web-application-deployment.yaml

###Creación del servicio para la aplicación web
minikube kubectl -- create service clusterip web-application --tcp=80:8081
o
minikube kubectl -- create -f web-application-service.yaml


###Creación del ingress
minikube kubectl -- apply -f web-application-ingress.yaml

Una vez creado el ingress la app será accesible en la ip que figure en este output de comando:
minikube kubectl -- get ingress

Por ejemplo:
http://192.168.49.2:80/swagger-ui/







