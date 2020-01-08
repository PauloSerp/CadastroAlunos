package com.example.cadastrodealunos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cadastrodealunos.R
import com.example.cadastrodealunos.model.Aluno
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var aluno: Aluno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastrarAluno(view: View) {

        aluno = Aluno(
            nome_aluno_main.text.toString(),
            email_aluno_main.text.toString(),
            idade_aluno_main.text.toString().toInt()
        )

        aluno.validarComp(aluno, applicationContext)

    }

    fun listarAlunos(view: View) {

    }


}
