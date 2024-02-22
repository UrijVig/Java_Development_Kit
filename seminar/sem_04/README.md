## Урок 4. Коллекции

### Создать справочник сотрудников

* Создать класс [справочник сотрудников](https://github.com/UrijVig/Java_Development_Kit/blob/main/seminar/sem_04/src/main/java/app/EmployeeDirectory.java), который содержит внутри коллекцию сотрудников


* Каждый [сотрудник](https://github.com/UrijVig/Java_Development_Kit/blob/main/seminar/sem_04/src/main/java/app/Employee.java) должен иметь следующие атрибуты:  
  * Табельный номер  
  * Номер телефона  
  * Имя  
  * Стаж


* Добавить метод, который ищет сотрудника по стажу (может быть список)
    ```java
    public List<Employee> getEmployeeByExperience(int experience){
        return employees.stream().filter(employee -> employee.experience() == experience)
                .toList();
    }
    ```

* Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    ```java
    public List<String> getPhoneNumberByName(String name){
        return employees.stream().filter(employee -> employee.name().equals(name))
                .map(Employee::phoneNumber).toList();
    }
    ```

* Добавить метод, который ищет сотрудника по табельному номеру
    ```java
    public Employee getEmployeeByPersonalNumber(int personalNumber){
        return employees.stream()
                .filter(employee -> employee.personalNumber() == personalNumber)
                .findFirst().orElse(null);
    }
    ```

* Добавить метод добавление нового сотрудника в справочник
    ```java
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    ```


