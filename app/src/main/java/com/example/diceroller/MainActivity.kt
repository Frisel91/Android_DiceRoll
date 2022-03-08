package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }


    /**
     * Устанавливаю количество сторон и вывожу результат случайного броска в TextView
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        // присваивание переменной результата случайного броска и ресурса картинки
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource) // вывод изображения на экран
        diceImage.contentDescription = diceRoll.toString()
        }


    }

    /**
     * Создаю клас кубика с диапазоном сторон от 1 до заданного размера
     */
    class Dice(val numSize: Int) {

        fun roll(): Int {
            return (1..numSize).random()
        }
    }

