package ru.techpark.hw1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class OneNumberFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_number, container, false)
        val bundle = arguments

        if (bundle != null) {
            val textView = view.findViewById<TextView>(R.id.number)
            val number = bundle.getString(AllNumbersFragment.getNumbersKey(), "2")
            textView.text = number
            if (Integer.parseInt(number) % 2 == 0) {
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.red))
            } else {
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.blue))
            }
        }
        return view
    }
}