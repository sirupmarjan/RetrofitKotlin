package com.quick.datarecyclerfirebasekt.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quick.datarecyclerfirebasekt.Model.Users
import com.quick.datarecyclerfirebasekt.R
import kotlinx.android.synthetic.main.user_list.view.*

class UsersAdapter(val data: List<Users>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Users?) {
            itemView.nama.text = get?.name
            itemView.email.text = get?.email
            itemView.notelp.text = get?.phone

            val address =
                "${get?.address?.street}, ${get?.address?.city}, ${get?.address?.suite}, ${get?.address?.zipcode} "
            itemView.alamat.text = address
        }

    }
}
