package com.devdvs.testapplication.src.ui.user_list;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devdvs.testapplication.R;
import com.devdvs.testapplication.src.data.network.model.user.User;
import com.devdvs.testapplication.src.ui.user_list.adapter.UserListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class UserListActivity extends ComponentActivity implements UserListMVP.View{
    @BindView(R.id.rv_user_list)
    RecyclerView rv;
    private UserListAdapter adapter;
    private UserListPresenter presenter;
    private List<User> userArrayList = new ArrayList<>();
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        this.context=this;
        presenter = new UserListPresenter(this, context);
        ButterKnife.bind(this);
        if (presenter != null)
            presenter.getUserList();
        loadaView();
    }

    private void loadaView() {
        adapter = new UserListAdapter(userArrayList,context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        /*rv.addItemDecoration(new DividerItemDecoration(rv.getContext(),
                DividerItemDecoration.VERTICAL));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_,menu);
        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar por nombre de usuario");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s.toString());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void successfulGettingUserList(List<User> userList) {
        if (userList.isEmpty()) {
            Toast.makeText(context, "No hay Información", Toast.LENGTH_SHORT).show();

        } else {
            this.userArrayList.clear();
            this.userArrayList.addAll(userList);
            adapter.notifyDataSetChanged();
            adapter.getFilter().filter("");
        }
    }

    @Override
    public void errorGettingUserList(String error) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
    }
}
