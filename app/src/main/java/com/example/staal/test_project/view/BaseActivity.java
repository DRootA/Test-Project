package com.example.staal.test_project.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.staal.test_project.Constants;
import com.example.staal.test_project.DTO.Commits;
import com.example.staal.test_project.DTO.Contributor;
import com.example.staal.test_project.DTO.Repository;
import com.example.staal.test_project.R;
import com.example.staal.test_project.presenter.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity implements ISetupRecycler {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.base_recycler)
    RecyclerView recyclerView;


    BasePresenter basePresenter;
    BaseRecyclerAdapter baseRecyclerAdapter;
    String title;
    String type;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getTypeAndSetupAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    // получаем тип активити и передаем в адаптер дженерик нужный для этого класса
    private void getTypeAndSetupAdapter() {
        if (getIntent().getStringExtra("type") != null) {
            type = getIntent().getStringExtra("type");
            name = getIntent().getStringExtra("name");
            if (type.equals(Constants.COMMIT_HOLDER_TYPE)) {
                title = "Commit";
                setup(Commits.class);
            } else if (type.equals(Constants.CONTRIBUTOR_HOLDER_TYPE)) {
                title = "Contributor";
                setup(Contributor.class);
            }
        } else {
            type = Constants.REPOSITORY_HOLDER_TYPE;
            title = "Repository";
            setup(Repository.class);
        }
        getSupportActionBar().setTitle(title);
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setup(Class object) {
        basePresenter = new BasePresenter(this, type);

        if (object.getSimpleName().equals(Commits.class.getSimpleName())) {
            baseRecyclerAdapter = new BaseRecyclerAdapter<Commits>(type);
            recyclerView.setAdapter(baseRecyclerAdapter);
            setupActionBar();
            basePresenter.startLoading(name);
        } else if (object.getSimpleName().equals(Repository.class.getSimpleName())) {
            baseRecyclerAdapter = new BaseRecyclerAdapter<Repository>(type);
            recyclerView.setAdapter(baseRecyclerAdapter);
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            basePresenter.startLoading();
        } else {
            baseRecyclerAdapter = new BaseRecyclerAdapter<Contributor>(type);
            recyclerView.setAdapter(baseRecyclerAdapter);
            setupActionBar();
            basePresenter.startLoading(name);
        }
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Произошла ошибка загрузки", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupRecycler(List list) {
        baseRecyclerAdapter.setupRecycle(list);
    }
}
