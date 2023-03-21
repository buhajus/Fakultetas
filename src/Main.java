import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Studentai> sudentuSarasas = new ArrayList<>();
        sudentuSarasas.add(new Studentai(253, "Karnišovas Tomas", "1953-10-01", "5a", 8));
        sudentuSarasas.add(new Studentai(250, "Spurga Jurga", "1993-10-01", "9a", 3));
        sudentuSarasas.add(new Studentai(21, "Mačas Jurgis", "2003-10-01", "5a", 5));
        sudentuSarasas.add(new Studentai(153, "Mikus Stasys", "1923-10-01", "9a", 8));
        sudentuSarasas.add(new Studentai(5, "Vasiljeva Ana", "2006-10-01", "5a", 3.8));
        sudentuSarasas.add(new Studentai(12, "Popu Paulius", "1973-10-01", "8a", 8.8));
        sudentuSarasas.add(new Studentai(36, "Vinigretas Saulius", "1953-10-01", "7a", 9.5));
        sudentuSarasas.add(new Studentai(85, "Bulka Jonas", "1993-10-01", "5a", 4));
        sudentuSarasas.add(new Studentai(333, "Pyragas Stasys", "2020-10-01", "8a", 6.5));
        sudentuSarasas.add(new Studentai(200, "Gaidys Vladas", "2005-10-01", "9a", 7.3));

        System.out.println("Studentų sąrašas");
        spausdintiSarasa(sudentuSarasas);

//        System.out.println("Praščiausio studento vidurkis ");
//        System.out.println(minVidurkis(sudentuSarasas));
//        System.out.println("Pažangiausio studento vidurkis ");
//        System.out.println(maxVidurkis(sudentuSarasas));

        System.out.println("\nSwap : max - " + maxVidurkis(sudentuSarasas) + " sukeičiam su min " + minVidurkis(sudentuSarasas));
        swap(sudentuSarasas, minVidurkioIndex(sudentuSarasas), maxVidurkioIndex(sudentuSarasas));
        spausdintiSarasa(sudentuSarasas);

        System.out.print("\nStudentų skaičius pagal grupę: \t");
        System.out.println(gautiFakultetoStudentus("5a", sudentuSarasas) + " studentu ");

        System.out.println("\nStudentų sąrašas pagal pažangumą:");
        Collections.sort(sudentuSarasas);
        spausdintiSarasa(sudentuSarasas);

        System.out.println("\nPašalinti studentai:");
        pasalintiStudentusSuNeigiamuVidurkiu(sudentuSarasas, 5);

        spausdintiSarasa(sudentuSarasas);

        System.out.println();
        paieska(sudentuSarasas);


    }

    public static void spausdintiSarasa(ArrayList<Studentai> sarasas) {
        for (Studentai studentai : sarasas) {
            System.out.println(studentai);
        }
    }

    //4. Suteikti galimybę vartotojui rasti konkrečios grupės studentų skaičių, panaudojant funkciją 'int gautiFakultetoStudentus(String grupe, ArrayList studentai)'.
    public static int gautiFakultetoStudentus(String grupe, ArrayList<Studentai> sarasas) {
        int studentuSkaicius = 0;
        for (Studentai studentai : sarasas) {
            if (studentai.getGrupe().equals(grupe)) {
                studentuSkaicius++;
            }
        }

        return studentuSkaicius;
    }

    public static void pasalintiStudentusSuNeigiamuVidurkiu(ArrayList<Studentai> sarasas, double vidurkis) {
        Iterator<Studentai> i = sarasas.iterator();
        while (i.hasNext()) {

            Studentai studentai = i.next();
            if (studentai.getVidurkis() <= vidurkis) {
                System.out.println(studentai);
                i.remove();
            }
        }

        System.out.println("\nLikę gerai besimokantys studentai");
    }

    //7. Sukeisti vidurkius geriausiai ir prasčiausiai besimokančių studentų.
    public static int minVidurkioIndex(ArrayList<Studentai> sarasas) {
        //Map<Integer, Double> min = sarasas.stream().collect(Collectors.toMap(Studentai::getPazymejimoId, Studentai::getVidurkis));
//        //   Set<Integer> set = min.keySet();
//        //   System.out.println(set);
//        Collection<Double> collection = min.values();
//         System.out.println(collection);
//        ArrayList<Double> arr = new ArrayList<>(min.values());
//        System.out.println(arr);
//        Double minValue = arr.get(0);
//        int index = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) < minValue) {
//                minValue = arr.get(i);
//                index = i;
//            }
//        }
        Iterator<Studentai> st = sarasas.iterator();

        double minval = 99999;
        int index = 0;
        int i = 0;

        for (sarasas.iterator(); st.hasNext(); index++) {
            Studentai studentai = st.next();
            if (studentai.getVidurkis() < minval) {
                minval = studentai.getVidurkis();
                i = index;
            }
        }

        return i;
    }

    public static int maxVidurkioIndex(ArrayList<Studentai> sarasas) {

        Iterator<Studentai> st = sarasas.iterator();

        double maxVal = -99999;
        int i = 0;
        int index = 0;

        for (sarasas.iterator(); st.hasNext(); index++) {
            Studentai studentai = st.next();
            if (studentai.getVidurkis() > maxVal) {
                maxVal = studentai.getVidurkis();
                i = index;
            }
        }

        return i;
    }

    public static void swap(ArrayList<Studentai> sarasas, int min, int max) {

        Collections.swap(sarasas, min, max);

    }

    public static double maxVidurkis(ArrayList<Studentai> sarasas) {
        Map<Integer, Double> map = sarasas.stream().collect(Collectors.toMap(Studentai::getPazymejimoId, Studentai::getVidurkis));
        double max = Collections.max(map.values());
        return max;
    }

    public static double minVidurkis(ArrayList<Studentai> sarasas) {
        Map<Integer, Double> map = sarasas.stream().collect(Collectors.toMap(Studentai::getPazymejimoId, Studentai::getVidurkis));
        double min = Collections.min(map.values());
        return min;
    }
    //8. Sukurti galimybę vartotojui atlikti studentų paiešką pagal pavardę arba gimimo datą. Vartotojas turi įvesti kriterijus į terminalą (Scanner).

    public static void paieska(ArrayList<Studentai> sarasas) {
        Scanner scan = new Scanner(System.in);
     //   Map<String, String> map = sarasas.stream().collect(Collectors.toMap(Studentai::getPavardeVardas, Studentai::getGimimoData));
        System.out.println("Paieška pagal stutendo pavardė arba gimimo datą (YYYY-mm-dd)");
        String paieska = scan.nextLine();
        Iterator<Studentai> iterator = sarasas.iterator();

        while (iterator.hasNext()) {
            Studentai studentai = iterator.next();
            String dalinam[] = studentai.getPavardeVardas().split(" ");
            String pavarde = dalinam[0];

            if (studentai.getGimimoData().equals(paieska) || pavarde.equals(paieska))  {
                System.out.println(studentai);
            }
        }
    }
}