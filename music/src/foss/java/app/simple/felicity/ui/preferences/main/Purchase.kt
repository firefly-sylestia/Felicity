package app.simple.felicity.ui.preferences.main

import android.os.Bundle
import app.simple.felicity.R
import app.simple.felicity.enums.PreferenceType
import app.simple.felicity.extensions.fragments.PreferenceFragment
import app.simple.felicity.models.Preference

class Purchase : PreferenceFragment() {
    override val titleRes: Int
        get() = R.string.purchase
    override val iconRes: Int
        get() = R.drawable.ic_sell

    override fun getPreferencesList(): List<Preference> = listOf(
        Preference(
            title = R.string.already_purchased,
            summary = R.string.all_features_summary,
            icon = R.drawable.ic_unlocked,
            type = PreferenceType.NORMAL
        )
    )

    companion object {
        fun newInstance(): Purchase = Purchase().apply { arguments = Bundle() }
        const val TAG = "Purchase"
    }
}
