package com.moments.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moments.Fragments.ProfileFragment;
import com.moments.MainActivity;
import com.moments.Model.User;
import com.moments.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class UserAdapter {
    private Context mContext;
    private List<User> mUsers;
    //private boolean isFragment;

    private FirebaseUser firebaseUser;

    public UserAdapter(Context mContext, List<User> mUsers) { //, boolean isFargment
        this.mContext = mContext;
        this.mUsers = mUsers;
        //this.isFargment = isFargment;
    }
}
