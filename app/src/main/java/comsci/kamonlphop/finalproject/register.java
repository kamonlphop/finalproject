package comsci.kamonlphop.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    private StudentTABLE objStudentTABLE;
    private TeacherTABLE objTeacherTABLE;
    private AdminTABLE objAdminTABLE;
    private LessonTABLE objLessonTABLE;

    EditText nameEditText,lastnameEditText,passwordEditText;
    String nameString,lastnameString,passwordString,strid_student,strname,strpasswordstudent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connect();
    }

    public void clickbackmain(View view) {
        finish();
    }


    public void onClicklo (View view) {




        nameEditText = (EditText) findViewById(R.id.editusername);
        lastnameEditText = (EditText) findViewById(R.id.editlastname);
        passwordEditText = (EditText) findViewById(R.id.editpassword);

        nameString = nameEditText.getText().toString();
        lastnameString = lastnameEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (nameString.length()==0||lastnameString.length()==0||passwordString.length()==0){
            Toast.makeText(getApplicationContext(),"!!!!!กรุณากรอกข้อมูลให้ครบ!!!!!",Toast.LENGTH_SHORT).show();

        }else {
            //Intent intent = new Intent(register.this, MainActivity.class);
            //Toast.makeText(getApplication(),"!!!บันทึกข้อมูลเรียบร้อยเเล้ว!!!",Toast.LENGTH_SHORT).show();

            addStudent(strid_student,strname,strpasswordstudent);


            //startActivity(intent);
        }

    }
    public void addStudent(final String strid_student ,final String strname ,final String strpasswordstudent ){



            try{
                StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(myPolicy);

                ArrayList<NameValuePair> objNameValuePairs = new ArrayList<NameValuePair>();
                objNameValuePairs.add(new BasicNameValuePair("isAdd","true"));
                objNameValuePairs.add(new BasicNameValuePair("id_student",strid_student));
                objNameValuePairs.add(new BasicNameValuePair("name_student",strname));
                objNameValuePairs.add(new BasicNameValuePair("lastname_student",""));
                objNameValuePairs.add(new BasicNameValuePair("password_student",strpasswordstudent));
                objNameValuePairs.add(new BasicNameValuePair("email_student",""));

                HttpClient objHttpClient = new DefaultHttpClient();
                HttpPost objHttpPost = new HttpPost("http://5711020660038.sci.dusit.ac.th/addregisterjson.php");//ใส่json ดด้วนะ
                objHttpPost.setEntity(new UrlEncodedFormEntity(objNameValuePairs,"UTF-8"));
                objHttpClient.execute(objHttpPost);
            }catch(Exception e){
                Toast.makeText(register.this,"สมัครไม่ได้",Toast.LENGTH_SHORT).show();


        }
        Intent intent = new Intent(register.this,MainActivity.class);
        startActivity(intent);

    }
    public void connect(){
        objStudentTABLE = new StudentTABLE(this);
    }

}
