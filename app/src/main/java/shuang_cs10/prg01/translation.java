package shuang_cs10.prg01;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class translation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        // set English phrases adapter
        final ArrayAdapter<CharSequence> english_adapter = ArrayAdapter.createFromResource(this,
                R.array.english_phrases, android.R.layout.simple_spinner_item);
        english_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // set Spanish phrases adapter
        final ArrayAdapter<CharSequence> spanish_adapter = ArrayAdapter.createFromResource(this,
                R.array.spanish_phrases, android.R.layout.simple_spinner_item);
        spanish_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // set French phrases adapter
        final ArrayAdapter<CharSequence> french_adapter = ArrayAdapter.createFromResource(this,
                R.array.french_phrases, android.R.layout.simple_spinner_item);
        french_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // set German phrases adapter
        final ArrayAdapter<CharSequence> german_adapter = ArrayAdapter.createFromResource(this,
                R.array.german_phrases, android.R.layout.simple_spinner_item);
        german_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // set Mandarin phrases adapter
        final ArrayAdapter<CharSequence> mandarin_adapter = ArrayAdapter.createFromResource(this,
                R.array.mandarin_phrases, android.R.layout.simple_spinner_item);
        mandarin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // set Korean phrases adapter
        final ArrayAdapter<CharSequence> korean_adapter = ArrayAdapter.createFromResource(this,
                R.array.korean_phrases, android.R.layout.simple_spinner_item);
        korean_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // initially set spinner to English
        final Spinner text_from = (Spinner) findViewById(R.id.text_from);





        // set languages adapter
        ArrayAdapter<CharSequence> lang_adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        lang_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // set FROM LANGUAGE drop-down and listener
        Spinner language_from = (Spinner) findViewById(R.id.language_from);
        language_from.setAdapter(lang_adapter);
        language_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                if (pos == 0) {
                    text_from.setAdapter(english_adapter);
                } else if (pos == 1) {
                    text_from.setAdapter(spanish_adapter);
                } else if (pos == 2) {
                    text_from.setAdapter(french_adapter);
                } else if (pos == 3) {
                    text_from.setAdapter(german_adapter);
                } else if (pos == 4) {
                    text_from.setAdapter(mandarin_adapter);
                } else if (pos == 5) {
                    text_from.setAdapter(korean_adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });



        // set TO LANGUAGE drop-down and listener
        final Spinner language_to = (Spinner) findViewById(R.id.language_to);
        language_to.setAdapter(lang_adapter);





        // find ID of translated text box
        final TextView translation = (TextView) findViewById(R.id.text_to);

        // adding BUTTON logic and listener
        Button submit = (Button) findViewById(R.id.translate);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int lang = language_to.getSelectedItemPosition();
                int phrase = text_from.getSelectedItemPosition();

                if (lang == 0) {
                    String[] display_lang = getResources().getStringArray(R.array.english_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                } else if (lang == 1) {
                    String[] display_lang = getResources().getStringArray(R.array.spanish_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                } else if (lang == 2) {
                    String[] display_lang = getResources().getStringArray(R.array.french_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                } else if (lang == 3) {
                    String[] display_lang = getResources().getStringArray(R.array.german_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                } else if (lang == 4) {
                    String[] display_lang = getResources().getStringArray(R.array.mandarin_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                } else if (lang == 5) {
                    String[] display_lang = getResources().getStringArray(R.array.korean_phrases);
                    String translated = display_lang[phrase];
                    translation.setText(translated);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_translation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
