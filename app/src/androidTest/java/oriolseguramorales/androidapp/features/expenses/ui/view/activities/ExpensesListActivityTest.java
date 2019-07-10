package oriolseguramorales.androidapp.features.expenses.ui.view.activities;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import oriolseguramorales.androidapp.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpensesListActivityTest {

    @Rule
    public ActivityScenarioRule<ExpensesListActivity> activityScenarioRule
            = new ActivityScenarioRule<>(ExpensesListActivity.class);

    @Test
    public void adapter_with_data(){
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void check_button(){
        onView(withId(R.id.new_expense_button)).check(matches(withText(R.string.expenses_list_new_expense_button)));
    }
}