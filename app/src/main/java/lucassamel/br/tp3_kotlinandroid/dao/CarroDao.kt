package lucassamel.br.tp3_kotlinandroid.dao

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import lucassamel.br.tp3_kotlinandroid.model.Carro

interface CarroDao {

    fun insert(vehicle: Carro): Task<Void>

    fun delete(vehicle: Carro) : Task<Void>

    fun get(placa: String): Task<DocumentSnapshot>

    fun selectByMarca(marca: String): Task<QuerySnapshot>

    fun all(): CollectionReference
}