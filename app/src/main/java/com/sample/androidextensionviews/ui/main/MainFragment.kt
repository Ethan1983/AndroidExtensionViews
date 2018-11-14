package com.sample.androidextensionviews.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import com.sample.androidextensionviews.R
import kotlinx.android.synthetic.main.intro_text_layout.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        val viewStub : ViewStub = view.findViewById( R.id.viewStub )
        viewStub.layoutResource = R.layout.intro_text_layout
        viewStub.inflate()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // stubInflatedText needs a Layout container. The container gets the inflatedId from the ViewStub.
        // Without layoutcontainer, the textview replaces the ViewStub but gets the inflatedId and the id
        // stubInflatedText is basically ignored and any findViewById will fail with null.
        stubInflatedText.text = "Updated Text from Fragment"

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
