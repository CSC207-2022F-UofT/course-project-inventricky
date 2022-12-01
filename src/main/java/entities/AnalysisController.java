package entities;

import entities.comparator.AnalysisPresenter;

public class AnalysisController {
    private final Analysis analysis;

    public AnalysisController(Inventory inventory){
        this.analysis = new Analysis(inventory);
    }
    public AnalysisController(Analysis analysis){
        this.analysis = analysis;
    }

    public String[] makeRevenueArray(){
        String[] list = this.analysis.totalRevenueBreakdown().toArray(new String[0]);
        AnalysisPresenter presenter = new AnalysisPresenter();
        return presenter.showRevenueArray(list);

    }

    public String[] makeCostsArray(){
        String[] list = this.analysis.totalCostsBreakdown().toArray(new String[0]);
        AnalysisPresenter presenter = new AnalysisPresenter();
        return presenter.showCostsArray(list);
    }

    public String[] makeProfitLossArray(){
        String revenue = "Revenue: " + this.analysis.getTotalRevenue();
        String costs = "Costs: " + this.analysis.getTotalRevenue();
        String profitloss = new String();
        if (analysis.loss()){
            profitloss = "Loss: " + (this.analysis.calculateProfit() * -1);
        } else{
            profitloss = "Profit: " + this.analysis.calculateProfit();
        }
        String[] list = new String[]{revenue, costs, profitloss};
        AnalysisPresenter presenter = new AnalysisPresenter();
        return presenter.showProfitLossArray(list);
    }

}
