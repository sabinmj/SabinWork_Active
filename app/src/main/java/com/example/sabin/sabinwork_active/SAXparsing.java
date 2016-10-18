package com.example.sabin.sabinwork_active;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXparsing extends AppCompatActivity {
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saxparsing);

        tv=(TextView)findViewById(R.id.textView1);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                boolean salary = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("salary")) {
                        salary = true;
                    }
                }
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                }
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (name) {
                        tv.setText(tv.getText()+"\n\n Name : " + new String(ch, start, length));
                        name = false;
                    }
                    if (salary) {
                        tv.setText(tv.getText()+"\n Salary : " + new String(ch, start, length));
                        salary = false;
                    }
                }//end of characters
            };//end of DefaultHandler

            InputStream is = getAssets().open("file.xml");
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(),"error "+e,Toast.LENGTH_SHORT).show();

        }
    }

}
