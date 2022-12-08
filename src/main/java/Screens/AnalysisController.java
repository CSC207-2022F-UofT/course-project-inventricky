package Screens;

import analysis_use_case.Analysis;

public class AnalysisController {
    private final Analysis analysis;

    /**
     * AnalysisController Contrsuctor
     * @param analysis the Analysis object I will perform the required analysis on
     */
    public AnalysisController(Analysis analysis){
        this.analysis = analysis;
    }

    /**
     * Creates a revenue array and sends it to the presenter
     */
    public void makeRevenueArray(){
        String[] list = this.analysis.totalRevenueBreakdown().toArray(new String[0]);
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);

    }

    /**
     * Creates a costs array and sends it to the presenter
     */
    public void makeCostsArray(){
        String[] list = this.analysis.totalCostsBreakdown().toArray(new String[0]);
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);
    }

    /**
     * Creates a profit or loss array and sends it to the presenter
     */
    public void makeProfitLossArray(){
        String revenue = "Revenue: " + this.analysis.getTotalRevenue();
        String costs = "Costs: " + this.analysis.getTotalCosts();
        String profit_loss;
        if (analysis.loss()){
            profit_loss = "Loss: " + (this.analysis.calculateProfit() * -1);
        } else{
            profit_loss = "Profit: " + this.analysis.calculateProfit();
        }
        String[] list = new String[]{revenue, costs, profit_loss};
        AnalysisScreenUpdater presenter = new AnalysisScreenUpdater();
        presenter.showArray(list);
    }

}
