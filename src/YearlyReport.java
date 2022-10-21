import java.util.ArrayList;

public class YearlyReport {
    ArrayList<DataYear> dataYear = new ArrayList<>();
    ReadFileContents readFileContents= new ReadFileContents();

    public void getReport(String path){
        String months = readFileContents.readFileContentsOrNull(path);
        String[] lines = months.split("\n");

        for (int j = 1; j < lines.length; j++) {
            String[] line = lines[j].split(",");

            DataYear data = new DataYear();
            data.month = Integer.parseInt(line[0]);
            data.isExpense = Boolean.parseBoolean(line[2]);
            data.amount = Integer.parseInt(line[1]);
            this.dataYear.add(data);
        }
    }

    public void printInformation(){
        if (!dataYear.isEmpty()){
            System.out.println("Год 2021");
            this.profitEachMonth();
            this.middleProfitAndExpense();
        } else {
            System.out.println("Вы не считали годовой отчёт.");
        }
    }

    public ArrayList<Integer> profitOfMonth() {
        ArrayList<Integer> profitOfMonth = new ArrayList<>();
        if (!dataYear.isEmpty()){
            for (int i = 0; i < dataYear.size(); i++) {
                DataYear data = dataYear.get(i);
                if (!data.isExpense) {
                    profitOfMonth.add(data.amount);
                }
            }
        }
        return profitOfMonth;
    }

    public ArrayList<Integer> expenseOfMonth(){
        ArrayList<Integer> expenseOfMonth = new ArrayList<>();
        if (!dataYear.isEmpty())
            for (int i = 0; i < dataYear.size(); i++) {
                DataYear data = dataYear.get(i);
                if (data.isExpense) {
                    expenseOfMonth.add(data.amount);
                }
            }
        return expenseOfMonth;
    }

    private void middleProfitAndExpense(){
        Integer sumProfit = 0;
        Integer sumExpense = 0;
        Integer monthProfit = 0;
        Integer monthExpense = 0;
        for (int i = 0; i < dataYear.size(); i++) {
            DataYear data = dataYear.get(i);
            if (!data.isExpense){
                sumProfit += data.amount;
                monthProfit++;
            } else {
                sumExpense += data.amount;
                monthExpense++;
            }
        }
        System.out.println("Средний доход за все месяцы в году состовляет " + sumProfit / monthProfit);
        System.out.println("Средний расход за все месяцы в году составляет " + sumExpense / monthExpense);
    }

    private void profitEachMonth(){
        Integer sumProfit = 0;
        Integer sumExpense = 0;
        int j = 1;
        System.out.println("Прибыль по каждому месяцу:");
        for (int i = 0; i < dataYear.size(); i++) {
            DataYear data = dataYear.get(i);
            if (!data.isExpense){
                sumProfit = data.amount;
            } else {
                sumExpense = data.amount;
            }
            if (i == 1 || i == 3 || i == 5) {
                Integer profitOfMonth = (sumProfit - sumExpense);
                System.out.println("Месяц № " + j + " " + profitOfMonth);
                j++;
            }
        }
    }
}
