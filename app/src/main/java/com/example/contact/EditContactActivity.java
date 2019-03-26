package com.example.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContactActivity extends AppCompatActivity {

    private EditText mEdtFullname , mEdtCompany , mEdtTitle , mEdtMobile , mEdtEmail;
    private TextView mTvCreatedAt;
    private ImageView mIvAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        mEdtFullname = (EditText)findViewById(R.id.edt_fullname);
        mEdtCompany = (EditText)findViewById(R.id.edt_company);
        mEdtTitle = (EditText)findViewById(R.id.edt_Title);
        mEdtMobile = (EditText)findViewById(R.id.edt_mobile);
        mEdtEmail = (EditText)findViewById(R.id.edt_email);

        mTvCreatedAt = (TextView)findViewById(R.id.tv_created_id);
        mIvAvatar = (ImageView)findViewById(R.id.iv_avatar);

        Intent intentData = getIntent();
        Bundle packBundle = intentData.getBundleExtra("My package");
        Contact getContact = (Contact)packBundle.getSerializable("Contact");

        mEdtFullname.setText(getContact.getFullname());
        mEdtCompany.setText(getContact.getCompany());
        mEdtTitle.setText(getContact.getTitle());
        mEdtMobile.setText(getContact.getMobile());
        mEdtEmail.setText(getContact.getEmail());
//        mTvCreatedAt.setText(getContact.getCreatedAt().toString());
    }
}
