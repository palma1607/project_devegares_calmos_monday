package br.com.up.devegaresecalmos.repository

import android.util.Log
import br.com.up.devegaresecalmos.model.Race
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RaceRepository private constructor(){

    private val collectionPath = "corridas"

    companion object{
        private var repository:RaceRepository? = null

        fun instance(): RaceRepository{
            if(repository == null){
                repository = RaceRepository()
            }
            return repository!!
        }
    }

    fun save(race:Race){
        val database = Firebase.firestore
        database.collection(collectionPath)
            .add(race)
    }

    fun delete(race:Race){
        val database = Firebase.firestore
        database.collection(collectionPath)
            .document(race.id!!)
            .delete()
    }

    fun getAll(callback:(List<Race>) -> Unit){

        val database = Firebase.firestore
        database.collection(collectionPath)
            .get()
            .addOnSuccessListener { documents ->
                val races = arrayListOf<Race>()
                for(document in documents){
                    val race = Race(
                        id = document.id,
                        opponent = document.get("opponent").toString(),
                        time = document.getDouble("time")!!.toFloat(),
                        hour = document.getTimestamp("hour")!!,
                        distance =  document.get("distance").toString()
                    )
                    races.add(race)
                }
                callback(races)
            }
    }

    fun getById(id:String, listener: (Race) -> Unit){
        val database = Firebase.firestore
        database.collection(collectionPath)
            .document(id).get().addOnSuccessListener{ document ->

                val race = Race(
                    id = document.id,
                    opponent = document.get("opponent").toString(),
                    time = document.getDouble("time")!!.toFloat(),
                    hour = document.getTimestamp("hour")!!,
                    distance =  document.get("distance").toString()
                )
                listener(race)
            }
    }

    fun update(id:String, race: Race){
        val database = Firebase.firestore
        val document = database.collection(collectionPath)
            .document(id)

        document.update("opponent",race.opponent)
        document.update("time",race.time)
        document.update("hour",race.hour)
        document.update("distance",race.distance)
    }

}