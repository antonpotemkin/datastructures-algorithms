package ru.potemkin.dsa.sorting;

public class InsertionSort extends Sort {

    public InsertionSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        for (int out = 1; out < mas.length; out++) {
            var temp = mas[out];
            var in = out;
            while (in > 0 && mas[in - 1] > temp) {
                mas[in] = mas[in - 1];
                in--;
            }
            mas[in] = temp;
        }
    }

    public int mediana() {
        var sum = 0;
        for (int ma : mas)
            sum += ma;
        var halfSum = sum / 2;
        int mediana;
        var temp = 0;
        for (mediana = 0; mediana < mas.length; mediana++) {
            temp += mas[mediana];
            if (temp >= halfSum)
                break;
        }
        return mediana - 1;
    }

    /**
     * sort use System.arraycopy
     */
    public void sortArraycopy() {
        for (var i = 1; i < mas.length; i++) {
            var key = mas[i];
            var point = i;

            for (var j = i - 1; j >= 0; j--) {
                if (key < mas[j])
                    point = j;
                else
                    break;
            }
            System.arraycopy(mas, point, mas, point + 1, i - point);
            mas[point] = key;
        }
    }
}
