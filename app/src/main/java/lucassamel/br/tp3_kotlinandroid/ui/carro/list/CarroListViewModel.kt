package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.tp3_kotlinandroid.dao.CarroDao
import lucassamel.br.tp3_kotlinandroid.model.Carro

class CarroListViewModel(private val carroDao: CarroDao) : ViewModel() {

    private val _carros = MutableLiveData<List<Carro>>()
    val carros: LiveData<List<Carro>> = _carros

    fun atualizarQuantidade() {
        carroDao.all() // task<>
            .addSnapshotListener { snapshot, error ->
                if (error != null)
                    Log.i("LstCarroVMSnapshotError", "${error.message}")
                else
                    if (snapshot != null && !snapshot.isEmpty)
                        _carros.value = snapshot.toObjects(Carro::class.java)
            }
    }
}