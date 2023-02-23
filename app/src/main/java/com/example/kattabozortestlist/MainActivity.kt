package com.example.kattabozortestlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.kattabozortestlist.ui.OffersFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private var mFragmentTransaction: FragmentTransaction? = null
   private var mFragmentManager: FragmentManager? = null

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      mFragmentManager = supportFragmentManager
      mFragmentTransaction = mFragmentManager?.beginTransaction()
      mFragmentTransaction?.replace(R.id.container, OffersFragment())
      mFragmentTransaction?.commit()
   }

}