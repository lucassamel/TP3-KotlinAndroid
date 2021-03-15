package lucassamel.br.tp3_kotlinandroid.ui.carro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.list_carro_recycler.view.*
import lucassamel.br.tp3_kotlinandroid.R
import lucassamel.br.tp3_kotlinandroid.model.Carro

class CarroRecyclerAdapter(
    private val carros: List<Carro>,
    private val actionClick: (Carro) -> Unit
): RecyclerView.Adapter<CarroRecyclerAdapter.CarroViewHolder>() {

    class CarroViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val textMarca: TextView = itemView.textViewRecyclerCarroMarca
        val textModelo: TextView = itemView.textViewRecyclerCarroModelo
        val textPreco: TextView = itemView.textViewRecyclerCarroPreco
        val textAno: TextView = itemView.textViewRecyclerCarroAno
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.list_carro_recycler,
                parent, false
            )
        return CarroViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = carros[position]
        holder.textMarca.text = carro.marca
        holder.textModelo.text = carro.modelo
        holder.textPreco.text = carro.preco
        holder.textAno.text = carro.ano

        holder.itemView.setOnClickListener {
            actionClick(carro)
        }
    }

    override fun getItemCount(): Int = carros.size

    private fun deleteCarro(carro: Carro): Task<Void> {
        val collection = FirebaseFirestore.getInstance().collection("carros")

        return collection
            .document(carro.modelo!!)
            .delete()
    }

}