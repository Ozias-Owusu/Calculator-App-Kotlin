//package com.example.calculatorapp
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import org.mozilla.javascript.Context
//import org.mozilla.javascript.Scriptable
//
//class CalculatorViewModel: ViewModel(){
//
//    private val _equationText = MutableLiveData("")
//    val equationText : LiveData<String> = _equationText
//
//    private val _resultText = MutableLiveData("0")
//    val resultText : LiveData<String> = _resultText
//
//    fun onButtonClicked(symbol:String){
//        Log.i("Clicked Button ", symbol)
//
//        _equationText.value?.let {
//            if(symbol=="C"){
//                if(it.isNotEmpty()){
//                    _equationText.value = it.substring(0,it.length-1)
//                }
//                return
//            }
//            if(symbol == "="){
//                _equationText.value = _resultText.value
//                return
//            }
//            _equationText.value = it+symbol
//
//            //Calculate Result
//            try {
//                _resultText.value =  calculateResult(_equationText.value.toString())
//            }catch (_ : Exception){}
//        }
//    }
//}
//
//fun calculateResult(equation : String) : String{
//    val context : Context = Context.enter()
//    context.optimizationLevel = -1
//    val scriptable : Scriptable = context.initStandardObjects()
//
//
//    val modifiedEquation = equation
//        .replace("x", "*")
//        .replace("%", "/100")
//        .replace("÷", "/")
//
//    var finalResult = context.evaluateString(scriptable,modifiedEquation,"Javascript",1,null).toString()
//    if(finalResult.endsWith(".0")){
//        finalResult = finalResult.replace(".0","")
//    }
//    return finalResult
//}