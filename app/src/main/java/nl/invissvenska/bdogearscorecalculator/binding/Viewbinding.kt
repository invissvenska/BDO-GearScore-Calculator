package nl.invissvenska.bdogearscorecalculator.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

@BindingAdapter("onNavigationItemSelected")
fun bindOnNavigationItemSelectedListener(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener?) {
    view.setOnNavigationItemSelectedListener(listener)
}