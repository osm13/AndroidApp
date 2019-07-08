package oriolseguramorales.androidapp.features.expenses.ui.presenter;

import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public interface NewExpensePresenter {

    void saveExpense(Expense expense);
    void setView(NewExpensePresenter.View view);

    interface View {
        void onSaveExpensesOK();
        void onSaveExpensesError(Throwable e);
    }
}
