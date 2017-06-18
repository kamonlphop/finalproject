package comsci.kamonlphop.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public StudentTABLE objStudentTABLE;

    //public TeacherTABLE objTeacherTABLE;
    //public StatisticsTABLE objStatisticsTABLE;

    EditText usernameEditText,passwordEditText;
    String usernameString , passwordString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();
    }//endactivity
    //สมัคร
    public void clickregister(View view){
        Intent intent = new Intent(MainActivity.this,register.class);
        startActivity(intent);
    }//endสมัคร



    //login
    public void clicklogin(View view){


        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

        usernameString=usernameEditText.getText().toString().trim();
        passwordString=passwordEditText.getText().toString().trim();

        if(usernameString.equals("")||passwordString.equals("")){
            Toast.makeText(getApplicationContext(),"กรุณากรอกให้ครบ", Toast.LENGTH_SHORT).show();
        }else{/*
            Intent intent = new Intent(MainActivity.this,homeebook.class);
            Toast.makeText(getApplicationContext(),"ยินดีต้อนรับเข้าสู้ระบบ",Toast.LENGTH_SHORT).show();
            startActivity(intent);*/

            checkUserpassword(usernameString,passwordString);
        }


    }
    //endlogin
    private void  checkUserpassword(String usernameString,String passwordString){

        try{
            String[] strMyResult = objStudentTABLE.searchUserpassword(usernameString);
            if (passwordString.equals(strMyResult[3])){
                Intent intent = new Intent(MainActivity.this,MyEbook.class);
                startActivity(intent);
                //passwordtrue
                Toast.makeText(getApplicationContext(),"ยินตอนรับเข้าสู้ระบบ",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Pasword false",Toast.LENGTH_SHORT).show();
            }



        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"ไม่มี"+usernameString+"ในฐานข้อข้อมูลเรา",Toast.LENGTH_SHORT).show();
        }

    }//end checkUserpassword
    private void connect(){
       // objTeacherTABLE = new TeacherTABLE(this);
       // objStatisticsTABLE = new StatisticsTABLE(this);
        objStudentTABLE = new StudentTABLE(this);
    }

}//endclass

