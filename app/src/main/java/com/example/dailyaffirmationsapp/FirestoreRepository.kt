package com.example.dailyaffirmationsapp

import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepository {

    // Reference to "affirmations" collection in Firestore
    private val collection =
        FirebaseFirestore.getInstance().collection("affirmations")

    // Add new affirmation
    fun addAffirmation(text: String) {
        if (text.isNotBlank()) {
            collection.add(
                mapOf("text" to text)
            )
        }
    }

    // Fetch all affirmations and listen for real-time updates
    fun fetchAffirmations(
        onAffirmationChanged: (List<Pair<String, String>>) -> Unit
    ) {

        collection.addSnapshotListener { snapshots, _ ->

            val affirmationList =
                snapshots?.documents?.mapNotNull { document ->

                    val text = document.getString("text")

                    if (text != null) {
                        document.id to text
                    } else {
                        null
                    }

                } ?: emptyList()

            onAffirmationChanged(affirmationList)
        }
    }

    // Update affirmation
    fun updateAffirmation(id: String, newText: String) {
        collection.document(id).update("text", newText)
    }

    // Delete affirmation
    fun deleteAffirmation(id: String) {
        collection.document(id).delete()
    }
}