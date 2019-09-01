package cn.com.java8lambdasexercises.chapter8.template_method.lambdas;


public class CompanyLoanApplication extends LoanApplication {

    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
              company::checkHistoricalDebt,
              company::checkProfitAndLoss);
    }

}

