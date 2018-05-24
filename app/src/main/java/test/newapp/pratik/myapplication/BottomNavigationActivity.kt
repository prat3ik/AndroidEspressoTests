package test.newapp.pratik.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import test.newapp.pratik.myapplication.R.*
import test.newapp.pratik.myapplication.fragments.OneFragment
import test.newapp.pratik.myapplication.fragments.ThreeFragment
import test.newapp.pratik.myapplication.fragments.TwoFragment

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                id.bnOne -> {
                    val fragment = OneFragment.newInstance()
                    addFragment(fragment)
                }

                id.bnTwo -> {
                    val fragment = TwoFragment.newInstance()
                    addFragment(fragment)
                }
                id.bnThree -> {
                    val fragment = ThreeFragment.newInstance()
                    addFragment(fragment)
                }
                else ->
                    Toast.makeText(this, "Default Fragment", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val fragment = OneFragment.newInstance()
        addFragment(fragment)

    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }
}