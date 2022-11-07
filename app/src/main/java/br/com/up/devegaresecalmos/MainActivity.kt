package br.com.up.devegaresecalmos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import br.com.up.devegaresecalmos.fragment.RegisterRaceFragment
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


        val dialogRegister = RegisterRaceFragment()
        dialogRegister.show(supportFragmentManager,
            "DialogRegister")

    }
}