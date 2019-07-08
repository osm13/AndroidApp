package oriolseguramorales.androidapp.core.di;

import dagger.Component;
import oriolseguramorales.androidapp.core.application.AndroidAppApplication;
import oriolseguramorales.androidapp.features.expenses.ui.view.activities.ExpensesListActivity;
import oriolseguramorales.androidapp.features.expenses.ui.view.activities.NewExpenseActivity;

@Component(modules = {PresenterModule.class, RepositoryModule.class, UseCaseModule.class})
public interface AppComponent {
    void inject(AndroidAppApplication androidAppApplication);
    void inject(ExpensesListActivity expensesListActivity);
    void inject(NewExpenseActivity newExpenseActivity);
}
