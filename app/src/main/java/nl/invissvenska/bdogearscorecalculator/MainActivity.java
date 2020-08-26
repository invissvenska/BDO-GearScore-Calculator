package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private CalculatorFragment calculatorFragment;
    private BracketFragment bracketFragment;

    private static final String CALCULATOR = "Calculator";
    private static final String BRACKET = "Brackets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorFragment = (CalculatorFragment) getSupportFragmentManager().findFragmentByTag(CALCULATOR);
        bracketFragment = (BracketFragment) getSupportFragmentManager().findFragmentByTag(BRACKET);

        if (calculatorFragment == null || bracketFragment == null) {
            calculatorFragment = new CalculatorFragment();
            bracketFragment = new BracketFragment();
            setFragment(calculatorFragment, CALCULATOR);
        }

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_calculator);
        navigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item) -> {
            int id = item.getItemId();

            if (id == R.id.action_calculator) {
                setFragment(calculatorFragment, CALCULATOR);
                return true;
            }
            if (id == R.id.action_brackets) {
                setFragment(bracketFragment, BRACKET);
                return true;
            }
            return false;
        });
    }

    private void setFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment, tag)
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}