package com.devspace.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

// Adaptacao entre o data class e o item_list layout
class ContactListAdapter :
    ListAdapter<Contact,  ContactListAdapter.ContactViewHolder>(ContactDiffUtil()) {

    private lateinit var onClickListener: (Contact) -> Unit

     // criar um view holder
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
         return ContactViewHolder(view)

    }
     // bind - atrelar o dadocom a UI views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }

     fun setOnClickListener(onClick: (Contact) -> Unit){
        onClickListener = onClick
    }

    //view holder = view que segura os dados
    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(contact: Contact, onClick: (Contact) -> Unit){
       tvName.text = contact.name
            tvPhone.text = contact.phone
            image.setImageResource(contact.icon)

            view.setOnClickListener {
                onClick.invoke(contact)
            }
        }

    }

    class ContactDiffUtil : DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

    }



}


