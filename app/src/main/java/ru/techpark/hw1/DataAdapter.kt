package ru.techpark.hw1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val clickListener: (String) -> Unit) : RecyclerView.Adapter<DataAdapter.ElemViewHolder> () {
    var data = listOf<Int> ()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemViewHolder {
        return ElemViewHolder.getHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ElemViewHolder, position: Int) {
        holder.setData(data[position].toString(), clickListener)
    }

    class ElemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.number_item)

        fun setData(number:String, clickListener: (String) -> Unit) {
            textView.text = number
            itemView.setOnClickListener{clickListener(number)}
        }

        companion object {
            fun getHolder(parent: ViewGroup): ElemViewHolder {
                val context = parent.context
                val layoutIdForListItem = R.layout.fragment_all_numbers_item
                val inflater = LayoutInflater.from(context)
                val shouldAttachToParentImmediately = false
                val view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately)
                return ElemViewHolder(view)
            }
        }
    }

}