package com.example.cadastrodealunos.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATA_BASE_NAME = "Escola"
val TABLE_NAME = "Aluno"
val COL_NOME = "nome"
val COL_EMAIL = "email"
val COL_IDADE = "idade"
val COL_ID = "id"

open class HelperSQLite(val context: Context) : SQLiteOpenHelper(context, DATA_BASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTabel = " CREATE TABLE " + TABLE_NAME + " ("+
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOME+ " VARCHAR(256)," +
                COL_EMAIL+ " VARCHAR(30)," +
                COL_IDADE+ " INTEGER)"

        db?.execSQL(createTabel)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insert(aluno: Aluno){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NOME, aluno.nome)
        contentValues.put(COL_EMAIL, aluno.email)
        contentValues.put(COL_IDADE, aluno.idade)

        var result = db.insert(TABLE_NAME, null, contentValues)
        if(result == -1.toLong()){
            Toast.makeText(context, "Erro ao inserir", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Aluno inserido", Toast.LENGTH_SHORT).show()
        }
    }

    //fun getList():ArrayList<Aluno>{

      //  return
    //}

}