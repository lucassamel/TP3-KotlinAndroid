package lucassamel.br.tp3_kotlinandroid.ui.carro.form

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_kotlinandroid.dao.CarroDaoFirestore

class CarroFormViewModelFactory(private val vehicleDao: CarroDaoFirestore,
                                private val application: Application
): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarroFormViewModel::class.java))
            return CarroFormViewModel(vehicleDao, application) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}