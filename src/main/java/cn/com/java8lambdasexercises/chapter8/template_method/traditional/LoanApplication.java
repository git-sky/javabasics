package cn.com.java8lambdasexercises.chapter8.template_method.traditional;


import cn.com.java8lambdasexercises.chapter8.template_method.ApplicationDenied;

public abstract class LoanApplication {

    public void checkLoanApplication() throws ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;

    protected abstract void checkIncomeHistory() throws ApplicationDenied;

    protected abstract void checkCreditHistory() throws ApplicationDenied;

    private void reportFindings() {
    }


}
