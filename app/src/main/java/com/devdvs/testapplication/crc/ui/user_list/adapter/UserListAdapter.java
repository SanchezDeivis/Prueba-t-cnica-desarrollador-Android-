package com.devdvs.testapplication.crc.ui.user_list.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.devdvs.testapplication.R;
import com.devdvs.testapplication.crc.data.network.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolderCP>
        implements Filterable {

    private List<User> userList;
    private Context ctx;
    private List<User> mDataFiltered;
    private CustomFilter mFilter;

    public UserListAdapter(List<User> userList, Context ctx) {
        this.userList = userList;
        this.ctx = ctx;
        this.mDataFiltered = new ArrayList<>();
        this.mDataFiltered.addAll(userList);
        this.mFilter = new CustomFilter(UserListAdapter.this);
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public List<User> getmDataFiltered() {
        return mDataFiltered;
    }

    @NonNull
    @Override
    public MyViewHolderCP onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_list, parent, false);
        return new MyViewHolderCP(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCP holder, int position) {
        //Obtenemos el obj PatientRecord para asignar valores a las views
        User record = mDataFiltered.get(position);
        holder.fullname.setText(record.getName());
        holder.userName.setText(record.getUsername());
        holder.email.setText(record.getEmail());
        holder.phone.setText(record.getPhone());
        holder.website.setText(record.getWebsite());

    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    public class MyViewHolderCP extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.rly_users)
        CardView rly_users;
        @BindView(R.id.fullname)
        TextView fullname;
        @BindView(R.id.username)
        TextView userName;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.phone)
        TextView phone;
        @BindView(R.id.website)
        TextView website;
        View view;

        public MyViewHolderCP(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }

        @Override
        public void onClick(View view) {
        }
    }

    /* Filtro */
    public class CustomFilter extends Filter {
        private UserListAdapter listAdapter;

        private CustomFilter(UserListAdapter listAdapter) {
            super();
            this.listAdapter = listAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            mDataFiltered.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                mDataFiltered.addAll(userList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();
                for (final User user : userList) {
                    if (user.getName().toLowerCase().contains(filterPattern)) {
                        mDataFiltered.add(user);
                    }
                }
            }

            results.values = mDataFiltered;
            results.count = mDataFiltered.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            this.listAdapter.notifyDataSetChanged();
        }
    }
}
