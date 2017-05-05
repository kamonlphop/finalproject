package comsci.kamonlphop.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText nameEditText,lastnameEditText,passwordEditText;
    String nameString,lastnameString,passwordString;

    public StudentTABLE objStudentTABLE;

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
            Intent intent = new Intent(register.this, MainActivity.class);
            Toast.makeText(getApplication(),"!!!บันทึกข้อมูลเรียบร้อยเเล้ว!!!",Toast.LENGTH_SHORT).show();

            addStudent();


            startActivity(intent);
        }

    }
    public void addStudent(){
        objStudentTABLE.addNewstudent(nameString,lastnameString,passwordString,"");
    }
    public void connect(){
        objStudentTABLE = new StudentTABLE(this);
    }

}
