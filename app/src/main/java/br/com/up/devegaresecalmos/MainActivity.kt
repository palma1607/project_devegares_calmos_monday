package br.com.up.devegaresecalmos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.up.devegaresecalmos.model.Race
import br.com.up.devegaresecalmos.repository.RaceRepository
import com.google.firebase.Timestamp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = RaceRepository.instance()

        repository.getAll{ races ->

        }



        /*val race = Race(
            "402",
            10.5f,
            Timestamp.now(),
            "Toretto"
        )

        repository.save(
            race
        )*/



    }
}