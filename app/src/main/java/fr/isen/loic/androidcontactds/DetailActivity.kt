package fr.isen.loic.androidcontactds

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import fr.isen.loic.androidcontactds.databinding.ActivityDetailBinding
import fr.isen.loic.androidcontactds.model.Personne
import java.util.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var personne: Personne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        personne = intent.getSerializableExtra("contact") as Personne
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(personne.picture.large.isNotEmpty()) {
            Picasso.get().load(personne.picture.large).into(binding.image)
            binding.image
        }
        binding.nom.text = personne.name.first + " " + personne.name.last.uppercase()
        binding.adresse.text = personne.location.street.number.toString() + " " + personne.location.street.name + " " + personne.location.city + " " + personne.location.state
        binding.mail.text = personne.email
        binding.phone.text = personne.phone.replace("-", " ")
        var date = personne.dob.date.split("T")[0].split("-")
        binding.birth.text = date[2] + "/" + date[1] + "/" + date[0]


    }

}