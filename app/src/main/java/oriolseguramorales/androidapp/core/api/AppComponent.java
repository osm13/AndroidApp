package oriolseguramorales.androidapp.core.api;

import dagger.Component;
import oriolseguramorales.androidapp.core.application.AndroidAppApplication;
import oriolseguramorales.androidapp.features.expenses.ui.view.activities.ExpensesListActivity;

@Component(modules = {PresenterModule.class, RepositoryModule.class, UseCaseModule.class})
public interface AppComponent {
    void inject(AndroidAppApplication androidAppApplication);
    void inject(ExpensesListActivity expensesListActivity);
}
