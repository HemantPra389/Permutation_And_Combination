package com.example.permutationandcombination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.permutationandcombination.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        val_calculate.setOnClickListener {
            if (binding.valN.text.isEmpty() || binding.valR.text.isEmpty()){
                Toast.makeText(this, "Empty Values", Toast.LENGTH_SHORT).show()
                binding.tvValCom.text="0"
                binding.tvValPer.text="0"
            }else{
                mainViewModel.n=val_n.text.toString().toLong()
                mainViewModel.r=val_r.text.toString().toLong()
                if (binding.valN.text.toString().toLong()>20 || binding.valR.text.toString().toLong()>20){
                    Toast.makeText(this, "Not Valid", Toast.LENGTH_SHORT).show()
                }else{
                    if (mainViewModel.n<mainViewModel.r){
                        Toast.makeText(this, "r cannot be greater than n", Toast.LENGTH_SHORT).show()
                    }else{
                        binding.tvValPer.text= mainViewModel.setText_permutation(mainViewModel.n,mainViewModel.r)
                        binding.tvValCom.text= mainViewModel.setText_combination(mainViewModel.n,mainViewModel.r)
                    }

                }

            }


        }

    }


}