package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.activity.MainActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.Context.LOCATION_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    LatLng latLng;
    GoogleMap mMap;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        givePermission();

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getCurrentLocation();

//
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                double addressLat = latLng.latitude;
//                double addressLong = latLng.longitude;
//                Bundle bundle = new Bundle();
//                bundle.putDouble("latitude", addressLat);
//                bundle.putDouble("longtitude", addressLong);
//                DonationRequestFragment donationRequestFragment = new DonationRequestFragment();
//                donationRequestFragment.setArguments(bundle);
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container, donationRequestFragment);
////                Intent sendlocation=new Intent(getActivity().getBaseContext(), MainActivity.class);
////                sendlocation.putExtra("address",latLng);
//
//            }
//        });

        return view;
    }

    private void getCurrentLocation() {
        LocationManager mngr = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        LocationProvider provider = mngr.getProvider(LocationManager.GPS_PROVIDER);
        String providername = provider.getName();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        mngr.requestLocationUpdates(providername, 100, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                latLng = new LatLng(lat, lng);
                setMarkerOnMap(latLng);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });

    }

    private void setMarkerOnMap(LatLng latLng) {
        this.latLng = latLng;
        mMap.addMarker(new MarkerOptions().position(latLng).title("My location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15f);
        mMap.animateCamera(cameraUpdate);
    }

    private void givePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 10);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length > 0) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 10);
                }


            }
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        latLng = new LatLng(31.0402553, 31.3615603);
    }
}
