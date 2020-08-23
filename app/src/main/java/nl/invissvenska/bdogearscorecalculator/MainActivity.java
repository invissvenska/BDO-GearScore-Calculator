package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    private CalculatorFragment calculatorFragment;
    private BracketFragment bracketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState != null) {
            calculatorFragment = (CalculatorFragment)getSupportFragmentManager().findFragmentByTag("Calculator");
            bracketFragment = (BracketFragment)getSupportFragmentManager().findFragmentByTag("Brackets");
        } else {
            if(calculatorFragment == null){
                calculatorFragment = new CalculatorFragment();
            }
            if(bracketFragment == null){
                bracketFragment = new BracketFragment();
            }
        }


        addFragment(calculatorFragment, "Calculator");

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_calculator);
        navigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item) -> {
            int id = item.getItemId();

            if (id == R.id.action_calculator) {
                addFragment(calculatorFragment, "Calculator");
                return true;
            }
            if (id == R.id.action_brackets) {
                addFragment(bracketFragment, "Brackets");
                return true;
            }
            return false;
        });
    }

    private void addFragment(Fragment fragment, String tag) {
//        if (isSameFragment(fragment)) {
//            Log.w("BDO", "Pop backstack because fragment already is in there");
//            getSupportFragmentManager().popBackStackImmediate();
//            return;
//        }



        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

//    private BaseFragment getCurrentFragment() {
//        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
//            return null;
//        }
//        FragmentManager.BackStackEntry currentEntry = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);
//
//        String tag = currentEntry.getName();
//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
//
//        return (BaseFragment) fragment;
//    }
//
//    private boolean isSameFragment(BaseFragment fragment) {
//        //don't add a fragment of the same type on top of itself.
//        BaseFragment currentFragment = getCurrentFragment();
//        if (currentFragment != null) {
//            if (currentFragment.getClass() == fragment.getClass()) {
//                Log.w("Fragment Manager", "Tried to add a fragment of the same type to the backstack. This may be done on purpose in some circumstances but generally should be avoided.");
//                return true;
//            }
//        }
//        return false;
//    }

//    private boolean sendBackPressToFragmentOnTop() {
//        BaseFragment fragmentOnTop = getCurrentFragment();
//        if (fragmentOnTop == null) {
//            return false;
//        }
//        if (!(fragmentOnTop instanceof BackButtonSupportFragment)) {
//            return false;
//        }
//        return onBackPressed();
//    }

    @Override
    public void onBackPressed() {
//        if (sendBackPressToFragmentOnTop()) {
//            // fragment on top consumed the back press
//            return;
//        }
//
//        //let the android system handle the back press, usually by popping the fragment
//        super.onBackPressed();
//
//        //close the activity if back is pressed on the root fragment
//        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
//        }
    }

    // These variable are destroyed along with Activity
//    private int someVarA;
//    private String someVarB;
    private static final String INPUT_COMBINED_ATTACK = "COMBINED_ATTACK";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putInt("someVarA", someVarA);
//        outState.putString("someVarB", someVarB);
        outState.putString(INPUT_COMBINED_ATTACK, "200");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        someVarA = savedInstanceState.getInt("someVarA");
//        someVarB = savedInstanceState.getString("someVarB");
        if (savedInstanceState != null) {
            Log.d("BDO", "restored value: " + savedInstanceState.getString(INPUT_COMBINED_ATTACK));
        }
    }
}