package br.com.up.devegaresecalmos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import br.com.up.devegaresecalmos.R
import br.com.up.devegaresecalmos.model.Race
import br.com.up.devegaresecalmos.repository.RaceRepository
import com.google.firebase.Timestamp

class RegisterRaceFragment : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_register,
            container,
            false
        )
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSave : Button =
            view.findViewById(R.id.button_save)

        val editRace : EditText =
            view.findViewById(R.id.edit_race)

        val editLocal : EditText =
            view.findViewById(R.id.edit_local)

        val editTime : EditText =
            view.findViewById(R.id.edit_time)

        buttonSave.setOnClickListener {

            val raceName = editRace.text.toString()
            val raceLocal = editLocal.text.toString()
            val raceTime = editTime.text.toString()

            RaceRepository.instance().save(
                Race(
                    raceLocal,
                    raceTime.toFloat(),
                    Timestamp.now(),
                    raceName,
                    null
                )
            )
        }
    }

}