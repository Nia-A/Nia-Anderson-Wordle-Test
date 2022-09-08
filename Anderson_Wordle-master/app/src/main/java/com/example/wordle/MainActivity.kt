// Nia Anderson Lab 1- Wordle
package com.example.wordle
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

var currentRow by Delegates.notNull<Int>()

lateinit var list1: List<TextInputLayout>
lateinit var list2: List<TextInputLayout>
lateinit var list3: List<TextInputLayout>
lateinit var list4: List<TextInputLayout>
lateinit var list5: List<TextInputLayout>
lateinit var list6: List<TextInputLayout>

lateinit var word_selection: String       //word being selected

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRandomFourLetterWord()

        list1 = listOf(letterBox01, letterBox02, letterBox03, letterBox04, letterBox05)
        list2 = listOf(letterBox06, letterBox07, letterBox08, letterBox09, letterBox10)
        list3 = listOf(letterBox11, letterBox12, letterBox13, letterBox14, letterBox15)
        list4 = listOf(letterBox16, letterBox17, letterBox18, letterBox19, letterBox20)
        list5 = listOf(letterBox21, letterBox22, letterBox23, letterBox24, letterBox25)
        list6 = listOf(letterBox26, letterBox27, letterBox28, letterBox29, letterBox30)

        //Set the row's current variable to 1
        currentRow = 1


        //Function that ensures user is on the right row
        rowInputController()

        //List 1
        for (index in list1.indices) {
            list1[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list1[index].editText?.text?.length == 1) {
                    if (list1[index] == list1.last()) {
                        list1[index].requestFocus()
                    } else {
                        list1[index + 1].requestFocus()
                    }
                }

                if (list1[index].editText?.text?.length == 0) {
                    if (list1[index] == list1.first()) {
                        list1[index].requestFocus()
                    } else {
                        list1[index - 1].requestFocus()
                    }
                }
            }
        }

        // list 2
        for (index in list2.indices) {
            list2[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list2[index].editText?.text?.length == 1) {
                    if (list2[index] == list2.last()) {
                        list2[index].requestFocus()
                    } else {
                        list2[index + 1].requestFocus()
                    }
                }
                if (list2[index].editText?.text?.length == 0) {
                    if (list2[index] == list2.first()) {
                        list2[index].requestFocus()
                    } else {
                        list2[index - 1].requestFocus()
                    }
                }
            }
        }

        // list 3
        for (index in list3.indices) {
            list3[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list3[index].editText?.text?.length == 1) {
                    if (list3[index] == list3.last()) {
                        list3[index].requestFocus()
                    } else {
                        list3[index + 1].requestFocus()
                    }
                }
                if (list3[index].editText?.text?.length == 0) {
                    if (list3[index] == list3.first()) {
                        list3[index].requestFocus()
                    } else {
                        list3[index - 1].requestFocus()
                    }
                }
            }
        }

        //list 4
        for (index in list5.indices) {
            list5[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list5[index].editText?.text?.length == 1) {
                    if (list5[index] == list5.last()) {
                        list5[index].requestFocus()
                    } else {
                        list5[index + 1].requestFocus()
                    }
                }
                if (list5[index].editText?.text?.length == 0) {
                    if (list5[index] == list5.first()) {
                        list5[index].requestFocus()
                    } else {
                        list5[index - 1].requestFocus()
                    }
                }
            }
        }

        //list 5
        for (index in list6.indices) {
            list6[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list6[index].editText?.text?.length == 1) {
                    if (list6[index] == list6.last()) {
                        list6[index].requestFocus()
                    } else {
                        list6[index + 1].requestFocus()
                    }
                }
                if (list6[index].editText?.text?.length == 0) {
                    if (list6[index] == list6.first()) {
                        list6[index].requestFocus()
                    } else {
                        list6[index - 1].requestFocus()
                    }
                }
            }
        }

        //list 6
        for (index in list4.indices) {
            list4[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list4[index].editText?.text?.length == 1) {
                    if (list4[index] == list4.last()) {
                        list4[index].requestFocus()
                    } else {
                        list4[index + 1].requestFocus()
                    }
                }
                if (list4[index].editText?.text?.length == 0) {
                    if (list4[index] == list4.first()) {
                        list4[index].requestFocus()
                    } else {
                        list4[index - 1].requestFocus()
                    }
                }
            }
        }
        rowInputController()
    }


    fun Test(view: View){
        var rows = listOf(list1, list2, list3, list4, list5, list6)

        var currentList = rows[currentRow-1]
        var currentWord = ""
        var index = 0

        for (element in currentList){
            currentWord += element.editText?.text
        }


        for (element in currentList){       //right letter, wrong spot
            if (word_selection.contains(element.editText?.text.toString())){
                Toast.makeText(applicationContext, "You have the right letter in the wrong place!", Toast.LENGTH_SHORT).show()
            }
        }

        for (element in currentList){       // right letter right spot
            if (word_selection[index].toString() == element.editText?.text.toString()){
                element.setBackgroundColor(Color.parseColor("#3300FF00"))
            }
            index += 1
        }

        nextRow()
    }

    fun nextRow(){ // Move app along to next row
        currentRow += 1
        rowInputController()



        if (currentRow == 7){
            Toast.makeText(applicationContext, "You Have Exceeded your number of guesses", Toast.LENGTH_SHORT).show()
            gameOverText.text = "Word: "+word_selection.toString()
            gameOverText.isVisible = true

        }

    }



    fun rowInputController(){
        if (currentRow == 1){
            for (element in list1){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 2){
            for (element in list2){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 3){
            for (element in list3){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 4){
            for (element in list4){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 5){
            for (element in list5){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 6){
            for (element in list6){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
    }

    fun getRandomFourLetterWord(){
        val words = listOf("cigar","rebut","sissy","humph","awake","blush","focal","evade","naval","serve","heath","dwarf","model","karma","stink","grade","quiet","bench","abate","feign","major","death","fresh","crust","stool","colon","abase","marry","react","batty","pride","floss","helix","croak","staff","paper","unfed","whelp","trawl","outdo","adobe","crazy","sower","repay","digit","crate","cluck","spike","mimic","pound","maxim","linen","unmet","flesh","booby","forth","first","stand","belly","ivory","seedy","print","yearn","drain","bribe","stout","panel","crass","flume","offal","agree","error","swirl","argue","bleed","delta","flick","totem","wooer","front","shrub","parry","biome","lapel","start","greet","goner","golem","lusty","loopy","round","audit","lying","gamma","labor","islet","civic","forge","corny","moult","basic","salad","agate","spicy","spray","essay","fjord","spend","kebab","guild","aback","motor","alone","hatch","hyper","thumb","dowry","ought","belch","dutch","pilot","tweed","comet","jaunt","enema","steed","abyss","growl","fling","dozen","boozy","erode","world","gouge","click","briar","great","altar","pulpy","blurt","coast","duchy","groin","fixer","group","rogue","badly","smart","pithy","gaudy","chill","heron","vodka","finer","surer","radio","rouge","perch","retch","wrote","clock","tilde","store","prove","bring","solve","cheat","grime","exult","usher","epoch","triad","break","rhino","viral","conic","masse","sonic","vital","trace","using","peach","champ","baton","brake","pluck","craze","gripe","weary","picky","acute","ferry","aside","tapir","troll","unify","rebus","boost","truss","siege","tiger","banal","slump","crank","gorge","query","drink","favor","abbey","tangy","panic","solar","shire","proxy","point","robot","prick","wince","crimp","knoll","sugar")
        word_selection = words.random()
    }



}
