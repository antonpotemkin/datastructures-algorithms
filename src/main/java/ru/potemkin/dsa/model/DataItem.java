package ru.potemkin.dsa.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class DataItem {
    private final int key;
    private final String value;
}
