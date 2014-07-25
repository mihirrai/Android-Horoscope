package com.example.horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mihir on 7/1/2014.
 */
public class Aries extends Activity {
    TextView tv,tv1,tv2;
    ImageView iv;
    Boolean connected;
    private String finalUrl="http://feeds.feedburner.com/AstroSageAries?format=xml";
    private HandleXML obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        init();
        tv.setText(R.string.Aries);
        iv.setBackgroundResource(R.drawable.aries);
        fetch();
    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        iv=(ImageView)findViewById(R.id.imageView);
    }

    public void fetch(){
        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        tv1.setText(obj.getTitle());
        tv2.setText(obj.getDescription());
    }
}
