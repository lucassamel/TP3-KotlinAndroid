package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarroListViewModel : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String?>()
    val msg: MutableLiveData<String?> = _msg
}