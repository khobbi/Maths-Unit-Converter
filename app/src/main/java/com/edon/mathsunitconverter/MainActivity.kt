package com.edon.mathsunitconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.edon.mathsunitconverter.classes.Calculations
import com.edon.mathsunitconverter.classes.Categories
import com.edon.mathsunitconverter.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var bnd: ActivityMainBinding
    private lateinit var category: Categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bnd.root)

        //initialize the categories
        category = Categories()
        //onclick for the clear and calculate fabs
        bnd.fabClear.setOnClickListener{
            btnClearFields()
        }
        bnd.fabConvert.setOnClickListener{ view ->
            view.hideKeyboard() //hide keyboard from screen
            btnCalculate(view)
        }
        //get category list and put it in adapter for the category spinner
        val categoryAdapter = ArrayAdapter<String>(this, R.layout.spinner_item_a, category.categoryList)
        bnd.spnCategory.adapter = categoryAdapter

        //setting onItemSelectedListener for the Categories, From, and To
        setOnItemSelectedListenersForSpinners()

        //hide keyboard when user clicks on empty space
        bnd.viewBackgroundTop.setOnClickListener { it -> it.hideKeyboard() }
        bnd.viewBackgroundDown.setOnClickListener { it -> it.hideKeyboard() }
    }

    private fun setOnItemSelectedListenersForSpinners() {
        //listener for Category Spinner
        bnd.spnCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //pass category list of units to be used to set the other spinners
                setSpinnersItems(category.getCategory(position))
                //send index of item selected from the Category spinner to the variable
                // in the Calculations object
                Calculations.categoryIndex = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        //listener for From Spinner
        bnd.spnFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //send index of item selected from the From spinner to the variable
                // in the Calculations object
                Calculations.indexOfFrom = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        //listener for To Spinner
        bnd.spnTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //send index of item selected from the To spinner to the variable
                // in the Calculations object
                Calculations.indexOfTo = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    //clear all inputs
    private fun btnClearFields(){
        bnd.tieFrom.text!!.clear()
        bnd.tieTo.text!!.clear()
        bnd.tilFrom.error = null
    }

    private fun btnCalculate(view: View){
        //use the try to catch if text field is empty, if statement can work too
        try {
            bnd.tilFrom.error = null // clear previous error message if any

            val number: Double = bnd.tieFrom.text.toString().toDouble()
            bnd.tieTo.setText(String.format("%.4g", Calculations.calculate(number)))
        } catch (e: Exception){
            bnd.tilFrom.error = "Please enter a valid number!"
        }
    }

    //set the list in the spinners according to the array that will be passed to the method
    fun setSpinnersItems(category: ArrayList<String>){
        val arrayAdapter1 = ArrayAdapter<String>(this, R.layout.spinner_item_a, category)
        val arrayAdapter2 = ArrayAdapter<String>(this, R.layout.spinner_item_b, category)
        bnd.spnFrom.adapter = arrayAdapter1
        bnd.spnTo.adapter = arrayAdapter2
    }

    //hide keyboard
    private fun View.hideKeyboard(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}