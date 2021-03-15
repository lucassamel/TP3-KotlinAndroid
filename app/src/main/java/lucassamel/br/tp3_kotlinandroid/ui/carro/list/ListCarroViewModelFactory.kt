package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_kotlinandroid.dao.CarroDao

class ListCarroViewModelFactory(
        private val carroDao: CarroDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarroListViewModel::class.java))
            return CarroListViewModel(carroDao ) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }

}
