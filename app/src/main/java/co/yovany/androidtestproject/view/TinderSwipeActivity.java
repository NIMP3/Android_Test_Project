package co.yovany.androidtestproject.view;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.adapter.ProfileAdapterSwipeView;
import co.yovany.androidtestproject.model.Profile;
import co.yovany.androidtestproject.model.Utils;

public class TinderSwipeActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_swipe);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f));


        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new ProfileAdapterSwipeView(profile, this, mSwipeView));
        }
    }
}
