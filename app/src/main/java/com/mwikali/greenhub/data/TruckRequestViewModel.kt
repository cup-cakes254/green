package com.mwikali.greenhub.data

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.mwikali.greenhub.ui.theme.Screens.Full.TruckRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TruckRequestViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("TruckRequests")

    private val _truckRequests = MutableStateFlow<List<TruckRequest>>(emptyList())
    val truckRequests: StateFlow<List<TruckRequest>> = _truckRequests

    init {
        fetchTruckRequests()
    }

    private fun fetchTruckRequests() {
        val uid = auth.currentUser?.uid ?: return
        val userRequestsRef = db.child(uid)
        userRequestsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<TruckRequest>()
                for (snap in snapshot.children) {
                    val request = snap.getValue(TruckRequest::class.java)
                    request?.let { list.add(it) }
                }
                viewModelScope.launch(Dispatchers.Main) {
                    _truckRequests.emit(list)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // You can show error toast here if you want
            }
        })
    }

    fun submitRequest(
        context: Context,
        truckName: String,
        pickupDate: String,
        onSuccess: () -> Unit = {},
        onFailure: () -> Unit = {}
    ) {
        val uid = auth.currentUser?.uid ?: run {
            Toast.makeText(context, "User not signed in", Toast.LENGTH_SHORT).show()
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val requestId = db.child(uid).push().key ?: ""
            val request = TruckRequest(
                truckname = truckName,
                pickupdate = pickupDate,
                timestamp = System.currentTimeMillis()
            )
            db.child(uid).child(requestId).setValue(request)
                .addOnSuccessListener {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Request saved", Toast.LENGTH_SHORT).show()
                        onSuccess()
                    }
                }
                .addOnFailureListener {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Save failed", Toast.LENGTH_SHORT).show()
                        onFailure()
                    }
                }
        }
    }

    fun deleteRequest(
        context: Context,
        requestId: String
    ) {
        val uid = auth.currentUser?.uid ?: run {
            Toast.makeText(context, "User not signed in", Toast.LENGTH_SHORT).show()
            return
        }

        AlertDialog.Builder(context)
            .setTitle("Delete Request")
            .setMessage("Are you sure you want to delete this request?")
            .setPositiveButton("Yes") { _, _ ->
                db.child(uid).child(requestId)
                    .removeValue()
                    .addOnCompleteListener { task ->
                        Toast.makeText(
                            context,
                            if (task.isSuccessful) "Deleted" else "Delete failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
            .setNegativeButton("No", null)
            .show()
    }

    // Optional: updateRequest function (similar to submitRequest)
}


//package com.mwikali.greenhub.data
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.*
//import com.mwikali.greenhub.ui.theme.Screens.Full.TruckRequest
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//
//class TruckRequestViewModel : ViewModel() {
//
//    private val auth = FirebaseAuth.getInstance()
//    private val db   = FirebaseDatabase.getInstance().reference
//
//    // Backing StateFlow holding the full list of requests
//    private val _truckRequests = MutableStateFlow<List<TruckRequest>>(emptyList())
//    val truckRequests: StateFlow<List<TruckRequest>> = _truckRequests
//
//    init {
//        fetchRequestsFromFirebase()
//    }
//
//    /** Loads all pickup requests for the current user into `_truckRequests`. */
//    private fun fetchRequestsFromFirebase() {
//        val uid = auth.currentUser?.uid ?: return
//        val ref = db.child("users").child(uid).child("truckRequests")
//
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val list = snapshot.children.mapNotNull {
//                    it.getValue(TruckRequest::class.java)
//                }
//                // Sort newest first
//                _truckRequests.value = list.sortedByDescending { it.pickupDate }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.e("TruckRequestVM", "Error loading requests: ${error.message}")
//            }
//        })
//    }
//
//    /**
//     * Returns only those requests whose truckName and pickupDate match the parameters.
//     */
//    fun filterRequests(truckName: String, pickupDate: String): List<TruckRequest> {
//        return _truckRequests.value.filter {
//            it.truckName == truckName && it.pickupDate == pickupDate
//        }
//    }
//}
//
//
//
//
//

























































































































