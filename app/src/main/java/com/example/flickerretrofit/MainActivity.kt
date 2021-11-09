package com.example.flickerretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm by lazy { ViewModelProvider(this).get(MyVM::class.java) }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var search=findViewById<EditText>(R.id.search)
        var btn=findViewById<Button>(R.id.button)
        var rv=findViewById<RecyclerView>(R.id.rv)
        btn.setOnClickListener {
           vm.getData(search.text.toString())
            vm.getContents().observe(this, { contents ->
               rv.adapter=RVAdapter(contents)
                rv.layoutManager=LinearLayoutManager(this)
            })



        }

    }
}