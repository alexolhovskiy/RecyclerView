package com.example.myrecyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    private val adapter=BenderAdapter()
    private val benders=listOf(
        R.drawable.bender1,
        R.drawable.bender2,
        R.drawable.bender3
        )
    private var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        init()
    }

    private fun init(){
        //mainBinding.apply{
        //mainBinding.rcView.layoutManager=GridLayoutManager(this@MainActivity,3)
        mainBinding.rcView.layoutManager= LinearLayoutManager(this)
        mainBinding.rcView.adapter=adapter
        mainBinding.b1.setOnClickListener{
                if(index>2)index=0
                val nbender=Bender(benders[index],"Bender $index")
                adapter.addBender(nbender)
                index++
            }
        //}
    }
}