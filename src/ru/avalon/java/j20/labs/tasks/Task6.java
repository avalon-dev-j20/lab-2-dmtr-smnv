package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.models.Country;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Задание №6
 *
 * <p>
 * Тема: "Потоковый ввод-вывод. Получение объекта на основании прочитанных
 * данных".
 */
public class Task6 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException, ParseException {
        File input = new File("assets/countries.txt");
        Collection<Country> countries = read(input);
    }

    /**
     * Выполняет чтение коллекции объектов типа {@link Country} из указанного
     * файла.
     *
     * <p>
     * Выполняет чтение файла построчно. Преобразование из текста в объект
     * выполняется с использованием метода {@code valueOf} класса
     * {@link Country}.
     *
     * @param file файл
     * @return коллекция объектов типа {@link Country}
     * @throws IOException в случае ошибки ввода-вывода.
     */
    private Collection<Country> read(File file) throws IOException, ParseException {
        List<Country> collection = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                collection.add(Country.valueOf(line));
            }
            return collection;
        }
    }
}
