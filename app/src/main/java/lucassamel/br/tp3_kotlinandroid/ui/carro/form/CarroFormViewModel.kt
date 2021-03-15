package lucassamel.br.tp3_kotlinandroid.ui.carro.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.tp3_kotlinandroid.dao.CarroDaoFirestore
import lucassamel.br.tp3_kotlinandroid.model.Carro

class CarroFormViewModel(
    private val carroDao: CarroDaoFirestore
) : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String?>()
    val msg: MutableLiveData<String?> = _msg

    init {
        _status.value = false
        _msg.value = null
    }

    fun inserCarro(modelo: String, marca: String, ano: String, preco: String) {
        val carro = Carro(modelo,marca,ano,preco)
        carroDao.insert(carro)
                .addOnSuccessListener {
                    _status.value = true
                    _msg.value = "Persistência realizada com sucesso."
                }
                .addOnFailureListener {
                    _msg.value = "${it.message}"
                }
    }
}