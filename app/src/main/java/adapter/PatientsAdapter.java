package adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalandroidassignmentproject.Api_Connection;
import com.example.finalandroidassignmentproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Patients;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.PatientsViewHolder>{
    Context mContext;
    List<Patients> patientsList;
    public PatientsAdapter(Context mContext, List<Patients> patientsList){
        this.mContext = mContext;
        this.patientsList = patientsList;
    }

    @NonNull
    @Override
    public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.patient,viewGroup,false);
        return new PatientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsViewHolder patientsViewHolder, int i) {

        final String id=patientsList.get(i).getId();
        final String name=patientsList.get(i).getFirst_name();
        final String email=patientsList.get(i).getEmail();
        final String photo=patientsList.get(i).getPhoto();





      patientsViewHolder.id.setText("ID :"+patientsList.get(i).getId());
      patientsViewHolder.email.setText("Email :"+patientsList.get(i).getEmail());
      patientsViewHolder.name.setText("Name :"+patientsList.get(i).getFirst_name());


        final String image_url= Api_Connection.API_URL+"images/profile/"+patientsList.get(i).getPhoto();
        System.out.println(patientsList.get(i).getPhoto());
        strictMode();


        try {
            URL url=new URL(image_url);
            patientsViewHolder.img.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    private void strictMode(){
        StrictMode.ThreadPolicy strict=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(strict);
    }

    @Override
    public int getItemCount() {
        return patientsList.size();
    }

    public static class PatientsViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView img;
        private TextView name, id,email;

        public PatientsViewHolder(@NonNull View  v){
            super(v);
            id=v.findViewById(R.id.tvId);
            name=v.findViewById(R.id.tvName);
            email=v.findViewById(R.id.tvEmail);
            img=v.findViewById(R.id.imgProfile);





        }
    }
}
