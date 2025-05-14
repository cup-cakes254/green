package com.mwikali.greenhub.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mwikali.greenhub.ui.theme.Screens.home.TruckRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.jvm.java
class TruckRequestViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().reference
    private val _truckRequests = MutableStateFlow<List<TruckRequest>>(emptyList())
    val truckRequests: StateFlow<List<TruckRequest>> = _truckRequests

    init {
        fetchRequests()
    }

    private fun fetchRequests() {
        val userId = auth.currentUser?.uid ?: return
        db.child("users").child(userId).child("truckRequests")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = snapshot.children.mapNotNull {
                        it.getValue(TruckRequest::class.java)
                    }

                    _truckRequests.value = list.sortedByDescending { it.pickupDate }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("TruckRequestVM", "Failed to load requests: ${error.message}")
                }
            })
    }
}
