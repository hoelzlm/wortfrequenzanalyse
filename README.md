# Aufgabe: Wortfrequenzanalyse
### Full-Stack App zum Thema Wortfrequenzanalyse


## Verwendete Technologien
- Frontend: Angular, Tailwind für styling
- Backend: Java Spring Boot App, JBDC Datenbank Adapter mit JPA
- Datenbank: MariaDB

- Docker: Container für Frontend, Backend und Datenbank. Compose für einfaches starten des kompletten Stacks


## Konfiguration
- Backend:
    -  Datenbank-Konfiguration in ``` wortfrequenzanalyse-backend/src/main/resources/application.properties ```

- Frontend:
    - API-Endpunkt-Konfiguration in ``` wortfrequenzanalyse-frontend/src/environments ```

- Datenbank
    - Konfiguration mittels environment variablen. Beispiel kann hier gefunden werden: ``` docker-compose;yml ```
## Startup
### Docker-Compose
1. Terminal im Ordner ``` wortfrequenzanalyse-backend ``` öffnen und ``` ./gradlew build ``` ausführen.
2. ``` docker-compose up --build ``` ausführen in diesem Ordner ausführen

### Manuell (Node v22, Angular CLI, Java 17 werden vom System erwartet)
1. MariaDB lokal installieren, root passwort vergeben und Datenbank mit Namen ``` wortfrequenzanalyse ``` erstellen
2. Backend: Datenbank-Verbindung in Konfiguration anpassen. Terminal im Ordner ``` wortfrequenzanalyse-backend ``` öffnen und ``` ./gradlew bootRun ``` ausführen.
3. Frontend: Terminal im Ordner ``` wortfrequenzanalyse-frontend ``` öffnen. Konfiguration zur Backendverbindung anpassen. ``` npm install ``` ausführen. ``` ng serve ``` ausführen um Frontend zu starten.