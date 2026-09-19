package app.simple.felicity.ui.preferences.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.simple.felicity.R
import app.simple.felicity.databinding.FragmentPurchaseBinding
import app.simple.felicity.databinding.HeaderPreferencesGenericBinding
import app.simple.felicity.extensions.fragments.PreferenceFragment
import dagger.hilt.android.AndroidEntryPoint

/** Displays the permanent ownership status. */
@AndroidEntryPoint
class Purchase : PreferenceFragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var headerBinding: HeaderPreferencesGenericBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        headerBinding = HeaderPreferencesGenericBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        headerBinding.title.text = getString(R.string.purchase)
        headerBinding.icon.setImageResource(R.drawable.ic_sell)
        binding.header.setContentView(headerBinding.root)
        binding.sectionTrial.visibility = View.GONE
        binding.trialStatus.text = getString(R.string.already_purchased)
        binding.buyButton.visibility = View.GONE
        binding.restoreButton.visibility = View.GONE
        binding.priceRow.visibility = View.GONE
    }

    override val wantsMiniPlayerVisible: Boolean
        get() = false

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Purchase {
            return Purchase().apply { arguments = Bundle() }
        }

        const val TAG = "Purchase"
    }
}
