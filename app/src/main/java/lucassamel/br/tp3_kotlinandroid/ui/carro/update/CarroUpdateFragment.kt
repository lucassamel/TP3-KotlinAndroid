package lucassamel.br.tp3_kotlinandroid.ui.carro.update

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_kotlinandroid.R

class CarroUpdateFragment : Fragment() {

    companion object {
        fun newInstance() = CarroUpdateFragment()
    }

    private lateinit var viewModel: CarroUpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.carro_update_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarroUpdateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}