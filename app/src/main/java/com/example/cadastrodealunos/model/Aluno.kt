package com.example.cadastrodealunos.model

import android.content.Context
import android.widget.Toast

data class Aluno(
    val nome: String,
    val email: String,
    val idade: Int = 0){

    fun validarComp(aluno: Aluno, context: Context): Boolean{

        if (aluno.nome.isEmpty()||aluno.email.isEmpty()||aluno.idade == 0){
            Toast.makeText(context, "Erro ao inserir Aluno", Toast.LENGTH_SHORT).show()
            return false
        }else{
            val helperSQLite = HelperSQLite(context)
            helperSQLite.insert(aluno)
            return true
        }
    }
}