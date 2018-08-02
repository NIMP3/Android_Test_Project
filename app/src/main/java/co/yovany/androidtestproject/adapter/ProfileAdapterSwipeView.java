package co.yovany.androidtestproject.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.squareup.picasso.Picasso;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Profile;
import de.hdodenhof.circleimageview.CircleImageView;

@Layout(R.layout.cardview_tinder)

public class ProfileAdapterSwipeView {

    @View(R.id.profileImageView)
    private ImageView civPictureProfile;
    @View(R.id.nameAgeTxt)
    private TextView tvNameProfile;
    @View(R.id.locationNameTxt)
    private TextView tvIdProfile;

    private Profile profile;
    private Context context;
    private SwipePlaceHolderView swipeView;

    public ProfileAdapterSwipeView(Profile profile, Context context, SwipePlaceHolderView swipeView) {
        this.profile = profile;
        this.context = context;
        this.swipeView = swipeView;
    }

    @Resolve
    private void onResolve() {
        Picasso.get().load(profile.getImageUrl()).into(civPictureProfile);

        tvNameProfile.setText(profile.getName());
        tvIdProfile.setText(profile.getId());
    }

    @SwipeOut
    private void onSwipeOut() { swipeView.addView(this); }

    @SwipeCancelState
    private void onSwipeCancelState() {}

    @SwipeIn
    private void onSwipeIn() {}

    @SwipeInState
    private void onSwipeInState() {}

    @SwipeOutState
    private void onSwipeOutState() {}
}
