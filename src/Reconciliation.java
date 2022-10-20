import java.util.ArrayList;

public class Reconciliation {

    public void checkProfit(ArrayList<Integer> profitMonth, ArrayList<Integer> profitOfMonth) {
        for (int i = 0; i < profitMonth.size(); i++) {
            Integer profit = profitMonth.get(i);
            if (!profitOfMonth.contains(profit)){
                if (i == 0) {
                    System.out.println("Не совпадают значения в доходах месячного и годового отчёта по месяцу Январь.");
                } else if (i == 1) {
                    System.out.println("Не совпадают значения в доходах месячного и годового отчёта по месяцу Февраль.");
                } else if (i == 2){
                    System.out.println("Не совпадают значения в доходах месячного и годового отчёта по месяцу Март.");
                }
            } else {
                if (i == 2) {
                    System.out.println("Сверка прошла успешно. Все отчёты по доходам совпадают.");
                }
            }
        }
    }

    public void checkExpense(ArrayList<Integer> expenseMonth, ArrayList<Integer> expenseOfMonth) {
        for (int i = 0; i < expenseMonth.size(); i++) {
            Integer profit = expenseMonth.get(i);
            if (!expenseOfMonth.contains(profit)){
                if (i == 0) {
                    System.out.println("Не совпадают значения в тратах месячного и годового отчёта по месяцу Январь.");
                } else if (i == 1) {
                    System.out.println("Не совпадают значения в тратах месячного и годового отчёта по месяцу Февраль.");
                } else if (i == 2){
                    System.out.println("Не совпадают значения в тратах месячного и годового отчёта по месяцу Март.");
                }
            } else {
                if (i == 2) {
                    System.out.println("Сверка прошла успешно. Все отчёты по тратам совпадают.");
                }
            }
        }
    }
}
