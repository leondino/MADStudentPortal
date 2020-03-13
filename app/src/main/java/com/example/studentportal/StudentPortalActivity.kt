package com.example.studentportal

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_student_portal.*
import kotlinx.android.synthetic.main.content_student_portal.*
import kotlinx.android.synthetic.main.item_portal.view.*

class StudentPortalActivity : AppCompatActivity() {

    private var portals = arrayListOf<Portal>()
    private var portalAdapter = PortalAdapter(portals, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_portal)
        setSupportActionBar(toolbar)

        initView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initView(){
        rvPortals.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvPortals.adapter = portalAdapter

        //test
        portals.add(Portal("serebii","https://serebii.net/"))
        portals.add(Portal("android level 3 task 2", "https://www.android-development.app/level-3-multi-screen-app/level3-task2"))

        portalAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
