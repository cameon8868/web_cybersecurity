# web_cybersecurity

Хранение и быстрый поиск шпаргалок по инструментам и приёмам [кибербезопасности](cybersecurity/Cybersecurity.md), ведение разборов (writeups) решённых CTF-задач и лаб, самопроверка знаний.

## Технологии

<p align="left">
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5">
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3">
  <img src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot_4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Spring_Web_MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Web MVC">
  <img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Data JPA">
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" alt="Thymeleaf">
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/springboot4--dotenv-ECD53F?style=for-the-badge&logo=dotenv&logoColor=black" alt="dotenv">
  <img src="https://img.shields.io/badge/Maven_Wrapper-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge" alt="Lombok">
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" alt="Git">
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub">
</p>

## 📋 Содержание

- [Используемые технологии](#используемые-технологии)
- [Использование Spring Boot 4.1.1](#использование-spring-boot-411)
- [Структура проекта](#структура-проекта)
- [Запуск](#запуск)
- [Конфигурация](#конфигурация)
- [Разбор уязвимостей на примере этого сайта](#разбор-уязвимостей-на-примере-этого-сайта)

## Использование Spring Boot 4.1.1

В проекте используются:

- **spring-boot-starter-webmvc** — веб-слой: контроллеры, маршрутизация запросов, обработка форм;
- **spring-boot-starter-thymeleaf** — серверный рендеринг HTML-страниц из шаблонов;
- **spring-boot-starter-data-jpa** — работа с базой данных через сущности и репозитории (шпаргалки, writeups, вопросы для самопроверки);
- **PostgreSQL JDBC driver** — подключение к СУБД PostgreSQL;
- **springboot4-dotenv** — загрузка параметров подключения и других секретов из файла `.env`;
- **Lombok** — генерация геттеров, сеттеров и конструкторов;
- **spring-boot-starter-data-jpa-test** и **spring-boot-starter-webmvc-test** — тестирование слоя данных и веб-слоя.

## Структура проекта

```
web_cybersecurity/
├── .mvn/wrapper/     # Maven Wrapper
├── cybersecurity/    # материалы по разбору уязвимостей (Cybersecurity.md)
├── src/              # исходный код приложения и тесты
├── mvnw, mvnw.cmd    # запуск Maven Wrapper
└── pom.xml           # зависимости и сборка
```

## Запуск

Требуется JDK 21 и PostgreSQL. Устанавливать Maven не нужно.

```bash
git clone https://github.com/cameon8868/web_cybersecurity.git
cd web_cybersecurity

# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

После старта приложение доступно по адресу <http://localhost:8080> (если порт не изменён в настройках).

## Конфигурация

Параметры подключения к базе данных хранятся в файле `.env` в корне проекта. Файл не должен попадать в репозиторий — убедитесь, что он указан в `.gitignore`.

Пример (имена переменных замените на те, что используются в `application.properties`):

```env
DB_URL=jdbc:postgresql://localhost:5432/web_cybersecurity
DB_USERNAME=postgres
DB_PASSWORD=change_me
```

## Разбор уязвимостей на примере этого сайта
В этом разделе разобраны уязвимости, которые были в предыдущих версиях сайта: для каждой показано, в чём она заключалась, и в конце пункта описано, как она была исправлена.

Подробно про них рассказано [здесь](cybersecurity/Cybersecurity.md).
Все кодировки CWE берутся [отсюда](https://cwe.mitre.org/data/downloads.html).
