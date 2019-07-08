package oriolseguramorales.androidapp.features.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.features.expenses.ui.view.activities.ExpensesListActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    Intent intent = new Intent(SplashActivity.this, ExpensesListActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
