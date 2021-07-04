# Java Summer Practice
Repository for Java Summer Practice

### Запустить приложение из командной строки
В корневой директории приложения:

`mvn spring-boot:run`

или

`mvn clean install` - выполнить в корневой папке приложения (book-store или discount)

`cd target` - перейти в папку target

`java -jar book-store-0.0.1-SNAPSHOT.jar` - в папке target выполнить команду


### Ссылки на актуатор (информация о приложении)
http://localhost:8080/actuator

http://localhost:8080/actuator/health

### Получить список книг

http://localhost:8080/book

### Ссылки на документацию API в Swagger
http://localhost:8080/v2/api-docs

http://localhost:8080/v3/api-docs

http://localhost:8080/swagger-ui/

### Ссылка на консоль базы данных H2
http://localhost:8080/h2-console

### Получить информацию о скидке

http://localhost:8081/discount

### Собрать image для Docker 
В корневой папке приложения:
`mvn spring-boot:build-image`

### Запустить контейнер на основе image
`docker run -p 8081:8081 -d book-discount:0.0.1-SNAPSHOT`

## Дополнительное задание
1. Доработать сервис Discount, чтобы он возвращал скидку для групп книг:
   - Сервис должен возвращать список из групп и скидок. 
   - Группа может обозначаться набором букв и цифр длинной до 10 символов.
   - Предусмотреть применение полученных скидок перед отдачей списка книг из сервиса BookStore.
   - Предусмотреть ситуацию, когда для некоторых групп скидки не предусмотрены.
   - Предусмотреть ситуацию, когда сервис скидок не доступен.
2. Доработать API для получения информации о книге по id ("/book/{id}"). Информация должна возвращаться из базы данных. 



 
