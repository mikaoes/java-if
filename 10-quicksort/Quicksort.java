public class Quicksort {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 1, 9, 2, 4, 6, 8, 0};

        int[] erg = quicksort(array, 0, array.length - 1);
        for (int i = 0; i < erg.length; i++) {
            System.out.print(erg[i] + " ");
        }
    }

    public static int[] quicksort(int[] a, int from, int to) {

        if (from < to) {            // Abbruchbedingung
            int pivot = a[from];    // erstes Element als Pivot
            int i = from + 1;       // linke Grenze
            int j = to;             // rechte Grenze

            while (i <= j) {       // solange linke und rechte Grenze sich nicht überschneiden
                while (i <= to && a[i] < pivot) { // solange linke Grenze nicht überschritten und Element kleiner als Pivot
                    i++;           // linke Grenze eins weiter
                }
                while (j >= from && a[j] > pivot) { // solange rechte Grenze nicht überschritten und Element größer als Pivot
                    j--;          // rechte Grenze eins zurück
                }
                if (i <= j) {      // wenn linke Grenze kleiner gleich rechter Grenze
                    tausche(a, i, j); // tausche Elemente
                    i++;            // linke Grenze eins weiter
                    j--;           // rechte Grenze eins zurück
                }
            }
            tausche(a, from, j);   // Pivot-Element an die richtige Stelle tauschen

            quicksort(a, from, j - 1); // rekursiver Aufruf für linke Hälfte
            quicksort(a, i, to);      // rekursiver Aufruf für rechte Hälfte
        }

        return a;
    }

    public static void tausche(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}