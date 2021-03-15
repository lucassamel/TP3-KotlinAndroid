package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.carro_list_fragment.*
import lucassamel.br.tp3_kotlinandroid.R

class CarroListFragment : Fragment() {



    private lateinit var viewModel: CarroListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.carro_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabtnCarroForm.setOnClickListener {
            findNavController().navigate(R.id.action_carroListFragment_to_carroFormFragment)
        }
    }

}