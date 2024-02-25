package com.ebookfrenzy.namesave

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var input: MutableLiveData<String> = MutableLiveData()
    var output: MutableLiveData<String> = MutableLiveData()
    var outputNames: MutableLiveData<List<String>> = MutableLiveData()

    init {
        outputNames.value = mutableListOf()
    }

    fun addName() {
        val currentList = outputNames.value?.toMutableList() ?: mutableListOf()
        input.value?.let { name ->
            if (name.isNotEmpty()) {
                currentList.add(name)
                outputNames.value = currentList.toList()
                output.value = currentList.joinToString("\n")
            } else {
                output.value = "No Name Entered"
            }
        }
    }


//    fun addName() {
//        input.let {
//            if (!it.value.equals("")) {
//                output.value = input.value.toString()
//            } else {
//                output.value = "No Name Entered"
//            }
//        }
//    }
}