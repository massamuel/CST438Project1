package edu.csumb.spoplack.project1samryanjamesjose.Adpaters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    ArrayList<Course> courses;

    Context context;

    public CoursesAdapter(ArrayList<Course> movies) {
        this.courses = movies;
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
        holder.tvCourseGrade.setText("90.5");

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvCourseTitle;
        TextView tvCourseInstructor;
        TextView tvCourseGrade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCourseTitle = itemView.findViewById(R.id.textViewClassTitle);
            tvCourseInstructor = itemView.findViewById(R.id.textViewClassInstructor);
            tvCourseGrade = itemView.findViewById(R.id.textViewCourseGrade);

        }

        @Override
        public void onClick(View v) {
//            int position = getAdapterPosition();
//            // make sure the position is valid, i.e. actually exists in the view
//            if (position != RecyclerView.NO_POSITION) {
//                Course course = courses.get(position);\
//                Intent intent = new Intent(context, ); // TODO: connect to class view
//
//                intent.putExtra(Course.class.getSimpleName(), course);
//                // show the activity
//                context.startActivity(intent);
//            }
        }
    }
}
