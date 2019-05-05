package pindah.dicoding.biodata;

/*28-April-2019
    10116396
        Rizki Muhamad Fauzi
            AKB-9*/

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileFragment extends Fragment implements OnMapReadyCallback {

    MaterialDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView txtphone = (TextView) view.findViewById(R.id.txtPhone);
        TextView txtig = (TextView) view.findViewById(R.id.txtInstagram);
        TextView txtemail = (TextView) view.findViewById(R.id.txtEmail);
        TextView txtfb = (TextView) view.findViewById(R.id.txtFacebook);

        txtemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:rizkinabil.999@email.unikom.ac.id"));
                startActivity(intent);
            }
        });

        txtfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/rizki.nabil.77"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rizki.nabil.77")));
                }
            }
        });

        txtig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/rzbill_");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/rzbill_")));
                }
            }
        });

        txtphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:082237542800"));
                startActivity(intent);
            }
        });

        LinearLayout line = (LinearLayout) view.findViewById(R.id.linear);

        line.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialog = new MaterialDialog.Builder(getActivity())
                        .title("Information")
                        .content("Rizki Nabil Design Application v2.0 alfa")
                        .positiveText("Oke")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            }
                        })
                        .cancelable(false)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColorRes(R.color.colorBlack)
                        .backgroundColorRes(R.color.colorWhite)
                        .positiveColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();

            }
        });

        SupportMapFragment mMapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();
        mMapFragment.getMapAsync(this);

        return view;

    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng nabil = new LatLng(-6.8893112, 107.6160011);
        googleMap.addMarker(new MarkerOptions()
                .position(nabil)
                .title("Tempat "));
        googleMap.setMinZoomPreference(6.0f);
        googleMap.setMaxZoomPreference(14.0f);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(nabil));
    }
}