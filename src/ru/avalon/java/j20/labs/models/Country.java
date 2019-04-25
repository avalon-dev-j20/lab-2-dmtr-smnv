package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;

/**
 * Модель представления о стране.
 */
public class Country {

    /**
     * Код страны.
     */
    private final String CODE;
    /**
     * Название страны.
     */
    private final String NAME;

    /**
     * Основной конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.CODE = code;
        this.NAME = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCODE() {
        return CODE;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getNAME() {
        return NAME;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Country) {
            Country otherCountry = (Country) otherObject;
            return CODE.equals(otherCountry.CODE) && NAME.equals(otherCountry.NAME);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CODE, NAME);
    }

    /**
     * Возвращает экземпляр страны созданный из переданного текста в формате
     * 'Код:Название'.
     *
     * @param text текст в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка имеет неверный
     * формат.
     */
    public static Country valueOf(String text) throws ParseException {
        int index = text.indexOf(':');
        String code = text.substring(0, index).trim();
        String name = text.substring(index + 1).trim();
        return new Country(code, name);
    }
}
