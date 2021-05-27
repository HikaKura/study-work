package com.example.mp.friends

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mp.R
import com.example.mp.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.URL
import androidx.fragment.app.Fragment

class ListAdapter(context: Context, private val data: List<User>): BaseAdapter() {

    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) view = inflater.inflate(R.layout.list_row, null)!!

        val currentItem = data[position]

        val textView = view.findViewById<View>(R.id.list_row_text) as TextView
        textView.text = "${currentItem.firstName} ${currentItem.lastName}"

        val description = view.findViewById<View>(R.id.list_row_description) as TextView

        val imageView: ImageView = view.findViewById(R.id.list_row_icon) as ImageView

        runBlocking {
            val photo = GlobalScope.launch {
                val url = URL(currentItem.photo)
                val image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageView.setImageBitmap(image)
            }

            photo.join()
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}