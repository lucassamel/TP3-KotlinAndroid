package lucassamel.br.tp3_kotlinandroid.ui.carro.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_kotlinandroid.R

class CarroFormFragment : Fragment() {

    companion object {
        fun newInstance() = CarroFormFragment()
    }

    private lateinit var viewModel: CarroFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.carro_form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarroFormViewModel::class.java)
        // TODO: Use the ViewModel
    }

}