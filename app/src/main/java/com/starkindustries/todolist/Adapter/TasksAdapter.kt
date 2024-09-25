package com.starkindustries.todolist.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.starkindustries.todolist.Data.Task
import com.starkindustries.todolist.R
class TasksAdapter(var context_: Context,var taskList_:ArrayList<Task>):RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    lateinit var context: Context
    lateinit var taskList:ArrayList<Task>
    init{
        this.context=context_
        this.taskList=taskList_
    }
    open inner class TaskViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        lateinit var title:AppCompatTextView
        lateinit var task:AppCompatTextView
        init{
            title=itemView.findViewById(R.id.task_title)
            task=itemView.findViewById(R.id.task_task)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.task_custom_row, parent, false)
        var viewHolder = TaskViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.title.text=taskList.get(position).title
        holder.task.text=taskList.get(position).task
    }
}