package co.yovany.androidtestproject.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

@Layout(R.layout.cardview_tinder)

public class ProfileAdapterSwipeView {

    @View(R.id.profileImageView)
    private ImageView civPictureProfile;
    @View(R.id.nameAgeTxt)
    private TextView tvNameProfile;
    @View(R.id.locationNameTxt)
    private TextView tvIdProfile;
    @View(R.id.tvStatusProfile)
    private TextView tvStatusProfile;
    @View(R.id.cbAssistanceProfile)
    private CheckBox cbAssistanceProfile;


    private Profile profile;
    private Activity activity;
    private SwipePlaceHolderView swipeView;

    public ProfileAdapterSwipeView(Profile profile, Activity activity, SwipePlaceHolderView swipeView) {
        this.profile = profile;
        this.activity = activity;
        this.swipeView = swipeView;
    }

    @Resolve
    private void onResolve() {
        Log.e("PROFILE",profile.getName());
        Picasso.get().load(profile.getImageUrl()).into(civPictureProfile);

        tvNameProfile.setText(profile.getName());
        tvIdProfile.setText(profile.getId());
        switch (profile.getStatus()) {
            case 0:
                tvStatusProfile.setText("ASISTIÓ");
                cbAssistanceProfile.setChecked(false);
                break;
            case 1:
                tvStatusProfile.setText("NO ASISTIÓ - CON EXCUSA");
                cbAssistanceProfile.setChecked(true);
                break;
            case 2:
                tvStatusProfile.setText("NO ASISTIÓ");
                cbAssistanceProfile.setChecked(true);
                break;
        }

        cbAssistanceProfile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int status = profile.getStatus();
                switch (status) {
                    case 2:
                        profile.setStatus(0);
                        tvStatusProfile.setText("ASISTIÓ");
                        break;
                    case 1:
                        profile.setStatus(0);
                        tvStatusProfile.setText("ASISTIÓ");
                        break;
                    case 0:
                        new AlertDialog.Builder(activity)
                                .setTitle("Asistencia")
                                .setMessage("¿El estudiante tiene excusa?")
                                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        tvStatusProfile.setText("NO ASISTIÓ - CON EXCUSA");
                                        profile.setStatus(1);

                                        dialogInterface.dismiss();
                                    }
                                })
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        tvStatusProfile.setText("NO ASISTIÓ");
                                        profile.setStatus(2);

                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();

                        break;
                }
            }
        });
    }

    @SwipeOut
    private void onSwipeOut() { swipeView.addView(this); }

    @SwipeCancelState
    private void onSwipeCancelState() {}

    @SwipeIn
    private void onSwipeIn() { swipeView.addView(this); }

    @SwipeInState
    private void onSwipeInState() {}

    @SwipeOutState
    private void onSwipeOutState() {}
}
