package oriolseguramorales.androidapp.features.expenses.ui.presenter.impl;

import io.reactivex.observers.DisposableObserver;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.SaveExpenseUseCase;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.NewExpensePresenter;

public class NewExpensePresenterImpl implements NewExpensePresenter {

    private NewExpensePresenter.View view;

    private final SaveExpenseUseCase saveExpenseUseCase;
    private DisposableObserver<String> saveExpenseObserver;

    public NewExpensePresenterImpl(SaveExpenseUseCase saveExpenseUseCase) {
        this.saveExpenseUseCase = saveExpenseUseCase;
        initObservers();
    }

    private void initObservers() {
        createSaveExpenseObserver();
    }

    private void createSaveExpenseObserver() {
        saveExpenseObserver = new DisposableObserver<String>() {

            @Override
            public void onNext(String s) {
                view.onSaveExpensesOK();
            }

            @Override
            public void onError(Throwable e) {
                view.onSaveExpensesError(e);
            }

            @Override
            public void onComplete() {
                //Aquí quitaria la barra de progreso
            }
        };
    }

    @Override
    public void saveExpense(Expense expense) {
        saveExpenseUseCase.execute(saveExpenseObserver, expense);
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
