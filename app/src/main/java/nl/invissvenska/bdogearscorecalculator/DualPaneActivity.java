package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DualPaneActivity extends AppCompatActivity {
    private CalculatorFragment calculatorFragment;
    private BracketFragment bracketFragment;

    private static final String CALCULATOR = "Calculator";
    private static final String BRACKET = "Brackets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean singlePane = findViewById(R.id.bottom_nav) != null;
        if (singlePane) {
            handleNormalScreen();
        }
    }

    private void handleNormalScreen() {
        calculatorFragment = (CalculatorFragment) getSupportFragmentManager().findFragmentByTag(CALCULATOR);
        bracketFragment = (BracketFragment) getSupportFragmentManager().findFragmentByTag(BRACKET);

        if (calculatorFragment == null || bracketFragment == null) {
            calculatorFragment = new CalculatorFragment();
            bracketFragment = new BracketFragment();
            setFragment(calculatorFragment, R.id.nav_host_fragment, CALCULATOR);
        }

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_calculator);
        navigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item) -> {
            int id = item.getItemId();

            if (id == R.id.action_calculator) {
                setFragment(calculatorFragment, R.id.nav_host_fragment, CALCULATOR);
                return true;
            }
            if (id == R.id.action_brackets) {
                setFragment(bracketFragment, R.id.nav_host_fragment, BRACKET);
                return true;
            }
            return false;
        });
    }

    private void setFragment(Fragment fragment, int container, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, tag)
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
