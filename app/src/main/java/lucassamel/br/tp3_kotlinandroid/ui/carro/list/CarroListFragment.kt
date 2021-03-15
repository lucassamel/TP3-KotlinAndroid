package lucassamel.br.tp3_kotlinandroid.ui.carro.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.carro_list_fragment.*
import lucassamel.br.tp3_kotlinandroid.R
import lucassamel.br.tp3_kotlinandroid.dao.CarroDaoFirestore
import lucassamel.br.tp3_kotlinandroid.model.AppUtil
import lucassamel.br.tp3_kotlinandroid.model.Carro
import lucassamel.br.tp3_kotlinandroid.ui.carro.adapter.CarroRecyclerAdapter

class CarroListFragment : Fragment() {

    private lateinit var viewModel: CarroListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val application = requireActivity().application
//
//        val carroFormViewModelFactory = ListCarroViewModelFactory(CarroDaoFirestore(),
//                application)
//
//        viewModel = ViewModelProvider(this, carroFormViewModelFactory)
//                .get(CarroListViewModel::class.java)

        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null)
            findNavController().popBackStack()

        val listCarros = ListCarroViewModelFactory(CarroDaoFirestore())
        viewModel = ViewModelProvider(this,listCarros)
                .get(CarroListViewModel::class.java)

        viewModel.carros.observe(viewLifecycleOwner){
            setupListViewCarros(it)
        }

        viewModel.atualizarQuantidade()

        return inflater.inflate(R.layout.carro_list_fragment, container, false)
    }


    private fun setupListViewCarros(carros: List<Carro>) {
        listCarros.adapter = CarroRecyclerAdapter(carros) {
            AppUtil.carroSelecionado = it
//            findNavController().navigate(R.id.)
        }
        listCarros.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabtnCarroForm.setOnClickListener {
            findNavController().navigate(R.id.action_carroListFragment_to_carroFormFragment)
        }
    }

}