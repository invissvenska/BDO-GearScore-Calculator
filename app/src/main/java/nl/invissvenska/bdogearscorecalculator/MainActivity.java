package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    private CalculatorFragment calculatorFragment;
    private BracketFragment bracketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorFragment = (CalculatorFragment) getSupportFragmentManager().findFragmentByTag("Calculator");
        bracketFragment = (BracketFragment) getSupportFragmentManager().findFragmentByTag("Brackets");

        if (calculatorFragment == null || bracketFragment == null) {
            calculatorFragment = new CalculatorFragment();
            bracketFragment = new BracketFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, calculatorFragment, "Calculator")
                    .commit();
        }

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_calculator);
        navigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item) -> {
            int id = item.getItemId();

            if (id == R.id.action_calculator) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, calculatorFragment, "Calculator")
                        .commit();
                return true;
            }
            if (id == R.id.action_brackets) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, bracketFragment, "Brackets")
                        .commit();
                return true;
            }
            return false;
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}