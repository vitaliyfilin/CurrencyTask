package BYN;

import BYN.Exception.CsvLineException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {

        try (Scanner sc = new Scanner(new FileReader("csv"))) {
            Map<Purchase, WrapperDate> firstPurchasesMap = new HashMap<>();
            Map<Purchase, WrapperDate> lastPurchasesMap = new HashMap<>();
            Map<Weekday, List<Purchase>> dayPurchasesMap = new EnumMap<>(Weekday.class);
            List<PriceDiscountPurchase> discountPurchases = new ArrayList<>();
            List<Purchase> purchaseList = new ArrayList<>();

            while (sc.hasNext()) {
                String line = sc.nextLine();

                try {

                    WrapperEntry newWrap = WrapperEntry.getValidEntry(line);
                    Weekday weekday = WrapperEntry.getDayOfWeek(line);
                    if (!dayPurchasesMap.containsKey(weekday)) {List<Purchase> mondayList = new ArrayList<>();mondayList.add(newWrap.getPurchase());dayPurchasesMap.put(weekday, mondayList);} else {List<Purchase> purchaseList1 = dayPurchasesMap.get(weekday);purchaseList1.add(newWrap.getPurchase());dayPurchasesMap.replace(weekday, purchaseList1);}

                } catch (NullPointerException | CsvLineException | ParseException e) {
                }
            }
            dayPurchasesMap.entrySet().stream().forEach(System.out::println);
            System.out.println();
            System.out.println();
            checkMap(dayPurchasesMap, dayPurchasesMap.get(Weekday.FRIDAY).get(2)).entrySet().stream().forEach(System.out::println);
        }

    }

    public static Map<Weekday, List<Purchase>> checkMap(Map<Weekday, List<Purchase>> entry, Purchase purchase) {
        Set<Map.Entry<Weekday, List<Purchase>>> mapEntry = entry.entrySet();
        LinkedHashMap<Weekday, List<Purchase>> linkedMap = new LinkedHashMap<>();

        for (Map.Entry<Weekday, List<Purchase>> i : mapEntry) {
            i.getValue().remove(purchase);
            linkedMap.put(i.getKey(), i.getValue());
        }
        return linkedMap;
    }

}





