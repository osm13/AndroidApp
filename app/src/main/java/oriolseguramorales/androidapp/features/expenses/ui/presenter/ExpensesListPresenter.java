package oriolseguramorales.androidapp.features.expenses.ui.presenter;

import java.util.List;

import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public interface ExpensesListPresenter  {

    void getExpensesList();
    void setView(View view);

    interface View {
        void onGetExpensesListOK(List<Expense> expenseList);
        void onGetExpensesListError(Throwable e);
    }
}
