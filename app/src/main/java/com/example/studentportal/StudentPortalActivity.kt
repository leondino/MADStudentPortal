package com.example.studentportal

import android.app.Activity
import android.content.Intent
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

const val ADD_PORTAL_REQUEST_CODE = 100

class StudentPortalActivity : AppCompatActivity() {

    private var portals = arrayListOf<Portal>()
    private var portalAdapter = PortalAdapter(portals, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_portal)
        setSupportActionBar(toolbar)

        initViews()

        fab.setOnClickListener {
            startAddActivity()
        }
    }

    private fun initViews(){
        rvPortals.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvPortals.adapter = portalAdapter

        portalAdapter.notifyDataSetChanged()
    }

    private fun startAddActivity(){
        val intent = Intent(this, AddPortalActivity::class.java)
        startActivityForResult(intent, ADD_PORTAL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when (requestCode){
                ADD_PORTAL_REQUEST_CODE -> {
                    val portal = data!!.getParcelableExtra<Portal>(EXTRA_PORTAL)
                    portals.add(portal)
                    portalAdapter.notifyDataSetChanged()
                }
            }
        }
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
