package fr.isen.loic.androidcontactds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import fr.isen.loic.androidcontactds.databinding.ActivityHomeBinding
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import fr.isen.loic.androidcontactds.model.Data

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.liste.layoutManager = LinearLayoutManager(null)
        binding.liste.hasFixedSize()
        loadContactsFromApi()
    }

    private fun loadContactsFromApi() {
        val jsonObject = JSONObject()
        val request = JsonObjectRequest(
            Request.Method.GET,
            "https://randomuser.me/api/?results=10&nat=fr",
            jsonObject,
            { response ->
                try {
                    val datas = Gson().fromJson(response.toString(), Data::class.java)
                    binding.liste.adapter = ContactAdapter(datas.results) {
                            startActivity(Intent(this, DetailActivity::class.java).putExtra("contact", it))
                        }
                } catch (e: JSONException) {
                    Toast.makeText(this, "Error parsing JSON", Toast.LENGTH_SHORT).show()
                }
            },
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(this).add(request)
    }
}