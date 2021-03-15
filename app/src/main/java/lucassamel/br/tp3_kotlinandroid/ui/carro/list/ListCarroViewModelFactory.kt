package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_kotlinandroid.dao.CarroDaoFirestore
import lucassamel.br.tp3_kotlinandroid.ui.carro.form.CarroFormViewModel

class ListCarroViewModelFactory(
        private val carroDao: CarroDaoFirestore
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarroFormViewModel::class.java))
            return CarroFormViewModel(carroDao ) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }

}
