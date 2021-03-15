package lucassamel.br.tp3_kotlinandroid.dao

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import lucassamel.br.tp3_kotlinandroid.model.Carro

class CarroDaoFirestore {

    private val collection = FirebaseFirestore
        .getInstance()
        .collection("carros")

    fun insert(carro: Carro): Task<Void> {
        return collection
            .document(carro.modelo!!)
            .set(carro)
    }
    fun delete(carro: Carro): Task<Void> {
        return collection
            .document(carro.modelo!!)
            .delete()
    }
    fun get(placa: String): Task<DocumentSnapshot> {
        return collection
            .document(placa)
            .get()
    }

    fun selectByMarca(modelo: String): Task<QuerySnapshot> {
        return collection
            .whereEqualTo("modelo", modelo)
            .get()
    }

    fun all(): CollectionReference {
        return collection
    }
}