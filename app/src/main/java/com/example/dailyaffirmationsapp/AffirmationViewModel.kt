package com.example.dailyaffirmationsapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AffirmationViewModel : ViewModel() {

    private val firestoreRepository = FirestoreRepository()

    // Stores all affirmations
    val affirmations = mutableStateListOf<Pair<String, String>>()

    init {

        firestoreRepository.fetchAffirmations { updatedAffirmations ->

            affirmations.clear()
            affirmations.addAll(updatedAffirmations)
        }
    }

    // Add affirmation
    fun addAffirmation(text: String) {
        firestoreRepository.addAffirmation(text)
    }

    // Delete affirmation
    fun deleteAffirmation(id: String) {
        firestoreRepository.deleteAffirmation(id)
    }

    // Update affirmation
    fun updateAffirmation(id: String, newText: String) {
        firestoreRepository.updateAffirmation(id, newText)
    }
}