package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_kotlinandroid.R

class CarroListFragment : Fragment() {

    companion object {
        fun newInstance() = CarroListFragment()
    }

    private lateinit var viewModel: CarroListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.carro_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarroListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}