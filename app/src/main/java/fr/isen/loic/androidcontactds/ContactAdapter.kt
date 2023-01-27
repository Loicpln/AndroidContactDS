package fr.isen.loic.androidcontactds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.loic.androidcontactds.model.Location
import fr.isen.loic.androidcontactds.model.Name
import fr.isen.loic.androidcontactds.model.Personne
import fr.isen.loic.androidcontactds.model.Picture

class ContactAdapter(private val list: Array<Personne>, private val onClick: (Personne) -> Unit) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image: ImageView? = view.findViewById(R.id.image)
        private val nom: TextView? = view.findViewById(R.id.nom)
        private val adresse: TextView? = view.findViewById(R.id.adresse)
        private val mail: TextView? = view.findViewById(R.id.mail)

        fun bind(elem: Personne, onClick: (Personne) -> Unit) {
            setImage(elem.picture)
            setPrenomNom(elem.name)
            setAdresse(elem.location)
            setMail(elem.email)
            itemView.setOnClickListener {
                onClick(elem)
            }
        }

        private fun setImage(elem: Picture) {
            if(elem.large.isNotEmpty()) {
                Picasso.get().load(elem.large).into(image)
            }
        }

        private fun setPrenomNom(elem: Name) {
            nom?.text = elem.first + " " + elem.last.uppercase()
        }

        private fun setAdresse(elem: Location) {
            adresse?.text = elem.street.number.toString() + " " + elem.street.name + " " + elem.city + " " + elem.state
        }

        private fun setMail(elem: String) {
            mail?.text = elem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_contact, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], onClick)
    }
}