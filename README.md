# web_cybersecurity

Хранение и быстрый поиск шпаргалок по инструментам и приёмам кибербезопасности, ведение разборов (writeups) решённых CTF-задач и лаб, самопроверка знаний.

## Содержание

- [Используемые технологии](#используемые-технологии)
- [Использование Spring Boot 4.1.1](#использование-spring-boot-411)
- [Структура проекта](#структура-проекта)
- [Запуск](#запуск)
- [Конфигурация](#конфигурация)
- [Разбор уязвимостей на примере этого сайта](#разбор-уязвимостей-на-примере-этого-сайта)

## Используемые технологии

- HTML;
- CSS;
- Java 21;
- Spring Boot 4.1.1;
- Spring Web MVC;
- Spring Data JPA;
- Thymeleaf;
- PostgreSQL;
- springboot4-dotenv;
- Maven (wrapper);
- Lombok;
- Git;
- GitHub.

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

Подробно про них рассказано [здесь](cybersecurity/Cybersecurity.md).

> ⚠️ Проект учебный. Не публикуйте его в открытом интернете с реальными данными и паролями.
