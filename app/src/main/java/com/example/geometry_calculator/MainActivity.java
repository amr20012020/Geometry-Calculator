package com.example.geometry_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double area = 0;
    TextView tv_result;
    Spinner sp_shapes;
    EditText et_rectangle_width;
    EditText et_rectangle_height;
    EditText et_circle_radius;
    EditText et_triangle_base;
    EditText et_triangle_height;

    //call back
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_LONG).show();

         sp_shapes = findViewById(R.id.areas_sp_shapes);
         et_rectangle_width = findViewById(R.id.areas_ed_rectangle_width);
         et_rectangle_height = findViewById(R.id.areas_ed_rectangle_height);
         et_circle_radius = findViewById(R.id.areas_et_circle_radius);
         et_triangle_base = findViewById(R.id.areas_ed_triangle_base);
         et_triangle_height= findViewById(R.id.areas_ed_triangle_height);
        tv_result= findViewById(R.id.tv_result);
        Button btn_Calc= findViewById(R.id.btn_Calc);

        //Circle -> pi * r * r  Perimeter of Circle -> 2 * pi * r
        //Rectangle -> w * h  Perimeter rectangle -> 2(h + w)
        //Triangle -> 0.5 * base * h
        //parallelogram -> base * h
        //Ball -> 4 * pi * r * r     The size of Ball -> 3/4 * pi * r * r * r
        //The cylinder -> 2 * pi * r * h


        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 1:
                        //Rectangle
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 2:
                        //Circle
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 3:
                        //Triangle
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        break;

                    case 4:
                        //Ball
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;

                    case 5:
                        //The cylinder
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;

                    case 6:
                        //parallelogram
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        break;

                    case 7:
                        //Perimeter of Circle
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;


                    case 8:
                        //Perimeter of Rectangle
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;

                    case 9:
                        //Size of Ball
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int index = sp_shapes.getSelectedItemPosition();
               switch (index){
                   case 1:
                       //Rectangle
                       double rect_width = Double.parseDouble(et_rectangle_width.getText().toString());
                       double rect_height = Double.parseDouble(et_rectangle_height.getText().toString());
                       area = rect_width * rect_height;
                       break;
                   case 2:
                       //circle
                       double cir_radius = Double.parseDouble(et_circle_radius.getText().toString());
                       area = Math.PI * Math.pow(cir_radius,2);
                       break;
                   case 3:
                       //Triangle
                       double triangle_base = Double.parseDouble(et_triangle_base.getText().toString());
                       double triangle_hieght= Double.parseDouble(et_triangle_height.getText().toString());
                       area = 0.5 * triangle_base * triangle_hieght;
                       break;
                   case 4:
                       //Ball
                       double ball_radius = Double.parseDouble(et_circle_radius.getText().toString());
                       area = 4 * Math.PI * Math.pow(ball_radius,2);
                       break;
                   case 5:
                       //The cylinder
                       double cylinder_raduis = Double.parseDouble(et_circle_radius.getText().toString());
                       double cylinder_height = Double.parseDouble(et_rectangle_height.getText().toString());
                       area = 2 * Math.PI * Math.pow(cylinder_raduis,1) * cylinder_height;
                       break;
                   case 6:
                       //The parallelogrm
                       double parallelorgm_base = Double.parseDouble(et_triangle_base.getText().toString());
                       double pallarelorgm_height = Double.parseDouble(et_rectangle_height.getText().toString());
                       area = parallelorgm_base * pallarelorgm_height;
                       break;
                   case 7:
                       //Perimeter of Circle
                       double prcir_radius = Double.parseDouble(et_circle_radius.getText().toString());
                       area =2 * Math.PI * Math.pow(prcir_radius,1);
                       break;
                   case 8:
                       //Perimeter of Rectangle
                       double prrec_width = Double.parseDouble(et_rectangle_width.getText().toString());
                       double prrec_height = Double.parseDouble(et_rectangle_height.getText().toString());
                       area =2 * (prrec_height * prrec_width);
                       break;
                   case 9:
                      //Size of Ball
                       double prball_radius = Double.parseDouble(et_circle_radius.getText().toString());
                       area = Math.PI * Math.pow(prball_radius,3);
                       break;

               }

               tv_result.setText(area +"");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(), "Area is:" + area, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState( Bundle outState,  PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("result",tv_result.getText().toString());
        Toast.makeText(this, "on save instance state", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String r = savedInstanceState.getString("result");
        tv_result.setText(r);
        Toast.makeText(this, "on restore instance state", Toast.LENGTH_SHORT).show();
    }
}
