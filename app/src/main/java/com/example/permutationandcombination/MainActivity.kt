package com.example.permutationandcombination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        val_calculate.setOnClickListener {
            if (val_n.text.isEmpty() || val_n.text.isEmpty()){
                Toast.makeText(this, "Empty Values", Toast.LENGTH_SHORT).show()
                tv_val_com.text="0"
                tv_val_per.text="0"
            }else{
                mainViewModel.n=val_n.text.toString().toLong()
                mainViewModel.r=val_r.text.toString().toLong()
                if (val_n.text.toString().toLong()>20 || val_r.text.toString().toLong()>20){
                    Toast.makeText(this, "Not Valid", Toast.LENGTH_SHORT).show()
                }else{
                    if (mainViewModel.n<mainViewModel.r){
                        Toast.makeText(this, "r cannot be greater than n", Toast.LENGTH_SHORT).show()
                    }else{
                        tv_val_per.text= mainViewModel.setText_permutation(mainViewModel.n,mainViewModel.r)
                        tv_val_com.text= mainViewModel.setText_combination(mainViewModel.n,mainViewModel.r)
                    }

                }

            }


        }

    }


}