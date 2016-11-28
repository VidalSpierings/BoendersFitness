package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by Vidal on 10-05-16.
 */
public class NotKeyFragment extends android.support.v4.app.Fragment {

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

    String isSet1;
    TextView stateName;
    String sstateName;

    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.not_key_content, container, false);

        today_top = (TextView) rootView.findViewById(R.id.today_top);
        today_middle = (TextView) rootView.findViewById(R.id.today_middle);
        today_bottom = (TextView) rootView.findViewById(R.id.today_bottom);

        tomorrow_top = (TextView) rootView.findViewById(R.id.tomorrow_top);
        tomorrow_middle = (TextView) rootView.findViewById(R.id.tomorrow_middle);
        tomorrow_bottom = (TextView) rootView.findViewById(R.id.tomorrow_bottom);

        stateName = (TextView) rootView.findViewById(R.id.textView2);
        sstateName = stateName.toString();


        key_textView = (TextView) rootView.findViewById(R.id.textView2);

        button6 = (Button) rootView.findViewById(R.id.button6);
        all_openinghours = (Button) rootView.findViewById(R.id.all_openinghours);

        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_WEEK);

        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP){
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

        }
        else if (BoenderMichiel == 3) {

            today_top.setVisibility(View.INVISIBLE);
            tomorrow_top.setVisibility(View.INVISIBLE);

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

        }

        else if (BoenderDames == 2) {

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

                if (BoenderBoxtel == 1){
                    intent = new Intent(getActivity(), AllOpeningHoursActivity.class);
                }

                if (BoenderDames == 2){
                    intent = new Intent(getActivity(), AllOpeningHoursDamesActivity.class);
                }

                if (BoenderMichiel == 3){
                    intent = new Intent(getActivity(), AllOpeningHoursMichielActivity.class);
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

                                else if (BoenderDames == 2) {

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

                                else if (BoenderMichiel == 3) {

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
                            }else {

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

        return rootView;
    }

    @Override
    public void onStart() {

        button6.performClick();

        super.onStart();
    }
}
