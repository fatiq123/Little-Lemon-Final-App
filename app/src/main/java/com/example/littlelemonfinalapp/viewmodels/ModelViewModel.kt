package com.example.littlelemonfinalapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.littlelemonfinalapp.database.Model

class ModelViewModel : ViewModel() {
    // Define a LiveData to hold the list of Model items
    private val _modelData = MutableLiveData<List<Model>>()
    val modelData: LiveData<List<Model>> = _modelData

    // Function to set the Model data
    fun setModelData(data: List<Model>) {
        _modelData.value = data
    }
}