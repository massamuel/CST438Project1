package edu.csumb.spoplack.project1samryanjamesjose.Adpaters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {

    ArrayList<Assignment> assignments;

    Context context;

    public AssignmentAdapter(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public AssignmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View assignmentView = inflater.inflate(R.layout.item_assignment, parent, false);
        return new ViewHolder(assignmentView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AssignmentAdapter.ViewHolder holder, int position) {

        Assignment assignment = assignments.get(position);
        holder.tvAssignmentId.setText(assignment.getAssignmentName());
        DecimalFormat df = new DecimalFormat("0.00");
        holder.tvScore.setText(df.format((assignment.getEarnedScore() / assignment.getMaxScore()) * 100));

    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAssignmentId;
        TextView tvScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAssignmentId = itemView.findViewById(R.id.textViewAssignmentId);
            tvScore = itemView.findViewById(R.id.textViewScore);

        }
    }

}
