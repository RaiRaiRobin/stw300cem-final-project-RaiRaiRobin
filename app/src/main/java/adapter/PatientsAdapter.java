package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalandroidassignmentproject.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Patients;

public class PatientsAdapter {

//    Context mContext;
//    List<Patients> patientsList;
//    public PatientsAdapter(Context mContext, List<Patients> patientsList){
//        this.mContext = mContext;
//        this.patientsList = patientsList;
//    }
//
//    @NonNull
//    @Override
//    public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.patient,viewGroup,false);
//        return new PatientsViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PatientsViewHolder patientsViewHolder, int i) {
//        Patients patients = patientsList.get(i);
//        patientsViewHolder.imgProfile.setImageResource(patients.getImageId());
//        patientsViewHolder.tvName.setText(patients.getName());
//        patientsViewHolder.tvEmail.setText(patients.getEmail());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return patientsList.size();
//    }
//
//    public class PatientsViewHolder extends RecyclerView.ViewHolder{
//        CircleImageView imgProfile;
//        TextView tvName, tvEmail;
//
//        public PatientsViewHolder(@NonNull View itemView){
//            super(itemView);
//            imgProfile = itemView.findViewById(R.id.imgProfile);
//            tvName = itemView.findViewById(R.id.tvName);
//            tvEmail = itemView.findViewById(R.id.tvEmail);
//        }
//    }
}
