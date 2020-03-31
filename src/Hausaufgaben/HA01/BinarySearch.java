package Hausaufgaben.HA01;

/**
 * Diese Vorlage dieser Klasse stammt aus folgender Quelle:
 * https://www.geeksforgeeks.org/binary-search/
 * 
 * @LukeSky1712
 */
public class BinarySearch {
    
    /**
     * Diese Methode implementiert die klassische Implementation des binarySearch Algorithmus.
     * Die Methode gibt den index von x zurueck, falls x vorhanden ist, sonst -1.
     * 
     * @param arr Das zu durchsuchende Feld.
     * @param l Der linke index des zu durchsuchenden Feldes (fuer externe Aufrufe 0).
     * @param r Der rechte index des zu durchsuchenden Feldes (fuer externe Aufrufe arr.length - 1).
     * @param x Der gesuchte Wert.
     * @return Der index von x, oder -1, falls x nicht vorhanden ist.
     */
    public int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }

    /**
     * Diese Methode implementiert eine modifizierte Implementation des binarySearch Algorithmus, diese Implementation verwendet die Interpolationssuche.
     * Die Methode gibt den index von x zurueck, falls x vorhanden ist, sonst -1.
     * 
     * @param arr Das zu durchsuchende Feld.
     * @param l Der linke index des zu durchsuchenden Feldes (fuer externe Aufrufe 0).
     * @param r Der rechte index des zu durchsuchenden Feldes (fuer externe Aufrufe arr.length - 1).
     * @param x Der gesuchte Wert.
     * @return Der index von x, oder -1, falls x nicht vorhanden ist.
     */
    public int interpolationSearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (x - arr[l]) / (arr[r] - arr[l]) * (r - l);

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return interpolationSearch(arr, l, mid - 1, x);

            return interpolationSearch(arr, mid + 1, r, x);
        }

        return -1;
    }

    /**
     * Dies ist eine kleine Testmethode.
     */
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();

        int arr[] = { 1, 2, 3, 5, 6, 8, 10, 20, 40 };
        int n = arr.length;
        int x = 4;
        int result = ob.interpolationSearch(arr, 0, n - 1, x);

        System.out.println(result);
    }
}