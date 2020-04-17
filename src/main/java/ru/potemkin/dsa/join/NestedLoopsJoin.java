package ru.potemkin.dsa.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of join two lists using nested loops
 */
public class NestedLoopsJoin implements Join {

    @Override
    public <K extends Comparable<K>, V1, V2> List<Triple<K, V1, V2>> join(List<Pair<K, V1>> left, List<Pair<K, V2>> right) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();
        for (Pair<K, V1> leftPair : left)
            for (Pair<K, V2> rightPair : right)
                if (Objects.equals(leftPair.getK(), rightPair.getK()))
                    result.add(new Triple<>(leftPair.getK(), leftPair.getV(), rightPair.getV()));
        return result;
    }
}
