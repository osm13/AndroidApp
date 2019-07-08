package oriolseguramorales.androidapp.features.expenses.ui.presenter.impl;


import java.util.List;

import io.reactivex.observers.DisposableObserver;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.GetExpensesListUseCase;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.ExpensesListPresenter;

public class ExpensesListPresenterImpl implements ExpensesListPresenter {

    private ExpensesListPresenter.View view;

    private final GetExpensesListUseCase getExpensesListUseCase;

    public ExpensesListPresenterImpl(GetExpensesListUseCase getExpensesListUseCase) {
        this.getExpensesListUseCase = getExpensesListUseCase;
    }


    private DisposableObserver<List<Expense>> createGetExpensesListObserver() {
        return new DisposableObserver<List<Expense>>() {

            @Override
            public void onNext(List<Expense> expenseList) {
                view.onGetExpensesListOK(expenseList);
            }

            @Override
            public void onError(Throwable e) {
                view.onGetExpensesListError(e);
            }

            @Override
            public void onComplete() {
                //En este punto se debería parar la barra de progreso
            }
        };
    }

    @Override
    public void getExpensesList() {
        getExpensesListUseCase.execute(createGetExpensesListObserver(), null);
    }


    @Override
    public void setView(View view) {
        this.view = view;
    }
}
