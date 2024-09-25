package com.starkindustries.todolist.UI
import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.starkindustries.todolist.Adapter.TasksAdapter
import com.starkindustries.todolist.Data.Task
import com.starkindustries.todolist.R
import com.starkindustries.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var taskList:ArrayList<Task>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.addtask.setOnClickListener(){
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.add_task_dialog)
            dialog.show()
        }
        taskList=ArrayList<Task>()
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("gym","go to GYM"))
        taskList.add(Task("Dsa","Do Dsa"))
        taskList.add(Task("Code","do Coding"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        taskList.add(Task("Meet","Attend Meet"))
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.adapter= TasksAdapter(this,taskList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}