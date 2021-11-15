package com.example.permutationandcombination

import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainViewModel:ViewModel() {

    var n:Long=0
    var r:Long=0

    fun find_factorial(num:Long):Long{
        var result:Long=1
        for(i in 1..num){
            result*=i
        }
        return result
    }

    fun find_combination(n:Long,r:Long):Long{
        var numerator=find_factorial(n)
        var denominator=find_factorial(r)*find_factorial(n-r)
        var result=numerator/denominator
        return result
    }

    fun find_permutation(n:Long,r:Long):Long{
        var numerator=find_factorial(n)
        var denominator=find_factorial(n-r)
        var result=numerator/denominator
        return result
    }

    fun setText_permutation(n:Long,r:Long):String{
        return "Permutation : ${find_permutation(n,r).toString()}"

    }

    fun setText_combination(n:Long,r:Long):String{
        return "Combination : ${find_combination(n,r).toString()}"
    }
}