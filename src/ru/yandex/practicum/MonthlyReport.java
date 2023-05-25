package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    public List<MonthData> dataMonth = new ArrayList<>();
    ReadFileContents readFileContents = new ReadFileContents();

    private List<Data> readData(String path) {
        String months = readFileContents.readFileContentsOrNull(path);
        String[] lines = months.split("\n");
        List<Data> datas = new ArrayList<>();
        for (int j = 1; j <= lines.length - 1; j++) {
            String[] line = lines[j].split(",");

            Data data = new Data();
            data.itemName = line[0];
            data.isExpense = Boolean.parseBoolean(line[1]);
            data.quantity = Integer.parseInt(line[2]);
            data.sumOfOne = Integer.parseInt(line[3]);
            datas.add(data);
        }
        return datas;
    }

    public void getReport() {
        for (int i = 0; i < 3; i++) {
            String monthName;
            switch (i) {
                case 0:
                    monthName = "Январь";
                    break;
                case 1:
                    monthName = "Февраль";
                    break;
                default:
                    monthName = "Март";
                    break;
            }
            List<Data> datas = readData("resources\\m.20210" + (i + 1) + ".csv");
            MonthData monthData = new MonthData(monthName, datas);
            dataMonth.add(monthData);
        }
    }

    public void printInformation() {
        if (dataMonth.size() == 0) {
            System.out.println("Вы не считали месячные отчёты.");
        } else {
            String nameProfit = "";
            String nameExpense = "";
            for (MonthData monthData : dataMonth) {
                System.out.println(monthData.monthName);
                int maxProfit = 0;
                int maxExpense = 0;
                for (Data data : monthData.datas) {
                    if (!data.isExpense) {
                        int profit = data.quantity * data.sumOfOne;
                        if (maxProfit < profit) {
                            maxProfit = profit;
                            nameProfit = data.itemName;
                        }
                    } else {
                        int expense = data.quantity * data.sumOfOne;
                        if (maxExpense < expense) {
                            maxExpense = expense;
                            nameExpense = data.itemName;
                        }
                    }
                }
                System.out.println("Самый прибольный товар " + nameProfit + " - " + maxProfit + ".");
                System.out.println("Самая большая трата на товар " + nameExpense + " составляет " + maxExpense + ".");
            }
        }
    }

    public ArrayList<Integer> sumProfitMonth() {
        ArrayList<Integer> sumProfitOfMonth = new ArrayList<>();
        if (!dataMonth.isEmpty()) {
            for (MonthData monthData : dataMonth) {
                int sumProfit = 0;
                for (Data data : monthData.datas) {
                    if (!data.isExpense) {
                        int profit = data.quantity * data.sumOfOne;
                        sumProfit += profit;
                    }
                }
                sumProfitOfMonth.add(sumProfit);
            }
        }
        return sumProfitOfMonth;
    }

    public ArrayList<Integer> sumExpenseMonth() {
        ArrayList<Integer> sumExpenseOfMonth = new ArrayList<>();
        if (!dataMonth.isEmpty()) {
            for (MonthData monthData : dataMonth) {
                int sumExpense = 0;
                for (Data data : monthData.datas) {
                    if (data.isExpense) {
                        int expense = data.quantity * data.sumOfOne;
                        sumExpense += expense;
                    }
                }
                sumExpenseOfMonth.add(sumExpense);
            }
        }
        return sumExpenseOfMonth;
    }

    private static class MonthData {
        private final String monthName;

        private final List<Data> datas;

        private MonthData(String monthName, List<Data> datas) {
            this.monthName = monthName;
            this.datas = datas;
        }
    }
}

