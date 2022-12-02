package entities;

import entities.comparator.AnalysisScreenUpdater;

public class AnalysisController {
    private final Analysis analysis;

    public AnalysisController(Analysis analysis){
        this.analysis = analysis;
    }

    public void makeRevenueArray(){
        String[] list = this.analysis.totalRevenueBreakdown().toArray(new String[0]);
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);

    }

    public void makeCostsArray(){
        String[] list = this.analysis.totalCostsBreakdown().toArray(new String[0]);
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);
    }

    public void makeProfitLossArray(){
        String revenue = "Revenue: " + this.analysis.getTotalRevenue();
        String costs = "Costs: " + this.analysis.getTotalCosts();
        String profitloss = new String();
        if (analysis.loss()){
            profitloss = "Loss: " + (this.analysis.calculateProfit() * -1);
        } else{
            profitloss = "Profit: " + this.analysis.calculateProfit();
        }
        String[] list = new String[]{revenue, costs, profitloss};
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);
    }

}
