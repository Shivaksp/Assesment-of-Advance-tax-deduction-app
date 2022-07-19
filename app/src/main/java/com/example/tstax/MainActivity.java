package com.example.tstax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String name_c,desing_c,place_c,mandal_c,district_c,pan_c,mobile_c,ddoname_c,ddodesign_c,ddooffice_c,ddodis_c,ddotan_c;
    String fpi_c ,sp_pay_c ,hm_c ,tsincrement_c ,fta_c , tution_c;
    String pay1,pay2,pay3,pay4;
    String da1,da2,da3,da4;
    String hra1,hra2,hra3,hra4;
    String cca1,cca2,cca3,cca4;
    String cps1,cps2,cps3,cps4;
    String pf,pf_no,tsgli,tsgli_no,gis,gis_no;
    String tut_fee,fiveyears,national,pli,lic,investment,public_c,others,others_no;
    String rent,medical_self,medical_senior,check,loan;
    String mar,apr,may,june,july,aug,sep,oct,nov,dec,jan,feb;
    String sl_m;
    int fpi_n ,sp_pay_n ,hm_n ,tsincrement_n ,fta_n , tution_n;
    int pay1_n,pay2_n,pay3_n,pay4_n;
    int da1_n,da2_n,da3_n,da4_n;
    int hra1_n,hra2_n,hra3_n,hra4_n;
    int  cca1_n,cca2_n,cca3_n,cca4_n;
    int  cps1_n,cps2_n,cps3_n,cps4_n;
    int  pf_n,pf_no_n,tsgli_n,tsgli_no_n,gis_n,gis_no_n;
    int  tut_fee_n,fiveyears_n,national_n,pli_n,lic_n,investment_n,public_c_n,others_no_n;
    int  rent_n,medical_self_n,medical_senior_n,check_n,loan_n;
    int mar_n,apr_n,may_n,june_n,july_n,aug_n,sep_n,oct_n,nov_n,dec_n,jan_n,feb_n;
    int sl_leave;

    EditText et_name_c,et_desing_c,et_place_c,et_mandal_c,et_district_c,et_pan_c,et_mobile_c,et_ddoname_c,et_ddodesign_c,et_ddooffice_c,et_ddodis_c,et_ddotan_c;
    EditText et_fpi_c ,et_sp_pay_c ,et_hm_c ,et_tsincrement_c ,et_fta_c ,et_hra_change_c , et_tution_c;
    EditText et_pay1,et_pay2,et_pay3,et_pay4;
    EditText et_da1,et_da2,et_da3,et_da4;
    EditText et_hra1,et_hra2,et_hra3,et_hra4;
    EditText et_cca1,et_cca2,et_cca3,et_cca4;
    EditText et_cps1,et_cps2,et_cps3,et_cps4;
    EditText et_pf,et_pf_no,et_tsgli,et_tsgli_no,et_gis,et_gis_no;
    EditText et_tut_fee,et_fiveyears,et_national,et_pli,et_lic,et_investment,et_public_c,et_others,et_others_no;
    EditText et_rent,et_medical_self,et_medical_senior,et_check,et_loan;
    EditText et_mar,et_apr,et_may,et_june,et_july,et_aug,et_sep,et_oct,et_nov,et_dec,et_jan,et_feb;
    Button btn,btn2;
    int[][] gross = new int[12][11];
    int[][] deduct = new int[12][7];
    int[] gross_total = new int[12];
    int[] deduct_total = new int[12];
    int[] sum_gross = new int[11];
    int[] sum_deduct = new int[7];
    int arr_1 ,arr_2,arr_3,arr_4;
    int grand_gross,grand_deduct;
    String[][] gross_s = new String[12][11];


    String basicpay_c,basicpay2_c,basicpay3_c;
    int basic_n1,basic_n2,basic_n3;
    int phc_c,in_month_c,aas_c,promotion_c,hra_c,hra_dt_change,hra_per_change_c,els_c,els_dt_c,cps_c,da_arrears_c, pf_dt_c,tsgli_dt_c,gis_dt_c,living_c,disable_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this , new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);


        Spinner basicpay_spinner = findViewById(R.id.et_basic_pay);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Basic_pay,
                R.layout.color_spinner_layout
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        basicpay_spinner.setAdapter(adapter);
        basicpay_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                basicpay_c = adapter.getItem(i).toString();
                basic_n1 = Integer.parseInt(basicpay_c);
                basicpay2_c = adapter.getItem(i + 1).toString();
                basic_n2 = Integer.parseInt(basicpay2_c);
                basicpay3_c = adapter.getItem(i + 2).toString();
                basic_n3 = Integer.parseInt(basicpay3_c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                basicpay_c = adapter.getItem(0).toString();
                basic_n1 = Integer.parseInt(basicpay_c);
                basicpay2_c = adapter.getItem(1).toString();
                basic_n2 = Integer.parseInt(basicpay2_c);
                basicpay3_c = adapter.getItem(2).toString();
                basic_n3 = Integer.parseInt(basicpay3_c);
            }
        });
        Spinner phc_spinner = findViewById(R.id.et_phc);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.phc,
                R.layout.color_spinner_layout
        );
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown);
        phc_spinner.setAdapter(adapter1);
        phc_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                phc_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                phc_c = 0;
            }
        });
        Spinner in_month_spinner = findViewById(R.id.et_in_month);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.in_month,
                R.layout.color_spinner_layout
        );
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown);
        in_month_spinner.setAdapter(adapter2);
        in_month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                in_month_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                in_month_c = 0;
            }
        });
        Spinner aas_spinner = findViewById(R.id.et_aas);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.aas,
                R.layout.color_spinner_layout
        );
        adapter3.setDropDownViewResource(R.layout.spinner_dropdown);
        aas_spinner.setAdapter(adapter3);
        aas_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                aas_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                aas_c = 0;
            }
        });
        Spinner promotion_spinner = findViewById(R.id.et_promotion);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.promotion,
                R.layout.color_spinner_layout
        );
        adapter4.setDropDownViewResource(R.layout.spinner_dropdown);
        promotion_spinner.setAdapter(adapter4);
        promotion_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                promotion_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                promotion_c = 0;
            }
        });
        Spinner hra_spinner = findViewById(R.id.et_hra);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(
                this,
                R.array.hra,
                R.layout.color_spinner_layout
        );
        adapter5.setDropDownViewResource(R.layout.spinner_dropdown);
        hra_spinner.setAdapter(adapter5);
        hra_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hra_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hra_c = 0;
            }
        });



        Spinner els_spinner = findViewById(R.id.et_els);
        ArrayAdapter adapter8 = ArrayAdapter.createFromResource(
                this,
                R.array.els,
                R.layout.color_spinner_layout
        );
        adapter8.setDropDownViewResource(R.layout.spinner_dropdown);
        els_spinner.setAdapter(adapter8);
        els_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                els_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                els_c = 0;
            }
        });
        Spinner els_dt_spinner = findViewById(R.id.et_els_dt);
        ArrayAdapter adapter9 = ArrayAdapter.createFromResource(
                this,
                R.array.els_dt,
                R.layout.color_spinner_layout
        );
        adapter9.setDropDownViewResource(R.layout.spinner_dropdown);
        els_dt_spinner.setAdapter(adapter9);
        els_dt_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                els_dt_c = i;
                sl_m = adapter9.getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                els_dt_c = 0;
            }
        });
        Spinner cps_spinner = findViewById(R.id.et_cps);
        ArrayAdapter adapter10 = ArrayAdapter.createFromResource(
                this,
                R.array.cps,
                R.layout.color_spinner_layout
        );
        adapter10.setDropDownViewResource(R.layout.spinner_dropdown);
        cps_spinner.setAdapter(adapter10);
        cps_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cps_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                cps_c = 0;
            }
        });
        Spinner da_arrears_spinner = findViewById(R.id.et_da_arrears);
        ArrayAdapter adapter11 = ArrayAdapter.createFromResource(
                this,
                R.array.da_arrears,
                R.layout.color_spinner_layout
        );
        adapter11.setDropDownViewResource(R.layout.spinner_dropdown);
        da_arrears_spinner.setAdapter(adapter11);
        da_arrears_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                da_arrears_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                da_arrears_c = 0;
            }
        });

        Spinner pf_dt_spinner = findViewById(R.id.et_pf_dt);
        ArrayAdapter adapter12 = ArrayAdapter.createFromResource(
                this,
                R.array.pf_dt,
                R.layout.color_spinner_layout
        );
        adapter12.setDropDownViewResource(R.layout.spinner_dropdown);
        pf_dt_spinner.setAdapter(adapter12);
        pf_dt_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pf_dt_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pf_dt_c = 0;
            }
        });
        Spinner tsgli_dt_spinner = findViewById(R.id.et_tsgli_dt);
        ArrayAdapter adapter13 = ArrayAdapter.createFromResource(
                this,
                R.array.tsgli_dt,
                R.layout.color_spinner_layout
        );
        adapter13.setDropDownViewResource(R.layout.spinner_dropdown);
        tsgli_dt_spinner.setAdapter(adapter13);
        tsgli_dt_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tsgli_dt_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tsgli_dt_c = 0;
            }
        });
        Spinner gis_dt_spinner = findViewById(R.id.et_gis_dt);
        ArrayAdapter adapter14 = ArrayAdapter.createFromResource(
                this,
                R.array.gis_dt,
                R.layout.color_spinner_layout
        );
        adapter14.setDropDownViewResource(R.layout.spinner_dropdown);
        gis_dt_spinner.setAdapter(adapter14);
        gis_dt_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gis_dt_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                gis_dt_c = 0;
            }
        });
        Spinner living_spinner = findViewById(R.id.et_living);
        ArrayAdapter adapter15 = ArrayAdapter.createFromResource(
                this,
                R.array.living,
                R.layout.color_spinner_layout
        );
        adapter15.setDropDownViewResource(R.layout.spinner_dropdown);
        living_spinner.setAdapter(adapter15);
        living_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                living_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                living_c = 0;
            }
        });
        Spinner disable_spinner = findViewById(R.id.et_disable);
        ArrayAdapter adapter16 = ArrayAdapter.createFromResource(
                this,
                R.array.disable,
                R.layout.color_spinner_layout
        );
        adapter16.setDropDownViewResource(R.layout.spinner_dropdown);
        disable_spinner.setAdapter(adapter16);
        disable_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                disable_c = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                disable_c = 0;
            }
        });
        et_name_c = findViewById(R.id.et_name);
        et_desing_c = findViewById(R.id.et_design);
        et_place_c = findViewById(R.id.et_place);
        et_mandal_c = findViewById(R.id.et_mandal);
        et_district_c = findViewById(R.id.et_district);
        et_pan_c = findViewById(R.id.et_pan);
        et_mobile_c = findViewById(R.id.et_mobile);
        et_ddoname_c = findViewById(R.id.et_ddoname);
        et_ddodesign_c = findViewById(R.id.et_ddodesign);
        et_ddooffice_c = findViewById(R.id.et_ddooffice);
        et_ddodis_c = findViewById(R.id.et_ddodis);
        et_ddotan_c = findViewById(R.id.et_ddotan);

        et_fpi_c = findViewById(R.id.et_fpi);
        et_sp_pay_c = findViewById(R.id.et_sp_pay);
        et_hm_c = findViewById(R.id.et_hm);
        et_tsincrement_c = findViewById(R.id.et_tsincrement);
        et_fta_c = findViewById(R.id.et_fta);
        et_tution_c = findViewById(R.id.et_tution);
        et_pay1 = findViewById(R.id.et_pay1);
        et_pay2 = findViewById(R.id.et_pay2);
        et_pay3 = findViewById(R.id.et_pay3);
        et_pay4 = findViewById(R.id.et_pay4);
        et_da1 = findViewById(R.id.et_da1);
        et_da2 = findViewById(R.id.et_da2);
        et_da3 = findViewById(R.id.et_da3);
        et_da4 = findViewById(R.id.et_da4);
        et_hra1 = findViewById(R.id.et_hra1);
        et_hra2 = findViewById(R.id.et_hra2);
        et_hra3 = findViewById(R.id.et_hra3);
        et_hra4 = findViewById(R.id.et_hra4);
        et_cca1 = findViewById(R.id.et_cca1);
        et_cca2 = findViewById(R.id.et_cca2);
        et_cca3 = findViewById(R.id.et_cca3);
        et_cca4 = findViewById(R.id.et_cca4);
        et_cps1 = findViewById(R.id.et_cps1);
        et_cps2 = findViewById(R.id.et_cps2);
        et_cps3 = findViewById(R.id.et_cps3);
        et_cps4 = findViewById(R.id.et_cps4);
        et_pf = findViewById(R.id.et_pf);
        et_pf_no = findViewById(R.id.et_pf_no);
        et_tsgli = findViewById(R.id.et_tsgli);
        et_tsgli_no = findViewById(R.id.et_tsgli_no);
        et_gis = findViewById(R.id.et_gis);
        et_gis_no = findViewById(R.id.et_gis_no);
        et_tut_fee = findViewById(R.id.et_tut_fee);
        et_fiveyears = findViewById(R.id.et_fiveyears);
        et_national = findViewById(R.id.et_national);
        et_pli = findViewById(R.id.et_pli);
        et_lic = findViewById(R.id.et_lic);
        et_investment = findViewById(R.id.et_investment);
        et_public_c = findViewById(R.id.et_public_c);
        et_others = findViewById(R.id.et_others);
        et_others_no = findViewById(R.id.et_others_no);
        et_rent = findViewById(R.id.et_rent);
        et_medical_self = findViewById(R.id.et_medical_self);
        et_medical_senior = findViewById(R.id.et_medical_senior);
        et_check = findViewById(R.id.et_check);
        et_loan = findViewById(R.id.et_loan);
        et_mar = findViewById(R.id.et_mar);
        et_apr = findViewById(R.id.et_apr);
        et_may = findViewById(R.id.et_may);
        et_june = findViewById(R.id.et_june);
        et_july = findViewById(R.id.et_july);
        et_aug = findViewById(R.id.et_aug);
        et_sep = findViewById(R.id.et_sep);
        et_oct = findViewById(R.id.et_oct);
        et_nov = findViewById(R.id.et_nov);
        et_dec = findViewById(R.id.et_dec);
        et_jan = findViewById(R.id.et_jan);
        et_feb = findViewById(R.id.et_feb);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_name_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Name of the Employee is empty", Toast.LENGTH_SHORT).show();
                } else {
                    name_c = et_name_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_desing_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Designation is empty", Toast.LENGTH_SHORT).show();
                } else {
                    desing_c = et_desing_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_place_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Place of working is empty", Toast.LENGTH_SHORT).show();
                } else {
                    place_c = et_place_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_mandal_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Mandal is empty", Toast.LENGTH_SHORT).show();
                } else {
                    mandal_c = et_mandal_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_district_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "District is empty", Toast.LENGTH_SHORT).show();
                } else {
                    district_c = et_district_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_pan_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Pan card is empty", Toast.LENGTH_SHORT).show();
                } else {
                    pan_c = et_pan_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_mobile_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Mobile no is empty", Toast.LENGTH_SHORT).show();
                } else {
                    mobile_c = et_mobile_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddoname_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Name of the DDO is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddoname_c = et_ddoname_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddodesign_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "DDO Designation is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddodesign_c = et_ddodesign_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddooffice_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "DDO Office is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddooffice_c = et_ddooffice_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddodis_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "DDO Mandal&District is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddodis_c = et_ddodis_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddotan_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "DDO Tan is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddotan_c = et_ddotan_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_ddooffice_c.getText().toString())) {
                    Toast.makeText(MainActivity.this, "DOO Office is empty", Toast.LENGTH_SHORT).show();
                } else {
                    ddooffice_c = et_ddooffice_c.getText().toString();
                }
                if (TextUtils.isEmpty(et_fpi_c.getText().toString())) {
                    fpi_c = "0";
                    fpi_n = 0;
                } else {
                    fpi_c = et_fpi_c.getText().toString();
                    fpi_n = Integer.parseInt(fpi_c);
                }
                if (TextUtils.isEmpty(et_sp_pay_c.getText().toString())) {
                    sp_pay_c = "0";
                    sp_pay_n = 0;
                } else {
                    sp_pay_c = et_sp_pay_c.getText().toString();
                    sp_pay_n = Integer.parseInt(sp_pay_c);
                }
                if (TextUtils.isEmpty(et_hm_c.getText().toString())) {
                    hm_c = "0";
                    hm_n = 0;
                } else {
                    hm_c = et_hm_c.getText().toString();
                    hm_n = Integer.parseInt(hm_c);

                }
                if (TextUtils.isEmpty(et_tsincrement_c.getText().toString())) {
                    tsincrement_c = "0";
                    tsincrement_n = 0;
                } else {
                    tsincrement_c = et_tsincrement_c.getText().toString();
                    tsincrement_n = Integer.parseInt(tsincrement_c);

                }
                if (TextUtils.isEmpty(et_fta_c.getText().toString())) {
                    fta_c = "0";
                    fta_n = 0;
                } else {
                    fta_c = et_fta_c.getText().toString();
                    fta_n = Integer.parseInt(fta_c);
                }


                if (TextUtils.isEmpty(et_tution_c.getText().toString())) {
                    tution_c = "0";
                    tution_n = 0;
                } else {
                    tution_c = et_tution_c.getText().toString();
                    tution_n = Integer.parseInt(tution_c);
                }
                if (TextUtils.isEmpty(et_pay1.getText().toString())) {
                    pay1 = "0";
                    pay1_n = 0;
                } else {
                    pay1 = et_pay1.getText().toString();
                    pay1_n = Integer.parseInt(pay1);
                }
                if (TextUtils.isEmpty(et_pay2.getText().toString())) {
                    pay2 = "0";
                    pay2_n = 0;
                } else {
                    pay2 = et_pay2.getText().toString();
                    pay2_n = Integer.parseInt(pay2);
                }
                if (TextUtils.isEmpty(et_pay3.getText().toString())) {
                    pay3 = "0";
                    pay3_n = 0;
                } else {
                    pay3 = et_pay3.getText().toString();
                    pay3_n = Integer.parseInt(pay3);
                }
                if (TextUtils.isEmpty(et_pay4.getText().toString())) {
                    pay4 = "0";
                    pay4_n = 0;
                } else {
                    pay4 = et_pay4.getText().toString();
                    pay4_n = Integer.parseInt(pay4);
                }
                if (TextUtils.isEmpty(et_da1.getText().toString())) {
                    da1 = "0";
                    da1_n = 0;
                } else {
                    da1 = et_da1.getText().toString();
                    da1_n = Integer.parseInt(da1);
                }
                if (TextUtils.isEmpty(et_da2.getText().toString())) {
                    da2 = "0";
                    da2_n = 0;
                } else {
                    da2 = et_da2.getText().toString();
                    da2_n = Integer.parseInt(da2);
                }
                if (TextUtils.isEmpty(et_da3.getText().toString())) {
                    da3 = "0";
                    da3_n = 0;
                } else {
                    da3 = et_da3.getText().toString();
                    da3_n = Integer.parseInt(da3);
                }
                if (TextUtils.isEmpty(et_da4.getText().toString())) {
                    da4 = "0";
                    da4_n = 0;
                } else {
                    da4 = et_da4.getText().toString();
                    da4_n = Integer.parseInt(da4);
                }
                if (TextUtils.isEmpty(et_hra1.getText().toString())) {
                    hra1 = "0";
                    hra1_n = 0;
                } else {
                    hra1 = et_hra1.getText().toString();
                    hra1_n = Integer.parseInt(hra1);
                }
                if (TextUtils.isEmpty(et_hra2.getText().toString())) {
                    hra2 = "0";
                    hra2_n = 0;
                } else {
                    hra2 = et_hra2.getText().toString();
                    hra2_n = Integer.parseInt(hra2);
                }
                if (TextUtils.isEmpty(et_hra3.getText().toString())) {
                    hra3 = "0";
                    hra3_n = 0;
                } else {
                    hra3 = et_hra3.getText().toString();
                    hra3_n = Integer.parseInt(hra3);
                }
                if (TextUtils.isEmpty(et_hra4.getText().toString())) {
                    hra4 = "0";
                    hra4_n = 0;
                } else {
                    hra4 = et_hra4.getText().toString();
                    hra4_n = Integer.parseInt(hra4);
                }
                if (TextUtils.isEmpty(et_cca1.getText().toString())) {
                    cca1 = "0";
                    cca1_n = 0;
                } else {
                    cca1 = et_cca1.getText().toString();
                    cca1_n = Integer.parseInt(cca1);
                }
                if (TextUtils.isEmpty(et_cca2.getText().toString())) {
                    cca2 = "0";
                    cca2_n = 0;
                } else {
                    cca2 = et_cca2.getText().toString();
                    cca2_n = Integer.parseInt(cca2);
                }
                if (TextUtils.isEmpty(et_cca3.getText().toString())) {
                    cca3 = "0";
                    cca3_n = 0;
                } else {
                    cca3 = et_cca3.getText().toString();
                    cca3_n = Integer.parseInt(cca3);
                }
                if (TextUtils.isEmpty(et_cca4.getText().toString())) {
                    cca4 = "0";
                    cca4_n = 0;
                } else {
                    cca4 = et_cca4.getText().toString();
                    cca4_n = Integer.parseInt(cca4);
                }
                if (TextUtils.isEmpty(et_cps1.getText().toString())) {
                    cps1 = "0";
                    cps1_n = 0;

                } else {
                    cps1 = et_cps1.getText().toString();
                    cps1_n = Integer.parseInt(cps1);
                }
                if (TextUtils.isEmpty(et_cps2.getText().toString())) {
                    cps2 = "0";
                    cps2_n = 0;
                } else {
                    cps2 = et_cps2.getText().toString();
                    cps2_n = Integer.parseInt(cps2);
                }
                if (TextUtils.isEmpty(et_cps3.getText().toString())) {
                    cps3 = "0";
                    cps3_n = 0;
                } else {
                    cps3 = et_cps3.getText().toString();
                    cps3_n = Integer.parseInt(cps3);
                }
                if (TextUtils.isEmpty(et_cps4.getText().toString())) {
                    cps4 = "0";
                    cps4_n = 0;
                } else {
                    cps4 = et_cps4.getText().toString();
                    cps4_n = Integer.parseInt(cps4);
                }
                if (TextUtils.isEmpty(et_pf.getText().toString())) {
                    pf = "0";
                    pf_n = 0;
                } else {
                    pf = et_pf.getText().toString();
                    pf_n = Integer.parseInt(pf);
                }
                if (TextUtils.isEmpty(et_pf_no.getText().toString())) {
                    pf_no = "0";
                    pf_no_n = 0;
                } else {
                    pf_no = et_pf_no.getText().toString();
                    pf_no_n = Integer.parseInt(pf_no);
                }
                if (TextUtils.isEmpty(et_tsgli.getText().toString())) {
                    tsgli = "0";
                    tsgli_n = 0;
                } else {
                    tsgli = et_tsgli.getText().toString();
                    tsgli_n = Integer.parseInt(tsgli);
                }
                if (TextUtils.isEmpty(et_tsgli_no.getText().toString())) {
                    tsgli_no = "0";
                    tsgli_no_n = 0;
                } else {
                    tsgli_no = et_tsgli_no.getText().toString();
                    tsgli_no_n = Integer.parseInt(tsgli_no);
                }
                if (TextUtils.isEmpty(et_gis.getText().toString())) {
                    gis = "0";
                    gis_n = 0;
                } else {
                    gis = et_gis.getText().toString();
                    gis_n = Integer.parseInt(gis);
                }
                if (TextUtils.isEmpty(et_gis_no.getText().toString())) {
                    gis_no = "0";
                    gis_no_n = 0;
                } else {
                    gis_no = et_gis_no.getText().toString();
                    gis_no_n = Integer.parseInt(gis_no);
                }
                if (TextUtils.isEmpty(et_tut_fee.getText().toString())) {
                    tut_fee = "0";
                    tut_fee_n = 0;
                } else {
                    tut_fee = et_tut_fee.getText().toString();
                    tut_fee_n = Integer.parseInt(tut_fee);
                }
                if (TextUtils.isEmpty(et_fiveyears.getText().toString())) {
                    fiveyears = "0";
                    fiveyears_n = 0;
                } else {
                    fiveyears = et_fiveyears.getText().toString();
                    fiveyears_n = Integer.parseInt(fiveyears);
                }
                if (TextUtils.isEmpty(et_national.getText().toString())) {
                    national = "0";
                    national_n = 0;
                } else {
                    national = et_national.getText().toString();
                    national_n = Integer.parseInt(national);
                }
                if (TextUtils.isEmpty(et_pli.getText().toString())) {
                    pli = "0";
                    pli_n = 0;
                } else {
                    pli = et_pli.getText().toString();
                    pli_n = Integer.parseInt(pli);
                }
                if (TextUtils.isEmpty(et_lic.getText().toString())) {
                    lic = "0";
                    lic_n = 0;
                } else {
                    lic = et_lic.getText().toString();
                    lic_n = Integer.parseInt(lic);
                }
                if (TextUtils.isEmpty(et_investment.getText().toString())) {
                    investment = "0";
                    investment_n = 0;
                } else {
                    investment = et_investment.getText().toString();
                    investment_n = Integer.parseInt(investment);
                }
                if (TextUtils.isEmpty(et_public_c.getText().toString())) {
                    public_c = "0";
                    public_c_n = 0;
                } else {
                    public_c = et_public_c.getText().toString();
                    public_c_n = Integer.parseInt(public_c);
                }
                if (TextUtils.isEmpty(et_others.getText().toString())) {
                    others = "XXX";
                } else {
                    others = et_others.getText().toString();
                }
                if (TextUtils.isEmpty(et_others_no.getText().toString())) {
                    others_no = "0";
                    others_no_n = 0;
                } else {
                    others_no = et_others_no.getText().toString();
                    others_no_n = Integer.parseInt(others_no);
                }
                if (TextUtils.isEmpty(et_rent.getText().toString())) {
                    rent = "0";
                    rent_n = 0;
                } else {
                    rent = et_rent.getText().toString();
                    rent_n = Integer.parseInt(rent);
                }
                if (TextUtils.isEmpty(et_medical_self.getText().toString())) {
                    medical_self = "0";
                    medical_self_n = 0;
                } else {
                    medical_self = et_medical_self.getText().toString();
                    medical_self_n = Integer.parseInt(medical_self);
                }
                if (TextUtils.isEmpty(et_medical_senior.getText().toString())) {
                    medical_senior = "0";
                    medical_senior_n = 0;
                } else {
                    medical_senior = et_medical_senior.getText().toString();
                    medical_senior_n = Integer.parseInt(medical_senior);
                }
                if (TextUtils.isEmpty(et_check.getText().toString())) {
                    check = "0";
                    check_n = 0;
                } else {
                    check = et_check.getText().toString();
                    check_n = Integer.parseInt(check);
                }
                if (TextUtils.isEmpty(et_loan.getText().toString())) {
                    loan = "0";
                    loan_n = 0;
                } else {
                    loan = et_loan.getText().toString();
                    loan_n = Integer.parseInt(loan);
                }
                if (TextUtils.isEmpty(et_mar.getText().toString())) {
                    mar = "0";
                    mar_n = 0;
                } else {
                    mar = et_mar.getText().toString();
                    mar_n = Integer.parseInt(mar);
                }
                if (TextUtils.isEmpty(et_apr.getText().toString())) {
                    apr = "0";
                    apr_n = 0;
                } else {
                    apr = et_apr.getText().toString();
                    apr_n = Integer.parseInt(apr);
                }
                if (TextUtils.isEmpty(et_may.getText().toString())) {
                    may = "0";
                    may_n = 0;
                } else {
                    may = et_may.getText().toString();
                    may_n = Integer.parseInt(may);
                }
                if (TextUtils.isEmpty(et_june.getText().toString())) {
                    june = "0";
                    june_n = 0;
                } else {
                    june = et_june.getText().toString();
                    june_n = Integer.parseInt(june);
                }
                if (TextUtils.isEmpty(et_july.getText().toString())) {
                    july = "0";
                    july_n = 0;
                } else {
                    july = et_july.getText().toString();
                    july_n = Integer.parseInt(july);
                }
                if (TextUtils.isEmpty(et_aug.getText().toString())) {
                    aug = "0";
                    aug_n = 0;
                } else {
                    aug = et_aug.getText().toString();
                    aug_n = Integer.parseInt(aug);
                }
                if (TextUtils.isEmpty(et_sep.getText().toString())) {
                    sep = "0";
                    sep_n = 0;
                } else {
                    sep = et_sep.getText().toString();
                    sep_n = Integer.parseInt(sep);
                }
                if (TextUtils.isEmpty(et_oct.getText().toString())) {
                    oct = "0";
                    oct_n = 0;
                } else {
                    oct = et_oct.getText().toString();
                    oct_n = Integer.parseInt(oct);

                }
                if (TextUtils.isEmpty(et_nov.getText().toString())) {
                    nov = "0";
                    nov_n = 0;
                } else {
                    nov = et_nov.getText().toString();
                    nov_n = Integer.parseInt(nov);
                }
                if (TextUtils.isEmpty(et_dec.getText().toString())) {
                    dec = "0";
                    dec_n = 0;
                } else {
                    dec = et_dec.getText().toString();
                    dec_n = Integer.parseInt(dec);
                }
                if (TextUtils.isEmpty(et_jan.getText().toString())) {
                    jan = "0";
                    jan_n = 0;
                } else {
                    jan = et_jan.getText().toString();
                    jan_n = Integer.parseInt(jan);
                }
                if (TextUtils.isEmpty(et_feb.getText().toString())) {
                    feb = "0";
                    feb_n = 0;
                } else {
                    feb = et_feb.getText().toString();
                    feb_n = Integer.parseInt(feb);
                }
                gross[0][0] = basic_n1;

                if (in_month_c == 11) {
                    for (int i = 0; i < 12; i++) {
                        gross[i][0] = basic_n1;
                    }
                } else if (aas_c == 1) {
                    for (int i = 1; i < in_month_c + 1; i++) {
                        gross[i][0] = basic_n1;
                    }
                    for (int i = in_month_c + 1; i < 12; i++) {
                        gross[i][0] = basic_n3;
                    }
                } else {
                    for (int i = 1; i < in_month_c + 1; i++) {
                        gross[i][0] = basic_n1;
                    }
                    for (int i = in_month_c + 1; i < 12; i++) {
                        gross[i][0] = basic_n3;
                    }
                }


                for (int i = 0; i < 12; i++) {
                    if (hra_c == 0) {
                        gross[i][2] = (gross[i][0] * 11) / 100;
                    } else if (hra_c == 1) {
                        gross[i][2] = (gross[i][0] * 13) / 100;
                    } else if (hra_c == 2) {
                        gross[i][2] = (gross[i][0] * 17) / 100;
                    } else if (hra_c == 3) {
                        gross[i][2] = (gross[i][0] * 24) / 100;
                    } else {
                        gross[i][2] = (gross[i][0] * 0) / 100;
                    }
                }


                for (int i = 0; i < 12; i++) {
                    gross[i][3] = tsincrement_n;
                    gross[i][1] = (int) (gross[i][0] * 0.1729);
                }
                for (int i = 0; i < 12; i++) {
                    gross[i][4] = hm_n;
                }
                for (int i = 0; i < 12; i++) {
                    gross[i][5] = fpi_n + sp_pay_n;
                }
                for (int i = 0; i < 12; i++) {
                    gross[i][10] = fta_n;
                }
                for (int i = 0; i < 12; i++) {
                    if (phc_c == 0) {
                        gross[i][9] = 0;
                    } else {
                        gross[i][9] = 2000;
                    }
                }
                for (int i = 0; i < 12; i++) {
                    gross[i][6] = 0;
                    gross[i][7] = 0;
                    gross[i][8] = 0;
                }


                if (els_c == 1) {
                    sl_leave = (gross[els_dt_c][0] + gross[els_dt_c][1] + gross[els_dt_c][2]) / 2;
                } else if (els_c == 2) {
                    sl_leave = (gross[els_dt_c][0] + gross[els_dt_c][1] + gross[els_dt_c][2]);
                } else {
                    sl_leave = 0;
                }

                if (cps_c == 1) {
                    for (int i = 0; i < 12; i++) {
                        deduct[i][0] = (gross[i][0] * 12) / 100;
                    }
                } else {
                    if (pf_dt_c == 0) {
                        for (int i = 0; i < 12; i++) {
                            deduct[i][0] = pf_n;
                        }
                    } else {
                        deduct[0][0] = pf_n;
                        for (int i = 1; i < 12; i++) {
                            if (i >= pf_dt_c) {
                                deduct[i][0] = pf_no_n;
                            } else {
                                deduct[i][0] = pf_n;
                            }
                        }
                    }
                }


                if (tsgli_dt_c == 0) {
                    for (int i = 0; i < 12; i++) {
                        deduct[i][1] = tsgli_n;
                    }
                } else {
                    deduct[0][1] = tsgli_n;
                    for (int i = 1; i < 12; i++) {
                        if (i >= tsgli_dt_c) {
                            deduct[i][1] = tsgli_no_n;
                        } else {
                            deduct[i][1] = tsgli_n;
                        }
                    }
                }


                if (gis_dt_c == 0) {
                    for (int i = 0; i < 12; i++) {
                        deduct[i][2] = gis_n;
                    }
                } else {
                    deduct[0][2] = gis_n;
                    for (int i = 1; i < 12; i++) {
                        if (i >= gis_dt_c) {
                            deduct[i][2] = gis_no_n;
                        } else {
                            deduct[i][2] = gis_n;
                        }
                    }
                }

                for (int i = 0; i < 12; i++) {
                    deduct[i][3] = 200;
                    deduct[i][5] = 0;
                }
                deduct[0][6] = 20;
                for (int i = 1; i < 10; i++) {
                    if (i == 9) {
                        deduct[i][6] = 100;
                    } else {
                        deduct[i][6] = 0;
                    }

                }
                deduct[0][4] = mar_n;
                deduct[1][4] = apr_n;
                deduct[2][4] = may_n;
                deduct[3][4] = june_n;
                deduct[4][4] = july_n;
                deduct[5][4] = aug_n;
                deduct[6][4] = sep_n;
                deduct[7][4] = oct_n;
                deduct[8][4] = nov_n;
                deduct[9][4] = dec_n;
                deduct[10][4] = jan_n;
                deduct[11][4] = feb_n;
                int sum;
                for (int j = 0; j < 12; j++) {
                    sum = 0;
                    for (int i = 0; i < 11; i++) {
                        sum = sum + gross[j][i];
                    }
                    gross_total[j] = sum;
                }
                sum = 0;

                for (int j = 0; j < 12; j++) {
                    sum = 0;
                    for (int i = 0; i < 7; i++) {
                        sum = sum + deduct[j][i];
                    }
                    deduct_total[j] = sum;
                }
                sum = 0;
                int sum1 = 0;
                int sum2 = 0;


                for (int i = 0; i < 12; i++) {
                    sum = sum + gross[i][0];
                    sum1 = sum1 + gross[i][1];
                    sum2 = sum2 + gross[i][2];

                }
                sum_gross[0] = sum + pay1_n + pay2_n + pay3_n + pay4_n;
                sum_gross[1] = sum + da1_n + da2_n + da3_n + da4_n;
                sum_gross[2] = sum + hra1_n + hra2_n + hra3_n + hra4_n;
                sum_gross[3] = tsincrement_n * 12;
                sum_gross[4] = hm_n * 12;
                sum_gross[5] = (fpi_n + sp_pay_n) * 12;
                sum_gross[6] = 0;
                sum_gross[7] = tution_n + sl_leave;
                sum_gross[8] = cca1_n + cca2_n + cca3_n + cca4_n;
                if (phc_c == 0) {
                    sum_gross[9] = 0;
                } else {
                    sum_gross[9] = 2000 * 12;
                }
                sum_gross[10] = fta_n * 12;
                arr_1 = pay1_n + da1_n + cca1_n + hra1_n;
                arr_2 = pay2_n + da2_n + cca2_n + hra2_n;
                arr_3 = pay3_n + da3_n + cca3_n + hra3_n;
                arr_4 = pay4_n + da4_n + cca4_n + hra4_n;
                sum = 0;
                for (int i = 0; i < 11; i++) {
                    sum = sum + sum_gross[i];
                }
                grand_gross = sum;
                int ded1 = 0;
                int ded2 = 0;
                int ded3 = 0;
                int ded4 = 0;


                for (int i = 0; i < 12; i++) {
                    ded1 = ded1 + deduct[i][0];
                    ded2 = ded2 + deduct[i][1];
                    ded3 = ded3 + deduct[i][2];
                    ded4 = ded4 + deduct[i][4];


                }
                sum_deduct[0] = ded1 + cps1_n + cps2_n + cps3_n + cps4_n;
                sum_deduct[1] = ded2;
                sum_deduct[2] = ded3;
                sum_deduct[4] = ded4;
                sum_deduct[3] = 200 * 12;
                sum_deduct[5] = 0;
                sum_deduct[6] = 120;

                sum = 0;
                for (int i = 0; i < 7; i++) {
                    sum = sum + sum_deduct[i];
                }
                grand_deduct = sum;


                try {
                    createPdf(pay1,pay2,pay3,pay4,da1,da2,da3,da4,hra1,hra2,hra3,hra4,cca1,cca2,cca3,cca4,gross,gross_total,sum_gross,grand_gross,deduct_total,deduct,sum_deduct,grand_deduct,arr_1,arr_2,arr_3,arr_4,sl_leave,tution_n,name_c,desing_c,place_c,cps_c);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }


        });

    }


        private void createPdf(String pay1,String pay2,String pay3,String pay4,String da1,String da2,String da3,String da4,String hra1,String hra2,String hra3,String hra4,String cca1,String cca2,String cca3,String cca4,int[][] gross,int[] gross_total,int[] sum_gross,int grand_gross,int[] deduct_total,int[][] deduct,int[] sum_deduct,int grand_deduct,int arr_1,int arr2,int arr_3,int arr_4,int sl_leave,int tution_n,String name_c,String desing_c,String place_c,int cps_c) throws FileNotFoundException {
            String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
            File file = new File(pdfPath, name_c + " Annexure-I.pdf");
            OutputStream outputStream = new FileOutputStream(file);

            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            pdfDocument.setDefaultPageSize(PageSize.A4.rotate());

            Paragraph paragraph = new Paragraph("Statement showing the Salary particulars of Sri. " + name_c + ", "+ desing_c + ", "+ place_c).setFontSize(12).setBold().setTextAlignment(TextAlignment.CENTER);

            float[] columnWidth = {75,70,56,56,49,41,43,45,46,42,48,53,80,54,52,48,40,55,28,70};
            Table table = new Table(columnWidth);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);


            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Month").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Pay").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("DA").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("HRA").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("TS increment").setFontSize(7)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("HMA").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("FPI+ADD").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("AHRA").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Others").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("CCA").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("PHC").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Conveyance allowance").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Gross total").setFontSize(8)));
            if(cps_c==1){
                table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("CPS").setFontSize(8)));
            }
            else {
                table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("GPF").setFontSize(8)));
            }
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("TSGLI").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("GIS").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("PT").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Income tax").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("SWF,EWF").setFontSize(8)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("Total deductions").setFontSize(7)));


            table.addCell(new Cell().add(new Paragraph("Mar,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[0][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[0])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[0][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("20").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[0])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Apr,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[1][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[1])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[1][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[1])).setFontSize(9)));




            table.addCell(new Cell().add(new Paragraph("May,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[2][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[2])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[2][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[2])).setFontSize(9)));




            table.addCell(new Cell().add(new Paragraph("June,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[3][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[3])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[3][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[3])).setFontSize(9)));




            table.addCell(new Cell().add(new Paragraph("July,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[4][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[4])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[4][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[4])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Aug,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[5][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[5])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[5][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[5])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Sep,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[6][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[6])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[6][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[6])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Oct,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[7][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[7])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[7][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[7])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Nov,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[8][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[8])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[8][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[8])).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Dec,22").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[9][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[9])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[9][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("100").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[9])).setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Jan,23").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[10][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[10])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[10][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[10])).setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Feb,23").setFontSize(9)));
            for(int i=0;i<11;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(gross[11][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph(String.valueOf(gross_total[11])).setFontSize(9)));
            for(int i=0;i<5;i++) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct[11][i])).setFontSize(9)));
            }
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(deduct_total[11])).setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Surrender Leaves" + sl_m).setFontSize(7)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(sl_leave)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(sl_leave)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("RPS-21,Arrears").setFontSize(8)));
            table.addCell(new Cell().add(new Paragraph(pay1).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(da1).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(hra1).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cca1).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(arr_1)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps1).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps1).setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Arrears").setFontSize(8)));
            table.addCell(new Cell().add(new Paragraph(pay2).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(da2).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(hra2).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cca2).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(arr_2)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps2).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps2).setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Arrears").setFontSize(8)));
            table.addCell(new Cell().add(new Paragraph(pay3).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(da3).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(hra3).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cca3).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(arr_3)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps3).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps3).setFontSize(9)));



            table.addCell(new Cell().add(new Paragraph("Arrears").setFontSize(8)));
            table.addCell(new Cell().add(new Paragraph(pay4).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(da4).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(hra4).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cca4).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(arr_4)).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(cps4).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph().setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("DA Arrears").setFontSize(8)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));


            table.addCell(new Cell().add(new Paragraph("Children fee concession").setFontSize(6)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(tution_c).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph(tution_c).setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));
            table.addCell(new Cell().add(new Paragraph("0").setFontSize(9)));

            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("TOTAL").setFontSize(9)));
            for(int i=0;i<11;i++){
                table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph(String.valueOf(sum_gross[i])).setFontSize(9)));
            }
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph(String.valueOf(grand_gross)).setFontSize(9)));
            for(int i=0;i<5;i++){
                table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph(String.valueOf(sum_deduct[i])).setFontSize(9)));
            }
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph("120").setFontSize(9)));
            table.addCell(new Cell().setBackgroundColor(ColorConstants.GRAY).add(new Paragraph(String.valueOf(grand_deduct)).setFontSize(9)));


            Paragraph p = new Paragraph("Signature of DDO").setFontSize(12);
            p.add(new Tab());
            p.addTabStops(new TabStop(1000, TabAlignment.RIGHT));
            p.add("Signature of Employee").setBold();






            document.add(paragraph);
            document.add(table);
            document.add(new Paragraph("\n\n\n"));
            document.add(p);
            document.close();
            Toast.makeText(this, "Pdf Created", Toast.LENGTH_SHORT).show();
        }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}