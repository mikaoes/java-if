public class Abiaufgabe {
    public static BinTree tree = new BinTree<Stern>(null);

    public static int sternUmgebung(BinTree<Stern> b, BinTree<Stern> refStern) {
        int anzahl = 0;
        if (!b.isEmpty()) {
            if (!b.getLeft().isEmpty()) {
                anzahl += sternUmgebung(b.getLeft(), refStern);
            }
            if (!b.getRight().isEmpty()) {
                anzahl += sternUmgebung(b.getRight(), refStern);
            }

            if ((b.getP1() - refStern.getP1()) <= 5 && (b.getP1() - refStern.getP1()) >= 5
                    && (b.getP2() - refStern.getP2()) <= 5 && (b.getP2() - refStern.getP2()) >= 5) {
                anzahl++;
            }

            return anzahl;
        }
    }
}