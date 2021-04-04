package com.dicoding.fundamentalandroid.ListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.fundamentalandroid.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_list_view_main.view.*

class HeroAdapter(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder(view: View){
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvDescription: TextView = view.findViewById(R.id.tv_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero) {
            tvName.text = hero.name
            tvDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = heroes.size
}