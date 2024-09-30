# GeoLocaliza-API-Nominatim

## Ideia
Utilizando a API gratuita Nominatim do projeto OpenStreetMap para realizar geocodificação reversa, permitindo que os usuários conversem coordenadas geográficas (latitude e longitude) em informações de localização (país, estado e cidade).

## Technologies
- Spring Web
- Java
- Spring Boot

## Endpoints

* **GET** `http://localhost:8080/api/geolocaliza/reverse?lat=40.7128&lon=-74.0060`  
  O usuário deve informar a latitude e a longitude para obter informações sobre o país, estado e cidade correspondentes.

#### **OK 200**
```json
{
  "pais": "United States",
  "estado": "New York",
  "cidade": "City of New York"
}
```

* **GET** do Sobre `http://localhost:8080/sobre`  
Mostrar meus dados e do trabalho

### **OK 200**
```json
{
    "projeto": "Geolocalizacao",
    "estudante": "Matheus da Silva Gastaldi"
}
```

* **POST** `http://localhost:8080/api/geolocaliza/reverse`  
  O usuário deve enviar um JSON contendo latitude e longitude para receber as informações de localização.

### Requisição raw

```json
{
  "lat": 40.7128,
  "lon": -74.0060
} 
```
Passando a pergunta juntamente da resposta.

### **OK 200**
```json
{
  "pais": "United States",
  "estado": "New York",
  "cidade": "City of New York"
}
```

Sendo essas informações correspondentes ao JSON passado.

### Requisição raw

```json
{
  "lat": -28.6783,
  "lon": -49.3704
} 
```
### **OK 200**
```json
{
  "pais": "Brasil",
  "estado": "Santa Catarina",
  "cidade": "Criciúma"
}
```


## Como rodar

* Clonar o repositório: 
```bash
git clone https://github.com/Matheus2037/GeoLocaliza-API-Nominatim.git
```

* Abrir o projeto no interpretador de sua preferência: 
```bash
E rodar a classe GeolocalizacaoApplication.java
```
