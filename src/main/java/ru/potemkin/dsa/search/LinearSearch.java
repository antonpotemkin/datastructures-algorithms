package ru.potemkin.dsa.search;

public class LinearSearch implements Search {

    @Override
    public int search(int[] massive, int number) {
        var result = -1;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == number) {
                result = i;
                break;
            }
        }
        return result;
    }
}
