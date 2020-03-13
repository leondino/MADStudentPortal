package com.example.studentportal

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>, private val context: Context) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    private val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(portal: Portal){
            itemView.portalButton.text = context.getString(R.string.portal_text, portal.name, portal.url)
            itemView.portalButton.setOnClickListener { customTabsIntent.launchUrl(context, Uri.parse(portal.url)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }
}