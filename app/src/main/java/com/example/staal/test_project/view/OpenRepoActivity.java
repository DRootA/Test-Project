package com.example.staal.test_project.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.staal.test_project.Constants;
import com.example.staal.test_project.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpenRepoActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.name_open_repo)
    TextView name_open_repo;
    @BindView(R.id.tv_description)
    TextView tv_description;

    @OnClick(R.id.bt_commits)
    public void click() {
        Intent intent=new Intent(this,BaseActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("type", Constants.COMMIT_HOLDER_TYPE);
        startActivity(intent);
    }

    @OnClick(R.id.bt_contributors)
    public void contr_click() {
        Intent intent=new Intent(this,BaseActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("type", Constants.CONTRIBUTOR_HOLDER_TYPE);
        startActivity(intent);
    }

    String name;
    int idRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_repo);
        ButterKnife.bind(this);
        name=getIntent().getStringExtra("name");
        createlayout(name, getIntent().getStringExtra("description"));
        idRepo = getIntent().getIntExtra("id", -1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
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

    private void createlayout(String name, String description) {
        name_open_repo.setText(name);
        tv_description.setText(description);
    }

}
