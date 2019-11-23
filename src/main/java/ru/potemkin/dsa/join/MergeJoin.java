package ru.potemkin.dsa.join;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeJoin implements Join {
    @Override
    public <K extends Comparable<K>, V1, V2> List<Triple<K, V1, V2>> join(List<Pair<K, V1>> left, List<Pair<K, V2>> right) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();
        Iterator<Pair<K, V1>> leftIterator = left.iterator();
        Iterator<Pair<K, V2>> rightIterator = right.iterator();
        Pair<K, V1> leftPair = leftIterator.next();
        Pair<K, V2> rightPair = rightIterator.next();
        while (true) {
            var compare = leftPair.getK().compareTo(rightPair.getK());
            if (compare < 0) {
                if (leftIterator.hasNext()) {
                    leftPair = leftIterator.next();
                } else {
                    break;
                }
            } else if (compare > 0) {
                if (rightIterator.hasNext()) {
                    rightPair = rightIterator.next();
                } else {
                    break;
                }
            } else {
                result.add(new Triple<>(leftPair.getK(), leftPair.getV(), rightPair.getV()));
                if (leftIterator.hasNext() && rightIterator.hasNext()) {
                    leftPair = leftIterator.next();
                    rightPair = rightIterator.next();
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
