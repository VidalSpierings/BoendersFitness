package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Vidal on 16-07-16.
 */
public class Openinghours_ActivityActivity extends AppCompatActivity {

    Calendar calendar;
    TextView
            today_top,
            today_middle,
            today_bottom,
            tomorrow_top,
            tomorrow_middle,
            tomorrow_bottom,
            key_textView;
    Button
            button6,
            all_openinghours;

    int
            BoenderBoxtel,
            BoenderMichiel,
            BoenderDames,
            day;

    Intent intent;

    String isSet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.not_key_content);

        today_top = (TextView) findViewById(R.id.today_top);
        today_middle = (TextView) findViewById(R.id.today_middle);
        today_bottom = (TextView) findViewById(R.id.today_bottom);

        tomorrow_top = (TextView) findViewById(R.id.tomorrow_top);
        tomorrow_middle = (TextView) findViewById(R.id.tomorrow_middle);
        tomorrow_bottom = (TextView) findViewById(R.id.tomorrow_bottom);

        key_textView = (TextView) findViewById(R.id.textView2);

        button6 = (Button) findViewById(R.id.button6);
        all_openinghours = (Button) findViewById(R.id.all_openinghours);

        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_WEEK);

        BoenderBoxtel = getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getIntent().getExtras().getInt("BoenderMichiel");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            all_openinghours.setBackgroundColor(Color.parseColor("#FFFFFF"));
            button6.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (BoenderBoxtel == 1) {

            today_bottom.setVisibility(View.INVISIBLE);
            today_top.setVisibility(View.INVISIBLE);
            tomorrow_bottom.setVisibility(View.INVISIBLE);
            tomorrow_top.setVisibility(View.INVISIBLE);

            if (day == Calendar.MONDAY) {

                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

            } else if (day == Calendar.TUESDAY) {

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

            } else if (day == Calendar.WEDNESDAY) {

                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

            } else if (day == Calendar.THURSDAY) {

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

            } else if (day == Calendar.FRIDAY) {

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

            } else if (day == Calendar.SATURDAY) {

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.eight_till_nine_string));
                tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

            } else if (day == Calendar.SUNDAY) {

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.eight_till_nine_string));
                tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

            }

        } else if (BoenderMichiel == 3) {

            today_top.setVisibility(View.VISIBLE);
            today_middle.setVisibility(View.VISIBLE);
            today_bottom.setVisibility(View.VISIBLE);
            tomorrow_middle.setVisibility(View.VISIBLE);
            tomorrow_bottom.setVisibility(View.VISIBLE);
            tomorrow_top.setVisibility(View.VISIBLE);

            button6.setVisibility(View.INVISIBLE);

            key_textView.setVisibility(View.INVISIBLE);

            if (day == Calendar.MONDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setVisibility(View.INVISIBLE);

            }
            if (day == Calendar.TUESDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setVisibility(View.INVISIBLE);

            }
            if (day == Calendar.WEDNESDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setVisibility(View.INVISIBLE);

            }
            if (day == Calendar.THURSDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);
                tomorrow_top.setVisibility(View.INVISIBLE);

            }
            if (day == Calendar.FRIDAY) {

                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);

                tomorrow_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);
            }
            if (day == Calendar.SATURDAY) {

                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);

                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);

            }
            if (day == Calendar.SUNDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);

                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
            }

        } else if (BoenderDames == 2) {

            key_textView.setText(getString(R.string.normal_hours_string));

            if (day == Calendar.MONDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_middle.setText(getString(R.string.half_past_one_till_three_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

            } else if (day == Calendar.TUESDAY) {
                today_top.setText(getString(R.string.nine_till_eleven_string));
                today_middle.setText(getString(R.string.half_past_one_till_three_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

            } else if (day == Calendar.WEDNESDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_middle.setText(getString(R.string.half_past_one_till_three_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

            } else if (day == Calendar.THURSDAY) {
                today_top.setText(getString(R.string.nine_till_eleven_string));
                today_middle.setText(getString(R.string.half_past_one_till_three_string));
                today_bottom.setText(getString(R.string.six_till_ten_string));
                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);

            } else if (day == Calendar.FRIDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);
                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);

            } else if (day == Calendar.SATURDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);
                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setVisibility(View.INVISIBLE);

            } else if (day == Calendar.SUNDAY) {
                today_top.setVisibility(View.INVISIBLE);
                today_middle.setText(getString(R.string.nine_till_eleven_string));
                today_bottom.setVisibility(View.INVISIBLE);
                tomorrow_top.setVisibility(View.INVISIBLE);
                tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

            }

        }

        all_openinghours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (BoenderBoxtel == 1) {
                    intent = new Intent(Openinghours_ActivityActivity.this, AllOpeningHoursActivity.class);
                }

                if (BoenderDames == 2) {
                    intent = new Intent(Openinghours_ActivityActivity.this, AllOpeningHoursDamesActivity.class);
                }

                if (BoenderMichiel == 3) {
                    intent = new Intent(Openinghours_ActivityActivity.this, AllOpeningHoursMichielActivity.class);
                }

                startActivity(intent);
            }
        });

        isSet1 = "sample";

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isSet1.equals("sample")) {

                    key_textView.setText(getString(R.string.not_key_string));

                    today_top.setVisibility(View.VISIBLE);
                    today_middle.setVisibility(View.VISIBLE);
                    today_bottom.setVisibility(View.VISIBLE);
                    tomorrow_top.setVisibility(View.VISIBLE);
                    tomorrow_middle.setVisibility(View.VISIBLE);
                    tomorrow_bottom.setVisibility(View.VISIBLE);

                    isSet1 = "notsample";


                    if (BoenderBoxtel == 1) {

                        key_textView.setText(getString(R.string.not_key_string));

                        if (day == Calendar.MONDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.quarter_past_six_till_eight_string));

                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.TUESDAY) {

                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.WEDNESDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.quarter_past_six_till_eight_string));
                            today_top.setVisibility(View.INVISIBLE);

                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.THURSDAY) {

                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.FRIDAY) {

                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.SATURDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);


                        } else if (day == Calendar.SUNDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.quarter_past_six_till_eight_string));
                        }
                    } else if (BoenderDames == 2) {

                        key_textView.setText(getString(R.string.peak_hours_string));

                        if (day == Calendar.MONDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.half_past_one_till_three_string));
                            tomorrow_bottom.setText(getString(R.string.quarter_past_six_till_eight_string));

                        } else if (day == Calendar.TUESDAY) {
                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.half_past_one_till_three_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

                        } else if (day == Calendar.WEDNESDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.half_past_one_till_three_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

                        } else if (day == Calendar.THURSDAY) {
                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.half_past_one_till_three_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);

                        } else if (day == Calendar.FRIDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);
                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);

                        } else if (day == Calendar.SATURDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);
                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);

                        } else if (day == Calendar.SUNDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);
                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));

                        }
                    } else if (BoenderMichiel == 3) {

                        today_top.setVisibility(View.VISIBLE);
                        today_middle.setVisibility(View.VISIBLE);
                        today_bottom.setVisibility(View.VISIBLE);
                        tomorrow_middle.setVisibility(View.VISIBLE);
                        tomorrow_bottom.setVisibility(View.VISIBLE);
                        tomorrow_top.setVisibility(View.VISIBLE);

                        button6.setVisibility(View.INVISIBLE);

                        key_textView.setVisibility(View.INVISIBLE);

                        if (day == Calendar.MONDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setVisibility(View.INVISIBLE);

                        }
                        if (day == Calendar.TUESDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setVisibility(View.INVISIBLE);

                        }
                        if (day == Calendar.WEDNESDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_top.setVisibility(View.INVISIBLE);

                        }
                        if (day == Calendar.THURSDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setText(getString(R.string.six_till_ten_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);
                            tomorrow_top.setVisibility(View.INVISIBLE);

                        }
                        if (day == Calendar.FRIDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);
                        }
                        if (day == Calendar.SATURDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setVisibility(View.INVISIBLE);

                        }
                        if (day == Calendar.SUNDAY) {
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            today_bottom.setVisibility(View.INVISIBLE);

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.six_till_ten_string));
                        }

                    }
                } else {

                    today_bottom.setVisibility(View.INVISIBLE);
                    today_top.setVisibility(View.INVISIBLE);
                    tomorrow_bottom.setVisibility(View.INVISIBLE);
                    tomorrow_top.setVisibility(View.INVISIBLE);

                    isSet1 = "sample";

                    if (BoenderBoxtel == 1) {

                        key_textView.setText(getString(R.string.key_string));

                        if (day == Calendar.MONDAY) {
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.TUESDAY) {
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.WEDNESDAY) {
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.THURSDAY) {
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.FRIDAY) {
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

                        } else if (day == Calendar.SATURDAY) {
                            today_middle.setText(getString(R.string.eight_till_nine_string));
                            tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

                        } else if (day == Calendar.SUNDAY) {
                            today_middle.setText(getString(R.string.eight_till_nine_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        }
                    } else if (BoenderDames == 2) {

                        key_textView.setText(getString(R.string.normal_hours_string));

                        if (day == Calendar.MONDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.half_past_one_till_three_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        } else if (day == Calendar.TUESDAY) {

                            today_bottom.setText(getString(R.string.half_past_one_till_three_string));
                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));


                        } else if (day == Calendar.WEDNESDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_bottom.setText(getString(R.string.half_past_one_till_three_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        } else if (day == Calendar.THURSDAY) {

                            today_top.setText(getString(R.string.nine_till_eleven_string));
                            today_middle.setText(getString(R.string.half_past_one_till_three_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        } else if (day == Calendar.FRIDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        } else if (day == Calendar.SATURDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        } else if (day == Calendar.SUNDAY) {

                            today_middle.setText(getString(R.string.nine_till_eleven_string));
                            tomorrow_middle.setText(getString(R.string.nine_till_eleven_string));

                        }
                    } else if (BoenderMichiel == 3) {

                        key_textView.setText(getString(R.string.key_string));

                        today_bottom.setVisibility(View.INVISIBLE);
                        today_top.setVisibility(View.INVISIBLE);
                        tomorrow_bottom.setVisibility(View.INVISIBLE);
                        tomorrow_top.setVisibility(View.INVISIBLE);

                        if (day == Calendar.MONDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.TUESDAY) {

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.WEDNESDAY) {

                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.THURSDAY) {

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        } else if (day == Calendar.FRIDAY) {

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));
                            tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

                        } else if (day == Calendar.SATURDAY) {

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.eight_till_nine_string));
                            tomorrow_middle.setText(getString(R.string.eight_till_nine_string));

                        } else if (day == Calendar.SUNDAY) {

                            tomorrow_top.setVisibility(View.INVISIBLE);
                            today_top.setVisibility(View.INVISIBLE);
                            today_middle.setText(getString(R.string.eight_till_nine_string));
                            tomorrow_middle.setText(getString(R.string.seven_till_thirty_past_ten_string));

                        }
                    }
                }
            }

        });



    }
    @Override
    public void onStart() {

        button6.performClick();

        super.onStart();
    }
}
