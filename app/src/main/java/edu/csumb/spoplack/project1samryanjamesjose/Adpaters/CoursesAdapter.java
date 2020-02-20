package edu.csumb.spoplack.project1samryanjamesjose.Adpaters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Activities.AssignmentActivity;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    ArrayList<Course> courses;
    int userId;

    Context context;

    public CoursesAdapter(ArrayList<Course> courses, int userId) {
        this.courses = courses;
        this.userId = userId;
    }

    @NonNull
    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View courseView = inflater.inflate(R.layout.item_class, parent, false);
        return new ViewHolder(courseView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ViewHolder holder, int position) {

        Course course = courses.get(position);
        holder.tvCourseTitle.setText(course.getTitle());
        holder.tvCourseInstructor.setText(course.getInstructor());
        holder.tvCourseDesc.setText(course.getDescription());
        holder.tvCourseGrade.setText(Double.toString(Math.round(course.getCourseGrade() * 100.0) / 100.0));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = courses.get(position);
                Intent intent = new Intent(context, AssignmentActivity.class);

                intent.putExtra("userId", userId);
                intent.putExtra("courseId", course.getCourseId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCourseTitle;
        TextView tvCourseInstructor;
        TextView tvCourseDesc;
        TextView tvCourseGrade;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCourseTitle = itemView.findViewById(R.id.textViewClassTitle);
            tvCourseInstructor = itemView.findViewById(R.id.textViewClassInstructor);
            tvCourseDesc = itemView.findViewById(R.id.textViewCourseDesc);
            tvCourseGrade = itemView.findViewById(R.id.textViewCourseGrade);
            constraintLayout = itemView.findViewById(R.id.classItemLayout);

        }

    }
}
