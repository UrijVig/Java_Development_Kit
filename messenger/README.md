## Урок 1. Графические интерфейсы

1. Реализовать клиент-серверное приложение. Начало его можно увидеть в презентации к первому уроку, а можно ориентироваться на скриншоты. Результат можно увидеть на скриншотах, которые также можно найти в материалах к уроку  

[Стартовое состояние](https://drive.google.com/file/d/1cG6B19iwOzQazdfdA9VUngEYGwdyV6L9/view?usp=sharing)

[рабочее состояние](https://drive.google.com/file/d/18dqigUO6n24K3orJsrYnC7mHnSAoVkGG/view?usp=sharing)


2. Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное приложение по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;  

```java
/*
Метод устанавливает слушателя клавиатуры, реагирующего на нажатие клавиши Enter
*/
message.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') sendMessage();
    }
});
```

3. Продублировать импровизированный лог (историю) чата в файле;  

```java
/**
 * Метод сохраняет полученное тесктовое значение в файле истории чата
 * 
 * @param text полоученное сообщение
 */
private void saveMassageInLog(String text) {
    try (FileWriter fw = new FileWriter(HISTORY_PATH,true)) {
        fw.write(text + "\n");
    } catch (IOException e) {
        printInfo("Ошибка при сохранении истории! " + e.getMessage());
        e.printStackTrace();
    }
}
```

4. При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.

```java
/**
 * Метот возвращает историю переписки из файла в памяти сервера
 *
 * @return строка с перепиской
 */
public String getHistory() {
    StringBuilder data = new StringBuilder();
    try (FileReader fr = new FileReader(HISTORY_PATH); BufferedReader bf = new BufferedReader(fr)){
        String line;
        while ((line = bf.readLine()) != null) data.append(line).append("\n");
        return data.toString();
    } catch (FileNotFoundException e) {
        printInfo("Файл истории не найден!" + e.getMessage());
        e.printStackTrace();
        return null;
    } catch (IOException e) {
        printInfo("Ошибка чтения файла!" + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
```



