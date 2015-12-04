package lab.fun.oswiki.softinputmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import lab.fun.oswiki.R;

public class InputModeSimpleTest extends Activity {
    private static final String SOFT_INPUT_MODE_KEY = "soft_input_mode_key";
    private static final String SOFT_INPUT_MODE_NAME_KEY = "soft_input_mode_name_key";

    private int softInputMode = -1;
    private String softInputModeName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        setContentView(R.layout.activity_input_mode_simple_test);


//        View decorView = getWindow().getDecorView();
//        // Hide the status bar.
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                | View.SYSTEM_UI_FLAG_IMMERSIVE);

//        hideStatusBar();
        getParameter();
        toggleFullScreen(true);
//        if (softInputMode == -1) {
//            finish();
//            return;
//        }

//        getWindow().setSoftInputMode(softInputMode);
        TextView targetView = (TextView) findViewById(R.id.txt_mode_name);
        targetView.setText(softInputModeName);
        targetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFullScreen(false);
            }
        });

        ((EditText) findViewById(R.id.edit_target)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                }

                return false;
            }
        });
        (findViewById(R.id.edit_target)).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

    }

    private void getParameter() {
        final Intent launchIntent = getIntent();
        if (launchIntent == null) {
            return;
        }

        final Bundle launchBundle = launchIntent.getExtras();
        if (launchBundle == null) {
            return;
        }

        softInputMode = launchBundle.getInt(SOFT_INPUT_MODE_KEY, -1);
        softInputModeName = launchBundle.getString(SOFT_INPUT_MODE_NAME_KEY, "");

//        mEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);

    }

    public static Bundle createParameter(final int softInputMode, final String softInputModeName) {
        if (softInputMode == -1) {
            return null;
        }

        final Bundle parameter = new Bundle();
        parameter.putInt(SOFT_INPUT_MODE_KEY, softInputMode);
        parameter.putString(SOFT_INPUT_MODE_NAME_KEY, softInputModeName);

        return parameter;

    }

    private void toggleFullScreen(boolean fullScreenOn) {
        if (fullScreenOn) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
