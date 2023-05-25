import ru.yandex.practicum.MonthlyReport;
import ru.yandex.practicum.Reconciliation;
import ru.yandex.practicum.YearlyReport;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Reconciliation reconciliation = new Reconciliation();
        while (true){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1){
                monthlyReport.getReport();
                System.out.println("Все месячные отчёты считаны.");
            } else if (command == 2) {
                yearlyReport.getReport("resources\\y.2021.csv");
                System.out.println("Годовой отчёт считан.");
            } else if (command == 3) {
                if (monthlyReport.dataMonth.isEmpty() && yearlyReport.dataYear.isEmpty()){
                    System.out.println("Вы не считали месячный и годовой отчёты.");
                } else if (monthlyReport.dataMonth.isEmpty()) {
                    System.out.println("Вы не считали месячный отчёт.");
                } else if (yearlyReport.dataYear.isEmpty()) {
                    System.out.println("Вы не считали годовой отчёт.");
                } else {
                    reconciliation.checkProfit(monthlyReport.sumProfitMonth(), yearlyReport.profitOfMonth());
                    reconciliation.checkExpense(monthlyReport.sumExpenseMonth(), yearlyReport.expenseOfMonth());
                }
            } else if (command == 4) {
                monthlyReport.printInformation();
            } else if (command == 5) {
                yearlyReport.printInformation();
            } else if (command == 0){
                System.out.println("Программа завершена.");
                return;
            } else {
                System.out.println("Неверно введена команда. Прошу повторите ввод:");
            }
        }
    }

    private static void printMenu(){
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию о всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("0 - Выход из программы.");
    }
}
