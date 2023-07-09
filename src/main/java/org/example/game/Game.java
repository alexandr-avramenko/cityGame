package org.example.game;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private int userScore = 0;
    private int computerScore = 0;
    private final Map<Character, List<String>> vocabulary;
    private final Random randomIndex = new Random();
    private String previousCity;

    public int getUserScore() {
        return this.userScore;
    }

    public int getComputerScore() {
        return this.computerScore;
    }

    public Game(List<String> cities) {
        //Group data by the first char
        this.vocabulary = cities.stream()
                .collect(Collectors.groupingBy(this::getFirstCityLetter, Collectors.toCollection(LinkedList::new)));
    }

    public Optional<String> findNextCity(String userProvidedCity) {

        if (!this.isCityUsed(userProvidedCity)) {
            this.userScore++;
        }

        char lastLetter = lastCityLetter(userProvidedCity);

        List<String> cities = getCitiesByLetter(lastLetter);

        if (cities.size() == 0) {
            return Optional.empty();
        }

        int index = randomIndex.nextInt(cities.size());

        //remove the next city from PC and save it
        String nextCity = cities.remove(index);

        //remove a city which a user entered
        char firstLetter = userProvidedCity.toLowerCase().charAt(0);
        List<String> citiesByLetter = getCitiesByLetter(firstLetter);
        citiesByLetter.remove(userProvidedCity);

        this.computerScore++;

        this.previousCity = nextCity;
        return Optional.ofNullable(nextCity);
    }

    //перевірка чи коректна назва міста, навіть якщо воно ще не використовувалось.
    // Чи співпадає перша літера введеного слова з останньою літерою попереднього
    public boolean canBeNextCity(String city) {

        if (this.previousCity != null) {
            return getFirstCityLetter(city) == this.lastCityLetter(this.previousCity);
        }
        return true;
    }

    //перевірка чи вже використовувалось міст
    public boolean isCityUsed(String userCity) {
        char firstLetter = this.getFirstCityLetter(userCity);
        List<String> citiesByLetter = getCitiesByLetter(firstLetter);
        return !citiesByLetter.contains(userCity);
    }

    private char lastCityLetter(String city) {
        char lastLetter = city.charAt(city.toLowerCase().length() - 1);

        if ('ь' == lastLetter) {
            lastLetter = city.charAt(city.length() - 2);
        }
        return lastLetter;
    }

    private char getFirstCityLetter(String city) {
        return Character.toLowerCase(city.charAt(0));
    }

    private List<String> getCitiesByLetter(char firstLetter) {
        return vocabulary.getOrDefault(Character.toLowerCase(firstLetter), List.of());
    }
}