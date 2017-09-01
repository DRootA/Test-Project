package com.example.staal.test_project.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.staal.test_project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpenCardActivity extends AppCompatActivity {

    @BindView(R.id.iv_open_card_foto)
    ImageView foto;
    @BindView(R.id.tv_name_open_card)
    TextView tv_name;
    @BindView(R.id.tv_message_open_card)
    TextView tv_message;

    @BindView(R.id.toolbar_open_card)
    Toolbar toolbar;
    int type;
    String name;
    String message;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_card);
        type = getIntent().getIntExtra("type", -1);
        name=getIntent().getStringExtra("name");
        message=getIntent().getStringExtra("message");
        url=getIntent().getStringExtra("url");
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupLayout();
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

    public void setupLayout(){
        tv_name.setText(name);
        tv_message.setText(message);
        foto.setVisibility(View.GONE);
        if(type==2){
            foto.setVisibility(View.VISIBLE);
            Glide.with(this)
                    .load(url)
                    .into(foto);
        }
    }
}
