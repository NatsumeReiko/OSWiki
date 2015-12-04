package lab.fun.oswiki.softinputmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.HashMap;

public class InputModeSimpleShowCase extends Activity {

    //    One of the visibility states SOFT_INPUT_STATE_UNSPECIFIED, SOFT_INPUT_STATE_UNCHANGED, SOFT_INPUT_STATE_HIDDEN, SOFT_INPUT_STATE_ALWAYS_VISIBLE, or SOFT_INPUT_STATE_VISIBLE.
//    One of the adjustment options SOFT_INPUT_ADJUST_UNSPECIFIED, SOFT_INPUT_ADJUST_RESIZE, or SOFT_INPUT_ADJUST_PAN.
    HashMap<String, Integer> keyValue = new HashMap<>();

    final String[] listStringKey = new String[]{
            "SOFT_INPUT_STATE_UNSPECIFIED",
            "SOFT_INPUT_STATE_UNCHANGED",
            "SOFT_INPUT_STATE_HIDDEN",
            "SOFT_INPUT_STATE_ALWAYS_VISIBLE",
            "SOFT_INPUT_STATE_VISIBLE",
            "SOFT_INPUT_ADJUST_UNSPECIFIED",
            "SOFT_INPUT_ADJUST_RESIZE",
            "SOFT_INPUT_ADJUST_PAN"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        makeDate();

        ListView list = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listStringKey);

        list.setAdapter(adapter);
        setContentView(list);

        FrameLayout frame = new FrameLayout(this);

//        frame.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        addContentView(frame, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                handlerItem(position);
            }

        });
    }

    private void makeDate() {
        keyValue.put("SOFT_INPUT_STATE_UNSPECIFIED", WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED);
        keyValue.put("SOFT_INPUT_STATE_UNCHANGED", WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        keyValue.put("SOFT_INPUT_STATE_HIDDEN", WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        keyValue.put("SOFT_INPUT_STATE_ALWAYS_VISIBLE", WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        keyValue.put("SOFT_INPUT_STATE_VISIBLE", WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        keyValue.put("SOFT_INPUT_ADJUST_UNSPECIFIED", WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED);
        keyValue.put("SOFT_INPUT_ADJUST_RESIZE", WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        keyValue.put("SOFT_INPUT_ADJUST_PAN", WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void handlerItem(final int position) {
        final String name = listStringKey[position];
        final int value = keyValue.get(name);

        final Intent launchIntent = new Intent(this, InputModeSimpleTest.class);
        launchIntent.putExtras(InputModeSimpleTest.createParameter(value, name));
        startActivity(launchIntent);


    }


}
