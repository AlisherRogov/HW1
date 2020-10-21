package ru.techpark.hw1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val clickListener: (String) -> Unit) : RecyclerView.Adapter<DataAdapter.ElemViewHolder>() {
    var data = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemViewHolder {
        val holder = ElemViewHolder.getHolder(parent)
        holder.itemView.setOnClickListener { clickListener(holder.getNumber()) }
        return holder
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ElemViewHolder, position: Int) {
        holder.setData(data[position].toString())
    }

    class ElemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.number_item)

        fun setData(number: String) {
            textView.text = number
            if (Integer.parseInt(number) % 2 == 0) {
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.red))
            } else {
                textView.setTextColor(ContextCompat.getColor(textView.context, R.color.blue))
            }
        }

        fun getNumber(): String = textView.text as String

        companion object {
            fun getHolder(parent: ViewGroup): ElemViewHolder {
                val layoutIdForListItem = R.layout.fragment_all_numbers_item
                val inflater = LayoutInflater.from(parent.context)
                val shouldAttachToParentImmediately = false
                val view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately)
                return ElemViewHolder(view)
            }
        }
    }

}