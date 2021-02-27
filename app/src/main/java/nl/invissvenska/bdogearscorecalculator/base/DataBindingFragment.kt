package nl.invissvenska.bdogearscorecalculator.base

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * DataBindingActivity is an abstract class for providing [DataBindingUtil].
 * provides implementations of only [ViewDataBinding] from an abstract information.
 * Do not modify this class. This is a first-level abstraction class.
 * If you want to add more specifications, make another class which extends [DataBindingFragment].
 */
abstract class DataBindingFragment : Fragment() {

    protected inline fun <reified T : ViewDataBinding> binding(
            @LayoutRes resId: Int

    ): Lazy<T> = lazy {
        DataBindingUtil.inflate<T>(layoutInflater, resId, null, false)
    }
}
