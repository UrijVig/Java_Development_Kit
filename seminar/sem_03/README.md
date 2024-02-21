## Урок 3. Обобщенное программирование

1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.  

    [решение](https://github.com/UrijVig/Java_Development_Kit/blob/main/seminar/sem_03/task01/src/Calc.java)  

2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам. То есть тип элемента в первом массиве под нулевым индексом такой же как тип элемента во втором массиве под нулевым индексом (и под всеми остальными индексами аналогично)  

    ```java
    private static <T> boolean compareArrays(T[] arr1, T[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].getClass() != arr2[i].getClass()) return  false;
        }
        return true;
    }
    ```
    [решение](https://github.com/UrijVig/Java_Development_Kit/blob/main/seminar/sem_03/task02/src/Main.java)

3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары. Работу сдать в виде ссылки на гит репозиторий  

    [решение](https://github.com/UrijVig/Java_Development_Kit/blob/main/seminar/sem_03/task03/src/Pair.java)
